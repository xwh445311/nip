package com.efs.bus.base.cby.controller;

import com.efs.bus.base.cby.mapper.TbCbyInfo;
import com.efs.bus.base.cby.service.TbCbyInfoService;
import com.efs.common.Util.IDUtil;
import com.efs.common.Util.SysUtils;
import com.efs.common.auth.org.service.TsOrgInfoService;
import com.efs.common.controller.BaseController;
import com.efs.common.controller.JsonResult;
import com.efs.common.database.PageDataBunder;
import com.efs.common.interceptor.Auth;
import com.xwh.bean.SelectBean;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * 
 * com.efs.bus.base.cby.mapper.TbCbyInfoController
 * @author xuwh
 * 2020-05-24 21:47:25
 * 抄表员信息
 *
 */
@Controller
@RequestMapping("/base/cby")
public class TbCbyInfoController extends BaseController
{
	@Resource(name="tbCbyInfoService")
	private TbCbyInfoService tbCbyInfoService;

	@Resource(name="tsOrgInfoService")
	private TsOrgInfoService tsOrgInfoService;
	
	/**
	 * 进入TbCbyInfo页面
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/gotoTbCbyInfoPage")
	@Auth
	public String gotoTbCbyInfoPage(Model model) throws Exception
	{
		List<SelectBean> branchOrgSelect = tsOrgInfoService.listBranchOrgSelect();
		model.addAttribute("branchOrgSelect",branchOrgSelect);
		return "/base/cby/tbCbyInfoPage";
	}
	
	/**
	 * 查询TbCbyInfoGrid列表
	 * @param paramBean
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/listTbCbyInfo")
	@Auth
	public PageDataBunder listTbCbyInfo(HttpSession session,HttpServletRequest request,TbCbyInfoForm tbCbyInfoForm) throws Exception
	{
		TbCbyInfo tbCbyInfo = new TbCbyInfo();
		
		BeanUtils.copyProperties(tbCbyInfo, tbCbyInfoForm);
		return tbCbyInfoService.listTbCbyInfo(tbCbyInfo,getPage(request));
	}
	
	/**
	 * 查询单个TbCbyInfo信息
	 * @param roleDbId
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getTbCbyInfo")
	@Auth
	public TbCbyInfo getTbCbyInfo(String dbId) throws Exception
	{
		return tbCbyInfoService.getTbCbyInfo(dbId);
	}
	
	/**
	 * 新增TbCbyInfo信息
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/addTbCbyInfo")
	@Auth("role_addTbCbyInfo")
	public JsonResult addTbCbyInfo(HttpSession session,HttpServletResponse resp,TbCbyInfoForm tbCbyInfoForm) throws Exception
	{
		TbCbyInfo tbCbyInfo = new TbCbyInfo();
		BeanUtils.copyProperties(tbCbyInfo, tbCbyInfoForm);
		//SysUtils.packAddObjectProp(getSessionUser(session),tbCbyInfo);
		tbCbyInfo.setDbId(IDUtil.getId("ID_CBY_CODE"));
		tbCbyInfo.setStatus("1");
		tbCbyInfoService.addTbCbyInfo(tbCbyInfo);
		return packJsonResult4Form(true, resp);
	}
	
	/**
	 * 更新TbCbyInfo信息
	 * @param roleDbId
	 * @return
	 */
	@RequestMapping(value="/updateTbCbyInfo")
	@ResponseBody
	@Auth("role_updateTbCbyInfo")
	public JsonResult updateTbCbyInfo(HttpSession session,HttpServletResponse resp,TbCbyInfoForm tbCbyInfoForm) throws Exception
	{
		TbCbyInfo tbCbyInfo = new TbCbyInfo();
		BeanUtils.copyProperties(tbCbyInfo, tbCbyInfoForm);
		//SysUtils.packUpdObjectProp(getSessionUser(session),tbCbyInfo);
		tbCbyInfo.setStatus("1");
		tbCbyInfoService.updateTbCbyInfo(tbCbyInfo);
		return packJsonResult4Form(true, resp);
	}
	
	/**
	 * 刪除TbCbyInfo
	 * @param roleId
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping("/deleteTbCbyInfo")
	@Auth("role_deleteTbCbyInfo")
	public JsonResult deleteTbCbyInfo(String dbId) throws Exception
	{
		tbCbyInfoService.deleteTbCbyInfo(dbId);
		return packJsonResult(true);
	}
}
