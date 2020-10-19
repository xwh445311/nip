package com.efs.bus.base.fyxx.controller;

import com.efs.bus.base.fyxx.mapper.TbFyxx;
import com.efs.bus.base.fyxx.service.TbFyxxService;
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
 * com.efs.bus.base.fyxx.mapper.TbFyxxController
 * @author xuwh
 * 2020-05-19 20:11:32
 * 费用参数信息表
 *
 */
@Controller
@RequestMapping("/base/fyxx")
public class TbFyxxController extends BaseController
{
	@Resource(name="tbFyxxService")
	private TbFyxxService tbFyxxService;
	
	/**
	 * 进入TbFyxx页面
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/gotoTbFyxxPage")
	@Auth
	public String gotoTbFyxxPage() throws Exception
	{
		return "/sysadmin/roleadmin/roleAdminPage";
	}
	
	/**
	 * 查询TbFyxxGrid列表
	 * @param paramBean
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/listTbFyxx")
	@Auth
	public PageDataBunder listTbFyxx(HttpSession session,HttpServletRequest request,TbFyxxForm tbFyxxForm) throws Exception
	{
		TbFyxx tbFyxx = new TbFyxx();
		
		BeanUtils.copyProperties(tbFyxx, tbFyxxForm);
		return tbFyxxService.listTbFyxx(tbFyxx,getPage(request));
	}
	
	/**
	 * 查询单个TbFyxx信息
	 * @param roleDbId
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getTbFyxx")
	@Auth
	public TbFyxx getTbFyxx(String fydm) throws Exception
	{
		return tbFyxxService.getTbFyxx(fydm);
	}
	
	/**
	 * 新增TbFyxx信息
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/addTbFyxx")
	@Auth("role_addTbFyxx")
	public JsonResult addTbFyxx(HttpSession session,HttpServletResponse resp,TbFyxxForm tbFyxxForm) throws Exception
	{
		TbFyxx tbFyxx = new TbFyxx();
		BeanUtils.copyProperties(tbFyxx, tbFyxxForm);
		SysUtils.packAddObjectProp(getSessionUser(session),tbFyxx);
		tbFyxxService.addTbFyxx(tbFyxx);
		return packJsonResult4Form(true, resp);
	}
	
	/**
	 * 更新TbFyxx信息
	 * @param roleDbId
	 * @return
	 */
	@RequestMapping(value="/updateTbFyxx")
	@ResponseBody
	@Auth("role_updateTbFyxx")
	public JsonResult updateTbFyxx(HttpSession session,HttpServletResponse resp,TbFyxxForm tbFyxxForm) throws Exception
	{
		TbFyxx tbFyxx = new TbFyxx();
		BeanUtils.copyProperties(tbFyxx, tbFyxxForm);
		SysUtils.packUpdObjectProp(getSessionUser(session),tbFyxx);
		tbFyxxService.updateTbFyxx(tbFyxx);
		return packJsonResult4Form(true, resp);
	}
	
	/**
	 * 刪除TbFyxx
	 * @param roleId
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping("/deleteTbFyxx")
	@Auth("role_deleteTbFyxx")
	public JsonResult deleteTbFyxx(String fydm) throws Exception
	{
		tbFyxxService.deleteTbFyxx(fydm);
		return packJsonResult(true);
	}
}
