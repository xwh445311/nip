package com.efs.bus.edu.semcal.controller;

import com.efs.bus.edu.semcal.mapper.BaseSemesterCal;
import com.efs.bus.edu.semcal.service.BaseSemesterCalService;
import com.efs.common.Util.SysUtils;
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
import java.time.LocalDate;

/**
 * 
 * com.efs.bus.edu.semcal.mapper.BaseSemesterCalController
 * @author xwh
 * 2018-04-24 17:16:20
 * 学期日历
 *
 */
@Controller
@RequestMapping("/edu/semesterCal")
public class BaseSemesterCalController extends BaseController
{
	@Resource(name="baseSemesterCalService")
	private BaseSemesterCalService baseSemesterCalService;
	
	/**
	 * 进入BaseSemesterCal页面
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/gotoBaseSemesterCalPage")
	@Auth
	public String gotoBaseSemesterCalPage() throws Exception
	{
		return "/edu/baseSemesterCalPage";
	}
	
	/**
	 * 查询BaseSemesterCalGrid列表
	 * @param paramBean
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/listBaseSemesterCal")
	@Auth
	public PageDataBunder listBaseSemesterCal(HttpSession session,HttpServletRequest request,BaseSemesterCalForm baseSemesterCalForm) throws Exception
	{
		BaseSemesterCal baseSemesterCal = new BaseSemesterCal();
		
		BeanUtils.copyProperties(baseSemesterCal, baseSemesterCalForm);
		return baseSemesterCalService.listBaseSemesterCal(baseSemesterCal,getPage(request));
	}
	
	/**
	 * 查询单个BaseSemesterCal信息
	 * @param roleDbId
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getBaseSemesterCal")
	@Auth
	public BaseSemesterCal getBaseSemesterCal(String scTerm) throws Exception
	{
		return baseSemesterCalService.getBaseSemesterCal(scTerm);
	}
	
	/**
	 * 新增BaseSemesterCal信息
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/addBaseSemesterCal")
	@Auth("role_addBaseSemesterCal")
	public JsonResult addBaseSemesterCal(HttpSession session, HttpServletResponse resp, BaseSemesterCalForm baseSemesterCalForm) throws Exception
	{
		BaseSemesterCal baseSemesterCal = new BaseSemesterCal();
		BeanUtils.copyProperties(baseSemesterCal, baseSemesterCalForm);
		SysUtils.packAddObjectProp(getSessionUserId(session),baseSemesterCal);
		baseSemesterCal.setScTerm(baseSemesterCal.getScYear() + baseSemesterCal.getScHalfYear());
		baseSemesterCalService.addBaseSemesterCal(baseSemesterCal);
		return packJsonResult4Form(true, resp);
	}
	
	/**
	 * 更新BaseSemesterCal信息
	 * @param roleDbId
	 * @return
	 */
	@RequestMapping(value="/updateBaseSemesterCal")
	@ResponseBody
	@Auth("role_updateBaseSemesterCal")
	public JsonResult updateBaseSemesterCal(HttpSession session,HttpServletResponse resp,BaseSemesterCalForm baseSemesterCalForm) throws Exception
	{
		BaseSemesterCal baseSemesterCal = new BaseSemesterCal();
		BeanUtils.copyProperties(baseSemesterCal, baseSemesterCalForm);
		SysUtils.packAddObjectProp(getSessionUserId(session),baseSemesterCal);
		baseSemesterCalService.updateBaseSemesterCal(baseSemesterCal);
		return packJsonResult4Form(true, resp);
	}
	
	/**
	 * 刪除BaseSemesterCal
	 * @param roleId
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping("/deleteBaseSemesterCal")
	@Auth("role_deleteBaseSemesterCal")
	public JsonResult deleteBaseSemesterCal(String scTerm) throws Exception
	{
		baseSemesterCalService.deleteBaseSemesterCal(scTerm);
		return packJsonResult(true);
	}

	/**
	 * 检查学期是否已经存在
	 * @param scTerm
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping("/checkBaseSemesterCalExists")
	@Auth
	public String checkBaseSemesterCalExists(String scTerm) throws Exception
	{
		BaseSemesterCal cal = baseSemesterCalService.getBaseSemesterCal(scTerm);

		String res = cal == null ? "true" : "false";
		return res;
	}

	/**
	 * 检查当前系统日期是否在学期范围内
	 * @param scTerm
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping("/checkCurInTerm")
	@Auth
	public JsonResult checkCurInTerm(String scTerm) throws Exception
	{
		BaseSemesterCal cal = baseSemesterCalService.getBaseSemesterCal(scTerm);
		LocalDate endDate  = LocalDate.parse(cal.getScEndDate());
		LocalDate nowDate = LocalDate.now();
		String res ;

		if(nowDate.isBefore(endDate))
		{
			//当前系统日期在学期范围内
			res = "Y";
		}
		else
		{
			res = "N";
		}

		return packJsonResult(true,res);
	}
}
