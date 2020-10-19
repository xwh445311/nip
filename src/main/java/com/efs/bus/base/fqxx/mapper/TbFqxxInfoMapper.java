package com.efs.bus.base.fqxx.mapper;

import com.efs.common.database.Page;
import com.efs.common.database.PageDataBunder;


/**
 * 
 * com.efs.bus.base.fqxx.mapper.TbFqxxInfoMapper
 * @author xuwh
 * 2020-05-10 22:31:27
 * 分区信息表
 *
 */
public interface TbFqxxInfoMapper
{
	/**
	 * 根据主键ID获取TbFqxxInfo
	 * @param qyId
	 * @return
	 */
	public TbFqxxInfo getTbFqxxInfo(String qyId) throws Exception;
	
	/**
	 * 增加TbFqxxInfo
	 * @param tbFqxxInfo
	 */
	public void addTbFqxxInfo(TbFqxxInfo tbFqxxInfo) throws Exception;
	
	/**
	 * 更新TbFqxxInfo
	 * @param empBean
	 */
	public void updateTbFqxxInfo(TbFqxxInfo tbFqxxInfo) throws Exception;
	
	/**
	 * 删除TbFqxxInfo
	 * @param qyId
	 */
	public void deleteTbFqxxInfo(String qyId) throws Exception;
	
	
	/**
	 * 列举员工信息，带分页
	 * @param TbFqxxInfo
	 * @return
	 */
	public PageDataBunder listTbFqxxInfo(TbFqxxInfo paramBean,Page page) throws Exception;
	
}
