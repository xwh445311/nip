package com.efs.bpmn.proc.def.controller;

import com.efs.bpmn.proc.def.mapper.WorkProcessDefBean;
import com.efs.bpmn.proc.def.service.ProcDefService;
import com.efs.common.controller.BaseController;
import com.efs.common.interceptor.Auth;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;

/**
 * <strong>类全名</strong><br/>
 * com.efs.bpmn.proc.def.controller.ProcDefController <br/>
 * <strong>包名</strong><br/>
 * com.efs.bpmn.proc.def.controller <br/>
 * <strong>作者</strong><br/>
 * xwh <br/>
 * <strong>日期</strong><br/>
 * 2018/6/21 14:37 <br/>
 * <strong>JDK</strong><br/>
 * 1.8
 * <strong>版本</strong><br/>
 * v1.0 <br/>
 * <strong>描述</strong><br/>
 * 流程定义控制器
 */
@Controller
@RequestMapping("/bpmn/procDef")
public class ProcDefController extends BaseController
{
    @Resource(name="procDefService")
    private ProcDefService procDefService;

    /**
     * 下載圖片
     * @param wokProsId
     * @param request
     * @param response
     * @throws Exception
     */
    @RequestMapping("/showProcessDefImag")
    @Auth
    public void showProcessDefImag(String wokProsId, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        WorkProcessDefBean procBean = procDefService.getProcDef(wokProsId);
        InputStream is = null;

        is = procDefService.getProcessDefImage(wokProsId);
        commonDownLoadFile(procBean.getWokProsImgName(), "image/png", is, request, response);
    }
}
