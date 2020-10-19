package com.efs.bus.edu.baseset.controller;

import com.efs.bus.edu.baseset.mapper.BaseSetInfo;
import com.efs.bus.edu.baseset.service.BaseSetInfoService;
import com.efs.common.Util.SysUtils;
import com.efs.common.controller.BaseController;
import com.efs.common.controller.JsonResult;
import com.efs.common.database.PageDataBunder;
import com.efs.common.interceptor.Auth;
import com.xwh.util.EFSUtil;
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
 * com.efs.bus.edu.baseset.mapper.BaseSetInfoController
 * @author xwh
 * 2018-05-29 13:55:38
 * 基础信息设置记录表
 *
 */
@Controller
@RequestMapping("/edu/baseset")
public class BaseSetInfoController extends BaseController
{
	@Resource(name="baseSetInfoService")
	private BaseSetInfoService baseSetInfoService;
	
	/**
	 * 进入BaseSetInfo页面
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/gotoBaseSetInfoPage")
	@Auth
	public String gotoBaseSetInfoPage() throws Exception
	{
		return "/edu/baseSetInfoPage";
	}
	
	/**
	 * 查询BaseSetInfoGrid列表
	 * @param paramBean
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/listBaseSetInfo")
	@Auth
	public PageDataBunder listBaseSetInfo(HttpSession session,HttpServletRequest request,BaseSetInfoForm baseSetInfoForm) throws Exception
	{
		BaseSetInfo baseSetInfo = new BaseSetInfo();
		
		BeanUtils.copyProperties(baseSetInfo, baseSetInfoForm);
		return baseSetInfoService.listBaseSetInfo(baseSetInfo,getPage(request));
	}
	
	/**
	 * 查询单个BaseSetInfo信息
	 * @param roleDbId
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getBaseSetInfo")
	@Auth
	public BaseSetInfo getBaseSetInfo(String bsTerm) throws Exception
	{
		return baseSetInfoService.getBaseSetInfo(bsTerm);
	}
	
	/**
	 * 新增BaseSetInfo信息
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/addBaseSetInfo")
	@Auth("role_addBaseSetInfo")
	public JsonResult addBaseSetInfo(HttpSession session,HttpServletResponse resp,BaseSetInfoForm baseSetInfoForm) throws Exception
	{
		BaseSetInfo baseSetInfo = new BaseSetInfo();
		BeanUtils.copyProperties(baseSetInfo, baseSetInfoForm);
		baseSetInfo.setBsUser(getSessionUserId(session));
		baseSetInfo.setBsDate(EFSUtil.getSysFormatDate());
		baseSetInfo.setBsTime(EFSUtil.getSysFormatTime());
		baseSetInfoService.addBaseSetInfo(baseSetInfo);
		return packJsonResult4Form(true, resp);
	}
	
	/**
	 * 更新BaseSetInfo信息
	 * @param roleDbId
	 * @return
	 */
	@RequestMapping(value="/updateBaseSetInfo")
	@ResponseBody
	@Auth("role_updateBaseSetInfo")
	public JsonResult updateBaseSetInfo(HttpSession session,HttpServletResponse resp,BaseSetInfoForm baseSetInfoForm) throws Exception
	{
		BaseSetInfo baseSetInfo = new BaseSetInfo();
		BeanUtils.copyProperties(baseSetInfo, baseSetInfoForm);
		SysUtils.packUpdObjectProp(getSessionUser(session),baseSetInfo);
		baseSetInfoService.updateBaseSetInfo(baseSetInfo);
		return packJsonResult4Form(true, resp);
	}
	
	/**
	 * 刪除BaseSetInfo
	 * @param roleId
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping("/deleteBaseSetInfo")
	@Auth("role_deleteBaseSetInfo")
	public JsonResult deleteBaseSetInfo(String bsTerm) throws Exception
	{
		baseSetInfoService.deleteBaseSetInfo(bsTerm);
		return packJsonResult(true);
	}

	/**
	 * 检查该学期的基础信息还未设置过
	 * @param bsTerm
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping("/checkNoBaseSet")
	@Auth
	public String checkNoBaseSet(String bsTerm) throws Exception
	{
		boolean res = baseSetInfoService.checkHasBaseSet(bsTerm);

		if(res)
		{
			return "false";
		}
		else
		{
			return "true";
		}
	}
}
