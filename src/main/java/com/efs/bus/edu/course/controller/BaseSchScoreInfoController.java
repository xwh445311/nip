package com.efs.bus.edu.course.controller;

import com.efs.bus.edu.course.mapper.BaseSchScoreInfo;
import com.efs.bus.edu.course.service.BaseSchScoreInfoService;
import com.efs.common.Util.IDUtil;
import com.efs.common.Util.SysUtils;
import com.efs.common.controller.BaseController;
import com.efs.common.controller.JsonResult;
import com.efs.common.database.PageDataBunder;
import com.efs.common.interceptor.Auth;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 
 * com.efs.bus.edu.course.mapper.BaseSchScoreInfoController
 * @author xwh
 * 2018-05-03 15:44:12
 * 学校学期内开课信息表
 *
 */
@Controller
@RequestMapping("/edu/course")
public class BaseSchScoreInfoController extends BaseController
{
	@Resource(name="baseSchScoreInfoService")
	private BaseSchScoreInfoService baseSchScoreInfoService;
	
	/**
	 * 进入BaseSchScoreInfo页面
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/gotoBaseSchScoreInfoPage")
	@Auth
	public String gotoBaseSchScoreInfoPage() throws Exception
	{
		return "/edu/baseCoursesPage";
	}
	
	/**
	 * 查询BaseSchScoreInfoGrid列表
	 * @param paramBean
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/listBaseSchScoreInfo")
	@Auth
	public PageDataBunder listBaseSchScoreInfo(HttpSession session,HttpServletRequest request,BaseSchScoreInfoForm baseSchScoreInfoForm) throws Exception
	{
		BaseSchScoreInfo baseSchScoreInfo = new BaseSchScoreInfo();
		
		BeanUtils.copyProperties(baseSchScoreInfo, baseSchScoreInfoForm);
		return baseSchScoreInfoService.listBaseSchScoreInfo(baseSchScoreInfo,getPage(request));
	}
	
	/**
	 * 查询单个BaseSchScoreInfo信息
	 * @param roleDbId
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getBaseSchScoreInfo")
	@Auth
	public BaseSchScoreInfo getBaseSchScoreInfo(String ssId) throws Exception
	{
		return baseSchScoreInfoService.getBaseSchScoreInfo(ssId);
	}
	
	/**
	 * 新增BaseSchScoreInfo信息
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/addBaseSchScoreInfo")
	@Auth("role_addBaseSchScoreInfo")
	public JsonResult addBaseSchScoreInfo(HttpSession session,HttpServletResponse resp,BaseSchScoreInfoForm baseSchScoreInfoForm) throws Exception
	{
		BaseSchScoreInfo baseSchScoreInfo = new BaseSchScoreInfo();
		BeanUtils.copyProperties(baseSchScoreInfo, baseSchScoreInfoForm);

		baseSchScoreInfo.setSsId(IDUtil.getId("ID_COURSES_CODE"));

		SysUtils.packAddObjectProp(getSessionUser(session),baseSchScoreInfo);
		baseSchScoreInfoService.addBaseSchScoreInfo(baseSchScoreInfo);
		return packJsonResult4Form(true, resp);
	}
	
	/**
	 * 更新BaseSchScoreInfo信息
	 * @param roleDbId
	 * @return
	 */
	@RequestMapping(value="/updateBaseSchScoreInfo")
	@ResponseBody
	@Auth("role_updateBaseSchScoreInfo")
	public JsonResult updateBaseSchScoreInfo(HttpSession session,HttpServletResponse resp,BaseSchScoreInfoForm baseSchScoreInfoForm) throws Exception
	{
		BaseSchScoreInfo baseSchScoreInfo = new BaseSchScoreInfo();
		BeanUtils.copyProperties(baseSchScoreInfo, baseSchScoreInfoForm);
		SysUtils.packUpdObjectProp(getSessionUser(session),baseSchScoreInfo);
		baseSchScoreInfoService.updateBaseSchScoreInfo(baseSchScoreInfo);
		return packJsonResult4Form(true, resp);
	}
	
	/**
	 * 刪除BaseSchScoreInfo
	 * @param roleId
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping("/deleteBaseSchScoreInfo")
	@Auth("role_deleteBaseSchScoreInfo")
	public JsonResult deleteBaseSchScoreInfo(String ssId) throws Exception
	{
		baseSchScoreInfoService.deleteBaseSchScoreInfo(ssId);
		return packJsonResult(true);
	}

	@ResponseBody
	@RequestMapping("/batchCopyScore")
	@Auth("role_addBaseSchScoreInfo")
	public JsonResult batchCopyScore(HttpSession session,HttpServletResponse resp,BaseSchScoreInfoForm baseSchScoreInfoForm) throws Exception
	{
		BaseSchScoreInfo baseSchScoreInfo = new BaseSchScoreInfo();
		BeanUtils.copyProperties(baseSchScoreInfo, baseSchScoreInfoForm);
		String errMsg = "";
		boolean chkRes = false ;

		//对上上传内容进行检查
		if(StringUtils.isEmpty(baseSchScoreInfo.getNewSsTerm()))
		{
			errMsg = "新学期必须指定\n";
		}

		if((StringUtils.isEmpty(baseSchScoreInfo.getNewClasses()) && StringUtils.isNotEmpty(baseSchScoreInfo.getSsClass())) ||
				(StringUtils.isNotEmpty(baseSchScoreInfo.getNewClasses()) && StringUtils.isEmpty(baseSchScoreInfo.getSsClass())))
		{
			errMsg = "原班级与新的班级必须同时指定或同时不指定\n";
		}

		//检查是否已经分配了课程
		chkRes = baseSchScoreInfoService.checkTermHasCourse(baseSchScoreInfo.getNewSsTerm(),baseSchScoreInfo.getNewClasses());
		if(chkRes)
		{
			errMsg = "指定的学期或班级已经分配了课程\n";
		}

		//校验失败返回
		if(StringUtils.isNotEmpty(errMsg))
		{
			return packJsonResult4Form(false,errMsg,resp);
		}

		SysUtils.packAddObjectProp(getSessionUser(session),baseSchScoreInfo);
		baseSchScoreInfoService.copyBaseSchScoreInfo(baseSchScoreInfo);
		return packJsonResult4Form(true, resp);
	}


}
