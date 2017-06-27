package com.digihealth.anesthesia.websocket;

import javax.websocket.Session;

import org.apache.log4j.Logger;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 支持多用户多客户端的session
     * Title: SessionUtil.java    
     * Description: 
     * @author chenyong       
     * @created 2016年6月21日 上午11:39:09
 */
public class SessionUtil {
    private final static Logger logger = Logger.getLogger(SessionUtil.class);
    
    private static Session localSession;
    private static String username;

    public static String getUsername() {
		return username;
	}

	public static void setUsername(String username) {
		SessionUtil.username = username;
	}

	public static Map<String, Session> clients = new ConcurrentHashMap<String, Session>();

    public static void put(String sessionId, String username, Session session) {
        logger.info("put------保存Session，sessionId:" + sessionId + " username:"
                + username);
        clients.put(getKey(sessionId, username), session);
    }
    
    public static void putUsers(String username, Session session) {
        logger.info("put------保存Session， username:" + username);
        clients.put(username, session);
    }

    public static Session get(String sessionId, String username) {
        return (Session) clients.get(getKey(sessionId, username));
    }
    
    public static Session get(String username) {
        return (Session) clients.get(username);
    }

    public static void remove(String sessionId, String username) {
        String currKey = getKey(sessionId, username);
        logger.info("remove------session key：" + currKey);
        if (clients.remove(currKey) == null) {
            for (String key : clients.keySet()) {
                if (key.contains(currKey)) {
                    clients.remove(key);
                }
            }
        }
    }
    
    public static void removeAll(String username) {
        logger.info("removeAll------session");
        if (clients != null) {
            for (String key : clients.keySet()) {
                if (key.contains(username)) {
                    clients.remove(key);
                }
            }
        }
    }

    /**
     * 判断是否有连接
     * 
     * @param relationId
     * @param userCode
     * @return
     */
    public static boolean hasConnection(String sessionId, String username) {
        return clients.containsKey(getKey(sessionId, username));
    }

    /**
     * 组装唯一识别的key
     * 
     * @param relationId
     * @param userCode
     * @return
     */
    public static String getKey(String sessionId, String username) {
        String key = sessionId + "_" + username;
        logger.info("getKey------获取Key:" + key);
        return key;
    }

    public static void broadcast(Session client, String msg) {
        logger.info("broadcast------session key:"
                + client.getId() + " Msg:" + msg);
        try {
            client.getBasicRemote().sendText(msg);
        } catch (Exception e) {
        	logger.error(e.getMessage());
        }
    }

    /*public static void broadcast(String msg) {
        if (null != localSession) {
        	try {
				localSession.getBasicRemote().sendText(msg);
			} catch (Exception e) {
				localSession = null;
				logger.error(e.getMessage());
			}
        } else {
	        for (String key : clients.keySet()) {
	            try {
	                synchronized (clients.get(key)) {
	                    logger.info("broadcast------session key:" + key + " Msg:" + msg);
	                    clients.get(key).getBasicRemote().sendText(msg);
	                }
	            } catch (Exception e) {
	            	logger.error(e.getMessage());
	                try {
	                    clients.get(key).close();
	                    clients.remove(key);
	                } catch (Exception e1) {
	                	logger.error(e1.getMessage());
	                }
	            }
	        }
        }
    }*/
    
    public static void broadcast(String msg) {
        for (String key : clients.keySet()) {
            try {
                synchronized (clients.get(key)) {
                    logger.info("broadcast------session key:" + key + " Msg:" + msg);
                    // 同步发送 
                    //clients.get(key).getBasicRemote().sendText(msg);
                    // 异步发送
                    clients.get(key).getAsyncRemote().sendText(msg);
                }
            } catch (Exception e) {
            	logger.error(e.getMessage());
                try {
                    clients.get(key).close();
                    clients.remove(key);
                } catch (Exception e1) {
                	logger.error(e1.getMessage());
                }
            }
        }
    }

    public static Session getLocalSession() {
        return localSession;
    }

    public static void setLocalSession(Session session) {
    	SessionUtil.localSession = session;
    }

}
