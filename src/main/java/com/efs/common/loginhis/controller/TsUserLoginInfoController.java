package com.efs.common.loginhis.controller;

import com.efs.common.controller.BaseController;
import com.efs.common.controller.JsonResult;
import com.efs.common.database.PageDataBunder;
import com.efs.common.interceptor.Auth;
import com.efs.common.loginhis.mapper.TsUserLoginInfo;
import com.efs.common.loginhis.service.TsUserLoginInfoService;
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
 * com.efs.bus.loginhis.mapper.TsUserLoginInfoController
 * @author xwh
 * 2017-06-23 09:34:15
 * 用户登录日志表
 *
 */
@Controller
@RequestMapping("/sysadmin/roleadmin")
public class TsUserLoginInfoController extends BaseController
{
	@Resource(name="tsUserLoginInfoService")
	private TsUserLoginInfoService tsUserLoginInfoService;
	
	/**
	 * 进入TsUserLoginInfo页面
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/gotoTsUserLoginInfoPage")
	@Auth
	public String gotoTsUserLoginInfoPage() throws Exception
	{
		return "/sysadmin/roleadmin/roleAdminPage";
	}
	
	/**
	 * 查询TsUserLoginInfoGrid列表
	 * @param
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/listTsUserLoginInfo")
	@Auth
	public PageDataBunder listTsUserLoginInfo(HttpSession session, HttpServletRequest request, TsUserLoginInfoForm tsUserLoginInfoForm) throws Exception
	{
		TsUserLoginInfo tsUserLoginInfo = new TsUserLoginInfo();
		
		BeanUtils.copyProperties(tsUserLoginInfo, tsUserLoginInfoForm);
		return tsUserLoginInfoService.listTsUserLoginInfo(tsUserLoginInfo,getPage(request));
	}
	
	/**
	 * 查询单个TsUserLoginInfo信息
	 * @param
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getTsUserLoginInfo")
	@Auth
	public TsUserLoginInfo getTsUserLoginInfo(String ulDbId) throws Exception
	{
		return tsUserLoginInfoService.getTsUserLoginInfo(ulDbId);
	}
	
	/**
	 * 新增TsUserLoginInfo信息
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/addTsUserLoginInfo")
	@Auth("role_addTsUserLoginInfo")
	public JsonResult addTsUserLoginInfo(HttpServletRequest request, HttpServletResponse resp, TsUserLoginInfoForm tsUserLoginInfoForm) throws Exception
	{
		TsUserLoginInfo tsUserLoginInfo = new TsUserLoginInfo();
		BeanUtils.copyProperties(tsUserLoginInfo, tsUserLoginInfoForm);
		tsUserLoginInfoService.addTsUserLoginInfo(tsUserLoginInfo);
		return packJsonResult4Form(true, resp);
	}
	
	/**
	 * 更新TsUserLoginInfo信息
	 * @param
	 * @return
	 */
	@RequestMapping(value="/updateTsUserLoginInfo")
	@ResponseBody
	@Auth("role_updateTsUserLoginInfo")
	public JsonResult updateTsUserLoginInfo(HttpServletRequest request, HttpServletResponse resp, TsUserLoginInfoForm tsUserLoginInfoForm) throws Exception
	{
		TsUserLoginInfo tsUserLoginInfo = new TsUserLoginInfo();
		BeanUtils.copyProperties(tsUserLoginInfo, tsUserLoginInfoForm);
		tsUserLoginInfoService.updateTsUserLoginInfo(tsUserLoginInfo);
		return packJsonResult4Form(true, resp);
	}
	
	/**
	 * 刪除TsUserLoginInfo
	 * @param
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping("/deleteTsUserLoginInfo")
	@Auth("role_deleteTsUserLoginInfo")
	public JsonResult deleteTsUserLoginInfo(String ulDbId) throws Exception
	{
		tsUserLoginInfoService.deleteTsUserLoginInfo(ulDbId);
		return packJsonResult(true);
	}
}
