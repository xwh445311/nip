package com.efs.bus.edu.baseset.service;

import com.efs.common.database.Page;
import com.efs.common.database.PageDataBunder;
import com.efs.bus.edu.baseset.mapper.BaseSetInfo;

/**
 * 
 * com.efs.bus.edu.baseset.mapper.BaseSetInfoService
 * @author xwh
 * 2018-05-29 13:55:38
 * 基础信息设置记录表
 *
 */
public interface BaseSetInfoService
{
	/**
	 * 根据主键ID获取BaseSetInfo
	 * @param dbId
	 * @return
	 */
	public BaseSetInfo getBaseSetInfo(String bsTerm) throws Exception;
	
	/**
	 * 增加BaseSetInfo
	 * @param baseSetInfo
	 */
	public void addBaseSetInfo(BaseSetInfo baseSetInfo) throws Exception;
	
	/**
	 * 更新BaseSetInfo
	 * @param empBean
	 */
	public String updateBaseSetInfo(BaseSetInfo baseSetInfo) throws Exception;
	
	/**
	 * 删除BaseSetInfo
	 * @param dbId
	 */
	public void deleteBaseSetInfo(String bsTerm) throws Exception;
	
	
	/**
	 * 列举员工信息，带分页
	 * @param BaseSetInfo
	 * @return
	 */
	public PageDataBunder listBaseSetInfo(BaseSetInfo paramBean, Page page) throws Exception;

	/**
	 * 检查基础信息是否已经设置过，TRUE表示已经设置，FALSE表示未设置
	 * @param bsTerm
	 * @return
	 * @throws Exception
	 */
	boolean checkHasBaseSet(String bsTerm) throws Exception;
}
