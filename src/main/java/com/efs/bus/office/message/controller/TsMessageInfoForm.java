package com.efs.bus.office.message.controller;

/**
 * 
 * com.efs.bus.office.message.controller.TsMessageInfoForm
 * @author xwh
 * 2018-05-24 13:41:27
 * 系统通知消息表
 *
 */
public class TsMessageInfoForm
{
	/**
	 * 消息ID
	 */
	private String miCode;
	
	/**
	 * 消息发布单位
	 */
	private String miIssueDept;
	
	/**
	 * 消息发布人
	 */
	private String miIssueUser;
	
	/**
	 * 消息发布人姓名
	 */
	private String miIssueUserNm;
	
	/**
	 * 消息类型:01内部消息，02系统所有人员
	 */
	private String miType;
	
	/**
	 * 消息标题
	 */
	private String miTitle;
	
	/**
	 * 消息正文
	 */
	private String miContent;
	
	/**
	 * 消息紧急程度
	 */
	private String miLvl;
	
	/**
	 * 附件ID
	 */
	private String miFileIds;
	
	/**
	 * 消息发布日期
	 */
	private String miIssueDate;
	
	/**
	 * 消息发布时间
	 */
	private String miIssueTime;

	/**
	 * 是否删除附件
	 */
	private String delFile;

	public String getDelFile()
	{
		return delFile;
	}

	public void setDelFile(String delFile)
	{
		this.delFile = delFile;
	}

	/**
	 * 消息ID<br/>
	 * @return String miCode
	 */
	public String getMiCode()
	{
		return miCode;
	}

	/**
	 * 消息ID<br/>
	 * @param String miCode
	 */
	public void setMiCode(String miCode)
	{
		this.miCode = miCode;
	}
	
	/**
	 * 消息发布单位<br/>
	 * @return String miIssueDept
	 */
	public String getMiIssueDept()
	{
		return miIssueDept;
	}

	/**
	 * 消息发布单位<br/>
	 * @param String miIssueDept
	 */
	public void setMiIssueDept(String miIssueDept)
	{
		this.miIssueDept = miIssueDept;
	}
	
	/**
	 * 消息发布人<br/>
	 * @return String miIssueUser
	 */
	public String getMiIssueUser()
	{
		return miIssueUser;
	}

	/**
	 * 消息发布人<br/>
	 * @param String miIssueUser
	 */
	public void setMiIssueUser(String miIssueUser)
	{
		this.miIssueUser = miIssueUser;
	}
	
	/**
	 * 消息发布人姓名<br/>
	 * @return String miIssueUserNm
	 */
	public String getMiIssueUserNm()
	{
		return miIssueUserNm;
	}

	/**
	 * 消息发布人姓名<br/>
	 * @param String miIssueUserNm
	 */
	public void setMiIssueUserNm(String miIssueUserNm)
	{
		this.miIssueUserNm = miIssueUserNm;
	}
	
	/**
	 * 消息类型:01内部消息，02系统所有人员<br/>
	 * @return String miType
	 */
	public String getMiType()
	{
		return miType;
	}

	/**
	 * 消息类型:01内部消息，02系统所有人员<br/>
	 * @param String miType
	 */
	public void setMiType(String miType)
	{
		this.miType = miType;
	}
	
	/**
	 * 消息标题<br/>
	 * @return String miTitle
	 */
	public String getMiTitle()
	{
		return miTitle;
	}

	/**
	 * 消息标题<br/>
	 * @param String miTitle
	 */
	public void setMiTitle(String miTitle)
	{
		this.miTitle = miTitle;
	}
	
	/**
	 * 消息正文<br/>
	 * @return String miContent
	 */
	public String getMiContent()
	{
		return miContent;
	}

	/**
	 * 消息正文<br/>
	 * @param String miContent
	 */
	public void setMiContent(String miContent)
	{
		this.miContent = miContent;
	}
	
	/**
	 * 消息紧急程度<br/>
	 * @return String miLvl
	 */
	public String getMiLvl()
	{
		return miLvl;
	}

	/**
	 * 消息紧急程度<br/>
	 * @param String miLvl
	 */
	public void setMiLvl(String miLvl)
	{
		this.miLvl = miLvl;
	}
	
	/**
	 * 附件ID<br/>
	 * @return String miFileIds
	 */
	public String getMiFileIds()
	{
		return miFileIds;
	}

	/**
	 * 附件ID<br/>
	 * @param String miFileIds
	 */
	public void setMiFileIds(String miFileIds)
	{
		this.miFileIds = miFileIds;
	}
	
	/**
	 * 消息发布日期<br/>
	 * @return String miIssueDate
	 */
	public String getMiIssueDate()
	{
		return miIssueDate;
	}

	/**
	 * 消息发布日期<br/>
	 * @param String miIssueDate
	 */
	public void setMiIssueDate(String miIssueDate)
	{
		this.miIssueDate = miIssueDate;
	}
	
	/**
	 * 消息发布时间<br/>
	 * @return String miIssueTime
	 */
	public String getMiIssueTime()
	{
		return miIssueTime;
	}

	/**
	 * 消息发布时间<br/>
	 * @param String miIssueTime
	 */
	public void setMiIssueTime(String miIssueTime)
	{
		this.miIssueTime = miIssueTime;
	}
	
	
	@Override
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		
		sb.append("miCode=" + miCode).append("\n");
		sb.append("miIssueDept=" + miIssueDept).append("\n");
		sb.append("miIssueUser=" + miIssueUser).append("\n");
		sb.append("miIssueUserNm=" + miIssueUserNm).append("\n");
		sb.append("miType=" + miType).append("\n");
		sb.append("miTitle=" + miTitle).append("\n");
		sb.append("miContent=" + miContent).append("\n");
		sb.append("miLvl=" + miLvl).append("\n");
		sb.append("miFileIds=" + miFileIds).append("\n");
		sb.append("miIssueDate=" + miIssueDate).append("\n");
		sb.append("miIssueTime=" + miIssueTime).append("\n");
		return sb.toString();
	}
}
