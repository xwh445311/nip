package com.efs.bus.fee.yhzl.controller;

import com.efs.bus.fee.yhzl.mapper.TcYhzl;
import com.efs.bus.fee.yhzl.service.TcYhzlService;
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
 * com.efs.bus.fee.yhzl.mapper.TcYhzlController
 * @author xwh
 * 2020-10-18 16:11:27
 * 用户信息表
 *
 */
@Controller
@RequestMapping("/fee/yhzl")
public class TcYhzlController extends BaseController
{
	@Resource(name="tcYhzlService")
	private TcYhzlService tcYhzlService;
	
	/**
	 * 进入TcYhzl页面
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/gotoTcYhzlPage")
	@Auth
	public String gotoTcYhzlPage() throws Exception
	{
		return "/sysadmin/roleadmin/roleAdminPage";
	}
	
	/**
	 * 查询TcYhzlGrid列表
	 * @param paramBean
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/listTcYhzl")
	@Auth
	public PageDataBunder listTcYhzl(HttpSession session,HttpServletRequest request,TcYhzlForm tcYhzlForm) throws Exception
	{
		TcYhzl tcYhzl = new TcYhzl();
		
		BeanUtils.copyProperties(tcYhzl, tcYhzlForm);
		return tcYhzlService.listTcYhzl(tcYhzl,getPage(request));
	}
	
	/**
	 * 查询单个TcYhzl信息
	 * @param roleDbId
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getTcYhzl")
	@Auth
	public TcYhzl getTcYhzl(String yhbh) throws Exception
	{
		return tcYhzlService.getTcYhzl(yhbh);
	}
	
	/**
	 * 新增TcYhzl信息
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/addTcYhzl")
	@Auth("role_addTcYhzl")
	public JsonResult addTcYhzl(HttpSession session,HttpServletResponse resp,TcYhzlForm tcYhzlForm) throws Exception
	{
		TcYhzl tcYhzl = new TcYhzl();
		BeanUtils.copyProperties(tcYhzl, tcYhzlForm);
		SysUtils.packAddObjectProp(getSessionUser(session),tcYhzl);
		tcYhzlService.addTcYhzl(tcYhzl);
		return packJsonResult4Form(true, resp);
	}
	
	/**
	 * 更新TcYhzl信息
	 * @param roleDbId
	 * @return
	 */
	@RequestMapping(value="/updateTcYhzl")
	@ResponseBody
	@Auth("role_updateTcYhzl")
	public JsonResult updateTcYhzl(HttpSession session,HttpServletResponse resp,TcYhzlForm tcYhzlForm) throws Exception
	{
		TcYhzl tcYhzl = new TcYhzl();
		BeanUtils.copyProperties(tcYhzl, tcYhzlForm);
		SysUtils.packUpdObjectProp(getSessionUser(session),tcYhzl);
		tcYhzlService.updateTcYhzl(tcYhzl);
		return packJsonResult4Form(true, resp);
	}
	
	/**
	 * 刪除TcYhzl
	 * @param roleId
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping("/deleteTcYhzl")
	@Auth("role_deleteTcYhzl")
	public JsonResult deleteTcYhzl(String yhbh) throws Exception
	{
		tcYhzlService.deleteTcYhzl(yhbh);
		return packJsonResult(true);
	}
}
