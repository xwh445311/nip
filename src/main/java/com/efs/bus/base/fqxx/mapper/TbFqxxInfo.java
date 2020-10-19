package com.efs.bus.base.fqxx.mapper;

/**
 * 
 * com.efs.bus.base.fqxx.mapper.TbFqxxInfo
 * @author xuwh
 * 2020-05-10 22:31:27
 * 分区信息表
 *
 */
public class TbFqxxInfo
{
	/**
	 * 区域ID
	 */
	private String qyId;
	
	/**
	 * 公司信息
	 */
	private String qyOrgId;

	/**
	 * 公司名称
	 */
	private String qyOrgName;
	
	/**
	 * 区域名称
	 */
	private String qyName;
	
	/**
	 * 1:有效，0无效
	 */
	private String qyStatus;
	
	
	/**
	 * 区域ID<br/>
	 * @return String qyId
	 */
	public String getQyId()
	{
		return qyId;
	}

	/**
	 * 区域ID<br/>
	 * @param String qyId
	 */
	public void setQyId(String qyId)
	{
		this.qyId = qyId;
	}
	
	/**
	 * 公司信息<br/>
	 * @return String qyOrgId
	 */
	public String getQyOrgId()
	{
		return qyOrgId;
	}

	/**
	 * 公司信息<br/>
	 * @param String qyOrgId
	 */
	public void setQyOrgId(String qyOrgId)
	{
		this.qyOrgId = qyOrgId;
	}
	
	/**
	 * 区域名称<br/>
	 * @return String qyName
	 */
	public String getQyName()
	{
		return qyName;
	}

	/**
	 * 区域名称<br/>
	 * @param String qyName
	 */
	public void setQyName(String qyName)
	{
		this.qyName = qyName;
	}
	
	/**
	 * 1:有效，0无效<br/>
	 * @return String qyStatus
	 */
	public String getQyStatus()
	{
		return qyStatus;
	}

	/**
	 * 1:有效，0无效<br/>
	 * @param String qyStatus
	 */
	public void setQyStatus(String qyStatus)
	{
		this.qyStatus = qyStatus;
	}

	public String getQyOrgName()
	{
		return qyOrgName;
	}

	public void setQyOrgName(String qyOrgName)
	{
		this.qyOrgName = qyOrgName;
	}

	@Override
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		
		sb.append("qyId=" + qyId).append("\n");
		sb.append("qyOrgId=" + qyOrgId).append("\n");
		sb.append("qyName=" + qyName).append("\n");
		sb.append("qyStatus=" + qyStatus).append("\n");
		return sb.toString();
	}
}
