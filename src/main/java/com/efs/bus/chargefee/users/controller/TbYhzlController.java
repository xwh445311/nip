package com.efs.bus.chargefee.users.controller;

import com.efs.bus.chargefee.users.mapper.TbYhzl;
import com.efs.bus.chargefee.users.service.TbYhzlService;
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
 * com.efs.bus.chargefee.users.mapper.TbYhzlController
 * @author xuwh
 * 2020-08-13 23:24:08
 * 用户信息表
 *
 */
@Controller
@RequestMapping("/base/cby")
public class TbYhzlController extends BaseController
{
	@Resource(name="tbYhzlService")
	private TbYhzlService tbYhzlService;
	
	/**
	 * 进入TbYhzl页面
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/gotoTbYhzlPage")
	@Auth
	public String gotoTbYhzlPage() throws Exception
	{
		return "/sysadmin/roleadmin/roleAdminPage";
	}
	
	/**
	 * 查询TbYhzlGrid列表
	 * @param paramBean
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/listTbYhzl")
	@Auth
	public PageDataBunder listTbYhzl(HttpSession session,HttpServletRequest request,TbYhzlForm tbYhzlForm) throws Exception
	{
		TbYhzl tbYhzl = new TbYhzl();
		
		BeanUtils.copyProperties(tbYhzl, tbYhzlForm);
		return tbYhzlService.listTbYhzl(tbYhzl,getPage(request));
	}
	
	/**
	 * 查询单个TbYhzl信息
	 * @param roleDbId
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getTbYhzl")
	@Auth
	public TbYhzl getTbYhzl(String yhbh) throws Exception
	{
		return tbYhzlService.getTbYhzl(yhbh);
	}
	
	/**
	 * 新增TbYhzl信息
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/addTbYhzl")
	@Auth("role_addTbYhzl")
	public JsonResult addTbYhzl(HttpSession session,HttpServletResponse resp,TbYhzlForm tbYhzlForm) throws Exception
	{
		TbYhzl tbYhzl = new TbYhzl();
		BeanUtils.copyProperties(tbYhzl, tbYhzlForm);
		SysUtils.packAddObjectProp(getSessionUser(session),tbYhzl);
		tbYhzlService.addTbYhzl(tbYhzl);
		return packJsonResult4Form(true, resp);
	}
	
	/**
	 * 更新TbYhzl信息
	 * @param roleDbId
	 * @return
	 */
	@RequestMapping(value="/updateTbYhzl")
	@ResponseBody
	@Auth("role_updateTbYhzl")
	public JsonResult updateTbYhzl(HttpSession session,HttpServletResponse resp,TbYhzlForm tbYhzlForm) throws Exception
	{
		TbYhzl tbYhzl = new TbYhzl();
		BeanUtils.copyProperties(tbYhzl, tbYhzlForm);
		SysUtils.packUpdObjectProp(getSessionUser(session),tbYhzl);
		tbYhzlService.updateTbYhzl(tbYhzl);
		return packJsonResult4Form(true, resp);
	}
	
	/**
	 * 刪除TbYhzl
	 * @param roleId
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping("/deleteTbYhzl")
	@Auth("role_deleteTbYhzl")
	public JsonResult deleteTbYhzl(String yhbh) throws Exception
	{
		tbYhzlService.deleteTbYhzl(yhbh);
		return packJsonResult(true);
	}
}
