package com.efs.common.taglib;

import com.efs.bus.edu.semcal.mapper.BaseSemesterCal;
import com.efs.bus.edu.semcal.service.BaseSemesterCalService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.util.List;

/**
 * <strong>类全名</strong><br/>
 * com.efs.common.taglib.SemesterSelectListTag <br/>
 * <strong>包名</strong><br/>
 * com.efs.common.taglib <br/>
 * <strong>作者</strong><br/>
 * xwh <br/>
 * <strong>日期</strong><br/>
 * 2018/4/27 9:33 <br/>
 * <strong>JDK</strong><br/>
 * 1.8
 * <strong>版本</strong><br/>
 * v1.0 <br/>
 * <strong>描述</strong><br/>
 * 学期下拉列表标签
 */
public class SemesterSelectListTag extends SimpleTagSupport
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
     * 是否已经安排班级
     */
    private String hasClasses;

    @Override
    public void doTag() throws JspException, IOException
    {
        ServletContext servletContext = ((PageContext)getJspContext()).getServletContext();
        WebApplicationContext wac = WebApplicationContextUtils.getWebApplicationContext(servletContext);

        BaseSemesterCal paramBean = new BaseSemesterCal();
        if(StringUtils.isNotEmpty(hasClasses))
        {
            paramBean.setHasClass(hasClasses);
        }


        try
        {
            BaseSemesterCalService baseSemesterCalService = (BaseSemesterCalService)wac.getBean("baseSemesterCalService");
            List<BaseSemesterCal> calList = baseSemesterCalService.listBaseSemesterCalNoPage(paramBean);

            StringBuilder sb = new StringBuilder();
            String tmpStr = "<select class='"+ (StringUtils.isEmpty(cls) ? "" : cls) +"' name='"+name+"' id='"+id+"' ";

            if(StringUtils.isNotEmpty(onchange))
            {
                tmpStr += " onchange='"+ onchange +"' ";
            }

            tmpStr += ">\n";

            sb.append(tmpStr);
            sb.append("<option value=''>请选择</option>\n");

            for (BaseSemesterCal cal : calList)
            {
                sb.append("<option value='"+cal.getScTerm()+"' "+ (cal.getScTerm().equals(selVal) ? "selected" : "") +">"+cal.getScTermDesc()+"</option>\n");
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

    public String getHasClasses()
    {
        return hasClasses;
    }

    public void setHasClasses(String hasClasses)
    {
        this.hasClasses = hasClasses;
    }
}
