package com.efs.bus.upload.mapper;

import java.util.List;

/**
 * 
 * com.efs.bus.upload.mapper.TsFileUpload
 * @author xwh
 * 2018-05-22 14:03:14
 * 系统文件上传表
 *
 */
public class TsFileUpload
{
	/**
	 * 文件ID
	 */
	private String fpId;
	
	/**
	 * 文件显示名称
	 */
	private String fpName;
	
	/**
	 * 文件存储名称
	 */
	private String fpLocName;
	
	/**
	 * 文件上传人
	 */
	private String fpAddUser;
	
	/**
	 * 文件上传日期
	 */
	private String fpAddDate;
	
	/**
	 * 文件上传时间
	 */
	private String fpAddTime;

	/**
	 * 全文件名称
	 */
	private String fullFileName;

	/**
	 * 文件ID列表
	 */
	private List<String> fpIds;

	public List<String> getFpIds()
	{
		return fpIds;
	}

	public void setFpIds(List<String> fpIds)
	{
		this.fpIds = fpIds;
	}

	public String getFullFileName()
	{
		return fullFileName;
	}

	public void setFullFileName(String fullFileName)
	{
		this.fullFileName = fullFileName;
	}

	/**
	 * 文件ID<br/>
	 * @return String fpId
	 */
	public String getFpId()
	{
		return fpId;
	}

	/**
	 * 文件ID<br/>
	 * @param String fpId
	 */
	public void setFpId(String fpId)
	{
		this.fpId = fpId;
	}
	
	/**
	 * 文件显示名称<br/>
	 * @return String fpName
	 */
	public String getFpName()
	{
		return fpName;
	}

	/**
	 * 文件显示名称<br/>
	 * @param String fpName
	 */
	public void setFpName(String fpName)
	{
		this.fpName = fpName;
	}
	
	/**
	 * 文件存储名称<br/>
	 * @return String fpLocName
	 */
	public String getFpLocName()
	{
		return fpLocName;
	}

	/**
	 * 文件存储名称<br/>
	 * @param String fpLocName
	 */
	public void setFpLocName(String fpLocName)
	{
		this.fpLocName = fpLocName;
	}
	
	/**
	 * 文件上传人<br/>
	 * @return String fpAddUser
	 */
	public String getFpAddUser()
	{
		return fpAddUser;
	}

	/**
	 * 文件上传人<br/>
	 * @param String fpAddUser
	 */
	public void setFpAddUser(String fpAddUser)
	{
		this.fpAddUser = fpAddUser;
	}
	
	/**
	 * 文件上传日期<br/>
	 * @return String fpAddDate
	 */
	public String getFpAddDate()
	{
		return fpAddDate;
	}

	/**
	 * 文件上传日期<br/>
	 * @param String fpAddDate
	 */
	public void setFpAddDate(String fpAddDate)
	{
		this.fpAddDate = fpAddDate;
	}
	
	/**
	 * 文件上传时间<br/>
	 * @return String fpAddTime
	 */
	public String getFpAddTime()
	{
		return fpAddTime;
	}

	/**
	 * 文件上传时间<br/>
	 * @param String fpAddTime
	 */
	public void setFpAddTime(String fpAddTime)
	{
		this.fpAddTime = fpAddTime;
	}
	
	
	@Override
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		
		sb.append("fpId=" + fpId).append("\n");
		sb.append("fpName=" + fpName).append("\n");
		sb.append("fpLocName=" + fpLocName).append("\n");
		sb.append("fpAddUser=" + fpAddUser).append("\n");
		sb.append("fpAddDate=" + fpAddDate).append("\n");
		sb.append("fpAddTime=" + fpAddTime).append("\n");
		return sb.toString();
	}
}
