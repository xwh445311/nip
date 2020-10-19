package com.efs.bus.fee.yhzl.mapper;

/**
 * 
 * com.efs.bus.fee.yhzl.mapper.TcYhzl
 * @author xwh
 * 2020-10-18 16:11:27
 * 用户信息表
 *
 */
public class TcYhzl
{
	/**
	 * 用户编号
	 */
	private String yhbh;
	
	/**
	 * 用户名称
	 */
	private String yhmc;
	
	/**
	 * 身份证号
	 */
	private String sfzh;
	
	/**
	 * 分公司ID
	 */
	private String ch;
	
	/**
	 * 区域编码
	 */
	private String qh;
	
	/**
	 * 用户住址
	 */
	private String yhzz;
	
	/**
	 * 联系人
	 */
	private String lxr;
	
	/**
	 * 固定电话
	 */
	private String dh;
	
	/**
	 * 移动电话
	 */
	private String yddh;
	
	/**
	 * 
	 */
	private String call;
	
	/**
	 * 抄表类型
	 */
	private String cblx;
	
	/**
	 * 
	 */
	private Date xzrq;
	
	/**
	 * 销户日期
	 */
	private Date xhrq;
	
	/**
	 * 
	 */
	private String fzbz;
	
	/**
	 * 用户状态
	 */
	private String yhzt;
	
	/**
	 * 操作员
	 */
	private String czy;
	
	/**
	 * 余额
	 */
	private BigDecimal ye;
	
	/**
	 * 
	 */
	private String zsfs;
	
	/**
	 * 
	 */
	private String dkbz;
	
	/**
	 * 应缴费日1
	 */
	private BigDecimal yjfr1;
	
	/**
	 * 应缴费日2
	 */
	private BigDecimal yjfr2;
	
	/**
	 * 
	 */
	private String qybj;
	
	/**
	 * 
	 */
	private String jyfw;
	
	/**
	 * 
	 */
	private String yjfbz;
	
	/**
	 * 
	 */
	private BigDecimal billline;
	
	/**
	 * 
	 */
	private BigDecimal billpage;
	
	/**
	 * 旧编号
	 */
	private String oldbh;
	
	/**
	 * 银行账号
	 */
	private BigDecimal yhzh;
	
	/**
	 * 
	 */
	private BigDecimal sfyc;
	
	
	/**
	 * 用户编号<br/>
	 * @return String yhbh
	 */
	public String getYhbh()
	{
		return yhbh;
	}

	/**
	 * 用户编号<br/>
	 * @param String yhbh
	 */
	public void setYhbh(String yhbh)
	{
		this.yhbh = yhbh;
	}
	
	/**
	 * 用户名称<br/>
	 * @return String yhmc
	 */
	public String getYhmc()
	{
		return yhmc;
	}

	/**
	 * 用户名称<br/>
	 * @param String yhmc
	 */
	public void setYhmc(String yhmc)
	{
		this.yhmc = yhmc;
	}
	
	/**
	 * 身份证号<br/>
	 * @return String sfzh
	 */
	public String getSfzh()
	{
		return sfzh;
	}

	/**
	 * 身份证号<br/>
	 * @param String sfzh
	 */
	public void setSfzh(String sfzh)
	{
		this.sfzh = sfzh;
	}
	
	/**
	 * 分公司ID<br/>
	 * @return String ch
	 */
	public String getCh()
	{
		return ch;
	}

	/**
	 * 分公司ID<br/>
	 * @param String ch
	 */
	public void setCh(String ch)
	{
		this.ch = ch;
	}
	
	/**
	 * 区域编码<br/>
	 * @return String qh
	 */
	public String getQh()
	{
		return qh;
	}

	/**
	 * 区域编码<br/>
	 * @param String qh
	 */
	public void setQh(String qh)
	{
		this.qh = qh;
	}
	
	/**
	 * 用户住址<br/>
	 * @return String yhzz
	 */
	public String getYhzz()
	{
		return yhzz;
	}

	/**
	 * 用户住址<br/>
	 * @param String yhzz
	 */
	public void setYhzz(String yhzz)
	{
		this.yhzz = yhzz;
	}
	
	/**
	 * 联系人<br/>
	 * @return String lxr
	 */
	public String getLxr()
	{
		return lxr;
	}

	/**
	 * 联系人<br/>
	 * @param String lxr
	 */
	public void setLxr(String lxr)
	{
		this.lxr = lxr;
	}
	
	/**
	 * 固定电话<br/>
	 * @return String dh
	 */
	public String getDh()
	{
		return dh;
	}

	/**
	 * 固定电话<br/>
	 * @param String dh
	 */
	public void setDh(String dh)
	{
		this.dh = dh;
	}
	
	/**
	 * 移动电话<br/>
	 * @return String yddh
	 */
	public String getYddh()
	{
		return yddh;
	}

	/**
	 * 移动电话<br/>
	 * @param String yddh
	 */
	public void setYddh(String yddh)
	{
		this.yddh = yddh;
	}
	
	/**
	 * <br/>
	 * @return String call
	 */
	public String getCall()
	{
		return call;
	}

	/**
	 * <br/>
	 * @param String call
	 */
	public void setCall(String call)
	{
		this.call = call;
	}
	
	/**
	 * 抄表类型<br/>
	 * @return String cblx
	 */
	public String getCblx()
	{
		return cblx;
	}

	/**
	 * 抄表类型<br/>
	 * @param String cblx
	 */
	public void setCblx(String cblx)
	{
		this.cblx = cblx;
	}
	
	/**
	 * <br/>
	 * @return Date xzrq
	 */
	public Date getXzrq()
	{
		return xzrq;
	}

	/**
	 * <br/>
	 * @param Date xzrq
	 */
	public void setXzrq(Date xzrq)
	{
		this.xzrq = xzrq;
	}
	
	/**
	 * 销户日期<br/>
	 * @return Date xhrq
	 */
	public Date getXhrq()
	{
		return xhrq;
	}

	/**
	 * 销户日期<br/>
	 * @param Date xhrq
	 */
	public void setXhrq(Date xhrq)
	{
		this.xhrq = xhrq;
	}
	
	/**
	 * <br/>
	 * @return String fzbz
	 */
	public String getFzbz()
	{
		return fzbz;
	}

	/**
	 * <br/>
	 * @param String fzbz
	 */
	public void setFzbz(String fzbz)
	{
		this.fzbz = fzbz;
	}
	
	/**
	 * 用户状态<br/>
	 * @return String yhzt
	 */
	public String getYhzt()
	{
		return yhzt;
	}

	/**
	 * 用户状态<br/>
	 * @param String yhzt
	 */
	public void setYhzt(String yhzt)
	{
		this.yhzt = yhzt;
	}
	
	/**
	 * 操作员<br/>
	 * @return String czy
	 */
	public String getCzy()
	{
		return czy;
	}

	/**
	 * 操作员<br/>
	 * @param String czy
	 */
	public void setCzy(String czy)
	{
		this.czy = czy;
	}
	
	/**
	 * 余额<br/>
	 * @return BigDecimal ye
	 */
	public BigDecimal getYe()
	{
		return ye;
	}

	/**
	 * 余额<br/>
	 * @param BigDecimal ye
	 */
	public void setYe(BigDecimal ye)
	{
		this.ye = ye;
	}
	
	/**
	 * <br/>
	 * @return String zsfs
	 */
	public String getZsfs()
	{
		return zsfs;
	}

	/**
	 * <br/>
	 * @param String zsfs
	 */
	public void setZsfs(String zsfs)
	{
		this.zsfs = zsfs;
	}
	
	/**
	 * <br/>
	 * @return String dkbz
	 */
	public String getDkbz()
	{
		return dkbz;
	}

	/**
	 * <br/>
	 * @param String dkbz
	 */
	public void setDkbz(String dkbz)
	{
		this.dkbz = dkbz;
	}
	
	/**
	 * 应缴费日1<br/>
	 * @return BigDecimal yjfr1
	 */
	public BigDecimal getYjfr1()
	{
		return yjfr1;
	}

	/**
	 * 应缴费日1<br/>
	 * @param BigDecimal yjfr1
	 */
	public void setYjfr1(BigDecimal yjfr1)
	{
		this.yjfr1 = yjfr1;
	}
	
	/**
	 * 应缴费日2<br/>
	 * @return BigDecimal yjfr2
	 */
	public BigDecimal getYjfr2()
	{
		return yjfr2;
	}

	/**
	 * 应缴费日2<br/>
	 * @param BigDecimal yjfr2
	 */
	public void setYjfr2(BigDecimal yjfr2)
	{
		this.yjfr2 = yjfr2;
	}
	
	/**
	 * <br/>
	 * @return String qybj
	 */
	public String getQybj()
	{
		return qybj;
	}

	/**
	 * <br/>
	 * @param String qybj
	 */
	public void setQybj(String qybj)
	{
		this.qybj = qybj;
	}
	
	/**
	 * <br/>
	 * @return String jyfw
	 */
	public String getJyfw()
	{
		return jyfw;
	}

	/**
	 * <br/>
	 * @param String jyfw
	 */
	public void setJyfw(String jyfw)
	{
		this.jyfw = jyfw;
	}
	
	/**
	 * <br/>
	 * @return String yjfbz
	 */
	public String getYjfbz()
	{
		return yjfbz;
	}

	/**
	 * <br/>
	 * @param String yjfbz
	 */
	public void setYjfbz(String yjfbz)
	{
		this.yjfbz = yjfbz;
	}
	
	/**
	 * <br/>
	 * @return BigDecimal billline
	 */
	public BigDecimal getBillline()
	{
		return billline;
	}

	/**
	 * <br/>
	 * @param BigDecimal billline
	 */
	public void setBillline(BigDecimal billline)
	{
		this.billline = billline;
	}
	
	/**
	 * <br/>
	 * @return BigDecimal billpage
	 */
	public BigDecimal getBillpage()
	{
		return billpage;
	}

	/**
	 * <br/>
	 * @param BigDecimal billpage
	 */
	public void setBillpage(BigDecimal billpage)
	{
		this.billpage = billpage;
	}
	
	/**
	 * 旧编号<br/>
	 * @return String oldbh
	 */
	public String getOldbh()
	{
		return oldbh;
	}

	/**
	 * 旧编号<br/>
	 * @param String oldbh
	 */
	public void setOldbh(String oldbh)
	{
		this.oldbh = oldbh;
	}
	
	/**
	 * 银行账号<br/>
	 * @return BigDecimal yhzh
	 */
	public BigDecimal getYhzh()
	{
		return yhzh;
	}

	/**
	 * 银行账号<br/>
	 * @param BigDecimal yhzh
	 */
	public void setYhzh(BigDecimal yhzh)
	{
		this.yhzh = yhzh;
	}
	
	/**
	 * <br/>
	 * @return BigDecimal sfyc
	 */
	public BigDecimal getSfyc()
	{
		return sfyc;
	}

	/**
	 * <br/>
	 * @param BigDecimal sfyc
	 */
	public void setSfyc(BigDecimal sfyc)
	{
		this.sfyc = sfyc;
	}
	
	
	@Override
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		
		sb.append("yhbh=" + yhbh).append("\n");
		sb.append("yhmc=" + yhmc).append("\n");
		sb.append("sfzh=" + sfzh).append("\n");
		sb.append("ch=" + ch).append("\n");
		sb.append("qh=" + qh).append("\n");
		sb.append("yhzz=" + yhzz).append("\n");
		sb.append("lxr=" + lxr).append("\n");
		sb.append("dh=" + dh).append("\n");
		sb.append("yddh=" + yddh).append("\n");
		sb.append("call=" + call).append("\n");
		sb.append("cblx=" + cblx).append("\n");
		sb.append("xzrq=" + xzrq).append("\n");
		sb.append("xhrq=" + xhrq).append("\n");
		sb.append("fzbz=" + fzbz).append("\n");
		sb.append("yhzt=" + yhzt).append("\n");
		sb.append("czy=" + czy).append("\n");
		sb.append("ye=" + ye).append("\n");
		sb.append("zsfs=" + zsfs).append("\n");
		sb.append("dkbz=" + dkbz).append("\n");
		sb.append("yjfr1=" + yjfr1).append("\n");
		sb.append("yjfr2=" + yjfr2).append("\n");
		sb.append("qybj=" + qybj).append("\n");
		sb.append("jyfw=" + jyfw).append("\n");
		sb.append("yjfbz=" + yjfbz).append("\n");
		sb.append("billline=" + billline).append("\n");
		sb.append("billpage=" + billpage).append("\n");
		sb.append("oldbh=" + oldbh).append("\n");
		sb.append("yhzh=" + yhzh).append("\n");
		sb.append("sfyc=" + sfyc).append("\n");
		return sb.toString();
	}
}
