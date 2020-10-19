package com.efs.bus.lib.addr.mapper;

import com.efs.common.database.Page;
import com.efs.common.database.PageDataBunder;

import java.util.List;


/**
 * 
 * com.efs.bus.lib.addr.mapper.LibShelfAddInfoMapper
 * @author xwh
 * 2018-03-20 23:46:18
 * 书架信息表
 *
 */
public interface LibShelfAddInfoMapper
{
	/**
	 * 根据主键ID获取LibShelfAddInfo
	 * @param siCode
	 * @return
	 */
	public LibShelfAddInfo getLibShelfAddInfo(String siCode) throws Exception;
	
	/**
	 * 增加LibShelfAddInfo
	 * @param libShelfAddInfo
	 */
	public void addLibShelfAddInfo(List<LibShelfAddInfo> libShelfAddInfoList) throws Exception;
	
	/**
	 * 更新LibShelfAddInfo
	 * @param empBean
	 */
	public void updateLibShelfAddInfo(LibShelfAddInfo libShelfAddInfo) throws Exception;
	
	/**
	 * 删除LibShelfAddInfo
	 * @param siCode
	 */
	public void deleteLibShelfAddInfo(String siCode) throws Exception;
	
	
	/**
	 * 列举员工信息，带分页
	 * @param LibShelfAddInfo
	 * @return
	 */
	public PageDataBunder listLibShelfAddInfo(LibShelfAddInfo paramBean, Page page) throws Exception;

	/**
	 * 根据箱子删除地址
	 * @param siShelfNo
	 * @throws Exception
	 */
	public void deleteLibAddrWithShelf(int siShelfNo) throws Exception;
	
}
