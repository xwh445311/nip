package com.efs.bus.base.sbkj.service;

import com.efs.common.database.Page;
import com.efs.common.database.PageDataBunder;
import com.efs.bus.base.sbkj.mapper.TbSbkjInfo;
import com.xwh.bean.SelectBean;

import java.util.List;

/**
 * 
 * com.efs.bus.base.sbkj.mapper.TbSbkjInfoService
 * @author xwh
 * 2020-05-17 11:59:17
 * 水表口径信息
 *
 */
public interface TbSbkjInfoService
{
	/**
	 * 根据主键ID获取TbSbkjInfo
	 * @param dbId
	 * @return
	 */
	public TbSbkjInfo getTbSbkjInfo(String sbkj) throws Exception;
	
	/**
	 * 增加TbSbkjInfo
	 * @param tbSbkjInfo
	 */
	public void addTbSbkjInfo(TbSbkjInfo tbSbkjInfo) throws Exception;
	
	/**
	 * 更新TbSbkjInfo
	 * @param empBean
	 */
	public void updateTbSbkjInfo(TbSbkjInfo tbSbkjInfo) throws Exception;
	
	/**
	 * 删除TbSbkjInfo
	 * @param dbId
	 */
	public void deleteTbSbkjInfo(String sbkj) throws Exception;
	
	
	/**
	 * 列举员工信息，带分页
	 * @param TbSbkjInfo
	 * @return
	 */
	public PageDataBunder listTbSbkjInfo(TbSbkjInfo paramBean,Page page) throws Exception;

	/**
	 * 查询水表口径下拉选项框
	 * @return
	 * @throws Exception
	 */
	public List<SelectBean> listAllSbkjSelectBean() throws Exception;
	
}
