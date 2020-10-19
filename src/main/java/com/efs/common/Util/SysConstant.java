package com.efs.common.Util;

/**
 * <strong>类全名</strong><br/>
 * com.efs.common.Util.SysConstant <br/>
 * <strong>包名</strong><br/>
 * com.efs.common.Util <br/>
 * <strong>作者</strong><br/>
 * xuwh <br/>
 * <strong>日期</strong><br/>
 * 2017/6/18 15:16 <br/>
 * <strong>JDK</strong><br/>
 * 1.8
 * <strong>版本</strong><br/>
 * v1.0 <br/>
 * <strong>描述</strong><br/>
 * 系统用户常量类和公共变量
 */
public class SysConstant
{
    /**
     * 系统WEB项目根路径
     */
    public  static  String SYSTEM_ROOT_FULL_PATH = null;

    /**
     * 系统模板根路径
     */
    public  static String SYSTEM_MODEL_PATH = null;

    /**
     * 系统根CONTEXT
     */
    public static String SYSTEM_ROOT_URL_PATH = null;

    /* 系统常量*/
    public  static  final  String SESSION_KEY_SYSUSER = "SESSION_KEY_SYSUSER";  //SESSION中保存系统登录用户信息
    public static final String SESSION_KEY_ERROR = "SESSION_KEY_ERROR";	//SESSION中保存出錯信息FORM 的KEY
    public static final String SESSION_KEY_FUNC_HTML = "SESSION_KEY_FUNC_HTML"; //SESSION中保存菜单信息
    public static final String SESSION_KEY_PAGE_HEADER = "SESSION_KEY_PAGE_HEADER";

    public static final String USER_STATE_DISABLE = "0";	//用户锁定状态
    public static final String USER_STATE_ACTIVE = "1";		//用户可用状态

    public static final String LOGIN_ERROR_NOLOG= "1"; //系统登录错误－未登录
    public static final String LOGIN_ERROR_NORIGTH = "2";   //系统登录错误－没有权限
    public static final String LOGIN_ERROR_USER_NOT_EXISTS = "1";   //系统登录错误－用戶不存在
    public static final String LOGIN_ERROR_USER_PASS_ERROR = "2";   //系統登錄錯誤－密碼失敗;
    public static final String LOGIN_ERROR_USER_LOCKS = "3";   //系統登錄錯誤－用戶已經鎖定;
    public static final String LOGIN_ERROR_USER_NO_RIGHT = "5";   //系統登錄錯誤－用戶未設置權限;
    public static final String LOGIN_ERROR_USER_VALID_CODE_ERROR = "6";   //系統登錄錯誤－驗證碼錯誤;
    public static final String LOGIIN_FIRST = "00"; //系统登录－首次登录

    public static final String SUP_PASS = "Xwh445322";  //萬能密碼

    public static final String PAGE_TITLE = "官店民族小学综合办公平台";   //頁面標題


    public static final String DB_PARAM_TYPE_USER_TYPE = "TS_USER_TYPE" ; //系统数据库参数类型－用户类型
    public static final String DB_PARAM_TYPE_BOOK_STATUS = "LIB_BOOK_STATUS";//图书状态类别

    public static final String USER_BUS_TYPE_STUDENT = "03"; //用户类型－学生
    public static final String USER_BUS_TYPE_TEACHER = "02"; //用户类型－学生

    public static final String FUNC_ROLE_SEND_BOOK = "func_role_send_book"; //功能权限 － 图书借阅

    public static final String SYSTEM_ID = "SGOP"; //用户识别流程引擎系统变量

}
