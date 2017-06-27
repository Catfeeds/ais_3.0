package com.digihealth.anesthesia.operProceed.core;

import javax.websocket.Session;

import org.apache.log4j.Logger;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class SessionUtil {
    private final static Logger logger = Logger.getLogger(SessionUtil.class);
    private static Session localSession;
    private static String regOptId;

    public static String getRegOptId() {
        return regOptId;
    }

    public static void setRegOptId(String operId) {
        regOptId = operId;
    }

    public static Map<String, Session> clients = new ConcurrentHashMap<String, Session>();

    public static void put(String sessionId, String regOptId, Session session) {
        logger.info("put------保存Session，sessionId:" + sessionId + " regOptId:"
                + regOptId);
        clients.put(getKey(sessionId, regOptId), session);
    }

    public static Session get(String sessionId, String regOptId) {
        return (Session) clients.get(getKey(sessionId, regOptId));
    }

    public static void remove(String sessionId, String regOptId) {
        String currKey = getKey(sessionId, regOptId);
        logger.info("remove------session key：" + currKey);
        if (clients.remove(currKey) == null) {
            for (String key : clients.keySet()) {
                if (key.contains(currKey)) {
                    clients.remove(key);
                }
            }
        }
    }
    
    public static void removeAll(String regOptId) {
        logger.info("removeAll------session");
        if (clients != null) {
            for (String key : clients.keySet()) {
                if (key.contains(regOptId)) {
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
    public static boolean hasConnection(String sessionId, String regOptId) {
        return clients.containsKey(getKey(sessionId, regOptId));
    }

    /**
     * 组装唯一识别的key
     * 
     * @param relationId
     * @param userCode
     * @return
     */
    public static String getKey(String sessionId, String regOptId) {
        String key = sessionId + "_" + regOptId;
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

    public static void broadcast(String msg) {
        if (null != localSession) {
        	try {
        		//logger.info("broadcast------localSession id:" + localSession.getId() + " Msg:" + msg);
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
    }

    public static Session getLocalSession() {
        return localSession;
    }

    public static void setLocalSession(Session session) {
        localSession = session;
    }

}
