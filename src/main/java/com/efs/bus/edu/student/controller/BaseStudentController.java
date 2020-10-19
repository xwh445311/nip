package com.efs.bus.edu.student.controller;

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
 * 学生管理CONTROLLER
 */
@Controller
@RequestMapping("/edu/student")
public class BaseStudentController extends BaseController
{

    @Resource(name="tsUserInfoService")
    private TsUserInfoService tsUserInfoService;

    /**
     * 进入学生管理页面
     * @param model
     * @return
     * @throws Exception
     */
    @RequestMapping("/gotoStudnetListPage")
    @Auth
    public String gotoStudnetListPage(Model model) throws Exception
    {
        return "/edu/baseStudentPage";
    }

    /**
     * 查询TsUserInfoGrid列表
     * @param paramBean
     * @return
     */
    @ResponseBody
    @RequestMapping("/listStudentInfo")
    @Auth
    public PageDataBunder listStudentInfo(HttpSession session, HttpServletRequest request, TsUserInfoForm tsUserInfoForm) throws Exception
    {
        TsUserInfo tsUserInfo = new TsUserInfo();

        BeanUtils.copyProperties(tsUserInfo, tsUserInfoForm);

        return tsUserInfoService.listStudentInfo(tsUserInfo,getPage(request));
    }

    /**
     * 新增TsUserInfo信息
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping("/addTsStudentInfo")
    @Auth("role_addTsStudentInfo")
    public JsonResult addTsStudentInfo(HttpSession session, HttpServletResponse resp, TsUserInfoForm tsUserInfoForm) throws Exception
    {
        TsUserInfo tsUserInfo = new TsUserInfo();
        BeanUtils.copyProperties(tsUserInfo, tsUserInfoForm);

        List<TsUserInfo> userList = new ArrayList<>();
        userList.add(tsUserInfo);
        tsUserInfoService.addBatchStudentInfo(userList,getSessionUserId(session));

        return packJsonResult4Form(true, resp);
    }

    /**
     * 更新学生信息
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping("/updTsStudentInfo")
    @Auth("role_updTsStudentInfo")
    public JsonResult updTsStudentInfo(HttpSession session, HttpServletResponse resp, TsUserInfoForm tsUserInfoForm) throws Exception
    {
        TsUserInfo tsUserInfo = new TsUserInfo();
        TsUserInfo logUser = getSessionUser(session);
        BeanUtils.copyProperties(tsUserInfo, tsUserInfoForm);

        tsUserInfo.setUiUpdUser(logUser.getUiId());

        //默认角色为学生
        tsUserInfo.setUiMobile(tsUserInfo.getUsFirstPhone());
        tsUserInfoService.updateStudentInfo(tsUserInfo);

        return packJsonResult4Form(true, resp);
    }

    /**
     * 进入学生信息上传页面
     * @return
     * @throws Exception
     */
    @RequestMapping("/gotoStudentUploadPage")
    @Auth
    public String gotoStudentUploadPage() throws Exception
    {
        return "/edu/baseStudentUploadPage";
    }

    /**
     * 上传学生信息
     * @param uploadFile
     * @param session
     * @param model
     * @return
     * @throws Exception
     */
    @RequestMapping("/uploadStudentInfo")
    @Auth
    public String uploadStudentInfo(@RequestParam CommonsMultipartFile uploadFile,String usClass, HttpSession session, Model model) throws Exception
    {
        List<TsUserInfo> repeatUser = new ArrayList<>();
        List<TsUserInfo> validUser = new ArrayList<>();
        String msg = "";

        try
        {
            if(!uploadFile.isEmpty())
            {
                File f = transUploadFile(uploadFile);

                List<TsUserInfo> userList = ExcelUploadParser.parserExcel(f,"model_student");
                if(userList != null && userList.size() > 0)
                {
                    for(TsUserInfo user : userList)
                    {
                        user.setUsClass(usClass);
                        TsUserInfo dbUser = tsUserInfoService.getTsUserInfo(user.getUiId());
                        if(dbUser != null)
                        {
                            //已经存在，不能更新
                            repeatUser.add(user);
                        }
                        else
                        {
                            validUser.add(user);
                        }
                    }
                }
                tsUserInfoService.addBatchStudentInfo(validUser,getSessionUserId(session));

                msg = "上传完成，此次成功上传学生信息["+validUser.size()+"]笔，因为重复记录，["+repeatUser.size()+"]未上传！";
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

        model.addAttribute("msg",msg);
        model.addAttribute("repeatUser",repeatUser);
        return "/edu/baseStudentUploadPage";
    }

    /**
     * 根据查询条件批量打印学生条码
     * @param tsUserInfoForm
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping("/batchPrintStuentBar")
    @Auth
    public JsonResult batchPrintStuentBar(TsUserInfoForm tsUserInfoForm) throws Exception
    {
        TsUserInfo tsUserInfo = new TsUserInfo();
        BeanUtils.copyProperties(tsUserInfo, tsUserInfoForm);

        List<TsUserInfo> userInfoList = tsUserInfoService.listStudentNoPage(tsUserInfo);
        List<SelectBean> beanList = EFSUtil.convertBeanToSelectBean(userInfoList,"uiId","uiName");
        return packJsonResult(true,beanList);
    }

}
