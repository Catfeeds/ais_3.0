package com.digihealth.anesthesia.operProceed.core;

import java.util.Map;

import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.timeout.IdleState;  
import io.netty.handler.timeout.IdleStateEvent; 
import net.sf.json.JSONObject;

import org.apache.log4j.Logger;

import com.digihealth.anesthesia.operProceed.datasync.MessageProcess;

/**
 * socketClientHandler处理类
     * Title: SocketClientHandler.java    
     * Description: 
     * @author chenyong       
     * @created 2016年7月15日 下午2:19:02
 */
public class SocketClientHandler extends SimpleChannelInboundHandler<Object> {

    private static final Logger logger = Logger
            .getLogger(SocketClientHandler.class);
    
    public SocketClientHandler() {
        super();
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, Object msg)
            throws Exception {
        String msgTxt = (String) msg;
        logger.info("channelRead0------处理采集服务监测数据:" + msg);
        @SuppressWarnings("unchecked")
        Map<String, Object> obj = JSONObject.fromObject(msg);
        int msgType = Integer.parseInt(obj.get("msgType").toString());
        if (MyConstants.DATA_COLLECTOR_HEARTBEAT == msgType) {
            JSONObject json = new JSONObject();
            json.put("msgType", MyConstants.DEFAULT_HEART_BEAT);
            ctx.channel().writeAndFlush(json.toString() + MyConstants.END);
        } else {
        	MessageProcess.contextHandle(msgTxt);
        }
    }
    
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
    	logger.info("channelActive-----remoteAddress:"+ctx.channel().remoteAddress()+",localAddress:"+ctx.channel().localAddress());
    	super.channelActive(ctx);
    }
    
    @Override  
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt)  
            throws Exception {  
        /*心跳处理*/
        if (evt instanceof IdleStateEvent) {
            IdleStateEvent event = (IdleStateEvent) evt;
            if (event.state() == IdleState.READER_IDLE) {
                logger.info("userEventTriggered------READER_IDLE 读超时");
            } else if (event.state() == IdleState.WRITER_IDLE) {
                logger.info("userEventTriggered------WRITER_IDLE 写超时");
            } else if (event.state() == IdleState.ALL_IDLE) {
                logger.info("userEventTriggered------ALL_IDLE 总超时");
            }
            JSONObject json = new JSONObject();
            json.put("msgType", MyConstants.DEFAULT_HEART_BEAT);
            ctx.writeAndFlush(json.toString() + MyConstants.END).addListener(
                    ChannelFutureListener.CLOSE_ON_FAILURE); 
        } else {
            super.userEventTriggered(ctx, evt);
        }
    }
}

