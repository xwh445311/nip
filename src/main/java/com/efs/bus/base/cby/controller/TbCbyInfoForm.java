package com.efs.bus.base.cby.controller;

/**
 * 
 * com.efs.bus.base.cby.controller.TbCbyInfoForm
 * @author xuwh
 * 2020-05-24 21:47:25
 * 抄表员信息
 *
 */
public class TbCbyInfoForm
{
	/**
	 * 主键ID
	 */
	private String dbId;
	
	/**
	 * 公司编号
	 */
	private String gsNo;
	
	/**
	 * 抄表员ID
	 */
	private String cbyId;
	
	/**
	 * 1有效，0无效
	 */
	private String status;
	
	
	/**
	 * 主键ID<br/>
	 * @return String dbId
	 */
	public String getDbId()
	{
		return dbId;
	}

	/**
	 * 主键ID<br/>
	 * @param String dbId
	 */
	public void setDbId(String dbId)
	{
		this.dbId = dbId;
	}
	
	/**
	 * 公司编号<br/>
	 * @return String gsNo
	 */
	public String getGsNo()
	{
		return gsNo;
	}

	/**
	 * 公司编号<br/>
	 * @param String gsNo
	 */
	public void setGsNo(String gsNo)
	{
		this.gsNo = gsNo;
	}
	
	/**
	 * 抄表员ID<br/>
	 * @return String cbyId
	 */
	public String getCbyId()
	{
		return cbyId;
	}

	/**
	 * 抄表员ID<br/>
	 * @param String cbyId
	 */
	public void setCbyId(String cbyId)
	{
		this.cbyId = cbyId;
	}
	
	/**
	 * 1有效，0无效<br/>
	 * @return String status
	 */
	public String getStatus()
	{
		return status;
	}

	/**
	 * 1有效，0无效<br/>
	 * @param String status
	 */
	public void setStatus(String status)
	{
		this.status = status;
	}
	
	
	@Override
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		
		sb.append("dbId=" + dbId).append("\n");
		sb.append("gsNo=" + gsNo).append("\n");
		sb.append("cbyId=" + cbyId).append("\n");
		sb.append("status=" + status).append("\n");
		return sb.toString();
	}
}
