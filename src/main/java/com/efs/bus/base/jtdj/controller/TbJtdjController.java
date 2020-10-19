package com.efs.bus.base.jtdj.controller;

import com.efs.bus.base.fyxx.service.TbFyxxService;
import com.efs.bus.base.jtdj.mapper.TbJtdj;
import com.efs.bus.base.jtdj.service.TbJtdjService;
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
 * com.efs.bus.base.fyxx.mapper.TbJtdjController
 * @author xuwh
 * 2020-05-19 21:46:13
 * 阶梯单价
 *
 */
@Controller
@RequestMapping("/base/jtdj")
public class TbJtdjController extends BaseController
{
	@Resource(name="tbJtdjService")
	private TbJtdjService tbJtdjService;

	@Resource(name="tbYsxzInfoService")
	private TbYsxzInfoService tbYsxzInfoService;

	@Resource(name="tbFyxxService")
	private TbFyxxService tbFyxxService;
	
	/**
	 * 进入TbJtdj页面
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/gotoTbJtdjPage")
	@Auth
	public String gotoTbJtdjPage(Model model) throws Exception
	{

		List<SelectBean> ysxzList = tbYsxzInfoService.listAllValidYsxzSelect();
		List<SelectBean> fyxxList = tbFyxxService.listAllFyxxSelect();

		model.addAttribute("ysxzList",ysxzList);
		model.addAttribute("fyxxList",fyxxList);
		return "/base/jtdj/tbJtdjPage";
	}
	
	/**
	 * 查询TbJtdjGrid列表
	 * @param paramBean
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/listTbJtdj")
	@Auth
	public PageDataBunder listTbJtdj(HttpSession session, HttpServletRequest request, TbJtdjForm tbJtdjForm) throws Exception
	{
		TbJtdj tbJtdj = new TbJtdj();
		
		BeanUtils.copyProperties(tbJtdj, tbJtdjForm);
		return tbJtdjService.listTbJtdj(tbJtdj,getPage(request));
	}
	
	/**
	 * 查询单个TbJtdj信息
	 * @param roleDbId
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getTbJtdj")
	@Auth
	public TbJtdj getTbJtdj(String dbId) throws Exception
	{
		return tbJtdjService.getTbJtdj(dbId);
	}
	
	/**
	 * 新增TbJtdj信息
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/addTbJtdj")
	@Auth("role_addTbJtdj")
	public JsonResult addTbJtdj(HttpSession session,HttpServletResponse resp,TbJtdjForm tbJtdjForm) throws Exception
	{
		TbJtdj tbJtdj = new TbJtdj();
		BeanUtils.copyProperties(tbJtdj, tbJtdjForm);
		tbJtdj.setDbId(IDUtil.getId("ID_JTDJ_CODE"));
		//SysUtils.packAddObjectProp(getSessionUser(session),tbJtdj);
		tbJtdjService.addTbJtdj(tbJtdj);
		return packJsonResult4Form(true, resp);
	}
	
	/**
	 * 更新TbJtdj信息
	 * @param roleDbId
	 * @return
	 */
	@RequestMapping(value="/updateTbJtdj")
	@ResponseBody
	@Auth("role_updateTbJtdj")
	public JsonResult updateTbJtdj(HttpSession session,HttpServletResponse resp,TbJtdjForm tbJtdjForm) throws Exception
	{
		TbJtdj tbJtdj = new TbJtdj();
		BeanUtils.copyProperties(tbJtdj, tbJtdjForm);
		//SysUtils.packUpdObjectProp(getSessionUser(session),tbJtdj);
		tbJtdjService.updateTbJtdj(tbJtdj);
		return packJsonResult4Form(true, resp);
	}
	
	/**
	 * 刪除TbJtdj
	 * @param roleId
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping("/deleteTbJtdj")
	@Auth("role_deleteTbJtdj")
	public JsonResult deleteTbJtdj(String dbId) throws Exception
	{
		tbJtdjService.deleteTbJtdj(dbId);
		return packJsonResult(true);
	}
}
