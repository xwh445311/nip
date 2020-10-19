package com.efs.bus.upload.controller;

import com.efs.bus.util.BusUtil;
import com.efs.common.Util.SysConstant;
import com.efs.common.auth.user.controller.TsUserInfoForm;
import com.efs.common.auth.user.mapper.TsUserInfo;
import com.efs.common.auth.user.service.TsUserInfoService;
import com.efs.common.controller.BaseController;
import com.efs.common.controller.JsonResult;
import com.efs.common.database.PageDataBunder;
import com.efs.common.interceptor.Auth;
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
 * 模板下载
 */
@Controller
@RequestMapping("/fileModel")
public class FileModelController extends BaseController
{

    /**
     * 进入学生管理页面
     * @param model
     * @return
     * @throws Exception
     */
    @RequestMapping("/downLoadModel")
    @Auth
    public String downLoadModel(String modelId,HttpServletRequest request,HttpServletResponse response) throws Exception
    {
        String modelName = BusUtil.getFileModelName(modelId);
        String fullPath = SysConstant.SYSTEM_MODEL_PATH + modelName;

        commonDownLoadFile(modelName,fullPath,request,response);

        return null;
    }

}
