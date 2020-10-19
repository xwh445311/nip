package com.efs.bus.base.jtdj.controller;

/**
 * 
 * com.efs.bus.base.fyxx.controller.TbJtdjForm
 * @author xuwh
 * 2020-05-19 21:46:13
 * 阶梯单价
 *
 */
public class TbJtdjForm
{
	private String dbId;

	/**
	 * 用户性质
	 */
	private String ysxz;
	
	/**
	 * 费用代码
	 */
	private String fydm;
	
	/**
	 * 阶梯号
	 */
	private String jth;
	
	/**
	 * 阶梯单价
	 */
	private String jtdj;
	
	/**
	 * 阶梯起始
	 */
	private String jtqs;
	
	/**
	 * 阶梯结束
	 */
	private String jtjs;
	
	/**
	 * 删除标志，非0表示删除
	 */
	private String delbz;
	
	/**
	 * 添加日期
	 */
	private String csrq;
	
	
	/**
	 * 用户性质<br/>
	 * @return String ysxz
	 */
	public String getYsxz()
	{
		return ysxz;
	}

	/**
	 * 用户性质<br/>
	 * @param String ysxz
	 */
	public void setYsxz(String ysxz)
	{
		this.ysxz = ysxz;
	}
	
	/**
	 * 费用代码<br/>
	 * @return String fydm
	 */
	public String getFydm()
	{
		return fydm;
	}

	/**
	 * 费用代码<br/>
	 * @param String fydm
	 */
	public void setFydm(String fydm)
	{
		this.fydm = fydm;
	}
	
	/**
	 * 阶梯号<br/>
	 * @return String jth
	 */
	public String getJth()
	{
		return jth;
	}

	/**
	 * 阶梯号<br/>
	 * @param BigDecimal jth
	 */
	public void setJth(String jth)
	{
		this.jth = jth;
	}
	
	/**
	 * 阶梯单价<br/>
	 * @return String jtdj
	 */
	public String getJtdj()
	{
		return jtdj;
	}

	/**
	 * 阶梯单价<br/>
	 * @param BigDecimal jtdj
	 */
	public void setJtdj(String jtdj)
	{
		this.jtdj = jtdj;
	}
	
	/**
	 * 阶梯起始<br/>
	 * @return String jtqs
	 */
	public String getJtqs()
	{
		return jtqs;
	}

	/**
	 * 阶梯起始<br/>
	 * @param BigDecimal jtqs
	 */
	public void setJtqs(String jtqs)
	{
		this.jtqs = jtqs;
	}
	
	/**
	 * 阶梯结束<br/>
	 * @return String jtjs
	 */
	public String getJtjs()
	{
		return jtjs;
	}

	/**
	 * 阶梯结束<br/>
	 * @param BigDecimal jtjs
	 */
	public void setJtjs(String jtjs)
	{
		this.jtjs = jtjs;
	}
	
	/**
	 * 删除标志，非0表示删除<br/>
	 * @return String delbz
	 */
	public String getDelbz()
	{
		return delbz;
	}

	/**
	 * 删除标志，非0表示删除<br/>
	 * @param String delbz
	 */
	public void setDelbz(String delbz)
	{
		this.delbz = delbz;
	}
	
	/**
	 * 添加日期<br/>
	 * @return String csrq
	 */
	public String getCsrq()
	{
		return csrq;
	}

	/**
	 * 添加日期<br/>
	 * @param Date csrq
	 */
	public void setCsrq(String csrq)
	{
		this.csrq = csrq;
	}

	public String getDbId()
	{
		return dbId;
	}

	public void setDbId(String dbId)
	{
		this.dbId = dbId;
	}

	@Override
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		
		sb.append("ysxz=" + ysxz).append("\n");
		sb.append("fydm=" + fydm).append("\n");
		sb.append("jth=" + jth).append("\n");
		sb.append("jtdj=" + jtdj).append("\n");
		sb.append("jtqs=" + jtqs).append("\n");
		sb.append("jtjs=" + jtjs).append("\n");
		sb.append("delbz=" + delbz).append("\n");
		sb.append("csrq=" + csrq).append("\n");
		return sb.toString();
	}
}
