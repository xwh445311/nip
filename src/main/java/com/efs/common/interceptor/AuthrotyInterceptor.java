package com.efs.common.interceptor;

import com.efs.common.Util.SysConstant;
import com.efs.common.auth.user.mapper.TsUserInfo;
import com.efs.common.error.controller.ErrorForm;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;

/**
 * 手动访问权限认证，对.do的请求进行认证
 * 校验逻辑：<br/>
 * 1、如果CONTROLLER方法上没有配置AUTH注解，则表示该方法不用校验。<br/>
 * 2、如果CONTROLLER方法配置了AUTH注解，但没有指定任何值，则表示只需要登录即可。<br/>
 * 3、如果CONTROLLER方法配置了AUTH注解，且指定了值，则表示用户必须具有此功能的权限。<br/>
 * @author xwh
 *
 */
public class AuthrotyInterceptor extends HandlerInterceptorAdapter
{

	private static Log logger = LogFactory.getLog(AuthrotyInterceptor.class);
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception
	{
		boolean flag = true;
		HttpSession session = request.getSession();
		String falseType = null;
		PrintWriter pw = null;
		if(handler instanceof HandlerMethod)
		{
			HandlerMethod handlerMethod = (HandlerMethod)handler;
			Auth auth = handlerMethod.getMethod().getAnnotation(Auth.class);
			if(null != auth)
			{
				logger.debug("--------對["+request.getRequestURI()+"]進行校驗");
				//需要进行权限检查，首先验证是否登录
				if(null == session.getAttribute(SysConstant.SESSION_KEY_SYSUSER))
				{
					//没有登录
					flag = false;
					falseType = SysConstant.LOGIN_ERROR_NOLOG;
					logger.debug("--------對["+request.getRequestURI()+"]進行校驗:失敗，未登錄！");
				}
				else
				{
					TsUserInfo user = (TsUserInfo)session.getAttribute(SysConstant.SESSION_KEY_SYSUSER);
					logger.debug("--------對["+request.getRequestURI()+"]進行校驗:己登錄，校驗權限，需要權限為：" + auth.value());
					
					//己经登录，验证是否有权限访问
					if(StringUtils.isNotEmpty(auth.value()))
					{
						//己有明确的权限要求，需要对权限进行校验
						if(user.getUserFuncIdList() == null || !user.getUserFuncIdList().contains(auth.value()))
						{
							flag = false;
							falseType = SysConstant.LOGIN_ERROR_NORIGTH;
							logger.debug("--------對["+request.getRequestURI()+"]進行校驗:失敗，沒有權限，需要權限為:" + auth.value());
						}
						else
						{
							logger.debug("--------對["+request.getRequestURI()+"]進行校驗:己登錄，校驗權限成功！");
						}
					}
					else
					{
						logger.debug("--------對["+request.getRequestURI()+"]進行校驗:無需校驗權限，跳過!");
					}
				}
			}
			else
			{
				logger.debug("--------對["+request.getRequestURI()+"]進行校驗:無需校驗，跳過!");
			}
		}
		
		if(!flag)
		{
			
			String errMsg = null;
			if(SysConstant.LOGIN_ERROR_NOLOG.equals(falseType))
			{
				errMsg = "您還沒有登錄系統，請先登錄！";
			}
			else
			{
				errMsg = "您沒有權限使用該功能，請聯繫系統管理員！";
			}
			
			String targetUrl = null;
			
			//权限校验不通过，根据登录请求的地址返回到相关的登录页
			if(SysConstant.LOGIN_ERROR_NOLOG.equals(falseType))
			{
				//校验失败，需重新登錄，清理SESSION
				session.invalidate();
				targetUrl = request.getContextPath() + "/common/expired.jsp";
				response.sendRedirect(targetUrl);
			}
			else
			{
				//沒有權限訪問該資源，跳轉到報錯頁面
				String ajax = request.getHeader("x-requested-with");
				if(StringUtils.isNotEmpty(ajax))
				{
					//JSON请求
					response.setStatus(500);
					response.setCharacterEncoding("UTF-8");
					pw = response.getWriter();
					pw.write("您無權限訪問此功能");
					pw.flush();
				}
				else
				{
					//普通請求
					targetUrl = request.getContextPath() + "/error/gotoNoright.do";
					ErrorForm form = new ErrorForm();
					form.setErrMsg(errMsg);
					form.setTargetUrl(targetUrl);
					session.setAttribute(SysConstant.SESSION_KEY_ERROR, form);
					response.sendRedirect(targetUrl);
				}
			}
		}
		
		return flag;
	}
}
