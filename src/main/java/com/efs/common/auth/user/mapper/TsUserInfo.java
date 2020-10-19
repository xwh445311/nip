package com.efs.common.auth.user.mapper;

import com.efs.common.Util.SysConstant;
import com.efs.common.auth.func.mapper.TsFuncIfno;
import com.efs.common.auth.org.mapper.TsOrgInfo;
import com.efs.common.auth.role.mapper.TsRoleInfo;
import com.xwh.util.EFSUtil;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * com.efs.common.auth.user.mapper.TsUserInfo
 * @author xwh
 * 2017-06-21 23:16:28
 * 系统用户信息表
 *
 */
public class TsUserInfo implements Serializable
{
	/**
	 * 用户ID,对学生就是指学生学号，对于其它人员则由系统自动产生
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
	 * 用户状态:0：失效，1：有效
	 */
	private String uiStatus;

	/**
	 * 生日
	 */
	private String uiBirthday;

	/**
	 * 年龄
	 */
	private String uiAge;

	/**
	 * 性别
	 */
	private String uiSex;
	
	/**
	 * 用户邮箱
	 */
	private String uiEmail;
	
	/**
	 * 用户手机
	 */
	private String uiMobile;

	/**
	 * 来源于参数表
	 01：学校管理层
	 02：学校教职工
	 03：学生
	 04：其他人员
	 */
	private String uiBusType;

	/**
	 * 職業類型值
	 */
	private String uiBusTypeVal;


	/**
	 * 姓名简称,老师需要姓名简称，为一个汉字
	 */
	private String uiShortName;

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

	private String utLevelVal;

	/**
	 * 职务：校长，副校长等，来源于系统参数表
	 */
	private String utDuty;

	private String utDutyVal;

	/**
	 * 当前学期所对应的班主任班级
	 */
	private String utLeadClass;

	private String utOrg;

	/**
	 * 当前学期的任课班级
	 */
	private List<String> utTeachClasses;

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
	 * 学籍状态:01在籍，02：转走，03：休学,04:毕业
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

	/**
	 * 用户角色
	 */
	private List<TsRoleInfo> uiRoles;

	/**
	 * 用于功能列表
	 */
	private List<String> userFuncIdList;

	/**
	 * 功能对象列表
	 */
	private List<TsFuncIfno> userFuncList;

	/**
	 * 用户所属机构
	 */
	private List<TsOrgInfo> userOrgList;

	/**
	 * 为显示在页面上的导航菜单
	 */
	private List<TsFuncIfno> userNavFuncList;

	private String uiIsSup;

	private String isSuperUser;

	/**
	 * 用户角色，显示时用
	 */
	private String[] userRoles;

    /**
     * 用户所属机构
     */
    private String[] userOrgs;


	/**
	 * 用户菜单HTML字符串，用于前端生成菜单
	 */
	private String funcHtmlStr;



	//查询参数
	//多个业务类型
	private String multBusType;

	//查询已排课量小于3的老师
	private String canHasScore;

	//学期
	private String scTerm;

	//查询班主任
	private String hasClassLeader;


	public String getScTerm()
	{
		return scTerm;
	}

	public void setScTerm(String scTerm)
	{
		this.scTerm = scTerm;
	}

	public String getCanHasScore()
	{
		return canHasScore;
	}

	public void setCanHasScore(String canHasScore)
	{
		this.canHasScore = canHasScore;
	}

	public String getHasClassLeader()
	{
		return hasClassLeader;
	}

	public void setHasClassLeader(String hasClassLeader)
	{
		this.hasClassLeader = hasClassLeader;
	}

	public String getMultBusType()
	{
		return multBusType;
	}

	public void setMultBusType(String multBusType)
	{
		this.multBusType = multBusType;
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

	public String[] getUserRoles()
	{
		return userRoles;
	}

	public void setUserRoles(String[] userRoles)
	{
		this.userRoles = userRoles;
	}

	public String getIsSuperUser()
	{
		return isSuperUser;
	}

	public void setIsSuperUser(String isSuperUser)
	{
		this.isSuperUser = isSuperUser;
	}

	public String getUiIsSup()
	{
		return uiIsSup;
	}

	public void setUiIsSup(String uiIsSup)
	{
		this.uiIsSup = uiIsSup;
	}

	public String getFuncHtmlStr()
	{
		return funcHtmlStr;
	}

	public void setFuncHtmlStr(String funcHtmlStr)
	{
		this.funcHtmlStr = funcHtmlStr;
	}

	public List<String> getUserFuncIdList()
	{
		return userFuncIdList;
	}

	public void setUserFuncIdList(List<String> userFuncIdList)
	{
		this.userFuncIdList = userFuncIdList;
	}

	public List<TsFuncIfno> getUserFuncList()
	{
		return userFuncList;
	}

	public void setUserFuncList(List<TsFuncIfno> userFuncList)
	{
		this.userFuncList = userFuncList;
	}

	public List<TsRoleInfo> getUiRoles()
	{
		return uiRoles;
	}

	public void setUiRoles(List<TsRoleInfo> uiRoles)
	{
		this.uiRoles = uiRoles;
	}

    public String[] getUserOrgs()
    {
        return userOrgs;
    }

    public void setUserOrgs(String[] userOrgs)
    {
        this.userOrgs = userOrgs;
    }

	public String getUtLevelVal()
	{
		return utLevelVal;
	}

	public void setUtLevelVal(String utLevelVal)
	{
		this.utLevelVal = utLevelVal;
	}

	public String getUtDutyVal()
	{
		return utDutyVal;
	}

	public void setUtDutyVal(String utDutyVal)
	{
		this.utDutyVal = utDutyVal;
	}

	public String getUtOrg()
	{
		return utOrg;
	}

	public void setUtOrg(String utOrg)
	{
		this.utOrg = utOrg;
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

	public String getUiBirthday()
	{
		return uiBirthday;
	}

	public void setUiBirthday(String uiBirthday)
	{
		this.uiBirthday = uiBirthday;
	}

	public String getUiAge()
	{
		return uiAge;
	}

	public void setUiAge(String uiAge)
	{
		this.uiAge = uiAge;
	}

	public String getUiSex()
	{
		return uiSex;
	}

	public void setUiSex(String uiSex)
	{
		this.uiSex = uiSex;
	}

	public List<TsOrgInfo> getUserOrgList()
	{
		return userOrgList;
	}

	public void setUserOrgList(List<TsOrgInfo> userOrgList)
	{
		this.userOrgList = userOrgList;
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

	public String getUiBusTypeVal() throws Exception
	{
		uiBusTypeVal = (String)EFSUtil.getDBParamValue(SysConstant.DB_PARAM_TYPE_USER_TYPE,uiBusType);
		return uiBusTypeVal;
	}

	/**
	 * 保存用戶前處理
	 * @throws Exception
	 */
	public void specHand4Save() throws Exception
	{
		if(userRoles != null && userRoles.length > 0)
		{
			List<TsRoleInfo> roleList = new ArrayList<TsRoleInfo>();
			TsRoleInfo bean = null;

			for(String id : userRoles)
			{
				bean = new TsRoleInfo();
				bean.setRiId(id);
				roleList.add(bean);
			}

			uiRoles = roleList;
		}

		if(userOrgs != null && userOrgs.length > 0)
		{
			List<TsOrgInfo> orgList = new ArrayList<>();
			TsOrgInfo bean = null;
			for(String id : userOrgs)
			{
				bean=new TsOrgInfo();
				bean.setOiCode(id);
				orgList.add(bean);
			}

			userOrgList = orgList;
		}

		//處理密碼
		uiPassword = EFSUtil.md5Encoding(uiPassword);
	}

	/**
	 * 顯示用戶信息
	 * @throws Exception
	 */
	public void specHand4Show() throws Exception
	{
		String[] roles = new String[0];
		if(uiRoles != null && uiRoles.size() > 0)
		{
			roles = new String[uiRoles.size()];
			for(int i=0;i<uiRoles.size();i++)
			{
				TsRoleInfo bean = uiRoles.get(i);
				roles[i] = bean.getRiId();
			}
		}
		userRoles = roles;

		String[] orgs = new String[0];
		if(userOrgList != null && userOrgList.size() > 0)
		{
			orgs = new String[userOrgList.size()];
			for(int i=0;i<userOrgList.size();i++)
			{
				TsOrgInfo orgInfo = userOrgList.get(i);
				orgs[i] = orgInfo.getOiCode();
			}
		}
		userOrgs = orgs;
	}

	public List<TsFuncIfno> getUserNavFuncList()
	{
		return userNavFuncList;
	}

	public void setUserNavFuncList(List<TsFuncIfno> userNavFuncList)
	{
		this.userNavFuncList = userNavFuncList;
	}

	public String getUtLeadClass()
	{
		return utLeadClass;
	}

	public void setUtLeadClass(String utLeadClass)
	{
		this.utLeadClass = utLeadClass;
	}

	public List<String> getUtTeachClasses()
	{
		return utTeachClasses;
	}

	public void setUtTeachClasses(List<String> utTeachClasses)
	{
		this.utTeachClasses = utTeachClasses;
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
