package com.efs.common.controller;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 
* @Title: BusinessInteceptor.java 
* @Package com.efs.common.controller 
* @Description: 平台业务拦截器
* @author xwh-徐武海
* @date 2016年6月24日 下午9:05:46 
* @version V1.0
 */
public class BusinessInteceptor extends HandlerInterceptorAdapter
{

	/* (non-Javadoc)
	 * @see org.springframework.web.servlet.handler.HandlerInterceptorAdapter#preHandle(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, java.lang.Object)
	 */
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception
	{
		//如果请求参数中带有isBack=Y，则把ISBACK设置到SESSION中，供下一步的查询使用缓存参数
		String isBack = request.getParameter("isBack");
		HttpSession session = request.getSession();
		if("Y".equals(isBack))
		{
			session.setAttribute("isBack", "Y");
		}
		
		return true;
	}
	
}
