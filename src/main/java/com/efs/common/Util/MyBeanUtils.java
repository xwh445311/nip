package com.efs.common.Util;

import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.BigDecimalConverter;

import java.math.BigDecimal;

/**
 * <strong>类全名</strong><br/>
 * com.efs.common.Util.MyBeanUtils <br/>
 * <strong>包名</strong><br/>
 * com.efs.common.Util <br/>
 * <strong>作者</strong><br/>
 * xwh <br/>
 * <strong>日期</strong><br/>
 * 2017/11/14 0:48 <br/>
 * <strong>JDK</strong><br/>
 * TODO:请指定JDK版本
 * <strong>版本</strong><br/>
 * v1.0 <br/>
 * <strong>描述</strong><br/>
 * TODO:请描述此类功能
 */
public class MyBeanUtils
{

    private static final BigDecimal BIGDECIMAL_ZERO = new BigDecimal("0");

    public static void initConvert()
    {
        ConvertUtils.register(new BigDecimalConverter(BIGDECIMAL_ZERO), BigDecimal.class);
    }
}
