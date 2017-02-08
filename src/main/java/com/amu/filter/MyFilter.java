package com.amu.filter;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyFilter implements Filter{

	private Logger logger = LoggerFactory.getLogger(MyFilter.class);
	
	private HttpServletRequest request;
	
	private HttpServletResponse response;
	
	public void destroy() {
		
	}

	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
			FilterChain filterChain) throws IOException, ServletException {
		request = (HttpServletRequest) servletRequest;
		response = (HttpServletResponse) servletResponse;
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		StringBuffer url = new StringBuffer(request.getRequestURI());
		if(url.toString().endsWith(".jsp")||url.toString().endsWith(".js")||url.toString().endsWith(".css")){
			//过滤jsp,js,css
		}else{
			url.append("?");
			Enumeration<String> enumeration = request.getParameterNames();
			while(enumeration.hasMoreElements()){
				String paramName = enumeration.nextElement();
				String paramValue = request.getParameter(paramName);
				url.append(paramName + "=" + paramValue + "&");
			}
			logger.debug(url.substring(0, url.length() - 1));
		}
		filterChain.doFilter(request, response);
	}

	public void init(FilterConfig arg0) throws ServletException {
		
	}

}
