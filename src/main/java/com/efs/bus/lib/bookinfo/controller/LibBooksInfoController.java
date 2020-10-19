package com.efs.bus.lib.bookinfo.controller;

import com.efs.bus.lib.addr.mapper.LibShelfAddInfo;
import com.efs.bus.lib.bookinfo.mapper.LibBooksInfo;
import com.efs.bus.lib.bookinfo.service.LibBooksInfoService;
import com.efs.bus.lib.booktype.mapper.LibBookTypeInfo;
import com.efs.bus.lib.booktype.service.LibBookTypeInfoService;
import com.efs.bus.libary.service.LibShelfInfoService;
import com.efs.bus.util.BusUtil;
import com.efs.common.Util.IDUtil;
import com.efs.common.Util.SysUtils;
import com.efs.common.controller.BaseController;
import com.efs.common.controller.JsonResult;
import com.efs.common.database.PageDataBunder;
import com.efs.common.interceptor.Auth;
import com.xwh.bean.SelectBean;
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
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * com.efs.bus.lib.bookinfo.mapper.LibBooksInfoController
 * @author xwh
 * 2018-03-24 21:36:10
 * 图书信息表
 *
 */
@Controller
@RequestMapping("/lib/bookAdmin")
public class LibBooksInfoController extends BaseController
{
	@Resource(name="libBooksInfoService")
	private LibBooksInfoService libBooksInfoService;

    @Resource(name="libBookTypeInfoService")
	private LibBookTypeInfoService libBookTypeInfoService;

	@Resource(name="libShelfInfoService")
    private LibShelfInfoService libShelfInfoService;


	/**
	 * 进入LibBooksInfo页面
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/gotoLibBooksInfoPage")
	@Auth
	public String gotoLibBooksInfoPage() throws Exception
	{
		return "/sysadmin/roleadmin/roleAdminPage";
	}
	
	/**
	 * 查询LibBooksInfoGrid列表
	 * @param paramBean
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/listLibBooksInfo")
	@Auth
	public PageDataBunder listLibBooksInfo(HttpSession session,HttpServletRequest request,LibBooksInfoForm libBooksInfoForm) throws Exception
	{
		LibBooksInfo libBooksInfo = new LibBooksInfo();

        libBooksInfoForm = (LibBooksInfoForm)getReturnBackParameter(session,"libBooksInfoForm",libBooksInfoForm);
		
		BeanUtils.copyProperties(libBooksInfo, libBooksInfoForm);
		return libBooksInfoService.listLibBooksInfo(libBooksInfo,getPage(request));
	}
	
	/**
	 * 查询单个LibBooksInfo信息
	 * @param roleDbId
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getLibBooksInfo")
	@Auth
	public LibBooksInfo getLibBooksInfo(String biCode) throws Exception
	{
		return libBooksInfoService.getLibBooksInfo(biCode);
	}
	
	/**
	 * 新增LibBooksInfo信息
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/addLibBooksInfo")
	@Auth
	public JsonResult addLibBooksInfo(HttpSession session, HttpServletResponse resp, LibBooksInfoForm libBooksInfoForm) throws Exception
	{
		List<String> bookCodeList = new ArrayList<>();
		int repeatCont = 1;
		LibBooksInfo libBooksInfo = new LibBooksInfo();
		BeanUtils.copyProperties(libBooksInfo, libBooksInfoForm);

		List<LibBooksInfo> booksInfoList = new ArrayList<>();
		SysUtils.packAddObjectProp(getSessionUserId(session),libBooksInfo);
		libBooksInfo.setBiInDate(EFSUtil.getSysFormatDate());
		libBooksInfo.setBiInUser(getSessionUserId(session));
		libBooksInfo.setBiPrice(Double.toString(EFSUtil.getDoubleFrmStr(libBooksInfo.getBiPrice())));

		if(StringUtils.isNotEmpty(libBooksInfo.getRepeatCont()))
		{
			repeatCont = Integer.parseInt(libBooksInfo.getRepeatCont());
		}

		for(int i=0;i<repeatCont;i++)
		{
			LibBooksInfo tmpBook = new LibBooksInfo();
			BeanUtils.copyProperties(tmpBook, libBooksInfo);
			tmpBook.setBiCode(IDUtil.getId("ID_BOOK_CODE"));
			bookCodeList.add(tmpBook.getBiCode());
			booksInfoList.add(tmpBook);
		}

		libBooksInfoService.addLibBooksInfo(booksInfoList);
		return packJsonResult4Form(true, bookCodeList,resp);
	}
	
	/**
	 * 更新LibBooksInfo信息
	 * @param roleDbId
	 * @return
	 */
	@RequestMapping(value="/updateLibBooksInfo")
	@ResponseBody
	@Auth("role_updateLibBooksInfo")
	public JsonResult updateLibBooksInfo(HttpSession session,HttpServletResponse resp,LibBooksInfoForm libBooksInfoForm) throws Exception
	{
		LibBooksInfo libBooksInfo = new LibBooksInfo();
		BeanUtils.copyProperties(libBooksInfo, libBooksInfoForm);
		SysUtils.packUpdObjectProp(getSessionUserId(session),libBooksInfo);
		libBooksInfoService.updateLibBooksInfo(libBooksInfo);
		return packJsonResult4Form(true, resp);
	}
	
	/**
	 * 刪除LibBooksInfo
	 * @param roleId
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping("/deleteLibBooksInfo")
	@Auth("role_deleteLibBooksInfo")
	public JsonResult deleteLibBooksInfo(HttpSession session,String biCode,String biReason) throws Exception
	{
		LibBooksInfo libBooksInfo = new LibBooksInfo();
		libBooksInfo.setBiCode(biCode);
		libBooksInfo.setDelDate(EFSUtil.getSysFormatDate());
		libBooksInfo.setDelTime(EFSUtil.getSysFormatTime());
		libBooksInfo.setDelUser(getSessionUserId(session));
		libBooksInfo.setDelReason(biReason);

		libBooksInfoService.deleteLibBooksInfo(libBooksInfo);
		return packJsonResult(true);
	}

	/**
	 * 进入新增图书页面
	 * @param session
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/gotoAddBookPage")
	@Auth
	public String gotoAddBookPage(HttpSession session , Model model) throws Exception
	{
		String batchNum = EFSUtil.getTimeStamp();
		model.addAttribute("batchNum",batchNum);

		List<SelectBean> selectBeanList = libBooksInfoService.listBookPress();
		model.addAttribute("selectBeanList",selectBeanList);

		List<LibBookTypeInfo> bookTypeInfoList = libBookTypeInfoService.listAllChildBookType();
        model.addAttribute("bookTypeInfoList",bookTypeInfoList);

        List<LibShelfAddInfo> libShelfAddInfoList = libShelfInfoService.listAllAddr();
		model.addAttribute("libShelfAddInfoList",libShelfAddInfoList);

		return "/libary/libAddBookPage";
	}

    /**
     * 获取图书出版社信息
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping("/getBookPress")
    @Auth
	public List<SelectBean> getBookPress() throws Exception
    {
        return libBooksInfoService.listBookPress();
    }

    /**
     * 根据ISBN码查询图书信息
     * @param biIsbn
     * @param model
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping("/getBooksInfoFromISBN")
    @Auth
    public LibBooksInfo getBooksInfoFromISBN(String biIsbn,String biInBatchNo) throws Exception
    {
        LibBooksInfo booksInfo = libBooksInfoService.findBookInfoFromISBN(biIsbn);
        booksInfo.setBiInBatchNo(biInBatchNo);
        return booksInfo;
    }

	/**
	 * 检查图书是否可以删除-只有在图书借阅表未出现过的才能删除
	 * @param biCode
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping("/checkBookDelete")
	@Auth
    public JsonResult checkBookDelete(String biCode) throws Exception
	{
		String res = "";

		if(!libBooksInfoService.checkBookInSend(biCode))
		{
			//只有未被借阅过的图书才能删除
			res = "Y";
		}
		else
		{
			res = "N";
		}

		return packJsonResult(true,res);
	}

	/**
	 * 进入图书查看页面
	 * @param biCode
	 * @param flag
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/gotoShowBookPage")
	@Auth
	public String gotoShowBookPage(String biCode,String flag,Model model) throws Exception
	{
		LibBooksInfo booksInfo = libBooksInfoService.getLibBooksInfo(biCode);

		LibBooksInfo.specHandForShow(booksInfo);
		model.addAttribute("booksInfo",booksInfo);
		model.addAttribute("flag",flag);

		return "/libary/libShowBookPage";
	}

	/**
	 * 进入图书查询页面
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/gotoListBookPage")
	@Auth
	public String gotoListBookPage(Model model) throws Exception
	{

		List<LibBookTypeInfo> bookTypeInfoList = libBookTypeInfoService.listAllChildBookType();
		model.addAttribute("bookTypeInfoList",bookTypeInfoList);
		return "/libary/libListBookPage";
	}
}
