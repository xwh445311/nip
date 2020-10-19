package com.efs.common.auth.user.controller;

/**
 * 
 * com.efs.common.auth.user.controller.TsUserInfoForm
 * @author xwh
 * 2017-06-20 15:35:18
 * 系统用户信息表
 *
 */
public class TsUserInfoForm
{
	/**
	 * 用户ID
	 */
	private String uiId;
	
	/**
	 * 用户姓名
	 */
	private String uiName;
	
	/**
	 * 用户密码
	 */
	private String uiPassword;
	
	/**
	 * 用户状态:0：失效，1：有效，2：系统锁定
	 */
	private String uiStatus;

	/**
	 * 用户邮箱
	 */
	private String uiEmail;
	
	/**
	 * 用户手机
	 */
	private String uiMobile;

	/**
	 * 职业类型
	 */
	private String uiBusType;

	/**
	 * 姓名简称,老师需要姓名简称，为一个汉字
	 */
	private String uiShortName;

	/**
	 * 性别
	 */
	private String uiSex;

	/**
	 * 生日
	 */
	private String uiBirthday;

	/**
	 *
	 */
	private String uiChangePass;

	/**
	 * 限借图书数量
	 */
	private Integer uiBookCount;

	/**
	 * 01：在职，02：离职
	 */
	private String utWorkStatus;

	/**
	 * 入职日期
	 */
	private String utEntryDate;

	/**
	 * 离职日期
	 */
	private String utLeaveDate;

	/**
	 * 工作级别：用户的级别，高级，中级等，来源于系统参数表
	 */
	private String utLevel;

	/**
	 * 职务：校长，副校长等，来源于系统参数表
	 */
	private String utDuty;

	/**
	 * 主要联系人电话
	 */
	private String usFirstPhone;

	/**
	 * 主要联系人姓名
	 */
	private String usFirstName;

	/**
	 * 主要联系人关系
	 */
	private String usFirstShip;

	/**
	 * 第二联系人电话
	 */
	private String usSecPhon;

	/**
	 * 第二联系人姓名
	 */
	private String usSecName;

	/**
	 * 第二联系人关系
	 */
	private String usSecShip;

	/**
	 *
	 */
	private String usClass;

	/**
	 *
	 */
	private String usClassName;

	/**
	 * 入学日期
	 */
	private String usEntryDate;

	/**
	 * 学籍状态:01在籍，02：转走，03：休学
	 */
	private String usSchStatus;

	/**
	 * 家庭住址
	 */
	private String usAddr;
	
	/**
	 * 上次登录IP
	 */
	private String uiLastIp;
	
	/**
	 * 上次登录时间
	 */
	private String uiLastTime;
	
	/**
	 * 本次登录IP
	 */
	private String uiThisIp;
	
	/**
	 * 本次登录时间
	 */
	private String uiThisTime;
	
	/**
	 * 创建日期
	 */
	private String uiAddDate;
	
	/**
	 * 创建时间
	 */
	private String uiAddTime;
	
	/**
	 * 创建用户ID
	 */
	private String uiAddUser;
	
	/**
	 * 最后修改日期
	 */
	private String uiUpdDate;
	
	/**
	 * 最后修改时间
	 */
	private String uiUpdTime;
	
	/**
	 * 修改用户ID
	 */
	private String uiUpdUser;

	private String uiIsSup;

	/**
	 * 用户角色，显示时用
	 */
	private String[] userRoles;

    /**
     * 用户所属机构
     */
	private String[] userOrgs;

	public String[] getUserRoles()
	{
		return userRoles;
	}

	public void setUserRoles(String[] userRoles)
	{
		this.userRoles = userRoles;
	}

	public String getUiIsSup()
	{
		return uiIsSup;
	}

	public void setUiIsSup(String uiIsSup)
	{
		this.uiIsSup = uiIsSup;
	}

    public String[] getUserOrgs()
    {
        return userOrgs;
    }

    public void setUserOrgs(String[] userOrgs)
    {
        this.userOrgs = userOrgs;
    }

	public String getUsClass()
	{
		return usClass;
	}

	public void setUsClass(String usClass)
	{
		this.usClass = usClass;
	}

	public String getUsClassName()
	{
		return usClassName;
	}

	public void setUsClassName(String usClassName)
	{
		this.usClassName = usClassName;
	}

	/**
	 * 用户ID<br/>
	 * @return String uiId
	 */
	public String getUiId()
	{
		return uiId;
	}

	/**
	 * 用户ID<br/>
	 * @param String uiId
	 */
	public void setUiId(String uiId)
	{
		this.uiId = uiId;
	}
	
	/**
	 * 用户姓名<br/>
	 * @return String uiName
	 */
	public String getUiName()
	{
		return uiName;
	}

	/**
	 * 用户姓名<br/>
	 * @param String uiName
	 */
	public void setUiName(String uiName)
	{
		this.uiName = uiName;
	}
	
	/**
	 * 用户密码<br/>
	 * @return String uiPassword
	 */
	public String getUiPassword()
	{
		return uiPassword;
	}

	/**
	 * 用户密码<br/>
	 * @param String uiPassword
	 */
	public void setUiPassword(String uiPassword)
	{
		this.uiPassword = uiPassword;
	}
	
	/**
	 * 用户状态:0：失效，1：有效<br/>
	 * @return String uiStatus
	 */
	public String getUiStatus()
	{
		return uiStatus;
	}

	/**
	 * 用户状态:0：失效，1：有效<br/>
	 * @param String uiStatus
	 */
	public void setUiStatus(String uiStatus)
	{
		this.uiStatus = uiStatus;
	}
	
	/**
	 * 用户邮箱<br/>
	 * @return String uiEmail
	 */
	public String getUiEmail()
	{
		return uiEmail;
	}

	/**
	 * 用户邮箱<br/>
	 * @param String uiEmail
	 */
	public void setUiEmail(String uiEmail)
	{
		this.uiEmail = uiEmail;
	}
	
	/**
	 * 用户手机<br/>
	 * @return String uiMobile
	 */
	public String getUiMobile()
	{
		return uiMobile;
	}

	/**
	 * 用户手机<br/>
	 * @param String uiMobile
	 */
	public void setUiMobile(String uiMobile)
	{
		this.uiMobile = uiMobile;
	}
	
	/**
	 * 上次登录IP<br/>
	 * @return String uiLastIp
	 */
	public String getUiLastIp()
	{
		return uiLastIp;
	}

	/**
	 * 上次登录IP<br/>
	 * @param String uiLastIp
	 */
	public void setUiLastIp(String uiLastIp)
	{
		this.uiLastIp = uiLastIp;
	}
	
	/**
	 * 上次登录时间<br/>
	 * @return String uiLastTime
	 */
	public String getUiLastTime()
	{
		return uiLastTime;
	}

	/**
	 * 上次登录时间<br/>
	 * @param String uiLastTime
	 */
	public void setUiLastTime(String uiLastTime)
	{
		this.uiLastTime = uiLastTime;
	}
	
	/**
	 * 本次登录IP<br/>
	 * @return String uiThisIp
	 */
	public String getUiThisIp()
	{
		return uiThisIp;
	}

	/**
	 * 本次登录IP<br/>
	 * @param String uiThisIp
	 */
	public void setUiThisIp(String uiThisIp)
	{
		this.uiThisIp = uiThisIp;
	}
	
	/**
	 * 本次登录时间<br/>
	 * @return String uiThisTime
	 */
	public String getUiThisTime()
	{
		return uiThisTime;
	}

	/**
	 * 本次登录时间<br/>
	 * @param String uiThisTime
	 */
	public void setUiThisTime(String uiThisTime)
	{
		this.uiThisTime = uiThisTime;
	}
	
	/**
	 * 创建日期<br/>
	 * @return String uiAddDate
	 */
	public String getUiAddDate()
	{
		return uiAddDate;
	}

	/**
	 * 创建日期<br/>
	 * @param String uiAddDate
	 */
	public void setUiAddDate(String uiAddDate)
	{
		this.uiAddDate = uiAddDate;
	}
	
	/**
	 * 创建时间<br/>
	 * @return String uiAddTime
	 */
	public String getUiAddTime()
	{
		return uiAddTime;
	}

	/**
	 * 创建时间<br/>
	 * @param String uiAddTime
	 */
	public void setUiAddTime(String uiAddTime)
	{
		this.uiAddTime = uiAddTime;
	}
	
	/**
	 * 创建用户ID<br/>
	 * @return String uiAddUser
	 */
	public String getUiAddUser()
	{
		return uiAddUser;
	}

	/**
	 * 创建用户ID<br/>
	 * @param String uiAddUser
	 */
	public void setUiAddUser(String uiAddUser)
	{
		this.uiAddUser = uiAddUser;
	}
	
	/**
	 * 最后修改日期<br/>
	 * @return String uiUpdDate
	 */
	public String getUiUpdDate()
	{
		return uiUpdDate;
	}

	/**
	 * 最后修改日期<br/>
	 * @param String uiUpdDate
	 */
	public void setUiUpdDate(String uiUpdDate)
	{
		this.uiUpdDate = uiUpdDate;
	}
	
	/**
	 * 最后修改时间<br/>
	 * @return String uiUpdTime
	 */
	public String getUiUpdTime()
	{
		return uiUpdTime;
	}

	/**
	 * 最后修改时间<br/>
	 * @param String uiUpdTime
	 */
	public void setUiUpdTime(String uiUpdTime)
	{
		this.uiUpdTime = uiUpdTime;
	}
	
	/**
	 * 修改用户ID<br/>
	 * @return String uiUpdUser
	 */
	public String getUiUpdUser()
	{
		return uiUpdUser;
	}

	/**
	 * 修改用户ID<br/>
	 * @param String uiUpdUser
	 */
	public void setUiUpdUser(String uiUpdUser)
	{
		this.uiUpdUser = uiUpdUser;
	}

	public String getUiBusType()
	{
		return uiBusType;
	}

	public void setUiBusType(String uiBusType)
	{
		this.uiBusType = uiBusType;
	}

	public String getUiShortName()
	{
		return uiShortName;
	}

	public void setUiShortName(String uiShortName)
	{
		this.uiShortName = uiShortName;
	}

	public String getUiChangePass()
	{
		return uiChangePass;
	}

	public void setUiChangePass(String uiChangePass)
	{
		this.uiChangePass = uiChangePass;
	}


	public Integer getUiBookCount()
	{
		return uiBookCount;
	}

	public void setUiBookCount(Integer uiBookCount)
	{
		this.uiBookCount = uiBookCount;
	}

	public String getUtWorkStatus()
	{
		return utWorkStatus;
	}

	public void setUtWorkStatus(String utWorkStatus)
	{
		this.utWorkStatus = utWorkStatus;
	}

	public String getUtEntryDate()
	{
		return utEntryDate;
	}

	public void setUtEntryDate(String utEntryDate)
	{
		this.utEntryDate = utEntryDate;
	}

	public String getUtLeaveDate()
	{
		return utLeaveDate;
	}

	public void setUtLeaveDate(String utLeaveDate)
	{
		this.utLeaveDate = utLeaveDate;
	}

	public String getUtLevel()
	{
		return utLevel;
	}

	public void setUtLevel(String utLevel)
	{
		this.utLevel = utLevel;
	}

	public String getUtDuty()
	{
		return utDuty;
	}

	public void setUtDuty(String utDuty)
	{
		this.utDuty = utDuty;
	}

	public String getUsFirstPhone()
	{
		return usFirstPhone;
	}

	public void setUsFirstPhone(String usFirstPhone)
	{
		this.usFirstPhone = usFirstPhone;
	}

	public String getUsFirstName()
	{
		return usFirstName;
	}

	public void setUsFirstName(String usFirstName)
	{
		this.usFirstName = usFirstName;
	}

	public String getUsFirstShip()
	{
		return usFirstShip;
	}

	public void setUsFirstShip(String usFirstShip)
	{
		this.usFirstShip = usFirstShip;
	}

	public String getUsSecPhon()
	{
		return usSecPhon;
	}

	public void setUsSecPhon(String usSecPhon)
	{
		this.usSecPhon = usSecPhon;
	}

	public String getUsSecName()
	{
		return usSecName;
	}

	public void setUsSecName(String usSecName)
	{
		this.usSecName = usSecName;
	}

	public String getUsSecShip()
	{
		return usSecShip;
	}

	public void setUsSecShip(String usSecShip)
	{
		this.usSecShip = usSecShip;
	}

	public String getUsEntryDate()
	{
		return usEntryDate;
	}

	public void setUsEntryDate(String usEntryDate)
	{
		this.usEntryDate = usEntryDate;
	}

	public String getUsSchStatus()
	{
		return usSchStatus;
	}

	public void setUsSchStatus(String usSchStatus)
	{
		this.usSchStatus = usSchStatus;
	}

	public String getUsAddr()
	{
		return usAddr;
	}

	public void setUsAddr(String usAddr)
	{
		this.usAddr = usAddr;
	}

	public String getUiSex()
	{
		return uiSex;
	}

	public void setUiSex(String uiSex)
	{
		this.uiSex = uiSex;
	}

	public String getUiBirthday()
	{
		return uiBirthday;
	}

	public void setUiBirthday(String uiBirthday)
	{
		this.uiBirthday = uiBirthday;
	}

	@Override
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		
		sb.append("uiId=" + uiId).append("\n");
		sb.append("uiName=" + uiName).append("\n");
		sb.append("uiPassword=" + uiPassword).append("\n");
		sb.append("uiStatus=" + uiStatus).append("\n");
		sb.append("uiEmail=" + uiEmail).append("\n");
		sb.append("uiMobile=" + uiMobile).append("\n");
		sb.append("uiLastIp=" + uiLastIp).append("\n");
		sb.append("uiLastTime=" + uiLastTime).append("\n");
		sb.append("uiThisIp=" + uiThisIp).append("\n");
		sb.append("uiThisTime=" + uiThisTime).append("\n");
		sb.append("uiAddDate=" + uiAddDate).append("\n");
		sb.append("uiAddTime=" + uiAddTime).append("\n");
		sb.append("uiAddUser=" + uiAddUser).append("\n");
		sb.append("uiUpdDate=" + uiUpdDate).append("\n");
		sb.append("uiUpdTime=" + uiUpdTime).append("\n");
		sb.append("uiUpdUser=" + uiUpdUser).append("\n");
		return sb.toString();
	}
}
