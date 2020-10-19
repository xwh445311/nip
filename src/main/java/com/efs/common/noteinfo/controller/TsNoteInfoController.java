package com.efs.common.noteinfo.controller;

import com.efs.common.Util.IDUtil;
import com.efs.common.controller.BaseController;
import com.efs.common.controller.JsonResult;
import com.efs.common.database.PageDataBunder;
import com.efs.common.interceptor.Auth;
import com.efs.common.noteinfo.mapper.TsNoteInfo;
import com.efs.common.noteinfo.service.TsNoteInfoService;
import com.xwh.util.EFSUtil;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 
 * com.efs.common.noteinfo.mapper.TsNoteInfoController
 * @author xwh
 * 2017-08-30 17:22:24
 * 系统消息表
 *
 */
@Controller
@RequestMapping("/sysadmin/noteInfo")
public class TsNoteInfoController extends BaseController
{
	@Resource(name="tsNoteInfoService")
	private TsNoteInfoService tsNoteInfoService;
	
	/**
	 * 进入TsNoteInfo页面
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/gotoTsNoteInfoPage")
	@Auth
	public String gotoTsNoteInfoPage() throws Exception
	{
		return "/admin/sysadmin/note/noteInfoPage";
	}
	
	/**
	 * 查询TsNoteInfoGrid列表
	 * @param paramBean
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/listTsNoteInfo")
	@Auth
	public PageDataBunder listTsNoteInfo(HttpSession session, HttpServletRequest request, TsNoteInfoForm tsNoteInfoForm) throws Exception
	{
		TsNoteInfo tsNoteInfo = new TsNoteInfo();

		tsNoteInfoForm = (TsNoteInfoForm)getReturnBackParameter(session,"tsNoteInfoForm",tsNoteInfoForm);

		BeanUtils.copyProperties(tsNoteInfo, tsNoteInfoForm);
		tsNoteInfo.setNtReadUser(getSessionUserId(session));
		return tsNoteInfoService.listTsNoteInfo(tsNoteInfo,getPage(request));
	}
	
	/**
	 * 查询单个TsNoteInfo信息
	 * @param roleDbId
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getTsNoteInfo")
	@Auth
	public TsNoteInfo getTsNoteInfo(String ntId) throws Exception
	{
		return tsNoteInfoService.getTsNoteInfo(ntId);
	}

	/**
	 * 进入添加消息页面
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/gotoAddNoteInfo")
	@Auth("role_addTsNoteInfo")
	public String gotoAddNoteInfo() throws Exception
	{
		return "/admin/sysadmin/note/addNoteInfoPage";
	}
	
	/**
	 * 新增TsNoteInfo信息
	 * @param request
	 * @return
	 */
	@RequestMapping("/addTsNoteInfo")
	@Auth
	public String addTsNoteInfo(HttpSession session, HttpServletResponse resp, TsNoteInfoForm tsNoteInfoForm) throws Exception
	{
		TsNoteInfo tsNoteInfo = new TsNoteInfo();
		BeanUtils.copyProperties(tsNoteInfo, tsNoteInfoForm);

		tsNoteInfo.setNtId(IDUtil.getId("ID_SYS_NOTE_INFO"));
		tsNoteInfo.setNtSendDate(EFSUtil.getSysFormatDate());
		tsNoteInfo.setNtSendTime(EFSUtil.getSysFormatTime());
		tsNoteInfo.setNtSendUser(getSessionUserId(session));
		tsNoteInfoService.addTsNoteInfo(tsNoteInfo);
		return "redirect:/sysadmin/noteInfo/gotoTsNoteInfoPage.do?isBack=Y";
	}

	/**
	 * 进入修改页面
	 * @param ntId
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/gotoUpdateNoteInfo")
	@Auth("role_updateTsNoteInfo")
	public String gotoUpdateNoteInfo(String ntId,Model model) throws Exception
	{
		TsNoteInfo noteInfo = tsNoteInfoService.getTsNoteInfo(ntId);
		model.addAttribute("tsNoteInfo",noteInfo);
		return "/admin/sysadmin/note/updNoteInfoPage";
	}

	/**
	 * 更新TsNoteInfo信息
	 * @param roleDbId
	 * @return
	 */
	@RequestMapping(value="/updateTsNoteInfo")
	@Auth
	public String updateTsNoteInfo(HttpSession session,HttpServletResponse resp,TsNoteInfoForm tsNoteInfoForm) throws Exception
	{
		TsNoteInfo tsNoteInfo = new TsNoteInfo();
		BeanUtils.copyProperties(tsNoteInfo, tsNoteInfoForm);

		tsNoteInfo.setNtSendDate(EFSUtil.getSysFormatDate());
		tsNoteInfo.setNtSendTime(EFSUtil.getSysFormatTime());
		tsNoteInfo.setNtSendUser(getSessionUserId(session));

		tsNoteInfoService.updateTsNoteInfo(tsNoteInfo);
		return "redirect:/sysadmin/noteInfo/gotoTsNoteInfoPage.do?isBack=Y";
	}
	
	/**
	 * 刪除TsNoteInfo
	 * @param roleId
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping("/deleteTsNoteInfo")
	@Auth("role_deleteTsNoteInfo")
	public JsonResult deleteTsNoteInfo(String ntId) throws Exception
	{
		tsNoteInfoService.deleteTsNoteInfo(ntId);
		return packJsonResult(true);
	}

	/**
	 * 进入查看 页面
	 * @param session
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/gotoViewNotePage")
	@Auth
	public String gotoViewNotePage(HttpSession session,String ntId, Model model) throws Exception
	{
		TsNoteInfo noteInfo = tsNoteInfoService.getTsNoteInfo(ntId);
		model.addAttribute("tsNoteInfo",noteInfo);

		//设置消息已经读过
		tsNoteInfoService.updateReadNoteInfo(ntId,getSessionUserId(session));

		return "/admin/sysadmin/note/viewNoteInfoPage";
	}
}
