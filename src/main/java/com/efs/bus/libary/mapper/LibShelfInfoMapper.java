package com.efs.bus.libary.mapper;

import java.util.List;
import java.util.Map;

import com.efs.bus.lib.addr.mapper.LibShelfAddInfo;
import com.efs.common.database.Page;
import com.efs.common.database.PageDataBunder;


/**
 * 
 * com.efs.bus.libary.mapper.LibShelfInfoMapper
 * @author xuwh
 * 2018-03-19 10:52:52
 * 书架信息表
 *
 */
public interface LibShelfInfoMapper
{
	/**
	 * 根据主键ID获取LibShelfInfo
	 * @param lsNo
	 * @return
	 */
	public LibShelfInfo getLibShelfInfo(String lsNo) throws Exception;
	
	/**
	 * 增加LibShelfInfo
	 * @param libShelfInfo
	 */
	public void addLibShelfInfo(LibShelfInfo libShelfInfo) throws Exception;
	
	/**
	 * 更新LibShelfInfo
	 * @param empBean
	 */
	public void updateLibShelfInfo(LibShelfInfo libShelfInfo) throws Exception;
	
	/**
	 * 删除LibShelfInfo
	 * @param lsNo
	 */
	public void deleteLibShelfInfo(String lsNo) throws Exception;
	
	
	/**
	 * 列举员工信息，带分页
	 * @param LibShelfInfo
	 * @return
	 */
	public PageDataBunder listLibShelfInfo(LibShelfInfo paramBean, Page page) throws Exception;

	/**
	 * 获取下一个书架号
	 * @return
	 * @throws Exception
	 */
	public int getNexShelfNo() throws Exception;

	/**
	 * 获得某个书架的所有书柜
	 * @param lsNo
	 * @return
	 * @throws Exception
	 */
	public List<LibShelfAddInfo> listShelfAddr(String lsNo) throws Exception;

	/**
	 * 列举所有的书架信息
	 * @return
	 * @throws Exception
	 */
	public List<LibShelfInfo> listAllShelf() throws Exception;

	/**
	 * 查询所有的书架地址
	 * @return
	 * @throws Exception
	 */
	public List<LibShelfAddInfo> listAllAddr() throws Exception;

	/**
	 * 更新书架的使用状态
	 * @param siCode
	 * @param status
	 * @throws Exception
	 */
	public void updateAddUseStatus(String siCode,String status) throws Exception;
	
}
