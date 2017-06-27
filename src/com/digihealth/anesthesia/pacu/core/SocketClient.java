package com.digihealth.anesthesia.pacu.core;

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.DelimiterBasedFrameDecoder;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.handler.timeout.IdleStateHandler;
import io.netty.handler.timeout.ReadTimeoutException;
import io.netty.handler.timeout.WriteTimeoutException;
import io.netty.util.CharsetUtil;

import java.net.InetSocketAddress;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;

import net.sf.json.JSONObject;


/**
 * 基于Netty框架实现Socket客户端，与采集服务完成数据同步 simple introduction
     * Title: SocketClient.java    
     * Description: 
     * @author chenyong       
     * @created 2016年7月15日 下午2:18:21
 */
public class SocketClient {
    private volatile EventLoopGroup workerGroup;

    private volatile Bootstrap bootstrap;

    private volatile static ChannelFuture future;

    //private volatile boolean connected = false;
    
    private volatile int connected = -1; //1/成功，0/正在重连，-1/失败

    private final String remoteHost;

    private final int remotePort;

    protected static final Logger logger = Logger.getLogger(SocketClient.class);

//    public boolean isConnected() {
//        return connected;
//    }
//
//    public void setConnected(boolean connected) {
//        this.connected = connected;
//    }
    
    public int getConnected() {
		return connected;
	}

	public void setConnected(int connected) {
		this.connected = connected;
	}

    public SocketClient(String remoteHost, int remotePort) {
        this.remoteHost = remoteHost;
        this.remotePort = remotePort;
    }

    

	private String getServerInfo() {
        return String.format("RemoteHost=%s RemotePort=%d", remoteHost,
                remotePort);
    }

    public boolean init() {
        workerGroup = new NioEventLoopGroup();
        bootstrap = new Bootstrap();
        bootstrap.group(workerGroup);
        bootstrap.channel(NioSocketChannel.class);
        bootstrap.option(ChannelOption.SO_KEEPALIVE, true);
        bootstrap.option(ChannelOption.CONNECT_TIMEOUT_MILLIS, 5000);
        bootstrap.handler(new ChannelInitializer<Channel>() {
            @Override
            public void initChannel(Channel ch) throws Exception {
                ChannelPipeline pipeline = ch.pipeline();
                ByteBuf delimiter = Unpooled.copiedBuffer(new byte[] { 0x0D });// {0x0D});//{0x1C,0x0D});
                pipeline.addLast(new DelimiterBasedFrameDecoder(1024 * 128, delimiter));
                pipeline.addLast("decoder", new StringDecoder( CharsetUtil.ISO_8859_1));
                pipeline.addLast("encoder", new StringEncoder( CharsetUtil.ISO_8859_1));
                pipeline.addLast("timeout", new IdleStateHandler(60, 60, 60));
                // pipeline.addLast("hearbeat", new HeartbeatClient());
                SocketClientHandler socketClientHandler = new SocketClientHandler();
                pipeline.addLast("handler", socketClientHandler);
                pipeline.addFirst(new ChannelInboundHandlerAdapter() {
                    @Override
                    public void channelInactive(ChannelHandlerContext ctx)
                            throws Exception {
                    	// 进入channelInactive,将connected置为false 
                    	connected = -1;
                        logger.info("init------channelInactive，不处理");
                        super.channelInactive(ctx);
//                        ctx.channel().eventLoop().schedule(new Runnable() {
//                            public void run() {
//                                try {
                                    logger.info("run------channelInactive");
                                    doConnect();
//                                } catch (Exception e) {
//                                    e.printStackTrace();
//                                    logger.error(e);
//                                }
//                            }
//                        }, 10, TimeUnit.SECONDS);
                    }

                    @Override
                    public void exceptionCaught(ChannelHandlerContext ctx,
                            Throwable cause) {
                        // 对读取超时异常进行判断
                        if (cause instanceof ReadTimeoutException) {
                            JSONObject json = new JSONObject();
                            json.put("msgType", MyConstants.DEFAULT_HEART_BEAT);
                            ctx.channel().writeAndFlush(json.toString() + MyConstants.END);
                        } else if (cause instanceof WriteTimeoutException) {
                            JSONObject json = new JSONObject();
                            json.put("msgType", MyConstants.DEFAULT_HEART_BEAT);
                            ctx.channel().writeAndFlush(json.toString() + MyConstants.END);
                        } else {
                            /*connected = false;
                            ctx.channel().eventLoop().schedule(new Runnable() {
                                public void run() {
                                    try {
                                        if (!connected) {
                                            logger.error("exceptionCaught------尝试Socket重连");
                                            doConnect();
                                        }
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                        logger.error(e);
                                    }
                                }
                            }, 10, TimeUnit.SECONDS);*/
                        }

                    }
                });
            }
        });

        doConnect();
        return true;
    }

    private void doConnect() {
        if (connected==1) {
            logger.info("doConnect------Tcp Client连接已经成功 " + getServerInfo());
            return;
        }
        
        logger.info("doConnect------尝试建立Tcp Client连接：" + getServerInfo());

        future = bootstrap.connect(new InetSocketAddress(remoteHost, remotePort));

        future.addListener(new ChannelFutureListener() {
            public void operationComplete(ChannelFuture f) throws Exception {
                if (f.isSuccess()) {
                    connected = 1;
                    logger.info("doConnect------建立Tcp Client连接成功: "
                            + future.channel().localAddress());
                } else {
                    //connected = false;
                    logger.error("doConnect------建立Tcp Client连接失败： "
                            + getServerInfo());
                    f.channel().eventLoop().schedule(new Runnable() {
                        // @Override
                        public void run() {
                            try {
                                //if (connected !=1) {
                                logger.error("doConnect------重试Tcp Client连接: " + getServerInfo());
                                future.channel().close();
                                connected = 0;
                                doConnect();
                                //}
                            } catch (Exception e) {
                                e.printStackTrace();
                                logger.error(e);
                            }
                        }
                    }, 10, TimeUnit.SECONDS);
                }
            }
        });
    }

    public void close() {
        connected = -1;
        workerGroup.shutdownGracefully();
        logger.info("close------Stopped Tcp Client Successed: "
                + getServerInfo());
    }

    public boolean sendMsg(String msg) {
        logger.info("sendMsg------Msg: " + msg);
        try {
            if (connected == -1) {
                logger.error("sendMsg------Socket消息发送失败，连接尚未建立 ");
                return false;
            }
            String END = new String(new byte[] { 0x0D });
            msg = msg + END;
            future.channel().writeAndFlush(msg).sync();
            return true;
        } catch (Exception e) {
            logger.error("sendMsg------Socket消息发送失败： " + e + " Msg：" + msg);
            connected = -1;
//            doConnect();
//            try {
//                future.channel().writeAndFlush(msg).sync();
//				return true;
//            } catch (Exception ex) {
//                logger.error("sendMsg------重连后Socket消息发送失败： " + e + " Msg：" + msg);
//            }
        }
        
        return false;
    }
    
    //单独用：发送设备检查的命令
    public boolean sendDeviceMsg(String msg){
    	logger.info("sendDeviceMsg------Msg: " + msg);
    	try {
    		String END = new String(new byte[] { 0x0D });
            msg = msg + END;
            future.channel().writeAndFlush(msg).await(500);
            return true;
		} catch (Exception e) {
			logger.error("sendDeviceMsg------Socket消息发送失败： " + e + " Msg：" + msg);
            connected = -1;
		}
    	return false;
    }
}
