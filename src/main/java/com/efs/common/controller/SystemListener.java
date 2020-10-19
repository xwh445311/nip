package com.efs.common.controller;

import com.efs.common.Util.MyBeanUtils;
import com.efs.common.Util.SysConstant;
import com.xwh.util.SysDBParamLoader;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.util.Map;

public class SystemListener implements ServletContextListener
{
	
	private static Log logger = LogFactory.getLog(SystemListener.class);

	/* (non-Javadoc)
	 * @see javax.servlet.ServletContextListener#contextDestroyed(javax.servlet.ServletContextEvent)
	 */
	@Override
	public void contextDestroyed(ServletContextEvent arg0)
	{
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see javax.servlet.ServletContextListener#contextInitialized(javax.servlet.ServletContextEvent)
	 */
	@Override
	public void contextInitialized(ServletContextEvent arg0)
	{
		logger.info("======开始加载系统参数======");
		try
		{
			//初始化BEAN UTILS转换器
			MyBeanUtils.initConvert();

			//初始化系统参数
			logger.info("******开始初始化数据库参数表");
			SysDBParamLoader.initParam();
			logger.info("******成功初始化数据库参数表");

			//将参数信息装载到APPLICATION中
			ServletContext app = arg0.getServletContext();
			Map<String,Map<String,Object>> allMap = SysDBParamLoader.getAllParamMap();
			for (String key : allMap.keySet())
			{
				app.setAttribute(key, allMap.get(key));
			}
			
			//初始化系统根路径地址
			SysConstant.SYSTEM_ROOT_FULL_PATH = arg0.getServletContext().getRealPath("/");
			SysConstant.SYSTEM_MODEL_PATH = SysConstant.SYSTEM_ROOT_FULL_PATH + "model\\";
			SysConstant.SYSTEM_ROOT_URL_PATH = arg0.getServletContext().getContextPath();
			logger.info("***********************WEB应用根路径" + SysConstant.SYSTEM_ROOT_FULL_PATH);
			logger.info("***********************WEB应用模板根路径" + SysConstant.SYSTEM_MODEL_PATH);
			logger.info("***********************WEB应用URL根路径" + SysConstant.SYSTEM_ROOT_URL_PATH);
		} catch (Exception e)
		{
			logger.error("======加载系统参数出错",e);
			throw new RuntimeException(e);
		}
		logger.info("======结束加载系统参数======");
	}
	
}
