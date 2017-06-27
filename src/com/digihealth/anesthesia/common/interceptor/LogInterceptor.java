/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.digihealth.anesthesia.common.interceptor;

import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.core.NamedThreadLocal;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.digihealth.anesthesia.common.service.BaseService;
import com.digihealth.anesthesia.common.utils.DateUtils;
import com.digihealth.anesthesia.common.utils.Exceptions;

/**
 * 
 * Title: LogInterceptor.java Description: 日志拦截器
 * 
 * @author chengwang
 * @created 2015-10-7 下午5:59:24
 */
public class LogInterceptor extends BaseService implements HandlerInterceptor {

	private static final ThreadLocal<Long> startTimeThreadLocal = new NamedThreadLocal<Long>(
			"ThreadLocal StartTime");

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		/*
		 * BufferedReader br = new BufferedReader(request.getReader()); String
		 * inputLine; String str = ""; try { while ((inputLine = br.readLine())
		 * != null) { str += inputLine; } br.close(); } catch (IOException e) {
		 * System.out.println("IOException: " + e); }
		 */
		/*StringBuffer info = new java.lang.StringBuffer();
		InputStream in = request.getInputStream();
		BufferedInputStream buf = new BufferedInputStream(in);
		byte[] buffer = new byte[1024];
		int iRead;
		while ((iRead = buf.read(buffer)) != -1) {
			info.append(new String(buffer, 0, iRead, "UTF-8"));
		}*/
		if (logger.isDebugEnabled()) {
			long beginTime = System.currentTimeMillis();// 1、开始时间
			startTimeThreadLocal.set(beginTime); // 线程绑定变量（该数据只有当前请求的线程可见）
			logger.debug("开始计时: {}  URI: {} DATA: " ,
					new SimpleDateFormat("hh:mm:ss.SSS").format(beginTime),
					request.getRequestURI());
		}
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		if (modelAndView != null) {
			logger.info("ViewName: " + modelAndView.getViewName());
		}
	}

	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		/*StringBuffer info = new java.lang.StringBuffer();
		InputStream in = request.getInputStream();
		BufferedInputStream buf = new BufferedInputStream(in);
		byte[] buffer = new byte[1024];
		int iRead;
		while ((iRead = buf.read(buffer)) != -1) {
			info.append(new String(buffer, 0, iRead, "UTF-8"));
		}
		*/
		// 打印JVM信息。
		if (logger.isDebugEnabled()) {
			logger.debug(Exceptions.getStackTraceAsString(ex));
			long beginTime = startTimeThreadLocal.get();// 得到线程绑定的局部变量（开始时间）
			long endTime = System.currentTimeMillis(); // 2、结束时间
			logger.debug("计时结束：{"
					+ new SimpleDateFormat("hh:mm:ss.SSS").format(endTime)
					+ "}  耗时：{" + DateUtils.formatDateTime(endTime - beginTime)
					+ "}  URI: {" + request.getRequestURI() + "}  ");
		}
		// 保存日志
		//LogUtils.saveLog(request, handler, ex, null);
	}
}
