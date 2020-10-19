package com.efs.bus.util;

import com.xwh.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 * <strong>类全名</strong><br/>
 * com.efs.bus.util.RecordComputeUtil <br/>
 * <strong>包名</strong><br/>
 * com.efs.bus.util <br/>
 * <strong>作者</strong><br/>
 * xwh <br/>
 * <strong>日期</strong><br/>
 * 2018/5/9 15:37 <br/>
 * <strong>JDK</strong><br/>
 * 1.8
 * <strong>版本</strong><br/>
 * v1.0 <br/>
 * <strong>描述</strong><br/>
 * 成绩计算工具类
 */
public class RecordComputeUtil
{
    /**
     * 计算考试成绩，需要线程同步执行
     * @param riTerm
     * @param riMidTerm
     * @throws Exception
     */
    public static synchronized void computeRecord(String riTerm,String riMidTerm) throws Exception
    {
        Connection conn = null;
        PreparedStatement ps = null;

        try
        {
            conn = DBUtil.getConnection();
            ps = conn.prepareStatement("{call dbo.PROC_COMP_SCORE(?,?)}");
            ps.setString(1,riTerm);
            ps.setString(2,riMidTerm);

            ps.executeUpdate();
        }  finally
        {
            DBUtil.closeResource(null,ps,conn);
        }

    }

    /**
     * 对考试结果进行统计
     * @param riTerm
     * @param riMidTerm
     * @throws Exception
     */
    public static synchronized void computeStatics(String riTerm,String riMidTerm) throws Exception
    {
        Connection conn = null;
        PreparedStatement ps = null;

        try
        {
            conn = DBUtil.getConnection();
            ps = conn.prepareStatement("{call dbo.PROC_CLASS_RECORD_STATIC(?,?)}");
            ps.setString(1,riTerm);
            ps.setString(2,riMidTerm);

            ps.executeUpdate();
        }  finally
        {
            DBUtil.closeResource(null,ps,conn);
        }

    }
}
