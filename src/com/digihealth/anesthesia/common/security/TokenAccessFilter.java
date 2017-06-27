package com.digihealth.anesthesia.common.security;

import io.jsonwebtoken.Claims;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;

import net.sf.json.JSONObject;

import com.digihealth.anesthesia.common.config.Global;
import com.digihealth.anesthesia.common.jwt.JwtUtils;
import com.digihealth.anesthesia.common.jwt.TokenState;
import com.digihealth.anesthesia.common.listener.ConstantHolder;
import com.digihealth.anesthesia.common.utils.CacheUtils;

public class TokenAccessFilter implements Filter {

	private final static String LOGIN_URL = "/sys/login";
	private final static String LOGOUT_URL = "/sys/logout";
	private final static String AUTH_TOKEN = "x-token";

	//private static final Set<String> ALLOWED_PATHS = Collections.unmodifiableSet(new HashSet<String>( Arrays.asList( "/login", "/logout", "/register")));

	private static final Set<String> ALLOWED_RESOURCES = Collections.unmodifiableSet(new HashSet<String>(
			Arrays.asList("/","/public/", "/swagger/","/api-docs","/api-docs/","/server/","/druid/")));
	
	@Override
	public void destroy() {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;

		// 过滤掉不要校验的path
		String requestUrl = req.getRequestURI();
		String ctxPath = req.getContextPath();
		String path = requestUrl.substring(ctxPath.length());
		int lastIndexOf = path.lastIndexOf("/");
		String substr = null;
		if(lastIndexOf == 0){//如果lastIndexOf为0，则只有一个/
			substr = path;
		}else{
			int indexOf = path.indexOf("/",0);
			substr = path.substring(indexOf, path.indexOf("/",1)+1);
		}
		
		if (ALLOWED_RESOURCES.contains(substr)) {//在允许的资源列表里，才允许通过
			chain.doFilter(request, response);
		} else if (LOGIN_URL.equals(path)) { //登录逻辑
			// 1、如果用户已登录，则直接返回对应的提示信息；用户在登录的时候，需要将token存放到缓存中,也需要保存到数据库中
			// 2、如果用户未登录，则直接通过；
			//String username = req.getParameter("username");
			// 从routingAccessCache缓存中获取beid
			//String beid = (String)CacheUtils.get(ConstantHolder.ROUTING_ACCESS_CACHE,ConstantHolder.CUR_BEID);
			//String operatorAdmin = Global.getConfig("operatorAdmin").trim();
			//String baseAdmin = Global.getConfig("baseAdmin").trim();
			//if(operatorAdmin.equals(username)){//运营管理平台beid
			//	beid = ConstantHolder.DEFAULT_BEID;
			//}else if(baseAdmin.equals(username)){//基线管理beid
			//	beid = ConstantHolder.BASE_BEID;
			//}
			//String key = JwtUtils.getKey(username, beid);
			
			//String token = (String)CacheUtils.get(key);
			//根据token是否存在，判断是否已经登录
			/*if(null != token){
				HttpServletResponse res = (HttpServletResponse) response;
				response.setCharacterEncoding("utf-8");
				response.setContentType("text/html;charset=utf-8");
				PrintWriter out = res.getWriter();
				String retStr = "";
				retStr = "{\"resultCode\":20000006,\"resultMessage\":"+username+"\" already logined.\"}";
				out.println(retStr);
				out.flush();
				return;
			}*/
			chain.doFilter(request, response);
			
		} else if(LOGOUT_URL.equals(path)){ 
			// 1、用户点击登陆按钮or叉掉浏览器都需要触发调用登出logout的接口；
			// 2、用户登出系统时，需要调用logout接口，后端会将数据库中的token和缓存中的token清除，前端也需要将token清空；
			chain.doFilter(request, response);
		}else {
			// 拿到header中的token
			String token = req.getHeader(AUTH_TOKEN);
			
			int jwtHolder = Integer.parseInt(Global.getConfig("jwtHolder"));//jwt认证开关
			
			if(1 == jwtHolder){ //开启认证
				if (null == token || StringUtils.isBlank(token)) {
					// 根据返回值做处理
					HttpServletResponse res = (HttpServletResponse) response;
					response.setCharacterEncoding("utf-8");
					response.setContentType("text/html;charset=utf-8");
					PrintWriter out = res.getWriter();
					String retStr = "";
					retStr = "{\"resultCode\":403,\"resultMessage\":\"非法接入。\"}";
					out.println(retStr);
					out.flush();
					return;
				}
				
				//从header中获取username和beid,接口参数中header中必传username和beid
				String username = req.getHeader("username");
				String beid = req.getHeader("beid");
				if(null ==username || StringUtils.isBlank(username) || null == beid || StringUtils.isBlank(beid)){
					HttpServletResponse res = (HttpServletResponse) response;
					response.setCharacterEncoding("utf-8");
					response.setContentType("text/html;charset=utf-8");
					PrintWriter out = res.getWriter();
					String retStr = "";
					retStr = "{\"resultCode\":403,\"resultMessage\":\"非法接入。\"}";
					out.println(retStr);
					out.flush();
					return;
				}
				String key = JwtUtils.getKey(username, beid);
				String cacheToken = (String)CacheUtils.get(key);
				
				if(!cacheToken.equals(token)){//缓存中的token和页面传递过来的token不一致
					HttpServletResponse res = (HttpServletResponse) response;
					response.setCharacterEncoding("utf-8");
					response.setContentType("text/html;charset=utf-8");
					PrintWriter out = res.getWriter();
					String retStr = "";
					retStr = "{\"resultCode\":401,\"resultMessage\":\"token不一致。\"}";
					out.println(retStr);
					out.flush();
					return;
				}
				
				// jwt认证token
				// 获得私密 
				String secretKey = Global.getConfig("secretKey").trim();
				Map<String, Object> resultMap = JwtUtils.parseJWT(token, secretKey);
				
				String state = (String)resultMap.get(ConstantHolder.TOKEN_STATE);
				
				if(TokenState.INVALID.name().equals(state)){ //非法token
					// 根据返回值做处理
					HttpServletResponse res = (HttpServletResponse) response;
					response.setCharacterEncoding("utf-8");
					response.setContentType("text/html;charset=utf-8");
					PrintWriter out = res.getWriter();
					String retStr = "";
					retStr = "{\"resultCode\":401,\"resultMessage\":\"token认证无效。\"}";
					out.println(retStr);
					out.flush();
					return;
				}else if(TokenState.EXPIRED.name().equals(state)){
					//过期则直接清空缓存中的token，方便页面重新登陆
					Claims claims = (Claims)resultMap.get(ConstantHolder.TOKEN_CLAIMS);
					String subject = claims.getSubject();
					JSONObject json = JSONObject.fromObject(subject);
					username = json.getString("username");
					beid = json.getString("beid");
					key = JwtUtils.getKey(username, beid);
					Object obj = CacheUtils.get(key);
					if(null != obj){
						CacheUtils.remove(key);
					}
					
					HttpServletResponse res = (HttpServletResponse) response;
					response.setCharacterEncoding("utf-8");
					response.setContentType("text/html;charset=utf-8");
					PrintWriter out = res.getWriter();
					String retStr = "";
					retStr = "{\"resultCode\":402,\"resultMessage\":\"token已过期，请重新登录。\"}";
					out.println(retStr);
					out.flush();
					return;
				}else{
					Claims claims = (Claims)resultMap.get(ConstantHolder.TOKEN_CLAIMS);
					System.out.println("parseJWT--Subject: " + claims.getSubject());
					System.out.println("parseJWT--Expiration: " + claims.getExpiration());
					chain.doFilter(request, response);
				}
			}else{
				
				chain.doFilter(request, response);
			}
		}
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

	}

}
