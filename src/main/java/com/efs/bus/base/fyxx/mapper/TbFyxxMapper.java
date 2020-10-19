package com.efs.bus.base.fyxx.mapper;

import com.efs.common.database.Page;
import com.efs.common.database.PageDataBunder;

import java.util.List;


/**
 * 
 * com.efs.bus.base.fyxx.mapper.TbFyxxMapper
 * @author xuwh
 * 2020-05-19 20:11:32
 * 费用参数信息表
 *
 */
public interface TbFyxxMapper
{
	/**
	 * 根据主键ID获取TbFyxx
	 * @param fydm
	 * @return
	 */
	public TbFyxx getTbFyxx(String fydm) throws Exception;
	
	/**
	 * 增加TbFyxx
	 * @param tbFyxx
	 */
	public void addTbFyxx(TbFyxx tbFyxx) throws Exception;
	
	/**
	 * 更新TbFyxx
	 * @param empBean
	 */
	public void updateTbFyxx(TbFyxx tbFyxx) throws Exception;
	
	/**
	 * 删除TbFyxx
	 * @param fydm
	 */
	public void deleteTbFyxx(String fydm) throws Exception;
	
	
	/**
	 * 列举员工信息，带分页
	 * @param TbFyxx
	 * @return
	 */
	public PageDataBunder listTbFyxx(TbFyxx paramBean,Page page) throws Exception;

	/**
	 * 查询合理费用信息
	 * @return
	 */
	public List<TbFyxx> listAllFyxx();
	
}
