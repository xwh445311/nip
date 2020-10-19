package com.efs.bus.lib.booksend.controller;

/**
 * 
 * com.efs.bus.lib.booksend.controller.LibInSendInfoForm
 * @author xwh
 * 2018-04-04 15:23:31
 * 在借图书信息表
 *
 */
public class LibInSendInfoForm
{
	/**
	 * 借阅流水号
	 */
	private String isId;
	
	/**
	 * 借书人ID
	 */
	private String isUserId;
	
	/**
	 * 图书编码
	 */
	private String isBookCode;
	
	/**
	 * 借书处理人
	 */
	private String isSendHandler;
	
	/**
	 * 借书日期
	 */
	private String isStartDate;

	/**
	 * 00：已还，01：在借，02：挂失，03：已赔
	 */
	private String isSendStatus;
	
	/**
	 * 借书时间
	 */
	private String isStartTime;
	
	/**
	 * 计划归还日期
	 */
	private String isPlanBackDate;
	
	/**
	 * 超期时长，计算列
	 */
	private String isOverdueLong;

	/**
	 * 丢失登记人
	 */
	private String blRegUser;

	/**
	 * 丢失登记日期
	 */
	private String blRegDate;

	/**
	 * 丢失登记时间
	 */
	private String biRegTime;

	/**
	 * 挂失备注
	 */
	private String biRegCommon;

	/**
	 * 待赔偿金额
	 */
	private String biPlanCompAmt;

	/**
	 * 赔偿方式:01价格赔偿，02：新书替换，03：找回
	 */
	private String biCompType;

	/**
	 * 赔偿图书ID
	 */
	private String blCompBookCode;

	/**
	 * 赔偿处理人
	 */
	private String blCompHandler;

	/**
	 * 赔偿处理日期
	 */
	private String blCompDate;

	/**
	 * 赔偿处理时间
	 */
	private String blCompTime;

	/**
	 * 实际赔偿金额
	 */
	private String blCompAmt;

	/**
	 *	赔偿备注
	 */
	private String blCommon;

	/**
	 * 超期状态
	 */
	private String isOverStatus;

	private String biName;

	public String getBiName()
	{
		return biName;
	}

	public void setBiName(String biName)
	{
		this.biName = biName;
	}

	public String getIsSendStatus()
	{
		return isSendStatus;
	}

	public void setIsSendStatus(String isSendStatus)
	{
		this.isSendStatus = isSendStatus;
	}

	public String getIsOverStatus()
	{
		return isOverStatus;
	}

	public void setIsOverStatus(String isOverStatus)
	{
		this.isOverStatus = isOverStatus;
	}

	public String getBlRegUser()
	{
		return blRegUser;
	}

	public void setBlRegUser(String blRegUser)
	{
		this.blRegUser = blRegUser;
	}

	public String getBlRegDate()
	{
		return blRegDate;
	}

	public void setBlRegDate(String blRegDate)
	{
		this.blRegDate = blRegDate;
	}

	public String getBiRegTime()
	{
		return biRegTime;
	}

	public void setBiRegTime(String biRegTime)
	{
		this.biRegTime = biRegTime;
	}

	public String getBiRegCommon()
	{
		return biRegCommon;
	}

	public void setBiRegCommon(String biRegCommon)
	{
		this.biRegCommon = biRegCommon;
	}

	public String getBiPlanCompAmt()
	{
		return biPlanCompAmt;
	}

	public void setBiPlanCompAmt(String biPlanCompAmt)
	{
		this.biPlanCompAmt = biPlanCompAmt;
	}

	public String getBiCompType()
	{
		return biCompType;
	}

	public void setBiCompType(String biCompType)
	{
		this.biCompType = biCompType;
	}

	public String getBlCompBookCode()
	{
		return blCompBookCode;
	}

	public void setBlCompBookCode(String blCompBookCode)
	{
		this.blCompBookCode = blCompBookCode;
	}

	public String getBlCompHandler()
	{
		return blCompHandler;
	}

	public void setBlCompHandler(String blCompHandler)
	{
		this.blCompHandler = blCompHandler;
	}

	public String getBlCompDate()
	{
		return blCompDate;
	}

	public void setBlCompDate(String blCompDate)
	{
		this.blCompDate = blCompDate;
	}

	public String getBlCompTime()
	{
		return blCompTime;
	}

	public void setBlCompTime(String blCompTime)
	{
		this.blCompTime = blCompTime;
	}

	public String getBlCompAmt()
	{
		return blCompAmt;
	}

	public void setBlCompAmt(String blCompAmt)
	{
		this.blCompAmt = blCompAmt;
	}

	public String getBlCommon()
	{
		return blCommon;
	}

	public void setBlCommon(String blCommon)
	{
		this.blCommon = blCommon;
	}

	/**
	 * 借阅流水号<br/>
	 * @return String isId
	 */
	public String getIsId()
	{
		return isId;
	}

	/**
	 * 借阅流水号<br/>
	 * @param BigDecimal isId
	 */
	public void setIsId(String isId)
	{
		this.isId = isId;
	}
	
	/**
	 * 借书人ID<br/>
	 * @return String isUserId
	 */
	public String getIsUserId()
	{
		return isUserId;
	}

	/**
	 * 借书人ID<br/>
	 * @param String isUserId
	 */
	public void setIsUserId(String isUserId)
	{
		this.isUserId = isUserId;
	}
	
	/**
	 * 图书编码<br/>
	 * @return String isBookCode
	 */
	public String getIsBookCode()
	{
		return isBookCode;
	}

	/**
	 * 图书编码<br/>
	 * @param String isBookCode
	 */
	public void setIsBookCode(String isBookCode)
	{
		this.isBookCode = isBookCode;
	}
	
	/**
	 * 借书处理人<br/>
	 * @return String isSendHandler
	 */
	public String getIsSendHandler()
	{
		return isSendHandler;
	}

	/**
	 * 借书处理人<br/>
	 * @param String isSendHandler
	 */
	public void setIsSendHandler(String isSendHandler)
	{
		this.isSendHandler = isSendHandler;
	}
	
	/**
	 * 借书日期<br/>
	 * @return String isStartDate
	 */
	public String getIsStartDate()
	{
		return isStartDate;
	}

	/**
	 * 借书日期<br/>
	 * @param String isStartDate
	 */
	public void setIsStartDate(String isStartDate)
	{
		this.isStartDate = isStartDate;
	}
	
	/**
	 * 借书时间<br/>
	 * @return String isStartTime
	 */
	public String getIsStartTime()
	{
		return isStartTime;
	}

	/**
	 * 借书时间<br/>
	 * @param String isStartTime
	 */
	public void setIsStartTime(String isStartTime)
	{
		this.isStartTime = isStartTime;
	}
	
	/**
	 * 计划归还日期<br/>
	 * @return String isPlanBackDate
	 */
	public String getIsPlanBackDate()
	{
		return isPlanBackDate;
	}

	/**
	 * 计划归还日期<br/>
	 * @param String isPlanBackDate
	 */
	public void setIsPlanBackDate(String isPlanBackDate)
	{
		this.isPlanBackDate = isPlanBackDate;
	}
	
	/**
	 * 超期时长，计算列<br/>
	 * @return String isOverdueLong
	 */
	public String getIsOverdueLong()
	{
		return isOverdueLong;
	}

	/**
	 * 超期时长，计算列<br/>
	 * @param Integer isOverdueLong
	 */
	public void setIsOverdueLong(String isOverdueLong)
	{
		this.isOverdueLong = isOverdueLong;
	}
	
	
	@Override
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		
		sb.append("isId=" + isId).append("\n");
		sb.append("isUserId=" + isUserId).append("\n");
		sb.append("isBookCode=" + isBookCode).append("\n");
		sb.append("isSendHandler=" + isSendHandler).append("\n");
		sb.append("isStartDate=" + isStartDate).append("\n");
		sb.append("isStartTime=" + isStartTime).append("\n");
		sb.append("isPlanBackDate=" + isPlanBackDate).append("\n");
		sb.append("isOverdueLong=" + isOverdueLong).append("\n");
		return sb.toString();
	}
}
