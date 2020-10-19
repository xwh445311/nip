package com.efs.bpmn.proc.def.mapper;

/**
 * 流程定义BEAN
 * @author xwh
 *
 */
public class WorkProcessDefBean
{
	/**
	 * 流程名称
	 */
	private String wokProsName;
	
	/**
	 * 流程描述
	 * 
	 */
	private String wokProsDesc;
	
	/**
	 * 流程KEY,_流程启动角色ID_流程描述
	 */
	private String wokProsKey;
	
	/**
	 * 流程定义ID
	 */
	private String wokProsId;
	
	/**
	 * 流程发布ID
	 */
	private String workDeployId;
	
	/**
	 * 流程版本
	 */
	private String wokProsVersion;
	
	/**
	 * 流程创建时间
	 */
	private String wokProsCreateDate;
	
	/**
	 * 流程所属公司
	 */
	private String wokProsComp;
	
	/**
	 * 流程定义图片名称
	 */
	private String wokProsImgName;
	
	/**
	 * 流程定义XML名称
	 */
	private String workProcXmlName;
	
	/**
	 * 流程所属审批ROLE
	 */
	private String workPocSpRole;

	
	
	public String getWokProsImgName()
	{
		return wokProsImgName;
	}

	public void setWokProsImgName(String wokProsImgName)
	{
		this.wokProsImgName = wokProsImgName;
	}

	public String getWorkProcXmlName()
	{
		return workProcXmlName;
	}

	public void setWorkProcXmlName(String workProcXmlName)
	{
		this.workProcXmlName = workProcXmlName;
	}

	public String getWorkPocSpRole()
	{
		return workPocSpRole;
	}

	public void setWorkPocSpRole(String workPocSpRole)
	{
		this.workPocSpRole = workPocSpRole;
	}

	public String getWokProsName()
	{
		return wokProsName;
	}

	public void setWokProsName(String wokProsName)
	{
		this.wokProsName = wokProsName;
	}

	public String getWokProsDesc()
	{
		return wokProsDesc;
	}

	public void setWokProsDesc(String wokProsDesc)
	{
		this.wokProsDesc = wokProsDesc;
	}

	public String getWokProsKey()
	{
		return wokProsKey;
	}

	public void setWokProsKey(String wokProsKey)
	{
		this.wokProsKey = wokProsKey;
	}

	public String getWokProsId()
	{
		return wokProsId;
	}

	public void setWokProsId(String wokProsId)
	{
		this.wokProsId = wokProsId;
	}

	public String getWokProsVersion()
	{
		return wokProsVersion;
	}

	public void setWokProsVersion(String wokProsVersion)
	{
		this.wokProsVersion = wokProsVersion;
	}

	public String getWokProsCreateDate()
	{
		return wokProsCreateDate;
	}

	public void setWokProsCreateDate(String wokProsCreateDate)
	{
		this.wokProsCreateDate = wokProsCreateDate;
	}

	public String getWokProsComp()
	{
		return wokProsComp;
	}

	public void setWokProsComp(String wokProsComp)
	{
		this.wokProsComp = wokProsComp;
	}

	public String getWorkDeployId()
	{
		return workDeployId;
	}

	public void setWorkDeployId(String workDeployId)
	{
		this.workDeployId = workDeployId;
	}
	
}
