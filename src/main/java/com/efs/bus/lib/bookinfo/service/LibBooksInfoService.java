package com.efs.bus.lib.bookinfo.service;

import java.util.List;
import java.util.Map;

import com.efs.common.database.Page;
import com.efs.common.database.PageDataBunder;
import com.efs.bus.lib.bookinfo.mapper.LibBooksInfo;
import com.xwh.bean.SelectBean;

/**
 * 
 * com.efs.bus.lib.bookinfo.mapper.LibBooksInfoService
 * @author xwh
 * 2018-03-24 21:36:10
 * 图书信息表
 *
 */
public interface LibBooksInfoService
{
	/**
	 * 根据主键ID获取LibBooksInfo
	 * @param dbId
	 * @return
	 */
	public LibBooksInfo getLibBooksInfo(String biCode) throws Exception;
	
	/**
	 * 增加LibBooksInfo
	 * @param libBooksInfo
	 */
	public void addLibBooksInfo(List<LibBooksInfo> libBookInfoList) throws Exception;
	
	/**
	 * 更新LibBooksInfo
	 * @param empBean
	 */
	public void updateLibBooksInfo(LibBooksInfo libBooksInfo) throws Exception;
	
	/**
	 * 删除LibBooksInfo
	 * @param dbId
	 */
	public void deleteLibBooksInfo(LibBooksInfo libBooksInfo) throws Exception;
	
	
	/**
	 * 列举员工信息，带分页
	 * @param LibBooksInfo
	 * @return
	 */
	public PageDataBunder listLibBooksInfo(LibBooksInfo paramBean, Page page) throws Exception;

	/**
	 * 根据ISBN码在本地或者网络上搜索图书信息
	 * @param isbn
	 * @return
	 * @throws Exception
	 */
	public LibBooksInfo findBookInfoFromISBN(String isbn) throws Exception;

	/**
	 * 查询图书出版社信息
	 * @return
	 * @throws Exception
	 */
	public List<SelectBean> listBookPress() throws Exception;

	/**
	 * 检查图书是在借阅中出现过
	 * @param biCode
	 * @return
	 * @throws Exception
	 */
	public boolean checkBookInSend(String biCode) throws Exception;
	
}
