package com.efs.common.auth.user.controller;

import com.efs.bus.util.BusUtil;
import com.efs.common.Util.IDUtil;
import com.efs.common.Util.SysConstant;
import com.efs.common.Util.SysUtils;
import com.efs.common.auth.role.mapper.TsRoleInfo;
import com.efs.common.auth.role.service.TsRoleInfoService;
import com.efs.common.auth.user.mapper.TsUserInfo;
import com.efs.common.auth.user.service.TsUserInfoService;
import com.efs.common.barcode.ZXingCode;
import com.efs.common.controller.BaseController;
import com.efs.common.controller.JsonResult;
import com.efs.common.database.PageDataBunder;
import com.efs.common.interceptor.Auth;
import com.xwh.bean.SelectBean;
import com.xwh.util.EFSUtil;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;

/**
 * 
 * com.efs.common.auth.user.mapper.TsUserInfoController
 * @author xwh
 * 2017-06-20 15:35:18
 * 系统用户信息表
 *
 */
@Controller
@RequestMapping("/sysadmin/userAdmin")
public class TsUserInfoController extends BaseController
{
	@Resource(name="tsUserInfoService")
	private TsUserInfoService tsUserInfoService;

	@Resource(name="tsRoleInfoService")
	private TsRoleInfoService tsRoleInfoService;
	
	/**
	 * 进入TsUserInfo页面
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/gotoTsUserInfoPage")
	@Auth
	public String gotoTsUserInfoPage(Model model) throws Exception
	{
		Map<String,Object> busTypeMapper = EFSUtil.getDBParamMap(SysConstant.DB_PARAM_TYPE_USER_TYPE);
		model.addAttribute("busType",busTypeMapper);
		return "/admin/sysadmin/user/userAdminPage";
	}
	
	/**
	 * 查询TsUserInfoGrid列表
	 * @param paramBean
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/listTsUserInfo")
	@Auth
	public PageDataBunder listTsUserInfo(HttpSession session,HttpServletRequest request,TsUserInfoForm tsUserInfoForm) throws Exception
	{
		TsUserInfo tsUserInfo = new TsUserInfo();
		
		BeanUtils.copyProperties(tsUserInfo, tsUserInfoForm);

		tsUserInfo.setIsSuperUser(getSuperUser(session));

		return tsUserInfoService.listTsUserInfo(tsUserInfo,getPage(request));
	}
	
	/**
	 * 查询单个TsUserInfo信息
	 * @param roleDbId
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getTsUserInfo")
	@Auth
	public TsUserInfo getTsUserInfo(String uiId) throws Exception
	{
		TsUserInfo userInfo = tsUserInfoService.getTsUserInfo(uiId);
		userInfo.specHand4Show();
		return userInfo;
	}
	
	/**
	 * 新增TsUserInfo信息
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/addTsUserInfo")
	@Auth("role_addTsUserInfo")
	public JsonResult addTsUserInfo(HttpSession session, HttpServletRequest request, HttpServletResponse resp, TsUserInfoForm tsUserInfoForm) throws Exception
	{
		TsUserInfo tsUserInfo = new TsUserInfo();
		TsUserInfo logUser = getSessionUser(session);
		BeanUtils.copyProperties(tsUserInfo, tsUserInfoForm);

		tsUserInfo.setUiId(IDUtil.getId("ID_SYS_USER_ID"));
		tsUserInfo.setUiAddUser(logUser.getUiId());
		tsUserInfo.setUiUpdUser(logUser.getUiId());

		//对于新增用户，密码默认使用用户名
		tsUserInfo.setUiPassword(tsUserInfo.getUiId());

		tsUserInfo.specHand4Save();

		tsUserInfoService.addTsUserInfo(tsUserInfo);
		tsUserInfoService.addUserRole(tsUserInfo);
		tsUserInfoService.addUsserOrgs(tsUserInfo);
		return packJsonResult4Form(true, resp);
	}
	
	/**
	 * 更新TsUserInfo信息
	 * @param roleDbId
	 * @return
	 */
	@RequestMapping(value="/updateTsUserInfo")
	@ResponseBody
	@Auth("role_updateTsUserInfo")
	public JsonResult updateTsUserInfo(HttpSession session, HttpServletRequest request, HttpServletResponse resp, TsUserInfoForm tsUserInfoForm) throws Exception
	{
		TsUserInfo logUser = getSessionUser(session);
		TsUserInfo tsUserInfo = new TsUserInfo();
		BeanUtils.copyProperties(tsUserInfo, tsUserInfoForm);

		tsUserInfo.setUiUpdUser(logUser.getUiId());

		tsUserInfo.specHand4Save();
		tsUserInfoService.updateTsUserInfo(tsUserInfo);
		tsUserInfoService.addUserRole(tsUserInfo);
		tsUserInfoService.addUsserOrgs(tsUserInfo);
		return packJsonResult4Form(true, resp);
	}
	
	/**
	 * 刪除TsUserInfo
	 * @param roleId
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping("/deleteTsUserInfo")
	@Auth("role_deleteTsUserInfo")
	public JsonResult deleteTsUserInfo(String uiId) throws Exception
	{
		tsUserInfoService.deleteTsUserInfo(uiId);
		return packJsonResult(true);
	}

	/**
	 * 检查用户ID是否重复
	 * @param uiId
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping("/checkUserIdRepeat")
	@Auth
	public String checkUserIdRepeat(String uiId,String handType) throws Exception
	{

		if("A".equals(handType))
		{
			TsUserInfo userInfo = tsUserInfoService.getTsUserInfo(uiId);

			if(userInfo == null)
			{
				return "true";
			}
			else
			{
				return "false";
			}
		}
		else
		{
			return "true";
		}

	}

	/**
	 * 检查用户ID是否重复
	 * @param uiId
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping("/checkShortNameRepeat")
	@Auth
	public String checkShortNameRepeat(String uiShortName,String uiId) throws Exception
	{

		if(tsUserInfoService.checkShortNameExist(uiShortName,uiId))
		{
			return "false";
		}
		else
		{
			return "true";
		}

	}

	/**
	 * 校验用户密码是否正确
	 * @param session
	 * @param oldPassword
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping("/checkUserPassword")
	@Auth
	public String checkUserPassword(HttpSession session,String oldPassword) throws Exception
	{
		TsUserInfo user = tsUserInfoService.getTsUserInfo(getSessionUserId(session));
		oldPassword = EFSUtil.md5Encoding(oldPassword);

		String res ="";

		if(oldPassword.equals(user.getUiPassword()))
		{
			res = "true";
		}
		else
		{
			res = "false";
		}

		return res;
	}

	/**
	 * 修改用户密码
	 * @param session
	 * @param oldPassword
	 * @param newPassword
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping("/updateUserPass")
	@Auth
	public JsonResult updateUserPass(HttpSession session,String oldPassword,String newPassword) throws Exception
	{
		TsUserInfo user = tsUserInfoService.getTsUserInfo(getSessionUserId(session));
		oldPassword = EFSUtil.md5Encoding(oldPassword);

		if(oldPassword.equals(user.getUiPassword()))
		{
			//修改密码
			tsUserInfoService.updateUserPassword(user.getUiId(),EFSUtil.md5Encoding(newPassword));
			return packJsonResult(true);
		}
		else
		{
			return packJsonResult(false);
		}
	}

	/**
	 * 获取通讯录信息
	 * @param keyWord
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping("/queryAddressBook")
	@Auth("role_queryAddressBook")
	public JsonResult queryAddressBook(String keyWord,HttpServletRequest request) throws Exception
	{
		List<TsUserInfo> userInfoList = tsUserInfoService.listAddressBook(keyWord);
		String htmlStr = BusUtil.genAddressBookHtml(userInfoList,request.getContextPath());

		return packJsonResult(true,htmlStr);
	}

    /**
     * 获得二维码
     * @param userId
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping("/getVcardBarCode")
    @Auth
	public String getVcardBarCode(String userId,HttpServletResponse  response) throws Exception
    {
        TsUserInfo userInfo = tsUserInfoService.listAddressBook(userId).get(0);
        String vcard = BusUtil.genVCArdString(userInfo);
        String name  = userInfo.getUiName();

        BufferedImage bi = null;
        OutputStream os = null;

        try
        {
            bi = ZXingCode.getCodeImage(null,vcard,name);
            os = response.getOutputStream();
            ImageIO.write(bi,"png",os);
        } finally
        {
            if(null != os)
            {
                os.close();
            }
        }

        return null;
    }


	/**
	 * 首次登录，修改密码
	 * @param session
	 * @param oldPassword
	 * @param newPassword
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/updateUserPassFirst")
	@Auth
    public String updateUserPassFirst(HttpSession session,String oldPassword,String newPassword,Model model) throws Exception
	{
		String msg;
		TsUserInfo user = tsUserInfoService.getTsUserInfo(getSessionUserId(session));
		oldPassword = EFSUtil.md5Encoding(oldPassword);

		if(oldPassword.equals(EFSUtil.md5Encoding(newPassword)))
		{
			msg = "新密码不能与旧密码一样，请重新修改";
			model.addAttribute("msg",msg);
			return "/admin/changePassPage";
		}

		if(oldPassword.equals(user.getUiPassword()))
		{
			//修改密码
			tsUserInfoService.updateUserPasswordFirst(user.getUiId(),EFSUtil.md5Encoding(newPassword));
			return "redirect:/login/gotoLogin.do";
		}
		else
		{
			msg = "旧密码输入错误，请重新输入";
			model.addAttribute("msg",msg);
			return "/admin/changePassPage";
		}
	}

	/**
	 * 获取用户的角色数据
	 * @param uiId
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping("/getUserRoleList")
	@Auth
	public JsonResult getUserRoleList(String uiId) throws Exception
	{
		List<TsRoleInfo> roleInfoList = tsRoleInfoService.listUserRole(uiId);
		StringBuilder sb = new StringBuilder();
		if(CollectionUtils.isNotEmpty(roleInfoList))
		{
			for (TsRoleInfo role : roleInfoList)
			{
				sb.append("[" + role.getRiId() + "]&nbsp;" + role.getRiName() + "<br/>");
			}
		}
		else
		{
			sb.append("该用户未设置任何角色");
		}

		return packJsonResult(true,sb.toString());
	}

	/**
	 * 重置用户的密码
	 * @param uiId
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping("/resetUserPassword")
	@Auth
	public JsonResult resetUserPassword(String uiId) throws Exception
	{
		String password = EFSUtil.md5Encoding(uiId);
		tsUserInfoService.updateResetPassword(uiId,password);
		return packJsonResult(true);
	}

	/**
	 * 查询机构下的用户列表
	 * @param userOrg
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping("/listOrgUserList")
	@Auth
	public JsonResult listOrgUserList(String userOrg) throws Exception
	{
		List<SelectBean> orgUserList = tsUserInfoService.listUserInOrgSelect(userOrg);
		return packJsonResult(true,orgUserList);
	}
}
