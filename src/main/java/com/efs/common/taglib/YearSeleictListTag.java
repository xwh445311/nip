package com.efs.common.taglib;

import org.apache.commons.lang3.StringUtils;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.time.LocalDate;

/**
 * <strong>类全名</strong><br/>
 * com.efs.common.taglib.YearSeleictListTag <br/>
 * <strong>包名</strong><br/>
 * com.efs.common.taglib <br/>
 * <strong>作者</strong><br/>
 * xuwh <br/>
 * <strong>日期</strong><br/>
 * 2018/4/25 12:38 <br/>
 * <strong>JDK</strong><br/>
 * 生生选择年的下拉列表
 * <strong>版本</strong><br/>
 * v1.0 <br/>
 * <strong>描述</strong><br/>
 * 年份选择下拉框
 */
public class YearSeleictListTag extends SimpleTagSupport
{
    /**
     * SEL 样式
     */
    private String cls;

    /**
     * 开始年份
     */
    private String startYear;

    /**
     * 时长
     */
    private String yearLen;

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


    @Override
    public void doTag() throws JspException, IOException
    {
        int yl = Integer.parseInt(yearLen);
        StringBuilder sb = new StringBuilder();
        String tmpStr = "<select class='"+ (StringUtils.isEmpty(cls) ? "" : cls) +"' name='"+name+"' id='"+id+"' ";

        if(StringUtils.isNotEmpty(onchange))
        {
            tmpStr += " onchange='"+ onchange +"' ";
        }

        tmpStr += ">\n";

        sb.append(tmpStr);
        sb.append("<option value=''>请选择</option>\n");

        LocalDate ld = LocalDate.of(Integer.parseInt(startYear),1,1);

        sb.append("<option value='"+ld.getYear()+"' "+ (Integer.toString(ld.getYear()).equals(selVal) ? "selected" : "") +">"+ld.getYear()+"</option>\n");
        for(int i=0;i<yl;i++)
        {
            ld = ld.plusYears(1);
            sb.append("<option value='"+ld.getYear()+"' "+ (Integer.toString(ld.getYear()).equals(selVal) ? "selected" : "") +">"+ld.getYear()+"</option>\n");
        }

        sb.append("</select>\n");

        getJspContext().getOut().write(sb.toString());
    }

    public String getCls()
    {
        return cls;
    }

    public void setCls(String cls)
    {
        this.cls = cls;
    }

    public String getStartYear()
    {
        return startYear;
    }

    public void setStartYear(String startYear)
    {
        this.startYear = startYear;
    }

    public String getYearLen()
    {
        return yearLen;
    }

    public void setYearLen(String yearLen)
    {
        this.yearLen = yearLen;
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
}
