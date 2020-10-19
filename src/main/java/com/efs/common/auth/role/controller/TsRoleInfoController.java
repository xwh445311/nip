package com.efs.common.auth.role.controller;


import com.efs.common.auth.role.mapper.TsRoleInfo;
import com.efs.common.auth.role.service.TsRoleInfoService;
import com.efs.common.auth.user.mapper.TsUserInfo;
import com.efs.common.controller.BaseController;
import com.efs.common.controller.JsonResult;
import com.efs.common.database.PageDataBunder;
import com.efs.common.interceptor.Auth;
import com.xwh.util.EFSUtil;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * com.efs.common.auth.role.mapper.TsRoleInfoController
 * @author xwh
 * 2017-06-21 23:24:56
 * 系统角色表
 *
 */
@Controller
@RequestMapping("/sysAdmin/role")
public class TsRoleInfoController extends BaseController
{
	@Resource(name="tsRoleInfoService")
	private TsRoleInfoService tsRoleInfoService;
	
	/**
	 * 进入TsRoleInfo页面
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/gotoTsRoleInfoPage")
	@Auth
	public String gotoTsRoleInfoPage() throws Exception
	{
		return "/admin/sysadmin/role/roleAdminPage";
	}

	/**
	 * 进入TsRoleInfo页面
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/gotoTestPage2")
	@Auth
	public String gotoTestPage2() throws Exception
	{
		return "/admin/sysadmin/role/test2";
	}
	
	/**
	 * 查询TsRoleInfoGrid列表
	 * @param paramBean
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/listTsRoleInfo")
	@Auth
	public PageDataBunder listTsRoleInfo(HttpSession session,HttpServletRequest request,TsRoleInfoForm tsRoleInfoForm) throws Exception
	{
		TsRoleInfo tsRoleInfo = new TsRoleInfo();
		
		BeanUtils.copyProperties(tsRoleInfo, tsRoleInfoForm);
		tsRoleInfo.setIsSuperUser(getSuperUser(session));

		return tsRoleInfoService.listTsRoleInfo(tsRoleInfo,getPage(request));
	}
	
	/**
	 * 查询单个TsRoleInfo信息
	 * @param roleDbId
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getTsRoleInfo")
	@Auth
	public TsRoleInfo getTsRoleInfo(String riId) throws Exception
	{
		return tsRoleInfoService.getTsRoleInfo(riId);
	}
	
	/**
	 * 新增TsRoleInfo信息
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/addTsRoleInfo")
	@Auth("role_addTsRoleInfo")
	public JsonResult addTsRoleInfo(HttpSession session, HttpServletRequest request, HttpServletResponse resp, TsRoleInfoForm tsRoleInfoForm) throws Exception
	{
		TsRoleInfo tsRoleInfo = new TsRoleInfo();
		TsUserInfo loginUser = getSessionUser(session);
		List<String> funcList = null;

		BeanUtils.copyProperties(tsRoleInfo, tsRoleInfoForm);

		if(tsRoleInfoForm.getRoleFunc() != null && tsRoleInfoForm.getRoleFunc().length>0)
		{
			funcList = new ArrayList<>();
			for (String func : tsRoleInfoForm.getRoleFunc())
			{
				funcList.add(func);
			}

			tsRoleInfo.setFuncList(funcList);
		}

		tsRoleInfo.setRiAddUser(loginUser.getUiId());
		tsRoleInfo.setRiAddDate(EFSUtil.getSysFormatDate());
		tsRoleInfo.setRiAddTime(EFSUtil.getSysFormatTime());

		tsRoleInfoService.addTsRoleInfo(tsRoleInfo);
		return packJsonResult(true);
	}
	
	/**
	 * 更新TsRoleInfo信息
	 * @param roleDbId
	 * @return
	 */
	@RequestMapping(value="/updateTsRoleInfo")
	@ResponseBody
	@Auth("role_updateTsRoleInfo")
	public JsonResult updateTsRoleInfo(HttpSession session, HttpServletRequest request, HttpServletResponse resp, TsRoleInfoForm tsRoleInfoForm) throws Exception
	{
		TsRoleInfo tsRoleInfo = new TsRoleInfo();
		TsUserInfo loginUser = getSessionUser(session);
		List<String> funcList = null;

		BeanUtils.copyProperties(tsRoleInfo, tsRoleInfoForm);

		if(tsRoleInfoForm.getRoleFunc() != null && tsRoleInfoForm.getRoleFunc().length>0)
		{
			funcList = new ArrayList<>();
			for (String func : tsRoleInfoForm.getRoleFunc())
			{
				funcList.add(func);
			}
			tsRoleInfo.setFuncList(funcList);
		}

		tsRoleInfo.setRiAddUser(loginUser.getUiId());
		tsRoleInfo.setRiAddDate(EFSUtil.getSysFormatDate());
		tsRoleInfo.setRiAddTime(EFSUtil.getSysFormatTime());

		tsRoleInfoService.updateTsRoleInfo(tsRoleInfo);
		return packJsonResult(true);
	}
	
	/**
	 * 刪除TsRoleInfo
	 * @param roleId
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping("/deleteTsRoleInfo")
	@Auth("role_deleteTsRoleInfo")
	public JsonResult deleteTsRoleInfo(String riId) throws Exception
	{
		tsRoleInfoService.deleteTsRoleInfo(riId);
		return packJsonResult(true);
	}

	/**
	 * 檢查某個用戶是否還在使用
	 * @param roleId
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping("/checkRoleHasUser")
	@Auth
	public JsonResult checkRoleHasUser(String riId) throws Exception
	{
		int res = tsRoleInfoService.getRoleUserCount(riId);
		return packJsonResult(true, res);
	}

	/**
	 * 获取当前系统中的可用角色
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping("/listAllEnableRole")
	@Auth
	public List<TsRoleInfo> listAllEnableRole(HttpSession session) throws Exception
	{
		return tsRoleInfoService.listAllEnableRole(getSuperUser(session));
	}
}
