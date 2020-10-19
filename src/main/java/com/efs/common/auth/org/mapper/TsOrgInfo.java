package com.efs.common.auth.org.mapper;

import java.math.BigDecimal;

/**
 * 
 * com.efs.common.auth.org.mapper.TsOrgInfo
 * @author xuwh
 * 2020-05-05 21:47:11
 * 
 *
 */
public class TsOrgInfo
{
	/**
	 * 
	 */
	private String oiCode;
	
	/**
	 * 
	 */
	private String oiName;
	
	/**
	 * 收费地址
	 */
	private String oiSfdz;
	
	/**
	 * 开户银行
	 */
	private String oiKhyh;
	
	/**
	 * 银行账号
	 */
	private String oiYhzh;
	
	/**
	 * 增值税号
	 */
	private String oiZzsh;
	
	/**
	 * 联系电话
	 */
	private String oiLxdh;
	
	/**
	 * 联系人
	 */
	private String oiLxr;
	
	/**
	 * 单位负责人
	 */
	private String oiDwfzr;
	
	/**
	 * 业务负责人
	 */
	private String oiYwfzr;
	
	/**
	 * 有效性：1有效，0无效
	 */
	private String oiStatus;
	
	/**
	 * 上级机构
	 */
	private String oiPartCode;
	
	/**
	 * 机构类别：01管辖公司，02部门
	 */
	private String oiType;
	
	/**
	 * 排序
	 */
	private Integer oiOrder;
	
	/**
	 * 
	 */
	private String addDate;
	
	/**
	 * 
	 */
	private String addTime;
	
	/**
	 * 
	 */
	private String addUser;
	
	/**
	 * 
	 */
	private String updDate;
	
	/**
	 * 
	 */
	private String updTime;
	
	/**
	 * 
	 */
	private String updUser;
	
	
	/**
	 * <br/>
	 * @return String oiCode
	 */
	public String getOiCode()
	{
		return oiCode;
	}

	/**
	 * <br/>
	 * @param String oiCode
	 */
	public void setOiCode(String oiCode)
	{
		this.oiCode = oiCode;
	}
	
	/**
	 * <br/>
	 * @return String oiName
	 */
	public String getOiName()
	{
		return oiName;
	}

	/**
	 * <br/>
	 * @param String oiName
	 */
	public void setOiName(String oiName)
	{
		this.oiName = oiName;
	}
	
	/**
	 * 收费地址<br/>
	 * @return String oiSfdz
	 */
	public String getOiSfdz()
	{
		return oiSfdz;
	}

	/**
	 * 收费地址<br/>
	 * @param String oiSfdz
	 */
	public void setOiSfdz(String oiSfdz)
	{
		this.oiSfdz = oiSfdz;
	}
	
	/**
	 * 开户银行<br/>
	 * @return String oiKhyh
	 */
	public String getOiKhyh()
	{
		return oiKhyh;
	}

	/**
	 * 开户银行<br/>
	 * @param String oiKhyh
	 */
	public void setOiKhyh(String oiKhyh)
	{
		this.oiKhyh = oiKhyh;
	}
	
	/**
	 * 银行账号<br/>
	 * @return String oiYhzh
	 */
	public String getOiYhzh()
	{
		return oiYhzh;
	}

	/**
	 * 银行账号<br/>
	 * @param String oiYhzh
	 */
	public void setOiYhzh(String oiYhzh)
	{
		this.oiYhzh = oiYhzh;
	}
	
	/**
	 * 增值税号<br/>
	 * @return String oiZzsh
	 */
	public String getOiZzsh()
	{
		return oiZzsh;
	}

	/**
	 * 增值税号<br/>
	 * @param String oiZzsh
	 */
	public void setOiZzsh(String oiZzsh)
	{
		this.oiZzsh = oiZzsh;
	}
	
	/**
	 * 联系电话<br/>
	 * @return String oiLxdh
	 */
	public String getOiLxdh()
	{
		return oiLxdh;
	}

	/**
	 * 联系电话<br/>
	 * @param String oiLxdh
	 */
	public void setOiLxdh(String oiLxdh)
	{
		this.oiLxdh = oiLxdh;
	}
	
	/**
	 * 联系人<br/>
	 * @return String oiLxr
	 */
	public String getOiLxr()
	{
		return oiLxr;
	}

	/**
	 * 联系人<br/>
	 * @param String oiLxr
	 */
	public void setOiLxr(String oiLxr)
	{
		this.oiLxr = oiLxr;
	}
	
	/**
	 * 单位负责人<br/>
	 * @return String oiDwfzr
	 */
	public String getOiDwfzr()
	{
		return oiDwfzr;
	}

	/**
	 * 单位负责人<br/>
	 * @param String oiDwfzr
	 */
	public void setOiDwfzr(String oiDwfzr)
	{
		this.oiDwfzr = oiDwfzr;
	}
	
	/**
	 * 业务负责人<br/>
	 * @return String oiYwfzr
	 */
	public String getOiYwfzr()
	{
		return oiYwfzr;
	}

	/**
	 * 业务负责人<br/>
	 * @param String oiYwfzr
	 */
	public void setOiYwfzr(String oiYwfzr)
	{
		this.oiYwfzr = oiYwfzr;
	}
	
	/**
	 * 有效性：1有效，0无效<br/>
	 * @return String oiStatus
	 */
	public String getOiStatus()
	{
		return oiStatus;
	}

	/**
	 * 有效性：1有效，0无效<br/>
	 * @param String oiStatus
	 */
	public void setOiStatus(String oiStatus)
	{
		this.oiStatus = oiStatus;
	}
	
	/**
	 * 上级机构<br/>
	 * @return String oiPartCode
	 */
	public String getOiPartCode()
	{
		return oiPartCode;
	}

	/**
	 * 上级机构<br/>
	 * @param String oiPartCode
	 */
	public void setOiPartCode(String oiPartCode)
	{
		this.oiPartCode = oiPartCode;
	}
	
	/**
	 * 机构类别：01管辖公司，02部门<br/>
	 * @return String oiType
	 */
	public String getOiType()
	{
		return oiType;
	}

	/**
	 * 机构类别：01管辖公司，02部门<br/>
	 * @param String oiType
	 */
	public void setOiType(String oiType)
	{
		this.oiType = oiType;
	}
	
	/**
	 * 排序<br/>
	 * @return BigDecimal oiOrder
	 */
	public Integer getOiOrder()
	{
		return oiOrder;
	}

	/**
	 * 排序<br/>
	 * @param BigDecimal oiOrder
	 */
	public void setOiOrder(Integer oiOrder)
	{
		this.oiOrder = oiOrder;
	}
	
	/**
	 * <br/>
	 * @return String addDate
	 */
	public String getAddDate()
	{
		return addDate;
	}

	/**
	 * <br/>
	 * @param String addDate
	 */
	public void setAddDate(String addDate)
	{
		this.addDate = addDate;
	}
	
	/**
	 * <br/>
	 * @return String addTime
	 */
	public String getAddTime()
	{
		return addTime;
	}

	/**
	 * <br/>
	 * @param String addTime
	 */
	public void setAddTime(String addTime)
	{
		this.addTime = addTime;
	}
	
	/**
	 * <br/>
	 * @return String addUser
	 */
	public String getAddUser()
	{
		return addUser;
	}

	/**
	 * <br/>
	 * @param String addUser
	 */
	public void setAddUser(String addUser)
	{
		this.addUser = addUser;
	}
	
	/**
	 * <br/>
	 * @return String updDate
	 */
	public String getUpdDate()
	{
		return updDate;
	}

	/**
	 * <br/>
	 * @param String updDate
	 */
	public void setUpdDate(String updDate)
	{
		this.updDate = updDate;
	}
	
	/**
	 * <br/>
	 * @return String updTime
	 */
	public String getUpdTime()
	{
		return updTime;
	}

	/**
	 * <br/>
	 * @param String updTime
	 */
	public void setUpdTime(String updTime)
	{
		this.updTime = updTime;
	}
	
	/**
	 * <br/>
	 * @return String updUser
	 */
	public String getUpdUser()
	{
		return updUser;
	}

	/**
	 * <br/>
	 * @param String updUser
	 */
	public void setUpdUser(String updUser)
	{
		this.updUser = updUser;
	}
	
	
	@Override
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		
		sb.append("oiCode=" + oiCode).append("\n");
		sb.append("oiName=" + oiName).append("\n");
		sb.append("oiSfdz=" + oiSfdz).append("\n");
		sb.append("oiKhyh=" + oiKhyh).append("\n");
		sb.append("oiYhzh=" + oiYhzh).append("\n");
		sb.append("oiZzsh=" + oiZzsh).append("\n");
		sb.append("oiLxdh=" + oiLxdh).append("\n");
		sb.append("oiLxr=" + oiLxr).append("\n");
		sb.append("oiDwfzr=" + oiDwfzr).append("\n");
		sb.append("oiYwfzr=" + oiYwfzr).append("\n");
		sb.append("oiStatus=" + oiStatus).append("\n");
		sb.append("oiPartCode=" + oiPartCode).append("\n");
		sb.append("oiType=" + oiType).append("\n");
		sb.append("oiOrder=" + oiOrder).append("\n");
		sb.append("addDate=" + addDate).append("\n");
		sb.append("addTime=" + addTime).append("\n");
		sb.append("addUser=" + addUser).append("\n");
		sb.append("updDate=" + updDate).append("\n");
		sb.append("updTime=" + updTime).append("\n");
		sb.append("updUser=" + updUser).append("\n");
		return sb.toString();
	}
}
