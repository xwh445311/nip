package com.efs.bus.edu.classes.mapper;

import java.io.Serializable;

/**
 * 
 * com.efs.bus.edu.classes.mapper.BaseSchClassInfo
 * @author xwh
 * 2018-04-26 20:43:12
 * 学校班级设置信息表
 *
 */
public class BaseSchClassInfo implements Serializable
{
	/**
	 * 
	 */
	private Long scId;
	
	/**
	 * 
	 */
	private String scTerm;

	/**
	 * 学期描述
	 */
	private String scTermDesc;
	
	/**
	 * 班级编号
	 */
	private String scClassCode;
	
	/**
	 * 班级名称
	 */
	private String scClassName;
	
	/**
	 * 所属年级,计算列
	 */
	private Integer scGrade;
	
	/**
	 * 所属班级,计算列
	 */
	private Integer scCls;
	
	/**
	 * 班主任
	 */
	private String scLeader;
	
	/**
	 * 班主任名称,计算列
	 */
	private String scLeaderName;
	
	/**
	 * 审核状态
	 */
	private String ssChkStatus;
	
	/**
	 * 创建日期创
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
	 * 
	 */
	private String addUserName;
	
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
	 * 
	 */
	private String updUserName;
	
	/**
	 * 
	 */
	private String chkUser;
	
	/**
	 * 
	 */
	private String chkUserName;
	
	/**
	 * 
	 */
	private String chkDate;
	
	/**
	 * 
	 */
	private String chkTime;

	/**
	 * 每个年级的班级数量
	 */
	private int clsCnt;

	public int getClsCnt()
	{
		return clsCnt;
	}

	public void setClsCnt(int clsCnt)
	{
		this.clsCnt = clsCnt;
	}

	public String getScTermDesc()
	{
		return scTermDesc;
	}

	public void setScTermDesc(String scTermDesc)
	{
		this.scTermDesc = scTermDesc;
	}

	/**
	 * <br/>
	 * @return Long scId
	 */
	public Long getScId()
	{
		return scId;
	}

	/**
	 * <br/>
	 * @param Long scId
	 */
	public void setScId(Long scId)
	{
		this.scId = scId;
	}
	
	/**
	 * <br/>
	 * @return String scTerm
	 */
	public String getScTerm()
	{
		return scTerm;
	}

	/**
	 * <br/>
	 * @param String scTerm
	 */
	public void setScTerm(String scTerm)
	{
		this.scTerm = scTerm;
	}
	
	/**
	 * 班级编号<br/>
	 * @return String scClassCode
	 */
	public String getScClassCode()
	{
		return scClassCode;
	}

	/**
	 * 班级编号<br/>
	 * @param String scClassCode
	 */
	public void setScClassCode(String scClassCode)
	{
		this.scClassCode = scClassCode;
	}
	
	/**
	 * 班级名称<br/>
	 * @return String scClassName
	 */
	public String getScClassName()
	{
		return scClassName;
	}

	/**
	 * 班级名称<br/>
	 * @param String scClassName
	 */
	public void setScClassName(String scClassName)
	{
		this.scClassName = scClassName;
	}
	
	/**
	 * 所属年级,计算列<br/>
	 * @return Integer scGrade
	 */
	public Integer getScGrade()
	{
		return scGrade;
	}

	/**
	 * 所属年级,计算列<br/>
	 * @param Integer scGrade
	 */
	public void setScGrade(Integer scGrade)
	{
		this.scGrade = scGrade;
	}
	
	/**
	 * 所属班级,计算列<br/>
	 * @return Integer scCls
	 */
	public Integer getScCls()
	{
		return scCls;
	}

	/**
	 * 所属班级,计算列<br/>
	 * @param Integer scCls
	 */
	public void setScCls(Integer scCls)
	{
		this.scCls = scCls;
	}
	
	/**
	 * 班主任<br/>
	 * @return String scLeader
	 */
	public String getScLeader()
	{
		return scLeader;
	}

	/**
	 * 班主任<br/>
	 * @param String scLeader
	 */
	public void setScLeader(String scLeader)
	{
		this.scLeader = scLeader;
	}
	
	/**
	 * 班主任名称,计算列<br/>
	 * @return String scLeaderName
	 */
	public String getScLeaderName()
	{
		return scLeaderName;
	}

	/**
	 * 班主任名称,计算列<br/>
	 * @param String scLeaderName
	 */
	public void setScLeaderName(String scLeaderName)
	{
		this.scLeaderName = scLeaderName;
	}
	
	/**
	 * 审核状态<br/>
	 * @return String ssChkStatus
	 */
	public String getSsChkStatus()
	{
		return ssChkStatus;
	}

	/**
	 * 审核状态<br/>
	 * @param String ssChkStatus
	 */
	public void setSsChkStatus(String ssChkStatus)
	{
		this.ssChkStatus = ssChkStatus;
	}
	
	/**
	 * 创建日期创<br/>
	 * @return String addDate
	 */
	public String getAddDate()
	{
		return addDate;
	}

	/**
	 * 创建日期创<br/>
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
	 * <br/>
	 * @return String addUserName
	 */
	public String getAddUserName()
	{
		return addUserName;
	}

	/**
	 * <br/>
	 * @param String addUserName
	 */
	public void setAddUserName(String addUserName)
	{
		this.addUserName = addUserName;
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
	
	/**
	 * <br/>
	 * @return String updUserName
	 */
	public String getUpdUserName()
	{
		return updUserName;
	}

	/**
	 * <br/>
	 * @param String updUserName
	 */
	public void setUpdUserName(String updUserName)
	{
		this.updUserName = updUserName;
	}
	
	/**
	 * <br/>
	 * @return String chkUser
	 */
	public String getChkUser()
	{
		return chkUser;
	}

	/**
	 * <br/>
	 * @param String chkUser
	 */
	public void setChkUser(String chkUser)
	{
		this.chkUser = chkUser;
	}
	
	/**
	 * <br/>
	 * @return String chkUserName
	 */
	public String getChkUserName()
	{
		return chkUserName;
	}

	/**
	 * <br/>
	 * @param String chkUserName
	 */
	public void setChkUserName(String chkUserName)
	{
		this.chkUserName = chkUserName;
	}
	
	/**
	 * <br/>
	 * @return String chkDate
	 */
	public String getChkDate()
	{
		return chkDate;
	}

	/**
	 * <br/>
	 * @param String chkDate
	 */
	public void setChkDate(String chkDate)
	{
		this.chkDate = chkDate;
	}
	
	/**
	 * <br/>
	 * @return String chkTime
	 */
	public String getChkTime()
	{
		return chkTime;
	}

	/**
	 * <br/>
	 * @param String chkTime
	 */
	public void setChkTime(String chkTime)
	{
		this.chkTime = chkTime;
	}
	
	
	@Override
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		
		sb.append("scId=" + scId).append("\n");
		sb.append("scTerm=" + scTerm).append("\n");
		sb.append("scClassCode=" + scClassCode).append("\n");
		sb.append("scClassName=" + scClassName).append("\n");
		sb.append("scGrade=" + scGrade).append("\n");
		sb.append("scCls=" + scCls).append("\n");
		sb.append("scLeader=" + scLeader).append("\n");
		sb.append("scLeaderName=" + scLeaderName).append("\n");
		sb.append("ssChkStatus=" + ssChkStatus).append("\n");
		sb.append("addDate=" + addDate).append("\n");
		sb.append("addTime=" + addTime).append("\n");
		sb.append("addUser=" + addUser).append("\n");
		sb.append("addUserName=" + addUserName).append("\n");
		sb.append("updDate=" + updDate).append("\n");
		sb.append("updTime=" + updTime).append("\n");
		sb.append("updUser=" + updUser).append("\n");
		sb.append("updUserName=" + updUserName).append("\n");
		sb.append("chkUser=" + chkUser).append("\n");
		sb.append("chkUserName=" + chkUserName).append("\n");
		sb.append("chkDate=" + chkDate).append("\n");
		sb.append("chkTime=" + chkTime).append("\n");
		return sb.toString();
	}
}
