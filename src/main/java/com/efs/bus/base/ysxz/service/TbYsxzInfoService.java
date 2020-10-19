package com.efs.bus.base.ysxz.service;

import com.efs.common.database.Page;
import com.efs.common.database.PageDataBunder;
import com.efs.bus.base.ysxz.mapper.TbYsxzInfo;
import com.xwh.bean.SelectBean;

import java.util.List;

/**
 * 
 * com.efs.bus.base.ysxz.mapper.TbYsxzInfoService
 * @author xuwh
 * 2020-05-17 20:59:30
 * 用水性质
 *
 */
public interface TbYsxzInfoService
{
	/**
	 * 根据主键ID获取TbYsxzInfo
	 * @param dbId
	 * @return
	 */
	public TbYsxzInfo getTbYsxzInfo(String xzdm) throws Exception;
	
	/**
	 * 增加TbYsxzInfo
	 * @param tbYsxzInfo
	 */
	public void addTbYsxzInfo(TbYsxzInfo tbYsxzInfo) throws Exception;
	
	/**
	 * 更新TbYsxzInfo
	 * @param empBean
	 */
	public void updateTbYsxzInfo(TbYsxzInfo tbYsxzInfo) throws Exception;
	
	/**
	 * 删除TbYsxzInfo
	 * @param dbId
	 */
	public void deleteTbYsxzInfo(String xzdm) throws Exception;
	
	
	/**
	 * 列举员工信息，带分页
	 * @param TbYsxzInfo
	 * @return
	 */
	public PageDataBunder listTbYsxzInfo(TbYsxzInfo paramBean,Page page) throws Exception;

	/**
	 * 查询所有有效用水性质
	 * @return
	 */
	public List<SelectBean> listAllValidYsxzSelect() throws Exception;
	
}
