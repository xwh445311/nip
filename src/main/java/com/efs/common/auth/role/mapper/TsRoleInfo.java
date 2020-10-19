package com.efs.common.auth.role.mapper;

import java.io.Serializable;
import java.util.List;

/**
 * 
 * com.efs.common.auth.role.mapper.TsRoleInfo
 * @author xwh
 * 2017-06-21 23:24:56
 * 系统角色表
 *
 */
public class TsRoleInfo implements Serializable
{
	/**
	 * 角色ID
	 */
	private String riId;
	
	/**
	 * 角色名称
	 */
	private String riName;
	
	/**
	 * 角色状态
	 */
	private String riStatus;

	/**
	 * 是否為超級角色(1:是，0：否)
	 */
	private String riIsSuper;
	
	/**
	 * 角色创建日期
	 */
	private String riAddDate;
	
	/**
	 * 角色创建时间
	 */
	private String riAddTime;
	
	/**
	 * 角色创建人ID
	 */
	private String riAddUser;

	/**
	 * 对应的功能IDS
	 */
	private List<String> funcList;

	private String isSuperUser;

	public String getIsSuperUser()
	{
		return isSuperUser;
	}

	public void setIsSuperUser(String isSuperUser)
	{
		this.isSuperUser = isSuperUser;
	}

	public String getRiIsSuper()
	{
		return riIsSuper;
	}

	public void setRiIsSuper(String riIsSuper)
	{
		this.riIsSuper = riIsSuper;
	}

	public List<String> getFuncList()
	{
		return funcList;
	}

	public void setFuncList(List<String> funcList)
	{
		this.funcList = funcList;
	}

	/**
	 * 角色ID<br/>
	 * @return String riId
	 */
	public String getRiId()
	{
		return riId;
	}

	/**
	 * 角色ID<br/>
	 * @param String riId
	 */
	public void setRiId(String riId)
	{
		this.riId = riId;
	}
	
	/**
	 * 角色名称<br/>
	 * @return String riName
	 */
	public String getRiName()
	{
		return riName;
	}

	/**
	 * 角色名称<br/>
	 * @param String riName
	 */
	public void setRiName(String riName)
	{
		this.riName = riName;
	}
	
	/**
	 * 角色状态<br/>
	 * @return String riStatus
	 */
	public String getRiStatus()
	{
		return riStatus;
	}

	/**
	 * 角色状态<br/>
	 * @param String riStatus
	 */
	public void setRiStatus(String riStatus)
	{
		this.riStatus = riStatus;
	}
	
	/**
	 * 角色创建日期<br/>
	 * @return String riAddDate
	 */
	public String getRiAddDate()
	{
		return riAddDate;
	}

	/**
	 * 角色创建日期<br/>
	 * @param String riAddDate
	 */
	public void setRiAddDate(String riAddDate)
	{
		this.riAddDate = riAddDate;
	}
	
	/**
	 * 角色创建时间<br/>
	 * @return String riAddTime
	 */
	public String getRiAddTime()
	{
		return riAddTime;
	}

	/**
	 * 角色创建时间<br/>
	 * @param String riAddTime
	 */
	public void setRiAddTime(String riAddTime)
	{
		this.riAddTime = riAddTime;
	}
	
	/**
	 * 角色创建人ID<br/>
	 * @return String riAddUser
	 */
	public String getRiAddUser()
	{
		return riAddUser;
	}

	/**
	 * 角色创建人ID<br/>
	 * @param String riAddUser
	 */
	public void setRiAddUser(String riAddUser)
	{
		this.riAddUser = riAddUser;
	}
	
	
	@Override
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		
		sb.append("riId=" + riId).append("\n");
		sb.append("riName=" + riName).append("\n");
		sb.append("riStatus=" + riStatus).append("\n");
		sb.append("riAddDate=" + riAddDate).append("\n");
		sb.append("riAddTime=" + riAddTime).append("\n");
		sb.append("riAddUser=" + riAddUser).append("\n");
		return sb.toString();
	}
}
