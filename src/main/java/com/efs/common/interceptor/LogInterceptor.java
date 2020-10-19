package com.efs.common.interceptor;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 記錄用戶訪問日誌
 * @author xwh
 *
 */
public class LogInterceptor extends HandlerInterceptorAdapter
{
	private static Log logger = LogFactory.getLog(LogInterceptor.class);
	
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception
	{
		logger.info("["+request.getRemoteHost()+"] ☆☆☆☆☆☆=================> ["+request.getRequestURL()+"]");
		return super.preHandle(request,response,handler);
	}
}
