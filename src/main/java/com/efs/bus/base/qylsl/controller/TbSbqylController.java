package com.efs.bus.base.qylsl.controller;

import com.efs.bus.base.qylsl.mapper.TbSbqyl;
import com.efs.bus.base.qylsl.service.TbSbqylService;
import com.efs.bus.base.sbkj.service.TbSbkjInfoService;
import com.efs.bus.base.ysxz.mapper.TbYsxzInfo;
import com.efs.bus.base.ysxz.service.TbYsxzInfoService;
import com.efs.common.Util.IDUtil;
import com.efs.common.Util.SysUtils;
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
 * com.efs.bus.base.qylsl.mapper.TbSbqylController
 * @author xwh
 * 2020-08-08 22:41:38
 * 启用量设立
 *
 */
@Controller
@RequestMapping("/base/qylsl")
public class TbSbqylController extends BaseController
{
	@Resource(name="tbSbqylService")
	private TbSbqylService tbSbqylService;

	@Resource(name="tbYsxzInfoService")
	private TbYsxzInfoService tbYsxzInfoService;

	@Resource(name="tbSbkjInfoService")
	private TbSbkjInfoService tbSbkjInfoService;
	
	/**
	 * 进入TbSbqyl页面
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/gotoTbSbqylPage")
	@Auth
	public String gotoTbSbqylPage(Model model) throws Exception
	{
		List<SelectBean> ysxzList = tbYsxzInfoService.listAllValidYsxzSelect();
		List<SelectBean> sbkjList = tbSbkjInfoService.listAllSbkjSelectBean();

		model.addAttribute("ysxzList",ysxzList);
		model.addAttribute("sbkjList",sbkjList);
		return "/base/qylsl/tbSbqylPage";
	}
	
	/**
	 * 查询TbSbqylGrid列表
	 * @param paramBean
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/listTbSbqyl")
	@Auth
	public PageDataBunder listTbSbqyl(HttpSession session,HttpServletRequest request,TbSbqylForm tbSbqylForm) throws Exception
	{
		TbSbqyl tbSbqyl = new TbSbqyl();
		
		BeanUtils.copyProperties(tbSbqyl, tbSbqylForm);
		return tbSbqylService.listTbSbqyl(tbSbqyl,getPage(request));
	}
	
	/**
	 * 查询单个TbSbqyl信息
	 * @param roleDbId
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getTbSbqyl")
	@Auth
	public TbSbqyl getTbSbqyl(String dbId) throws Exception
	{
		return tbSbqylService.getTbSbqyl(dbId);
	}
	
	/**
	 * 新增TbSbqyl信息
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/addTbSbqyl")
	@Auth("role_addTbSbqyl")
	public JsonResult addTbSbqyl(HttpSession session,HttpServletResponse resp,TbSbqylForm tbSbqylForm) throws Exception
	{
		TbSbqyl tbSbqyl = new TbSbqyl();
		BeanUtils.copyProperties(tbSbqyl, tbSbqylForm);
		tbSbqyl.setDbId(IDUtil.getId("ID_QYL_CODE"));
		//SysUtils.packAddObjectProp(getSessionUser(session),tbSbqyl);
		tbSbqylService.addTbSbqyl(tbSbqyl);
		return packJsonResult4Form(true, resp);
	}
	
	/**
	 * 更新TbSbqyl信息
	 * @param roleDbId
	 * @return
	 */
	@RequestMapping(value="/updateTbSbqyl")
	@ResponseBody
	@Auth("role_updateTbSbqyl")
	public JsonResult updateTbSbqyl(HttpSession session,HttpServletResponse resp,TbSbqylForm tbSbqylForm) throws Exception
	{
		TbSbqyl tbSbqyl = new TbSbqyl();
		BeanUtils.copyProperties(tbSbqyl, tbSbqylForm);
		//SysUtils.packUpdObjectProp(getSessionUser(session),tbSbqyl);
		tbSbqylService.updateTbSbqyl(tbSbqyl);
		return packJsonResult4Form(true, resp);
	}
	
	/**
	 * 刪除TbSbqyl
	 * @param roleId
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping("/deleteTbSbqyl")
	@Auth("role_deleteTbSbqyl")
	public JsonResult deleteTbSbqyl(String dbId) throws Exception
	{
		tbSbqylService.deleteTbSbqyl(dbId);
		return packJsonResult(true);
	}
}
