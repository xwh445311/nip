package com.efs.bus.base.tsbz.controller;

import com.efs.bus.base.tsbz.mapper.TbTsbz;
import com.efs.bus.base.tsbz.service.TbTsbzService;
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
 * com.efs.bus.base.tsbz.mapper.TbTsbzController
 * @author xuwh
 * 2020-05-20 20:55:43
 * 特殊关系表
 *
 */
@Controller
@RequestMapping("/base/tsbz")
public class TbTsbzController extends BaseController
{
	@Resource(name="tbTsbzService")
	private TbTsbzService tbTsbzService;
	
	/**
	 * 进入TbTsbz页面
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/gotoTbTsbzPage")
	@Auth
	public String gotoTbTsbzPage() throws Exception
	{
		return "/base/tsbz/tbTsbzPage";
	}
	
	/**
	 * 查询TbTsbzGrid列表
	 * @param paramBean
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/listTbTsbz")
	@Auth
	public PageDataBunder listTbTsbz(HttpSession session,HttpServletRequest request,TbTsbzForm tbTsbzForm) throws Exception
	{
		TbTsbz tbTsbz = new TbTsbz();
		
		BeanUtils.copyProperties(tbTsbz, tbTsbzForm);
		return tbTsbzService.listTbTsbz(tbTsbz,getPage(request));
	}
	
	/**
	 * 查询单个TbTsbz信息
	 * @param roleDbId
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getTbTsbz")
	@Auth
	public TbTsbz getTbTsbz(String bm) throws Exception
	{
		return tbTsbzService.getTbTsbz(bm);
	}
	
	/**
	 * 新增TbTsbz信息
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/addTbTsbz")
	@Auth("role_addTbTsbz")
	public JsonResult addTbTsbz(HttpSession session,HttpServletResponse resp,TbTsbzForm tbTsbzForm) throws Exception
	{
		TbTsbz tbTsbz = new TbTsbz();
		BeanUtils.copyProperties(tbTsbz, tbTsbzForm);
		tbTsbz.setBm(IDUtil.getId("ID_TSGX_CODE"));
		//SysUtils.packAddObjectProp(getSessionUser(session),tbTsbz);
		tbTsbzService.addTbTsbz(tbTsbz);
		return packJsonResult4Form(true, resp);
	}
	
	/**
	 * 更新TbTsbz信息
	 * @param roleDbId
	 * @return
	 */
	@RequestMapping(value="/updateTbTsbz")
	@ResponseBody
	@Auth("role_updateTbTsbz")
	public JsonResult updateTbTsbz(HttpSession session,HttpServletResponse resp,TbTsbzForm tbTsbzForm) throws Exception
	{
		TbTsbz tbTsbz = new TbTsbz();
		BeanUtils.copyProperties(tbTsbz, tbTsbzForm);
		//SysUtils.packUpdObjectProp(getSessionUser(session),tbTsbz);
		tbTsbzService.updateTbTsbz(tbTsbz);
		return packJsonResult4Form(true, resp);
	}
	
	/**
	 * 刪除TbTsbz
	 * @param roleId
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping("/deleteTbTsbz")
	@Auth("role_deleteTbTsbz")
	public JsonResult deleteTbTsbz(String bm) throws Exception
	{
		tbTsbzService.deleteTbTsbz(bm);
		return packJsonResult(true);
	}
}
