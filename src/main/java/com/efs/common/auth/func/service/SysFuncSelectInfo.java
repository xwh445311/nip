package com.efs.common.auth.func.service;

import java.util.List;

/**
 * <strong>类全名</strong><br/>
 * com.efs.common.auth.func.service.SysFuncSelectInfo <br/>
 * <strong>包名</strong><br/>
 * com.efs.common.auth.func.service <br/>
 * <strong>作者</strong><br/>
 * xwh <br/>
 * <strong>日期</strong><br/>
 * 2017/7/17 17:32 <br/>
 * <strong>JDK</strong><br/>
 * 1.8
 * <strong>版本</strong><br/>
 * v1.0 <br/>
 * <strong>描述</strong><br/>
 * TODO:请描述此类功能
 */
public class SysFuncSelectInfo
{
    private String id;

    private String text;

    private boolean checked;

    private List<SysFuncSelectInfo> children;

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getText()
    {
        return text;
    }

    public void setText(String text)
    {
        this.text = text;
    }

    public boolean isChecked()
    {
        return checked;
    }

    public void setChecked(boolean checked)
    {
        this.checked = checked;
    }

    public List<SysFuncSelectInfo> getChildren()
    {
        return children;
    }

    public void setChildren(List<SysFuncSelectInfo> children)
    {
        this.children = children;
    }
}
