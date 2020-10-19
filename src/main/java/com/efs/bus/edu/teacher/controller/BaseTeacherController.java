package com.efs.bus.edu.teacher.controller;

import com.efs.common.auth.user.controller.TsUserInfoForm;
import com.efs.common.auth.user.mapper.TsUserInfo;
import com.efs.common.auth.user.service.TsUserInfoService;
import com.efs.common.controller.BaseController;
import com.efs.common.controller.JsonResult;
import com.efs.common.database.PageDataBunder;
import com.efs.common.interceptor.Auth;
import com.xwh.bean.SelectBean;
import com.xwh.excelupload.exception.ExcelUploadException;
import com.xwh.excelupload.util.ExcelUploadParser;
import com.xwh.util.EFSUtil;
import org.apache.commons.beanutils.BeanUtils;
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
import java.util.ArrayList;
import java.util.List;

/**
 * <strong>类全名</strong><br/>
 * com.efs.bus.edu.student.controller.BaseStudentController <br/>
 * <strong>包名</strong><br/>
 * com.efs.bus.edu.student.controller <br/>
 * <strong>作者</strong><br/>
 * xuwh <br/>
 * <strong>日期</strong><br/>
 * 2018/4/13 23:14 <br/>
 * <strong>JDK</strong><br/>
 * 1.8
 * <strong>版本</strong><br/>
 * v1.0 <br/>
 * <strong>描述</strong><br/>
 * 教师信息管理CONTROLLER
 */
@Controller
@RequestMapping("/edu/teacher")
public class BaseTeacherController extends BaseController
{

    @Resource(name="tsUserInfoService")
    private TsUserInfoService tsUserInfoService;

    /**
     * 进入学生管理页面
     * @param model
     * @return
     * @throws Exception
     */
    @RequestMapping("/gotoTeacherListPage")
    @Auth
    public String gotoTeacherListPage(Model model) throws Exception
    {
        return "/edu/baseTeacherPage";
    }

    /**
     * 查询TsUserInfoGrid列表
     * @param paramBean
     * @return
     */
    @ResponseBody
    @RequestMapping("/listTeacherInfo")
    @Auth
    public PageDataBunder listTeacherInfo(HttpSession session, HttpServletRequest request, TsUserInfoForm tsUserInfoForm) throws Exception
    {
        TsUserInfo tsUserInfo = new TsUserInfo();

        BeanUtils.copyProperties(tsUserInfo, tsUserInfoForm);

        return tsUserInfoService.listTeacherInfo(tsUserInfo,getPage(request));
    }

    /**
     * 新增TsUserInfo信息
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping("/addTsTeacherInfo")
    @Auth("role_addTsTeacherInfo")
    public JsonResult addTsTeacherInfo(HttpSession session, HttpServletResponse resp, TsUserInfoForm tsUserInfoForm) throws Exception
    {
        TsUserInfo tsUserInfo = new TsUserInfo();
        BeanUtils.copyProperties(tsUserInfo, tsUserInfoForm);

        List<TsUserInfo> userList = new ArrayList<>();
        userList.add(tsUserInfo);
        tsUserInfoService.addBatchTeacherInfo(userList,getSessionUserId(session));

        return packJsonResult4Form(true, resp);
    }

    /**
     * 更新学生信息
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping("/updTsTeacherInfo")
    @Auth("role_updTsTeacherInfo")
    public JsonResult updTsTeacherInfo(HttpSession session, HttpServletResponse resp, TsUserInfoForm tsUserInfoForm) throws Exception
    {
        TsUserInfo tsUserInfo = new TsUserInfo();
        TsUserInfo logUser = getSessionUser(session);
        BeanUtils.copyProperties(tsUserInfo, tsUserInfoForm);

        tsUserInfo.setUiUpdUser(logUser.getUiId());
        tsUserInfoService.updateTeacherInfo(tsUserInfo);

        return packJsonResult4Form(true, resp);
    }

    /**
     * 选择可以安排课程的老师下拉列表
     * @param ssTerm
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping("/listCanCourTeacher")
    @Auth
    public JsonResult listCanCourTeacher(String ssTerm) throws Exception
    {
        List<TsUserInfo> userInfoList;
        List<SelectBean> selectBeanList;
        TsUserInfo paramBean = new TsUserInfo();
        paramBean.setCanHasScore("Y");
        paramBean.setUtWorkStatus("01");
        paramBean.setScTerm(ssTerm);

        userInfoList = tsUserInfoService.listTeacherInfoNoPage(paramBean);
        selectBeanList = EFSUtil.convertBeanToSelectBean(userInfoList,"uiId",(Object obj)->{
            TsUserInfo userInfo = (TsUserInfo)obj;
            return "(" + userInfo.getUiShortName() + ")" + userInfo.getUiName();
        });

        return packJsonResult(true,selectBeanList);
    }

    /**
     * 根据查询条件批量打印教工条码
     * @param tsUserInfoForm
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping("/batchPrintTeacherBar")
    @Auth
    public JsonResult batchPrintTeacherBar(TsUserInfoForm tsUserInfoForm) throws Exception
    {
        TsUserInfo tsUserInfo = new TsUserInfo();
        BeanUtils.copyProperties(tsUserInfo, tsUserInfoForm);

        List<TsUserInfo> userInfoList = tsUserInfoService.listTeacherInfoNoPage(tsUserInfo);
        List<SelectBean> beanList = EFSUtil.convertBeanToSelectBean(userInfoList,"uiId","uiName");
        return packJsonResult(true,beanList);
    }
}
