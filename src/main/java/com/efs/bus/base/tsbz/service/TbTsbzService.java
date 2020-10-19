package com.efs.bus.base.tsbz.service;

import com.efs.common.database.Page;
import com.efs.common.database.PageDataBunder;
import com.efs.bus.base.tsbz.mapper.TbTsbz;

/**
 * 
 * com.efs.bus.base.tsbz.mapper.TbTsbzService
 * @author xuwh
 * 2020-05-20 20:55:43
 * 特殊关系表
 *
 */
public interface TbTsbzService
{
	/**
	 * 根据主键ID获取TbTsbz
	 * @param dbId
	 * @return
	 */
	public TbTsbz getTbTsbz(String bm) throws Exception;
	
	/**
	 * 增加TbTsbz
	 * @param tbTsbz
	 */
	public void addTbTsbz(TbTsbz tbTsbz) throws Exception;
	
	/**
	 * 更新TbTsbz
	 * @param empBean
	 */
	public void updateTbTsbz(TbTsbz tbTsbz) throws Exception;
	
	/**
	 * 删除TbTsbz
	 * @param dbId
	 */
	public void deleteTbTsbz(String bm) throws Exception;
	
	
	/**
	 * 列举员工信息，带分页
	 * @param TbTsbz
	 * @return
	 */
	public PageDataBunder listTbTsbz(TbTsbz paramBean,Page page) throws Exception;
	
}
