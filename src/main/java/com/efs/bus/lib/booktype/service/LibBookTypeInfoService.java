package com.efs.bus.lib.booktype.service;

import com.efs.bus.lib.booktype.mapper.LibBookTypeInfo;

import java.util.List;

/**
 * 
 * com.efs.bus.lib.booktype.mapper.LibBookTypeInfoService
 * @author xuwh
 * 2018-03-25 23:08:05
 * 图书类别信息表
 *
 */
public interface LibBookTypeInfoService
{
	/**
	 * 根据主键ID获取LibBookTypeInfo
	 * @param dbId
	 * @return
	 */
	public LibBookTypeInfo getLibBookTypeInfo(String btId) throws Exception;
	
	/**
	 * 增加LibBookTypeInfo
	 * @param libBookTypeInfo
	 */
	public void addLibBookTypeInfo(LibBookTypeInfo libBookTypeInfo) throws Exception;
	
	/**
	 * 更新LibBookTypeInfo
	 * @param empBean
	 */
	public void updateLibBookTypeInfo(LibBookTypeInfo libBookTypeInfo) throws Exception;
	
	/**
	 * 删除LibBookTypeInfo
	 * @param dbId
	 */
	public void deleteLibBookTypeInfo(String btId) throws Exception;
	
	
	/**
	 * 列举员工信息，带分页
	 * @param LibBookTypeInfo
	 * @return
	 */
	public List<LibBookTypeInfo> listLibBookTypeInfo(LibBookTypeInfo paramBean) throws Exception;

	/**
	 * 获取下一下数据库主键
	 * @return
	 * @throws Exception
	 */
	public Integer getNextDbId() throws Exception;

	/**
	 * 查询所有子类分类
	 * @return
	 * @throws Exception
	 */
	public List<LibBookTypeInfo> listAllChildBookType() throws Exception;
	
}
