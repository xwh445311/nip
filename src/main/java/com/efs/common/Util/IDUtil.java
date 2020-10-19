package com.efs.common.Util;

import com.xwh.util.DBUtil;
import com.xwh.util.EFSUtil;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * <strong>类全名</strong><br/>
 * com.efs.common.Util.IDUtil <br/>
 * <strong>包名</strong><br/>
 * com.efs.common.Util <br/>
 * <strong>作者</strong><br/>
 * xwh <br/>
 * <strong>日期</strong><br/>
 * 2017/7/24 15:53 <br/>
 * <strong>JDK</strong><br/>
 * 1.8
 * <strong>版本</strong><br/>
 * v1.0 <br/>
 * <strong>描述</strong><br/>
 * ID生成器，此类是线程安全的
 */
public class IDUtil
{
    private static Log logger = LogFactory.getLog(IDUtil.class);

    /**
     * 根据ID类型生成ID值
     * @param idType
     * @return
     * @throws Exception
     */
    public static synchronized String getId(String idType) throws Exception
    {
        String qSql= "SELECT GI_VAL FROM TS_GEN_ID_INFO T WHERE T.GI_KEY = ?";
        String addSql = "INSERT INTO TS_GEN_ID_INFO (GI_KEY, GI_VAL) VALUES (?, ?)";
        String updSql = "UPDATE TS_GEN_ID_INFO SET GI_VAL = ? WHERE GI_KEY = ?";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int index = 0;
        StringBuilder sb = new StringBuilder();
        String tmpStr = null;
        boolean hasDate = false;
        String curDate = EFSUtil.getSysFormatDate();

        try
        {
            //根据模板产生健值
            String type = IDPropUtil.getIdPattern(idType);
            logger.debug("准备生成 ID,模板为["+ idType +"]");
            if(StringUtils.isEmpty(type))
            {
                throw new RuntimeException("ID TYPE:" + type + " ,没有定义");
            }

            if(type.contains("["))
            {
                hasDate = true;
            }

            if(hasDate)
            {
                qSql= "SELECT GI_VAL FROM TS_GEN_ID_INFO T WHERE T.GI_KEY = ? AND T.GI_DATE=?";
                addSql = "INSERT INTO TS_GEN_ID_INFO (GI_KEY, GI_DATE, GI_VAL) VALUES (?,?, ?)";
                updSql = "UPDATE TS_GEN_ID_INFO SET GI_VAL = ? WHERE GI_KEY = ? AND GI_DATE=?";
            }

            conn = DBUtil.getConnection();
            ps = conn.prepareStatement(qSql);
            ps.setString(1,idType);

            if(hasDate)
            {
                ps.setString(2,curDate);
            }

            rs = ps.executeQuery();
            if(rs.next())
            {
                index = rs.getInt(1) + 1;
            }
            else
            {
                index = 1;
            }

            rs.close();
            ps.close();

            if(index == 1)
            {
                //新增
                ps = conn.prepareStatement(addSql);

                if(hasDate)
                {
                    ps.setString(1,idType);
                    ps.setString(2,curDate);
                    ps.setInt(3,index);
                }
                else
                {
                    ps.setString(1,idType);
                    ps.setInt(2,index);
                }

            }
            else
            {
                //更新键值
                ps = conn.prepareStatement(updSql);

                if(hasDate)
                {
                    ps.setInt(1,index);
                    ps.setString(2,idType);
                    ps.setString(3,curDate);
                }
                else
                {
                    ps.setInt(1,index);
                    ps.setString(2,idType);
                }
            }

            ps.executeUpdate();



            String[] typePart = type.split(",");
            for (String part : typePart)
            {
                if (part.contains("["))
                {
                    tmpStr = part.replaceAll("\\[","").replaceAll("\\]","");
                    sb.append(EFSUtil.getSysFormatDateTime(tmpStr));
                }
                else if(part.contains("{"))
                {
                    tmpStr = part.replaceAll("[{]","").replaceAll("[}]","");
                    int size = Integer.parseInt(tmpStr);

                    tmpStr =  StringUtils.leftPad(index+"",size,'0');
                    sb.append(tmpStr);
                }
                else
                {
                    sb.append(part);
                }
            }

            logger.debug("已经成功生成ID ["+ sb.toString() +"]");
            return sb.toString();
        } catch (Exception e)
        {
            logger.error(e);
            throw e;
        } finally
        {
            DBUtil.closeResource(rs,ps,conn);
        }
    }
}
