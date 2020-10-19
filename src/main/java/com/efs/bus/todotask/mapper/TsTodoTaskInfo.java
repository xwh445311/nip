package com.efs.bus.todotask.mapper;

/**
 * 
 * com.efs.bus.todotask.mapper.TsTodoTaskInfo
 * @author xwh
 * 2018-05-23 23:13:27
 * 待办任务信息表
 *
 */
public class TsTodoTaskInfo
{
	/**
	 * 黑体主题
	 */
	private String mainTitle;

	/**
	 * 任务标题
	 */
	private String ttTitle;
	
	/**
	 * 任务级别
	 */
	private String ttLvl;
	
	/**
	 * URL地址
	 */
	private String ttUrl;

	public String getMainTitle()
	{
		return mainTitle;
	}

	public void setMainTitle(String mainTitle)
	{
		this.mainTitle = mainTitle;
	}

	/**
	 * 任务标题<br/>
	 * @return String ttTitle
	 */
	public String getTtTitle()
	{
		return ttTitle;
	}

	/**
	 * 任务标题<br/>
	 * @param String ttTitle
	 */
	public void setTtTitle(String ttTitle)
	{
		this.ttTitle = ttTitle;
	}
	
	/**
	 * 任务级别<br/>
	 * @return String ttLvl
	 */
	public String getTtLvl()
	{
		return ttLvl;
	}

	/**
	 * 任务级别<br/>
	 * @param String ttLvl
	 */
	public void setTtLvl(String ttLvl)
	{
		this.ttLvl = ttLvl;
	}
	
	/**
	 * URL地址<br/>
	 * @return String ttUrl
	 */
	public String getTtUrl()
	{
		return ttUrl;
	}

	/**
	 * URL地址<br/>
	 * @param String ttUrl
	 */
	public void setTtUrl(String ttUrl)
	{
		this.ttUrl = ttUrl;
	}
	
	
	@Override
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		
		sb.append("ttTitle=" + ttTitle).append("\n");
		sb.append("ttLvl=" + ttLvl).append("\n");
		sb.append("ttUrl=" + ttUrl).append("\n");
		return sb.toString();
	}
}
