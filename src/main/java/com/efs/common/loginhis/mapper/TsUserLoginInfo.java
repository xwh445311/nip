package com.efs.common.loginhis.mapper;

/**
 * 
 * com.efs.bus.loginhis.mapper.TsUserLoginInfo
 * @author xwh
 * 2017-06-23 09:34:15
 * 用户登录日志表
 *
 */
public class TsUserLoginInfo
{
	/**
	 * 主键ID
	 */
	private Long ulDbId;
	
	/**
	 * 登录用户ID
	 */
	private String ulUserId;
	
	/**
	 * 登录用户IP
	 */
	private String ulLoginIp;

	private String ulLoginDate;
	
	/**
	 * 登录时间
	 */
	private String ulLoginTime;

	/**
	 * 浏览器版本
	 */
	private String ulExploreVersion;

	public String getUlLoginDate()
	{
		return ulLoginDate;
	}

	public void setUlLoginDate(String ulLoginDate)
	{
		this.ulLoginDate = ulLoginDate;
	}

	public String getUlExploreVersion()
	{
		return ulExploreVersion;
	}

	public void setUlExploreVersion(String ulExploreVersion)
	{
		this.ulExploreVersion = ulExploreVersion;
	}

	/**
	 * 主键ID<br/>
	 * @return Long ulDbId
	 */
	public Long getUlDbId()
	{
		return ulDbId;
	}

	/**
	 * 主键ID<br/>
	 * @param Long ulDbId
	 */
	public void setUlDbId(Long ulDbId)
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
