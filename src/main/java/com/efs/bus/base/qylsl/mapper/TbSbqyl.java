package com.efs.bus.base.qylsl.mapper;

/**
 * 
 * com.efs.bus.base.qylsl.mapper.TbSbqyl
 * @author xwh
 * 2020-08-08 22:41:38
 * 启用量设立
 *
 */
public class TbSbqyl
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
	 * 性质名称
	 */
	private String xzmc;
	
	/**
	 * 水表口径
	 */
	private Integer sbkj;
	
	/**
	 * 启用量
	 */
	private Integer qyl;
	
	
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
	 * 启用量<br/>
	 * @return BigDecimal qyl
	 */
	public Integer getQyl()
	{
		return qyl;
	}

	/**
	 * 启用量<br/>
	 * @param BigDecimal qyl
	 */
	public void setQyl(Integer qyl)
	{
		this.qyl = qyl;
	}

	public String getXzmc()
	{
		return xzmc;
	}

	public void setXzmc(String xzmc)
	{
		this.xzmc = xzmc;
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
