package com.efs.common.controller;

import com.alibaba.fastjson.JSON;
import com.efs.common.Util.SysConstant;
import com.efs.common.auth.user.mapper.TsUserInfo;
import com.efs.common.database.Page;
import com.efs.common.database.PageDataBunder;
import com.xwh.util.EFSUtil;
import org.apache.commons.collections4.MapUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;

/**
 * 基础ACTION 类
 * @author xwh
 *
 */
public class BaseController
{
	private static Log logger = LogFactory.getLog(BaseController.class);
	
	/**
	 * 封装前端传过来的分页信息
	 * @param request
	 * @return
	 */
	protected Page getPage(HttpServletRequest request)
	{
		Page page = new Page();
		int p = 1;
		int r = 20;
		
		if(request.getParameter("page") != null)
		{
			p = Integer.parseInt(request.getParameter("page"));
		}
		
		if(request.getParameter("rows") != null)
		{
			r = Integer.parseInt(request.getParameter("rows"));
		}
		
		page.setPage(p);
		page.setRows(r);
		return page;
	}
	
	/**
	 * 将结果封装为DATA GRID的数据
	 * @param page
	 * @param dataList
	 * @return
	 */
	protected PageDataBunder packDataPage(Page page, List<?> dataList)
	{
		PageDataBunder pb = new PageDataBunder();
		pb.setTotal(page.getTotal());
		pb.setRows(dataList);
		return pb;
	}
	
	/**
	 * 返回处理结果
	 * @param success
	 * @return
	 */
	protected JsonResult packJsonResult(boolean success)
	{
		JsonResult res = new JsonResult();
		res.setSuccess(success);
		return res;
	}
	
	/**
	 * 返回处理结果
	 * @param success
	 * @return
	 */
	protected JsonResult packJsonResult(boolean success, Object data)
	{
		JsonResult res = new JsonResult();
		res.setSuccess(success);
		res.setData(data);
		return res;
	}
	
	/**
	 * 返回处理结果
	 * @param success
	 * @return
	 */
	protected JsonResult packJsonResult(boolean success, String message, Object obj)
	{
		JsonResult res = new JsonResult();
		res.setSuccess(success);
		res.setMessage(message);
		res.setData(obj);
		return res;
	}
	
	/**
	 * 对于FORM表单提交返回，因为IE浏览器不支持APPLICATION/JSON，需要直接写流，
	 * @param resp
	 * @return
	 * @throws Exception
	 */
	protected JsonResult packJsonResult4Form(boolean success, HttpServletResponse resp) throws Exception
	{
		JsonResult js = packJsonResult(success);
		String res = JSON.toJSONString(js);
		PrintWriter pw = resp.getWriter();
		pw.write(res);
		pw.flush();
		return null;
	}
	
	/**
	 * 对于FORM表单提交返回，因为IE浏览器不支持APPLICATION/JSON，需要直接写流，
	 * @param resp
	 * @return
	 * @throws Exception
	 */
	protected JsonResult packJsonResult4Form(boolean success, Object data, HttpServletResponse resp) throws Exception
	{
		JsonResult js = packJsonResult(success);
		js.setData(data);
		String res = JSON.toJSONString(js);
		PrintWriter pw = resp.getWriter();
		pw.write(res);
		pw.flush();
		return null;
	}
	
	/**
	 * 返回當前系統登錄用戶
	 * @param session
	 * @return
	 */
	protected TsUserInfo getSessionUser(HttpSession session)
	{
		TsUserInfo userBean = (TsUserInfo)session.getAttribute(SysConstant.SESSION_KEY_SYSUSER);
		return userBean;
	}

	/**
	 * 获得当前登录系统用户的用户ID
	 * @param session
	 * @return
	 */
	protected String getSessionUserId(HttpSession session)
	{
		return getSessionUser(session).getUiId();
	}
	
	/**
	 * 下载EXCEL文件处理类
	 * @param fileName
	 * @param contentType
	 * @param book
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	protected void downLoadFile(String fileName, String contentType, Workbook book, HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		response.setContentType(contentType);
		response.setCharacterEncoding("UTF-8");
		fileName = URLEncoder.encode(fileName, "UTF-8");
		response.setHeader("Content-disposition", "attachment;filename=\"" + fileName + "\"");
		OutputStream os = response.getOutputStream();
		book.write(os);
		os.flush();
		os.close();
	}
	
	//通用下載文件處理類
	protected void commonDownLoadFile(String fileName,String contentType,String filePath,HttpServletRequest request,HttpServletResponse response) throws Exception
	{
		response.setContentType(contentType);
		response.setCharacterEncoding("UTF-8");
		fileName = EFSUtil.encodeCHUrlString(fileName);
		response.setHeader("Content-disposition", "attachment;filename=\"" + fileName + "\"");
		FileInputStream fis = null;
		OutputStream fos = null;
		
		try
		{
			fis = new FileInputStream(filePath);
			byte[] bt = new byte[1024*1000];
			int i =0;
			fos = response.getOutputStream();
			while((i = fis.read(bt)) != -1)
			{
				fos.write(bt, 0, i);
			}
			
			fos.flush();
			fos.close();
		}
		finally
		{
			if(null != fis) fis.close();
			
		}
	}
	
	//通用下載文件處理類
	protected void commonDownLoadFile(String fileName,String contentType,InputStream is,HttpServletRequest request,HttpServletResponse response) throws Exception
	{
		response.setContentType(contentType);
		response.setCharacterEncoding("UTF-8");
		fileName = EFSUtil.encodeCHUrlString(fileName);
		response.setHeader("Content-disposition", "attachment;filename=\"" + fileName + "\"");
		OutputStream fos = null;
		
		try
		{
			byte[] bt = new byte[1024*1000];
			int i =0;
			fos = response.getOutputStream();
			while((i = is.read(bt)) != -1)
			{
				fos.write(bt, 0, i);
			}
			
			fos.flush();
			fos.close();
		}
		finally
		{
			if(null != is) is.close();
			
		}
	}
	
	//通用下載文件處理類
	protected void commonDownLoadFile(String fileName,String filePath,HttpServletRequest request,HttpServletResponse response) throws Exception
	{
		response.setCharacterEncoding("UTF-8");
		fileName = EFSUtil.encodeCHUrlString(fileName);
		response.setHeader("Content-disposition", "attachment;filename=\"" + fileName + "\"");
		FileInputStream fis = null;
		OutputStream fos = null;
		
		try
		{
			fis = new FileInputStream(filePath);
			byte[] bt = new byte[1024*1000];
			int i =0;
			fos = response.getOutputStream();
			while((i = fis.read(bt)) != -1)
			{
				fos.write(bt, 0, i);
			}
			
			fos.flush();
			fos.close();
		}
		finally
		{
			if(null != fis) fis.close();
			
		}
	}
	

	/**
	 * 获得当前应用的根路径
	 * @param request
	 * @return
	 * @throws Exception
	 */
	protected String getCurrentRootPath(HttpServletRequest request) throws Exception
	{
		String path = request.getSession().getServletContext().getRealPath("/");
		return path;
	}
	
	/**
	 * 接收上傳文件並重命名保存到本地臨時目錄
	 * @return
	 * @throws Exception
	 */
	protected File transUploadFile(CommonsMultipartFile planedFile) throws Exception
	{
		String fileName = planedFile.getOriginalFilename();
		logger.debug("上傳文件：" + fileName);
		
		String extension = fileName.substring(fileName.lastIndexOf('.') + 1);
		String shortName = fileName.substring(0,fileName.lastIndexOf("."));
		String newName = shortName + "_"+ EFSUtil.getTimeStamp() + "." + extension;
		
		File f = new File(EFSUtil.getSystemConfig("sys.temp.path") + "\\" + newName);
		planedFile.transferTo(f);
		logger.debug("上傳文件己另存為:" + f.getAbsolutePath());
		
		return f;
	}
	
	/**
	 * 返回模板路径
	 * @param request
	 * @return
	 * @throws Exception
	 */
	protected String getModePath(HttpServletRequest request) throws Exception
	{
		return request.getSession().getServletContext().getRealPath("/") + File.separator + "model" + File.separator;
	}
	
	/**
	 * 设置返回时的查询参数。如果返回拿到参数，则马上会清除SESSION中缓存的参数
	 * @param paramKey
	 * @param paramBean
	 * @return
	 * @throws Exception
	 */
	protected Object getReturnBackParameter(HttpSession session,String paramKey,Object paramBean) throws Exception
	{
		String isBack = (String)session.getAttribute("isBack");
		Object returnParamBean = null;
		if("Y".equals(isBack))
		{
			returnParamBean = session.getAttribute(paramKey);
			session.removeAttribute("isBack");
		}
		else
		{
			session.setAttribute(paramKey, paramBean);
			returnParamBean = paramBean;
		}

		if(null == returnParamBean)
		{
			returnParamBean = paramBean;
		}

		return returnParamBean;
	}
	
	/**
	 * 设置返回时的查询参数。但此时查询后并不清理SESSION的返回标记，用于临时需要使用缓存的参数
	 * @param paramKey
	 * @param paramBean
	 * @return
	 * @throws Exception
	 */
	protected Object getSessionReturnBackParameter(HttpSession session,String paramKey,Object paramBean) throws Exception
	{
		String isBack = (String)session.getAttribute("isBack");
		Object returnParamBean = null;
		if("Y".equals(isBack))
		{
			returnParamBean = session.getAttribute(paramKey);
		}
		else
		{
			returnParamBean = paramBean;
		}
		
		return returnParamBean;
	}

	/**
	 * 判断用户是否为超级用户，主要用于开发用户的特殊角色、功能控制
	 * @param session
	 * @return
	 */
	protected boolean isSuperUser(HttpSession session)
	{
		TsUserInfo userBean = (TsUserInfo)session.getAttribute(SysConstant.SESSION_KEY_SYSUSER);

		if("1".equals(userBean.getUiIsSup()))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	/**
	 * 获取当前用户是否超级用户
	 * @param session
	 * @return
	 */
	protected String getSuperUser(HttpSession session)
	{
		if(isSuperUser(session))
		{
			return "Y";
		}
		else
		{
			return "N";
		}
	}

	/**
	 * 代码间跳转
	 * @param url
	 * @param model
	 * @param param
	 * @return
	 */
	protected String redirectTo(String url, RedirectAttributes model,Map<String,Object> param)
	{
		if(MapUtils.isNotEmpty(param))
		{
			for (Map.Entry<String, Object> entry : param.entrySet())
			{
				model.addFlashAttribute(entry.getKey(),entry.getValue());
			}
		}

		return "redirect:" + url;
	}

	/**
	 * 返回用户的校内还是校外，1表示校内，2表示校外
	 * @param session
	 * @return
	 */
	protected String getUserInOrOutType(HttpSession session)
	{
		TsUserInfo userBean = (TsUserInfo)session.getAttribute(SysConstant.SESSION_KEY_SYSUSER);
		String type;

		if("03".equals(userBean.getUiBusType()))
		{
			//校外人员
			type = "2";
		}
		else
		{
			type="1";
		}

		return type;
	}
}
