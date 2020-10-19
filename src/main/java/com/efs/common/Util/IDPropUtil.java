package com.efs.common.Util;

import com.xwh.util.PropertiesLoader;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * <strong>类全名</strong><br/>
 * com.efs.common.Util.IDPropUtil <br/>
 * <strong>包名</strong><br/>
 * com.efs.common.Util <br/>
 * <strong>作者</strong><br/>
 * xwh <br/>
 * <strong>日期</strong><br/>
 * 2017/7/24 16:00 <br/>
 * <strong>JDK</strong><br/>
 * 1.8
 * <strong>版本</strong><br/>
 * v1.0 <br/>
 * <strong>描述</strong><br/>
 * ID资源文件工具类
 */
public class IDPropUtil
{
    private static Properties prop;

    static
    {
        InputStream is = null;

        try
        {
            is = PropertiesLoader.class.getClassLoader().getResourceAsStream("IdGen.properties");
            prop = new Properties();
            prop.load(is);

        } catch (Exception e)
        {
            prop = null;
            throw new RuntimeException(e);
        }
        finally
        {
            if(null != is)
            {
                try
                {
                    is.close();
                }
                catch (IOException e)
                {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    public static String getIdPattern(String type)
    {
        return prop.getProperty(type);
    }
}
