package com.digihealth.anesthesia.common.listener;

import javax.servlet.ServletContext;

import org.apache.log4j.Logger;
import org.springframework.web.context.ServletContextAware;

/**
 * 跟随spring一起启动，初始化路径控制表相关数据，存入缓存
 * 初始化当前局点，存入缓存
 * 1、如果业务修改了当前局点，能够触发修改对应缓存相关数据
 * 2、如果业务修改了，系统相关路径控制表数据，则清除带routing_access_前缀的缓存中的数据
     * Title: InitPathAccessListener.java    
     * Description: 
     * @author chenyong       
     * @created 2017年3月8日 下午3:03:13
 */
public class InitPathAccessListener implements ServletContextAware{
	
	private static Logger logger = Logger.getLogger(InitPathAccessListener.class);
	
	
	@Override
	public void setServletContext(ServletContext servletContext) {
		logger.info("InitPathAccessListener------setServletContext");
		//PathAccessThread thread = new PathAccessThread();
		PathAccessThread.handle();//处理
	}

	
	

}
