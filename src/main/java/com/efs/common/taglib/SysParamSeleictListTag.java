package com.efs.common.taglib;

import com.xwh.util.EFSUtil;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Map;

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
 * 1.8
 * <strong>版本</strong><br/>
 * v1.0 <br/>
 * <strong>描述</strong><br/>
 * 系统参数表下拉菜单
 */
public class SysParamSeleictListTag extends SimpleTagSupport
{
    /**
     * SEL 样式
     */
    private String cls;

    /**
     * 参数类别
     */
    private String type;

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

        StringBuilder sb = new StringBuilder();

        try
        {
            Map<String,Object> paramMap = EFSUtil.getDBParamMap(type);

            String tmpStr = "<select class='"+ (StringUtils.isEmpty(cls) ? "" : cls) +"' name='"+name+"' id='"+id+"' ";

            if(StringUtils.isNotEmpty(onchange))
            {
                tmpStr += " onchange='"+ onchange +"' ";
            }

            tmpStr += ">\n";

            sb.append(tmpStr);
            sb.append("<option value=''>请选择</option>\n");

            for (Map.Entry<String, Object> entry : paramMap.entrySet())
            {
                sb.append("<option value='" + entry.getKey() + "' " +(selVal == null ? "" : (selVal.equals(entry.getKey()) ? "selected" : "") ) + ">" + entry.getValue() + "</option>\n");
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

    public String getType()
    {
        return type;
    }

    public void setType(String type)
    {
        this.type = type;
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
