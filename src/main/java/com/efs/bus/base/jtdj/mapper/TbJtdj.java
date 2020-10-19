package com.efs.bus.base.jtdj.mapper;

import java.math.BigDecimal;

/**
 * 
 * com.efs.bus.base.fyxx.mapper.TbJtdj
 * @author xuwh
 * 2020-05-19 21:46:13
 * 阶梯单价
 *
 */
public class TbJtdj
{
	private String dbId;

	/**
	 * 用户性质
	 */
	private String ysxz;

	private String xzmc;
	
	/**
	 * 费用代码
	 */
	private String fydm;

	private String fymc;
	
	/**
	 * 阶梯号
	 */
	private Integer jth;
	
	/**
	 * 阶梯单价
	 */
	private BigDecimal jtdj;
	
	/**
	 * 阶梯起始
	 */
	private Integer jtqs;
	
	/**
	 * 阶梯结束
	 */
	private Integer jtjs;
	
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
	 * 阶梯单价<br/>
	 * @return BigDecimal jtdj
	 */
	public BigDecimal getJtdj()
	{
		return jtdj;
	}

	/**
	 * 阶梯单价<br/>
	 * @param BigDecimal jtdj
	 */
	public void setJtdj(BigDecimal jtdj)
	{
		this.jtdj = jtdj;
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

	public Integer getJth()
	{
		return jth;
	}

	public void setJth(Integer jth)
	{
		this.jth = jth;
	}

	public Integer getJtqs()
	{
		return jtqs;
	}

	public void setJtqs(Integer jtqs)
	{
		this.jtqs = jtqs;
	}

	public Integer getJtjs()
	{
		return jtjs;
	}

	public void setJtjs(Integer jtjs)
	{
		this.jtjs = jtjs;
	}

	public String getCsrq()
	{
		return csrq;
	}

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

	public String getXzmc()
	{
		return xzmc;
	}

	public void setXzmc(String xzmc)
	{
		this.xzmc = xzmc;
	}

	public String getFymc()
	{
		return fymc;
	}

	public void setFymc(String fymc)
	{
		this.fymc = fymc;
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
