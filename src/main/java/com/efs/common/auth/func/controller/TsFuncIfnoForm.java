package com.efs.common.auth.func.controller;

/**
 * 
 * com.efs.common.auth.func.controller.TsFuncIfnoForm
 * @author xuwh
 * 2017-06-25 15:53:43
 * 系统功能表
 *
 */
public class TsFuncIfnoForm
{
	/**
	 * 主键ID
	 */
	private String muDbId;
	
	/**
	 * 业务ID
	 */
	private String muId;
	
	/**
	 * 功能名称
	 */
	private String muName;
	
	/**
	 * 功能提示信息
	 */
	private String muTips;
	
	/**
	 * 功能URL
	 */
	private String muUrl;
	
	/**
	 * 父ID
	 */
	private String muParDbId;
	
	/**
	 * 功能状态
	 */
	private String muStatus;
	
	/**
	 * 菜单类型（M:菜单，U：功能）
	 */
	private String muTypes;
	
	/**
	 * 菜单系统类别，用于区分系统中多套菜单
	 */
	private String muSysType;
	
	/**
	 * CSS样式
	 */
	private String muCss;
	
	/**
	 * 排序
	 */
	private String muOrders;

	private String muIsSuper;

	/**
	 * 是否可以添加到快捷桌面(1:可以，0：不可以)
	 */
	private String muQuickLink;

	/**
	 * 快捷菜单定位IDD
	 */
	private String muQuickPosId;

	/**
	 * 快捷方式URL
	 */
	private String muQuickUrl;

	public String getMuIsSuper()
	{
		return muIsSuper;
	}

	public void setMuIsSuper(String muIsSuper)
	{
		this.muIsSuper = muIsSuper;
	}

	public String getMuQuickUrl()
	{
		return muQuickUrl;
	}

	public void setMuQuickUrl(String muQuickUrl)
	{
		this.muQuickUrl = muQuickUrl;
	}

	/**
	 * 主键ID<br/>
	 * @return String muDbId
	 */
	public String getMuDbId()
	{
		return muDbId;
	}

	/**
	 * 主键ID<br/>
	 * @param String muDbId
	 */
	public void setMuDbId(String muDbId)
	{
		this.muDbId = muDbId;
	}
	
	/**
	 * 业务ID<br/>
	 * @return String muId
	 */
	public String getMuId()
	{
		return muId;
	}

	/**
	 * 业务ID<br/>
	 * @param String muId
	 */
	public void setMuId(String muId)
	{
		this.muId = muId;
	}
	
	/**
	 * 功能名称<br/>
	 * @return String muName
	 */
	public String getMuName()
	{
		return muName;
	}

	/**
	 * 功能名称<br/>
	 * @param String muName
	 */
	public void setMuName(String muName)
	{
		this.muName = muName;
	}
	
	/**
	 * 功能提示信息<br/>
	 * @return String muTips
	 */
	public String getMuTips()
	{
		return muTips;
	}

	/**
	 * 功能提示信息<br/>
	 * @param String muTips
	 */
	public void setMuTips(String muTips)
	{
		this.muTips = muTips;
	}
	
	/**
	 * 功能URL<br/>
	 * @return String muUrl
	 */
	public String getMuUrl()
	{
		return muUrl;
	}

	/**
	 * 功能URL<br/>
	 * @param String muUrl
	 */
	public void setMuUrl(String muUrl)
	{
		this.muUrl = muUrl;
	}
	
	/**
	 * 父ID<br/>
	 * @return String muParDbId
	 */
	public String getMuParDbId()
	{
		return muParDbId;
	}

	/**
	 * 父ID<br/>
	 * @param String muParDbId
	 */
	public void setMuParDbId(String muParDbId)
	{
		this.muParDbId = muParDbId;
	}
	
	/**
	 * 功能状态<br/>
	 * @return String muStatus
	 */
	public String getMuStatus()
	{
		return muStatus;
	}

	/**
	 * 功能状态<br/>
	 * @param String muStatus
	 */
	public void setMuStatus(String muStatus)
	{
		this.muStatus = muStatus;
	}
	
	/**
	 * 菜单类型（M:菜单，U：功能）<br/>
	 * @return String muTypes
	 */
	public String getMuTypes()
	{
		return muTypes;
	}

	/**
	 * 菜单类型（M:菜单，U：功能）<br/>
	 * @param String muTypes
	 */
	public void setMuTypes(String muTypes)
	{
		this.muTypes = muTypes;
	}
	
	/**
	 * 菜单系统类别，用于区分系统中多套菜单<br/>
	 * @return String muSysType
	 */
	public String getMuSysType()
	{
		return muSysType;
	}

	/**
	 * 菜单系统类别，用于区分系统中多套菜单<br/>
	 * @param String muSysType
	 */
	public void setMuSysType(String muSysType)
	{
		this.muSysType = muSysType;
	}
	
	/**
	 * CSS样式<br/>
	 * @return String muCss
	 */
	public String getMuCss()
	{
		return muCss;
	}

	/**
	 * CSS样式<br/>
	 * @param String muCss
	 */
	public void setMuCss(String muCss)
	{
		this.muCss = muCss;
	}
	
	/**
	 * 排序<br/>
	 * @return String muOrders
	 */
	public String getMuOrders()
	{
		return muOrders;
	}

	/**
	 * 排序<br/>
	 * @param String muOrders
	 */
	public void setMuOrders(String muOrders)
	{
		this.muOrders = muOrders;
	}

	public String getMuQuickLink()
	{
		return muQuickLink;
	}

	public void setMuQuickLink(String muQuickLink)
	{
		this.muQuickLink = muQuickLink;
	}

	public String getMuQuickPosId()
	{
		return muQuickPosId;
	}

	public void setMuQuickPosId(String muQuickPosId)
	{
		this.muQuickPosId = muQuickPosId;
	}

	@Override
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		
		sb.append("muDbId=" + muDbId).append("\n");
		sb.append("muId=" + muId).append("\n");
		sb.append("muName=" + muName).append("\n");
		sb.append("muTips=" + muTips).append("\n");
		sb.append("muUrl=" + muUrl).append("\n");
		sb.append("muParDbId=" + muParDbId).append("\n");
		sb.append("muStatus=" + muStatus).append("\n");
		sb.append("muTypes=" + muTypes).append("\n");
		sb.append("muSysType=" + muSysType).append("\n");
		sb.append("muCss=" + muCss).append("\n");
		sb.append("muOrders=" + muOrders).append("\n");
		return sb.toString();
	}
}
