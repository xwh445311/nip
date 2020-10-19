package com.efs.bus.edu.scorerecord.controller;

/**
 * 
 * com.efs.bus.edu.scorerecord.controller.EduRecordInfoForm
 * @author xuwh
 * 2018-05-04 23:25:56
 * 学生学习成绩信息表
 *
 */
public class EduRecordInfoForm
{
	/**
	 * 主键ID
	 */
	private String riId;
	
	/**
	 * 学期
	 */
	private String riTerm;
	
	/**
	 * 学期名称
	 */
	private String riTermName;
	
	/**
	 * 期中/期末
	 */
	private String riMidTerm;
	
	/**
	 * 班级
	 */
	private String riClass;
	
	/**
	 * 班级名称
	 */
	private String riClassName;
	
	/**
	 * 学生ID
	 */
	private String riStuId;
	
	/**
	 * 学生姓名
	 */
	private String riStuName;
	
	/**
	 * 考号
	 */
	private String riTestId;
	
	/**
	 * 语文分数
	 */
	private String riYw;
	
	/**
	 * 数学分数
	 */
	private String riSx;
	
	/**
	 * 英语分数
	 */
	private String riEng;
	
	/**
	 * 科学分数
	 */
	private String riKx;
	
	/**
	 * 品德与社会分数
	 */
	private String riPs;
	
	/**
	 * 美术分数
	 */
	private String riMs;
	
	/**
	 * 音乐分数
	 */
	private String riMus;
	
	/**
	 * 体育分数
	 */
	private String riTy;
	
	/**
	 * 综合实践
	 */
	private String riZj;
	
	/**
	 * 总分
	 */
	private String riTot;
	
	/**
	 * 总分班内排名
	 */
	private String riClassRan;
	
	/**
	 * 总分班内排名变化
	 */
	private String riClassRanChg;
	
	/**
	 * 语文班内排名
	 */
	private String riYwClsRan;
	
	/**
	 * 语文班内排名变化
	 */
	private String riYwClsRanChg;
	
	/**
	 * 数学班内排名
	 */
	private String riSxClsRan;
	
	/**
	 * 数学班内排名变化
	 */
	private String riSxClsRanChg;
	
	/**
	 * 英语班内排名
	 */
	private String riEngClsRan;
	
	/**
	 * 英语班内排名变化
	 */
	private String riEngClsRanChg;
	
	/**
	 * 科学班内排名
	 */
	private String riKxClsRan;
	
	/**
	 * 科学班内排名变化
	 */
	private String riKxClsRanChg;
	
	/**
	 * 品社班内排名
	 */
	private String riPsClsRan;
	
	/**
	 * 品社班内排名变化
	 */
	private String riPsClsRanChg;
	
	/**
	 * 总分年级排名
	 */
	private String riGradeRan2;
	
	/**
	 * 总分年级排名变化
	 */
	private String riGradeRanChg2;
	
	/**
	 * 语文年级排名
	 */
	private String riYwGraRan2;
	
	/**
	 * 语文年级排名变化
	 */
	private String riYwGraRanChg2;
	
	/**
	 * 数学年级排名
	 */
	private String riSxGraRan2;
	
	/**
	 * 数学年级排名变化
	 */
	private String riSxGraRanChg2;
	
	/**
	 * 英语年级排名
	 */
	private String riEngGraRan2;
	
	/**
	 * 英语年级排名变化
	 */
	private String riEngGraRanChg2;
	
	/**
	 * 科学年级排名
	 */
	private String riKxGraRan2;
	
	/**
	 * 科学年级排名变化
	 */
	private String riKxGraRanChg2;
	
	/**
	 * 品社年级排名
	 */
	private String riPsGraRan2;
	
	/**
	 * 品社年级排名变化
	 */
	private String riPsGraRanChg2;
	
	/**
	 * 操行评定
	 */
	private String riConEval;
	
	/**
	 * 综合评定
	 */
	private String riGenEval;
	
	/**
	 * 班主任评价
	 */
	private String riLeaderCommon;
	
	/**
	 * 评价人ID
	 */
	private String riCommonUserId;
	
	/**
	 * 评价人姓名
	 */
	private String riCommonUserName;
	
	/**
	 * 评价日期
	 */
	private String riCommonDate;
	
	/**
	 * 评价时间
	 */
	private String riCommonTime;
	
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
	 * 主键ID<br/>
	 * @return String riId
	 */
	public String getRiId()
	{
		return riId;
	}

	/**
	 * 主键ID<br/>
	 * @param Long riId
	 */
	public void setRiId(String riId)
	{
		this.riId = riId;
	}
	
	/**
	 * 学期<br/>
	 * @return String riTerm
	 */
	public String getRiTerm()
	{
		return riTerm;
	}

	/**
	 * 学期<br/>
	 * @param String riTerm
	 */
	public void setRiTerm(String riTerm)
	{
		this.riTerm = riTerm;
	}
	
	/**
	 * 学期名称<br/>
	 * @return String riTermName
	 */
	public String getRiTermName()
	{
		return riTermName;
	}

	/**
	 * 学期名称<br/>
	 * @param String riTermName
	 */
	public void setRiTermName(String riTermName)
	{
		this.riTermName = riTermName;
	}
	
	/**
	 * 期中/期末<br/>
	 * @return String riMidTerm
	 */
	public String getRiMidTerm()
	{
		return riMidTerm;
	}

	/**
	 * 期中/期末<br/>
	 * @param String riMidTerm
	 */
	public void setRiMidTerm(String riMidTerm)
	{
		this.riMidTerm = riMidTerm;
	}
	
	/**
	 * 班级<br/>
	 * @return String riClass
	 */
	public String getRiClass()
	{
		return riClass;
	}

	/**
	 * 班级<br/>
	 * @param String riClass
	 */
	public void setRiClass(String riClass)
	{
		this.riClass = riClass;
	}
	
	/**
	 * 班级名称<br/>
	 * @return String riClassName
	 */
	public String getRiClassName()
	{
		return riClassName;
	}

	/**
	 * 班级名称<br/>
	 * @param String riClassName
	 */
	public void setRiClassName(String riClassName)
	{
		this.riClassName = riClassName;
	}
	
	/**
	 * 学生ID<br/>
	 * @return String riStuId
	 */
	public String getRiStuId()
	{
		return riStuId;
	}

	/**
	 * 学生ID<br/>
	 * @param String riStuId
	 */
	public void setRiStuId(String riStuId)
	{
		this.riStuId = riStuId;
	}
	
	/**
	 * 学生姓名<br/>
	 * @return String riStuName
	 */
	public String getRiStuName()
	{
		return riStuName;
	}

	/**
	 * 学生姓名<br/>
	 * @param String riStuName
	 */
	public void setRiStuName(String riStuName)
	{
		this.riStuName = riStuName;
	}
	
	/**
	 * 考号<br/>
	 * @return String riTestId
	 */
	public String getRiTestId()
	{
		return riTestId;
	}

	/**
	 * 考号<br/>
	 * @param String riTestId
	 */
	public void setRiTestId(String riTestId)
	{
		this.riTestId = riTestId;
	}
	
	/**
	 * 语文分数<br/>
	 * @return String riYw
	 */
	public String getRiYw()
	{
		return riYw;
	}

	/**
	 * 语文分数<br/>
	 * @param BigDecimal riYw
	 */
	public void setRiYw(String riYw)
	{
		this.riYw = riYw;
	}
	
	/**
	 * 数学分数<br/>
	 * @return String riSx
	 */
	public String getRiSx()
	{
		return riSx;
	}

	/**
	 * 数学分数<br/>
	 * @param BigDecimal riSx
	 */
	public void setRiSx(String riSx)
	{
		this.riSx = riSx;
	}
	
	/**
	 * 英语分数<br/>
	 * @return String riEng
	 */
	public String getRiEng()
	{
		return riEng;
	}

	/**
	 * 英语分数<br/>
	 * @param BigDecimal riEng
	 */
	public void setRiEng(String riEng)
	{
		this.riEng = riEng;
	}
	
	/**
	 * 科学分数<br/>
	 * @return String riKx
	 */
	public String getRiKx()
	{
		return riKx;
	}

	/**
	 * 科学分数<br/>
	 * @param BigDecimal riKx
	 */
	public void setRiKx(String riKx)
	{
		this.riKx = riKx;
	}
	
	/**
	 * 品德与社会分数<br/>
	 * @return String riPs
	 */
	public String getRiPs()
	{
		return riPs;
	}

	/**
	 * 品德与社会分数<br/>
	 * @param BigDecimal riPs
	 */
	public void setRiPs(String riPs)
	{
		this.riPs = riPs;
	}
	
	/**
	 * 美术分数<br/>
	 * @return String riMs
	 */
	public String getRiMs()
	{
		return riMs;
	}

	/**
	 * 美术分数<br/>
	 * @param BigDecimal riMs
	 */
	public void setRiMs(String riMs)
	{
		this.riMs = riMs;
	}
	
	/**
	 * 音乐分数<br/>
	 * @return String riMus
	 */
	public String getRiMus()
	{
		return riMus;
	}

	/**
	 * 音乐分数<br/>
	 * @param BigDecimal riMus
	 */
	public void setRiMus(String riMus)
	{
		this.riMus = riMus;
	}
	
	/**
	 * 体育分数<br/>
	 * @return String riTy
	 */
	public String getRiTy()
	{
		return riTy;
	}

	/**
	 * 体育分数<br/>
	 * @param BigDecimal riTy
	 */
	public void setRiTy(String riTy)
	{
		this.riTy = riTy;
	}
	
	/**
	 * 综合实践<br/>
	 * @return String riZj
	 */
	public String getRiZj()
	{
		return riZj;
	}

	/**
	 * 综合实践<br/>
	 * @param BigDecimal riZj
	 */
	public void setRiZj(String riZj)
	{
		this.riZj = riZj;
	}
	
	/**
	 * 总分<br/>
	 * @return String riTot
	 */
	public String getRiTot()
	{
		return riTot;
	}

	/**
	 * 总分<br/>
	 * @param BigDecimal riTot
	 */
	public void setRiTot(String riTot)
	{
		this.riTot = riTot;
	}
	
	/**
	 * 总分班内排名<br/>
	 * @return String riClassRan
	 */
	public String getRiClassRan()
	{
		return riClassRan;
	}

	/**
	 * 总分班内排名<br/>
	 * @param Integer riClassRan
	 */
	public void setRiClassRan(String riClassRan)
	{
		this.riClassRan = riClassRan;
	}
	
	/**
	 * 总分班内排名变化<br/>
	 * @return String riClassRanChg
	 */
	public String getRiClassRanChg()
	{
		return riClassRanChg;
	}

	/**
	 * 总分班内排名变化<br/>
	 * @param Integer riClassRanChg
	 */
	public void setRiClassRanChg(String riClassRanChg)
	{
		this.riClassRanChg = riClassRanChg;
	}
	
	/**
	 * 语文班内排名<br/>
	 * @return String riYwClsRan
	 */
	public String getRiYwClsRan()
	{
		return riYwClsRan;
	}

	/**
	 * 语文班内排名<br/>
	 * @param Integer riYwClsRan
	 */
	public void setRiYwClsRan(String riYwClsRan)
	{
		this.riYwClsRan = riYwClsRan;
	}
	
	/**
	 * 语文班内排名变化<br/>
	 * @return String riYwClsRanChg
	 */
	public String getRiYwClsRanChg()
	{
		return riYwClsRanChg;
	}

	/**
	 * 语文班内排名变化<br/>
	 * @param Integer riYwClsRanChg
	 */
	public void setRiYwClsRanChg(String riYwClsRanChg)
	{
		this.riYwClsRanChg = riYwClsRanChg;
	}
	
	/**
	 * 数学班内排名<br/>
	 * @return String riSxClsRan
	 */
	public String getRiSxClsRan()
	{
		return riSxClsRan;
	}

	/**
	 * 数学班内排名<br/>
	 * @param Integer riSxClsRan
	 */
	public void setRiSxClsRan(String riSxClsRan)
	{
		this.riSxClsRan = riSxClsRan;
	}
	
	/**
	 * 数学班内排名变化<br/>
	 * @return String riSxClsRanChg
	 */
	public String getRiSxClsRanChg()
	{
		return riSxClsRanChg;
	}

	/**
	 * 数学班内排名变化<br/>
	 * @param Integer riSxClsRanChg
	 */
	public void setRiSxClsRanChg(String riSxClsRanChg)
	{
		this.riSxClsRanChg = riSxClsRanChg;
	}
	
	/**
	 * 英语班内排名<br/>
	 * @return String riEngClsRan
	 */
	public String getRiEngClsRan()
	{
		return riEngClsRan;
	}

	/**
	 * 英语班内排名<br/>
	 * @param Integer riEngClsRan
	 */
	public void setRiEngClsRan(String riEngClsRan)
	{
		this.riEngClsRan = riEngClsRan;
	}
	
	/**
	 * 英语班内排名变化<br/>
	 * @return String riEngClsRanChg
	 */
	public String getRiEngClsRanChg()
	{
		return riEngClsRanChg;
	}

	/**
	 * 英语班内排名变化<br/>
	 * @param Integer riEngClsRanChg
	 */
	public void setRiEngClsRanChg(String riEngClsRanChg)
	{
		this.riEngClsRanChg = riEngClsRanChg;
	}
	
	/**
	 * 科学班内排名<br/>
	 * @return String riKxClsRan
	 */
	public String getRiKxClsRan()
	{
		return riKxClsRan;
	}

	/**
	 * 科学班内排名<br/>
	 * @param Integer riKxClsRan
	 */
	public void setRiKxClsRan(String riKxClsRan)
	{
		this.riKxClsRan = riKxClsRan;
	}
	
	/**
	 * 科学班内排名变化<br/>
	 * @return String riKxClsRanChg
	 */
	public String getRiKxClsRanChg()
	{
		return riKxClsRanChg;
	}

	/**
	 * 科学班内排名变化<br/>
	 * @param Integer riKxClsRanChg
	 */
	public void setRiKxClsRanChg(String riKxClsRanChg)
	{
		this.riKxClsRanChg = riKxClsRanChg;
	}
	
	/**
	 * 品社班内排名<br/>
	 * @return String riPsClsRan
	 */
	public String getRiPsClsRan()
	{
		return riPsClsRan;
	}

	/**
	 * 品社班内排名<br/>
	 * @param Integer riPsClsRan
	 */
	public void setRiPsClsRan(String riPsClsRan)
	{
		this.riPsClsRan = riPsClsRan;
	}
	
	/**
	 * 品社班内排名变化<br/>
	 * @return String riPsClsRanChg
	 */
	public String getRiPsClsRanChg()
	{
		return riPsClsRanChg;
	}

	/**
	 * 品社班内排名变化<br/>
	 * @param Integer riPsClsRanChg
	 */
	public void setRiPsClsRanChg(String riPsClsRanChg)
	{
		this.riPsClsRanChg = riPsClsRanChg;
	}
	
	/**
	 * 总分年级排名<br/>
	 * @return String riGradeRan2
	 */
	public String getRiGradeRan2()
	{
		return riGradeRan2;
	}

	/**
	 * 总分年级排名<br/>
	 * @param Integer riGradeRan2
	 */
	public void setRiGradeRan2(String riGradeRan2)
	{
		this.riGradeRan2 = riGradeRan2;
	}
	
	/**
	 * 总分年级排名变化<br/>
	 * @return String riGradeRanChg2
	 */
	public String getRiGradeRanChg2()
	{
		return riGradeRanChg2;
	}

	/**
	 * 总分年级排名变化<br/>
	 * @param Integer riGradeRanChg2
	 */
	public void setRiGradeRanChg2(String riGradeRanChg2)
	{
		this.riGradeRanChg2 = riGradeRanChg2;
	}
	
	/**
	 * 语文年级排名<br/>
	 * @return String riYwGraRan2
	 */
	public String getRiYwGraRan2()
	{
		return riYwGraRan2;
	}

	/**
	 * 语文年级排名<br/>
	 * @param Integer riYwGraRan2
	 */
	public void setRiYwGraRan2(String riYwGraRan2)
	{
		this.riYwGraRan2 = riYwGraRan2;
	}
	
	/**
	 * 语文年级排名变化<br/>
	 * @return String riYwGraRanChg2
	 */
	public String getRiYwGraRanChg2()
	{
		return riYwGraRanChg2;
	}

	/**
	 * 语文年级排名变化<br/>
	 * @param Integer riYwGraRanChg2
	 */
	public void setRiYwGraRanChg2(String riYwGraRanChg2)
	{
		this.riYwGraRanChg2 = riYwGraRanChg2;
	}
	
	/**
	 * 数学年级排名<br/>
	 * @return String riSxGraRan2
	 */
	public String getRiSxGraRan2()
	{
		return riSxGraRan2;
	}

	/**
	 * 数学年级排名<br/>
	 * @param Integer riSxGraRan2
	 */
	public void setRiSxGraRan2(String riSxGraRan2)
	{
		this.riSxGraRan2 = riSxGraRan2;
	}
	
	/**
	 * 数学年级排名变化<br/>
	 * @return String riSxGraRanChg2
	 */
	public String getRiSxGraRanChg2()
	{
		return riSxGraRanChg2;
	}

	/**
	 * 数学年级排名变化<br/>
	 * @param Integer riSxGraRanChg2
	 */
	public void setRiSxGraRanChg2(String riSxGraRanChg2)
	{
		this.riSxGraRanChg2 = riSxGraRanChg2;
	}
	
	/**
	 * 英语年级排名<br/>
	 * @return String riEngGraRan2
	 */
	public String getRiEngGraRan2()
	{
		return riEngGraRan2;
	}

	/**
	 * 英语年级排名<br/>
	 * @param Integer riEngGraRan2
	 */
	public void setRiEngGraRan2(String riEngGraRan2)
	{
		this.riEngGraRan2 = riEngGraRan2;
	}
	
	/**
	 * 英语年级排名变化<br/>
	 * @return String riEngGraRanChg2
	 */
	public String getRiEngGraRanChg2()
	{
		return riEngGraRanChg2;
	}

	/**
	 * 英语年级排名变化<br/>
	 * @param Integer riEngGraRanChg2
	 */
	public void setRiEngGraRanChg2(String riEngGraRanChg2)
	{
		this.riEngGraRanChg2 = riEngGraRanChg2;
	}
	
	/**
	 * 科学年级排名<br/>
	 * @return String riKxGraRan2
	 */
	public String getRiKxGraRan2()
	{
		return riKxGraRan2;
	}

	/**
	 * 科学年级排名<br/>
	 * @param Integer riKxGraRan2
	 */
	public void setRiKxGraRan2(String riKxGraRan2)
	{
		this.riKxGraRan2 = riKxGraRan2;
	}
	
	/**
	 * 科学年级排名变化<br/>
	 * @return String riKxGraRanChg2
	 */
	public String getRiKxGraRanChg2()
	{
		return riKxGraRanChg2;
	}

	/**
	 * 科学年级排名变化<br/>
	 * @param Integer riKxGraRanChg2
	 */
	public void setRiKxGraRanChg2(String riKxGraRanChg2)
	{
		this.riKxGraRanChg2 = riKxGraRanChg2;
	}
	
	/**
	 * 品社年级排名<br/>
	 * @return String riPsGraRan2
	 */
	public String getRiPsGraRan2()
	{
		return riPsGraRan2;
	}

	/**
	 * 品社年级排名<br/>
	 * @param Integer riPsGraRan2
	 */
	public void setRiPsGraRan2(String riPsGraRan2)
	{
		this.riPsGraRan2 = riPsGraRan2;
	}
	
	/**
	 * 品社年级排名变化<br/>
	 * @return String riPsGraRanChg2
	 */
	public String getRiPsGraRanChg2()
	{
		return riPsGraRanChg2;
	}

	/**
	 * 品社年级排名变化<br/>
	 * @param Integer riPsGraRanChg2
	 */
	public void setRiPsGraRanChg2(String riPsGraRanChg2)
	{
		this.riPsGraRanChg2 = riPsGraRanChg2;
	}
	
	/**
	 * 操行评定<br/>
	 * @return String riConEval
	 */
	public String getRiConEval()
	{
		return riConEval;
	}

	/**
	 * 操行评定<br/>
	 * @param String riConEval
	 */
	public void setRiConEval(String riConEval)
	{
		this.riConEval = riConEval;
	}
	
	/**
	 * 综合评定<br/>
	 * @return String riGenEval
	 */
	public String getRiGenEval()
	{
		return riGenEval;
	}

	/**
	 * 综合评定<br/>
	 * @param String riGenEval
	 */
	public void setRiGenEval(String riGenEval)
	{
		this.riGenEval = riGenEval;
	}
	
	/**
	 * 班主任评价<br/>
	 * @return String riLeaderCommon
	 */
	public String getRiLeaderCommon()
	{
		return riLeaderCommon;
	}

	/**
	 * 班主任评价<br/>
	 * @param String riLeaderCommon
	 */
	public void setRiLeaderCommon(String riLeaderCommon)
	{
		this.riLeaderCommon = riLeaderCommon;
	}
	
	/**
	 * 评价人ID<br/>
	 * @return String riCommonUserId
	 */
	public String getRiCommonUserId()
	{
		return riCommonUserId;
	}

	/**
	 * 评价人ID<br/>
	 * @param String riCommonUserId
	 */
	public void setRiCommonUserId(String riCommonUserId)
	{
		this.riCommonUserId = riCommonUserId;
	}
	
	/**
	 * 评价人姓名<br/>
	 * @return String riCommonUserName
	 */
	public String getRiCommonUserName()
	{
		return riCommonUserName;
	}

	/**
	 * 评价人姓名<br/>
	 * @param String riCommonUserName
	 */
	public void setRiCommonUserName(String riCommonUserName)
	{
		this.riCommonUserName = riCommonUserName;
	}
	
	/**
	 * 评价日期<br/>
	 * @return String riCommonDate
	 */
	public String getRiCommonDate()
	{
		return riCommonDate;
	}

	/**
	 * 评价日期<br/>
	 * @param String riCommonDate
	 */
	public void setRiCommonDate(String riCommonDate)
	{
		this.riCommonDate = riCommonDate;
	}
	
	/**
	 * 评价时间<br/>
	 * @return String riCommonTime
	 */
	public String getRiCommonTime()
	{
		return riCommonTime;
	}

	/**
	 * 评价时间<br/>
	 * @param String riCommonTime
	 */
	public void setRiCommonTime(String riCommonTime)
	{
		this.riCommonTime = riCommonTime;
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
	
	
	@Override
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		
		sb.append("riId=" + riId).append("\n");
		sb.append("riTerm=" + riTerm).append("\n");
		sb.append("riTermName=" + riTermName).append("\n");
		sb.append("riMidTerm=" + riMidTerm).append("\n");
		sb.append("riClass=" + riClass).append("\n");
		sb.append("riClassName=" + riClassName).append("\n");
		sb.append("riStuId=" + riStuId).append("\n");
		sb.append("riStuName=" + riStuName).append("\n");
		sb.append("riTestId=" + riTestId).append("\n");
		sb.append("riYw=" + riYw).append("\n");
		sb.append("riSx=" + riSx).append("\n");
		sb.append("riEng=" + riEng).append("\n");
		sb.append("riKx=" + riKx).append("\n");
		sb.append("riPs=" + riPs).append("\n");
		sb.append("riMs=" + riMs).append("\n");
		sb.append("riMus=" + riMus).append("\n");
		sb.append("riTy=" + riTy).append("\n");
		sb.append("riZj=" + riZj).append("\n");
		sb.append("riTot=" + riTot).append("\n");
		sb.append("riClassRan=" + riClassRan).append("\n");
		sb.append("riClassRanChg=" + riClassRanChg).append("\n");
		sb.append("riYwClsRan=" + riYwClsRan).append("\n");
		sb.append("riYwClsRanChg=" + riYwClsRanChg).append("\n");
		sb.append("riSxClsRan=" + riSxClsRan).append("\n");
		sb.append("riSxClsRanChg=" + riSxClsRanChg).append("\n");
		sb.append("riEngClsRan=" + riEngClsRan).append("\n");
		sb.append("riEngClsRanChg=" + riEngClsRanChg).append("\n");
		sb.append("riKxClsRan=" + riKxClsRan).append("\n");
		sb.append("riKxClsRanChg=" + riKxClsRanChg).append("\n");
		sb.append("riPsClsRan=" + riPsClsRan).append("\n");
		sb.append("riPsClsRanChg=" + riPsClsRanChg).append("\n");
		sb.append("riGradeRan2=" + riGradeRan2).append("\n");
		sb.append("riGradeRanChg2=" + riGradeRanChg2).append("\n");
		sb.append("riYwGraRan2=" + riYwGraRan2).append("\n");
		sb.append("riYwGraRanChg2=" + riYwGraRanChg2).append("\n");
		sb.append("riSxGraRan2=" + riSxGraRan2).append("\n");
		sb.append("riSxGraRanChg2=" + riSxGraRanChg2).append("\n");
		sb.append("riEngGraRan2=" + riEngGraRan2).append("\n");
		sb.append("riEngGraRanChg2=" + riEngGraRanChg2).append("\n");
		sb.append("riKxGraRan2=" + riKxGraRan2).append("\n");
		sb.append("riKxGraRanChg2=" + riKxGraRanChg2).append("\n");
		sb.append("riPsGraRan2=" + riPsGraRan2).append("\n");
		sb.append("riPsGraRanChg2=" + riPsGraRanChg2).append("\n");
		sb.append("riConEval=" + riConEval).append("\n");
		sb.append("riGenEval=" + riGenEval).append("\n");
		sb.append("riLeaderCommon=" + riLeaderCommon).append("\n");
		sb.append("riCommonUserId=" + riCommonUserId).append("\n");
		sb.append("riCommonUserName=" + riCommonUserName).append("\n");
		sb.append("riCommonDate=" + riCommonDate).append("\n");
		sb.append("riCommonTime=" + riCommonTime).append("\n");
		sb.append("addDate=" + addDate).append("\n");
		sb.append("addTime=" + addTime).append("\n");
		sb.append("addUser=" + addUser).append("\n");
		sb.append("addUserName=" + addUserName).append("\n");
		sb.append("updDate=" + updDate).append("\n");
		sb.append("updTime=" + updTime).append("\n");
		sb.append("updUser=" + updUser).append("\n");
		sb.append("updUserName=" + updUserName).append("\n");
		return sb.toString();
	}
}
