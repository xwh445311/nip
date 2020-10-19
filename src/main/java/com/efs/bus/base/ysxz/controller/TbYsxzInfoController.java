package com.efs.bus.base.ysxz.controller;

import com.efs.bus.base.ysxz.mapper.TbYsxzInfo;
import com.efs.bus.base.ysxz.service.TbYsxzInfoService;
import com.efs.common.Util.IDUtil;
import com.efs.common.Util.SysUtils;
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
 * com.efs.bus.base.ysxz.mapper.TbYsxzInfoController
 * @author xuwh
 * 2020-05-17 20:59:30
 * 用水性质
 *
 */
@Controller
@RequestMapping("/base/ysxz")
public class TbYsxzInfoController extends BaseController
{
	@Resource(name="tbYsxzInfoService")
	private TbYsxzInfoService tbYsxzInfoService;
	
	/**
	 * 进入TbYsxzInfo页面
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/gotoTbYsxzInfoPage")
	@Auth
	public String gotoTbYsxzInfoPage() throws Exception
	{
		return "/base/ysxz/tbYsxzInfoPage";
	}
	
	/**
	 * 查询TbYsxzInfoGrid列表
	 * @param paramBean
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/listTbYsxzInfo")
	@Auth
	public PageDataBunder listTbYsxzInfo(HttpSession session,HttpServletRequest request,TbYsxzInfoForm tbYsxzInfoForm) throws Exception
	{
		TbYsxzInfo tbYsxzInfo = new TbYsxzInfo();
		
		BeanUtils.copyProperties(tbYsxzInfo, tbYsxzInfoForm);
		return tbYsxzInfoService.listTbYsxzInfo(tbYsxzInfo,getPage(request));
	}
	
	/**
	 * 查询单个TbYsxzInfo信息
	 * @param roleDbId
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getTbYsxzInfo")
	@Auth
	public TbYsxzInfo getTbYsxzInfo(String xzdm) throws Exception
	{
		return tbYsxzInfoService.getTbYsxzInfo(xzdm);
	}
	
	/**
	 * 新增TbYsxzInfo信息
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/addTbYsxzInfo")
	@Auth("role_addTbYsxzInfo")
	public JsonResult addTbYsxzInfo(HttpSession session,HttpServletResponse resp,TbYsxzInfoForm tbYsxzInfoForm) throws Exception
	{
		TbYsxzInfo tbYsxzInfo = new TbYsxzInfo();
		BeanUtils.copyProperties(tbYsxzInfo, tbYsxzInfoForm);

		tbYsxzInfo.setXzdm(IDUtil.getId("ID_XZ_CODE"));

		//SysUtils.packAddObjectProp(getSessionUser(session),tbYsxzInfo);
		tbYsxzInfoService.addTbYsxzInfo(tbYsxzInfo);
		return packJsonResult4Form(true, resp);
	}
	
	/**
	 * 更新TbYsxzInfo信息
	 * @param roleDbId
	 * @return
	 */
	@RequestMapping(value="/updateTbYsxzInfo")
	@ResponseBody
	@Auth("role_updateTbYsxzInfo")
	public JsonResult updateTbYsxzInfo(HttpSession session,HttpServletResponse resp,TbYsxzInfoForm tbYsxzInfoForm) throws Exception
	{
		TbYsxzInfo tbYsxzInfo = new TbYsxzInfo();
		BeanUtils.copyProperties(tbYsxzInfo, tbYsxzInfoForm);
		//SysUtils.packUpdObjectProp(getSessionUser(session),tbYsxzInfo);
		tbYsxzInfoService.updateTbYsxzInfo(tbYsxzInfo);
		return packJsonResult4Form(true, resp);
	}
	
	/**
	 * 刪除TbYsxzInfo
	 * @param roleId
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping("/deleteTbYsxzInfo")
	@Auth("role_deleteTbYsxzInfo")
	public JsonResult deleteTbYsxzInfo(String xzdm) throws Exception
	{
		tbYsxzInfoService.deleteTbYsxzInfo(xzdm);
		return packJsonResult(true);
	}
}
