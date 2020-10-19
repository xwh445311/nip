package com.efs.bus.edu.scorerecord.controller;

import com.alibaba.fastjson.JSONObject;
import com.efs.bus.edu.scorerecord.mapper.EduRecordInfo;
import com.efs.bus.edu.scorerecord.service.EduRecordInfoService;
import com.efs.bus.edu.scorestatic.mapper.EduClassStaticInfo;
import com.efs.bus.edu.semcal.mapper.BaseSemesterCal;
import com.efs.bus.edu.semcal.service.BaseSemesterCalService;
import com.efs.bus.util.BusUtil;
import com.efs.bus.util.RecordComputeUtil;
import com.efs.common.Util.SysUtils;
import com.efs.common.auth.user.mapper.TsUserInfo;
import com.efs.common.controller.BaseController;
import com.efs.common.controller.JsonResult;
import com.efs.common.database.PageDataBunder;
import com.efs.common.interceptor.Auth;
import com.xwh.excelupload.exception.ExcelUploadException;
import com.xwh.excelupload.util.ExcelUploadParser;
import com.xwh.util.EFSUtil;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.List;
import java.util.Map;

/**
 * 
 * com.efs.bus.edu.scorerecord.mapper.EduRecordInfoController
 * @author xuwh
 * 2018-05-04 23:25:56
 * 学生学习成绩信息表
 *
 */
@Controller
@RequestMapping("/edu/record")
public class EduRecordInfoController extends BaseController
{
	@Resource(name="eduRecordInfoService")
	private EduRecordInfoService eduRecordInfoService;

	@Resource(name="baseSemesterCalService")
	private BaseSemesterCalService baseSemesterCalService;
	
	/**
	 * 进入EduRecordInfo页面
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/gotoEduRecordInfoPage")
	@Auth
	public String gotoEduRecordInfoPage(HttpSession session,String isBack) throws Exception
	{
		TsUserInfo curUser = getSessionUser(session);

		if(!"Y".equals(isBack))
		{
			EduRecordInfoForm eduRecordInfoForm = new EduRecordInfoForm();
			packRecordForm(curUser,eduRecordInfoForm);

			session.setAttribute("eduRecordInfoForm",eduRecordInfoForm);
		}

		return "/edu/eduRecordInfoPage";
	}
	
	/**
	 * 查询EduRecordInfoGrid列表
	 * @param paramBean
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/listEduRecordInfo")
	@Auth
	public PageDataBunder listEduRecordInfo(HttpSession session,HttpServletRequest request,EduRecordInfoForm eduRecordInfoForm) throws Exception
	{
		EduRecordInfo eduRecordInfo = new EduRecordInfo();

		eduRecordInfoForm = (EduRecordInfoForm)getReturnBackParameter(session,"eduRecordInfoForm",eduRecordInfoForm);
		TsUserInfo curUser = getSessionUser(session);

		packRecordForm(curUser,eduRecordInfoForm);
		BeanUtils.copyProperties(eduRecordInfo, eduRecordInfoForm);

		PageDataBunder pb = eduRecordInfoService.listEduRecordInfo(eduRecordInfo,getPage(request));
		BusUtil.formatShowRecord((List<EduRecordInfo>) pb.getRows());

		return pb;
	}

	/**
	 * 封装查询参数
	 * @param curUser
	 * @param eduRecordInfoForm
	 * @throws Exception
	 */
	private void packRecordForm(TsUserInfo curUser,EduRecordInfoForm eduRecordInfoForm) throws Exception
	{
		EduRecordInfo maxEdu = eduRecordInfoService.getMaxTermAndMid();
		if(StringUtils.isEmpty(eduRecordInfoForm.getRiTerm()))
		{
			if(maxEdu != null)
			{
				eduRecordInfoForm.setRiTerm(maxEdu.getRiTerm());
			}

		}

		if(StringUtils.isEmpty(eduRecordInfoForm.getRiMidTerm()))
		{
			if(maxEdu != null)
			{
				eduRecordInfoForm.setRiMidTerm(maxEdu.getRiMidTerm());
			}
		}

		if(StringUtils.isEmpty(eduRecordInfoForm.getRiClass()))
		{
			if(StringUtils.isNotEmpty(curUser.getHasClassLeader()))
			{
				eduRecordInfoForm.setRiClass(curUser.getHasClassLeader());
			}
			else if(CollectionUtils.isNotEmpty(curUser.getUtTeachClasses()))
			{
				String clas = curUser.getUtTeachClasses().get(0);
				eduRecordInfoForm.setRiClass(clas);
			}
			else if(maxEdu != null)
			{
				eduRecordInfoForm.setRiClass(maxEdu.getRiClass());
			}
		}
	}
	
	/**
	 * 查询单个EduRecordInfo信息
	 * @param roleDbId
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getEduRecordInfo")
	@Auth
	public EduRecordInfo getEduRecordInfo(String riId) throws Exception
	{
		return eduRecordInfoService.getEduRecordInfo(riId);
	}
	
	/**
	 * 新增EduRecordInfo信息
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/addEduRecordInfo")
	@Auth("role_addEduRecordInfo")
	public JsonResult addEduRecordInfo(HttpSession session,HttpServletResponse resp,EduRecordInfoForm eduRecordInfoForm) throws Exception
	{
		EduRecordInfo eduRecordInfo = new EduRecordInfo();
		BeanUtils.copyProperties(eduRecordInfo, eduRecordInfoForm);
		SysUtils.packAddObjectProp(getSessionUser(session),eduRecordInfo);
		//eduRecordInfoService.addEduRecordInfo(eduRecordInfo);
		return packJsonResult4Form(true, resp);
	}
	
	/**
	 * 更新EduRecordInfo信息
	 * @param roleDbId
	 * @return
	 */
	@RequestMapping(value="/updateLeaderCommont")
	@ResponseBody
	@Auth("role_updateLeaderCommont")
	public JsonResult updateLeaderCommont(HttpSession session,HttpServletResponse resp,EduRecordInfoForm eduRecordInfoForm) throws Exception
	{
		EduRecordInfo eduRecordInfo = new EduRecordInfo();
		BeanUtils.copyProperties(eduRecordInfo, eduRecordInfoForm);
		TsUserInfo curUser = getSessionUser(session);

		eduRecordInfo.setRiCommonUserId(curUser.getUiId());
		eduRecordInfo.setRiCommonUserName(curUser.getUiName());
		eduRecordInfo.setRiCommonDate(EFSUtil.getSysFormatDate());
		eduRecordInfo.setRiCommonTime(EFSUtil.getSysFormatTime());

		eduRecordInfoService.updateLeaderCommont(eduRecordInfo);
		return packJsonResult4Form(true, resp);
	}
	
	/**
	 * 刪除EduRecordInfo
	 * @param roleId
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping("/deleteEduRecordInfo")
	@Auth("role_deleteEduRecordInfo")
	public JsonResult deleteEduRecordInfo(String riId) throws Exception
	{
		eduRecordInfoService.deleteEduRecordInfo(riId);
		return packJsonResult(true);
	}

	/**
	 * 进入成绩上传页面
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/gotoUploadRecoredPage")
	@Auth
	public String gotoUploadRecoredPage(Model model) throws Exception
	{
		BaseSemesterCal semesterCal =baseSemesterCalService.getCurrentSemester();

		if(semesterCal == null)
		{
			model.addAttribute("errMsg","尚未设置当前日期的学期日历，请联系系统管理员");
		}
		else
		{
			model.addAttribute("semesterCal",semesterCal);
		}

		return "/edu/eduRecordUploadPage";
	}

	/**
	 * 下载指定班级的成绩统计模板
	 * @param request
	 * @param response
	 * @param eduRecordInfo
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/downFileModel")
	@Auth
	public String downFileModel(HttpServletRequest request,HttpServletResponse response,EduRecordInfo eduRecordInfo) throws Exception
	{
		String filePath = eduRecordInfoService.getRecoredModel(eduRecordInfo);
		String fileName = BusUtil.getClassDescFromCode(eduRecordInfo.getRiClass()) +".xlsx";

		commonDownLoadFile(fileName,filePath,request,response);
		return null;
	}

	/**
	 * 上传成绩
	 * @param uploadFile
	 * @param riTerm
	 * @param riMidTerm
	 * @param session
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/uploadStuRecordInfo")
	@Auth
	public String uploadStuRecordInfo(@RequestParam CommonsMultipartFile[] uploadFile, String riTerm,String riMidTerm, HttpSession session, RedirectAttributes model) throws Exception
	{
		List<EduRecordInfo> dataList ;
		String msg = "";
		String urClass;
		EduRecordInfo paramBean = new EduRecordInfo();
		int successCount =0;

		try
		{
			paramBean.setRiTerm(riTerm);
			paramBean.setRiMidTerm(riMidTerm);
			SysUtils.packAddObjectProp(getSessionUser(session),paramBean);

			if(ArrayUtils.isNotEmpty(uploadFile))
			{
				for (CommonsMultipartFile uFile : uploadFile)
				{
					File f = transUploadFile(uFile);
					urClass = BusUtil.getClassCodeFromName(f.getName());
					paramBean.setRiClass(urClass);
					paramBean.setRiClassName(BusUtil.getClassDescFromCode(urClass));

					dataList = ExcelUploadParser.parserExcel(f,"model_record");
					eduRecordInfoService.addEduRecordInfoPerClass(dataList,paramBean);
					successCount++;
				}

				//文件上传成功，计算成绩
                RecordComputeUtil.computeRecord(paramBean.getRiTerm(),paramBean.getRiMidTerm());
                RecordComputeUtil.computeStatics(paramBean.getRiTerm(),paramBean.getRiMidTerm());
				msg = "上传完成，成功上传["+successCount+"]个文件！";
			}
			else
			{
				msg = "上传失败，上传文件为空";
			}


		}
		catch (ExcelUploadException ex)
		{
			msg = ex.getMessage();
		}

		model.addFlashAttribute("msg",msg);
		return "redirect:/edu/record/gotoUploadRecoredPage.do";
	}

	/**
	 * 获取班级成绩统计信息
	 * @param session
	 * @param eduRecordInfoForm
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping("/listClassStatic")
	@Auth
	public PageDataBunder listClassStatic(HttpServletRequest request, HttpSession session,EduRecordInfoForm eduRecordInfoForm) throws Exception
	{
		EduRecordInfo eduRecordInfo = new EduRecordInfo();

		eduRecordInfoForm = (EduRecordInfoForm)getReturnBackParameter(session,"eduRecordInfoForm",eduRecordInfoForm);
		TsUserInfo curUser = getSessionUser(session);

		packRecordForm(curUser,eduRecordInfoForm);
		BeanUtils.copyProperties(eduRecordInfo, eduRecordInfoForm);

		EduClassStaticInfo staticInfoParam = new EduClassStaticInfo();
		staticInfoParam.setCsTerm(eduRecordInfo.getRiTerm());
		staticInfoParam.setCsMidTerm(eduRecordInfo.getRiMidTerm());
		staticInfoParam.setCsClass(eduRecordInfo.getRiClass());

		return eduRecordInfoService.listEduClassStaticInfo(staticInfoParam,getPage(request));
	}

	/**
	 * 进入学生成绩图表页面
	 * @param session
	 * @param stuId
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/gotoStudentRecordPage")
	@Auth
	public String gotoStudentRecordPage(HttpSession session,String stuId,Model model) throws Exception
	{

		if(StringUtils.isEmpty(stuId))
		{
			stuId = getSessionUserId(session);
		}

		List<String> stuRankLabel = eduRecordInfoService.getStudentRecordTerm(stuId);
		List<Map<String,Object>> stuRankData = eduRecordInfoService.getStudentScoreRecord(stuId);

		String stuRankLabelStr = JSONObject.toJSONString(stuRankLabel);
		String stuRankDataStr = JSONObject.toJSONString(stuRankData);

		model.addAttribute("stuRankLabelStr",stuRankLabelStr);
		model.addAttribute("stuRankDataStr",stuRankDataStr);
		model.addAttribute("riStuId",stuId);
		model.addAttribute("flag","1");

		return "/edu/eduStudentRecordInfoPage";
	}

	/**
	 * 获取班级成绩统计信息
	 * @param session
	 * @param eduRecordInfoForm
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping("/listStudentRecord")
	@Auth
	public PageDataBunder listStudentRecord(HttpServletRequest request, HttpSession session,EduRecordInfoForm eduRecordInfoForm) throws Exception
	{
		EduRecordInfo eduRecordInfo = new EduRecordInfo();

		BeanUtils.copyProperties(eduRecordInfo, eduRecordInfoForm);
		PageDataBunder pb = eduRecordInfoService.listStudentRecordInfo(eduRecordInfo,getPage(request));
		BusUtil.formatShowRecord((List<EduRecordInfo>) pb.getRows());

		return pb;
	}

	/**
	 * 下载班级成绩统计表
	 * @param request
	 * @param response
	 * @param eduRecordInfo
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/downloadClassRecord")
	@Auth
	public String downloadClassRecord(HttpServletRequest request,HttpServletResponse response,EduRecordInfo eduRecordInfo) throws Exception
	{
		String filePath = eduRecordInfoService.downloadClassRecord(eduRecordInfo);

		String fileName = BusUtil.getClassDescFromCode(eduRecordInfo.getRiClass())  +"成绩统计表.xlsx";

		commonDownLoadFile(fileName,filePath,request,response);

		return null;
	}

	/**
	 * 下载班级成绩统计表
	 * @param request
	 * @param response
	 * @param eduRecordInfo
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/downloadSchoolRecord")
	@Auth
	public String downloadSchoolRecord(HttpServletRequest request,HttpServletResponse response,EduRecordInfo eduRecordInfo) throws Exception
	{
		String filePath = eduRecordInfoService.downloadSchoolStatic(eduRecordInfo);

		String fileName = BusUtil.getTermNameFromCode(eduRecordInfo.getRiTerm())  +"教学质量检测成绩统计表.xlsx";

		commonDownLoadFile(fileName,filePath,request,response);

		return null;
	}

	/**
	 * 计算成绩
	 * @param riTerm
	 * @param riMidTerm
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping("/computeStatic")
	@Auth
	public JsonResult computeStatic(String riTerm,String riMidTerm) throws Exception
	{
		EduRecordInfo paramBean = new EduRecordInfo();
		paramBean.setRiTerm(riTerm);
		paramBean.setRiMidTerm(riMidTerm);
		RecordComputeUtil.computeRecord(paramBean.getRiTerm(),paramBean.getRiMidTerm());
		RecordComputeUtil.computeStatics(paramBean.getRiTerm(),paramBean.getRiMidTerm());

		return packJsonResult(true);
	}
}
