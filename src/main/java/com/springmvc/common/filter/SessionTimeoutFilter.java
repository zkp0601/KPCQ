package com.springmvc.common.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.springmvc.common.Constants;

/**
 *<b>类说明：</b>Session拦截器<br/>
 *<b>详细描述：</b>用户身份过期时会被拦截，需重新登录 
 * 
 * @author zhengkaipei
 * @since 2016年11月26日
 */
public class SessionTimeoutFilter extends HttpServlet implements Filter{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//logger 主要用来打印日志
	private Logger logger = LoggerFactory.getLogger(getClass());

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) 
			throws IOException, ServletException {
		
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		request.setCharacterEncoding("UTF-8");
		
		HttpServletResponse response = (HttpServletResponse) servletResponse;
		HttpSession session = request.getSession(false);
		
		/** 当前用户登录后服务器存储的session */
		if(session != null){
			logger.info("调用拦截－当前登录用户:{}", session.getAttribute(Constants.SESSION_TOKEN));
		}else{
			logger.info("调用拦截－session为空");
		}
		
		/** 不拦截静态资源以及登录操作的请求 */
		String contextPath = request.getContextPath();
		String uri = request.getRequestURI();
		logger.info(contextPath);
		
		if((session == null || null == session.getAttribute(Constants.SESSION_TOKEN))
				&& !uri.contains("/login") && !uri.contains("/logout") && !uri.contains("/static")){
			
			logger.info("当前请求:{} 被拦截, 并被重定向至登录页面", uri);
			response.sendRedirect(contextPath + "/login");
			
		}else{
			// 此句必须加上,否则一切请求到此会终止,不会再往下执行
			filterChain.doFilter(servletRequest, servletResponse);
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		
	}
	
}
