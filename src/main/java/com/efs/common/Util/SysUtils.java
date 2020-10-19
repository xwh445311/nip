package com.efs.common.Util;

import com.efs.common.auth.func.mapper.TsFuncIfno;
import com.efs.common.auth.user.mapper.TsUserInfo;
import com.xwh.util.DBUtil;
import com.xwh.util.EFSUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ColumnListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.poi.ss.formula.functions.T;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * <strong>类全名</strong><br/>
 * com.efs.common.Util.SysUtils <br/>
 * <strong>包名</strong><br/>
 * com.efs.common.Util <br/>
 * <strong>作者</strong><br/>
 * xwh <br/>
 * <strong>日期</strong><br/>
 * 2017/6/21 14:44 <br/>
 * <strong>JDK</strong><br/>
 * 1.8
 * <strong>版本</strong><br/>
 * v1.0 <br/>
 * <strong>描述</strong><br/>
 * 系统功具类
 */
public class SysUtils
{
    private static Log logger = LogFactory.getLog(SysUtils.class);

    /**
     * 产生数据库主键ID
     * @param preix
     * @return
     */
    public static String genDBID(String preix) throws Exception
    {
        String sql = "SELECT SQ_SYS.NEXTVAL AS DB_ID FROM DUAL";
        QueryRunner qr = null;
        Connection con = null;
        String res = null;
        long curIndex = 0;
        BigDecimal index = null;

        try
        {
            con = DBUtil.getConnection();
            qr = new QueryRunner();
            index = qr.query(con,sql,new ScalarHandler<BigDecimal>(1));
            curIndex = index.longValue();

            if(StringUtils.isEmpty(preix))
            {
                preix = "";
            }

            res = preix + StringUtils.leftPad(curIndex+"",6,'0');

            return res;
        } finally
        {
            DBUtil.closeResource(null,null,con);
        }
    }

    /**
     * 产生数据库主键ID，没有前缀
     * @return
     * @throws Exception
     */
    public static String genDBID() throws Exception
    {
        return genDBID(null);
    }

    /**
     * 根据菜单列表生成菜单HTML字符串
     * @param funcList,selUrl只能是ServletString
     * @return
     */
    public static String geneFuncHtml(String contextPath,String selUrl, List<TsFuncIfno> funcList)
    {
        String defaultClass = "fa fa-home";
        StringBuilder sb = new StringBuilder();


        //添加根菜单
        sb.append("<ul class=\"nav nav-pills nav-stacked custom-nav\">");
        if(funcList != null && funcList.size() > 0)
        {
            for (TsFuncIfno func:funcList)
            {
                sb.append("<li ");
                sb.append(" class=\"");

                String selRes = checkSelUrl(selUrl,func);

                if(hasChiledFunc(func))
                {
                    sb.append("menu-list");
                }

                if("1".equals(selRes))
                {
                    sb.append(" active");
                }
                else if("2".equals(selRes))
                {
                    sb.append(" nav-active");
                }

                sb.append(" \">");

                //设备URL
                String urlStr = EFSUtil.convertNullToEmpty(func.getMuUrl()).trim();
                if(StringUtils.isNotEmpty(urlStr))
                {
                    urlStr = contextPath + EFSUtil.appendUrlQueryString(urlStr,"isMenu=Y");

                }
                else
                {
                    urlStr = "#";
                }

                if("#".equals(urlStr))
                {
                    sb.append(" <a href=\"").append(urlStr).append("\">");
                }
                else
                {
                    sb.append(" <a href=\"javascript:void(0)\" onclick=\"gotoPage('" + urlStr + "')\">");
                }


                sb.append("<i class=\""+ (StringUtils.isNotEmpty(func.getMuCss()) ? func.getMuCss() : defaultClass) +"\"></i> ");

                sb.append("<span>"+ func.getMuName() +"</span>");

                sb.append("</a> ");

                //处理子节点部分
                sb.append(genChildFuncHtml(contextPath,selUrl,func));

                sb.append("</li>");

            }
        }

        sb.append("</ul>");

        System.out.println("系统菜单为：\n" + sb.toString() + "\n");

        return sb.toString();
    }

    private static String genChildFuncHtml(String contextPath,String selUrl,TsFuncIfno parFunc)
    {
        StringBuilder sb = new StringBuilder();
        String urlStr = null;
        if(parFunc == null || parFunc.getChildFuncs() == null || parFunc.getChildFuncs().size() == 0)
        {
            return "";
        }

        sb.append("<ul class=\"sub-menu-list\">");
        for(TsFuncIfno func : parFunc.getChildFuncs())
        {
            sb.append("<li");

            if("1".equals(checkSelUrl(selUrl,func)))
            {
                sb.append(" class=\"active\"");
            }

            sb.append(">");

            urlStr = EFSUtil.convertNullToEmpty(func.getMuUrl());
            if(StringUtils.isNotEmpty(urlStr))
            {
                urlStr = contextPath + EFSUtil.appendUrlQueryString(urlStr,"isMenu=Y");
            }

            sb.append(" <a href=\"javascript:void(0)\" onclick=\"gotoPage('" + urlStr + "')\">")
                    .append(func.getMuName())
                    .append("</a>");


            sb.append("</li>");
        }

        sb.append("</ul>");

        return sb.toString();
    }

    /**
     * 检查当前节点是否被选中（如果当前节点有子节点被选中，则当前节点也会被选中）
     * @param selUrl
     * @param func
     * @return 0:表示没有被选中的节点，1：表示当前节点无子节点，直接被选中，2：表示当前节点是因为子节点选中而被选中
     */
    private static String checkSelUrl(String selUrl,TsFuncIfno func)
    {
        if(hasChiledFunc(func))
        {
            //有子元素
            for(TsFuncIfno fn : func.getChildFuncs())
            {
                if(selUrl.equals(fn.getMuUrl()))
                {
                    return "2";
                }
            }

            return "0";

        }
        else
        {
            //无子元素
            if(selUrl.equals(func.getMuUrl()))
            {
                return "1";
            }
            else
            {
                return "0";
            }
        }
    }

    /*
    判断是否有子菜单
     */
    private static boolean hasChiledFunc(TsFuncIfno funcInfo)
    {
        if(funcInfo == null)
        {
            return false;
        }

        if(funcInfo.getChildFuncs() != null && funcInfo.getChildFuncs().size() > 0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    /**
     * 生成頁頭的菜單導航信息
     * @param selFunc
     * @param funcList
     * @return
     * @throws Exception
     */
    public static List<TsFuncIfno> getPageHeader(String selFunc,List<TsFuncIfno> funcList) throws Exception
    {
        List<TsFuncIfno> resList = new ArrayList<>();
        if(StringUtils.isEmpty(selFunc) || funcList == null)
        {
            return null;
        }

        for (TsFuncIfno func : funcList)
        {
            if(setChildFunc(selFunc,resList,func))
            {
                resList.add(func);
                break;
            }
        }

        //对RES LIST取倒序
        Collections.reverse(resList);

        return resList;
    }

    private static boolean setChildFunc(String selFunc,List<TsFuncIfno> resList,TsFuncIfno curFunc)
    {
        List<TsFuncIfno> childList = curFunc.getChildFuncs();
        boolean hasSel = false;

        if (selFunc.equals(curFunc.getMuUrl()) || selFunc.equals(curFunc.getMuQuickUrl()))
        {
            return true;
        }

        if(childList != null && childList.size() >0)
        {
            for (TsFuncIfno child : childList)
            {
                hasSel = setChildFunc(selFunc, resList, child);
                if(hasSel)
                {
                    resList.add(child);
                    return hasSel;
                }
            }
        }



        return hasSel;
    }

    /**
     * 生成每日记录的时刻点
     * @param preix
     * @return
     */
    public static List<String> getRecordTime() throws Exception
    {
        String sql =
                "SELECT REPLICATE('0', 2 - LEN((TT.RM - 1))) + CAST((TT.RM - 1) AS VARCHAR) AS C_TIME " +
                        "  FROM (SELECT ROW_NUMBER() OVER(ORDER BY NAME) AS RM FROM DBO.SYSOBJECTS) TT " +
                        " WHERE TT.RM <= 24";

        QueryRunner qr = null;
        Connection con = null;
        List<String> resList = null;

        try
        {
            con = DBUtil.getConnection();
            qr = new QueryRunner();
            resList = qr.query(con,sql,new ColumnListHandler<String>());

            return resList;

        } finally
        {
            DBUtil.closeResource(null,null,con);
        }
    }

    /**
     * 利用反射给JAVA BEAN 属性设置值
     * @param beanObj
     * @param propName
     * @param val
     * @throws Exception
     */
    public static void setBeanProp(Object beanObj,String propName,Object val) throws Exception
    {
        Class<?> clazz = beanObj.getClass();
        PropertyDescriptor pd = null;
        Method method = null;

        pd = new PropertyDescriptor(propName,clazz);
        method = pd.getWriteMethod();
        method.invoke(beanObj,val);
    }

    /**
     * 利用反射获取JAVA BEAN属性的值
     * @param beanObj
     * @param propName
     * @return
     * @throws Exception
     */
    public static Object getBeanProp(Object beanObj,String propName) throws Exception
    {
        Class<?> clazz = beanObj.getClass();
        PropertyDescriptor pd = null;
        Method method = null;

        pd = new PropertyDescriptor(propName,clazz);
        method = pd.getReadMethod();
        return method.invoke(beanObj);
    }

    /**
     *  当添加对像记录时，自动设置相关的添加人，修改人等信息
     * @param user
     * @param obj
     * @throws Exception
     */
    public static void packAddObjectProp(String user, Object obj) throws Exception
    {
        setBeanProp(obj,"addUser",user);
        setBeanProp(obj,"addDate",EFSUtil.getSysFormatDate());
        setBeanProp(obj,"addTime", EFSUtil.getSysFormatTime());

        setBeanProp(obj,"updUser",user);
        setBeanProp(obj,"updDate",EFSUtil.getSysFormatDate());
        setBeanProp(obj,"updTime", EFSUtil.getSysFormatTime());
    }

    /**
     *  当修改对像记录时，自动设置相关的添加人，修改人等信息
     * @param user
     * @param obj
     * @throws Exception
     */
    public static void packUpdObjectProp(String user, Object obj) throws Exception
    {
        setBeanProp(obj,"updUser",user);
        setBeanProp(obj,"updDate",EFSUtil.getSysFormatDate());
        setBeanProp(obj,"updTime", EFSUtil.getSysFormatTime());
    }

    public static void packAddObjectProp(TsUserInfo user,Object obj) throws Exception
    {
        setBeanProp(obj,"addUser",user.getUiId());
        setBeanProp(obj,"addUserName",user.getUiName());
        setBeanProp(obj,"addDate",EFSUtil.getSysFormatDate());
        setBeanProp(obj,"addTime", EFSUtil.getSysFormatTime());

        setBeanProp(obj,"updUser",user.getUiId());
        setBeanProp(obj,"updUserName",user.getUiName());
        setBeanProp(obj,"updDate",EFSUtil.getSysFormatDate());
        setBeanProp(obj,"updTime", EFSUtil.getSysFormatTime());
    }

    public static void packUpdObjectProp(TsUserInfo user,Object obj) throws Exception
    {
        setBeanProp(obj,"updUser",user.getUiId());
        setBeanProp(obj,"updUserName",user.getUiName());
        setBeanProp(obj,"updDate",EFSUtil.getSysFormatDate());
        setBeanProp(obj,"updTime", EFSUtil.getSysFormatTime());
    }

    /**
     * 根据书架编号，行数，列数计算所有书架编号
     * @param slNo
     * @param rowCnt
     * @param colCnt
     * @return
     */
    public static List<String> getShielfAddrDetail(int slNo,int rowCnt,int colCnt)
    {
        List<String> addrList = new ArrayList<>();
        for(int i=1;i<=rowCnt;i++)
        {
            for(int j=1;j<=colCnt;j++)
            {
                addrList.add(StringUtils.leftPad(slNo + "",2,'0') + StringUtils.leftPad(i + "",2,'0') + StringUtils.leftPad(j + "",2,'0'));
            }
        }

        return addrList;
    }
}
