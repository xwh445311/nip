package com.efs.bus.base.qylsl.controller;

/**
 * 
 * com.efs.bus.base.qylsl.controller.TbSbqylForm
 * @author xwh
 * 2020-08-08 22:41:38
 * 启用量设立
 *
 */
public class TbSbqylForm
{
	/**
	 * 主键ID
	 */
	private String dbId;
	
	/**
	 * 性质代码
	 */
	private String xzdm;
	
	/**
	 * 水表口径
	 */
	private String sbkj;
	
	/**
	 * 启用量
	 */
	private String qyl;
	
	
	/**
	 * 主键ID<br/>
	 * @return String dbId
	 */
	public String getDbId()
	{
		return dbId;
	}

	/**
	 * 主键ID<br/>
	 * @param String dbId
	 */
	public void setDbId(String dbId)
	{
		this.dbId = dbId;
	}
	
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
	 * 启用量<br/>
	 * @return String qyl
	 */
	public String getQyl()
	{
		return qyl;
	}

	/**
	 * 启用量<br/>
	 * @param BigDecimal qyl
	 */
	public void setQyl(String qyl)
	{
		this.qyl = qyl;
	}
	
	
	@Override
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		
		sb.append("dbId=" + dbId).append("\n");
		sb.append("xzdm=" + xzdm).append("\n");
		sb.append("sbkj=" + sbkj).append("\n");
		sb.append("qyl=" + qyl).append("\n");
		return sb.toString();
	}
}
