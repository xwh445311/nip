package com.efs.bus.lib.booktype.controller;

import com.efs.bus.lib.booktype.mapper.LibBookTypeInfo;
import com.efs.bus.lib.booktype.service.LibBookTypeInfoService;
import com.efs.common.Util.SysUtils;
import com.efs.common.controller.BaseController;
import com.efs.common.controller.JsonResult;
import com.efs.common.database.PageDataBunder;
import com.efs.common.interceptor.Auth;
import com.xwh.util.EFSUtil;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 
 * com.efs.bus.lib.booktype.mapper.LibBookTypeInfoController
 * @author xuwh
 * 2018-03-25 23:08:05
 * 图书类别信息表
 *
 */
@Controller
@RequestMapping("/lib/bookType")
public class LibBookTypeInfoController extends BaseController
{
	@Resource(name="libBookTypeInfoService")
	private LibBookTypeInfoService libBookTypeInfoService;
	
	/**
	 * 进入LibBookTypeInfo页面
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/gotoLibBookTypeInfoPage")
	@Auth
	public String gotoLibBookTypeInfoPage(Model model) throws Exception
	{
		List<LibBookTypeInfo> rootBookType = libBookTypeInfoService.listLibBookTypeInfo(new LibBookTypeInfo());
		model.addAttribute("rootBookType",rootBookType);
		return "/libary/libBookTypePage";
	}
	
	/**
	 * 查询LibBookTypeInfoGrid列表
	 * @param paramBean
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/listLibBookTypeInfo")
	@Auth
	public List<LibBookTypeInfo> listLibBookTypeInfo(HttpSession session, HttpServletRequest request, LibBookTypeInfoForm libBookTypeInfoForm) throws Exception
	{
		LibBookTypeInfo libBookTypeInfo = new LibBookTypeInfo();
		
		BeanUtils.copyProperties(libBookTypeInfo, libBookTypeInfoForm);
		return libBookTypeInfoService.listLibBookTypeInfo(libBookTypeInfo);
	}
	
	/**
	 * 查询单个LibBookTypeInfo信息
	 * @param roleDbId
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getLibBookTypeInfo")
	@Auth
	public LibBookTypeInfo getLibBookTypeInfo(String btId) throws Exception
	{
		return libBookTypeInfoService.getLibBookTypeInfo(btId);
	}
	
	/**
	 * 新增LibBookTypeInfo信息
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/addLibBookTypeInfo")
	@Auth("role_addLibBookTypeInfo")
	public JsonResult addLibBookTypeInfo(HttpSession session, HttpServletResponse resp, LibBookTypeInfoForm libBookTypeInfoForm) throws Exception
	{
		LibBookTypeInfo libBookTypeInfo = new LibBookTypeInfo();
		BeanUtils.copyProperties(libBookTypeInfo, libBookTypeInfoForm);

		libBookTypeInfo.setBtId(libBookTypeInfoService.getNextDbId());
		SysUtils.packAddObjectProp(getSessionUserId(session),libBookTypeInfo);

		libBookTypeInfoService.addLibBookTypeInfo(libBookTypeInfo);
		return packJsonResult4Form(true, resp);
	}
	
	/**
	 * 更新LibBookTypeInfo信息
	 * @param roleDbId
	 * @return
	 */
	@RequestMapping(value="/updateLibBookTypeInfo")
	@ResponseBody
	@Auth("role_updateLibBookTypeInfo")
	public JsonResult updateLibBookTypeInfo(HttpSession session,HttpServletResponse resp,LibBookTypeInfoForm libBookTypeInfoForm) throws Exception
	{
		LibBookTypeInfo libBookTypeInfo = new LibBookTypeInfo();
		BeanUtils.copyProperties(libBookTypeInfo, libBookTypeInfoForm);
		libBookTypeInfoService.updateLibBookTypeInfo(libBookTypeInfo);
		SysUtils.packUpdObjectProp(getSessionUserId(session),libBookTypeInfo);
		return packJsonResult4Form(true, resp);
	}
	
	/**
	 * 刪除LibBookTypeInfo
	 * @param roleId
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping("/deleteLibBookTypeInfo")
	@Auth("role_deleteLibBookTypeInfo")
	public JsonResult deleteLibBookTypeInfo(String btId) throws Exception
	{
		libBookTypeInfoService.deleteLibBookTypeInfo(btId);
		return packJsonResult(true);
	}
}
