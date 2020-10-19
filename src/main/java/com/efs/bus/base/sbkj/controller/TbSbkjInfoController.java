package com.efs.bus.base.sbkj.controller;

import com.efs.bus.base.sbkj.mapper.TbSbkjInfo;
import com.efs.bus.base.sbkj.service.TbSbkjInfoService;
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
 * com.efs.bus.base.sbkj.mapper.TbSbkjInfoController
 * @author xwh
 * 2020-05-17 11:59:17
 * 水表口径信息
 *
 */
@Controller
@RequestMapping("/base/sbkj")
public class TbSbkjInfoController extends BaseController
{
	@Resource(name="tbSbkjInfoService")
	private TbSbkjInfoService tbSbkjInfoService;
	
	/**
	 * 进入TbSbkjInfo页面
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/gotoTbSbkjInfoPage")
	@Auth
	public String gotoTbSbkjInfoPage() throws Exception
	{
		return "/base/sbkj/tbSbkjInfoPage";
	}
	
	/**
	 * 查询TbSbkjInfoGrid列表
	 * @param paramBean
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/listTbSbkjInfo")
	@Auth
	public PageDataBunder listTbSbkjInfo(HttpSession session,HttpServletRequest request,TbSbkjInfoForm tbSbkjInfoForm) throws Exception
	{
		TbSbkjInfo tbSbkjInfo = new TbSbkjInfo();
		
		BeanUtils.copyProperties(tbSbkjInfo, tbSbkjInfoForm);
		return tbSbkjInfoService.listTbSbkjInfo(tbSbkjInfo,getPage(request));
	}
	
	/**
	 * 查询单个TbSbkjInfo信息
	 * @param roleDbId
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getTbSbkjInfo")
	@Auth
	public TbSbkjInfo getTbSbkjInfo(String sbkj) throws Exception
	{
		return tbSbkjInfoService.getTbSbkjInfo(sbkj);
	}
	
	/**
	 * 新增TbSbkjInfo信息
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/addTbSbkjInfo")
	@Auth("role_addTbSbkjInfo")
	public JsonResult addTbSbkjInfo(HttpSession session,HttpServletResponse resp,TbSbkjInfoForm tbSbkjInfoForm) throws Exception
	{
		TbSbkjInfo tbSbkjInfo = new TbSbkjInfo();
		BeanUtils.copyProperties(tbSbkjInfo, tbSbkjInfoForm);
		//SysUtils.packAddObjectProp(getSessionUser(session),tbSbkjInfo);
		tbSbkjInfoService.addTbSbkjInfo(tbSbkjInfo);
		return packJsonResult4Form(true, resp);
	}
	
	/**
	 * 更新TbSbkjInfo信息
	 * @param roleDbId
	 * @return
	 */
	@RequestMapping(value="/updateTbSbkjInfo")
	@ResponseBody
	@Auth("role_updateTbSbkjInfo")
	public JsonResult updateTbSbkjInfo(HttpSession session,HttpServletResponse resp,TbSbkjInfoForm tbSbkjInfoForm) throws Exception
	{
		TbSbkjInfo tbSbkjInfo = new TbSbkjInfo();
		BeanUtils.copyProperties(tbSbkjInfo, tbSbkjInfoForm);
		//SysUtils.packUpdObjectProp(getSessionUser(session),tbSbkjInfo);
		tbSbkjInfoService.updateTbSbkjInfo(tbSbkjInfo);
		return packJsonResult4Form(true, resp);
	}
	
	/**
	 * 刪除TbSbkjInfo
	 * @param roleId
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping("/deleteTbSbkjInfo")
	@Auth("role_deleteTbSbkjInfo")
	public JsonResult deleteTbSbkjInfo(String sbkj) throws Exception
	{
		tbSbkjInfoService.deleteTbSbkjInfo(sbkj);
		return packJsonResult(true);
	}
}
