package com.efs.bus.base.fqxx.controller;

import com.efs.bus.base.fqxx.mapper.TbFqxxInfo;
import com.efs.bus.base.fqxx.service.TbFqxxInfoService;
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
 * com.efs.bus.base.fqxx.mapper.TbFqxxInfoController
 * @author xuwh
 * 2020-05-10 22:17:08
 * 分区信息表
 *
 */
@Controller
@RequestMapping("/base/fqxx")
public class TbFqxxInfoController extends BaseController
{
	@Resource(name="tbFqxxInfoService")
	private TbFqxxInfoService tbFqxxInfoService;

	@Resource(name="tsOrgInfoService")
	private TsOrgInfoService tsOrgInfoService;
	
	/**
	 * 进入TbFqxxInfo页面
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/gotoTbFqxxInfoPage")
	@Auth
	public String gotoTbFqxxInfoPage(Model model) throws Exception
	{

		List<SelectBean> branchOrgSelList = tsOrgInfoService.listBranchOrgSelect();
		model.addAttribute("branchOrgSelList",branchOrgSelList);
		return "/base/fqxx/tbFqxxInfoPage";
	}
	
	/**
	 * 查询TbFqxxInfoGrid列表
	 * @param paramBean
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/listTbFqxxInfo")
	@Auth
	public PageDataBunder listTbFqxxInfo(HttpSession session,HttpServletRequest request,TbFqxxInfoForm tbFqxxInfoForm) throws Exception
	{
		TbFqxxInfo tbFqxxInfo = new TbFqxxInfo();
		
		BeanUtils.copyProperties(tbFqxxInfo, tbFqxxInfoForm);
		return tbFqxxInfoService.listTbFqxxInfo(tbFqxxInfo,getPage(request));
	}
	
	/**
	 * 查询单个TbFqxxInfo信息
	 * @param roleDbId
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getTbFqxxInfo")
	@Auth
	public TbFqxxInfo getTbFqxxInfo(String qyId) throws Exception
	{
		return tbFqxxInfoService.getTbFqxxInfo(qyId);
	}
	
	/**
	 * 新增TbFqxxInfo信息
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/addTbFqxxInfo")
	@Auth("role_addTbFqxxInfo")
	public JsonResult addTbFqxxInfo(HttpSession session,HttpServletResponse resp,TbFqxxInfoForm tbFqxxInfoForm) throws Exception
	{
		TbFqxxInfo tbFqxxInfo = new TbFqxxInfo();
		BeanUtils.copyProperties(tbFqxxInfo, tbFqxxInfoForm);
		//SysUtils.packAddObjectProp(getSessionUser(session),tbFqxxInfo);

		tbFqxxInfo.setQyId(IDUtil.getId("ID_FQ_CODE"));

		tbFqxxInfoService.addTbFqxxInfo(tbFqxxInfo);
		return packJsonResult4Form(true, resp);
	}
	
	/**
	 * 更新TbFqxxInfo信息
	 * @param roleDbId
	 * @return
	 */
	@RequestMapping(value="/updateTbFqxxInfo")
	@ResponseBody
	@Auth("role_updateTbFqxxInfo")
	public JsonResult updateTbFqxxInfo(HttpSession session,HttpServletResponse resp,TbFqxxInfoForm tbFqxxInfoForm) throws Exception
	{
		TbFqxxInfo tbFqxxInfo = new TbFqxxInfo();
		BeanUtils.copyProperties(tbFqxxInfo, tbFqxxInfoForm);
		//SysUtils.packUpdObjectProp(getSessionUser(session),tbFqxxInfo);
		tbFqxxInfoService.updateTbFqxxInfo(tbFqxxInfo);
		return packJsonResult4Form(true, resp);
	}
	
	/**
	 * 刪除TbFqxxInfo
	 * @param roleId
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping("/deleteTbFqxxInfo")
	@Auth("role_deleteTbFqxxInfo")
	public JsonResult deleteTbFqxxInfo(String qyId) throws Exception
	{
		tbFqxxInfoService.deleteTbFqxxInfo(qyId);
		return packJsonResult(true);
	}
}
