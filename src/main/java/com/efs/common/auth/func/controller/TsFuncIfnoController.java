package com.efs.common.auth.func.controller;

import com.efs.common.auth.func.mapper.TsFuncIfno;
import com.efs.common.auth.func.service.TsFuncIfnoService;
import com.efs.common.controller.BaseController;
import com.efs.common.controller.JsonResult;
import com.efs.common.database.PageDataBunder;
import com.efs.common.interceptor.Auth;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 
 * com.efs.common.auth.func.mapper.TsFuncIfnoController
 * @author xuwh
 * 2017-06-25 15:53:43
 * 系统功能表
 *
 */
@Controller
@RequestMapping("/sysadmin/funcAdmin")
public class TsFuncIfnoController extends BaseController
{
	@Resource(name="tsFuncIfnoService")
	private TsFuncIfnoService tsFuncIfnoService;
	
	/**
	 * 进入TsFuncIfno页面
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/gotoTsFuncIfnoPage")
	@Auth
	public String gotoTsFuncIfnoPage(HttpSession session,Model model) throws Exception
	{
		String treeJson = tsFuncIfnoService.getFuncJson(getSuperUser(session));
		model.addAttribute("treeJson",treeJson);
		return "/admin/sysadmin/func/funcAdminPage";
	}
	
	/**
	 * 查询TsFuncIfnoGrid列表
	 * @param paramBean
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/listTsFuncIfno")
	@Auth
	public PageDataBunder listTsFuncIfno(HttpSession session,HttpServletRequest request,TsFuncIfnoForm tsFuncIfnoForm) throws Exception
	{
		TsFuncIfno tsFuncIfno = new TsFuncIfno();
		
		BeanUtils.copyProperties(tsFuncIfno, tsFuncIfnoForm);
		return tsFuncIfnoService.listTsFuncIfno(tsFuncIfno,getPage(request));
	}
	
	/**
	 * 查询单个TsFuncIfno信息
	 * @param roleDbId
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getTsFuncIfno")
	@Auth
	public TsFuncIfno getTsFuncIfno(String muDbId) throws Exception
	{
		TsFuncIfno funcInfo = tsFuncIfnoService.getTsFuncIfno(muDbId);
		return funcInfo;
	}
	
	/**
	 * 新增TsFuncIfno信息
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/addTsFuncIfno")
	@Auth
	public JsonResult addTsFuncIfno(HttpServletRequest request, HttpServletResponse resp, TsFuncIfnoForm tsFuncIfnoForm) throws Exception
	{
		TsFuncIfno tsFuncIfno = new TsFuncIfno();
		BeanUtils.copyProperties(tsFuncIfno, tsFuncIfnoForm);
		tsFuncIfnoService.addTsFuncIfno(tsFuncIfno);
		return packJsonResult(true);
	}
	
	/**
	 * 更新TsFuncIfno信息
	 * @param roleDbId
	 * @return
	 */
	@RequestMapping(value="/updateTsFuncIfno")
	@ResponseBody
	@Auth
	public JsonResult updateTsFuncIfno(HttpServletRequest request, HttpServletResponse resp, TsFuncIfnoForm tsFuncIfnoForm) throws Exception
	{
		TsFuncIfno tsFuncIfno = new TsFuncIfno();
		BeanUtils.copyProperties(tsFuncIfno, tsFuncIfnoForm);
		tsFuncIfnoService.updateTsFuncIfno(tsFuncIfno);
		return packJsonResult4Form(true, resp);
	}
	
	/**
	 * 刪除TsFuncIfno
	 * @param roleId
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping("/deleteTsFuncIfno")
	@Auth
	public JsonResult deleteTsFuncIfno(String muDbId) throws Exception
	{
		tsFuncIfnoService.deleteTsFuncIfno(muDbId);
		return packJsonResult(true);
	}

	/**
	 * 獲取菜單樹JSON字符串
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping("/getFuncResource")
	@Auth
	public JsonResult getFuncResource(HttpSession session) throws Exception
	{
		String json = tsFuncIfnoService.getFuncJson(getSuperUser(session));
		return packJsonResult(true,json);
	}

	/**
	 * 检查MUID是否存在
	 * @param muId
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping("/checkFuncIdExists")
	@Auth
	public String checkFuncIdExists(String muId) throws  Exception
	{
		if(tsFuncIfnoService.getFuncMuIdExists(muId))
		{
			return "false";
		}
		else
		{
			return "true";
		}
	}

	/**
	 * 更新菜单排序
	 * @param resFuncId
	 * @param newParentId
	 * @param targetId
	 * @param moveType
	 * @param newTreeJson
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping("/updateFuncOrders")
	@Auth
	public JsonResult updateFuncOrders(String resFuncId, String newParentId, String targetId, String moveType, String newTreeJson) throws Exception
	{
		TsFuncIfno funcInfo = null;
		List<Map<String, Object>> treeList = null;
		List<TsFuncIfno> funcList = new ArrayList<TsFuncIfno>();

		Type type = null;
		Gson gson = null;

		if(StringUtils.isEmpty(newParentId))
		{
			newParentId = "0";
		}

		//如果是移动到某个节点的子节点下，则父节点为目标结点
		if("inner".equals(moveType))
		{
			newParentId = targetId;
		}

		//产生新的次序号
		gson = new Gson();
		type = new TypeToken<List<Map<String, Object>>>(){}.getType();
		treeList = gson.fromJson(newTreeJson, type);

		if(treeList != null && treeList.size() > 0)
		{
			int index =1;
			for(Map<String, Object> ent : treeList)
			{
				funcInfo = new TsFuncIfno();
				funcInfo.setMuDbId((String)ent.get("id"));
				funcInfo.setMuOrders(index + "");
				funcList.add(funcInfo);
				index++;
			}
		}

		tsFuncIfnoService.updateFuncOrders(newParentId, resFuncId, funcList);
		return packJsonResult(true);

	}

	/**
	 * 获取角色下拉菜单树
	 * @param roleId
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping("/getFuncRoleSelectResource")
	@Auth
	public String getFuncRoleSelectResource(String roleId,HttpSession session) throws Exception
	{
		String json = tsFuncIfnoService.getRolesFuncTreeJson(roleId,getSuperUser(session));
		return json;
	}

	/**
	 * 获取某个角色相关的下拉
	 * @param roleId
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping("/getFuncRoleTreeJson")
	@Auth
	public JsonResult getFuncRoleTreeJson(String roleId, HttpSession session) throws Exception
	{
		String json = tsFuncIfnoService.getFuncJsonWithRole(roleId,getSuperUser(session));
		return packJsonResult(true,json);
	}

	/**
	 * 快捷菜单设置页面
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/gotoTsQuickFuncIfnoPage")
	@Auth
	public String gotoTsQuickFuncIfnoPage(HttpSession session,Model model) throws Exception
	{
		String treeJson = tsFuncIfnoService.getUserQuickFuncTreeJson(getSessionUserId(session));
		model.addAttribute("treeJson",treeJson);
		return "/admin/sysadmin/func/quickFuncAdminPage";
	}

	/**
	 * 添加快捷菜单
	 *
	 * @param userId
	 * @param funcId
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping("/addQuickLinkFunc")
	@Auth
	public JsonResult addQuickLinkFunc(HttpSession session, String funcId) throws Exception
	{
		tsFuncIfnoService.addQuickLinkFunc(getSessionUserId(session),funcId);
		return packJsonResult(true);
	}

	/**
	 * 删除快捷菜单
	 *
	 * @param userId
	 * @param funcId
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping("/delQuickLinkFunc")
	@Auth
	public JsonResult delQuickLinkFunc(HttpSession session, String funcId) throws Exception
	{
		tsFuncIfnoService.delQuickLinkFunc(getSessionUserId(session), funcId);
		return packJsonResult(true);
	}
}
