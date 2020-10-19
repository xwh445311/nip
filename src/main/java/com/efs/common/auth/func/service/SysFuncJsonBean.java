package com.efs.common.auth.func.service;

/**
 * <strong>类全名</strong><br/>
 * com.efs.common.auth.func.service.SysFuncJsonBean <br/>
 * <strong>包名</strong><br/>
 * com.efs.common.auth.func.service <br/>
 * <strong>作者</strong><br/>
 * xwh <br/>
 * <strong>日期</strong><br/>
 * 2017/7/4 23:42 <br/>
 * <strong>JDK</strong><br/>
 * 1.8
 * <strong>版本</strong><br/>
 * v1.0 <br/>
 * <strong>描述</strong><br/>
 * 菜单树
 */
public class SysFuncJsonBean
{
    private String id;

    private String pId;

    private String name;

    private boolean open;

    private boolean drag;

    private boolean drop;

    private boolean checked;

    private boolean chkDisabled;



    public boolean isChecked()
    {
        return checked;
    }

    public void setChecked(boolean checked)
    {
        this.checked = checked;
    }

    public boolean isChkDisabled()
    {
        return chkDisabled;
    }

    public void setChkDisabled(boolean chkDisabled)
    {
        this.chkDisabled = chkDisabled;
    }

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getpId()
    {
        return pId;
    }

    public void setpId(String pId)
    {
        this.pId = pId;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public boolean isOpen()
    {
        return open;
    }

    public void setOpen(boolean open)
    {
        this.open = open;
    }

    public boolean isDrag()
    {
        return drag;
    }

    public void setDrag(boolean drag)
    {
        this.drag = drag;
    }

    public boolean isDrop()
    {
        return drop;
    }

    public void setDrop(boolean drop)
    {
        this.drop = drop;
    }
}
