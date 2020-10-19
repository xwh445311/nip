package com.efs.bus.upload;

import com.xwh.excelupload.util.PropConvertHandler;

/**
 * <strong>类全名</strong><br/>
 * com.efs.bus.upload.UploadSexConvertHandler <br/>
 * <strong>包名</strong><br/>
 * com.efs.bus.upload <br/>
 * <strong>作者</strong><br/>
 * xuwh <br/>
 * <strong>日期</strong><br/>
 * 2018/4/30 22:25 <br/>
 * <strong>JDK</strong><br/>
 * 1.8
 * <strong>版本</strong><br/>
 * v1.0 <br/>
 * <strong>描述</strong><br/>
 * 上传姓名转换类
 */
public class UploadSexConvertHandler extends PropConvertHandler
{
    @Override
    public Object convert(Object inputObj)
    {
        if(inputObj == null)
        {
            return null;
        }

        String sex = (String)inputObj;

        if("男".equals(sex))
        {
            return "M";
        }
        else if("女".equals(sex))
        {
            return "F";
        }
        else
        {
            return sex;
        }
    }
}
