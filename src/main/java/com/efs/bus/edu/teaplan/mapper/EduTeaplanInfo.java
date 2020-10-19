package com.efs.bus.edu.teaplan.mapper;

/**
 * 
 * com.efs.bus.edu.teaplan.mapper.EduTeaplanInfo
 * @author xwh
 * 2018-05-22 14:33:08
 * 教案检查信息表
 *
 */
public class EduTeaplanInfo
{
	/**
	 * 系统主键
	 */
	private Long tiDbId;
	
	/**
	 * 检查批次号
	 */
	private String tiBatchId;
	
	/**
	 * 被检查人ID
	 */
	private String tiCheckedUser;
	
	/**
	 * 被检查人姓名
	 */
	private String tiCheckedUserNm;
	
	/**
	 * 
	 */
	private String tiTerm;
	
	/**
	 * 
	 */
	private String tiTermNm;
	
	/**
	 * 
	 */
	private String tiClass;
	
	/**
	 * 
	 */
	private String tiClassNm;
	
	/**
	 * 科目
	 */
	private String tiCourCode;
	
	/**
	 * 科目名称
	 */
	private String tiCourName;
	
	/**
	 * 教案保存ID
	 */
	private String tiFileId;
	
	/**
	 * 提交截止日期
	 */
	private String tiEndDate;
	
	/**
	 * 状态：0已经发布，1：已经保存，2：已经提交，3：已评定
	 */
	private String tiStatus;
	
	/**
	 * 评价等级
	 */
	private String tiEvalLvl;

	private String tiEvalLvlNm;
	
	/**
	 * 评价分数
	 */
	private Integer tiEvalScore;
	
	/**
	 * 评价备注
	 */
	private String tiEvalComm;
	
	/**
	 * 任务发布日期
	 */
	private String tiIssueDate;
	
	/**
	 * 任务发布时间
	 */
	private String tiIssueTime;
	
	/**
	 * 任务发布人
	 */
	private String tiIssueUser;
	
	/**
	 * 任务发布人姓名
	 */
	private String tiIssueUserNm;

	/**
	 * 注释
	 */
	private String tiIssueCommon;
	
	/**
	 * 保存日期
	 */
	private String tiSaveDate;
	
	/**
	 * 保存时间
	 */
	private String tiSaveTime;
	
	/**
	 * 保存人
	 */
	private String tiSaveUser;
	
	/**
	 * 保存人姓名
	 */
	private String tiSaveUserNm;
	
	/**
	 * 提交日期
	 */
	private String tiSubDate;
	
	/**
	 * 提交时间
	 */
	private String tiSubTime;
	
	/**
	 * 提交人
	 */
	private String tiSubUser;
	
	/**
	 * 提交人姓名
	 */
	private String tiSubUserNm;
	
	/**
	 * 评价日期
	 */
	private String tiEvalDate;
	
	/**
	 * 评价时间
	 */
	private String tiEvalTime;
	
	/**
	 * 评价人
	 */
	private String tiEvalUser;
	
	/**
	 * 评价人姓名
	 */
	private String tiEvalUserNm;

	/**
	 * 发布总人数
	 */
	private int totCnt;

	/**
	 * 提交总人数
	 */
	private int submitCnt;

	/**
	 * 评价总人数
	 */
	private int evalCnt;

	/**
	 * 教案评价标识
	 */
	private String checkFlag;

	public String getCheckFlag()
	{
		return checkFlag;
	}

	public void setCheckFlag(String checkFlag)
	{
		this.checkFlag = checkFlag;
	}

	public int getTotCnt()
	{
		return totCnt;
	}

	public void setTotCnt(int totCnt)
	{
		this.totCnt = totCnt;
	}

	public int getSubmitCnt()
	{
		return submitCnt;
	}

	public void setSubmitCnt(int submitCnt)
	{
		this.submitCnt = submitCnt;
	}

	public int getEvalCnt()
	{
		return evalCnt;
	}

	public void setEvalCnt(int evalCnt)
	{
		this.evalCnt = evalCnt;
	}

	public String getTiEvalLvlNm()
	{
		return tiEvalLvlNm;
	}

	public void setTiEvalLvlNm(String tiEvalLvlNm)
	{
		this.tiEvalLvlNm = tiEvalLvlNm;
	}

	public String getTiIssueCommon()
	{
		return tiIssueCommon;
	}

	public void setTiIssueCommon(String tiIssueCommon)
	{
		this.tiIssueCommon = tiIssueCommon;
	}

	/**
	 * 系统主键<br/>
	 * @return Long tiDbId
	 */
	public Long getTiDbId()
	{
		return tiDbId;
	}

	/**
	 * 系统主键<br/>
	 * @param Long tiDbId
	 */
	public void setTiDbId(Long tiDbId)
	{
		this.tiDbId = tiDbId;
	}
	
	/**
	 * 检查批次号<br/>
	 * @return String tiBatchId
	 */
	public String getTiBatchId()
	{
		return tiBatchId;
	}

	/**
	 * 检查批次号<br/>
	 * @param String tiBatchId
	 */
	public void setTiBatchId(String tiBatchId)
	{
		this.tiBatchId = tiBatchId;
	}
	
	/**
	 * 被检查人ID<br/>
	 * @return String tiCheckedUser
	 */
	public String getTiCheckedUser()
	{
		return tiCheckedUser;
	}

	/**
	 * 被检查人ID<br/>
	 * @param String tiCheckedUser
	 */
	public void setTiCheckedUser(String tiCheckedUser)
	{
		this.tiCheckedUser = tiCheckedUser;
	}
	
	/**
	 * 被检查人姓名<br/>
	 * @return String tiCheckedUserNm
	 */
	public String getTiCheckedUserNm()
	{
		return tiCheckedUserNm;
	}

	/**
	 * 被检查人姓名<br/>
	 * @param String tiCheckedUserNm
	 */
	public void setTiCheckedUserNm(String tiCheckedUserNm)
	{
		this.tiCheckedUserNm = tiCheckedUserNm;
	}
	
	/**
	 * <br/>
	 * @return String tiTerm
	 */
	public String getTiTerm()
	{
		return tiTerm;
	}

	/**
	 * <br/>
	 * @param String tiTerm
	 */
	public void setTiTerm(String tiTerm)
	{
		this.tiTerm = tiTerm;
	}
	
	/**
	 * <br/>
	 * @return String tiTermNm
	 */
	public String getTiTermNm()
	{
		return tiTermNm;
	}

	/**
	 * <br/>
	 * @param String tiTermNm
	 */
	public void setTiTermNm(String tiTermNm)
	{
		this.tiTermNm = tiTermNm;
	}
	
	/**
	 * <br/>
	 * @return String tiClass
	 */
	public String getTiClass()
	{
		return tiClass;
	}

	/**
	 * <br/>
	 * @param String tiClass
	 */
	public void setTiClass(String tiClass)
	{
		this.tiClass = tiClass;
	}
	
	/**
	 * <br/>
	 * @return String tiClassNm
	 */
	public String getTiClassNm()
	{
		return tiClassNm;
	}

	/**
	 * <br/>
	 * @param String tiClassNm
	 */
	public void setTiClassNm(String tiClassNm)
	{
		this.tiClassNm = tiClassNm;
	}
	
	/**
	 * 科目<br/>
	 * @return String tiCourCode
	 */
	public String getTiCourCode()
	{
		return tiCourCode;
	}

	/**
	 * 科目<br/>
	 * @param String tiCourCode
	 */
	public void setTiCourCode(String tiCourCode)
	{
		this.tiCourCode = tiCourCode;
	}
	
	/**
	 * 科目名称<br/>
	 * @return String tiCourName
	 */
	public String getTiCourName()
	{
		return tiCourName;
	}

	/**
	 * 科目名称<br/>
	 * @param String tiCourName
	 */
	public void setTiCourName(String tiCourName)
	{
		this.tiCourName = tiCourName;
	}
	
	/**
	 * 教案保存ID<br/>
	 * @return String tiFileId
	 */
	public String getTiFileId()
	{
		return tiFileId;
	}

	/**
	 * 教案保存ID<br/>
	 * @param String tiFileId
	 */
	public void setTiFileId(String tiFileId)
	{
		this.tiFileId = tiFileId;
	}
	
	/**
	 * 提交截止日期<br/>
	 * @return String tiEndDate
	 */
	public String getTiEndDate()
	{
		return tiEndDate;
	}

	/**
	 * 提交截止日期<br/>
	 * @param String tiEndDate
	 */
	public void setTiEndDate(String tiEndDate)
	{
		this.tiEndDate = tiEndDate;
	}
	
	/**
	 * 状态：0已经发布，1：已经保存，2：已经提交，3：已评定<br/>
	 * @return String tiStatus
	 */
	public String getTiStatus()
	{
		return tiStatus;
	}

	/**
	 * 状态：0已经发布，1：已经保存，2：已经提交，3：已评定<br/>
	 * @param String tiStatus
	 */
	public void setTiStatus(String tiStatus)
	{
		this.tiStatus = tiStatus;
	}
	
	/**
	 * 评价等级<br/>
	 * @return String tiEvalLvl
	 */
	public String getTiEvalLvl()
	{
		return tiEvalLvl;
	}

	/**
	 * 评价等级<br/>
	 * @param String tiEvalLvl
	 */
	public void setTiEvalLvl(String tiEvalLvl)
	{
		this.tiEvalLvl = tiEvalLvl;
	}
	
	/**
	 * 评价分数<br/>
	 * @return Integer tiEvalScore
	 */
	public Integer getTiEvalScore()
	{
		return tiEvalScore;
	}

	/**
	 * 评价分数<br/>
	 * @param Integer tiEvalScore
	 */
	public void setTiEvalScore(Integer tiEvalScore)
	{
		this.tiEvalScore = tiEvalScore;
	}
	
	/**
	 * 评价备注<br/>
	 * @return String tiEvalComm
	 */
	public String getTiEvalComm()
	{
		return tiEvalComm;
	}

	/**
	 * 评价备注<br/>
	 * @param String tiEvalComm
	 */
	public void setTiEvalComm(String tiEvalComm)
	{
		this.tiEvalComm = tiEvalComm;
	}
	
	/**
	 * 任务发布日期<br/>
	 * @return String tiIssueDate
	 */
	public String getTiIssueDate()
	{
		return tiIssueDate;
	}

	/**
	 * 任务发布日期<br/>
	 * @param String tiIssueDate
	 */
	public void setTiIssueDate(String tiIssueDate)
	{
		this.tiIssueDate = tiIssueDate;
	}
	
	/**
	 * 任务发布时间<br/>
	 * @return String tiIssueTime
	 */
	public String getTiIssueTime()
	{
		return tiIssueTime;
	}

	/**
	 * 任务发布时间<br/>
	 * @param String tiIssueTime
	 */
	public void setTiIssueTime(String tiIssueTime)
	{
		this.tiIssueTime = tiIssueTime;
	}
	
	/**
	 * 任务发布人<br/>
	 * @return String tiIssueUser
	 */
	public String getTiIssueUser()
	{
		return tiIssueUser;
	}

	/**
	 * 任务发布人<br/>
	 * @param String tiIssueUser
	 */
	public void setTiIssueUser(String tiIssueUser)
	{
		this.tiIssueUser = tiIssueUser;
	}
	
	/**
	 * 任务发布人姓名<br/>
	 * @return String tiIssueUserNm
	 */
	public String getTiIssueUserNm()
	{
		return tiIssueUserNm;
	}

	/**
	 * 任务发布人姓名<br/>
	 * @param String tiIssueUserNm
	 */
	public void setTiIssueUserNm(String tiIssueUserNm)
	{
		this.tiIssueUserNm = tiIssueUserNm;
	}
	
	/**
	 * 保存日期<br/>
	 * @return String tiSaveDate
	 */
	public String getTiSaveDate()
	{
		return tiSaveDate;
	}

	/**
	 * 保存日期<br/>
	 * @param String tiSaveDate
	 */
	public void setTiSaveDate(String tiSaveDate)
	{
		this.tiSaveDate = tiSaveDate;
	}
	
	/**
	 * 保存时间<br/>
	 * @return String tiSaveTime
	 */
	public String getTiSaveTime()
	{
		return tiSaveTime;
	}

	/**
	 * 保存时间<br/>
	 * @param String tiSaveTime
	 */
	public void setTiSaveTime(String tiSaveTime)
	{
		this.tiSaveTime = tiSaveTime;
	}
	
	/**
	 * 保存人<br/>
	 * @return String tiSaveUser
	 */
	public String getTiSaveUser()
	{
		return tiSaveUser;
	}

	/**
	 * 保存人<br/>
	 * @param String tiSaveUser
	 */
	public void setTiSaveUser(String tiSaveUser)
	{
		this.tiSaveUser = tiSaveUser;
	}
	
	/**
	 * 保存人姓名<br/>
	 * @return String tiSaveUserNm
	 */
	public String getTiSaveUserNm()
	{
		return tiSaveUserNm;
	}

	/**
	 * 保存人姓名<br/>
	 * @param String tiSaveUserNm
	 */
	public void setTiSaveUserNm(String tiSaveUserNm)
	{
		this.tiSaveUserNm = tiSaveUserNm;
	}
	
	/**
	 * 提交日期<br/>
	 * @return String tiSubDate
	 */
	public String getTiSubDate()
	{
		return tiSubDate;
	}

	/**
	 * 提交日期<br/>
	 * @param String tiSubDate
	 */
	public void setTiSubDate(String tiSubDate)
	{
		this.tiSubDate = tiSubDate;
	}
	
	/**
	 * 提交时间<br/>
	 * @return String tiSubTime
	 */
	public String getTiSubTime()
	{
		return tiSubTime;
	}

	/**
	 * 提交时间<br/>
	 * @param String tiSubTime
	 */
	public void setTiSubTime(String tiSubTime)
	{
		this.tiSubTime = tiSubTime;
	}
	
	/**
	 * 提交人<br/>
	 * @return String tiSubUser
	 */
	public String getTiSubUser()
	{
		return tiSubUser;
	}

	/**
	 * 提交人<br/>
	 * @param String tiSubUser
	 */
	public void setTiSubUser(String tiSubUser)
	{
		this.tiSubUser = tiSubUser;
	}
	
	/**
	 * 提交人姓名<br/>
	 * @return String tiSubUserNm
	 */
	public String getTiSubUserNm()
	{
		return tiSubUserNm;
	}

	/**
	 * 提交人姓名<br/>
	 * @param String tiSubUserNm
	 */
	public void setTiSubUserNm(String tiSubUserNm)
	{
		this.tiSubUserNm = tiSubUserNm;
	}
	
	/**
	 * 评价日期<br/>
	 * @return String tiEvalDate
	 */
	public String getTiEvalDate()
	{
		return tiEvalDate;
	}

	/**
	 * 评价日期<br/>
	 * @param String tiEvalDate
	 */
	public void setTiEvalDate(String tiEvalDate)
	{
		this.tiEvalDate = tiEvalDate;
	}
	
	/**
	 * 评价时间<br/>
	 * @return String tiEvalTime
	 */
	public String getTiEvalTime()
	{
		return tiEvalTime;
	}

	/**
	 * 评价时间<br/>
	 * @param String tiEvalTime
	 */
	public void setTiEvalTime(String tiEvalTime)
	{
		this.tiEvalTime = tiEvalTime;
	}
	
	/**
	 * 评价人<br/>
	 * @return String tiEvalUser
	 */
	public String getTiEvalUser()
	{
		return tiEvalUser;
	}

	/**
	 * 评价人<br/>
	 * @param String tiEvalUser
	 */
	public void setTiEvalUser(String tiEvalUser)
	{
		this.tiEvalUser = tiEvalUser;
	}
	
	/**
	 * 评价人姓名<br/>
	 * @return String tiEvalUserNm
	 */
	public String getTiEvalUserNm()
	{
		return tiEvalUserNm;
	}

	/**
	 * 评价人姓名<br/>
	 * @param String tiEvalUserNm
	 */
	public void setTiEvalUserNm(String tiEvalUserNm)
	{
		this.tiEvalUserNm = tiEvalUserNm;
	}
	
	
	@Override
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		
		sb.append("tiDbId=" + tiDbId).append("\n");
		sb.append("tiBatchId=" + tiBatchId).append("\n");
		sb.append("tiCheckedUser=" + tiCheckedUser).append("\n");
		sb.append("tiCheckedUserNm=" + tiCheckedUserNm).append("\n");
		sb.append("tiTerm=" + tiTerm).append("\n");
		sb.append("tiTermNm=" + tiTermNm).append("\n");
		sb.append("tiClass=" + tiClass).append("\n");
		sb.append("tiClassNm=" + tiClassNm).append("\n");
		sb.append("tiCourCode=" + tiCourCode).append("\n");
		sb.append("tiCourName=" + tiCourName).append("\n");
		sb.append("tiFileId=" + tiFileId).append("\n");
		sb.append("tiEndDate=" + tiEndDate).append("\n");
		sb.append("tiStatus=" + tiStatus).append("\n");
		sb.append("tiEvalLvl=" + tiEvalLvl).append("\n");
		sb.append("tiEvalScore=" + tiEvalScore).append("\n");
		sb.append("tiEvalComm=" + tiEvalComm).append("\n");
		sb.append("tiIssueDate=" + tiIssueDate).append("\n");
		sb.append("tiIssueTime=" + tiIssueTime).append("\n");
		sb.append("tiIssueUser=" + tiIssueUser).append("\n");
		sb.append("tiIssueUserNm=" + tiIssueUserNm).append("\n");
		sb.append("tiSaveDate=" + tiSaveDate).append("\n");
		sb.append("tiSaveTime=" + tiSaveTime).append("\n");
		sb.append("tiSaveUser=" + tiSaveUser).append("\n");
		sb.append("tiSaveUserNm=" + tiSaveUserNm).append("\n");
		sb.append("tiSubDate=" + tiSubDate).append("\n");
		sb.append("tiSubTime=" + tiSubTime).append("\n");
		sb.append("tiSubUser=" + tiSubUser).append("\n");
		sb.append("tiSubUserNm=" + tiSubUserNm).append("\n");
		sb.append("tiEvalDate=" + tiEvalDate).append("\n");
		sb.append("tiEvalTime=" + tiEvalTime).append("\n");
		sb.append("tiEvalUser=" + tiEvalUser).append("\n");
		sb.append("tiEvalUserNm=" + tiEvalUserNm).append("\n");
		return sb.toString();
	}
}
