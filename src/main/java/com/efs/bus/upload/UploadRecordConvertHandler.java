package com.efs.bus.upload;

import com.xwh.excelupload.util.PropConvertHandler;
import org.apache.commons.lang3.StringUtils;

/**
 * <strong>类全名</strong><br/>
 * com.efs.bus.upload.UploadRecordConvertHandler <br/>
 * <strong>包名</strong><br/>
 * com.efs.bus.upload <br/>
 * <strong>作者</strong><br/>
 * xwh <br/>
 * <strong>日期</strong><br/>
 * 2018/6/1 10:48 <br/>
 * <strong>JDK</strong><br/>
 * TODO:请指定JDK版本
 * <strong>版本</strong><br/>
 * v1.0 <br/>
 * <strong>描述</strong><br/>
 * 对上传学生成绩进行转换，如果输入的内容为空，都转换为NULL
 */
public class UploadRecordConvertHandler extends PropConvertHandler
{
    @Override
    public Object convert(Object inputObj)
    {
        if(inputObj == null)
        {
            return null;
        }

        if(StringUtils.isBlank(inputObj.toString()))
        {
            return null;
        }

        return inputObj;
    }
}
