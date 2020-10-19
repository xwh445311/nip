package com.efs.common.auth.org.controller;

import com.efs.common.Util.IDUtil;
import com.efs.common.Util.SysUtils;
import com.efs.common.auth.org.mapper.TsOrgInfo;
import com.efs.common.auth.org.service.TsOrgInfoService;
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
import java.util.List;

/**
 * 
 * com.efs.common.auth.org.mapper.TsOrgInfoController
 * @author xwh
 * 2018-03-15 09:54:12
 * 组织机构信息表
 *
 */
@Controller
@RequestMapping("/sysadmin/orgAdmin")
public class TsOrgInfoController extends BaseController
{
	@Resource(name="tsOrgInfoService")
	private TsOrgInfoService tsOrgInfoService;
	
	/**
	 * 进入TsOrgInfo页面
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/gotoTsOrgInfoPage")
	@Auth
	public String gotoTsOrgInfoPage() throws Exception
	{
		return "/admin/sysadmin/org/orgAdminPage";
	}
	
	/**
	 * 查询TsOrgInfoGrid列表
	 * @param paramBean
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/listTsOrgInfo")
	@Auth
	public PageDataBunder listTsOrgInfo(HttpSession session,HttpServletRequest request,TsOrgInfoForm tsOrgInfoForm) throws Exception
	{
		TsOrgInfo tsOrgInfo = new TsOrgInfo();
		
		BeanUtils.copyProperties(tsOrgInfo, tsOrgInfoForm);
		return tsOrgInfoService.listTsOrgInfo(tsOrgInfo,getPage(request));
	}
	
	/**
	 * 查询单个TsOrgInfo信息
	 * @param roleDbId
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getTsOrgInfo")
	@Auth
	public TsOrgInfo getTsOrgInfo(String oiCode) throws Exception
	{
		return tsOrgInfoService.getTsOrgInfo(oiCode);
	}
	
	/**
	 * 新增TsOrgInfo信息
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/addTsOrgInfo")
	@Auth("role_addTsOrgInfo")
	public JsonResult addTsOrgInfo(HttpSession session, HttpServletResponse resp, TsOrgInfoForm tsOrgInfoForm) throws Exception
	{
		TsOrgInfo tsOrgInfo = new TsOrgInfo();
		BeanUtils.copyProperties(tsOrgInfo, tsOrgInfoForm);
		tsOrgInfo.setOiCode(IDUtil.getId("ID_ORG_CODE"));
		SysUtils.packAddObjectProp(getSessionUserId(session),tsOrgInfo);
		tsOrgInfoService.addTsOrgInfo(tsOrgInfo);
		return packJsonResult4Form(true, resp);
	}
	
	/**
	 * 更新TsOrgInfo信息
	 * @param roleDbId
	 * @return
	 */
	@RequestMapping(value="/updateTsOrgInfo")
	@ResponseBody
	@Auth("role_updateTsOrgInfo")
	public JsonResult updateTsOrgInfo(HttpSession session,HttpServletResponse resp,TsOrgInfoForm tsOrgInfoForm) throws Exception
	{
		TsOrgInfo tsOrgInfo = new TsOrgInfo();
		BeanUtils.copyProperties(tsOrgInfo, tsOrgInfoForm);
		SysUtils.packUpdObjectProp(getSessionUserId(session),tsOrgInfo);
		tsOrgInfoService.updateTsOrgInfo(tsOrgInfo);
		return packJsonResult4Form(true, resp);
	}
	
	/**
	 * 刪除TsOrgInfo
	 * @param roleId
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping("/deleteTsOrgInfo")
	@Auth("role_deleteTsOrgInfo")
	public JsonResult deleteTsOrgInfo(String oiCode) throws Exception
	{
		tsOrgInfoService.deleteTsOrgInfo(oiCode);
		return packJsonResult(true);
	}

	/**
	 * 检查机构号是否已经被使用
	 * @param oiCode
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping("/checkOrgHasUsed")
	@Auth
	public JsonResult checkOrgHasUsed(String oiCode) throws Exception
	{
		boolean res = tsOrgInfoService.checkOrgHasUsed(oiCode);

		String flag = res ? "1" : "0";

		return packJsonResult(true,flag);
	}

	/**
	 * 返回JSON格式的可用的ORG 列表
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping("/listAllEnableOrgs")
	@Auth
	public List<TsOrgInfo> listAllEnableOrgs() throws Exception
	{
		return tsOrgInfoService.listActiveOrgInfo();
	}
}
