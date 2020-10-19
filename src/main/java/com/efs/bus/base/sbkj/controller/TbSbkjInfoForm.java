package com.efs.bus.base.sbkj.controller;

/**
 * 
 * com.efs.bus.base.sbkj.controller.TbSbkjInfoForm
 * @author xwh
 * 2020-05-17 11:59:17
 * 水表口径信息
 *
 */
public class TbSbkjInfoForm
{
	/**
	 * 水表口径
	 */
	private String sbkj;
	
	/**
	 * 最小用量
	 */
	private String zxyl;
	
	/**
	 * 公称用量
	 */
	private String gcyl;
	
	/**
	 * 最大用量
	 */
	private String zdyl;
	
	/**
	 * 日均用量
	 */
	private String rjyl;
	
	/**
	 * 未定义
	 */
	private String bjsl;
	
	
	/**
	 * 水表口径<br/>
	 * @return String sbkj
	 */
	public String getSbkj()
	{
		return sbkj;
	}

	/**
	 * 水表口径<br/>
	 * @param BigDecimal sbkj
	 */
	public void setSbkj(String sbkj)
	{
		this.sbkj = sbkj;
	}
	
	/**
	 * 最小用量<br/>
	 * @return String zxyl
	 */
	public String getZxyl()
	{
		return zxyl;
	}

	/**
	 * 最小用量<br/>
	 * @param BigDecimal zxyl
	 */
	public void setZxyl(String zxyl)
	{
		this.zxyl = zxyl;
	}
	
	/**
	 * 公称用量<br/>
	 * @return String gcyl
	 */
	public String getGcyl()
	{
		return gcyl;
	}

	/**
	 * 公称用量<br/>
	 * @param BigDecimal gcyl
	 */
	public void setGcyl(String gcyl)
	{
		this.gcyl = gcyl;
	}
	
	/**
	 * 最大用量<br/>
	 * @return String zdyl
	 */
	public String getZdyl()
	{
		return zdyl;
	}

	/**
	 * 最大用量<br/>
	 * @param BigDecimal zdyl
	 */
	public void setZdyl(String zdyl)
	{
		this.zdyl = zdyl;
	}
	
	/**
	 * 日均用量<br/>
	 * @return String rjyl
	 */
	public String getRjyl()
	{
		return rjyl;
	}

	/**
	 * 日均用量<br/>
	 * @param BigDecimal rjyl
	 */
	public void setRjyl(String rjyl)
	{
		this.rjyl = rjyl;
	}
	
	/**
	 * 未定义<br/>
	 * @return String bjsl
	 */
	public String getBjsl()
	{
		return bjsl;
	}

	/**
	 * 未定义<br/>
	 * @param BigDecimal bjsl
	 */
	public void setBjsl(String bjsl)
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
