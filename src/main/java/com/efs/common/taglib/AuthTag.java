package com.efs.common.taglib;


import com.efs.common.Util.SysConstant;
import com.efs.common.auth.user.mapper.TsUserInfo;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;

/**
 * 自定义权限标签库
 * @author xwh
 *
 */
public class AuthTag extends SimpleTagSupport
{
	
	private static Log logger = LogFactory.getLog(AuthTag.class);
	private String srcId;

	/* (non-Javadoc)
	 * @see javax.servlet.jsp.tagext.SimpleTagSupport#doTag()
	 */
	@Override
	public void doTag() throws JspException, IOException
	{
		try
		{
			PageContext pageContext = (PageContext)getJspContext();
			HttpSession session = pageContext.getSession();
			if(doCheck(session))
			{
				getJspBody().invoke(null);
			}
		} catch (Exception e)
		{
			throw new RuntimeException(e);
		}
		
	}

	private boolean doCheck(HttpSession session) throws Exception
	{
		if(StringUtils.isEmpty(srcId))
		{
			//没有指定资源ID，认为校验通过
			return true;
		}
		
		if(null == session.getAttribute(SysConstant.SESSION_KEY_SYSUSER))
		{
			//没有登录
			return false;
		}
		else
		{
			TsUserInfo user = (TsUserInfo)session.getAttribute(SysConstant.SESSION_KEY_SYSUSER);
			
			//己有明确的权限要求，需要对权限进行校验
			if(user.getUserFuncIdList() == null || !user.getUserFuncIdList().contains(srcId))
			{
				logger.debug("--------對TAG["+srcId+"]進行校驗:失敗，沒有權限,用户ID为["+user.getUiId()+"]");
				return false;
			}
			else
			{
				logger.debug("--------對TAG["+srcId+"]進行校驗:成功,用户ID为["+user.getUiId()+"]");
				return true;
			}
		}
	}

	/**
	 * @return the srcId
	 */
	public String getSrcId()
	{
		return srcId;
	}

	/**
	 * @param srcId the srcId to set
	 */
	public void setSrcId(String srcId)
	{
		this.srcId = srcId;
	}
	
	
	
}
