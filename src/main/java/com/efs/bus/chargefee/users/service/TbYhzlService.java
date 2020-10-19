package com.efs.bus.chargefee.users.service;

import com.efs.common.database.Page;
import com.efs.common.database.PageDataBunder;
import com.efs.bus.chargefee.users.mapper.TbYhzl;

/**
 * 
 * com.efs.bus.chargefee.users.mapper.TbYhzlService
 * @author xuwh
 * 2020-08-13 23:24:08
 * 用户信息表
 *
 */
public interface TbYhzlService
{
	/**
	 * 根据主键ID获取TbYhzl
	 * @param dbId
	 * @return
	 */
	public TbYhzl getTbYhzl(String yhbh) throws Exception;
	
	/**
	 * 增加TbYhzl
	 * @param tbYhzl
	 */
	public void addTbYhzl(TbYhzl tbYhzl) throws Exception;
	
	/**
	 * 更新TbYhzl
	 * @param empBean
	 */
	public void updateTbYhzl(TbYhzl tbYhzl) throws Exception;
	
	/**
	 * 删除TbYhzl
	 * @param dbId
	 */
	public void deleteTbYhzl(String yhbh) throws Exception;
	
	
	/**
	 * 列举员工信息，带分页
	 * @param TbYhzl
	 * @return
	 */
	public PageDataBunder listTbYhzl(TbYhzl paramBean,Page page) throws Exception;
	
}
