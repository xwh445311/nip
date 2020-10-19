package com.efs.common.loginhis.controller;

/**
 * 
 * com.efs.bus.loginhis.controller.TsUserLoginInfoForm
 * @author xwh
 * 2017-06-23 09:34:15
 * 用户登录日志表
 *
 */
public class TsUserLoginInfoForm
{
	/**
	 * 主键ID
	 */
	private String ulDbId;
	
	/**
	 * 登录用户ID
	 */
	private String ulUserId;
	
	/**
	 * 登录用户IP
	 */
	private String ulLoginIp;
	
	/**
	 * 登录时间
	 */
	private String ulLoginTime;
	
	
	/**
	 * 主键ID<br/>
	 * @return String ulDbId
	 */
	public String getUlDbId()
	{
		return ulDbId;
	}

	/**
	 * 主键ID<br/>
	 * @param Long ulDbId
	 */
	public void setUlDbId(String ulDbId)
	{
		this.ulDbId = ulDbId;
	}
	
	/**
	 * 登录用户ID<br/>
	 * @return String ulUserId
	 */
	public String getUlUserId()
	{
		return ulUserId;
	}

	/**
	 * 登录用户ID<br/>
	 * @param String ulUserId
	 */
	public void setUlUserId(String ulUserId)
	{
		this.ulUserId = ulUserId;
	}
	
	/**
	 * 登录用户IP<br/>
	 * @return String ulLoginIp
	 */
	public String getUlLoginIp()
	{
		return ulLoginIp;
	}

	/**
	 * 登录用户IP<br/>
	 * @param String ulLoginIp
	 */
	public void setUlLoginIp(String ulLoginIp)
	{
		this.ulLoginIp = ulLoginIp;
	}
	
	/**
	 * 登录时间<br/>
	 * @return String ulLoginTime
	 */
	public String getUlLoginTime()
	{
		return ulLoginTime;
	}

	/**
	 * 登录时间<br/>
	 * @param String ulLoginTime
	 */
	public void setUlLoginTime(String ulLoginTime)
	{
		this.ulLoginTime = ulLoginTime;
	}
	
	
	@Override
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		
		sb.append("ulDbId=" + ulDbId).append("\n");
		sb.append("ulUserId=" + ulUserId).append("\n");
		sb.append("ulLoginIp=" + ulLoginIp).append("\n");
		sb.append("ulLoginTime=" + ulLoginTime).append("\n");
		return sb.toString();
	}
}
