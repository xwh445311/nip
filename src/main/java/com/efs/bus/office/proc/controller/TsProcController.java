package com.efs.bus.office.proc.controller;

import com.efs.common.controller.BaseController;
import com.efs.common.interceptor.Auth;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * <strong>类全名</strong><br/>
 * com.efs.bus.office.proc.controller.TsProcController <br/>
 * <strong>包名</strong><br/>
 * com.efs.bus.office.proc.controller <br/>
 * <strong>作者</strong><br/>
 * xuwh <br/>
 * <strong>日期</strong><br/>
 * 2018/6/16 23:13 <br/>
 * <strong>JDK</strong><br/>
 * 1.8
 * <strong>版本</strong><br/>
 * v1.0 <br/>
 * <strong>描述</strong><br/>
 * 流程控制器
 */
@Controller
@RequestMapping("/office/proc")
public class TsProcController extends BaseController
{

    /**
     * 进入任务台页面
     * @return
     * @throws Exception
     */
    @RequestMapping("/gotoProcDefPage")
    @Auth
    public String gotoProcDefPage() throws Exception
    {
        return "/office/proc/procDefPage";
    }

    /**
     * 查询所有的待办流程
     * @return
     * @throws Exception
     */
    /*@ResponseBody
    @RequestMapping("/listProcDefPage")
    @Auth
    public PageDataBunder listProcDefPage() throws Exception
    {
        List<LocProcessDefinition> locProcessDefinitionList = remProcService.listProcessDefByCat(BusConstant.PROC_TYPE);
        PageDataBunder pageDataBunder = new PageDataBunder();
        pageDataBunder.setRows(locProcessDefinitionList);

        return pageDataBunder;
    }*/

    /**
     * 生成流程图片
     * @param userId
     * @param response
     * @return
     * @throws Exception
     */
    /*@RequestMapping("/getProcImage")
    @Auth
    public String getProcImage(String defId,HttpServletResponse response) throws Exception
    {

        OutputStream os = null;
        byte[] imgByte;

        try
        {
            imgByte = remProcService.getProcImg(defId);
            os = response.getOutputStream();
            os.write(imgByte);
            os.flush();
        } finally
        {
            if(null != os)
            {
                os.close();
            }
        }

        return null;
    }*/
}
