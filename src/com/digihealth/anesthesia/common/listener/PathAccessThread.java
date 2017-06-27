package com.digihealth.anesthesia.common.listener;

import java.util.List;

import net.sf.ehcache.Cache;
import net.sf.ehcache.Element;

import org.apache.log4j.Logger;

import com.digihealth.anesthesia.basedata.dao.BasBusEntityDao;
import com.digihealth.anesthesia.basedata.dao.BasRoutingAccessControlDao;
import com.digihealth.anesthesia.basedata.po.BasRoutingAccessControl;
import com.digihealth.anesthesia.common.utils.CacheUtils;
import com.digihealth.anesthesia.common.utils.SpringContextHolder;

public class PathAccessThread extends Thread{
	
	private static Logger logger = Logger.getLogger(PathAccessThread.class);
	
	/**
	 * 1、先清空缓存中的路径相关数据
	 * 2、重新保存路径数据到缓存中
	 */
	public static void setRacList(){
		logger.info("PathAccessThread---setRacList----");
    	List<BasRoutingAccessControl> racList = PathAccessThread.getAllRacList();
    	//先清空缓存中的路径数据
    	clearAllRoutingAccessControl();
    	if(null != racList && racList.size()>0){
    		for (int i = 0; i < racList.size(); i++) {
    			BasRoutingAccessControl sysRoutingAccessControl = racList.get(i);
    			String beid = sysRoutingAccessControl.getBeid();
    			String uri = sysRoutingAccessControl.getUri();
    			String key = getKey(beid,uri);
    			logger.info("put to routingAccessCache:"+key+",sysRoutingAccessControl="+sysRoutingAccessControl.toString());
				CacheUtils.put(ConstantHolder.ROUTING_ACCESS_CACHE , key, sysRoutingAccessControl);
			}
    	}
    }
	
	/**
	 * 1、清空curBeid缓存数据
	 * 2、重新保存到缓存
	 */
	public static void setCurBeId(){
		logger.info("PathAccessThread---setCurBeId----");
		String curBeid = getCurBeid();
		// 清空当前缓存中的beid
		clearCurBeId();
		CacheUtils.put(ConstantHolder.ROUTING_ACCESS_CACHE , ConstantHolder.CUR_BEID, curBeid);
	}
	
	
	/**
	 *  清除所有的前缀为ROUTING_ACCESS_PREFIX的缓存数据
	 */
	@SuppressWarnings("unchecked")
	public static void clearAllRoutingAccessControl(){
		Cache cache = CacheUtils.getCacheByCacheName(ConstantHolder.ROUTING_ACCESS_CACHE);
		if(null != cache){
			List<String> keys = cache.getKeys();
			if(null != keys && keys.size()>0){
				String key = keys.get(0);
				if(key.contains(ConstantHolder.ROUTING_ACCESS_PREFIX)){
					cache.remove(key);//清除key相应的对象
				}
			}
		}
	}
	
	/**
	 * 清空curBeid的缓存
	 */
	public static void clearCurBeId(){
		Cache cache = CacheUtils.getCacheByCacheName(ConstantHolder.ROUTING_ACCESS_CACHE);
		if(null != cache){
			Element element = cache.get(ConstantHolder.CUR_BEID);
			if(null != element){
				cache.removeElement(element);//清除元素
			}
		}
	}
	
	/**
	 * 根据beid和uri，判断是否有当前对象
	 * @param beid
	 * @param uri
	 * @return
	 */
	public static boolean hasSysRoutingAccessControl(String beid, String uri) {
		 BasRoutingAccessControl sysRoutingAccessControl = (BasRoutingAccessControl)CacheUtils.get(ConstantHolder.ROUTING_ACCESS_CACHE,getKey(beid, uri));
		 if(null != sysRoutingAccessControl){
			 return true;
		 }else{
			 return false;
		 }
	}
	
	/**
	 * 根据beid和uri，生成key
	 * @param beid
	 * @param uri
	 * @return
	 */
	public static String getKey(String beid, String uri) {
		String key = ConstantHolder.ROUTING_ACCESS_PREFIX + beid + ConstantHolder.ROUTING_ACCESS_LINK + uri;
		logger.info("PathAccessThread:getKey------获取Key:" + key);
		return key;
	}
	
	/**
	 * 从数据库中获取所有数据库路径对象RacList
	 * @return
	 */
	public static List<BasRoutingAccessControl> getAllRacList(){
		BasRoutingAccessControlDao sysRoutingAccessControlDao = SpringContextHolder.getBean(BasRoutingAccessControlDao.class);
		List<BasRoutingAccessControl> racList = sysRoutingAccessControlDao.selectAllRac();
		return racList;
	}
	
	/**
	 * 从数据库获取当前局点beid
	 * @return
	 */
	public static String getCurBeid(){
		BasBusEntityDao sysBusEntityDao = SpringContextHolder.getBean(BasBusEntityDao.class);
		String beid = sysBusEntityDao.getBeid();
		return beid;
	}
	
	/**
	 * 处理
	 */
	public static void handle(){
		setCurBeId();
		setRacList();
	}
    
    /*@Override
    public void run() {
    	while(1 == ConstantHolder.IS_CUR_BE_UPDATE){
    		logger.info("PathAccessThread--run----进入IS_CUR_BE_UPDATE-------");
    		setCurBeId();
    		ConstantHolder.IS_CUR_BE_UPDATE = 0; //修改为0，则不会再次进入循环，只有接口修改了，将值改成1之后，才会触发进入循环
    		try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				logger.error("InterruptedException:PathAccessThread--:ConstantHolder.IS_CUR_BE_UPDATE:"+e.getMessage());
			}
    	}
    	while(1==ConstantHolder.IS_PATH_ACCESS_UPDATE){
    		logger.info("PathAccessThread--run----进入IS_PATH_ACCESS_UPDATE-------");
    		setRacList();
    		ConstantHolder.IS_PATH_ACCESS_UPDATE = 0;//修改为0
    		try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				logger.error("InterruptedException:PathAccessThread--:ConstantHolder.IS_PATH_ACCESS_UPDATE:"+e.getMessage());
			}
    	}
    }*/
    
    /*@Override
    public synchronized void start() {
    	super.start();
    }*/
}
