package com.efs.bus.edu.course.controller;

/**
 * 
 * com.efs.bus.edu.course.controller.BaseSchScoreInfoForm
 * @author xwh
 * 2018-05-03 15:47:43
 * 学校学期内开课信息表
 *
 */
public class BaseSchScoreInfoForm
{
	/**
	 * 主键
	 */
	private String ssId;
	
	/**
	 * 学期
	 */
	private String ssTerm;
	
	/**
	 * 学期名称,计算列
	 */
	private String ssTermName;
	
	/**
	 * 课程编码
	 */
	private String ssScore;
	
	/**
	 * 课程名称，计算列
	 */
	private String ssScoreName;
	
	/**
	 * 课程简称，计算列
	 */
	private String ssShortName;
	
	/**
	 * 开课班级
	 */
	private String ssClass;
	
	/**
	 * 班级名称，计算列
	 */
	private String ssClassName;
	
	/**
	 * 课时
	 */
	private String ssCount;
	
	/**
	 * 课程学分
	 */
	private String ssCredit;
	
	/**
	 * 课程满分
	 */
	private String ssFullMark;
	
	/**
	 * 课程高分
	 */
	private String ssHighMark;
	
	/**
	 * 课程优分
	 */
	private String ssExcelMark;
	
	/**
	 * 及格分数
	 */
	private String ssPassMark;
	
	/**
	 * 课程低分
	 */
	private String ssLowMark;
	
	/**
	 * 选修类型
	 */
	private String ssStudyType;
	
	/**
	 * 考试类型
	 */
	private String ssTestType;
	
	/**
	 * 考试类型名称
	 */
	private String ssTestTypeVal;
	
	/**
	 * 任课老师
	 */
	private String ssTeacher;
	
	/**
	 * 任课老师名称,计算列
	 */
	private String ssTeacherName;
	
	/**
	 * 审核状态：1已经审批，0未审核
	 */
	private String ssChkStatus;
	
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

	private String newSsTerm;

	private String newClasses;

	public String getNewSsTerm()
	{
		return newSsTerm;
	}

	public void setNewSsTerm(String newSsTerm)
	{
		this.newSsTerm = newSsTerm;
	}

	public String getNewClasses()
	{
		return newClasses;
	}

	public void setNewClasses(String newClasses)
	{
		this.newClasses = newClasses;
	}

	/**
	 * 主键<br/>
	 * @return String ssId
	 */
	public String getSsId()
	{
		return ssId;
	}

	/**
	 * 主键<br/>
	 * @param String ssId
	 */
	public void setSsId(String ssId)
	{
		this.ssId = ssId;
	}
	
	/**
	 * 学期<br/>
	 * @return String ssTerm
	 */
	public String getSsTerm()
	{
		return ssTerm;
	}

	/**
	 * 学期<br/>
	 * @param String ssTerm
	 */
	public void setSsTerm(String ssTerm)
	{
		this.ssTerm = ssTerm;
	}
	
	/**
	 * 学期名称,计算列<br/>
	 * @return String ssTermName
	 */
	public String getSsTermName()
	{
		return ssTermName;
	}

	/**
	 * 学期名称,计算列<br/>
	 * @param String ssTermName
	 */
	public void setSsTermName(String ssTermName)
	{
		this.ssTermName = ssTermName;
	}
	
	/**
	 * 课程编码<br/>
	 * @return String ssScore
	 */
	public String getSsScore()
	{
		return ssScore;
	}

	/**
	 * 课程编码<br/>
	 * @param String ssScore
	 */
	public void setSsScore(String ssScore)
	{
		this.ssScore = ssScore;
	}
	
	/**
	 * 课程名称，计算列<br/>
	 * @return String ssScoreName
	 */
	public String getSsScoreName()
	{
		return ssScoreName;
	}

	/**
	 * 课程名称，计算列<br/>
	 * @param String ssScoreName
	 */
	public void setSsScoreName(String ssScoreName)
	{
		this.ssScoreName = ssScoreName;
	}
	
	/**
	 * 课程简称，计算列<br/>
	 * @return String ssShortName
	 */
	public String getSsShortName()
	{
		return ssShortName;
	}

	/**
	 * 课程简称，计算列<br/>
	 * @param String ssShortName
	 */
	public void setSsShortName(String ssShortName)
	{
		this.ssShortName = ssShortName;
	}
	
	/**
	 * 开课班级<br/>
	 * @return String ssClass
	 */
	public String getSsClass()
	{
		return ssClass;
	}

	/**
	 * 开课班级<br/>
	 * @param String ssClass
	 */
	public void setSsClass(String ssClass)
	{
		this.ssClass = ssClass;
	}
	
	/**
	 * 班级名称，计算列<br/>
	 * @return String ssClassName
	 */
	public String getSsClassName()
	{
		return ssClassName;
	}

	/**
	 * 班级名称，计算列<br/>
	 * @param String ssClassName
	 */
	public void setSsClassName(String ssClassName)
	{
		this.ssClassName = ssClassName;
	}
	
	/**
	 * 课时<br/>
	 * @return String ssCount
	 */
	public String getSsCount()
	{
		return ssCount;
	}

	/**
	 * 课时<br/>
	 * @param Integer ssCount
	 */
	public void setSsCount(String ssCount)
	{
		this.ssCount = ssCount;
	}
	
	/**
	 * 课程学分<br/>
	 * @return String ssCredit
	 */
	public String getSsCredit()
	{
		return ssCredit;
	}

	/**
	 * 课程学分<br/>
	 * @param BigDecimal ssCredit
	 */
	public void setSsCredit(String ssCredit)
	{
		this.ssCredit = ssCredit;
	}
	
	/**
	 * 课程满分<br/>
	 * @return String ssFullMark
	 */
	public String getSsFullMark()
	{
		return ssFullMark;
	}

	/**
	 * 课程满分<br/>
	 * @param BigDecimal ssFullMark
	 */
	public void setSsFullMark(String ssFullMark)
	{
		this.ssFullMark = ssFullMark;
	}
	
	/**
	 * 课程高分<br/>
	 * @return String ssHighMark
	 */
	public String getSsHighMark()
	{
		return ssHighMark;
	}

	/**
	 * 课程高分<br/>
	 * @param BigDecimal ssHighMark
	 */
	public void setSsHighMark(String ssHighMark)
	{
		this.ssHighMark = ssHighMark;
	}
	
	/**
	 * 课程优分<br/>
	 * @return String ssExcelMark
	 */
	public String getSsExcelMark()
	{
		return ssExcelMark;
	}

	/**
	 * 课程优分<br/>
	 * @param BigDecimal ssExcelMark
	 */
	public void setSsExcelMark(String ssExcelMark)
	{
		this.ssExcelMark = ssExcelMark;
	}
	
	/**
	 * 及格分数<br/>
	 * @return String ssPassMark
	 */
	public String getSsPassMark()
	{
		return ssPassMark;
	}

	/**
	 * 及格分数<br/>
	 * @param BigDecimal ssPassMark
	 */
	public void setSsPassMark(String ssPassMark)
	{
		this.ssPassMark = ssPassMark;
	}
	
	/**
	 * 课程低分<br/>
	 * @return String ssLowMark
	 */
	public String getSsLowMark()
	{
		return ssLowMark;
	}

	/**
	 * 课程低分<br/>
	 * @param BigDecimal ssLowMark
	 */
	public void setSsLowMark(String ssLowMark)
	{
		this.ssLowMark = ssLowMark;
	}
	
	/**
	 * 选修类型<br/>
	 * @return String ssStudyType
	 */
	public String getSsStudyType()
	{
		return ssStudyType;
	}

	/**
	 * 选修类型<br/>
	 * @param String ssStudyType
	 */
	public void setSsStudyType(String ssStudyType)
	{
		this.ssStudyType = ssStudyType;
	}
	
	/**
	 * 考试类型<br/>
	 * @return String ssTestType
	 */
	public String getSsTestType()
	{
		return ssTestType;
	}

	/**
	 * 考试类型<br/>
	 * @param String ssTestType
	 */
	public void setSsTestType(String ssTestType)
	{
		this.ssTestType = ssTestType;
	}
	
	/**
	 * 考试类型名称<br/>
	 * @return String ssTestTypeVal
	 */
	public String getSsTestTypeVal()
	{
		return ssTestTypeVal;
	}

	/**
	 * 考试类型名称<br/>
	 * @param String ssTestTypeVal
	 */
	public void setSsTestTypeVal(String ssTestTypeVal)
	{
		this.ssTestTypeVal = ssTestTypeVal;
	}
	
	/**
	 * 任课老师<br/>
	 * @return String ssTeacher
	 */
	public String getSsTeacher()
	{
		return ssTeacher;
	}

	/**
	 * 任课老师<br/>
	 * @param String ssTeacher
	 */
	public void setSsTeacher(String ssTeacher)
	{
		this.ssTeacher = ssTeacher;
	}
	
	/**
	 * 任课老师名称,计算列<br/>
	 * @return String ssTeacherName
	 */
	public String getSsTeacherName()
	{
		return ssTeacherName;
	}

	/**
	 * 任课老师名称,计算列<br/>
	 * @param String ssTeacherName
	 */
	public void setSsTeacherName(String ssTeacherName)
	{
		this.ssTeacherName = ssTeacherName;
	}
	
	/**
	 * 审核状态：1已经审批，0未审核<br/>
	 * @return String ssChkStatus
	 */
	public String getSsChkStatus()
	{
		return ssChkStatus;
	}

	/**
	 * 审核状态：1已经审批，0未审核<br/>
	 * @param String ssChkStatus
	 */
	public void setSsChkStatus(String ssChkStatus)
	{
		this.ssChkStatus = ssChkStatus;
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
		
		sb.append("ssId=" + ssId).append("\n");
		sb.append("ssTerm=" + ssTerm).append("\n");
		sb.append("ssTermName=" + ssTermName).append("\n");
		sb.append("ssScore=" + ssScore).append("\n");
		sb.append("ssScoreName=" + ssScoreName).append("\n");
		sb.append("ssShortName=" + ssShortName).append("\n");
		sb.append("ssClass=" + ssClass).append("\n");
		sb.append("ssClassName=" + ssClassName).append("\n");
		sb.append("ssCount=" + ssCount).append("\n");
		sb.append("ssCredit=" + ssCredit).append("\n");
		sb.append("ssFullMark=" + ssFullMark).append("\n");
		sb.append("ssHighMark=" + ssHighMark).append("\n");
		sb.append("ssExcelMark=" + ssExcelMark).append("\n");
		sb.append("ssPassMark=" + ssPassMark).append("\n");
		sb.append("ssLowMark=" + ssLowMark).append("\n");
		sb.append("ssStudyType=" + ssStudyType).append("\n");
		sb.append("ssTestType=" + ssTestType).append("\n");
		sb.append("ssTestTypeVal=" + ssTestTypeVal).append("\n");
		sb.append("ssTeacher=" + ssTeacher).append("\n");
		sb.append("ssTeacherName=" + ssTeacherName).append("\n");
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
