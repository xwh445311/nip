package com.efs.common.controller;

/**
 * 返回JSON数据结果
 * @author xwh
 *
 */
public class JsonResult
{
	/**
	 * 返回结果
	 */
	private boolean success;
	
	/**
	 * 返回信息
	 */
	private String message;
	
	/**
	 * 返回结果码
	 */
	private String resCode;

	/**
	 * 返回数据
	 */
	private Object data;
	
	/**
	 * @return the success
	 */
	public boolean isSuccess()
	{
		return success;
	}

	/**
	 * @param success the success to set
	 */
	public void setSuccess(boolean success)
	{
		this.success = success;
	}

	/**
	 * @return the resCode
	 */
	public String getResCode()
	{
		return resCode;
	}

	/**
	 * @param resCode the resCode to set
	 */
	public void setResCode(String resCode)
	{
		this.resCode = resCode;
	}

	/**
	 * @return the data
	 */
	public Object getData()
	{
		return data;
	}

	/**
	 * @param data the data to set
	 */
	public void setData(Object data)
	{
		this.data = data;
	}

	/**
	 * @return the message
	 */
	public String getMessage()
	{
		return message;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(String message)
	{
		this.message = message;
	}
	
	
	
}
