package com.efs.bus.base.sbkj.mapper;

import java.math.BigDecimal;

/**
 * 
 * com.efs.bus.base.sbkj.mapper.TbSbkjInfo
 * @author xwh
 * 2020-05-17 11:59:17
 * 水表口径信息
 *
 */
public class TbSbkjInfo
{
	/**
	 * 水表口径
	 */
	private Integer sbkj;
	
	/**
	 * 最小用量
	 */
	private BigDecimal zxyl;
	
	/**
	 * 公称用量
	 */
	private BigDecimal gcyl;
	
	/**
	 * 最大用量
	 */
	private BigDecimal zdyl;
	
	/**
	 * 日均用量
	 */
	private BigDecimal rjyl;
	
	/**
	 * 未定义
	 */
	private Integer bjsl;
	
	
	/**
	 * 水表口径<br/>
	 * @return BigDecimal sbkj
	 */
	public Integer getSbkj()
	{
		return sbkj;
	}

	/**
	 * 水表口径<br/>
	 * @param BigDecimal sbkj
	 */
	public void setSbkj(Integer sbkj)
	{
		this.sbkj = sbkj;
	}
	
	/**
	 * 最小用量<br/>
	 * @return BigDecimal zxyl
	 */
	public BigDecimal getZxyl()
	{
		return zxyl;
	}

	/**
	 * 最小用量<br/>
	 * @param BigDecimal zxyl
	 */
	public void setZxyl(BigDecimal zxyl)
	{
		this.zxyl = zxyl;
	}
	
	/**
	 * 公称用量<br/>
	 * @return BigDecimal gcyl
	 */
	public BigDecimal getGcyl()
	{
		return gcyl;
	}

	/**
	 * 公称用量<br/>
	 * @param BigDecimal gcyl
	 */
	public void setGcyl(BigDecimal gcyl)
	{
		this.gcyl = gcyl;
	}
	
	/**
	 * 最大用量<br/>
	 * @return BigDecimal zdyl
	 */
	public BigDecimal getZdyl()
	{
		return zdyl;
	}

	/**
	 * 最大用量<br/>
	 * @param BigDecimal zdyl
	 */
	public void setZdyl(BigDecimal zdyl)
	{
		this.zdyl = zdyl;
	}
	
	/**
	 * 日均用量<br/>
	 * @return BigDecimal rjyl
	 */
	public BigDecimal getRjyl()
	{
		return rjyl;
	}

	/**
	 * 日均用量<br/>
	 * @param BigDecimal rjyl
	 */
	public void setRjyl(BigDecimal rjyl)
	{
		this.rjyl = rjyl;
	}
	
	/**
	 * 未定义<br/>
	 * @return BigDecimal bjsl
	 */
	public Integer getBjsl()
	{
		return bjsl;
	}

	/**
	 * 未定义<br/>
	 * @param BigDecimal bjsl
	 */
	public void setBjsl(Integer bjsl)
	{
		this.bjsl = bjsl;
	}
	
	
	@Override
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		
		sb.append("sbkj=" + sbkj).append("\n");
		sb.append("zxyl=" + zxyl).append("\n");
		sb.append("gcyl=" + gcyl).append("\n");
		sb.append("zdyl=" + zdyl).append("\n");
		sb.append("rjyl=" + rjyl).append("\n");
		sb.append("bjsl=" + bjsl).append("\n");
		return sb.toString();
	}
}
