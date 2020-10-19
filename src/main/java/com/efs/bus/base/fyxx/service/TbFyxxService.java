package com.efs.bus.base.fyxx.service;

import com.efs.common.database.Page;
import com.efs.common.database.PageDataBunder;
import com.efs.bus.base.fyxx.mapper.TbFyxx;
import com.xwh.bean.SelectBean;

import java.util.List;

/**
 * 
 * com.efs.bus.base.fyxx.mapper.TbFyxxService
 * @author xuwh
 * 2020-05-19 20:11:32
 * 费用参数信息表
 *
 */
public interface TbFyxxService
{
	/**
	 * 根据主键ID获取TbFyxx
	 * @param dbId
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
	 * @param dbId
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
	public List<SelectBean> listAllFyxxSelect() throws Exception;
	
}
