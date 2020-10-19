package com.efs.bus.edu.scorerecord.mapper;

import java.io.File;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 
 * com.efs.bus.edu.scorerecord.mapper.EduRecordInfo
 * @author xuwh
 * 2018-05-04 23:25:56
 * 学生学习成绩信息表
 *
 */
public class EduRecordInfo implements Serializable
{
	/**
	 * 主键ID
	 */
	private Long riId;
	
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
	private BigDecimal riYw;
	
	/**
	 * 数学分数
	 */
	private BigDecimal riSx;
	
	/**
	 * 英语分数
	 */
	private BigDecimal riEng;
	
	/**
	 * 科学分数
	 */
	private BigDecimal riKx;
	
	/**
	 * 品德与社会分数
	 */
	private BigDecimal riPs;
	
	/**
	 * 美术分数
	 */
	private BigDecimal riMs;
	
	/**
	 * 音乐分数
	 */
	private BigDecimal riMus;
	
	/**
	 * 体育分数
	 */
	private BigDecimal riTy;
	
	/**
	 * 综合实践
	 */
	private BigDecimal riZj;

	/**
	 *
	 */
	private BigDecimal riYwChg;

	/**
	 *
	 */
	private BigDecimal riSxChg;

	/**
	 *
	 */
	private BigDecimal riEngChg;

	/**
	 *
	 */
	private BigDecimal riKxChg;

	/**
	 *
	 */
	private BigDecimal riPsChg;
	
	/**
	 * 总分
	 */
	private BigDecimal riTot;
	
	/**
	 * 总分班内排名
	 */
	private Integer riClassRan;
	
	/**
	 * 总分班内排名变化
	 */
	private Integer riClassRanChg;

	/**
	 * 总分班内排名变化
	 */
	private String riClassRanChgVal;
	
	/**
	 * 语文班内排名
	 */
	private Integer riYwClsRan;
	
	/**
	 * 语文班内排名变化
	 */
	private Integer riYwClsRanChg;

	/**
	 * 语文班内排名变化
	 */
	private String riYwClsRanChgVal;
	
	/**
	 * 数学班内排名
	 */
	private Integer riSxClsRan;
	
	/**
	 * 数学班内排名变化
	 */
	private Integer riSxClsRanChg;

	/**
	 * 数学班内排名变化
	 */
	private String riSxClsRanChgVal;
	
	/**
	 * 英语班内排名
	 */
	private Integer riEngClsRan;
	
	/**
	 * 英语班内排名变化
	 */
	private Integer riEngClsRanChg;

	/**
	 * 英语班内排名变化
	 */
	private String riEngClsRanChgVal;
	
	/**
	 * 科学班内排名
	 */
	private Integer riKxClsRan;
	
	/**
	 * 科学班内排名变化
	 */
	private Integer riKxClsRanChg;

	/**
	 * 科学班内排名变化
	 */
	private String riKxClsRanChgVal;
	
	/**
	 * 品社班内排名
	 */
	private Integer riPsClsRan;
	
	/**
	 * 品社班内排名变化
	 */
	private Integer riPsClsRanChg;

	/**
	 * 品社班内排名变化
	 */
	private String riPsClsRanChgVal;
	
	/**
	 * 总分年级排名
	 */
	private Integer riGradeRan2;
	
	/**
	 * 总分年级排名变化
	 */
	private Integer riGradeRanChg2;

	/**
	 * 总分年级排名变化
	 */
	private String riGradeRanChg2Val;
	
	/**
	 * 语文年级排名
	 */
	private Integer riYwGraRan2;
	
	/**
	 * 语文年级排名变化
	 */
	private Integer riYwGraRanChg2;

	/**
	 * 语文年级排名变化
	 */
	private String riYwGraRanChg2Val;
	
	/**
	 * 数学年级排名
	 */
	private Integer riSxGraRan2;
	
	/**
	 * 数学年级排名变化
	 */
	private Integer riSxGraRanChg2;

	/**
	 * 数学年级排名变化
	 */
	private String riSxGraRanChg2Val;
	
	/**
	 * 英语年级排名
	 */
	private Integer riEngGraRan2;
	
	/**
	 * 英语年级排名变化
	 */
	private Integer riEngGraRanChg2;

	/**
	 * 英语年级排名变化
	 */
	private String riEngGraRanChg2Val;
	
	/**
	 * 科学年级排名
	 */
	private Integer riKxGraRan2;
	
	/**
	 * 科学年级排名变化
	 */
	private Integer riKxGraRanChg2;

	/**
	 * 科学年级排名变化
	 */
	private String riKxGraRanChg2Val;
	
	/**
	 * 品社年级排名
	 */
	private Integer riPsGraRan2;
	
	/**
	 * 品社年级排名变化
	 */
	private Integer riPsGraRanChg2;

	/**
	 * 品社年级排名变化
	 */
	private String riPsGraRanChg2Val;
	
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

	//上传文件
	private File uploadFile;

	/**
	 * 是否已经评价
	 */
	private String hasCommon;

	public String getHasCommon()
	{
		return hasCommon;
	}

	public void setHasCommon(String hasCommon)
	{
		this.hasCommon = hasCommon;
	}

	public File getUploadFile()
	{
		return uploadFile;
	}

	public void setUploadFile(File uploadFile)
	{
		this.uploadFile = uploadFile;
	}

	public BigDecimal getRiYwChg()
	{
		return riYwChg;
	}

	public void setRiYwChg(BigDecimal riYwChg)
	{
		this.riYwChg = riYwChg;
	}

	public BigDecimal getRiSxChg()
	{
		return riSxChg;
	}

	public void setRiSxChg(BigDecimal riSxChg)
	{
		this.riSxChg = riSxChg;
	}

	public BigDecimal getRiEngChg()
	{
		return riEngChg;
	}

	public void setRiEngChg(BigDecimal riEngChg)
	{
		this.riEngChg = riEngChg;
	}

	public BigDecimal getRiKxChg()
	{
		return riKxChg;
	}

	public void setRiKxChg(BigDecimal riKxChg)
	{
		this.riKxChg = riKxChg;
	}

	public BigDecimal getRiPsChg()
	{
		return riPsChg;
	}

	public void setRiPsChg(BigDecimal riPsChg)
	{
		this.riPsChg = riPsChg;
	}

	/**
	 * 主键ID<br/>
	 * @return Long riId
	 */
	public Long getRiId()
	{
		return riId;
	}

	/**
	 * 主键ID<br/>
	 * @param Long riId
	 */
	public void setRiId(Long riId)
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
	 * @return BigDecimal riYw
	 */
	public BigDecimal getRiYw()
	{
		return riYw;
	}

	/**
	 * 语文分数<br/>
	 * @param BigDecimal riYw
	 */
	public void setRiYw(BigDecimal riYw)
	{
		this.riYw = riYw;
	}
	
	/**
	 * 数学分数<br/>
	 * @return BigDecimal riSx
	 */
	public BigDecimal getRiSx()
	{
		return riSx;
	}

	/**
	 * 数学分数<br/>
	 * @param BigDecimal riSx
	 */
	public void setRiSx(BigDecimal riSx)
	{
		this.riSx = riSx;
	}
	
	/**
	 * 英语分数<br/>
	 * @return BigDecimal riEng
	 */
	public BigDecimal getRiEng()
	{
		return riEng;
	}

	/**
	 * 英语分数<br/>
	 * @param BigDecimal riEng
	 */
	public void setRiEng(BigDecimal riEng)
	{
		this.riEng = riEng;
	}
	
	/**
	 * 科学分数<br/>
	 * @return BigDecimal riKx
	 */
	public BigDecimal getRiKx()
	{
		return riKx;
	}

	/**
	 * 科学分数<br/>
	 * @param BigDecimal riKx
	 */
	public void setRiKx(BigDecimal riKx)
	{
		this.riKx = riKx;
	}
	
	/**
	 * 品德与社会分数<br/>
	 * @return BigDecimal riPs
	 */
	public BigDecimal getRiPs()
	{
		return riPs;
	}

	/**
	 * 品德与社会分数<br/>
	 * @param BigDecimal riPs
	 */
	public void setRiPs(BigDecimal riPs)
	{
		this.riPs = riPs;
	}
	
	/**
	 * 美术分数<br/>
	 * @return BigDecimal riMs
	 */
	public BigDecimal getRiMs()
	{
		return riMs;
	}

	/**
	 * 美术分数<br/>
	 * @param BigDecimal riMs
	 */
	public void setRiMs(BigDecimal riMs)
	{
		this.riMs = riMs;
	}
	
	/**
	 * 音乐分数<br/>
	 * @return BigDecimal riMus
	 */
	public BigDecimal getRiMus()
	{
		return riMus;
	}

	/**
	 * 音乐分数<br/>
	 * @param BigDecimal riMus
	 */
	public void setRiMus(BigDecimal riMus)
	{
		this.riMus = riMus;
	}
	
	/**
	 * 体育分数<br/>
	 * @return BigDecimal riTy
	 */
	public BigDecimal getRiTy()
	{
		return riTy;
	}

	/**
	 * 体育分数<br/>
	 * @param BigDecimal riTy
	 */
	public void setRiTy(BigDecimal riTy)
	{
		this.riTy = riTy;
	}
	
	/**
	 * 综合实践<br/>
	 * @return BigDecimal riZj
	 */
	public BigDecimal getRiZj()
	{
		return riZj;
	}

	/**
	 * 综合实践<br/>
	 * @param BigDecimal riZj
	 */
	public void setRiZj(BigDecimal riZj)
	{
		this.riZj = riZj;
	}
	
	/**
	 * 总分<br/>
	 * @return BigDecimal riTot
	 */
	public BigDecimal getRiTot()
	{
		return riTot;
	}

	/**
	 * 总分<br/>
	 * @param BigDecimal riTot
	 */
	public void setRiTot(BigDecimal riTot)
	{
		this.riTot = riTot;
	}
	
	/**
	 * 总分班内排名<br/>
	 * @return Integer riClassRan
	 */
	public Integer getRiClassRan()
	{
		return riClassRan;
	}

	/**
	 * 总分班内排名<br/>
	 * @param Integer riClassRan
	 */
	public void setRiClassRan(Integer riClassRan)
	{
		this.riClassRan = riClassRan;
	}
	
	/**
	 * 总分班内排名变化<br/>
	 * @return Integer riClassRanChg
	 */
	public Integer getRiClassRanChg()
	{
		return riClassRanChg;
	}

	/**
	 * 总分班内排名变化<br/>
	 * @param Integer riClassRanChg
	 */
	public void setRiClassRanChg(Integer riClassRanChg)
	{
		this.riClassRanChg = riClassRanChg;
	}
	
	/**
	 * 语文班内排名<br/>
	 * @return Integer riYwClsRan
	 */
	public Integer getRiYwClsRan()
	{
		return riYwClsRan;
	}

	/**
	 * 语文班内排名<br/>
	 * @param Integer riYwClsRan
	 */
	public void setRiYwClsRan(Integer riYwClsRan)
	{
		this.riYwClsRan = riYwClsRan;
	}
	
	/**
	 * 语文班内排名变化<br/>
	 * @return Integer riYwClsRanChg
	 */
	public Integer getRiYwClsRanChg()
	{
		return riYwClsRanChg;
	}

	/**
	 * 语文班内排名变化<br/>
	 * @param Integer riYwClsRanChg
	 */
	public void setRiYwClsRanChg(Integer riYwClsRanChg)
	{
		this.riYwClsRanChg = riYwClsRanChg;
	}
	
	/**
	 * 数学班内排名<br/>
	 * @return Integer riSxClsRan
	 */
	public Integer getRiSxClsRan()
	{
		return riSxClsRan;
	}

	/**
	 * 数学班内排名<br/>
	 * @param Integer riSxClsRan
	 */
	public void setRiSxClsRan(Integer riSxClsRan)
	{
		this.riSxClsRan = riSxClsRan;
	}
	
	/**
	 * 数学班内排名变化<br/>
	 * @return Integer riSxClsRanChg
	 */
	public Integer getRiSxClsRanChg()
	{
		return riSxClsRanChg;
	}

	/**
	 * 数学班内排名变化<br/>
	 * @param Integer riSxClsRanChg
	 */
	public void setRiSxClsRanChg(Integer riSxClsRanChg)
	{
		this.riSxClsRanChg = riSxClsRanChg;
	}
	
	/**
	 * 英语班内排名<br/>
	 * @return Integer riEngClsRan
	 */
	public Integer getRiEngClsRan()
	{
		return riEngClsRan;
	}

	/**
	 * 英语班内排名<br/>
	 * @param Integer riEngClsRan
	 */
	public void setRiEngClsRan(Integer riEngClsRan)
	{
		this.riEngClsRan = riEngClsRan;
	}
	
	/**
	 * 英语班内排名变化<br/>
	 * @return Integer riEngClsRanChg
	 */
	public Integer getRiEngClsRanChg()
	{
		return riEngClsRanChg;
	}

	/**
	 * 英语班内排名变化<br/>
	 * @param Integer riEngClsRanChg
	 */
	public void setRiEngClsRanChg(Integer riEngClsRanChg)
	{
		this.riEngClsRanChg = riEngClsRanChg;
	}
	
	/**
	 * 科学班内排名<br/>
	 * @return Integer riKxClsRan
	 */
	public Integer getRiKxClsRan()
	{
		return riKxClsRan;
	}

	/**
	 * 科学班内排名<br/>
	 * @param Integer riKxClsRan
	 */
	public void setRiKxClsRan(Integer riKxClsRan)
	{
		this.riKxClsRan = riKxClsRan;
	}
	
	/**
	 * 科学班内排名变化<br/>
	 * @return Integer riKxClsRanChg
	 */
	public Integer getRiKxClsRanChg()
	{
		return riKxClsRanChg;
	}

	/**
	 * 科学班内排名变化<br/>
	 * @param Integer riKxClsRanChg
	 */
	public void setRiKxClsRanChg(Integer riKxClsRanChg)
	{
		this.riKxClsRanChg = riKxClsRanChg;
	}
	
	/**
	 * 品社班内排名<br/>
	 * @return Integer riPsClsRan
	 */
	public Integer getRiPsClsRan()
	{
		return riPsClsRan;
	}

	/**
	 * 品社班内排名<br/>
	 * @param Integer riPsClsRan
	 */
	public void setRiPsClsRan(Integer riPsClsRan)
	{
		this.riPsClsRan = riPsClsRan;
	}
	
	/**
	 * 品社班内排名变化<br/>
	 * @return Integer riPsClsRanChg
	 */
	public Integer getRiPsClsRanChg()
	{
		return riPsClsRanChg;
	}

	/**
	 * 品社班内排名变化<br/>
	 * @param Integer riPsClsRanChg
	 */
	public void setRiPsClsRanChg(Integer riPsClsRanChg)
	{
		this.riPsClsRanChg = riPsClsRanChg;
	}
	
	/**
	 * 总分年级排名<br/>
	 * @return Integer riGradeRan2
	 */
	public Integer getRiGradeRan2()
	{
		return riGradeRan2;
	}

	/**
	 * 总分年级排名<br/>
	 * @param Integer riGradeRan2
	 */
	public void setRiGradeRan2(Integer riGradeRan2)
	{
		this.riGradeRan2 = riGradeRan2;
	}
	
	/**
	 * 总分年级排名变化<br/>
	 * @return Integer riGradeRanChg2
	 */
	public Integer getRiGradeRanChg2()
	{
		return riGradeRanChg2;
	}

	/**
	 * 总分年级排名变化<br/>
	 * @param Integer riGradeRanChg2
	 */
	public void setRiGradeRanChg2(Integer riGradeRanChg2)
	{
		this.riGradeRanChg2 = riGradeRanChg2;
	}
	
	/**
	 * 语文年级排名<br/>
	 * @return Integer riYwGraRan2
	 */
	public Integer getRiYwGraRan2()
	{
		return riYwGraRan2;
	}

	/**
	 * 语文年级排名<br/>
	 * @param Integer riYwGraRan2
	 */
	public void setRiYwGraRan2(Integer riYwGraRan2)
	{
		this.riYwGraRan2 = riYwGraRan2;
	}
	
	/**
	 * 语文年级排名变化<br/>
	 * @return Integer riYwGraRanChg2
	 */
	public Integer getRiYwGraRanChg2()
	{
		return riYwGraRanChg2;
	}

	/**
	 * 语文年级排名变化<br/>
	 * @param Integer riYwGraRanChg2
	 */
	public void setRiYwGraRanChg2(Integer riYwGraRanChg2)
	{
		this.riYwGraRanChg2 = riYwGraRanChg2;
	}
	
	/**
	 * 数学年级排名<br/>
	 * @return Integer riSxGraRan2
	 */
	public Integer getRiSxGraRan2()
	{
		return riSxGraRan2;
	}

	/**
	 * 数学年级排名<br/>
	 * @param Integer riSxGraRan2
	 */
	public void setRiSxGraRan2(Integer riSxGraRan2)
	{
		this.riSxGraRan2 = riSxGraRan2;
	}
	
	/**
	 * 数学年级排名变化<br/>
	 * @return Integer riSxGraRanChg2
	 */
	public Integer getRiSxGraRanChg2()
	{
		return riSxGraRanChg2;
	}

	/**
	 * 数学年级排名变化<br/>
	 * @param Integer riSxGraRanChg2
	 */
	public void setRiSxGraRanChg2(Integer riSxGraRanChg2)
	{
		this.riSxGraRanChg2 = riSxGraRanChg2;
	}
	
	/**
	 * 英语年级排名<br/>
	 * @return Integer riEngGraRan2
	 */
	public Integer getRiEngGraRan2()
	{
		return riEngGraRan2;
	}

	/**
	 * 英语年级排名<br/>
	 * @param Integer riEngGraRan2
	 */
	public void setRiEngGraRan2(Integer riEngGraRan2)
	{
		this.riEngGraRan2 = riEngGraRan2;
	}
	
	/**
	 * 英语年级排名变化<br/>
	 * @return Integer riEngGraRanChg2
	 */
	public Integer getRiEngGraRanChg2()
	{
		return riEngGraRanChg2;
	}

	/**
	 * 英语年级排名变化<br/>
	 * @param Integer riEngGraRanChg2
	 */
	public void setRiEngGraRanChg2(Integer riEngGraRanChg2)
	{
		this.riEngGraRanChg2 = riEngGraRanChg2;
	}
	
	/**
	 * 科学年级排名<br/>
	 * @return Integer riKxGraRan2
	 */
	public Integer getRiKxGraRan2()
	{
		return riKxGraRan2;
	}

	/**
	 * 科学年级排名<br/>
	 * @param Integer riKxGraRan2
	 */
	public void setRiKxGraRan2(Integer riKxGraRan2)
	{
		this.riKxGraRan2 = riKxGraRan2;
	}
	
	/**
	 * 科学年级排名变化<br/>
	 * @return Integer riKxGraRanChg2
	 */
	public Integer getRiKxGraRanChg2()
	{
		return riKxGraRanChg2;
	}

	/**
	 * 科学年级排名变化<br/>
	 * @param Integer riKxGraRanChg2
	 */
	public void setRiKxGraRanChg2(Integer riKxGraRanChg2)
	{
		this.riKxGraRanChg2 = riKxGraRanChg2;
	}
	
	/**
	 * 品社年级排名<br/>
	 * @return Integer riPsGraRan2
	 */
	public Integer getRiPsGraRan2()
	{
		return riPsGraRan2;
	}

	/**
	 * 品社年级排名<br/>
	 * @param Integer riPsGraRan2
	 */
	public void setRiPsGraRan2(Integer riPsGraRan2)
	{
		this.riPsGraRan2 = riPsGraRan2;
	}
	
	/**
	 * 品社年级排名变化<br/>
	 * @return Integer riPsGraRanChg2
	 */
	public Integer getRiPsGraRanChg2()
	{
		return riPsGraRanChg2;
	}

	/**
	 * 品社年级排名变化<br/>
	 * @param Integer riPsGraRanChg2
	 */
	public void setRiPsGraRanChg2(Integer riPsGraRanChg2)
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

	public String getRiClassRanChgVal()
	{
		return riClassRanChgVal;
	}

	public void setRiClassRanChgVal(String riClassRanChgVal)
	{
		this.riClassRanChgVal = riClassRanChgVal;
	}

	public String getRiYwClsRanChgVal()
	{
		return riYwClsRanChgVal;
	}

	public void setRiYwClsRanChgVal(String riYwClsRanChgVal)
	{
		this.riYwClsRanChgVal = riYwClsRanChgVal;
	}

	public String getRiSxClsRanChgVal()
	{
		return riSxClsRanChgVal;
	}

	public void setRiSxClsRanChgVal(String riSxClsRanChgVal)
	{
		this.riSxClsRanChgVal = riSxClsRanChgVal;
	}

	public String getRiEngClsRanChgVal()
	{
		return riEngClsRanChgVal;
	}

	public void setRiEngClsRanChgVal(String riEngClsRanChgVal)
	{
		this.riEngClsRanChgVal = riEngClsRanChgVal;
	}

	public String getRiKxClsRanChgVal()
	{
		return riKxClsRanChgVal;
	}

	public void setRiKxClsRanChgVal(String riKxClsRanChgVal)
	{
		this.riKxClsRanChgVal = riKxClsRanChgVal;
	}

	public String getRiPsClsRanChgVal()
	{
		return riPsClsRanChgVal;
	}

	public void setRiPsClsRanChgVal(String riPsClsRanChgVal)
	{
		this.riPsClsRanChgVal = riPsClsRanChgVal;
	}

	public String getRiGradeRanChg2Val()
	{
		return riGradeRanChg2Val;
	}

	public void setRiGradeRanChg2Val(String riGradeRanChg2Val)
	{
		this.riGradeRanChg2Val = riGradeRanChg2Val;
	}

	public String getRiYwGraRanChg2Val()
	{
		return riYwGraRanChg2Val;
	}

	public void setRiYwGraRanChg2Val(String riYwGraRanChg2Val)
	{
		this.riYwGraRanChg2Val = riYwGraRanChg2Val;
	}

	public String getRiSxGraRanChg2Val()
	{
		return riSxGraRanChg2Val;
	}

	public void setRiSxGraRanChg2Val(String riSxGraRanChg2Val)
	{
		this.riSxGraRanChg2Val = riSxGraRanChg2Val;
	}

	public String getRiEngGraRanChg2Val()
	{
		return riEngGraRanChg2Val;
	}

	public void setRiEngGraRanChg2Val(String riEngGraRanChg2Val)
	{
		this.riEngGraRanChg2Val = riEngGraRanChg2Val;
	}

	public String getRiKxGraRanChg2Val()
	{
		return riKxGraRanChg2Val;
	}

	public void setRiKxGraRanChg2Val(String riKxGraRanChg2Val)
	{
		this.riKxGraRanChg2Val = riKxGraRanChg2Val;
	}

	public String getRiPsGraRanChg2Val()
	{
		return riPsGraRanChg2Val;
	}

	public void setRiPsGraRanChg2Val(String riPsGraRanChg2Val)
	{
		this.riPsGraRanChg2Val = riPsGraRanChg2Val;
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
