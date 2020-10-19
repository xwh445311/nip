package com.efs.common.taglib;

import org.apache.commons.lang3.StringUtils;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;

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
 * 期中期末下拉列表标签
 */
public class MidTermSelectListTag extends SimpleTagSupport
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


    @Override
    public void doTag() throws JspException, IOException
    {
        try
        {

            StringBuilder sb = new StringBuilder();
            String tmpStr = "<select class='"+ (StringUtils.isEmpty(cls) ? "" : cls) +"' name='"+name+"' id='"+id+"' ";

            if(StringUtils.isNotEmpty(onchange))
            {
                tmpStr += " onchange='"+ onchange +"' ";
            }

            tmpStr += ">\n";

            sb.append(tmpStr);
            sb.append("<option value=''>请选择</option>\n");
            sb.append("<option value='期中' "+ ("期中".equals(selVal) ? "selected" : "") +">期中</option>\n");
            sb.append("<option value='期末' "+ ("期末".equals(selVal) ? "selected" : "") +">期末</option>\n");
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

}
