package com.efs.bus.edu.classes.controller;

import com.efs.bus.edu.classes.mapper.BaseSchClassInfo;
import com.efs.bus.edu.classes.service.BaseSchClassInfoService;
import com.efs.bus.util.BusUtil;
import com.efs.common.Util.SysUtils;
import com.efs.common.auth.user.mapper.TsUserInfo;
import com.efs.common.auth.user.service.TsUserInfoService;
import com.efs.common.controller.BaseController;
import com.efs.common.controller.JsonResult;
import com.efs.common.database.PageDataBunder;
import com.efs.common.interceptor.Auth;
import com.xwh.bean.SelectBean;
import com.xwh.util.EFSUtil;
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
import java.util.List;

/**
 * 
 * com.efs.bus.edu.classes.mapper.BaseSchClassInfoController
 * @author xwh
 * 2018-04-26 20:43:12
 * 学校班级设置信息表
 *
 */
@Controller
@RequestMapping("/edu/classes")
public class BaseSchClassInfoController extends BaseController
{
	@Resource(name="baseSchClassInfoService")
	private BaseSchClassInfoService baseSchClassInfoService;

	@Resource(name="tsUserInfoService")
	private TsUserInfoService tsUserInfoService;

	/**
	 * 进入BaseSchClassInfo页面
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/gotoBaseSchClassInfoPage")
	@Auth
	public String gotoBaseSchClassInfoPage(Model model) throws Exception
	{
		TsUserInfo param = new TsUserInfo();
		param.setUtWorkStatus("01");
		List<TsUserInfo> teacherList = tsUserInfoService.listTeacherInfoNoPage(param);

		model.addAttribute("teacherList",teacherList);
		return "/edu/baseClassesPage";
	}
	
	/**
	 * 查询BaseSchClassInfoGrid列表
	 * @param paramBean
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/listBaseSchClassInfo")
	@Auth
	public PageDataBunder listBaseSchClassInfo(HttpSession session,HttpServletRequest request,BaseSchClassInfoForm baseSchClassInfoForm) throws Exception
	{
		BaseSchClassInfo baseSchClassInfo = new BaseSchClassInfo();
		
		BeanUtils.copyProperties(baseSchClassInfo, baseSchClassInfoForm);
		return baseSchClassInfoService.listBaseSchClassInfo(baseSchClassInfo,getPage(request));
	}
	
	/**
	 * 查询单个BaseSchClassInfo信息
	 * @param roleDbId
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getBaseSchClassInfo")
	@Auth
	public BaseSchClassInfo getBaseSchClassInfo(String scId) throws Exception
	{
		return baseSchClassInfoService.getBaseSchClassInfo(scId);
	}
	
	/**
	 * 新增BaseSchClassInfo信息
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/addBaseSchClassInfo")
	@Auth("role_addBaseSchClassInfo")
	public JsonResult addBaseSchClassInfo(HttpSession session, HttpServletResponse resp, String scTerm,int gradeCnt,int clsCnt) throws Exception
	{
		baseSchClassInfoService.batchAddClasses(scTerm,gradeCnt,clsCnt,getSessionUserId(session));
		return packJsonResult4Form(true, resp);
	}
	
	/**
	 * 更新BaseSchClassInfo信息
	 * @param roleDbId
	 * @return
	 */
	@RequestMapping(value="/updateBaseSchClassInfo")
	@ResponseBody
	@Auth("role_updateBaseSchClassInfo")
	public JsonResult updateBaseSchClassInfo(HttpSession session,HttpServletResponse resp,BaseSchClassInfoForm baseSchClassInfoForm) throws Exception
	{
		BaseSchClassInfo baseSchClassInfo = new BaseSchClassInfo();
		BeanUtils.copyProperties(baseSchClassInfo, baseSchClassInfoForm);
		SysUtils.packUpdObjectProp(getSessionUserId(session),baseSchClassInfo);
		baseSchClassInfoService.updateBaseSchClassInfo(baseSchClassInfo);
		return packJsonResult4Form(true, resp);
	}
	
	/**
	 * 刪除BaseSchClassInfo
	 * @param roleId
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping("/deleteBaseSchClassInfo")
	@Auth("role_deleteBaseSchClassInfo")
	public JsonResult deleteBaseSchClassInfo(String scId) throws Exception
	{
		baseSchClassInfoService.deleteBaseSchClassInfo(scId);
		return packJsonResult(true);
	}

	/**
	 * 校验班主任是否已经在别的班安排工作了
	 * @param paramBean
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping("/checkClassLeaderExist")
	@Auth
	public String checkClassLeaderExist(BaseSchClassInfo paramBean) throws Exception
	{
		boolean res = baseSchClassInfoService.checkClassLeaderExist(paramBean);

		if(res)
		{
			return "false";
		}
		else
		{
			return "true";
		}
	}

	/**
	 * 校验是否可以删除班级信息
	 * @param scId
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping("/checkCanDelClass")
	@Auth
	public JsonResult checkCanDelClass(String scId) throws Exception
	{
		return packJsonResult(baseSchClassInfoService.checkCanDelClass(scId));
	}

	/**
	 * 根据学期获得班级的下拉框
	 * @param scId
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping("/listClassSelectListFromTerm")
	@Auth
	public JsonResult listClassSelectListFromTerm(String term) throws Exception
	{
		BaseSchClassInfo paramBean = new BaseSchClassInfo();
		paramBean.setScTerm(term);
		List<BaseSchClassInfo> classInfoList = baseSchClassInfoService.listBaseSchClassInfoNoPage(paramBean);

		List<SelectBean> selectBeanList = EFSUtil.convertBeanToSelectBean(classInfoList,"scClassCode","scClassName");
		return packJsonResult(true,selectBeanList);
	}

	/**
	 * 检查当前用户是否为某班的班主任
	 * @param scId
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping("/checkCurUserIsClassLeader")
	@Auth
	public JsonResult checkCurUserIsClassLeader(HttpSession session, String scTerm,String scClass) throws Exception
	{
		boolean res = baseSchClassInfoService.checkUserIsClassLeader(scTerm,scClass,getSessionUserId(session));

		return packJsonResult(res);
	}

	/**
	 * 单笔添加班级
	 * @param session
	 * @param baseSchClassInfoForm
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping("/addSingleClass")
	@Auth
	public JsonResult addSingleClass(HttpSession session,BaseSchClassInfoForm baseSchClassInfoForm) throws Exception
	{
		BaseSchClassInfo baseSchClassInfo = new BaseSchClassInfo();
		BeanUtils.copyProperties(baseSchClassInfo, baseSchClassInfoForm);
		SysUtils.packAddObjectProp(getSessionUserId(session),baseSchClassInfo);

		String clasCode = StringUtils.leftPad(baseSchClassInfo.getScGrade().toString(),2,'0')
						+ StringUtils.leftPad(baseSchClassInfo.getScCls().toString(),2,'0');

		baseSchClassInfo.setScClassCode(clasCode);
		baseSchClassInfo.setScClassName(BusUtil.getClassDescFromCode(clasCode));
		baseSchClassInfoService.addBaseSchClassInfo(baseSchClassInfo);

		return packJsonResult(true);
	}
}
