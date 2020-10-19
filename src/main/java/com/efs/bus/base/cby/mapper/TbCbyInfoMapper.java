package com.efs.bus.base.cby.mapper;

import com.efs.common.database.Page;
import com.efs.common.database.PageDataBunder;


/**
 * 
 * com.efs.bus.base.cby.mapper.TbCbyInfoMapper
 * @author xuwh
 * 2020-05-24 21:47:25
 * 抄表员信息
 *
 */
public interface TbCbyInfoMapper
{
	/**
	 * 根据主键ID获取TbCbyInfo
	 * @param dbId
	 * @return
	 */
	public TbCbyInfo getTbCbyInfo(String dbId) throws Exception;
	
	/**
	 * 增加TbCbyInfo
	 * @param tbCbyInfo
	 */
	public void addTbCbyInfo(TbCbyInfo tbCbyInfo) throws Exception;
	
	/**
	 * 更新TbCbyInfo
	 * @param empBean
	 */
	public void updateTbCbyInfo(TbCbyInfo tbCbyInfo) throws Exception;
	
	/**
	 * 删除TbCbyInfo
	 * @param dbId
	 */
	public void deleteTbCbyInfo(String dbId) throws Exception;
	
	
	/**
	 * 列举员工信息，带分页
	 * @param TbCbyInfo
	 * @return
	 */
	public PageDataBunder listTbCbyInfo(TbCbyInfo paramBean,Page page) throws Exception;
	
}
