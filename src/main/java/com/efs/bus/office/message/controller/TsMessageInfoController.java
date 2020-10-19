package com.efs.bus.office.message.controller;

import com.efs.bus.office.message.mapper.TsMessageInfo;
import com.efs.bus.office.message.service.TsMessageInfoService;
import com.efs.bus.upload.mapper.TsFileUpload;
import com.efs.bus.upload.service.TsFileUploadService;
import com.efs.common.auth.org.mapper.TsOrgInfo;
import com.efs.common.auth.org.service.TsOrgInfoService;
import com.efs.common.auth.user.mapper.TsUserInfo;
import com.efs.common.controller.BaseController;
import com.efs.common.controller.JsonResult;
import com.efs.common.database.PageDataBunder;
import com.efs.common.interceptor.Auth;
import com.xwh.bean.SelectBean;
import com.xwh.util.EFSUtil;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * 
 * com.efs.bus.office.message.mapper.TsMessageInfoController
 * @author xwh
 * 2018-05-24 13:41:27
 * 系统通知消息表
 *
 */
@Controller
@RequestMapping("/office/message")
public class TsMessageInfoController extends BaseController
{
	@Resource(name="tsMessageInfoService")
	private TsMessageInfoService tsMessageInfoService;

	@Resource(name="tsOrgInfoService")
	private TsOrgInfoService tsOrgInfoService;

	@Resource(name="tsFileUploadService")
	private TsFileUploadService tsFileUploadService;
	
	/**
	 * 进入TsMessageInfo页面
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/gotoTsMessageInfoPage")
	@Auth
	public String gotoTsMessageInfoPage() throws Exception
	{
		return "/office/message/tsMessageInfoPage";
	}
	
	/**
	 * 查询TsMessageInfoGrid列表
	 * @param paramBean
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/listTsMessageInfo")
	@Auth
	public PageDataBunder listTsMessageInfo(HttpSession session,HttpServletRequest request,TsMessageInfoForm tsMessageInfoForm) throws Exception
	{
		TsMessageInfo tsMessageInfo = new TsMessageInfo();
		TsUserInfo curUser = getSessionUser(session);

		tsMessageInfoForm = (TsMessageInfoForm)getReturnBackParameter(session,"tsMessageInfoForm",tsMessageInfoForm);
		BeanUtils.copyProperties(tsMessageInfo, tsMessageInfoForm);
		tsMessageInfo.setUserType(getUserInOrOutType(session));

		return tsMessageInfoService.listTsMessageInfo(tsMessageInfo,getPage(request));
	}
	
	/**
	 * 查询单个TsMessageInfo信息
	 * @param roleDbId
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getTsMessageInfo")
	@Auth
	public TsMessageInfo getTsMessageInfo(String miCode) throws Exception
	{
		return tsMessageInfoService.getTsMessageInfo(miCode);
	}
	
	/**
	 * 新增TsMessageInfo信息
	 * @param request
	 * @return
	 */
	@RequestMapping("/addTsMessageInfo")
	@Auth("role_addTsMessageInfo")
	public String addTsMessageInfo(HttpSession session, @RequestParam CommonsMultipartFile[] uploadFiles, TsMessageInfoForm tsMessageInfoForm) throws Exception
	{
		TsMessageInfo tsMessageInfo = new TsMessageInfo();
		BeanUtils.copyProperties(tsMessageInfo, tsMessageInfoForm);

		tsMessageInfo.setMiIssueDate(EFSUtil.getSysFormatDate());
		tsMessageInfo.setMiIssueTime(EFSUtil.getSysFormatTime());
		tsMessageInfo.setMiIssueUser(getSessionUserId(session));

		//处理文件上传
		String ids = handUploadFile(uploadFiles,session);
		tsMessageInfo.setMiFileIds(ids);
		tsMessageInfoService.addTsMessageInfo(tsMessageInfo);

		return "redirect:/office/message/gotoTsMessageInfoPage.do?isBack=Y";
	}
	
	/**
	 * 更新TsMessageInfo信息
	 * @param roleDbId
	 * @return
	 */
	@RequestMapping(value="/updateTsMessageInfo")
	@Auth("role_updateTsMessageInfo")
	public String updateTsMessageInfo(HttpSession session,HttpServletResponse resp, @RequestParam CommonsMultipartFile[] uploadFiles,TsMessageInfoForm tsMessageInfoForm) throws Exception
	{
		TsMessageInfo tsMessageInfo = new TsMessageInfo();
		BeanUtils.copyProperties(tsMessageInfo, tsMessageInfoForm);

		tsMessageInfo.setMiIssueDate(EFSUtil.getSysFormatDate());
		tsMessageInfo.setMiIssueTime(EFSUtil.getSysFormatTime());
		tsMessageInfo.setMiIssueUser(getSessionUserId(session));

		//处理文件上传
		if(uploadFiles != null && uploadFiles.length > 0 && !uploadFiles[0].isEmpty())
		{
			String ids = handUploadFile(uploadFiles,session);
			tsMessageInfo.setMiFileIds(ids);
			tsMessageInfo.setDelFile("Y");
		}
		else if("Y".equals(tsMessageInfo.getDelFile()))
		{
			//删除上传的文件
			tsMessageInfo.setMiFileIds("");
		}

		tsMessageInfoService.updateTsMessageInfo(tsMessageInfo);
		return "redirect:/office/message/gotoTsMessageInfoPage.do?isBack=Y";
	}
	
	/**
	 * 刪除TsMessageInfo
	 * @param roleId
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping("/deleteTsMessageInfo")
	@Auth("role_deleteTsMessageInfo")
	public JsonResult deleteTsMessageInfo(String miCode) throws Exception
	{
		tsMessageInfoService.deleteTsMessageInfo(miCode);
		return packJsonResult(true);
	}

	/**
	 * 进入新增通知页面
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/gotoAddNewMessagePage")
	@Auth
	public String gotoAddNewMessagePage(Model model) throws Exception
	{
		List<TsOrgInfo> orgList =tsOrgInfoService.listActiveOrgInfo();
		List<SelectBean> orgSelList = EFSUtil.convertBeanToSelectBean(orgList,"oiCode","oiName");
		model.addAttribute("orgSelList",orgSelList);
		return "/office/message/addMessageInfoPage";
	}

	/**
	 * 处理文件上传内容
	 * @param uploadFiles
	 * @param session
	 * @return
	 * @throws Exception
	 */
	private String handUploadFile(@RequestParam CommonsMultipartFile[] uploadFiles,HttpSession session) throws Exception
	{
		String res = "";
		if(uploadFiles != null && uploadFiles.length > 0)
		{
			for (CommonsMultipartFile fl : uploadFiles)
			{
				res += tsFileUploadService.addTsFileUpload(fl,getSessionUserId(session),"office.message.upload.path") + ",";
			}

			res = StringUtils.stripEnd(res,",");
		}

		return res;
	}

	/**
	 * 进入消息查看页面
	 * @param model
	 * @param miCode
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/gotoDetailPage")
	@Auth
	public String gotoDetailPage(Model model,String miCode,String flag) throws Exception
	{
		TsMessageInfo messageInfo = tsMessageInfoService.getTsMessageInfo(miCode);
		messageInfo.specHandForShow();

		if(CollectionUtils.isNotEmpty(messageInfo.getPatchFileLis()))
		{
			TsFileUpload paramBean = new TsFileUpload();
			paramBean.setFpIds(messageInfo.getPatchFileLis());
			List<TsFileUpload> fileUploadse = tsFileUploadService.listFiles(paramBean);
			messageInfo.setFileUploadList(fileUploadse);
		}

		model.addAttribute("flag",flag);
		model.addAttribute("messageInfo",messageInfo);
		return "/office/message/viewMessageInfoPage";
	}

    /**
     * 下载附件
     * @param fileId
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping("/downloadFile")
    @Auth
	public String downloadFile(String fileId,HttpServletRequest request,HttpServletResponse response) throws Exception
    {
        TsFileUpload fileUpload = tsFileUploadService.getTsFileUpload(fileId,"office.message.upload.path");
        commonDownLoadFile(fileUpload.getFpName(),fileUpload.getFullFileName(),request,response);

        return null;
    }

    /**
     * 进入修改页面
     * @param model
     * @param miCode
     * @return
     * @throws Exception
     */
    @RequestMapping("/gotoUpdatePage")
    @Auth
    public String gotoUpdatePage(Model model,String miCode) throws Exception
    {
        TsMessageInfo tsMessageInfo = tsMessageInfoService.getTsMessageInfo(miCode);
        model.addAttribute("tsMessageInfo",tsMessageInfo);

        List<TsOrgInfo> orgList =tsOrgInfoService.listActiveOrgInfo();
        List<SelectBean> orgSelList = EFSUtil.convertBeanToSelectBean(orgList,"oiCode","oiName");
        model.addAttribute("orgSelList",orgSelList);
        return "/office/message/updMessageInfoPage";
    }

	/**
	 * 检查是否当前用户所发的通知
	 * @param session
	 * @param miCode
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping("/checkUserIssueMessage")
	@Auth
	public JsonResult checkUserIssueMessage(HttpSession session, String miCode) throws Exception
	{
		boolean res = tsMessageInfoService.checkUserIssueMessage(miCode,getSessionUserId(session));

		return packJsonResult(res);
	}
}
