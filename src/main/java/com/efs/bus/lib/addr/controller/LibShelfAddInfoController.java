package com.efs.bus.lib.addr.controller;

import com.efs.bus.lib.addr.mapper.LibShelfAddInfo;
import com.efs.bus.lib.addr.service.LibShelfAddInfoService;
import com.efs.common.controller.BaseController;
import com.efs.common.controller.JsonResult;
import com.efs.common.database.PageDataBunder;
import com.efs.common.interceptor.Auth;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 
 * com.efs.bus.lib.addr.mapper.LibShelfAddInfoController
 * @author xwh
 * 2018-03-20 23:46:18
 * 书架信息表
 *
 */
@Controller
@RequestMapping("/sysadmin/roleadmin")
public class LibShelfAddInfoController extends BaseController
{
	@Resource(name="libShelfAddInfoService")
	private LibShelfAddInfoService libShelfAddInfoService;
	
	/**
	 * 进入LibShelfAddInfo页面
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/gotoLibShelfAddInfoPage")
	@Auth
	public String gotoLibShelfAddInfoPage() throws Exception
	{
		return "/sysadmin/roleadmin/roleAdminPage";
	}
	
	/**
	 * 查询LibShelfAddInfoGrid列表
	 * @param paramBean
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/listLibShelfAddInfo")
	@Auth
	public PageDataBunder listLibShelfAddInfo(HttpSession session,HttpServletRequest request,LibShelfAddInfoForm libShelfAddInfoForm) throws Exception
	{
		LibShelfAddInfo libShelfAddInfo = new LibShelfAddInfo();
		
		BeanUtils.copyProperties(libShelfAddInfo, libShelfAddInfoForm);
		return libShelfAddInfoService.listLibShelfAddInfo(libShelfAddInfo,getPage(request));
	}
	
	/**
	 * 查询单个LibShelfAddInfo信息
	 * @param roleDbId
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getLibShelfAddInfo")
	@Auth
	public LibShelfAddInfo getLibShelfAddInfo(String siCode) throws Exception
	{
		return libShelfAddInfoService.getLibShelfAddInfo(siCode);
	}
	
	/**
	 * 新增LibShelfAddInfo信息
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/addLibShelfAddInfo")
	@Auth("role_addLibShelfAddInfo")
	public JsonResult addLibShelfAddInfo(HttpServletRequest request, HttpServletResponse resp, LibShelfAddInfoForm libShelfAddInfoForm) throws Exception
	{
		LibShelfAddInfo libShelfAddInfo = new LibShelfAddInfo();
		BeanUtils.copyProperties(libShelfAddInfo, libShelfAddInfoForm);
		//libShelfAddInfoService.addLibShelfAddInfo(libShelfAddInfo);
		return packJsonResult4Form(true, resp);
	}
	
	/**
	 * 更新LibShelfAddInfo信息
	 * @param roleDbId
	 * @return
	 */
	@RequestMapping(value="/updateLibShelfAddInfo")
	@ResponseBody
	@Auth("role_updateLibShelfAddInfo")
	public JsonResult updateLibShelfAddInfo(HttpServletRequest request,HttpServletResponse resp,LibShelfAddInfoForm libShelfAddInfoForm) throws Exception
	{
		LibShelfAddInfo libShelfAddInfo = new LibShelfAddInfo();
		BeanUtils.copyProperties(libShelfAddInfo, libShelfAddInfoForm);
		libShelfAddInfoService.updateLibShelfAddInfo(libShelfAddInfo);
		return packJsonResult4Form(true, resp);
	}
	
	/**
	 * 刪除LibShelfAddInfo
	 * @param roleId
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping("/deleteLibShelfAddInfo")
	@Auth("role_deleteLibShelfAddInfo")
	public JsonResult deleteLibShelfAddInfo(String siCode) throws Exception
	{
		libShelfAddInfoService.deleteLibShelfAddInfo(siCode);
		return packJsonResult(true);
	}
}
