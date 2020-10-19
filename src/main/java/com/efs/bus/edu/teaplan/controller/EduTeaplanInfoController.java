package com.efs.bus.edu.teaplan.controller;

import com.efs.bus.edu.teaplan.mapper.EduTeaplanInfo;
import com.efs.bus.edu.teaplan.service.EduTeaplanInfoService;
import com.efs.bus.upload.mapper.TsFileUpload;
import com.efs.bus.upload.service.TsFileUploadService;
import com.efs.common.Util.SysUtils;
import com.efs.common.controller.BaseController;
import com.efs.common.controller.JsonResult;
import com.efs.common.database.PageDataBunder;
import com.efs.common.interceptor.Auth;
import com.xwh.util.EFSUtil;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.collections4.CollectionUtils;
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
import java.io.File;
import java.util.List;

/**
 * 
 * com.efs.bus.edu.teaplan.mapper.EduTeaplanInfoController
 * @author xwh
 * 2018-05-22 14:33:08
 * 教案检查信息表
 *
 */
@Controller
@RequestMapping("/edu/teaplan")
public class EduTeaplanInfoController extends BaseController
{
	@Resource(name="eduTeaplanInfoService")
	private EduTeaplanInfoService eduTeaplanInfoService;

    @Resource(name="tsFileUploadService")
	private TsFileUploadService tsFileUploadService;
	
	/**
	 * 进入EduTeaplanInfo页面
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/gotoEduTeaplanInfoPage")
	@Auth
	public String gotoEduTeaplanInfoPage() throws Exception
	{
		return "/sysadmin/roleadmin/roleAdminPage";
	}
	
	/**
	 * 查询EduTeaplanInfoGrid列表
	 * @param paramBean
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/listEduTeaplanInfo")
	@Auth
	public PageDataBunder listEduTeaplanInfo(HttpSession session,HttpServletRequest request,EduTeaplanInfoForm eduTeaplanInfoForm) throws Exception
	{
		EduTeaplanInfo eduTeaplanInfo = new EduTeaplanInfo();
		
		BeanUtils.copyProperties(eduTeaplanInfo, eduTeaplanInfoForm);
		return eduTeaplanInfoService.listEduTeaplanInfo(eduTeaplanInfo,getPage(request));
	}
	
	/**
	 * 查询单个EduTeaplanInfo信息
	 * @param roleDbId
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getEduTeaplanInfo")
	@Auth
	public EduTeaplanInfo getEduTeaplanInfo(String tiDbId) throws Exception
	{
		return eduTeaplanInfoService.getEduTeaplanInfo(tiDbId);
	}
	
	/**
	 * 新增EduTeaplanInfo信息
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/addEduTeaplanInfo")
	@Auth("role_addEduTeaplanInfo")
	public JsonResult addEduTeaplanInfo(HttpSession session,HttpServletResponse resp,EduTeaplanInfoForm eduTeaplanInfoForm) throws Exception
	{
		EduTeaplanInfo eduTeaplanInfo = new EduTeaplanInfo();
		BeanUtils.copyProperties(eduTeaplanInfo, eduTeaplanInfoForm);
		SysUtils.packAddObjectProp(getSessionUser(session),eduTeaplanInfo);
		eduTeaplanInfoService.addEduTeaplanInfo(eduTeaplanInfo);
		return packJsonResult4Form(true, resp);
	}
	
	/**
	 * 更新EduTeaplanInfo信息
	 * @param roleDbId
	 * @return
	 */
	@RequestMapping(value="/updateEduTeaplanInfo")
	@ResponseBody
	@Auth("role_updateEduTeaplanInfo")
	public JsonResult updateEduTeaplanInfo(HttpSession session,HttpServletResponse resp,EduTeaplanInfoForm eduTeaplanInfoForm) throws Exception
	{
		EduTeaplanInfo eduTeaplanInfo = new EduTeaplanInfo();
		BeanUtils.copyProperties(eduTeaplanInfo, eduTeaplanInfoForm);
		SysUtils.packUpdObjectProp(getSessionUser(session),eduTeaplanInfo);
		eduTeaplanInfoService.updateEduTeaplanInfo(eduTeaplanInfo);
		return packJsonResult4Form(true, resp);
	}
	
	/**
	 * 刪除EduTeaplanInfo
	 * @param roleId
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping("/deleteEduTeaplanInfo")
	@Auth("role_deleteEduTeaplanInfo")
	public JsonResult deleteEduTeaplanInfo(String tiDbId) throws Exception
	{
		eduTeaplanInfoService.deleteEduTeaplanInfo(tiDbId);
		return packJsonResult(true);
	}

	/**
	 * 进入发布信息页面
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/gotoIssueTeanPlan")
	@Auth
	public String gotoIssueTeanPlan() throws Exception
	{
		return "/edu/teaplan/issueTeaplanInfoPage";
	}

	/**
	 * 查询EduTeaplanInfoGrid列表
	 * @param paramBean
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/listIssueEduTeaplanInfo")
	@Auth
	public PageDataBunder listIssueEduTeaplanInfo(HttpSession session,HttpServletRequest request,EduTeaplanInfoForm eduTeaplanInfoForm) throws Exception
	{
		EduTeaplanInfo eduTeaplanInfo = new EduTeaplanInfo();

		BeanUtils.copyProperties(eduTeaplanInfo, eduTeaplanInfoForm);
		return eduTeaplanInfoService.listIssueInfo(eduTeaplanInfo,getPage(request));
	}

	/**
	 * 发布检查信息
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/issueEduTeaplanInfo")
	@Auth
	public JsonResult issueEduTeaplanInfo(HttpSession session,HttpServletResponse resp,EduTeaplanInfoForm eduTeaplanInfoForm) throws Exception
	{
		EduTeaplanInfo eduTeaplanInfo = new EduTeaplanInfo();
		BeanUtils.copyProperties(eduTeaplanInfo, eduTeaplanInfoForm);

		eduTeaplanInfo.setTiIssueUser(getSessionUserId(session));
		eduTeaplanInfoService.addEduTeaplanInfo(eduTeaplanInfo);
		return packJsonResult4Form(true, resp);
	}

	/**
	 * 发布检查信息
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/deleteBatchEduTeaplan")
	@Auth
	public JsonResult deleteBatchEduTeaplan(String tiBatchId) throws Exception
	{
		eduTeaplanInfoService.deleteBatchTeaplan(tiBatchId);
		return packJsonResult(true);
	}

	/**
	 * 进入我的教案页面
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/gotoMyTeachPlan")
	@Auth
	public String gotoMyTeachPlan(HttpSession session) throws Exception
	{
		return "/edu/teaplan/myEduTeaplanInfoPage";
	}

	/**
	 * 查询我的教案
	 * @param paramBean
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/listMyEduTeaplanInfo")
	@Auth
	public PageDataBunder listMyEduTeaplanInfo(HttpSession session,HttpServletRequest request,EduTeaplanInfoForm eduTeaplanInfoForm) throws Exception
	{
		EduTeaplanInfo eduTeaplanInfo = new EduTeaplanInfo();

		eduTeaplanInfoForm = (EduTeaplanInfoForm)getReturnBackParameter(session,"eduTeaplanInfoForm",eduTeaplanInfoForm);

		BeanUtils.copyProperties(eduTeaplanInfo, eduTeaplanInfoForm);
		eduTeaplanInfo.setTiCheckedUser(getSessionUserId(session));
		return eduTeaplanInfoService.listEduTeaplanInfo(eduTeaplanInfo,getPage(request));
	}

    /**
     * 进入文件上传页面
     * @param session
     * @param model
     * @param tiDbId
     * @return
     * @throws Exception
     */
    @RequestMapping("/gotoUploadPlanPage")
    @Auth
	public String gotoUploadPlanPage(HttpSession session,Model model,String tiDbId) throws Exception
    {
        EduTeaplanInfo teaplanInfo = eduTeaplanInfoService.getEduTeaplanInfo(tiDbId);
        model.addAttribute("teaplanInfo",teaplanInfo);
        return "/edu/teaplan/myEduTeaplanInfoDetail";
    }

    /**
     * 检查教案是否没有上传过
     * @param tiDbId
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping("/checkPlanHasNoUpload")
    @Auth
    public JsonResult checkPlanHasNoUpload(String tiDbId) throws Exception
    {
        EduTeaplanInfo teaplanInfo = eduTeaplanInfoService.getEduTeaplanInfo(tiDbId);
        boolean res = false;
        if("0".equals(teaplanInfo.getTiStatus()))
        {
           res = true;
        }

        return packJsonResult(res);
    }

    /**
     * 上传并提交教案信息
     * @param session
     * @param tiFileId
     * @param tiDbId
     * @param model
     * @return
     * @throws Exception
     */
    @RequestMapping("/doUploadTeaPlan")
    @Auth
    public String doUploadTeaPlan(HttpSession session, @RequestParam CommonsMultipartFile tiFileId,String tiDbId,Model model) throws Exception
    {
        String errMsg = "";

        try
        {
            if(!tiFileId.isEmpty())
            {
                File f = transUploadFile(tiFileId);
                String fileId = tsFileUploadService.addTsFileUpload(tiFileId,getSessionUserId(session),"edu.teanplan.upload.path");

                EduTeaplanInfo dataBean = new EduTeaplanInfo();
                dataBean.setTiDbId(Long.parseLong(tiDbId));
                dataBean.setTiFileId(fileId);
                dataBean.setTiSubDate(EFSUtil.getSysFormatDate());
                dataBean.setTiSubTime(EFSUtil.getSysFormatTime());
                dataBean.setTiSubUser(getSessionUserId(session));

                eduTeaplanInfoService.addSubmitTeaplan(dataBean);
                errMsg = "上传成功";
            }
            else
            {
                errMsg = "上传文件为空";
            }
        } catch (Exception e)
        {
            errMsg = e.getMessage();
        }

        model.addAttribute("errMsg",errMsg);

        EduTeaplanInfo teaplanInfo = eduTeaplanInfoService.getEduTeaplanInfo(tiDbId);
        model.addAttribute("teaplanInfo",teaplanInfo);
        return "/edu/teaplan/myEduTeaplanInfoDetail";
    }

    /**
     * 下载教案
     * @param request
     * @param response
     * @param tiFileId
     * @return
     * @throws Exception
     */
    @RequestMapping("/downloadTeaplan")
    @Auth
    public String downloadTeaplan(HttpServletRequest request,HttpServletResponse response, String tiFileId) throws Exception
    {
        TsFileUpload fileUpload = tsFileUploadService.getTsFileUpload(tiFileId,"edu.teanplan.upload.path");

        commonDownLoadFile(fileUpload.getFpName(),fileUpload.getFullFileName(),request,response);

        return null;
    }

	/**
	 * 进入教案评价页面
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/gotoEvalTeachPlan")
	@Auth
	public String gotoEvalTeachPlan(Model model) throws Exception
	{
		List<String> batchIds = eduTeaplanInfoService.listBatchids();
		model.addAttribute("batchIds",batchIds);
		return "/edu/teaplan/evalEduTeaplanInfoPage";
	}

	/**
	 * 查询我的教案
	 * @param paramBean
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/listEvalEduTeaplanInfo")
	@Auth
	public PageDataBunder listEvalEduTeaplanInfo(HttpSession session,HttpServletRequest request,EduTeaplanInfoForm eduTeaplanInfoForm) throws Exception
	{
		EduTeaplanInfo eduTeaplanInfo = new EduTeaplanInfo();

		eduTeaplanInfoForm = (EduTeaplanInfoForm)getReturnBackParameter(session,"eduTeaplanInfoForm",eduTeaplanInfoForm);

		BeanUtils.copyProperties(eduTeaplanInfo, eduTeaplanInfoForm);
		eduTeaplanInfo.setCheckFlag("Y");
		return eduTeaplanInfoService.listEduTeaplanInfo(eduTeaplanInfo,getPage(request));
	}

	/**
	 * 进入教案评价页
	 * @param model
	 * @param tiDbId
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/gotoDoEvalTeaplan")
	@Auth
	public String gotoDoEvalTeaplan(Model model,String tiDbId) throws Exception
	{
		EduTeaplanInfo eduTeaplanInfo = eduTeaplanInfoService.getEduTeaplanInfo(tiDbId);

		model.addAttribute("teaplanInfo",eduTeaplanInfo);
		return "/edu/teaplan/evalEduTeaplanInfoDetail";
	}

	/**
	 * 进行评价
	 * @param session
	 * @param eduTeaplanInfoForm
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/doEvalTeaplan")
	@Auth
	public String doEvalTeaplan(HttpSession session,EduTeaplanInfoForm eduTeaplanInfoForm) throws Exception
	{
		EduTeaplanInfo paramBean = new EduTeaplanInfo();
		BeanUtils.copyProperties(paramBean, eduTeaplanInfoForm);

		paramBean.setTiEvalDate(EFSUtil.getSysFormatDate());
		paramBean.setTiEvalTime(EFSUtil.getSysFormatTime());
		paramBean.setTiEvalUser(getSessionUserId(session));

		eduTeaplanInfoService.addEvalTeaplan(paramBean);

		return "redirect:/edu/teaplan/gotoEvalTeachPlan.do?isBack=Y";
	}

	/**
	 * 查询各个状态老师的明细信息
	 * @param tiBatchId
	 * @param tiStatus
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping("/getStatusTeachers")
	@Auth
	public JsonResult getStatusTeachers(String tiBatchId, String tiStatus) throws Exception
	{
		List<EduTeaplanInfo> dataList = eduTeaplanInfoService.listStatusTeacher(tiBatchId, tiStatus);
		StringBuilder sb = new StringBuilder();

		if(CollectionUtils.isNotEmpty(dataList))
		{
			for (EduTeaplanInfo plan : dataList)
			{
				sb.append(plan.getTiClassNm() + ":" + plan.getTiCheckedUserNm() + "<br/>");
			}
		}
		else
		{
			sb.append("无相关人员信息");
		}

		return packJsonResult(true,sb.toString());
	}
}
