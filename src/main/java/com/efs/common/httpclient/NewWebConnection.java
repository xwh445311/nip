package com.efs.common.httpclient;

import com.xwh.util.EFSUtil;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.*;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.protocol.HttpContext;

import java.io.*;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;


public class NewWebConnection
{

	public static final String METHOD_GET = "GET";
	public static final String METHOD_POST = "POST";
	public static final String METHOD_AJAX = "AJAX";

	public static final String RES_TYPE_HTML = "HTML";
	public static final String RES_TYPE_FILE = "FILE";
	public static final String RES_TYPE_HS_FILE = "HS_FILE";
	public static final String RES_TYPE_AJAX = "AJAX";


	private static Log logger = LogFactory.getLog(NewWebConnection.class);
	
	private CloseableHttpClient client;
	
	//Connection Time out,default is 10000 ms
	private long conTimeOut = 10000;
	
	//re connection account when connection failed ,default is 5
	private int reConNum = 5;
	
	//The idle time between two connection
	private long conIdleTime = 1000;
	
	private String charSet = HTTP.UTF_8;
	
	private boolean needWriteResp = false;
	
	private boolean isAppended = false;

	private String tmpFilePath = "";

	private String logFilePath = "";
	
	private List<WebUrl> urlLists;
	
	public NewWebConnection(List<WebUrl> urls,String charset)
	{
		this(urls);
		this.charSet = charset;
	}

	public static NewWebConnection createWebConnection(WebUrl url,String charset)
	{
		List<WebUrl> urls = new ArrayList<>();
		urls.add(url);
		return new NewWebConnection(urls,charset);
	}

	public static NewWebConnection createWebConnection(WebUrl url)
	{
		List<WebUrl> urls = new ArrayList<>();
		urls.add(url);
		return new NewWebConnection(urls);
	}
	
	public NewWebConnection(List<WebUrl> urls)
	{
		
		HttpRequestRetryHandler retryHandler = null;
		
		logger.debug("Create NewWebConnection" + this);
		urlLists = urls;

		
		retryHandler = new HttpRequestRetryHandler()
		{
			@Override
			public boolean retryRequest(IOException e, int i, HttpContext httpContext)
			{
				if(i > reConNum)
				{
					return false;
				}

				HttpClientContext clientContext = HttpClientContext.adapt(httpContext);
				HttpRequest request = clientContext.getRequest();
				boolean idempotent = !(request instanceof HttpEntityEnclosingRequest);
				if (idempotent) {
					// Retry if the request is considered idempotent
					return true;
				}

				return false;
			}
		};

		client = HttpClients.custom().setRetryHandler(retryHandler).build();

		logger.debug("Init param:Connection Time Out[" + conTimeOut + "]," +
										   "Repeat ConNum[" + reConNum + "]," +
										   	"Connection Idle Time[" + conIdleTime +"]");
	}

	/**
	 * 对于执行接口
	 * @param resType
	 * @return
	 * @throws Exception
	 */
	public String executeRequest(String resType) throws Exception
	{
		String url = null;
		String method = null;
		
		HttpRequestBase httpRequest = null;
		CloseableHttpResponse httpResponse = null;
		HttpEntity httpEntity = null;
		String responseStr = null;
		String redirectUrl = null;
		Header header = null;
		
		try
		{
			for(WebUrl webUrl : urlLists)
			{
				if(webUrl != null)
				{
					if(!checkWebUrl(webUrl))
					{
						logger.error("The Web URL has error ,Execute will return null!");
						return null;
					}
					
					url = webUrl.getUrl();
					method = webUrl.getMethod();
					
					logger.info("Ready to request the url:" + url);
					
					if(METHOD_GET.equals(method))
					{
						httpResponse = executeGet(webUrl);
					}
					else if(METHOD_AJAX.equals(method))
					{
						httpResponse = executeAJAX(webUrl);
					}
					else
					{
						httpResponse = executePost(webUrl);
					}
					
				}
			}
			
			//解析最终响应内容 
			if(httpResponse != null)
			{
				//Execute request
				httpEntity = httpResponse.getEntity();
				logger.info("Get Response State Line :" + httpResponse.getStatusLine());
				
				if(RES_TYPE_FILE.equals(resType))
				{
					logger.info("##########Request handler Complete,The Result is File,File length is:" + httpEntity.getContentLength());
					responseStr = saveFile(httpEntity.getContent());
				}
				else if(RES_TYPE_HS_FILE.equals(resType))
				{
					responseStr = getFileConent(httpEntity.getContent());
					logger.info("##########Request handler Complete,The Result is File,File length is:" + responseStr.length());
				}
				else
				{
					responseStr = parseEntityContent(httpEntity,charSet);
					
					if(needWriteResp)
					{
						try
						{
							appendToFile(responseStr, logFilePath,isAppended);
						} 
						catch (Exception e)
						{
							logger.error("Write Response message to file error .",e);
						}
						
					}
					
					logger.info("##########Request handler Complete,The Result is TXT");
				}
			}
			
		} catch (Exception e)
		{
			logger.error("Execute Request Error", e);
		}
		finally
		{
			if(httpResponse != null)
			{
				httpResponse.close();
			}
		}
		
		return responseStr;
	}
	
	private String saveFile(InputStream is) throws Exception
	{
		String empFileName = null;
		byte[] b = new byte[1024*20];
		FileOutputStream fos = null;
		int i=0;
		try
		{
			empFileName = tmpFilePath + "\\F_" + EFSUtil.getTimeStamp() + ".data";
			fos = new FileOutputStream(empFileName);
			while((i=is.read(b)) != -1)
			{
				fos.write(b, 0, i);
			}
			
			return empFileName;
		} catch (Exception e)
		{
			logger.error(e);
			throw e;
		}
		finally
		{
			if(null != fos)
			{
				fos.close();
			}
			
			if(null != is)
			{
				is.close();
			}
		}
		
	}
	
	private String getFileConent(InputStream is) throws Exception
	{
		StringBuffer sb = new StringBuffer();
		BufferedReader br = null;
		String temp = null;
		try
		{
			br = new BufferedReader(new InputStreamReader(is, "GB2312"));
			while((temp = br.readLine()) != null)
			{
				sb.append(temp).append("\n");
			}
			
			return sb.toString();
		} catch (Exception e)
		{
			logger.error(e);
			throw e;
		}
		finally
		{
			if(null != br)
			{
				br.close();
			}
		}
		
	}
	
	private CloseableHttpResponse executeGet(WebUrl webUrl) throws Exception
	{
		HttpGet httpGet = null;
		CloseableHttpResponse httpResp = null;
		List<BasicNameValuePair> params = null;
		String allUrl = null;
		String param = "";
		
		try
		{
			logger.debug("Execute Http Get Method->executeGet()");
			allUrl = webUrl.getUrl();
			
			params = webUrl.getNewParams();
			
			for(BasicNameValuePair paramObj : params)
			{
				if(StringUtils.isNotEmpty(paramObj.getName()))
				{
					param += paramObj.getName() + "=" + (paramObj.getValue()!= null?paramObj.getValue():"") + "&";
				}
			}
			
			if(StringUtils.isNotEmpty(param))
			{
				param = param.substring(0, param.length()-1);
				allUrl += "?" + param;
			}
			
			httpGet = new HttpGet(allUrl);
			logger.info("executeGet()->The Get Url is:" + allUrl);
			httpResp = client.execute(httpGet);
			
			return httpResp;
			
		} catch (Exception e)
		{
			logger.error("Execute Get Method Error", e);
			throw e;
		}
	}
	

	
	private CloseableHttpResponse  executePost(WebUrl webUrl) throws Exception
	{
		HttpPost httpPost = null;
		CloseableHttpResponse httpResp = null;
		List<BasicNameValuePair> params = null;
		
		try
		{
			logger.debug("Execute Http Post Method->executePOST()");
			httpPost = new HttpPost(webUrl.getUrl());
			params = webUrl.getNewParams();
			
			httpPost.setEntity(new UrlEncodedFormEntity(params, charSet));
			
			httpResp = client.execute(httpPost);
			
			return httpResp;
			
		} catch (Exception e)
		{
			logger.error("Execute Post Method Error", e);
			throw e;
		}
	}
	
	private CloseableHttpResponse  executeAJAX(WebUrl webUrl) throws Exception
	{
		HttpPost httpPost = null;
		CloseableHttpResponse httpResp = null;
		List<BasicNameValuePair> params = null;
		
		try
		{
			logger.debug("Execute Http Post Method->executeAJAX()");
			httpPost = new HttpPost(webUrl.getUrl());
			httpPost.setHeader("X-Requested-With", "XMLHttpRequest");
			params = webUrl.getNewParams();
			
			httpPost.setEntity(new UrlEncodedFormEntity(params, charSet));
			
			httpResp = client.execute(httpPost);
			
			return httpResp;
			
		} catch (Exception e)
		{
			logger.error("Execute Post Method Error", e);
			throw e;
		}
	}
	

	
	private boolean checkWebUrl(WebUrl webUrl) throws Exception
	{
		String url = null;
		String method = null;
		
		if(null != webUrl)
		{
			url = webUrl.getUrl();
			try
			{
				URI.create(url);
			} catch (IllegalArgumentException e)
			{
				logger.error("The url format error:" + url);
				return false;
			}
			
			method = webUrl.getMethod();
			if(!METHOD_GET.equals(method) && !METHOD_POST.equals(method) && !METHOD_AJAX.equals(method))
			{
				logger.error("The Method Param is error:" + method);
				return false;
			}
		}
		
		return true;
	}
	
	public void shutDownClient() throws Exception
	{
		if(null != client)
		{
			client.close();
			client = null;
		}
	}
	
	public static String parseEntityContent(HttpEntity entity,String charSet) throws Exception
	{
		BufferedReader br = null;
		String res = null;
		String tmp  = null;
		try
		{
			if(null == entity)
			{
				return null;
			}
			
			logger.debug("Parse Entity :Content Length:" + entity.getContentLength() + 
										"Content Type :" + entity.getContentType() + 
										"Content Encode :" + entity.getContentType());
			
			br = new BufferedReader(new InputStreamReader(entity.getContent(),charSet));
			while((tmp = br.readLine()) != null)
			{
				res += tmp + "\n";
			}
		} 
		catch (Exception e)
		{
			logger.error("Parse Entity Error :",e);
		}
		finally
		{
			br.close();
		}
		
		return res;
	}

	public static void appendToFile(String res,String fileName,boolean appended) throws Exception
	{
		PrintWriter pw = null;
		FileWriter fw = null;
		try
		{
			if(appended)
			{
				fw = new FileWriter(fileName, true);
			}
			else
			{
				fw = new FileWriter(fileName);
			}

			pw = new PrintWriter(fw);
			pw.write(res);

		}
		finally
		{
			if(null != pw)
				pw.close();
		}
	}
	
	
}
