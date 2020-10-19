package com.efs.bus.edu.scorestatic.mapper;

/**
 * 
 * com.efs.bus.edu.scorestatic.mapper.EduClassStaticResult
 * @author xwh
 * 2018-05-16 11:06:19
 * 
 *
 */
public class EduClassStaticResult
{
	/**
	 * 
	 */
	private String csTerm;
	
	/**
	 * 
	 */
	private String csTermName;
	
	/**
	 * 
	 */
	private String csMidTerm;
	
	/**
	 * 
	 */
	private String csClass;
	
	/**
	 * 
	 */
	private String csClassName;
	
	/**
	 * 
	 */
	private String csDesc1;
	
	/**
	 * 
	 */
	private String csDesc2;
	
	/**
	 * 
	 */
	private String yuw;
	
	/**
	 * 
	 */
	private String shx;
	
	/**
	 * 
	 */
	private String yiw;
	
	/**
	 * 
	 */
	private String pis;
	
	/**
	 * 
	 */
	private String kex;

	private String staticType;

	private String staticDesc;

	public String getStaticType()
	{
		return staticType;
	}

	public void setStaticType(String staticType)
	{
		this.staticType = staticType;
	}

	public String getStaticDesc()
	{
		return staticDesc;
	}

	public void setStaticDesc(String staticDesc)
	{
		this.staticDesc = staticDesc;
	}

	/**
	 * <br/>
	 * @return String csTerm
	 */
	public String getCsTerm()
	{
		return csTerm;
	}

	/**
	 * <br/>
	 * @param String csTerm
	 */
	public void setCsTerm(String csTerm)
	{
		this.csTerm = csTerm;
	}
	
	/**
	 * <br/>
	 * @return String csTermName
	 */
	public String getCsTermName()
	{
		return csTermName;
	}

	/**
	 * <br/>
	 * @param String csTermName
	 */
	public void setCsTermName(String csTermName)
	{
		this.csTermName = csTermName;
	}
	
	/**
	 * <br/>
	 * @return String csMidTerm
	 */
	public String getCsMidTerm()
	{
		return csMidTerm;
	}

	/**
	 * <br/>
	 * @param String csMidTerm
	 */
	public void setCsMidTerm(String csMidTerm)
	{
		this.csMidTerm = csMidTerm;
	}
	
	/**
	 * <br/>
	 * @return String csClass
	 */
	public String getCsClass()
	{
		return csClass;
	}

	/**
	 * <br/>
	 * @param String csClass
	 */
	public void setCsClass(String csClass)
	{
		this.csClass = csClass;
	}
	
	/**
	 * <br/>
	 * @return String csClassName
	 */
	public String getCsClassName()
	{
		return csClassName;
	}

	/**
	 * <br/>
	 * @param String csClassName
	 */
	public void setCsClassName(String csClassName)
	{
		this.csClassName = csClassName;
	}
	
	/**
	 * <br/>
	 * @return String csDesc1
	 */
	public String getCsDesc1()
	{
		return csDesc1;
	}

	/**
	 * <br/>
	 * @param String csDesc1
	 */
	public void setCsDesc1(String csDesc1)
	{
		this.csDesc1 = csDesc1;
	}
	
	/**
	 * <br/>
	 * @return String csDesc2
	 */
	public String getCsDesc2()
	{
		return csDesc2;
	}

	/**
	 * <br/>
	 * @param String csDesc2
	 */
	public void setCsDesc2(String csDesc2)
	{
		this.csDesc2 = csDesc2;
	}
	
	/**
	 * <br/>
	 * @return String yuw
	 */
	public String getYuw()
	{
		return yuw;
	}

	/**
	 * <br/>
	 * @param String yuw
	 */
	public void setYuw(String yuw)
	{
		this.yuw = yuw;
	}
	
	/**
	 * <br/>
	 * @return String shx
	 */
	public String getShx()
	{
		return shx;
	}

	/**
	 * <br/>
	 * @param String shx
	 */
	public void setShx(String shx)
	{
		this.shx = shx;
	}
	
	/**
	 * <br/>
	 * @return String yiw
	 */
	public String getYiw()
	{
		return yiw;
	}

	/**
	 * <br/>
	 * @param String yiw
	 */
	public void setYiw(String yiw)
	{
		this.yiw = yiw;
	}
	
	/**
	 * <br/>
	 * @return String pis
	 */
	public String getPis()
	{
		return pis;
	}

	/**
	 * <br/>
	 * @param String pis
	 */
	public void setPis(String pis)
	{
		this.pis = pis;
	}
	
	/**
	 * <br/>
	 * @return String kex
	 */
	public String getKex()
	{
		return kex;
	}

	/**
	 * <br/>
	 * @param String kex
	 */
	public void setKex(String kex)
	{
		this.kex = kex;
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
		sb.append("csDesc1=" + csDesc1).append("\n");
		sb.append("csDesc2=" + csDesc2).append("\n");
		sb.append("yuw=" + yuw).append("\n");
		sb.append("shx=" + shx).append("\n");
		sb.append("yiw=" + yiw).append("\n");
		sb.append("pis=" + pis).append("\n");
		sb.append("kex=" + kex).append("\n");
		return sb.toString();
	}
}
