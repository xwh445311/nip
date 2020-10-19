package com.efs.common.error.controller;

import com.efs.common.Util.SysConstant;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * 系统错误处理CONTROLLER
 * @author xwh
 *
 */
@Controller
@RequestMapping("/error")
public class ErrorController
{
	/**
	 * 跳转到没有权限的页面
	 * @return
	 */
	@RequestMapping("/gotoNoright")
	public String gotoNoright(HttpSession session,Model model)
	{
		model.addAttribute("errorForm",session.getAttribute(SysConstant.SESSION_KEY_ERROR));
		session.invalidate();
		return "/error/noright";
	}
}
