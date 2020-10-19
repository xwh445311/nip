package com.efs.common.taglib;

import com.efs.bus.edu.classes.mapper.BaseSchClassInfo;
import com.efs.bus.edu.classes.service.BaseSchClassInfoService;
import com.efs.bus.edu.semcal.mapper.BaseSemesterCal;
import com.efs.bus.edu.semcal.service.BaseSemesterCalService;
import com.efs.bus.util.BusUtil;
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
 * 班级下拉列表标签
 */
public class ClassesSelectListTag extends SimpleTagSupport
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
     * 学期
     */
    private String scTerm;

    /**
     * 年级数量
     */
    private String grandeNo;

    /**
     * 班级数量
     */
    private String classNo;

    @Override
    public void doTag() throws JspException, IOException
    {
        List<BaseSchClassInfo> classInfoList = null;
        ServletContext servletContext = ((PageContext)getJspContext()).getServletContext();
        WebApplicationContext wac = WebApplicationContextUtils.getWebApplicationContext(servletContext);


        try
        {
            BaseSchClassInfoService baseSemesterCalService = (BaseSchClassInfoService)wac.getBean("baseSchClassInfoService");

            if(StringUtils.isNotEmpty(grandeNo) && StringUtils.isNotEmpty(classNo))
            {
                //根据年级数量和班级数量生成班级信息
                classInfoList = BusUtil.genClassesInfo(Integer.parseInt(grandeNo),Integer.parseInt(classNo));
            }
            else if(StringUtils.isNotEmpty(scTerm))
            {
                //查询数据库中的某个学期的班级
                BaseSchClassInfo paramBean = new BaseSchClassInfo();
                paramBean.setScTerm(scTerm);

                classInfoList = baseSemesterCalService.listBaseSchClassInfoNoPage(paramBean);
            }
            else
            {
                //没有设置任何参数，则取最近的学期的班级信息
                String term = baseSemesterCalService.getLastTerm();
                BaseSchClassInfo paramBean = new BaseSchClassInfo();
                paramBean.setScTerm(term);
                classInfoList = baseSemesterCalService.listBaseSchClassInfoNoPage(paramBean);
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

            for (BaseSchClassInfo cal : classInfoList)
            {
                sb.append("<option value='"+cal.getScClassCode()+"' "+ (cal.getScClassCode().equals(selVal) ? "selected" : "") +">"+cal.getScClassName()+"</option>\n");
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

    public String getScTerm()
    {
        return scTerm;
    }

    public void setScTerm(String scTerm)
    {
        this.scTerm = scTerm;
    }

    public String getGrandeNo()
    {
        return grandeNo;
    }

    public void setGrandeNo(String grandeNo)
    {
        this.grandeNo = grandeNo;
    }

    public String getClassNo()
    {
        return classNo;
    }

    public void setClassNo(String classNo)
    {
        this.classNo = classNo;
    }
}
