package com.efs.common.taglib;

import com.efs.common.auth.user.mapper.TsUserInfo;
import com.efs.common.auth.user.service.TsUserInfoService;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeansException;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * <strong>类全名</strong><br/>
 * com.efs.common.taglib.UserSelectListTag <br/>
 * <strong>包名</strong><br/>
 * com.efs.common.taglib <br/>
 * <strong>作者</strong><br/>
 * xwh <br/>
 * <strong>日期</strong><br/>
 * 2018/5/3 16:05 <br/>
 * <strong>JDK</strong><br/>
 * 1.8
 * <strong>版本</strong><br/>
 * v1.0 <br/>
 * <strong>描述</strong><br/>
 * 用户选项下拉框
 */
public class UserSelectListTag extends SimpleTagSupport
{
    /**
     * SEL 样式
     */
    private String cls;

    /**
     * 标签名称
     */
    private String name;

    /**
     * 标签ID
     */
    private String id;

    /**
     * 选中值
     */
    private Object selVal;

    /**
     * ONCHNAGE事件
     */
    private String onchange;

    /**
     * 选取用户类型：1：领导层，2：教职工，3：领导及教职工,4:班主任,5:可排课老师（会过滤掉排课超过3节的老师)，6：某班的所有老师 7：学生（学生只能按学期和班级进行选择）
     */
    private String userType;

    /**
     * 对于用户类型为4，5,6的，需要指定学期，如果不指定学期，则取当前日期对应的学期
     */
    private String scTerm;

    /**
     * 班级
     */
    private String classes;

    /**
     *
     * @throws JspException
     * @throws IOException
     */
    @Override
    public void doTag() throws JspException, IOException
    {
        ServletContext servletContext = ((PageContext)getJspContext()).getServletContext();
        WebApplicationContext wac = WebApplicationContextUtils.getWebApplicationContext(servletContext);
        List<TsUserInfo> userInfoList = new ArrayList<>();
        TsUserInfo paramBean ;
        String showVal;
        try
        {
            TsUserInfoService tsUserInfoService = (TsUserInfoService)wac.getBean("tsUserInfoService");

            if("1".equals(userType))
            {
                //查询领导层
                paramBean = new TsUserInfo();
                paramBean.setUiBusType("01");
                paramBean.setUtWorkStatus("01");
                userInfoList = tsUserInfoService.listTeacherInfoNoPage(paramBean);
            }
            else if("2".equals(userType))
            {
                //查询教职工
                paramBean = new TsUserInfo();
                paramBean.setUiBusType("02");
                paramBean.setUtWorkStatus("01");
                userInfoList = tsUserInfoService.listTeacherInfoNoPage(paramBean);
            }
            else if("3".equals(userType))
            {
                //所有教职工
                paramBean = new TsUserInfo();
                paramBean.setUtWorkStatus("01");
                userInfoList = tsUserInfoService.listTeacherInfoNoPage(paramBean);
            }
            else if("4".equals(userType))
            {
                //所有班主任
                paramBean = new TsUserInfo();
                paramBean.setHasClassLeader("Y");
                paramBean.setScTerm(scTerm);
                paramBean.setUtWorkStatus("01");
                userInfoList = tsUserInfoService.listTeacherInfoNoPage(paramBean);
            }
            else if("5".equals(userType))
            {
                //所有可排课的老师
                paramBean = new TsUserInfo();
                paramBean.setCanHasScore("Y");
                paramBean.setScTerm(scTerm);
                paramBean.setUtWorkStatus("01");
                userInfoList = tsUserInfoService.listTeacherInfoNoPage(paramBean);
            }
            else if("6".equals(userType))
            {
                //某班的所有课任老师
                paramBean = new TsUserInfo();
                paramBean.setUsClass(classes);
                paramBean.setScTerm(scTerm);
                paramBean.setUtWorkStatus("01");
                userInfoList = tsUserInfoService.listTeacherInfoNoPage(paramBean);
            }
            else if("7".equals(userType))
            {
                //某班的所有学生
                paramBean = new TsUserInfo();
                paramBean.setUsClass(classes);
                userInfoList = tsUserInfoService.listStudentNoPage(paramBean);
            }

            StringBuilder sb = new StringBuilder();
            String tmpStr = "<select class='"+ (StringUtils.isEmpty(cls) ? "" : cls) +"' name='"+name+"' id='"+id+"' ";

            if(StringUtils.isNotEmpty(onchange))
            {
                tmpStr += " onchange='"+ onchange +"' ";
            }

            tmpStr += ">\n";

            sb.append(tmpStr);
            sb.append("<option value=''>请选择</option>\n");

            if(CollectionUtils.isNotEmpty(userInfoList))
            {
                for (TsUserInfo user : userInfoList)
                {
                    if("01,02".contains(user.getUiBusType()))
                    {
                        showVal = "(" + user.getUiShortName() + ")" + user.getUiName();
                    }
                    else
                    {
                        showVal ="(" + user.getUiId() + ")" + user.getUiName();
                    }
                    sb.append("<option value='"+user.getUiId()+"' "+ (user.getUiId().equals(selVal) ? "selected" : "") +">"+ showVal +"</option>\n");
                }
            }

            sb.append("</select>\n");

            getJspContext().getOut().write(sb.toString());

        } catch (Exception e)
        {
            throw new RuntimeException(e);
        }


    }

    public String getCls()
    {
        return cls;
    }

    public void setCls(String cls)
    {
        this.cls = cls;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public Object getSelVal()
    {
        return selVal;
    }

    public void setSelVal(Object selVal)
    {
        this.selVal = selVal;
    }

    public String getOnchange()
    {
        return onchange;
    }

    public void setOnchange(String onchange)
    {
        this.onchange = onchange;
    }

    public String getUserType()
    {
        return userType;
    }

    public void setUserType(String userType)
    {
        this.userType = userType;
    }

    public String getScTerm()
    {
        return scTerm;
    }

    public void setScTerm(String scTerm)
    {
        this.scTerm = scTerm;
    }

    public String getClasses()
    {
        return classes;
    }

    public void setClasses(String classes)
    {
        this.classes = classes;
    }
}
