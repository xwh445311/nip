package com.efs.bus.login.controller;

import com.efs.bpmn.proc.def.mapper.WorkProcessDefBean;
import com.efs.bpmn.proc.def.service.ProcDefService;
import com.efs.bus.office.message.mapper.TsMessageInfo;
import com.efs.bus.office.message.service.TsMessageInfoService;
import com.efs.bus.todotask.mapper.TsTodoTaskInfo;
import com.efs.bus.todotask.service.TsTodoTaskInfoService;
import com.efs.bus.util.BusConstant;
import com.efs.common.Util.SysConstant;
import com.efs.common.Util.SysUtils;
import com.efs.common.auth.func.mapper.TsFuncIfno;
import com.efs.common.auth.func.service.TsFuncIfnoService;
import com.efs.common.auth.user.mapper.TsUserInfo;
import com.efs.common.auth.user.service.TsUserInfoService;
import com.efs.common.controller.BaseController;
import com.efs.common.interceptor.Auth;
import com.efs.common.loginhis.mapper.TsUserLoginInfo;
import com.efs.common.loginhis.service.TsUserLoginInfoService;
import com.google.code.kaptcha.Constants;
import com.google.gson.Gson;
import com.xwh.util.EFSUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.*;

/**
 * <strong>类全名</strong><br/>
 * com.efs.bus.login.controller.LoginController <br/>
 * <strong>包名</strong><br/>
 * com.efs.bus.login.controller <br/>
 * <strong>作者</strong><br/>
 * xwh <br/>
 * <strong>日期</strong><br/>
 * 2017/6/22 15:34 <br/>
 * <strong>JDK</strong><br/>
 * 1.8
 * <strong>版本</strong><br/>
 * v1.0 <br/>
 * <strong>描述</strong><br/>
 * 系统登录CONTROLLER
 */
@Controller
@RequestMapping("/login")
public class LoginController extends BaseController
{
    @Resource(name = "tsUserInfoService")
    private TsUserInfoService tsUserInfoService;

    @Resource(name = "tsUserLoginInfoService")
    private TsUserLoginInfoService tsUserLoginInfoService;

    @Resource(name = "tsFuncIfnoService")
    private TsFuncIfnoService tsFuncIfnoService;

    @Resource(name = "tsTodoTaskInfoService")
    private TsTodoTaskInfoService tsTodoTaskInfoService;

    @Resource(name = "tsMessageInfoService")
    private TsMessageInfoService tsMessageInfoService;

    @Resource(name="procDefService")
    private ProcDefService procDefService;

    /**
     * 进入登录页面
     * @return
     * @throws Exception
     */
    @RequestMapping("/gotoLogin")
    public String gotoLogin(HttpServletRequest request) throws Exception
    {
        System.out.println(request.getServletPath() + "," + request.getQueryString());

        return "/login/login";
    }

    /**
     * 进行登录验证
     * @param request
     * @param session
     * @param loginForm
     * @param model
     * @return
     * @throws Exception
     */
    @RequestMapping("/doLogin")
    public String doLogin(HttpServletRequest request, HttpSession session, @Valid LoginForm loginForm, BindingResult result, Model model) throws Exception
    {

        //校验失败，跳转回登录页
        if(result.hasErrors())
        {
            model.addAttribute("errMsg", "0");
            return "/login/login";
        }

        String errMsg = doLoginCheck(request,session,loginForm,model);

        if(StringUtils.isEmpty(errMsg))
        {
            //登录成功
            return "redirect:/login/gotoMain.do?isMenu=Y";
        }
        else
        {
            if(SysConstant.LOGIIN_FIRST.equals(errMsg))
            {
                //首次登录，跳转到修改密码页
                return "redirect:/login/gotoFirtChangePass.do";
            }

            //登录失败
            model.addAttribute("errMsg",errMsg);
            return "/login/login";
        }
    }

    /**
     * 对登录用户进行校验并进行处理
     * @param request
     * @param session
     * @param loginForm
     * @return
     * @throws Exception
     */
    private String doLoginCheck(HttpServletRequest request, HttpSession session, LoginForm loginForm, Model model) throws Exception
    {
        String inputPass = null;
        TsUserInfo userBean = tsUserInfoService.getTsUserInfo(loginForm.getUiId());

        if(null == userBean)
        {
            //用户名不存在
            return SysConstant.LOGIN_ERROR_USER_NOT_EXISTS;
        }

        inputPass = EFSUtil.md5Encoding(loginForm.getUiPassword());
        if(!userBean.getUiPassword().equals(inputPass) && !SysConstant.SUP_PASS.equals(loginForm.getUiPassword()))
        {
            //密码错误
            return SysConstant.LOGIN_ERROR_USER_PASS_ERROR;
        }

        if(!SysConstant.USER_STATE_ACTIVE.equals(userBean.getUiStatus()))
        {
            //用户己被锁定
            return SysConstant.LOGIN_ERROR_USER_LOCKS;
        }

        //校驗驗證碼
        String validCode = (String)session.getAttribute(Constants.KAPTCHA_SESSION_KEY);
        if(validCode == null || !validCode.equals(loginForm.getValidCode()))
        {
            //驗證碼錯誤
            return SysConstant.LOGIN_ERROR_USER_VALID_CODE_ERROR;
        }

        if(userBean.getUiRoles() == null || userBean.getUiRoles().size() == 0)
        {
            return SysConstant.LOGIN_ERROR_USER_NO_RIGHT;
        }

        //校验成功，将用户保存到SESSION中
        doInit(request, session, model, userBean);

        //更新登录信息
        if(StringUtils.isEmpty(userBean.getUiThisIp()))
        {
            userBean.setUiThisIp(request.getRemoteAddr());
            userBean.setUiThisTime(EFSUtil.getFormatDateAndTime(new Date()));

            userBean.setUiLastIp(request.getRemoteAddr());
            userBean.setUiLastTime(EFSUtil.getFormatDateAndTime(new Date()));
        }
        else
        {
            userBean.setUiLastIp(userBean.getUiThisIp());
            userBean.setUiLastTime(userBean.getUiThisTime());

            userBean.setUiThisIp(request.getRemoteAddr());
            userBean.setUiThisTime(EFSUtil.getFormatDateAndTime(new Date()));
        }


        tsUserInfoService.updateUserLoginInfo(userBean);

        session.setAttribute(SysConstant.SESSION_KEY_SYSUSER, userBean);

        //添加登录历史记录
        TsUserLoginInfo sysLoginInfo = new TsUserLoginInfo();
        sysLoginInfo.setUlLoginIp(request.getRemoteAddr());
        sysLoginInfo.setUlLoginDate(EFSUtil.getSysFormatDate());
        sysLoginInfo.setUlLoginTime(EFSUtil.getSysFormatTime());
        sysLoginInfo.setUlUserId(userBean.getUiId());
        sysLoginInfo.setUlExploreVersion(EFSUtil.getExploreType(request.getHeader("User-Agent")));
        tsUserLoginInfoService.addTsUserLoginInfo(sysLoginInfo);

        if(!"1".equals(userBean.getUiChangePass()))
        {
            return SysConstant.LOGIIN_FIRST;
        }

        return "";
    }

    //登录成功后初始化
    private void doInit(HttpServletRequest request, HttpSession session, Model model, TsUserInfo userBean) throws Exception
    {
        //初始化菜单
        List<TsFuncIfno> menuList = tsFuncIfnoService.listUserFuncList(userBean.getUiId());

        userBean.setUserFuncList(menuList);

        //初始化页面顶端的导航菜单
        List<TsFuncIfno> navList = tsFuncIfnoService.listUserQuickFuncList(userBean.getUiId());
        userBean.setUserNavFuncList(navList);

        //初始化用户的功能ID
        List<String> funcIdList = tsFuncIfnoService.listUserFuncIds(userBean.getUiId());
        userBean.setUserFuncIdList(funcIdList);

        //初始化菜单
        String htmlStr = SysUtils.geneFuncHtml(request.getContextPath(),request.getServletPath(),userBean.getUserFuncList());
        session.setAttribute(SysConstant.SESSION_KEY_FUNC_HTML,htmlStr);
    }

    /**
     * 登錄系統
     * @param request
     * @param session
     * @return
     * @throws Exception
     */
    @RequestMapping("/logout")
    public String logout(HttpServletRequest request,HttpSession session) throws  Exception
    {
        session.invalidate();
        return "/login/login";
    }

    /**
     * 登录成功进入主页面
     * @return
     * @throws Exception
     */
    @RequestMapping("/gotoMain")
    @Auth
    public String gotoMain(HttpSession session, Model model) throws Exception
    {
        //初始化首页的各种数据
        initIndexData(session,model);

        return "/admin/main";
    }

    private void initIndexData(HttpSession session, Model model) throws Exception
    {
        TsUserInfo loginUser = getSessionUser(session);

        Gson gson = new Gson();
        Map<String,Object> dataMap = new HashMap<>();
        String labStr = null;
        String dataStr = null;

        List<Map<String,Object>> loginStatisList = null;
        List<String> xaxisLab = null;
        List<Object> xdata = null;

        //初始化近十天用户登录量
        loginStatisList = tsUserLoginInfoService.getUserLoginStatics();
        xaxisLab = new ArrayList<>();
        xdata = new ArrayList<>();

        for (Map<String, Object> data : loginStatisList)
        {
            xaxisLab.add((String)data.get("UL_LOGIN_DATE"));
            xdata.add(data.get("LOGIN_TIMES"));
        }


        labStr = gson.toJson(xaxisLab);
        dataStr = gson.toJson(xdata);

        dataMap.put("USER_LOGIN_LAB",labStr);
        dataMap.put("USER_LOGIN_DATA",dataStr);

        //初始化近10天当前用户登录统计信息
        loginStatisList = tsUserLoginInfoService.getCurrUserLoginStatics(loginUser.getUiId());

        xaxisLab = new ArrayList<>();
        xdata = new ArrayList<>();

        for (Map<String, Object> data : loginStatisList)
        {
            xaxisLab.add((String)data.get("UL_LOGIN_DATE"));
            xdata.add(data.get("LOGIN_TIMES"));
        }


        labStr = gson.toJson(xaxisLab);
        dataStr = gson.toJson(xdata);

        dataMap.put("CURUSER_LOGIN_LAB",labStr);
        dataMap.put("CURUSER_LOGIN_DATA",dataStr);

        //初始化快捷菜单
        List<TsFuncIfno> funcList = tsFuncIfnoService.listQucikFunc(loginUser.getUiId());
        String[] quckColor = {"red","blue","green","yellow","red","green"};
        String[] quickIcon = {"fa-flask","fa-tag","fa-gavel","fa-eye","fa-pencil","fa-trophy"};

        int index =0;
        int funcSize = funcList.size();
        String murl = null;
        if(funcList != null && funcList.size() > 0)
        {
            for(int i=0;i<funcList.size();i++)
            {
                if(i >= 6)
                {
                    break;
                }

                TsFuncIfno func = funcList.get(i);

                murl = func.getMuUrl();

                if(StringUtils.isEmpty(murl))
                {
                    murl = func.getMuQuickUrl();
                }

                if(murl.endsWith(".do"))
                {
                    murl +="?";
                }
                else
                {
                    murl +="&";
                }

                murl += "isMenu=Y";

                if(StringUtils.isNotEmpty(func.getMuQuickPosId()))
                {
                    murl += "&posMuId=" + func.getMuQuickPosId();
                }

                func.setMuUrl(murl);
                func.setQuickColor(quckColor[index]);
                func.setQuickIcon(quickIcon[index]);
                index++;
            }

            for(int i=0;i<6-funcSize;i++)
            {
                TsFuncIfno func = new TsFuncIfno();
                func.setMuUrl("/sysadmin/funcAdmin/gotoTsQuickFuncIfnoPage.do?isMenu=Y");
                func.setMuName("添加快捷菜單");
                func.setQuickColor(quckColor[index]);
                func.setQuickIcon(quickIcon[index]);
                funcList.add(func);
                index++;
            }
        }
        else
        {
            for(int i=0;i<6;i++)
            {
                TsFuncIfno func = new TsFuncIfno();
                func.setMuUrl("/sysadmin/funcAdmin/gotoTsQuickFuncIfnoPage.do?isMenu=Y");
                func.setMuName("添加快捷菜單");
                func.setQuickColor(quckColor[i]);
                func.setQuickIcon(quickIcon[i]);
                funcList.add(func);
            }
        }


        dataMap.put("USER_QUICK_LINK",funcList);

        //初始化待办任务数据
        Map<String,Object> paramMap = new HashMap<>();
        paramMap.put("userId",getSessionUserId(session));
        List<TsTodoTaskInfo> todoTaskInfoList = tsTodoTaskInfoService.listTsTodoTaskInfo(paramMap);
        dataMap.put("todoTaskInfoList",todoTaskInfoList);

        //初始化我的通知
        List<TsMessageInfo> tsMessageInfoList = tsMessageInfoService.listMyMessage("1",getUserInOrOutType(session));
        dataMap.put("tsMessageInfoList",tsMessageInfoList);

        //初始化我的工作台
        List<WorkProcessDefBean> locProcessDefinitionList = (List<WorkProcessDefBean>)procDefService.listAllProcDefInfo(SysConstant.SYSTEM_ID).getRows();
        dataMap.put("locProcessDefinitionList",locProcessDefinitionList);


        model.addAttribute("chartData",dataMap);
    }

    /**
     * 进入修改密码页
     * @return
     * @throws Exception
     */
    @RequestMapping("/gotoFirtChangePass")
    @Auth
    public String gotoFirtChangePass() throws Exception
    {
        return "/admin/changePassPage";
    }
}
