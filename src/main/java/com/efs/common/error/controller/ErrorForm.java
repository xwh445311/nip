package com.efs.common.error.controller;

public class ErrorForm
{
	//错误信息
	private String errMsg;
	
	//跳转目标URL
	private String targetUrl;

	public String getErrMsg()
	{
		return errMsg;
	}

	public void setErrMsg(String errMsg)
	{
		this.errMsg = errMsg;
	}

	public String getTargetUrl()
	{
		return targetUrl;
	}

	public void setTargetUrl(String targetUrl)
	{
		this.targetUrl = targetUrl;
	}
	
	
}
