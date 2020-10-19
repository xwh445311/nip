package com.efs.bus.fee.sbzl.controller;

import com.efs.bus.fee.sbzl.mapper.TcSbzl;
import com.efs.bus.fee.sbzl.service.TcSbzlService;
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
 * com.efs.bus.fee.sbzl.mapper.TcSbzlController
 * @author xwh
 * 2020-10-18 16:16:33
 * 用户水表资料
 *
 */
@Controller
@RequestMapping("/fee/sbzl")
public class TcSbzlController extends BaseController
{
	@Resource(name="tcSbzlService")
	private TcSbzlService tcSbzlService;
	
	/**
	 * 进入TcSbzl页面
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/gotoTcSbzlPage")
	@Auth
	public String gotoTcSbzlPage() throws Exception
	{
		return "/sysadmin/roleadmin/roleAdminPage";
	}
	
	/**
	 * 查询TcSbzlGrid列表
	 * @param paramBean
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/listTcSbzl")
	@Auth
	public PageDataBunder listTcSbzl(HttpSession session,HttpServletRequest request,TcSbzlForm tcSbzlForm) throws Exception
	{
		TcSbzl tcSbzl = new TcSbzl();
		
		BeanUtils.copyProperties(tcSbzl, tcSbzlForm);
		return tcSbzlService.listTcSbzl(tcSbzl,getPage(request));
	}
	
	/**
	 * 查询单个TcSbzl信息
	 * @param roleDbId
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getTcSbzl")
	@Auth
	public TcSbzl getTcSbzl(String sbxh) throws Exception
	{
		return tcSbzlService.getTcSbzl(sbxh);
	}
	
	/**
	 * 新增TcSbzl信息
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/addTcSbzl")
	@Auth("role_addTcSbzl")
	public JsonResult addTcSbzl(HttpSession session,HttpServletResponse resp,TcSbzlForm tcSbzlForm) throws Exception
	{
		TcSbzl tcSbzl = new TcSbzl();
		BeanUtils.copyProperties(tcSbzl, tcSbzlForm);
		SysUtils.packAddObjectProp(getSessionUser(session),tcSbzl);
		tcSbzlService.addTcSbzl(tcSbzl);
		return packJsonResult4Form(true, resp);
	}
	
	/**
	 * 更新TcSbzl信息
	 * @param roleDbId
	 * @return
	 */
	@RequestMapping(value="/updateTcSbzl")
	@ResponseBody
	@Auth("role_updateTcSbzl")
	public JsonResult updateTcSbzl(HttpSession session,HttpServletResponse resp,TcSbzlForm tcSbzlForm) throws Exception
	{
		TcSbzl tcSbzl = new TcSbzl();
		BeanUtils.copyProperties(tcSbzl, tcSbzlForm);
		SysUtils.packUpdObjectProp(getSessionUser(session),tcSbzl);
		tcSbzlService.updateTcSbzl(tcSbzl);
		return packJsonResult4Form(true, resp);
	}
	
	/**
	 * 刪除TcSbzl
	 * @param roleId
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping("/deleteTcSbzl")
	@Auth("role_deleteTcSbzl")
	public JsonResult deleteTcSbzl(String sbxh) throws Exception
	{
		tcSbzlService.deleteTcSbzl(sbxh);
		return packJsonResult(true);
	}
}
