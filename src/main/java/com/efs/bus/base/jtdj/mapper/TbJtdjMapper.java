package com.efs.bus.base.jtdj.mapper;

import com.efs.common.database.Page;
import com.efs.common.database.PageDataBunder;


/**
 * 
 * com.efs.bus.base.fyxx.mapper.TbJtdjMapper
 * @author xuwh
 * 2020-05-19 21:46:13
 * 阶梯单价
 *
 */
public interface TbJtdjMapper
{
	/**
	 * 根据主键ID获取TbJtdj
	 * @param fydm
	 * @return
	 */
	public TbJtdj getTbJtdj(String dbId) throws Exception;
	
	/**
	 * 增加TbJtdj
	 * @param tbJtdj
	 */
	public void addTbJtdj(TbJtdj tbJtdj) throws Exception;
	
	/**
	 * 更新TbJtdj
	 * @param empBean
	 */
	public void updateTbJtdj(TbJtdj tbJtdj) throws Exception;
	
	/**
	 * 删除TbJtdj
	 * @param fydm
	 */
	public void deleteTbJtdj(String dbId) throws Exception;
	
	
	/**
	 * 列举员工信息，带分页
	 * @param TbJtdj
	 * @return
	 */
	public PageDataBunder listTbJtdj(TbJtdj paramBean,Page page) throws Exception;
	
}
