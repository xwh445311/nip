package com.efs.bus.util;

/**
 * <strong>类全名</strong><br/>
 * com.efs.bus.util.BusConstant <br/>
 * <strong>包名</strong><br/>
 * com.efs.bus.util <br/>
 * <strong>作者</strong><br/>
 * xwh <br/>
 * <strong>日期</strong><br/>
 * 2018/4/2 0:45 <br/>
 * <strong>JDK</strong><br/>
 * 1.8
 * <strong>版本</strong><br/>
 * v1.0 <br/>
 * <strong>描述</strong><br/>
 * 业务常量类
 */
public class BusConstant
{
    public static final String ADDR_STATUS_INUSE= "1";
    public static final String ADDR_STATUS_NOUSE= "2";

    public static final String BOOK_STATUS_SEND = "01"; //图书状态－借出
    public static final String BOOK_STATUS_INLIB = "00"; //图书状态－在库
    public static final String BOOK_STATUS_REGLOSE = "02"; //图书状态－在库

    public static final String ROLE_STUDENT_ID = "R000071"; //学生角色ID
    public static final String ROLE_TEACHER_ID = "R000087"; //学生角色ID

    public static final String PROC_TYPE = "SGOP"; //流程类别ID
}
