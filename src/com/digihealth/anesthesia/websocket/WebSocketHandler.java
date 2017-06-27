package com.digihealth.anesthesia.websocket;

import java.io.IOException;
import java.util.Map;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import net.sf.json.JSONObject;
import org.apache.log4j.Logger;

@ServerEndpoint(value = "/websocket/{username}")
public class WebSocketHandler {
    private final static Logger logger = Logger.getLogger(WebSocketHandler.class);
    
    @OnOpen
    public void onOpen(Session session, @PathParam("username") String username) {
        logger.info("WebSocketHandler------WebSocket @onOpen Start Connecting");
        JSONObject json = new JSONObject();
        json.put("msgType", Constants.WEBSOCKET_ONOPEN);
        json.put("username", username);
        SessionUtil.put(session.getId(), username, session);
        sentMessageToUser(username,json.toString());
    }
    
    @OnError
    public void onError(Session session, Throwable throwable,@PathParam("username") String username) {
        logger.info("WebSocketHandler------Websocket @onError Connection Exception" + SessionUtil.getKey(session.getId(), username));
        logger.info(throwable.getMessage(), throwable);
        SessionUtil.remove(session.getId(), username);
    }

    @OnClose
    public void onClose(Session session,@PathParam("username") String username) {
        logger.info("WebSocketHandler------WebSocket @OnClose");
        SessionUtil.remove(session.getId(), username);
    }

    @OnMessage
    public void onMessage(String message, @PathParam("username") String username, Session session)
    {
        logger.info("WebSocketHandler------WebSocket @onMessage"+message);
         // 前台发送来的消息
        JSONObject json = JSONObject.fromObject(message);
        String msgType = json.getString("msgType");
        //String regOptId = json.getString("regOptId");
        
        if(msgType.equals("hello"))
        {
        	logger.info("WebSocketHandler--- heartbeat------心跳session："+session);
        }else if(msgType.equals("init"))
        {
        	JSONObject jsonTest = new JSONObject();
        	jsonTest.put("test", "ok");
        	sentMessageToUser(username,jsonTest.toString());
        	//sentMessageToAllUser(jsonTest.toString());
        }else if(msgType.equals("reach"))
        {
//        	String reachIds = json.getString("reachIds");
//        	logger.info("服务器已经收了前台发来的--已收--消息！"+ reachIds);
//        	RemindRecordService remindRecordService = SpringContextHolder.getBean("remindRecordService");
//        	RemindRecord record = new RemindRecord();
//        	
//        	String[] ids = reachIds.split(",");
//        	if(ids.length>0)
//        	{
//        		for(String id : ids)
//        		{
//        			if(null != id && !"".equals(id))
//        			{
//        				record.setId(Integer.parseInt(id));
//            			record.setReachStatus(1);
//            			remindRecordService.updateRemindRecord(record);
//        			}
//        		}
//        	}

        }else if(msgType.equals("read"))
        {
//        	String readIds = json.getString("readIds");
//        	logger.info("服务器已经收了前台发来的--已读--消息！"+ readIds);
//        	RemindRecordService remindRecordService = SpringContextHolder.getBean("remindRecordService");
//        	RemindRecord record = new RemindRecord();
//        	
//        	String[] ids = readIds.split(",");
//        	if(ids.length>0)
//        	{
//        		for(String id : ids)
//        		{
//        			if(null != id && !"".equals(id))
//        			{
//        				record.setId(Integer.parseInt(id));
//            			record.setReadStatus(1);
//            			remindRecordService.updateRemindRecord(record);
//        			}
//        		}
//        	}
        }
    }
    
    public static void sentMessageToUser(String username ,String msg)
    {
        try 
        {
        	Map<String, Session> sessionMap  = SessionUtil.clients;
        	if(sessionMap.size()<= 0)
        	{
        		return ;
        	}
        	
        	String[] keyName = null;
            for(String key: sessionMap.keySet() )
         	{
            	keyName  = key.split("_");
            	if(keyName[1].equals(username))
            	{
            		Session session = sessionMap.get(key);
                    session.getBasicRemote().sendText(msg);
                    logger.info("WebSocketHandler---sentMessageToUser------username："+username+";msg="+msg);
            	}
         	}     
        } catch (IOException e) {
             logger.debug("错误: 消息群发送失败!", e);
        }
    }
    
    public static void sentMessageToAllUser(String msg)
    {
    	logger.info("WebSocketHandler--start--sentMessageToAllUser------msg:"+msg);
        try 
        {
        	Map<String, Session> sessionMap  = SessionUtil.clients;
        	logger.info("WebSocketHandler---sessionMapSize---"+sessionMap.size());
        	if(sessionMap.size()<= 0)
        	{
        		return ;
        	}
            for(String key: sessionMap.keySet() )
        	{
            	synchronized (sessionMap.get(key))
            	{
            	    Session session = sessionMap.get(key);
                    session.getBasicRemote().sendText(msg);
            	}
        	}
            logger.info("WebSocketHandler--end--sentMessageToAllUser------msg:"+msg);

        } catch (IOException e) {
             logger.debug("错误: 消息发送失败!", e);
        }
        
    }
}
