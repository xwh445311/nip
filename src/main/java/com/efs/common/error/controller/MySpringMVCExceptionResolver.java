package com.efs.common.error.controller;

import com.efs.common.controller.JsonResult;
import com.google.gson.Gson;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * <strong>类全名</strong><br/>
 * com.efs.common.error.controller.MySpringMVCExceptionResolver <br/>
 * <strong>包名</strong><br/>
 * com.efs.common.error.controller <br/>
 * <strong>作者</strong><br/>
 * xwh <br/>
 * <strong>日期</strong><br/>
 * 2017/7/19 9:05 <br/>
 * <strong>JDK</strong><br/>
 * 1.8
 * <strong>版本</strong><br/>
 * v1.0 <br/>
 * <strong>描述</strong><br/>
 * 重写SPRING MVC异常处理类，以实现对JSON请求的异常数据返回
 */
public class MySpringMVCExceptionResolver extends SimpleMappingExceptionResolver
{
    private static Log logger = LogFactory.getLog(MySpringMVCExceptionResolver.class);

    /**
     * Actually resolve the given exception that got thrown during on handler execution,
     * returning a ModelAndView that represents a specific error page if appropriate.
     * <p>May be overridden in subclasses, in order to apply specific exception checks.
     * Note that this template method will be invoked <i>after</i> checking whether this
     * resolved applies ("mappedHandlers" etc), so an implementation may simply proceed
     * with its actual exception handling.
     *
     * @param request  current HTTP request
     * @param response current HTTP response
     * @param handler  the executed handler, or {@code null} if none chosen at the time
     *                 of the exception (for example, if multipart resolution failed)
     * @param ex       the exception that got thrown during handler execution
     * @return a corresponding ModelAndView to forward to, or {@code null} for default processing
     */
    @Override
    protected ModelAndView doResolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
    {
        ModelAndView mv = null;
        String ajax = request.getHeader("x-requested-with");
        JsonResult jr = new JsonResult();
        Gson gson = null;
        PrintWriter pw = null;

        if(StringUtils.isNotEmpty(ajax))
        {
            //AJAX请求
            try
            {
                response.setStatus(500);
                response.setCharacterEncoding("UTF-8");
                pw = response.getWriter();
                pw.write(ex.getMessage());
                pw.flush();
                logger.error(ex);
            } catch (Exception e)
            {
                logger.error(e);
            } finally
            {
                if(pw != null) pw.close();
            }

            return null;

        }
        else
        {
            //普通请求
            mv = super.doResolveException(request,response,handler,ex);
            return mv;
        }
    }
}
