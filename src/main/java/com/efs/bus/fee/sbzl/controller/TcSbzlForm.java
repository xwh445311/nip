package com.efs.bus.fee.sbzl.controller;

/**
 * 
 * com.efs.bus.fee.sbzl.controller.TcSbzlForm
 * @author xwh
 * 2020-10-18 16:16:33
 * 用户水表资料
 *
 */
public class TcSbzlForm
{
	/**
	 * 用户编号
	 */
	private String yhbh;
	
	/**
	 * 水表型号
	 */
	private String sbxh;
	
	/**
	 * 水表编号
	 */
	private String sbbh;
	
	/**
	 * 水表口径
	 */
	private String sbkj;
	
	/**
	 * 水表铭牌（页面默认传00
	 */
	private String sbmp;
	
	/**
	 * 水表底度
	 */
	private String sbdd;
	
	/**
	 * 水表总度
	 */
	private String sbzd;
	
	/**
	 * 安装位置
	 */
	private String sbwz;
	
	/**
	 * 水表安装日期
	 */
	private String sbazrq;
	
	/**
	 * 
	 */
	private String jyjs;
	
	/**
	 * 用水性质
	 */
	private String ysxz;
	
	/**
	 * 供水人口
	 */
	private String gsrk;
	
	/**
	 * 
	 */
	private String gwjd;
	
	/**
	 * 特殊关系
	 */
	private String tsbz;
	
	/**
	 * 水表状态（默认值）
	 */
	private String sbzt;
	
	/**
	 * 混合性质标志
	 */
	private String bcbz;
	
	/**
	 * 增值税标志
	 */
	private String zzsbz;
	
	/**
	 * 抄表类型
	 */
	private String sfyf;
	
	/**
	 * 
	 */
	private String jtjs;
	
	/**
	 * 
	 */
	private String hbsl;
	
	/**
	 * 
	 */
	private String zhhbrq;
	
	/**
	 * 册本编码
	 */
	private String cbbh;
	
	/**
	 * 册本序号1
	 */
	private String cbxh1;
	
	/**
	 * 册本序号2
	 */
	private String cbxh2;
	
	/**
	 * 分公司编号
	 */
	private String ch;
	
	/**
	 * 区域编码
	 */
	private String qh;
	
	/**
	 * 默认值
	 */
	private String bysf;
	
	/**
	 * 新装日期
	 */
	private String xzrq;
	
	/**
	 * 操作员/录入员
	 */
	private String czy;
	
	/**
	 * 开户编号，默认值
	 */
	private String khbh;
	
	/**
	 * 
	 */
	private String zhzjrq;
	
	/**
	 * 客户名称
	 */
	private String xName;
	
	/**
	 * 
	 */
	private String ghsj;
	
	/**
	 * 
	 */
	private String pzr1;
	
	/**
	 * 
	 */
	private String pzr2;
	
	/**
	 * 
	 */
	private String pzyy;
	
	/**
	 * 
	 */
	private String ghczy;
	
	/**
	 * 抄表员
	 */
	private String cby;
	
	/**
	 * 
	 */
	private String oyhmc;
	
	/**
	 * 计量表类型（从sblx表中读取）
	 */
	private String sblx;
	
	/**
	 * 父级表编码
	 */
	private String partenttableid;
	
	/**
	 * 总分表组号
	 */
	private String tbbh;
	
	/**
	 * 用水户数（前端默认传1）
	 */
	private String yshs;
	
	/**
	 * 启用量
	 */
	private String qyl;
	
	/**
	 * 旧表编号
	 */
	private String sbzlOldbh;
	
	
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
	 * 水表型号<br/>
	 * @return String sbxh
	 */
	public String getSbxh()
	{
		return sbxh;
	}

	/**
	 * 水表型号<br/>
	 * @param String sbxh
	 */
	public void setSbxh(String sbxh)
	{
		this.sbxh = sbxh;
	}
	
	/**
	 * 水表编号<br/>
	 * @return String sbbh
	 */
	public String getSbbh()
	{
		return sbbh;
	}

	/**
	 * 水表编号<br/>
	 * @param String sbbh
	 */
	public void setSbbh(String sbbh)
	{
		this.sbbh = sbbh;
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
	 * 水表铭牌（页面默认传00<br/>
	 * @return String sbmp
	 */
	public String getSbmp()
	{
		return sbmp;
	}

	/**
	 * 水表铭牌（页面默认传00<br/>
	 * @param String sbmp
	 */
	public void setSbmp(String sbmp)
	{
		this.sbmp = sbmp;
	}
	
	/**
	 * 水表底度<br/>
	 * @return String sbdd
	 */
	public String getSbdd()
	{
		return sbdd;
	}

	/**
	 * 水表底度<br/>
	 * @param BigDecimal sbdd
	 */
	public void setSbdd(String sbdd)
	{
		this.sbdd = sbdd;
	}
	
	/**
	 * 水表总度<br/>
	 * @return String sbzd
	 */
	public String getSbzd()
	{
		return sbzd;
	}

	/**
	 * 水表总度<br/>
	 * @param BigDecimal sbzd
	 */
	public void setSbzd(String sbzd)
	{
		this.sbzd = sbzd;
	}
	
	/**
	 * 安装位置<br/>
	 * @return String sbwz
	 */
	public String getSbwz()
	{
		return sbwz;
	}

	/**
	 * 安装位置<br/>
	 * @param String sbwz
	 */
	public void setSbwz(String sbwz)
	{
		this.sbwz = sbwz;
	}
	
	/**
	 * 水表安装日期<br/>
	 * @return String sbazrq
	 */
	public String getSbazrq()
	{
		return sbazrq;
	}

	/**
	 * 水表安装日期<br/>
	 * @param Date sbazrq
	 */
	public void setSbazrq(String sbazrq)
	{
		this.sbazrq = sbazrq;
	}
	
	/**
	 * <br/>
	 * @return String jyjs
	 */
	public String getJyjs()
	{
		return jyjs;
	}

	/**
	 * <br/>
	 * @param String jyjs
	 */
	public void setJyjs(String jyjs)
	{
		this.jyjs = jyjs;
	}
	
	/**
	 * 用水性质<br/>
	 * @return String ysxz
	 */
	public String getYsxz()
	{
		return ysxz;
	}

	/**
	 * 用水性质<br/>
	 * @param String ysxz
	 */
	public void setYsxz(String ysxz)
	{
		this.ysxz = ysxz;
	}
	
	/**
	 * 供水人口<br/>
	 * @return String gsrk
	 */
	public String getGsrk()
	{
		return gsrk;
	}

	/**
	 * 供水人口<br/>
	 * @param BigDecimal gsrk
	 */
	public void setGsrk(String gsrk)
	{
		this.gsrk = gsrk;
	}
	
	/**
	 * <br/>
	 * @return String gwjd
	 */
	public String getGwjd()
	{
		return gwjd;
	}

	/**
	 * <br/>
	 * @param String gwjd
	 */
	public void setGwjd(String gwjd)
	{
		this.gwjd = gwjd;
	}
	
	/**
	 * 特殊关系<br/>
	 * @return String tsbz
	 */
	public String getTsbz()
	{
		return tsbz;
	}

	/**
	 * 特殊关系<br/>
	 * @param String tsbz
	 */
	public void setTsbz(String tsbz)
	{
		this.tsbz = tsbz;
	}
	
	/**
	 * 水表状态（默认值）<br/>
	 * @return String sbzt
	 */
	public String getSbzt()
	{
		return sbzt;
	}

	/**
	 * 水表状态（默认值）<br/>
	 * @param String sbzt
	 */
	public void setSbzt(String sbzt)
	{
		this.sbzt = sbzt;
	}
	
	/**
	 * 混合性质标志<br/>
	 * @return String bcbz
	 */
	public String getBcbz()
	{
		return bcbz;
	}

	/**
	 * 混合性质标志<br/>
	 * @param String bcbz
	 */
	public void setBcbz(String bcbz)
	{
		this.bcbz = bcbz;
	}
	
	/**
	 * 增值税标志<br/>
	 * @return String zzsbz
	 */
	public String getZzsbz()
	{
		return zzsbz;
	}

	/**
	 * 增值税标志<br/>
	 * @param String zzsbz
	 */
	public void setZzsbz(String zzsbz)
	{
		this.zzsbz = zzsbz;
	}
	
	/**
	 * 抄表类型<br/>
	 * @return String sfyf
	 */
	public String getSfyf()
	{
		return sfyf;
	}

	/**
	 * 抄表类型<br/>
	 * @param String sfyf
	 */
	public void setSfyf(String sfyf)
	{
		this.sfyf = sfyf;
	}
	
	/**
	 * <br/>
	 * @return String jtjs
	 */
	public String getJtjs()
	{
		return jtjs;
	}

	/**
	 * <br/>
	 * @param BigDecimal jtjs
	 */
	public void setJtjs(String jtjs)
	{
		this.jtjs = jtjs;
	}
	
	/**
	 * <br/>
	 * @return String hbsl
	 */
	public String getHbsl()
	{
		return hbsl;
	}

	/**
	 * <br/>
	 * @param BigDecimal hbsl
	 */
	public void setHbsl(String hbsl)
	{
		this.hbsl = hbsl;
	}
	
	/**
	 * <br/>
	 * @return String zhhbrq
	 */
	public String getZhhbrq()
	{
		return zhhbrq;
	}

	/**
	 * <br/>
	 * @param Date zhhbrq
	 */
	public void setZhhbrq(String zhhbrq)
	{
		this.zhhbrq = zhhbrq;
	}
	
	/**
	 * 册本编码<br/>
	 * @return String cbbh
	 */
	public String getCbbh()
	{
		return cbbh;
	}

	/**
	 * 册本编码<br/>
	 * @param BigDecimal cbbh
	 */
	public void setCbbh(String cbbh)
	{
		this.cbbh = cbbh;
	}
	
	/**
	 * 册本序号1<br/>
	 * @return String cbxh1
	 */
	public String getCbxh1()
	{
		return cbxh1;
	}

	/**
	 * 册本序号1<br/>
	 * @param BigDecimal cbxh1
	 */
	public void setCbxh1(String cbxh1)
	{
		this.cbxh1 = cbxh1;
	}
	
	/**
	 * 册本序号2<br/>
	 * @return String cbxh2
	 */
	public String getCbxh2()
	{
		return cbxh2;
	}

	/**
	 * 册本序号2<br/>
	 * @param BigDecimal cbxh2
	 */
	public void setCbxh2(String cbxh2)
	{
		this.cbxh2 = cbxh2;
	}
	
	/**
	 * 分公司编号<br/>
	 * @return String ch
	 */
	public String getCh()
	{
		return ch;
	}

	/**
	 * 分公司编号<br/>
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
	 * 默认值<br/>
	 * @return String bysf
	 */
	public String getBysf()
	{
		return bysf;
	}

	/**
	 * 默认值<br/>
	 * @param String bysf
	 */
	public void setBysf(String bysf)
	{
		this.bysf = bysf;
	}
	
	/**
	 * 新装日期<br/>
	 * @return String xzrq
	 */
	public String getXzrq()
	{
		return xzrq;
	}

	/**
	 * 新装日期<br/>
	 * @param Date xzrq
	 */
	public void setXzrq(String xzrq)
	{
		this.xzrq = xzrq;
	}
	
	/**
	 * 操作员/录入员<br/>
	 * @return String czy
	 */
	public String getCzy()
	{
		return czy;
	}

	/**
	 * 操作员/录入员<br/>
	 * @param String czy
	 */
	public void setCzy(String czy)
	{
		this.czy = czy;
	}
	
	/**
	 * 开户编号，默认值<br/>
	 * @return String khbh
	 */
	public String getKhbh()
	{
		return khbh;
	}

	/**
	 * 开户编号，默认值<br/>
	 * @param String khbh
	 */
	public void setKhbh(String khbh)
	{
		this.khbh = khbh;
	}
	
	/**
	 * <br/>
	 * @return String zhzjrq
	 */
	public String getZhzjrq()
	{
		return zhzjrq;
	}

	/**
	 * <br/>
	 * @param Date zhzjrq
	 */
	public void setZhzjrq(String zhzjrq)
	{
		this.zhzjrq = zhzjrq;
	}
	
	/**
	 * 客户名称<br/>
	 * @return String xName
	 */
	public String getXName()
	{
		return xName;
	}

	/**
	 * 客户名称<br/>
	 * @param String xName
	 */
	public void setXName(String xName)
	{
		this.xName = xName;
	}
	
	/**
	 * <br/>
	 * @return String ghsj
	 */
	public String getGhsj()
	{
		return ghsj;
	}

	/**
	 * <br/>
	 * @param Date ghsj
	 */
	public void setGhsj(String ghsj)
	{
		this.ghsj = ghsj;
	}
	
	/**
	 * <br/>
	 * @return String pzr1
	 */
	public String getPzr1()
	{
		return pzr1;
	}

	/**
	 * <br/>
	 * @param String pzr1
	 */
	public void setPzr1(String pzr1)
	{
		this.pzr1 = pzr1;
	}
	
	/**
	 * <br/>
	 * @return String pzr2
	 */
	public String getPzr2()
	{
		return pzr2;
	}

	/**
	 * <br/>
	 * @param String pzr2
	 */
	public void setPzr2(String pzr2)
	{
		this.pzr2 = pzr2;
	}
	
	/**
	 * <br/>
	 * @return String pzyy
	 */
	public String getPzyy()
	{
		return pzyy;
	}

	/**
	 * <br/>
	 * @param String pzyy
	 */
	public void setPzyy(String pzyy)
	{
		this.pzyy = pzyy;
	}
	
	/**
	 * <br/>
	 * @return String ghczy
	 */
	public String getGhczy()
	{
		return ghczy;
	}

	/**
	 * <br/>
	 * @param String ghczy
	 */
	public void setGhczy(String ghczy)
	{
		this.ghczy = ghczy;
	}
	
	/**
	 * 抄表员<br/>
	 * @return String cby
	 */
	public String getCby()
	{
		return cby;
	}

	/**
	 * 抄表员<br/>
	 * @param String cby
	 */
	public void setCby(String cby)
	{
		this.cby = cby;
	}
	
	/**
	 * <br/>
	 * @return String oyhmc
	 */
	public String getOyhmc()
	{
		return oyhmc;
	}

	/**
	 * <br/>
	 * @param String oyhmc
	 */
	public void setOyhmc(String oyhmc)
	{
		this.oyhmc = oyhmc;
	}
	
	/**
	 * 计量表类型（从sblx表中读取）<br/>
	 * @return String sblx
	 */
	public String getSblx()
	{
		return sblx;
	}

	/**
	 * 计量表类型（从sblx表中读取）<br/>
	 * @param BigDecimal sblx
	 */
	public void setSblx(String sblx)
	{
		this.sblx = sblx;
	}
	
	/**
	 * 父级表编码<br/>
	 * @return String partenttableid
	 */
	public String getPartenttableid()
	{
		return partenttableid;
	}

	/**
	 * 父级表编码<br/>
	 * @param String partenttableid
	 */
	public void setPartenttableid(String partenttableid)
	{
		this.partenttableid = partenttableid;
	}
	
	/**
	 * 总分表组号<br/>
	 * @return String tbbh
	 */
	public String getTbbh()
	{
		return tbbh;
	}

	/**
	 * 总分表组号<br/>
	 * @param String tbbh
	 */
	public void setTbbh(String tbbh)
	{
		this.tbbh = tbbh;
	}
	
	/**
	 * 用水户数（前端默认传1）<br/>
	 * @return String yshs
	 */
	public String getYshs()
	{
		return yshs;
	}

	/**
	 * 用水户数（前端默认传1）<br/>
	 * @param BigDecimal yshs
	 */
	public void setYshs(String yshs)
	{
		this.yshs = yshs;
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
	 * @param String qyl
	 */
	public void setQyl(String qyl)
	{
		this.qyl = qyl;
	}
	
	/**
	 * 旧表编号<br/>
	 * @return String sbzlOldbh
	 */
	public String getSbzlOldbh()
	{
		return sbzlOldbh;
	}

	/**
	 * 旧表编号<br/>
	 * @param String sbzlOldbh
	 */
	public void setSbzlOldbh(String sbzlOldbh)
	{
		this.sbzlOldbh = sbzlOldbh;
	}
	
	
	@Override
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		
		sb.append("yhbh=" + yhbh).append("\n");
		sb.append("sbxh=" + sbxh).append("\n");
		sb.append("sbbh=" + sbbh).append("\n");
		sb.append("sbkj=" + sbkj).append("\n");
		sb.append("sbmp=" + sbmp).append("\n");
		sb.append("sbdd=" + sbdd).append("\n");
		sb.append("sbzd=" + sbzd).append("\n");
		sb.append("sbwz=" + sbwz).append("\n");
		sb.append("sbazrq=" + sbazrq).append("\n");
		sb.append("jyjs=" + jyjs).append("\n");
		sb.append("ysxz=" + ysxz).append("\n");
		sb.append("gsrk=" + gsrk).append("\n");
		sb.append("gwjd=" + gwjd).append("\n");
		sb.append("tsbz=" + tsbz).append("\n");
		sb.append("sbzt=" + sbzt).append("\n");
		sb.append("bcbz=" + bcbz).append("\n");
		sb.append("zzsbz=" + zzsbz).append("\n");
		sb.append("sfyf=" + sfyf).append("\n");
		sb.append("jtjs=" + jtjs).append("\n");
		sb.append("hbsl=" + hbsl).append("\n");
		sb.append("zhhbrq=" + zhhbrq).append("\n");
		sb.append("cbbh=" + cbbh).append("\n");
		sb.append("cbxh1=" + cbxh1).append("\n");
		sb.append("cbxh2=" + cbxh2).append("\n");
		sb.append("ch=" + ch).append("\n");
		sb.append("qh=" + qh).append("\n");
		sb.append("bysf=" + bysf).append("\n");
		sb.append("xzrq=" + xzrq).append("\n");
		sb.append("czy=" + czy).append("\n");
		sb.append("khbh=" + khbh).append("\n");
		sb.append("zhzjrq=" + zhzjrq).append("\n");
		sb.append("xName=" + xName).append("\n");
		sb.append("ghsj=" + ghsj).append("\n");
		sb.append("pzr1=" + pzr1).append("\n");
		sb.append("pzr2=" + pzr2).append("\n");
		sb.append("pzyy=" + pzyy).append("\n");
		sb.append("ghczy=" + ghczy).append("\n");
		sb.append("cby=" + cby).append("\n");
		sb.append("oyhmc=" + oyhmc).append("\n");
		sb.append("sblx=" + sblx).append("\n");
		sb.append("partenttableid=" + partenttableid).append("\n");
		sb.append("tbbh=" + tbbh).append("\n");
		sb.append("yshs=" + yshs).append("\n");
		sb.append("qyl=" + qyl).append("\n");
		sb.append("sbzlOldbh=" + sbzlOldbh).append("\n");
		return sb.toString();
	}
}
