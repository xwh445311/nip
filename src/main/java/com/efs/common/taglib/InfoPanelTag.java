package com.efs.common.taglib;

import org.apache.commons.lang3.StringUtils;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

/**
 * <strong>类全名</strong><br/>
 * com.efs.common.taglib.InfoPanelTag <br/>
 * <strong>包名</strong><br/>
 * com.efs.common.taglib <br/>
 * <strong>作者</strong><br/>
 * xwh <br/>
 * <strong>日期</strong><br/>
 * 2018/5/7 16:08 <br/>
 * <strong>JDK</strong><br/>
 * 1.8
 * <strong>版本</strong><br/>
 * v1.0 <br/>
 * <strong>描述</strong><br/>
 * 显示提示信息框
 */
public class InfoPanelTag extends SimpleTagSupport
{
    private static Map<String,String> titleMap ;

    private static Map<String,String> cssMap;

    static
    {
        titleMap = new HashMap<>();
        titleMap.put("SUCCESS","成功");
        titleMap.put("INFO","提示");
        titleMap.put("WARN","警告");
        titleMap.put("ERROR","错误");

        cssMap = new HashMap<>();
        cssMap.put("SUCCESS","alert alert-success fade in");
        cssMap.put("INFO","alert alert-info fade in");
        cssMap.put("WARN","alert alert-warning fade in");
        cssMap.put("ERROR","alert alert-block alert-danger fade in");
    }

    /**
     * 消息类型：SUCCESS成功，INFO:提示，WARN：警告消息，ERROR:错误信息
     */
    private String msgType;

    /**
     * 消息TITLE
     */
    private String title;

    /**
     * 消息内容
     */
    private String content;

    /**
     * Y：显示关闭，默认不显示
     */
    private String showClose;

    @Override
    public void doTag() throws JspException, IOException
    {
        Writer out = getJspContext().getOut();
        StringBuilder sb = new StringBuilder();
        sb.append("<div class=\""+ cssMap.get(msgType) +"\">");
        if("Y".equals(showClose))
        {
            sb.append("<button type=\"button\" class=\"close close-sm\" data-dismiss=\"alert\"><i class=\"fa fa-times\"></i></button>");
        }

        sb.append("<strong>"+ (StringUtils.isEmpty(title) ? titleMap.get(msgType) : title) +"！</strong>");
        out.write(sb.toString());

        sb = new StringBuilder();
        if(StringUtils.isNotEmpty(content))
        {
            sb.append(content);
            out.write(sb.toString());
        }
        else
        {
            getJspBody().invoke(out);
        }

        sb.append("</div>");

        out.write(sb.toString());
    }

    public String getMsgType()
    {
        return msgType;
    }

    public void setMsgType(String msgType)
    {
        this.msgType = msgType;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public String getContent()
    {
        return content;
    }

    public void setContent(String content)
    {
        this.content = content;
    }

    public String getShowClose()
    {
        return showClose;
    }

    public void setShowClose(String showClose)
    {
        this.showClose = showClose;
    }
}
