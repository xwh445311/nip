package com.efs.bus.libary.controller;

/**
 * 
 * com.efs.bus.libary.controller.LibShelfInfoForm
 * @author xuwh
 * 2018-03-19 10:52:52
 * 书架信息表
 *
 */
public class LibShelfInfoForm
{
	/**
	 * 书架号
	 */
	private String lsNo;
	
	/**
	 * 书架层数
	 */
	private String lsRowCnt;
	
	/**
	 * 书架列数
	 */
	private String lsColCnt;
	
	/**
	 * 每列最大放书量
	 */
	private String lsMaxBookCnt;
	
	/**
	 * 书架使用状态：0未用，1在用
	 */
	private String lsUseStatus;
	
	/**
	 * 
	 */
	private String lsStarAddr;
	
	/**
	 * 
	 */
	private String lsEndAddr;
	
	/**
	 * 创建日期
	 */
	private String addDate;
	
	/**
	 * 创建时间
	 */
	private String addTime;
	
	/**
	 * 创建人
	 */
	private String addUser;
	
	/**
	 * 最后修改日期
	 */
	private String updDate;
	
	/**
	 * 最后修改时间
	 */
	private String updTime;
	
	/**
	 * 最后修改人
	 */
	private String updUser;
	
	
	/**
	 * 书架号<br/>
	 * @return String lsNo
	 */
	public String getLsNo()
	{
		return lsNo;
	}

	/**
	 * 书架号<br/>
	 * @param Integer lsNo
	 */
	public void setLsNo(String lsNo)
	{
		this.lsNo = lsNo;
	}
	
	/**
	 * 书架层数<br/>
	 * @return String lsRowCnt
	 */
	public String getLsRowCnt()
	{
		return lsRowCnt;
	}

	/**
	 * 书架层数<br/>
	 * @param Integer lsRowCnt
	 */
	public void setLsRowCnt(String lsRowCnt)
	{
		this.lsRowCnt = lsRowCnt;
	}
	
	/**
	 * 书架列数<br/>
	 * @return String lsColCnt
	 */
	public String getLsColCnt()
	{
		return lsColCnt;
	}

	/**
	 * 书架列数<br/>
	 * @param Integer lsColCnt
	 */
	public void setLsColCnt(String lsColCnt)
	{
		this.lsColCnt = lsColCnt;
	}
	
	/**
	 * 每列最大放书量<br/>
	 * @return String lsMaxBookCnt
	 */
	public String getLsMaxBookCnt()
	{
		return lsMaxBookCnt;
	}

	/**
	 * 每列最大放书量<br/>
	 * @param Integer lsMaxBookCnt
	 */
	public void setLsMaxBookCnt(String lsMaxBookCnt)
	{
		this.lsMaxBookCnt = lsMaxBookCnt;
	}
	
	/**
	 * 书架使用状态：0未用，1在用<br/>
	 * @return String lsUseStatus
	 */
	public String getLsUseStatus()
	{
		return lsUseStatus;
	}

	/**
	 * 书架使用状态：0未用，1在用<br/>
	 * @param String lsUseStatus
	 */
	public void setLsUseStatus(String lsUseStatus)
	{
		this.lsUseStatus = lsUseStatus;
	}
	
	/**
	 * <br/>
	 * @return String lsStarAddr
	 */
	public String getLsStarAddr()
	{
		return lsStarAddr;
	}

	/**
	 * <br/>
	 * @param String lsStarAddr
	 */
	public void setLsStarAddr(String lsStarAddr)
	{
		this.lsStarAddr = lsStarAddr;
	}
	
	/**
	 * <br/>
	 * @return String lsEndAddr
	 */
	public String getLsEndAddr()
	{
		return lsEndAddr;
	}

	/**
	 * <br/>
	 * @param String lsEndAddr
	 */
	public void setLsEndAddr(String lsEndAddr)
	{
		this.lsEndAddr = lsEndAddr;
	}
	
	/**
	 * 创建日期<br/>
	 * @return String addDate
	 */
	public String getAddDate()
	{
		return addDate;
	}

	/**
	 * 创建日期<br/>
	 * @param String addDate
	 */
	public void setAddDate(String addDate)
	{
		this.addDate = addDate;
	}
	
	/**
	 * 创建时间<br/>
	 * @return String addTime
	 */
	public String getAddTime()
	{
		return addTime;
	}

	/**
	 * 创建时间<br/>
	 * @param String addTime
	 */
	public void setAddTime(String addTime)
	{
		this.addTime = addTime;
	}
	
	/**
	 * 创建人<br/>
	 * @return String addUser
	 */
	public String getAddUser()
	{
		return addUser;
	}

	/**
	 * 创建人<br/>
	 * @param String addUser
	 */
	public void setAddUser(String addUser)
	{
		this.addUser = addUser;
	}
	
	/**
	 * 最后修改日期<br/>
	 * @return String updDate
	 */
	public String getUpdDate()
	{
		return updDate;
	}

	/**
	 * 最后修改日期<br/>
	 * @param String updDate
	 */
	public void setUpdDate(String updDate)
	{
		this.updDate = updDate;
	}
	
	/**
	 * 最后修改时间<br/>
	 * @return String updTime
	 */
	public String getUpdTime()
	{
		return updTime;
	}

	/**
	 * 最后修改时间<br/>
	 * @param String updTime
	 */
	public void setUpdTime(String updTime)
	{
		this.updTime = updTime;
	}
	
	/**
	 * 最后修改人<br/>
	 * @return String updUser
	 */
	public String getUpdUser()
	{
		return updUser;
	}

	/**
	 * 最后修改人<br/>
	 * @param String updUser
	 */
	public void setUpdUser(String updUser)
	{
		this.updUser = updUser;
	}
	
	
	@Override
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		
		sb.append("lsNo=" + lsNo).append("\n");
		sb.append("lsRowCnt=" + lsRowCnt).append("\n");
		sb.append("lsColCnt=" + lsColCnt).append("\n");
		sb.append("lsMaxBookCnt=" + lsMaxBookCnt).append("\n");
		sb.append("lsUseStatus=" + lsUseStatus).append("\n");
		sb.append("lsStarAddr=" + lsStarAddr).append("\n");
		sb.append("lsEndAddr=" + lsEndAddr).append("\n");
		sb.append("addDate=" + addDate).append("\n");
		sb.append("addTime=" + addTime).append("\n");
		sb.append("addUser=" + addUser).append("\n");
		sb.append("updDate=" + updDate).append("\n");
		sb.append("updTime=" + updTime).append("\n");
		sb.append("updUser=" + updUser).append("\n");
		return sb.toString();
	}
}
