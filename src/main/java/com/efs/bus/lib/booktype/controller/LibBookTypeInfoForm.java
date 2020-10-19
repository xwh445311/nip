package com.efs.bus.lib.booktype.controller;

/**
 * 
 * com.efs.bus.lib.booktype.controller.LibBookTypeInfoForm
 * @author xuwh
 * 2018-03-25 23:08:05
 * 图书类别信息表
 *
 */
public class LibBookTypeInfoForm
{
	/**
	 * 类别ID
	 */
	private String btId;
	
	/**
	 * 类别CODE
	 */
	private String btCode;
	
	/**
	 * 类别名称
	 */
	private String btName;
	
	/**
	 * 父类别ID
	 */
	private String btParentId;
	
	/**
	 * 顺序号
	 */
	private String btOrder;
	
	/**
	 * 类别匹配关键字
	 */
	private String btKeyword;
	
	/**
	 * 创建日期
	 */
	private String addDate;
	
	/**
	 * 创建时间
	 */
	private String addTime;
	
	/**
	 * 创建人
	 */
	private String addUser;
	
	/**
	 * 最后修改日期
	 */
	private String updDate;
	
	/**
	 * 最后修改时间
	 */
	private String updTime;
	
	/**
	 * 最后修改人
	 */
	private String updUser;
	
	
	/**
	 * 类别ID<br/>
	 * @return String btId
	 */
	public String getBtId()
	{
		return btId;
	}

	/**
	 * 类别ID<br/>
	 * @param Integer btId
	 */
	public void setBtId(String btId)
	{
		this.btId = btId;
	}
	
	/**
	 * 类别CODE<br/>
	 * @return String btCode
	 */
	public String getBtCode()
	{
		return btCode;
	}

	/**
	 * 类别CODE<br/>
	 * @param String btCode
	 */
	public void setBtCode(String btCode)
	{
		this.btCode = btCode;
	}
	
	/**
	 * 类别名称<br/>
	 * @return String btName
	 */
	public String getBtName()
	{
		return btName;
	}

	/**
	 * 类别名称<br/>
	 * @param String btName
	 */
	public void setBtName(String btName)
	{
		this.btName = btName;
	}
	
	/**
	 * 父类别ID<br/>
	 * @return String btParentId
	 */
	public String getBtParentId()
	{
		return btParentId;
	}

	/**
	 * 父类别ID<br/>
	 * @param String btParentId
	 */
	public void setBtParentId(String btParentId)
	{
		this.btParentId = btParentId;
	}
	
	/**
	 * 顺序号<br/>
	 * @return String btOrder
	 */
	public String getBtOrder()
	{
		return btOrder;
	}

	/**
	 * 顺序号<br/>
	 * @param Integer btOrder
	 */
	public void setBtOrder(String btOrder)
	{
		this.btOrder = btOrder;
	}
	
	/**
	 * 类别匹配关键字<br/>
	 * @return String btKeyword
	 */
	public String getBtKeyword()
	{
		return btKeyword;
	}

	/**
	 * 类别匹配关键字<br/>
	 * @param String btKeyword
	 */
	public void setBtKeyword(String btKeyword)
	{
		this.btKeyword = btKeyword;
	}
	
	/**
	 * 创建日期<br/>
	 * @return String addDate
	 */
	public String getAddDate()
	{
		return addDate;
	}

	/**
	 * 创建日期<br/>
	 * @param String addDate
	 */
	public void setAddDate(String addDate)
	{
		this.addDate = addDate;
	}
	
	/**
	 * 创建时间<br/>
	 * @return String addTime
	 */
	public String getAddTime()
	{
		return addTime;
	}

	/**
	 * 创建时间<br/>
	 * @param String addTime
	 */
	public void setAddTime(String addTime)
	{
		this.addTime = addTime;
	}
	
	/**
	 * 创建人<br/>
	 * @return String addUser
	 */
	public String getAddUser()
	{
		return addUser;
	}

	/**
	 * 创建人<br/>
	 * @param String addUser
	 */
	public void setAddUser(String addUser)
	{
		this.addUser = addUser;
	}
	
	/**
	 * 最后修改日期<br/>
	 * @return String updDate
	 */
	public String getUpdDate()
	{
		return updDate;
	}

	/**
	 * 最后修改日期<br/>
	 * @param String updDate
	 */
	public void setUpdDate(String updDate)
	{
		this.updDate = updDate;
	}
	
	/**
	 * 最后修改时间<br/>
	 * @return String updTime
	 */
	public String getUpdTime()
	{
		return updTime;
	}

	/**
	 * 最后修改时间<br/>
	 * @param String updTime
	 */
	public void setUpdTime(String updTime)
	{
		this.updTime = updTime;
	}
	
	/**
	 * 最后修改人<br/>
	 * @return String updUser
	 */
	public String getUpdUser()
	{
		return updUser;
	}

	/**
	 * 最后修改人<br/>
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
		
		sb.append("btId=" + btId).append("\n");
		sb.append("btCode=" + btCode).append("\n");
		sb.append("btName=" + btName).append("\n");
		sb.append("btParentId=" + btParentId).append("\n");
		sb.append("btOrder=" + btOrder).append("\n");
		sb.append("btKeyword=" + btKeyword).append("\n");
		sb.append("addDate=" + addDate).append("\n");
		sb.append("addTime=" + addTime).append("\n");
		sb.append("addUser=" + addUser).append("\n");
		sb.append("updDate=" + updDate).append("\n");
		sb.append("updTime=" + updTime).append("\n");
		sb.append("updUser=" + updUser).append("\n");
		return sb.toString();
	}
}
