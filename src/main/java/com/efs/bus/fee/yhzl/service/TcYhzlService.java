package com.efs.bus.fee.yhzl.service;

import com.efs.common.database.Page;
import com.efs.common.database.PageDataBunder;
import com.efs.bus.fee.yhzl.mapper.TcYhzl;

/**
 * 
 * com.efs.bus.fee.yhzl.mapper.TcYhzlService
 * @author xwh
 * 2020-10-18 16:11:27
 * 用户信息表
 *
 */
public interface TcYhzlService
{
	/**
	 * 根据主键ID获取TcYhzl
	 * @param dbId
	 * @return
	 */
	public TcYhzl getTcYhzl(String yhbh) throws Exception;
	
	/**
	 * 增加TcYhzl
	 * @param tcYhzl
	 */
	public void addTcYhzl(TcYhzl tcYhzl) throws Exception;
	
	/**
	 * 更新TcYhzl
	 * @param empBean
	 */
	public void updateTcYhzl(TcYhzl tcYhzl) throws Exception;
	
	/**
	 * 删除TcYhzl
	 * @param dbId
	 */
	public void deleteTcYhzl(String yhbh) throws Exception;
	
	
	/**
	 * 列举员工信息，带分页
	 * @param TcYhzl
	 * @return
	 */
	public PageDataBunder listTcYhzl(TcYhzl paramBean,Page page) throws Exception;
	
}
