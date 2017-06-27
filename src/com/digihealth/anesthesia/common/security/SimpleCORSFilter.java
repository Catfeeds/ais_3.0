package com.digihealth.anesthesia.common.security;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SimpleCORSFilter implements Filter{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest request = (HttpServletRequest) req;
		String url = request.getRequestURI();
		
		boolean bool = url.contains("/druid/");
		//System.out.println("url======================="+url+",bool===="+bool);
		
		if(null != url && !bool){
			// TODO Auto-generated method stub
			HttpServletResponse response = (HttpServletResponse) res;
			response.setHeader("Access-Control-Allow-Origin", "*");
			response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
			response.setHeader("Access-Control-Max-Age", "3600");
			response.setHeader("Access-Control-Allow-Headers", ",Origin, X-Requested-With, Content-Type, Accept,x-token,username,beid,module");
			response.setHeader("Content-Type", "application/x-www-form-urlencoded");
		    chain.doFilter(req, res);
		}else{ //直接过去
			chain.doFilter(req, res);
		}
		
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
