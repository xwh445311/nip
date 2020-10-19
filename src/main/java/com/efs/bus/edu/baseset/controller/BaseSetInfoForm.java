package com.efs.bus.edu.baseset.controller;

/**
 * 
 * com.efs.bus.edu.baseset.controller.BaseSetInfoForm
 * @author xwh
 * 2018-05-29 13:55:38
 * 基础信息设置记录表
 *
 */
public class BaseSetInfoForm
{
	/**
	 * 学期
	 */
	private String bsTerm;
	
	/**
	 * 设置人
	 */
	private String bsUser;
	
	/**
	 * 设置人姓名
	 */
	private String bsUserNm;
	
	/**
	 * 设置日期
	 */
	private String bsDate;
	
	/**
	 * 设置时间
	 */
	private String bsTime;
	
	
	/**
	 * 学期<br/>
	 * @return String bsTerm
	 */
	public String getBsTerm()
	{
		return bsTerm;
	}

	/**
	 * 学期<br/>
	 * @param String bsTerm
	 */
	public void setBsTerm(String bsTerm)
	{
		this.bsTerm = bsTerm;
	}
	
	/**
	 * 设置人<br/>
	 * @return String bsUser
	 */
	public String getBsUser()
	{
		return bsUser;
	}

	/**
	 * 设置人<br/>
	 * @param String bsUser
	 */
	public void setBsUser(String bsUser)
	{
		this.bsUser = bsUser;
	}
	
	/**
	 * 设置人姓名<br/>
	 * @return String bsUserNm
	 */
	public String getBsUserNm()
	{
		return bsUserNm;
	}

	/**
	 * 设置人姓名<br/>
	 * @param String bsUserNm
	 */
	public void setBsUserNm(String bsUserNm)
	{
		this.bsUserNm = bsUserNm;
	}
	
	/**
	 * 设置日期<br/>
	 * @return String bsDate
	 */
	public String getBsDate()
	{
		return bsDate;
	}

	/**
	 * 设置日期<br/>
	 * @param String bsDate
	 */
	public void setBsDate(String bsDate)
	{
		this.bsDate = bsDate;
	}
	
	/**
	 * 设置时间<br/>
	 * @return String bsTime
	 */
	public String getBsTime()
	{
		return bsTime;
	}

	/**
	 * 设置时间<br/>
	 * @param String bsTime
	 */
	public void setBsTime(String bsTime)
	{
		this.bsTime = bsTime;
	}
	
	
	@Override
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		
		sb.append("bsTerm=" + bsTerm).append("\n");
		sb.append("bsUser=" + bsUser).append("\n");
		sb.append("bsUserNm=" + bsUserNm).append("\n");
		sb.append("bsDate=" + bsDate).append("\n");
		sb.append("bsTime=" + bsTime).append("\n");
		return sb.toString();
	}
}
