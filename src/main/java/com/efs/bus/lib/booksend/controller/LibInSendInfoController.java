package com.efs.bus.lib.booksend.controller;

import com.efs.bus.lib.bookinfo.mapper.LibBooksInfo;
import com.efs.bus.lib.bookinfo.service.LibBooksInfoService;
import com.efs.bus.lib.booksend.mapper.LibInSendInfo;
import com.efs.bus.lib.booksend.service.LibInSendInfoService;
import com.efs.bus.util.BusUtil;
import com.efs.common.controller.BaseController;
import com.efs.common.controller.JsonResult;
import com.efs.common.database.PageDataBunder;
import com.efs.common.interceptor.Auth;
import com.xwh.util.EFSUtil;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * 
 * com.efs.bus.lib.booksend.mapper.LibInSendInfoController
 * @author xwh
 * 2018-04-04 15:23:31
 * 在借图书信息表
 *
 */
@Controller
@RequestMapping("/lib/booksend")
public class LibInSendInfoController extends BaseController
{
	@Resource(name="libInSendInfoService")
	private LibInSendInfoService libInSendInfoService;

	@Resource(name="libBooksInfoService")
	private LibBooksInfoService libBooksInfoService;
	
	/**
	 * 进入LibInSendInfo页面
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/gotoLibInSendInfoPage")
	@Auth
	public String gotoLibInSendInfoPage() throws Exception
	{
		return "/libary/libSendBookPage";
	}
	
	/**
	 * 查询LibInSendInfoGrid列表
	 * @param paramBean
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/listUserLibInSendInfo")
	@Auth
	public PageDataBunder listUserLibInSendInfo(HttpServletRequest request,String userId) throws Exception
	{
		return libInSendInfoService.listUserInSendInfo(userId,getPage(request));
	}
	
	/**
	 * 查询单个LibInSendInfo信息
	 * @param roleDbId
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getLibInSendUserInfo")
	@Auth
	public LibInSendInfo getLibInSendUserInfo(String userId) throws Exception
	{
		return libInSendInfoService.getSendUserInfo(userId);
	}
	
	/**
	 * 新增LibInSendInfo信息
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/addLibInSendInfo")
	@Auth("role_addLibInSendInfo")
	public JsonResult addLibInSendInfo(HttpServletRequest request, HttpServletResponse resp, LibInSendInfoForm libInSendInfoForm) throws Exception
	{
		LibInSendInfo libInSendInfo = new LibInSendInfo();
		BeanUtils.copyProperties(libInSendInfo, libInSendInfoForm);
		libInSendInfoService.addLibInSendInfo(libInSendInfo);
		return packJsonResult4Form(true, resp);
	}
	
	/**
	 * 更新LibInSendInfo信息
	 * @param roleDbId
	 * @return
	 */
	@RequestMapping(value="/updateLibInSendInfo")
	@ResponseBody
	@Auth("role_updateLibInSendInfo")
	public JsonResult updateLibInSendInfo(HttpServletRequest request,HttpServletResponse resp,LibInSendInfoForm libInSendInfoForm) throws Exception
	{
		LibInSendInfo libInSendInfo = new LibInSendInfo();
		BeanUtils.copyProperties(libInSendInfo, libInSendInfoForm);
		libInSendInfoService.updateLibInSendInfo(libInSendInfo);
		return packJsonResult4Form(true, resp);
	}
	
	/**
	 * 刪除LibInSendInfo
	 * @param roleId
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping("/deleteLibInSendInfo")
	@Auth("role_deleteLibInSendInfo")
	public JsonResult deleteLibInSendInfo(String isId) throws Exception
	{
		libInSendInfoService.deleteLibInSendInfo(isId);
		return packJsonResult(true);
	}

	/**
	 * 检查用户是否可以借阅图书<br/>
	 * 	 00：可以借<br/>
	 * 	 01：用于没有借书的权限<br/>
	 * 	 02：该图书已经借出<br/>
	 * 	 03：用户的图书已经借满<br/>
	 * 	 04：用户存在挂失未处理的图书<br/>
	 * 	 05：该图书已经丢失或作废，不可再借<br/>
	 * @param userId
	 * @param bookCode
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping("/checkUserSendBook")
	@Auth
	public JsonResult checkUserSendBook(String userId, String bookCode ) throws Exception
	{
		String res;
		Map<String,String> resMap = new HashMap<>();

		res = libInSendInfoService.checkUserSendBook(userId,bookCode);
		resMap.put("code",res);
		resMap.put("message",BusUtil.getSendBookChkStr(res));
		return packJsonResult(true,resMap);
	}

    /**
     * 执行借书动作
     * @param session
     * @param userId
     * @param bookCode
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping("/doSendBook")
    @Auth
	public JsonResult doSendBook(HttpSession session,String userId,String bookCode) throws Exception
    {
        //判断是否可以借书
        String res = libInSendInfoService.checkUserSendBook(userId,bookCode);
        if(!"00".equals(res))
        {
            //不具备借书条件，返回相关的信息
            return packJsonResult(false,BusUtil.getSendBookChkStr(res));
        }

        //处理借书逻辑
        LibInSendInfo libInSendInfo = new LibInSendInfo();
        libInSendInfo.setIsBookCode(bookCode);
        libInSendInfo.setIsUserId(userId);
        libInSendInfo.setIsSendHandler(getSessionUserId(session));
        libInSendInfo.setIsStartDate(EFSUtil.getSysFormatDate());
        libInSendInfo.setIsStartTime(EFSUtil.getSysFormatTime());

        libInSendInfoService.donSendBooks(libInSendInfo);

        return packJsonResult(true);

    }

	/**
	 * 进入还书页面
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/gotoBackBookPage")
	@Auth
	public String gotoBackBookPage() throws Exception
	{
		return "/libary/libBackBookPage";
	}

	/**
	 * 检查用户是否可以归还图书<br/>
	 *
	 * @param userId
	 * @param bookCode
	 * @return 00:可归还<br/>
	 * 01：图书尚未入库<br/>
	 * 02：图书尚未借出<br/>
	 * 03：图书不是由当前用户借出<br/>
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping("/checkUserBackBook")
	@Auth
	public JsonResult checkUserBackBook(String userId, String bookCode ) throws Exception
	{
		String res;
		Map<String,String> resMap = new HashMap<>();

		res = libInSendInfoService.checkUserBackBook(userId,bookCode);
		resMap.put("code",res);
		resMap.put("message",BusUtil.getBackBookChkStr(res));
		return packJsonResult(true,resMap);
	}

	/**
	 * 执行还书动作
	 * @param session
	 * @param userId
	 * @param bookCode
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping("/doBackBook")
	@Auth
	public JsonResult doBackBook(HttpSession session,String userId,String bookCode) throws Exception
	{
		//判断是否可以借书
		String res = libInSendInfoService.checkUserBackBook(userId,bookCode);
		if(!"00".equals(res))
		{
			//不具备借书条件，返回相关的信息
			return packJsonResult(false,BusUtil.getSendBookChkStr(res));
		}

		//处理还书逻辑
		LibInSendInfo libInSendInfo = new LibInSendInfo();
		libInSendInfo.setIsBookCode(bookCode);
		libInSendInfo.setIsUserId(userId);
		libInSendInfo.setIsBackHandler(getSessionUserId(session));
		libInSendInfo.setIsBackDate(EFSUtil.getSysFormatDate());
		libInSendInfo.setIsBackTime(EFSUtil.getSysFormatTime());

		libInSendInfoService.donBackBooks(libInSendInfo);

		return packJsonResult(true);

	}

	/**
	 * 执行挂失动作
	 * @param session
	 * @param userId
	 * @param bookCode
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping("/doRegLoseBook")
	@Auth
	public JsonResult doRegLoseBook(HttpSession session,LibInSendInfoForm libInSendInfoForm) throws Exception
	{
		LibInSendInfo libInSendInfo = new LibInSendInfo();
		BeanUtils.copyProperties(libInSendInfo, libInSendInfoForm);

		libInSendInfo.setBlRegDate(EFSUtil.getSysFormatDate());
		libInSendInfo.setBiRegTime(EFSUtil.getSysFormatTime());
		libInSendInfo.setBlRegUser(getSessionUserId(session));

		//判断是否可以挂失(与判断是否可以归还一样的逻辑）
		String res = libInSendInfoService.checkUserBackBook(libInSendInfoForm.getIsUserId(),libInSendInfoForm.getIsBookCode());
		if(!"00".equals(res))
		{
			//不具备挂失条件，返回相关的信息
			return packJsonResult(false,BusUtil.getSendBookChkStr(res));
		}

		//处理挂失逻辑
		libInSendInfoService.donRegLosBook(libInSendInfo);

		return packJsonResult(true);
	}

	/**
	 * 检查用户是否可以解挂图书<br/>
	 * @param userId
	 * @param bookCode
	 * @return
	 * 00:可归还<br/>
	 * 01：图书尚未入库<br/>
	 * 02：图书尚未挂失<br/>
	 * 03：图书不是由当前用户挂失<br/>
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping("/checkUserCompkBook")
	@Auth
	public JsonResult checkUserCompkBook(String userId, String bookCode ) throws Exception
	{
		String res;
		Map<String,String> resMap = new HashMap<>();

		res = libInSendInfoService.checkUserCompBook(userId,bookCode);
		resMap.put("code",res);
		resMap.put("message",BusUtil.getCompBookChkStr(res));
		return packJsonResult(true,resMap);
	}

	/**
	 * 执行挂失动作
	 * @param session
	 * @param userId
	 * @param bookCode
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping("/doCompBook")
	@Auth
	public JsonResult doCompBook(HttpSession session,LibInSendInfoForm libInSendInfoForm) throws Exception
	{
		LibInSendInfo libInSendInfo = new LibInSendInfo();
		BeanUtils.copyProperties(libInSendInfo, libInSendInfoForm);


		libInSendInfo.setBlCompHandler(getSessionUserId(session));

		//判断是否可以解挂
		String res = libInSendInfoService.checkUserCompBook(libInSendInfoForm.getIsUserId(),libInSendInfoForm.getIsBookCode());
		if(!"00".equals(res))
		{
			//不具备解挂条件，返回相关的信息
			return packJsonResult(false,BusUtil.getCompBookChkStr(res));
		}
		else
		{
			if("03".equals(libInSendInfoForm.getBiCompType()))
			{
				//检查原书与新书的编码是否一致
				if(!libInSendInfoForm.getIsBookCode().equals(libInSendInfoForm.getBlCompBookCode()))
				{
					return packJsonResult(false,BusUtil.getCompBookChkStr("04"));
				}
			}
			else if("02".equals(libInSendInfoForm.getBiCompType()))
			{
				//检查新书是否已经入库
				LibBooksInfo booksInfo = libBooksInfoService.getLibBooksInfo(libInSendInfoForm.getBlCompBookCode());
				if(booksInfo == null)
				{
					return packJsonResult(false,BusUtil.getCompBookChkStr("05"));
				}
			}
		}

		//处理挂失逻辑
		libInSendInfoService.donCompBook(libInSendInfo);

		return packJsonResult(true);
	}

	/**
	 * 进入我的借阅页面
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/gotoUserAllSendInfo")
	@Auth
	public String gotoUserAllSendInfo(HttpSession session, Model model,String flag,String userId,String bookCode) throws Exception
	{
		model.addAttribute("flag",flag);
		model.addAttribute("userId",userId);
		model.addAttribute("bookCode",bookCode);
		return "/libary/libMyBookSendPage";
	}

	/**
	 *
	 * @param request
	 * @param libInSendInfoForm
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping("/listUserAllSendInfo")
	@Auth
	public PageDataBunder listUserAllSendInfo(HttpSession session,HttpServletRequest request,LibInSendInfoForm libInSendInfoForm) throws Exception
	{
		LibInSendInfo libInSendInfo = new LibInSendInfo();
		BeanUtils.copyProperties(libInSendInfo, libInSendInfoForm);

		if(StringUtils.isEmpty(libInSendInfo.getIsUserId()))
		{
			libInSendInfo.setIsUserId(getSessionUserId(session));
		}

		return libInSendInfoService.listUserAllSendInfo(libInSendInfo,getPage(request));
	}

	/**
	 *
	 * @param request
	 * @param libInSendInfoForm
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/gotoShowSendPage")
	@Auth
	public String gotoShowSendPage(String isId,Model model) throws Exception
	{
		LibInSendInfo libInSendInfo = libInSendInfoService.getLibInSendInfo(isId);
		model.addAttribute("libInSendInfo",libInSendInfo);
		return "/libary/libShowSendPage";
	}
}
