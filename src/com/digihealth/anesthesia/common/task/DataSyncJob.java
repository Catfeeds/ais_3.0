package com.digihealth.anesthesia.common.task;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.DeliveryMode;
import javax.jms.Destination;
import javax.jms.MessageConsumer;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
//import org.springframework.stereotype.Component;
//import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.digihealth.anesthesia.common.listener.ConstantHolder;
import com.digihealth.anesthesia.common.listener.PathAccessThread;
import com.digihealth.anesthesia.common.utils.CacheUtils;
import com.digihealth.anesthesia.common.utils.SysUtil;
import com.digihealth.anesthesia.operProceed.core.MyConstants;

//@Component
//@Service
public class DataSyncJob {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    private final static Logger logger = Logger.getLogger(DataSyncJob.class);

    private String url;
    private String model;
    private String queues;
    private String currQue;
    private Connection connProducer;
    private Connection connConsumer;
    private static final Object lock = new Object();

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public DataSyncJob(String url, String model, String queues, String currQue) {
        logger.info("DataSyncJob------初始化，URL：" + url); 
        logger.info("DataSyncJob------model:" + model + " queues:" + queues + " currQue:" + currQue); 
        
        this.url = url;
        this.model = model;
        this.queues = queues;
        this.currQue = currQue;
    }
    
    public void job() {
        logger.info("job------数据同步定时任务开始");
        receiveMsg();
        sendMsg();
    }

    /**
     * 连接到ActiveMQ服务器
     * 
     * @param 
     *            
     * @return 不空表示连接成功，空表示连接失败
     */
    public Connection connectMQ() {
        logger.info("connectMQ------连接到ActiveMQ服务器:" + url); 
        ConnectionFactory connectionFactory;
        Connection connection = null;
	    connectionFactory = new ActiveMQConnectionFactory(
	                ActiveMQConnection.DEFAULT_USER,
	                ActiveMQConnection.DEFAULT_PASSWORD, url);
        try {
            connection = connectionFactory.createConnection();
            connection.start();
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        return connection;
    }

    /**
     * 断开连接
     * 
     * @param connection
     *            ActiveMQ连接
     */
    public void disconnectMQ(Connection connection) {
        logger.info("disconnectMQ------关闭ActiveMQ服务器连接"); 
        try {
            if (connection != null) {
                connection.stop();
                connection.close();
            }
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
    }

    private void sendMsg() {
        logger.info("sendMsg------发送JMS消息");
        synchronized (lock) {
            List<Map<String, Object>> messagesList = jdbcTemplate
                    .queryForList("select id,message from bas_message order by id limit 1000 for update");
            
            while (messagesList != null && messagesList.size() > 0) {
                String ids = "0";
                Iterator<Map<String, Object>> messagesIte = messagesList
                        .iterator();
                while (messagesIte.hasNext()) {
                    Map<String, Object> message = messagesIte.next();
                    String msgTxt = String.valueOf(message.get("message"));
                    if (sendMsg(msgTxt)) {
                        ids = ids + "," + String.valueOf(message.get("id"));	
                    }
                }
                
                logger.info("sendMsg------删除bas_message消息：" + ids);
                jdbcTemplate.update("delete from bas_message where id in (" + ids
                        + ")");
                
                messagesList = jdbcTemplate
                        .queryForList("select id,message from bas_message order by id limit 1000");
            }
        }
    }

    public boolean sendMsg(String msg) {
        logger.info("sendMsg------发送JMS消息：" + msg); 
        if (connProducer == null) {
            connProducer = connectMQ();
        }
        boolean flag = false;

        Session session = null; // Destination ：消息的目的地;消息发送给谁.
        Destination destination = null; // MessageProducer：消息发送者
        MessageProducer producer = null; // TextMessage message;

        try {
            // 获取操作连接
            session = connProducer.createSession(Boolean.TRUE,
                    Session.AUTO_ACKNOWLEDGE);
            if (MyConstants.DATA_SYNC_WORKSTATION_MASTER.equals(model)) {//生产者是queues(workstation1、workstation2、workstation3)
                if (SysUtil.isEmptyStr(queues)) {
                    queues = MyConstants.DATA_SYNC_WORKSTATION_MAINQUEUE;
                }
                String[] ques = queues.split(",");
                for (int i = 0; i < ques.length; i ++) {
                    // 获取session注意参数值 queue，须在在ActiveMq的console配置
                    destination = session.createQueue(ques[i]);
                    // 得到消息生成者【发送者】
                    producer = session.createProducer(destination);
                    // 设置不持久化，此处学习，实际根据项目决定      2016-04-13 设置持久化 
                    producer.setDeliveryMode(DeliveryMode.PERSISTENT);
                    // 构造消息，此处写死，项目就是参数，或者方法获取
                    TextMessage message = session.createTextMessage(msg);
                    logger.info("sendMsg------发送JMS消息到队列：" + ques[i]); 
                    producer.send(message);
                }
            } else {//生产者是 控制中心 Slave2Master
                // 获取session注意参数值 queue，须在在ActiveMq的console配置
                destination = session.createQueue(MyConstants.DATA_SYNC_WORKSTATION_MAINQUEUE);
                // 得到消息生成者【发送者】
                producer = session.createProducer(destination);
                // 设置不持久化，此处学习，实际根据项目决定          2016-04-13 设置持久化 
                producer.setDeliveryMode(DeliveryMode.PERSISTENT);
                // 构造消息，此处写死，项目就是参数，或者方法获取
                TextMessage message = session.createTextMessage(msg);
                logger.info("sendMsg------发送JMS消息到队列：" + MyConstants.DATA_SYNC_WORKSTATION_MAINQUEUE); 
                producer.send(message);
            }
            
            session.commit();
            flag = true;
        } catch (Exception e) {
            logger.error(e.getMessage());
            flag = false;
        } finally {
			try {
				if (session != null) {
					session.close();
				}
				if (null != connProducer) {
					connProducer.close();
					connProducer = null;
				}
			} catch (Throwable ignore) {
				logger.error(ignore);
				connProducer = null;
			}
        }
        
        return flag;
    }

    public void receiveMsg() {
    	logger.info("receiveMsg------接收JMS消息"); 
    	
        if (connConsumer == null) {
            connConsumer = connectMQ();
        }

        Session session = null;
        // Destination ：消息的目的地;消息发送给谁.
        Destination destination = null;
        // 消费者，消息接收者
        MessageConsumer consumer = null;

        try {
            // 获取操作连接
            session = connConsumer.createSession(Boolean.FALSE,
                    Session.AUTO_ACKNOWLEDGE);
            if (MyConstants.DATA_SYNC_WORKSTATION_MASTER.equals(model)) {//消费者是控制中心 Slave2Master
                // 获取session注意参数值 queue，须在在ActiveMq的console配置
                destination = session.createQueue(MyConstants.DATA_SYNC_WORKSTATION_MAINQUEUE);
                consumer = session.createConsumer(destination);
                while (true) {
                    // 设置接收者接收消息的时间，10s
                    TextMessage message = (TextMessage) consumer.receive(1000);
                    if (null != message) {
                    	try {
	                        logger.info("收到JMS消息 " + MyConstants.DATA_SYNC_WORKSTATION_MAINQUEUE + ":"+ message.getText());
	                        jdbcTemplate.update(message.getText());
                    	}
                    	catch (Exception e) {
                    		logger.error(e.getMessage());
                    	}
                    } else {
                    	break;
                    }
                }
            } else {//消费者是workstation1
                // 获取session注意参数值 queue，须在在ActiveMq的console配置
                destination = session.createQueue(currQue);
                consumer = session.createConsumer(destination);
                while (true) {
                    // 设置接收者接收消息的时间，10s
                    TextMessage message = (TextMessage) consumer.receive(1000);
                    if (null != message) {
                    	try {
	                        logger.info("收到JMS消息:" + currQue + ":"+ message.getText());
	                        jdbcTemplate.update(message.getText());
                    	}
                    	catch (Exception e) {
                    		logger.error(e.getMessage());
                    	}
                    } else {
                    	break;
                    }
                }
            }
        } catch (Exception e) {
            logger.error(e.getMessage());
        } finally {
            // 关闭释放资源
			try {
				if (session != null) {
					session.close();
				}

				if (null != connConsumer) {
					connConsumer.close();
					connConsumer = null;
				}
			} catch (Throwable ignore) {
				logger.error(ignore);
				connConsumer = null;
			}
		}
    }

    @Transactional
    public void saveMsg(final String message) {
        logger.info("saveMsg------新增bas_message消息：" + message);
        Object obj = CacheUtils.get(ConstantHolder.ROUTING_ACCESS_CACHE, ConstantHolder.CUR_BEID);
        String beid = null;
        if(obj!=null){
        	beid = obj.toString();
        }
        if(StringUtils.isBlank(beid)){
        	beid = PathAccessThread.getCurBeid();
        }
        try {
            String sql = "INSERT INTO bas_message(message,time,beid) values (?,now(),'"+beid+"' )";
            jdbcTemplate.update(sql, new PreparedStatementSetter() {
                @Override
                public void setValues(PreparedStatement pstmt)
                        throws SQLException {
                    pstmt.setObject(1, message);
                }
            });
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
    }
}
