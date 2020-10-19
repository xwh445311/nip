package com.efs.bus.login.controller;

import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Pattern;

public class LoginForm
{
	/**
	 * 用户ID
	 */
	@NotBlank
	@Pattern(regexp = "[A-Z0-9]{5,10}"   )
	private String uiId;

	/**
	 * 用户姓名
	 */
	private String uiName;

	/**
	 * 用户密码
	 */
	@NotBlank
	private String uiPassword;
	
	/**
	 * 校驗碼
	 */
	@NotBlank
	private String validCode;


	public String getUiId()
	{
		return uiId;
	}

	public void setUiId(String uiId)
	{
		this.uiId = uiId;
	}

	public String getUiName()
	{
		return uiName;
	}

	public void setUiName(String uiName)
	{
		this.uiName = uiName;
	}

	public String getUiPassword()
	{
		return uiPassword;
	}

	public void setUiPassword(String uiPassword)
	{
		this.uiPassword = uiPassword;
	}

	public String getValidCode()
	{
		return validCode;
	}

	public void setValidCode(String validCode)
	{
		this.validCode = validCode;
	}
}
