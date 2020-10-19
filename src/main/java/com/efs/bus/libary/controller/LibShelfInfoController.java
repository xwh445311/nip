package com.efs.bus.libary.controller;

import com.efs.bus.libary.mapper.LibShelfInfo;
import com.efs.bus.libary.service.LibShelfInfoService;
import com.efs.common.Util.SysUtils;
import com.efs.common.controller.BaseController;
import com.efs.common.controller.JsonResult;
import com.efs.common.database.PageDataBunder;
import com.efs.common.interceptor.Auth;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * 
 * com.efs.bus.libary.mapper.LibShelfInfoController
 * @author xuwh
 * 2018-03-19 10:52:52
 * 书架信息表
 *
 */
@Controller
@RequestMapping("/lib")
public class LibShelfInfoController extends BaseController
{
	@Resource(name="libShelfInfoService")
	private LibShelfInfoService libShelfInfoService;


	/**
	 * 进入LibShelfInfo页面
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/gotoLibShelfInfoPage")
	@Auth
	public String gotoLibShelfInfoPage() throws Exception
	{
		return "/libary/libAdminPage";
	}
	
	/**
	 * 查询LibShelfInfoGrid列表
	 * @param paramBean
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/listLibShelfInfo")
	@Auth
	public PageDataBunder listLibShelfInfo(HttpSession session,HttpServletRequest request,LibShelfInfoForm libShelfInfoForm) throws Exception
	{
		LibShelfInfo libShelfInfo = new LibShelfInfo();
		
		BeanUtils.copyProperties(libShelfInfo, libShelfInfoForm);
		return libShelfInfoService.listLibShelfInfo(libShelfInfo,getPage(request));
	}
	
	/**
	 * 查询单个LibShelfInfo信息
	 * @param roleDbId
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getLibShelfInfo")
	@Auth
	public LibShelfInfo getLibShelfInfo(String lsNo) throws Exception
	{
		return libShelfInfoService.getLibShelfInfo(lsNo);
	}
	
	/**
	 * 新增LibShelfInfo信息
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/addLibShelfInfo")
	@Auth("role_addLibShelfInfo")
	public JsonResult addLibShelfInfo(HttpSession session, HttpServletResponse resp, LibShelfInfoForm libShelfInfoForm) throws Exception
	{
		LibShelfInfo libShelfInfo = new LibShelfInfo();
		BeanUtils.copyProperties(libShelfInfo, libShelfInfoForm);
		libShelfInfo.setLsNo(libShelfInfoService.getNexShelfNo());

		//设置起始地址
		List<String> addrList = SysUtils.getShielfAddrDetail(libShelfInfo.getLsNo(),libShelfInfo.getLsRowCnt(),libShelfInfo.getLsColCnt());
        libShelfInfo.setLsStarAddr(addrList.get(0));
        libShelfInfo.setLsEndAddr(addrList.get(addrList.size() -1));
        SysUtils.packAddObjectProp(getSessionUserId(session),libShelfInfo);

        //添加数架信息
		libShelfInfoService.addLibShelfInfo(libShelfInfo,addrList);

		return packJsonResult4Form(true, resp);
	}


	
	/**
	 * 更新LibShelfInfo信息
	 * @param roleDbId
	 * @return
	 */
	@RequestMapping(value="/updateLibShelfInfo")
	@ResponseBody
	@Auth("role_updateLibShelfInfo")
	public JsonResult updateLibShelfInfo(HttpSession session,HttpServletResponse resp,LibShelfInfoForm libShelfInfoForm) throws Exception
	{
		LibShelfInfo libShelfInfo = new LibShelfInfo();
		BeanUtils.copyProperties(libShelfInfo, libShelfInfoForm);
        List<String> addrList = SysUtils.getShielfAddrDetail(libShelfInfo.getLsNo(),libShelfInfo.getLsRowCnt(),libShelfInfo.getLsColCnt());

        libShelfInfo.setLsStarAddr(addrList.get(0));
        libShelfInfo.setLsEndAddr(addrList.get(addrList.size() -1));

        SysUtils.packUpdObjectProp(getSessionUserId(session),libShelfInfo);

		libShelfInfoService.updateLibShelfInfo(libShelfInfo);
		return packJsonResult4Form(true, resp);
	}
	
	/**
	 * 刪除LibShelfInfo
	 * @param roleId
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping("/deleteLibShelfInfo")
	@Auth("role_deleteLibShelfInfo")
	public JsonResult deleteLibShelfInfo(String lsNo) throws Exception
	{
		libShelfInfoService.deleteLibShelfInfo(lsNo);
		return packJsonResult(true);
	}

    /**
     * 检查书架是否已经在用，1表示在用，0表示未用
     * @param lsNo
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping("/checkShielfInUse")
    @Auth
	public JsonResult checkShielfInUse(String lsNo) throws Exception
    {
        LibShelfInfo libShelfInfo = libShelfInfoService.getLibShelfInfo(lsNo);
        String res  = null;
        if("1".equals(libShelfInfo.getLsUseStatus()))
        {
            res = "1";
        }
        else
        {
            res = "0";
        }

        return packJsonResult(true,res);
    }

    /**
     * 进入收架地址页面
     * @param model
     * @return
     * @throws Exception
     */
    @RequestMapping("/gotoShielfAddrPage")
    @Auth
    public String gotoShielfAddrPage(Model model,String lsNo) throws Exception
    {
        List<LibShelfInfo> libShelfInfoList = libShelfInfoService.listAllShelf();

        model.addAttribute("libShelfInfoList",libShelfInfoList);
        model.addAttribute("lsNo",lsNo);

        return "/libary/libAddrPage";
    }
}
