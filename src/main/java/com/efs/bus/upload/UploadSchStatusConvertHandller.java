package com.efs.bus.upload;

import com.xwh.excelupload.util.PropConvertHandler;
import com.xwh.util.EFSUtil;
import org.apache.commons.collections4.MapUtils;

import java.util.Map;

/**
 * <strong>类全名</strong><br/>
 * com.efs.bus.upload.UploadSchStatusConvertHandller <br/>
 * <strong>包名</strong><br/>
 * com.efs.bus.upload <br/>
 * <strong>作者</strong><br/>
 * xuwh <br/>
 * <strong>日期</strong><br/>
 * 2018/4/30 22:30 <br/>
 * <strong>JDK</strong><br/>
 * 1.8
 * <strong>版本</strong><br/>
 * v1.0 <br/>
 * <strong>描述</strong><br/>
 * 学籍状态转换类
 */
public class UploadSchStatusConvertHandller extends PropConvertHandler
{
    @Override
    public Object convert(Object inputObj)
    {
        if(inputObj == null)
        {
            return null;
        }

        String status = (String)inputObj;

        try
        {
            Map<String,Object> statusMap = EFSUtil.getDBParamMap("BASE_STUDENT_STATUS");
            if(MapUtils.isNotEmpty(statusMap))
            {
                for (Map.Entry<String, Object> entry : statusMap.entrySet())
                {
                    if(status.equals(entry.getValue()))
                    {
                        return entry.getKey();
                    }
                }
            }

            return inputObj;
        } catch (Exception e)
        {
            throw new RuntimeException(e);
        }
    }
}
