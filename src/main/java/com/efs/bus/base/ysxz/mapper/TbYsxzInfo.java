package com.efs.bus.base.ysxz.mapper;

import java.math.BigDecimal;

/**
 * 
 * com.efs.bus.base.ysxz.mapper.TbYsxzInfo
 * @author xuwh
 * 2020-05-17 20:59:30
 * 用水性质
 *
 */
public class TbYsxzInfo
{
	/**
	 * 性质代码
	 */
	private String xzdm;
	
	/**
	 * 性质名称
	 */
	private String xzmc;
	
	/**
	 * 未定义
	 */
	private String zzsbz;
	
	/**
	 * 未定义
	 */
	private BigDecimal znjjsl;
	
	/**
	 * 未定义
	 */
	private String delbz;
	
	/**
	 * 测试日期
	 */
	private String csrq;
	
	
	/**
	 * 性质代码<br/>
	 * @return String xzdm
	 */
	public String getXzdm()
	{
		return xzdm;
	}

	/**
	 * 性质代码<br/>
	 * @param String xzdm
	 */
	public void setXzdm(String xzdm)
	{
		this.xzdm = xzdm;
	}
	
	/**
	 * 性质名称<br/>
	 * @return String xzmc
	 */
	public String getXzmc()
	{
		return xzmc;
	}

	/**
	 * 性质名称<br/>
	 * @param String xzmc
	 */
	public void setXzmc(String xzmc)
	{
		this.xzmc = xzmc;
	}
	
	/**
	 * 未定义<br/>
	 * @return String zzsbz
	 */
	public String getZzsbz()
	{
		return zzsbz;
	}

	/**
	 * 未定义<br/>
	 * @param String zzsbz
	 */
	public void setZzsbz(String zzsbz)
	{
		this.zzsbz = zzsbz;
	}
	
	/**
	 * 未定义<br/>
	 * @return BigDecimal znjjsl
	 */
	public BigDecimal getZnjjsl()
	{
		return znjjsl;
	}

	/**
	 * 未定义<br/>
	 * @param BigDecimal znjjsl
	 */
	public void setZnjjsl(BigDecimal znjjsl)
	{
		this.znjjsl = znjjsl;
	}
	
	/**
	 * 未定义<br/>
	 * @return String delbz
	 */
	public String getDelbz()
	{
		return delbz;
	}

	/**
	 * 未定义<br/>
	 * @param String delbz
	 */
	public void setDelbz(String delbz)
	{
		this.delbz = delbz;
	}
	
	/**
	 * 测试日期<br/>
	 * @return String csrq
	 */
	public String getCsrq()
	{
		return csrq;
	}

	/**
	 * 测试日期<br/>
	 * @param String csrq
	 */
	public void setCsrq(String csrq)
	{
		this.csrq = csrq;
	}
	
	
	@Override
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		
		sb.append("xzdm=" + xzdm).append("\n");
		sb.append("xzmc=" + xzmc).append("\n");
		sb.append("zzsbz=" + zzsbz).append("\n");
		sb.append("znjjsl=" + znjjsl).append("\n");
		sb.append("delbz=" + delbz).append("\n");
		sb.append("csrq=" + csrq).append("\n");
		return sb.toString();
	}
}
