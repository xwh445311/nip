package com.efs.bus.base.qylsl.service;

import com.efs.common.database.Page;
import com.efs.common.database.PageDataBunder;
import com.efs.bus.base.qylsl.mapper.TbSbqyl;

/**
 * 
 * com.efs.bus.base.qylsl.mapper.TbSbqylService
 * @author xwh
 * 2020-08-08 22:41:38
 * 启用量设立
 *
 */
public interface TbSbqylService
{
	/**
	 * 根据主键ID获取TbSbqyl
	 * @param dbId
	 * @return
	 */
	public TbSbqyl getTbSbqyl(String dbId) throws Exception;
	
	/**
	 * 增加TbSbqyl
	 * @param tbSbqyl
	 */
	public void addTbSbqyl(TbSbqyl tbSbqyl) throws Exception;
	
	/**
	 * 更新TbSbqyl
	 * @param empBean
	 */
	public void updateTbSbqyl(TbSbqyl tbSbqyl) throws Exception;
	
	/**
	 * 删除TbSbqyl
	 * @param dbId
	 */
	public void deleteTbSbqyl(String dbId) throws Exception;
	
	
	/**
	 * 列举员工信息，带分页
	 * @param TbSbqyl
	 * @return
	 */
	public PageDataBunder listTbSbqyl(TbSbqyl paramBean,Page page) throws Exception;
	
}
