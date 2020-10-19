package com.efs.common.interceptor;

import com.efs.common.Util.SysConstant;
import com.efs.common.Util.SysUtils;
import com.efs.common.auth.func.mapper.TsFuncIfno;
import com.efs.common.auth.func.service.TsFuncIfnoService;
import com.efs.common.auth.user.mapper.TsUserInfo;
import com.efs.common.noteinfo.mapper.TsNoteInfo;
import com.efs.common.noteinfo.service.TsNoteInfoService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * <strong>类全名</strong><br/>
 * com.efs.common.interceptor.FuncInterceptor <br/>
 * <strong>包名</strong><br/>
 * com.efs.common.interceptor <br/>
 * <strong>作者</strong><br/>
 * xwh <br/>
 * <strong>日期</strong><br/>
 * 2017/6/27 22:22 <br/>
 * <strong>JDK</strong><br/>
 * 1.8
 * <strong>版本</strong><br/>
 * v1.0 <br/>
 * <strong>描述</strong><br/>
 * 对请求处理菜单信息
 */
public class FuncInterceptor extends HandlerInterceptorAdapter
{
    @Resource(name = "tsNoteInfoService")
    private TsNoteInfoService tsNoteInfoService;

    @Resource(name="tsFuncIfnoService")
    private TsFuncIfnoService tsFuncIfnoService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception
    {
        HttpSession session = request.getSession();
        String isMenu = request.getParameter("isMenu");
        String posMuId = request.getParameter("posMuId");
        String htmlStr = null;
        TsUserInfo userInfo = (TsUserInfo)session.getAttribute(SysConstant.SESSION_KEY_SYSUSER);

        String muSelUrl = null;

        if(StringUtils.isNotEmpty(posMuId))
        {
            //该请求指定了菜单定位的FUNC ID，根据ID取FUNC URL进行菜单定位
            TsFuncIfno funcIfno = tsFuncIfnoService.getFuncFromId(posMuId);
            muSelUrl = funcIfno.getMuUrl();
        }
        else
        {
            muSelUrl = request.getServletPath();
        }

        if(userInfo != null && "Y".equals(isMenu))
        {
            //需要重新生成菜单信息
            htmlStr = SysUtils.geneFuncHtml(request.getContextPath(),muSelUrl,userInfo.getUserFuncList());
            session.setAttribute(SysConstant.SESSION_KEY_FUNC_HTML,htmlStr);

            session.setAttribute(SysConstant.SESSION_KEY_PAGE_HEADER, SysUtils.getPageHeader(request.getServletPath(),userInfo.getUserNavFuncList()));
        }

        if(userInfo != null)
        {
            //生成首页提示信息
            int sysNoteCount = tsNoteInfoService.getUnReadInfoCount(userInfo.getUiId());
            session.setAttribute("USER_NOTE_COUNT",sysNoteCount);

            List<TsNoteInfo> unReadNoteList = tsNoteInfoService.listUserUnReadNotes(userInfo.getUiId());
            session.setAttribute("USER_NOTE_LIST",unReadNoteList);
        }

        return super.preHandle(request, response, handler);
    }
}
