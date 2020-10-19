package com.efs.common.taglib;

import com.xwh.bean.SelectBean;
import com.xwh.util.EFSUtil;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * <strong>类全名</strong><br/>
 * com.efs.common.taglib.CommonSelectListTag <br/>
 * <strong>包名</strong><br/>
 * com.efs.common.taglib <br/>
 * <strong>作者</strong><br/>
 * xwh <br/>
 * <strong>日期</strong><br/>
 * 2020/5/16 20:15 <br/>
 * <strong>JDK</strong><br/>
 * TODO:请指定JDK版本
 * <strong>版本</strong><br/>
 * v1.0 <br/>
 * <strong>描述</strong><br/>
 * TODO:请描述此类功能
 */
public class CommonSelectListTag extends SimpleTagSupport
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
     * 数据LIST
     */
    private List<SelectBean> list;

    @Override
    public void doTag() throws JspException, IOException
    {

        StringBuilder sb = new StringBuilder();

        try
        {
            if(CollectionUtils.isEmpty(list))
            {
                list = new ArrayList<>();
            }

            String tmpStr = "<select class='"+ (StringUtils.isEmpty(cls) ? "" : cls) +"' name='"+name+"' id='"+id+"' ";

            if(StringUtils.isNotEmpty(onchange))
            {
                tmpStr += " onchange='"+ onchange +"' ";
            }

            tmpStr += ">\n";

            sb.append(tmpStr);
            sb.append("<option value=''>请选择</option>\n");

            for (SelectBean selectBean : list)
            {
                sb.append("<option value='" + selectBean.getKey() + "' " +(selVal == null ? "" : (selVal.equals(selectBean.getKey()) ? "selected" : "") ) + ">" + selectBean.getValue() + "</option>\n");
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

    public List<SelectBean> getList()
    {
        return list;
    }

    public void setList(List<SelectBean> list)
    {
        this.list = list;
    }
}
