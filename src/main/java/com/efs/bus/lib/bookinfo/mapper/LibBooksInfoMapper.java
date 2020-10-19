package com.efs.bus.lib.bookinfo.mapper;

import java.util.List;
import java.util.Map;

import com.efs.common.database.Page;
import com.efs.common.database.PageDataBunder;
import com.xwh.bean.SelectBean;


/**
 * 
 * com.efs.bus.lib.bookinfo.mapper.LibBooksInfoMapper
 * @author xwh
 * 2018-03-24 21:36:10
 * 图书信息表
 *
 */
public interface LibBooksInfoMapper
{
	/**
	 * 根据主键ID获取LibBooksInfo
	 * @param biCode
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
	 * @param biCode
	 */
	public void deleteLibBooksInfo(String biCode) throws Exception;
	
	
	/**
	 * 列举员工信息，带分页
	 * @param LibBooksInfo
	 * @return
	 */
	public PageDataBunder listLibBooksInfo(LibBooksInfo paramBean, Page page) throws Exception;

	/**
	 * 根据ISBN码搜索图书
	 * @param isbn
	 * @return
	 * @throws Exception
	 */
	public LibBooksInfo findLibBooksInfoFromIsbn(String isbn) throws Exception;

    /**
     * 列举出版社信息
     * @return
     * @throws Exception
     */
	public List<String> listLibPress() throws Exception;

	/**
	 * 将图书信息插入到删除表中
	 * @param paramBean
	 * @throws Exception
	 */
	public void addToDelInfo(LibBooksInfo paramBean) throws Exception;

	/**
	 * 更新图书状态
	 * @param biCode
	 * @param status
	 * @throws Exception
	 */
	public void updateBookStatus(String biCode,String status) throws Exception;

	/**
	 * 检查图书是否在借阅表中出现过
	 * @param biCode
	 * @return:
	 * 大于0表示出现过，0未出现
	 * @throws Exception
	 */
	public int checkBookInSend(String biCode) throws Exception;
	
}
