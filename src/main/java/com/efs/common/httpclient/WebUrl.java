package com.efs.common.httpclient;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.message.BasicNameValuePair;

import java.util.ArrayList;
import java.util.List;

public class WebUrl
{
	private static Log logger = LogFactory.getLog(WebUrl.class);
	
	private String url;
	private String[] params;
	private String method;
	private List<BasicNameValuePair> newParams = new ArrayList<BasicNameValuePair>();

	
	public String getUrl()
	{
		return url;
	}
	public void setUrl(String url)
	{
		this.url = url;
	}
	public String[] getParams()
	{
		return params;
	}
	public void setParams(String[] params)
	{
		this.params = params;
	}
	public String getMethod()
	{
		return method;
	}
	public void setMethod(String method)
	{
		this.method = method;
	} 
	
	public String getParamStr()
	{
		StringBuffer sb = new StringBuffer();
		if(params != null && params.length>0)
		{
			for(String param : params)
			{
				if(!"".equals(param))
					sb.append(param).append("&");
			}
			
			String res = sb.toString();
			if(res.endsWith("&"))
			{
				res = res.substring(0, res.length()-1);
			}
			
			
			return res;
		}
		else
		{
			return "";
		}
	}
	
	public boolean hasParam()
	{
		if(params != null && params.length>0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public List<BasicNameValuePair> getNewParams()
	{
		return newParams;
	}
	
	public void addParam(String name,String value)
	{
		if(StringUtils.isNotEmpty(name))
		{
			BasicNameValuePair param = new BasicNameValuePair(name, value);
			newParams.add(param);
		}
	}
	
}
