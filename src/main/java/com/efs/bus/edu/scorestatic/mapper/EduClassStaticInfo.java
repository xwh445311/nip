package com.efs.bus.edu.scorestatic.mapper;

import java.io.Serializable;
import java.math.BigDecimal;
import java.text.DecimalFormat;

/**
 * 
 * com.efs.bus.edu.scorestatic.mapper.EduClassStaticInfo
 * @author xuwh
 * 2018-05-12 21:06:11
 * 班级成绩统计表
 *
 */
public class EduClassStaticInfo implements Serializable
{
	/**
	 * 学期
	 */
	private String csTerm;
	
	/**
	 * 学期名称
	 */
	private String csTermName;
	
	/**
	 * 期中/期末
	 */
	private String csMidTerm;
	
	/**
	 * 班级
	 */
	private String csClass;
	
	/**
	 * 班级名称
	 */
	private String csClassName;
	
	/**
	 * 班主任
	 */
	private String csLead;
	
	/**
	 * 班主任姓名
	 */
	private String csLeadName;
	
	/**
	 * 课程
	 */
	private String csCourCode;
	
	/**
	 * 课程名称
	 */
	private String csCourName;
	
	/**
	 * 任课老师
	 */
	private String csCourTeacher;
	
	/**
	 * 任课老师姓名
	 */
	private String csCourTeacherNm;
	
	/**
	 * 课程应考人
	 */
	private Integer csCourYkr;
	
	/**
	 * 课程实考人
	 */
	private Integer csCourSkr;
	
	/**
	 * 课程参考率
	 */
	private BigDecimal csCourCkl;

	private String csCourCklVal;
	
	/**
	 * 课程总分
	 */
	private BigDecimal csCourZf;
	
	/**
	 * 课程均分
	 */
	private BigDecimal csCourJf;
	
	/**
	 * 课程均分排名
	 */
	private Integer csCourJfPm;
	
	/**
	 * 课程均分排名变化
	 */
	private Integer csCourJfPmbh;
	
	/**
	 * 课程高分人数
	 */
	private Integer csCourGfrs;
	
	/**
	 * 课程高分率
	 */
	private BigDecimal csCourGfl;

	private String csCourGflVal;
	
	/**
	 * 课程高分率排名
	 */
	private Integer csCourGflPm;
	
	/**
	 * 课程高分率排名变化
	 */
	private Integer csCourGflPmbh;
	
	/**
	 * 课程优分人数
	 */
	private Integer csCourYfrs;
	
	/**
	 * 课程优分率
	 */
	private BigDecimal csCourYfl;

	private String csCourYflVal;
	
	/**
	 * 课程优分率排名
	 */
	private Integer csCourYflPm;
	
	/**
	 * 课程优分率排名变化
	 */
	private Integer csCourYflPmbh;
	
	/**
	 * 课程及格人数
	 */
	private Integer csCourJgrs;
	
	/**
	 * 课程及格率
	 */
	private BigDecimal csCourJgl;

	private String csCourJglVal;
	
	/**
	 * 课程及格率排名
	 */
	private Integer csCourJglPm;
	
	/**
	 * 课程及格率排名变化
	 */
	private Integer csCourJglPmbh;
	
	/**
	 * 课程低分人数
	 */
	private Integer csCourDfrs;
	
	/**
	 * 课程低分率
	 */
	private BigDecimal csCourDfl;

	private String csCourDflVal;
	
	/**
	 * 课程低分率排名
	 */
	private Integer csCourDflPm;
	
	/**
	 * 课程低分率排名变化
	 */
	private Integer csCourDflPmbh;

	/**
	 * 实际考试人数
	 */
	private Integer csKsrs;

	public Integer getCsKsrs()
	{
		return csKsrs;
	}

	public void setCsKsrs(Integer csKsrs)
	{
		this.csKsrs = csKsrs;
	}

	/**
	 * 学期<br/>
	 * @return String csTerm
	 */
	public String getCsTerm()
	{
		return csTerm;
	}

	/**
	 * 学期<br/>
	 * @param String csTerm
	 */
	public void setCsTerm(String csTerm)
	{
		this.csTerm = csTerm;
	}
	
	/**
	 * 学期名称<br/>
	 * @return String csTermName
	 */
	public String getCsTermName()
	{
		return csTermName;
	}

	/**
	 * 学期名称<br/>
	 * @param String csTermName
	 */
	public void setCsTermName(String csTermName)
	{
		this.csTermName = csTermName;
	}
	
	/**
	 * 期中/期末<br/>
	 * @return String csMidTerm
	 */
	public String getCsMidTerm()
	{
		return csMidTerm;
	}

	/**
	 * 期中/期末<br/>
	 * @param String csMidTerm
	 */
	public void setCsMidTerm(String csMidTerm)
	{
		this.csMidTerm = csMidTerm;
	}
	
	/**
	 * 班级<br/>
	 * @return String csClass
	 */
	public String getCsClass()
	{
		return csClass;
	}

	/**
	 * 班级<br/>
	 * @param String csClass
	 */
	public void setCsClass(String csClass)
	{
		this.csClass = csClass;
	}
	
	/**
	 * 班级名称<br/>
	 * @return String csClassName
	 */
	public String getCsClassName()
	{
		return csClassName;
	}

	/**
	 * 班级名称<br/>
	 * @param String csClassName
	 */
	public void setCsClassName(String csClassName)
	{
		this.csClassName = csClassName;
	}
	
	/**
	 * 班主任<br/>
	 * @return String csLead
	 */
	public String getCsLead()
	{
		return csLead;
	}

	/**
	 * 班主任<br/>
	 * @param String csLead
	 */
	public void setCsLead(String csLead)
	{
		this.csLead = csLead;
	}
	
	/**
	 * 班主任姓名<br/>
	 * @return String csLeadName
	 */
	public String getCsLeadName()
	{
		return csLeadName;
	}

	/**
	 * 班主任姓名<br/>
	 * @param String csLeadName
	 */
	public void setCsLeadName(String csLeadName)
	{
		this.csLeadName = csLeadName;
	}
	
	/**
	 * 课程<br/>
	 * @return String csCourCode
	 */
	public String getCsCourCode()
	{
		return csCourCode;
	}

	/**
	 * 课程<br/>
	 * @param String csCourCode
	 */
	public void setCsCourCode(String csCourCode)
	{
		this.csCourCode = csCourCode;
	}
	
	/**
	 * 课程名称<br/>
	 * @return String csCourName
	 */
	public String getCsCourName()
	{
		return csCourName;
	}

	/**
	 * 课程名称<br/>
	 * @param String csCourName
	 */
	public void setCsCourName(String csCourName)
	{
		this.csCourName = csCourName;
	}
	
	/**
	 * 任课老师<br/>
	 * @return String csCourTeacher
	 */
	public String getCsCourTeacher()
	{
		return csCourTeacher;
	}

	/**
	 * 任课老师<br/>
	 * @param String csCourTeacher
	 */
	public void setCsCourTeacher(String csCourTeacher)
	{
		this.csCourTeacher = csCourTeacher;
	}
	
	/**
	 * 任课老师姓名<br/>
	 * @return String csCourTeacherNm
	 */
	public String getCsCourTeacherNm()
	{
		return csCourTeacherNm;
	}

	/**
	 * 任课老师姓名<br/>
	 * @param String csCourTeacherNm
	 */
	public void setCsCourTeacherNm(String csCourTeacherNm)
	{
		this.csCourTeacherNm = csCourTeacherNm;
	}
	
	/**
	 * 课程应考人<br/>
	 * @return Integer csCourYkr
	 */
	public Integer getCsCourYkr()
	{
		return csCourYkr;
	}

	/**
	 * 课程应考人<br/>
	 * @param Integer csCourYkr
	 */
	public void setCsCourYkr(Integer csCourYkr)
	{
		this.csCourYkr = csCourYkr;
	}
	
	/**
	 * 课程实考人<br/>
	 * @return Integer csCourSkr
	 */
	public Integer getCsCourSkr()
	{
		return csCourSkr;
	}

	/**
	 * 课程实考人<br/>
	 * @param Integer csCourSkr
	 */
	public void setCsCourSkr(Integer csCourSkr)
	{
		this.csCourSkr = csCourSkr;
	}
	
	/**
	 * 课程参考率<br/>
	 * @return BigDecimal csCourCkl
	 */
	public BigDecimal getCsCourCkl()
	{
		return csCourCkl;
	}

	/**
	 * 课程参考率<br/>
	 * @param BigDecimal csCourCkl
	 */
	public void setCsCourCkl(BigDecimal csCourCkl)
	{
		this.csCourCkl = csCourCkl;
	}
	
	/**
	 * 课程总分<br/>
	 * @return BigDecimal csCourZf
	 */
	public BigDecimal getCsCourZf()
	{
		return csCourZf;
	}

	/**
	 * 课程总分<br/>
	 * @param BigDecimal csCourZf
	 */
	public void setCsCourZf(BigDecimal csCourZf)
	{
		this.csCourZf = csCourZf;
	}
	
	/**
	 * 课程均分<br/>
	 * @return BigDecimal csCourJf
	 */
	public BigDecimal getCsCourJf()
	{
		return csCourJf;
	}

	/**
	 * 课程均分<br/>
	 * @param BigDecimal csCourJf
	 */
	public void setCsCourJf(BigDecimal csCourJf)
	{
		this.csCourJf = csCourJf;
	}
	
	/**
	 * 课程均分排名<br/>
	 * @return Integer csCourJfPm
	 */
	public Integer getCsCourJfPm()
	{
		return csCourJfPm;
	}

	/**
	 * 课程均分排名<br/>
	 * @param Integer csCourJfPm
	 */
	public void setCsCourJfPm(Integer csCourJfPm)
	{
		this.csCourJfPm = csCourJfPm;
	}
	
	/**
	 * 课程均分排名变化<br/>
	 * @return Integer csCourJfPmbh
	 */
	public Integer getCsCourJfPmbh()
	{
		return csCourJfPmbh;
	}

	/**
	 * 课程均分排名变化<br/>
	 * @param Integer csCourJfPmbh
	 */
	public void setCsCourJfPmbh(Integer csCourJfPmbh)
	{
		this.csCourJfPmbh = csCourJfPmbh;
	}
	
	/**
	 * 课程高分人数<br/>
	 * @return Integer csCourGfrs
	 */
	public Integer getCsCourGfrs()
	{
		return csCourGfrs;
	}

	/**
	 * 课程高分人数<br/>
	 * @param Integer csCourGfrs
	 */
	public void setCsCourGfrs(Integer csCourGfrs)
	{
		this.csCourGfrs = csCourGfrs;
	}
	
	/**
	 * 课程高分率<br/>
	 * @return BigDecimal csCourGfl
	 */
	public BigDecimal getCsCourGfl()
	{
		return csCourGfl;
	}

	/**
	 * 课程高分率<br/>
	 * @param BigDecimal csCourGfl
	 */
	public void setCsCourGfl(BigDecimal csCourGfl)
	{
		this.csCourGfl = csCourGfl;
	}
	
	/**
	 * 课程高分率排名<br/>
	 * @return Integer csCourGflPm
	 */
	public Integer getCsCourGflPm()
	{
		return csCourGflPm;
	}

	/**
	 * 课程高分率排名<br/>
	 * @param Integer csCourGflPm
	 */
	public void setCsCourGflPm(Integer csCourGflPm)
	{
		this.csCourGflPm = csCourGflPm;
	}
	
	/**
	 * 课程高分率排名变化<br/>
	 * @return Integer csCourGflPmbh
	 */
	public Integer getCsCourGflPmbh()
	{
		return csCourGflPmbh;
	}

	/**
	 * 课程高分率排名变化<br/>
	 * @param Integer csCourGflPmbh
	 */
	public void setCsCourGflPmbh(Integer csCourGflPmbh)
	{
		this.csCourGflPmbh = csCourGflPmbh;
	}
	
	/**
	 * 课程优分人数<br/>
	 * @return Integer csCourYfrs
	 */
	public Integer getCsCourYfrs()
	{
		return csCourYfrs;
	}

	/**
	 * 课程优分人数<br/>
	 * @param Integer csCourYfrs
	 */
	public void setCsCourYfrs(Integer csCourYfrs)
	{
		this.csCourYfrs = csCourYfrs;
	}
	
	/**
	 * 课程优分率<br/>
	 * @return BigDecimal csCourYfl
	 */
	public BigDecimal getCsCourYfl()
	{
		return csCourYfl;
	}

	/**
	 * 课程优分率<br/>
	 * @param BigDecimal csCourYfl
	 */
	public void setCsCourYfl(BigDecimal csCourYfl)
	{
		this.csCourYfl = csCourYfl;
	}
	
	/**
	 * 课程优分率排名<br/>
	 * @return Integer csCourYflPm
	 */
	public Integer getCsCourYflPm()
	{
		return csCourYflPm;
	}

	/**
	 * 课程优分率排名<br/>
	 * @param Integer csCourYflPm
	 */
	public void setCsCourYflPm(Integer csCourYflPm)
	{
		this.csCourYflPm = csCourYflPm;
	}
	
	/**
	 * 课程优分率排名变化<br/>
	 * @return Integer csCourYflPmbh
	 */
	public Integer getCsCourYflPmbh()
	{
		return csCourYflPmbh;
	}

	/**
	 * 课程优分率排名变化<br/>
	 * @param Integer csCourYflPmbh
	 */
	public void setCsCourYflPmbh(Integer csCourYflPmbh)
	{
		this.csCourYflPmbh = csCourYflPmbh;
	}
	
	/**
	 * 课程及格人数<br/>
	 * @return Integer csCourJgrs
	 */
	public Integer getCsCourJgrs()
	{
		return csCourJgrs;
	}

	/**
	 * 课程及格人数<br/>
	 * @param Integer csCourJgrs
	 */
	public void setCsCourJgrs(Integer csCourJgrs)
	{
		this.csCourJgrs = csCourJgrs;
	}
	
	/**
	 * 课程及格率<br/>
	 * @return BigDecimal csCourJgl
	 */
	public BigDecimal getCsCourJgl()
	{
		return csCourJgl;
	}

	/**
	 * 课程及格率<br/>
	 * @param BigDecimal csCourJgl
	 */
	public void setCsCourJgl(BigDecimal csCourJgl)
	{
		this.csCourJgl = csCourJgl;
	}
	
	/**
	 * 课程及格率排名<br/>
	 * @return Integer csCourJglPm
	 */
	public Integer getCsCourJglPm()
	{
		return csCourJglPm;
	}

	/**
	 * 课程及格率排名<br/>
	 * @param Integer csCourJglPm
	 */
	public void setCsCourJglPm(Integer csCourJglPm)
	{
		this.csCourJglPm = csCourJglPm;
	}
	
	/**
	 * 课程及格率排名变化<br/>
	 * @return Integer csCourJglPmbh
	 */
	public Integer getCsCourJglPmbh()
	{
		return csCourJglPmbh;
	}

	/**
	 * 课程及格率排名变化<br/>
	 * @param Integer csCourJglPmbh
	 */
	public void setCsCourJglPmbh(Integer csCourJglPmbh)
	{
		this.csCourJglPmbh = csCourJglPmbh;
	}
	
	/**
	 * 课程低分人数<br/>
	 * @return Integer csCourDfrs
	 */
	public Integer getCsCourDfrs()
	{
		return csCourDfrs;
	}

	/**
	 * 课程低分人数<br/>
	 * @param Integer csCourDfrs
	 */
	public void setCsCourDfrs(Integer csCourDfrs)
	{
		this.csCourDfrs = csCourDfrs;
	}
	
	/**
	 * 课程低分率<br/>
	 * @return BigDecimal csCourDfl
	 */
	public BigDecimal getCsCourDfl()
	{
		return csCourDfl;
	}

	/**
	 * 课程低分率<br/>
	 * @param BigDecimal csCourDfl
	 */
	public void setCsCourDfl(BigDecimal csCourDfl)
	{
		this.csCourDfl = csCourDfl;
	}
	
	/**
	 * 课程低分率排名<br/>
	 * @return Integer csCourDflPm
	 */
	public Integer getCsCourDflPm()
	{
		return csCourDflPm;
	}

	/**
	 * 课程低分率排名<br/>
	 * @param Integer csCourDflPm
	 */
	public void setCsCourDflPm(Integer csCourDflPm)
	{
		this.csCourDflPm = csCourDflPm;
	}
	
	/**
	 * 课程低分率排名变化<br/>
	 * @return Integer csCourDflPmbh
	 */
	public Integer getCsCourDflPmbh()
	{
		return csCourDflPmbh;
	}

	/**
	 * 课程低分率排名变化<br/>
	 * @param Integer csCourDflPmbh
	 */
	public void setCsCourDflPmbh(Integer csCourDflPmbh)
	{
		this.csCourDflPmbh = csCourDflPmbh;
	}

	public String getCsCourCklVal()
	{
		csCourCklVal = convertToRate(csCourCkl);
		return csCourCklVal;
	}

	public String getCsCourGflVal()
	{
		csCourGflVal = convertToRate(csCourGfl);
		return csCourGflVal;
	}

	public String getCsCourYflVal()
	{
		csCourYflVal = convertToRate(csCourYfl);
		return csCourYflVal;
	}

	public String getCsCourJglVal()
	{
		csCourJglVal = convertToRate(csCourJgl);
		return csCourJglVal;
	}

	public String getCsCourDflVal()
	{
		csCourDflVal = convertToRate(csCourDfl);
		return csCourDflVal;
	}

	private String convertToRate(BigDecimal input)
	{
		DecimalFormat format = new DecimalFormat("0.###%");
		if(input != null)
		{
			double di = input.doubleValue();

			return format.format(di);
		}
		else
		{
			return null;
		}
	}
	
	
	@Override
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		
		sb.append("csTerm=" + csTerm).append("\n");
		sb.append("csTermName=" + csTermName).append("\n");
		sb.append("csMidTerm=" + csMidTerm).append("\n");
		sb.append("csClass=" + csClass).append("\n");
		sb.append("csClassName=" + csClassName).append("\n");
		sb.append("csLead=" + csLead).append("\n");
		sb.append("csLeadName=" + csLeadName).append("\n");
		sb.append("csCourCode=" + csCourCode).append("\n");
		sb.append("csCourName=" + csCourName).append("\n");
		sb.append("csCourTeacher=" + csCourTeacher).append("\n");
		sb.append("csCourTeacherNm=" + csCourTeacherNm).append("\n");
		sb.append("csCourYkr=" + csCourYkr).append("\n");
		sb.append("csCourSkr=" + csCourSkr).append("\n");
		sb.append("csCourCkl=" + csCourCkl).append("\n");
		sb.append("csCourZf=" + csCourZf).append("\n");
		sb.append("csCourJf=" + csCourJf).append("\n");
		sb.append("csCourJfPm=" + csCourJfPm).append("\n");
		sb.append("csCourJfPmbh=" + csCourJfPmbh).append("\n");
		sb.append("csCourGfrs=" + csCourGfrs).append("\n");
		sb.append("csCourGfl=" + csCourGfl).append("\n");
		sb.append("csCourGflPm=" + csCourGflPm).append("\n");
		sb.append("csCourGflPmbh=" + csCourGflPmbh).append("\n");
		sb.append("csCourYfrs=" + csCourYfrs).append("\n");
		sb.append("csCourYfl=" + csCourYfl).append("\n");
		sb.append("csCourYflPm=" + csCourYflPm).append("\n");
		sb.append("csCourYflPmbh=" + csCourYflPmbh).append("\n");
		sb.append("csCourJgrs=" + csCourJgrs).append("\n");
		sb.append("csCourJgl=" + csCourJgl).append("\n");
		sb.append("csCourJglPm=" + csCourJglPm).append("\n");
		sb.append("csCourJglPmbh=" + csCourJglPmbh).append("\n");
		sb.append("csCourDfrs=" + csCourDfrs).append("\n");
		sb.append("csCourDfl=" + csCourDfl).append("\n");
		sb.append("csCourDflPm=" + csCourDflPm).append("\n");
		sb.append("csCourDflPmbh=" + csCourDflPmbh).append("\n");
		return sb.toString();
	}
}
