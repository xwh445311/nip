package com.efs.bus.base.fyxx.mapper;

import java.math.BigDecimal;

/**
 * 
 * com.efs.bus.base.fyxx.mapper.TbFyxx
 * @author xuwh
 * 2020-05-19 20:11:32
 * 费用参数信息表
 *
 */
public class TbFyxx
{
	/**
	 * 费用代码
	 */
	private String fydm;
	
	/**
	 * 费用名称
	 */
	private String fymc;
	
	/**
	 * 
	 */
	private String cbjsbz;
	
	/**
	 * 
	 */
	private String qtjsbz;
	
	/**
	 * 
	 */
	private String zkbz;
	
	/**
	 * 
	 */
	private String jmbz;
	
	/**
	 * 
	 */
	private String lrbz;
	
	/**
	 * 
	 */
	private BigDecimal zxzk;
	
	/**
	 * 
	 */
	private BigDecimal zdzk;
	
	/**
	 * 
	 */
	private BigDecimal sl;
	
	/**
	 * 
	 */
	private String dddybz;
	
	/**
	 * 
	 */
	private String zzsbz;
	
	/**
	 * 删除标志：0未删除，1已经删除
	 */
	private String delbz;
	
	/**
	 * 
	 */
	private String csrq;
	
	
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
	 * 费用名称<br/>
	 * @return String fymc
	 */
	public String getFymc()
	{
		return fymc;
	}

	/**
	 * 费用名称<br/>
	 * @param String fymc
	 */
	public void setFymc(String fymc)
	{
		this.fymc = fymc;
	}
	
	/**
	 * <br/>
	 * @return String cbjsbz
	 */
	public String getCbjsbz()
	{
		return cbjsbz;
	}

	/**
	 * <br/>
	 * @param String cbjsbz
	 */
	public void setCbjsbz(String cbjsbz)
	{
		this.cbjsbz = cbjsbz;
	}
	
	/**
	 * <br/>
	 * @return String qtjsbz
	 */
	public String getQtjsbz()
	{
		return qtjsbz;
	}

	/**
	 * <br/>
	 * @param String qtjsbz
	 */
	public void setQtjsbz(String qtjsbz)
	{
		this.qtjsbz = qtjsbz;
	}
	
	/**
	 * <br/>
	 * @return String zkbz
	 */
	public String getZkbz()
	{
		return zkbz;
	}

	/**
	 * <br/>
	 * @param String zkbz
	 */
	public void setZkbz(String zkbz)
	{
		this.zkbz = zkbz;
	}
	
	/**
	 * <br/>
	 * @return String jmbz
	 */
	public String getJmbz()
	{
		return jmbz;
	}

	/**
	 * <br/>
	 * @param String jmbz
	 */
	public void setJmbz(String jmbz)
	{
		this.jmbz = jmbz;
	}
	
	/**
	 * <br/>
	 * @return String lrbz
	 */
	public String getLrbz()
	{
		return lrbz;
	}

	/**
	 * <br/>
	 * @param String lrbz
	 */
	public void setLrbz(String lrbz)
	{
		this.lrbz = lrbz;
	}
	
	/**
	 * <br/>
	 * @return BigDecimal zxzk
	 */
	public BigDecimal getZxzk()
	{
		return zxzk;
	}

	/**
	 * <br/>
	 * @param BigDecimal zxzk
	 */
	public void setZxzk(BigDecimal zxzk)
	{
		this.zxzk = zxzk;
	}
	
	/**
	 * <br/>
	 * @return BigDecimal zdzk
	 */
	public BigDecimal getZdzk()
	{
		return zdzk;
	}

	/**
	 * <br/>
	 * @param BigDecimal zdzk
	 */
	public void setZdzk(BigDecimal zdzk)
	{
		this.zdzk = zdzk;
	}
	
	/**
	 * <br/>
	 * @return BigDecimal sl
	 */
	public BigDecimal getSl()
	{
		return sl;
	}

	/**
	 * <br/>
	 * @param BigDecimal sl
	 */
	public void setSl(BigDecimal sl)
	{
		this.sl = sl;
	}
	
	/**
	 * <br/>
	 * @return String dddybz
	 */
	public String getDddybz()
	{
		return dddybz;
	}

	/**
	 * <br/>
	 * @param String dddybz
	 */
	public void setDddybz(String dddybz)
	{
		this.dddybz = dddybz;
	}
	
	/**
	 * <br/>
	 * @return String zzsbz
	 */
	public String getZzsbz()
	{
		return zzsbz;
	}

	/**
	 * <br/>
	 * @param String zzsbz
	 */
	public void setZzsbz(String zzsbz)
	{
		this.zzsbz = zzsbz;
	}
	
	/**
	 * 删除标志：0未删除，1已经删除<br/>
	 * @return String delbz
	 */
	public String getDelbz()
	{
		return delbz;
	}

	/**
	 * 删除标志：0未删除，1已经删除<br/>
	 * @param String delbz
	 */
	public void setDelbz(String delbz)
	{
		this.delbz = delbz;
	}
	
	/**
	 * <br/>
	 * @return Date csrq
	 */
	public String getCsrq()
	{
		return csrq;
	}

	/**
	 * <br/>
	 * @param Date csrq
	 */
	public void setCsrq(String csrq)
	{
		this.csrq = csrq;
	}
	
	
	@Override
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		
		sb.append("fydm=" + fydm).append("\n");
		sb.append("fymc=" + fymc).append("\n");
		sb.append("cbjsbz=" + cbjsbz).append("\n");
		sb.append("qtjsbz=" + qtjsbz).append("\n");
		sb.append("zkbz=" + zkbz).append("\n");
		sb.append("jmbz=" + jmbz).append("\n");
		sb.append("lrbz=" + lrbz).append("\n");
		sb.append("zxzk=" + zxzk).append("\n");
		sb.append("zdzk=" + zdzk).append("\n");
		sb.append("sl=" + sl).append("\n");
		sb.append("dddybz=" + dddybz).append("\n");
		sb.append("zzsbz=" + zzsbz).append("\n");
		sb.append("delbz=" + delbz).append("\n");
		sb.append("csrq=" + csrq).append("\n");
		return sb.toString();
	}
}
