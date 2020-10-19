package com.efs.common.noteinfo.mapper;

/**
 * 
 * com.efs.common.noteinfo.mapper.TsNoteInfo
 * @author xwh
 * 2017-08-30 17:22:24
 * 系统消息表
 *
 */
public class TsNoteInfo
{
	/**
	 * 消息ID
	 */
	private String ntId;
	
	/**
	 * 消息头
	 */
	private String ntHead;
	
	/**
	 * 消息内容
	 */
	private String ntContent;
	
	/**
	 * 发布人
	 */
	private String ntSendUser;
	
	/**
	 * 发布日期
	 */
	private String ntSendDate;
	
	/**
	 * 发布时间
	 */
	private String ntSendTime;
	
	/**
	 * 消息状态:1已读，0：未读
	 */
	private String ntStatus;

	/**
	 * 阅读人
	 */
	private String ntReadUser;

	/**
	 * 消息发布到现在截至天数
	 */
	private int readDiffDay;

	/**
	 * 消息发布到现在截至小时
	 */
	private int readDiffH;

	/**
	 * 消息发布到现在截至分钟
	 */
	private int readDiffM;

	/**
	 * 在页面上显示的时间值
	 */
	private String showDiff;

	public String getNtReadUser()
	{
		return ntReadUser;
	}

	public void setNtReadUser(String ntReadUser)
	{
		this.ntReadUser = ntReadUser;
	}

	/**
	 * 消息ID<br/>
	 * @return String ntId
	 */
	public String getNtId()
	{
		return ntId;
	}

	/**
	 * 消息ID<br/>
	 * @param String ntId
	 */
	public void setNtId(String ntId)
	{
		this.ntId = ntId;
	}
	
	/**
	 * 消息头<br/>
	 * @return String ntHead
	 */
	public String getNtHead()
	{
		return ntHead;
	}

	/**
	 * 消息头<br/>
	 * @param String ntHead
	 */
	public void setNtHead(String ntHead)
	{
		this.ntHead = ntHead;
	}
	
	/**
	 * 消息内容<br/>
	 * @return String ntContent
	 */
	public String getNtContent()
	{
		return ntContent;
	}

	/**
	 * 消息内容<br/>
	 * @param String ntContent
	 */
	public void setNtContent(String ntContent)
	{
		this.ntContent = ntContent;
	}
	
	/**
	 * 发布人<br/>
	 * @return String ntSendUser
	 */
	public String getNtSendUser()
	{
		return ntSendUser;
	}

	/**
	 * 发布人<br/>
	 * @param String ntSendUser
	 */
	public void setNtSendUser(String ntSendUser)
	{
		this.ntSendUser = ntSendUser;
	}
	
	/**
	 * 发布日期<br/>
	 * @return String ntSendDate
	 */
	public String getNtSendDate()
	{
		return ntSendDate;
	}

	/**
	 * 发布日期<br/>
	 * @param String ntSendDate
	 */
	public void setNtSendDate(String ntSendDate)
	{
		this.ntSendDate = ntSendDate;
	}
	
	/**
	 * 发布时间<br/>
	 * @return String ntSendTime
	 */
	public String getNtSendTime()
	{
		return ntSendTime;
	}

	/**
	 * 发布时间<br/>
	 * @param String ntSendTime
	 */
	public void setNtSendTime(String ntSendTime)
	{
		this.ntSendTime = ntSendTime;
	}
	
	/**
	 * 消息状态:1已读，0：未读<br/>
	 * @return String ntStatus
	 */
	public String getNtStatus()
	{
		return ntStatus;
	}

	/**
	 * 消息状态:1已读，0：未读<br/>
	 * @param String ntStatus
	 */
	public void setNtStatus(String ntStatus)
	{
		this.ntStatus = ntStatus;
	}

	public int getReadDiffDay()
	{
		return readDiffDay;
	}

	public void setReadDiffDay(int readDiffDay)
	{
		this.readDiffDay = readDiffDay;
	}

	public int getReadDiffH()
	{
		return readDiffH;
	}

	public void setReadDiffH(int readDiffH)
	{
		this.readDiffH = readDiffH;
	}

	public int getReadDiffM()
	{
		return readDiffM;
	}

	public void setReadDiffM(int readDiffM)
	{
		this.readDiffM = readDiffM;
	}

	public String getShowDiff()
	{

		if(readDiffDay > 0)
		{
			showDiff = readDiffDay + " 天";
		}
		else if(readDiffH > 0)
		{
			showDiff = readDiffH + " 小時";
		}
		else
		{
			showDiff = readDiffM + " 分鐘";
		}

		return showDiff;
	}

	@Override
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		
		sb.append("ntId=" + ntId).append("\n");
		sb.append("ntHead=" + ntHead).append("\n");
		sb.append("ntContent=" + ntContent).append("\n");
		sb.append("ntSendUser=" + ntSendUser).append("\n");
		sb.append("ntSendDate=" + ntSendDate).append("\n");
		sb.append("ntSendTime=" + ntSendTime).append("\n");
		sb.append("ntStatus=" + ntStatus).append("\n");
		return sb.toString();
	}
}
