package com.efs.bus.base.tsbz.mapper;

import java.math.BigDecimal;

/**
 * 
 * com.efs.bus.base.tsbz.mapper.TbTsbz
 * @author xuwh
 * 2020-05-20 20:55:43
 * 特殊关系表
 *
 */
public class TbTsbz
{
	/**
	 * 代码
	 */
	private String bm;
	
	/**
	 * 关系名称
	 */
	private String mc;
	
	/**
	 * 加减用量
	 */
	private Integer jssl;
	
	
	/**
	 * 代码<br/>
	 * @return String bm
	 */
	public String getBm()
	{
		return bm;
	}

	/**
	 * 代码<br/>
	 * @param String bm
	 */
	public void setBm(String bm)
	{
		this.bm = bm;
	}
	
	/**
	 * 关系名称<br/>
	 * @return String mc
	 */
	public String getMc()
	{
		return mc;
	}

	/**
	 * 关系名称<br/>
	 * @param String mc
	 */
	public void setMc(String mc)
	{
		this.mc = mc;
	}
	
	/**
	 * 加减用量<br/>
	 * @return BigDecimal jssl
	 */
	public Integer getJssl()
	{
		return jssl;
	}

	/**
	 * 加减用量<br/>
	 * @param BigDecimal jssl
	 */
	public void setJssl(Integer jssl)
	{
		this.jssl = jssl;
	}
	
	
	@Override
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		
		sb.append("bm=" + bm).append("\n");
		sb.append("mc=" + mc).append("\n");
		sb.append("jssl=" + jssl).append("\n");
		return sb.toString();
	}
}
