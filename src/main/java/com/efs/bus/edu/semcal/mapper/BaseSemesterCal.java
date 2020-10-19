package com.efs.bus.edu.semcal.mapper;

import java.io.Serializable;

/**
 * 
 * com.efs.bus.edu.semcal.mapper.BaseSemesterCal
 * @author xwh
 * 2018-04-24 17:16:20
 * 学期日历
 *
 */
public class BaseSemesterCal implements Serializable
{
	/**
	 * 学期:201801表示18年春季学期，201802表示18年秋季学期
	 */
	private String scTerm;
	
	/**
	 * 学期描述:以中文对学期进行描述
	 */
	private String scTermDesc;
	
	/**
	 * 开学日期
	 */
	private String scStartDate;
	
	/**
	 * 放假日期
	 */
	private String scEndDate;
	
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

	private String scYear;

	private String scHalfYear;

	private String hasClass;


	public String getHasClass()
	{
		return hasClass;
	}

	public void setHasClass(String hasClass)
	{
		this.hasClass = hasClass;
	}

	/**
	 * 学期:201801表示18年春季学期，201802表示18年秋季学期<br/>
	 * @return String scTerm
	 */
	public String getScTerm()
	{
		return scTerm;
	}

	/**
	 * 学期:201801表示18年春季学期，201802表示18年秋季学期<br/>
	 * @param String scTerm
	 */
	public void setScTerm(String scTerm)
	{
		this.scTerm = scTerm;
	}
	
	/**
	 * 学期描述:以中文对学期进行描述<br/>
	 * @return String scTermDesc
	 */
	public String getScTermDesc()
	{
		return scTermDesc;
	}

	/**
	 * 学期描述:以中文对学期进行描述<br/>
	 * @param String scTermDesc
	 */
	public void setScTermDesc(String scTermDesc)
	{
		this.scTermDesc = scTermDesc;
	}
	
	/**
	 * 开学日期<br/>
	 * @return String scStartDate
	 */
	public String getScStartDate()
	{
		return scStartDate;
	}

	/**
	 * 开学日期<br/>
	 * @param String scStartDate
	 */
	public void setScStartDate(String scStartDate)
	{
		this.scStartDate = scStartDate;
	}
	
	/**
	 * 放假日期<br/>
	 * @return String scEndDate
	 */
	public String getScEndDate()
	{
		return scEndDate;
	}

	/**
	 * 放假日期<br/>
	 * @param String scEndDate
	 */
	public void setScEndDate(String scEndDate)
	{
		this.scEndDate = scEndDate;
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

	public String getScYear()
	{
		return scYear;
	}

	public void setScYear(String scYear)
	{
		this.scYear = scYear;
	}

	public String getScHalfYear()
	{
		return scHalfYear;
	}

	public void setScHalfYear(String scHalfYear)
	{
		this.scHalfYear = scHalfYear;
	}

	@Override
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		
		sb.append("scTerm=" + scTerm).append("\n");
		sb.append("scTermDesc=" + scTermDesc).append("\n");
		sb.append("scStartDate=" + scStartDate).append("\n");
		sb.append("scEndDate=" + scEndDate).append("\n");
		sb.append("addDate=" + addDate).append("\n");
		sb.append("addTime=" + addTime).append("\n");
		sb.append("addUser=" + addUser).append("\n");
		sb.append("updDate=" + updDate).append("\n");
		sb.append("updTime=" + updTime).append("\n");
		sb.append("updUser=" + updUser).append("\n");
		return sb.toString();
	}
}
