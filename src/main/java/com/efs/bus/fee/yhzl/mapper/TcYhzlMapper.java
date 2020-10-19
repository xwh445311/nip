package com.efs.bus.fee.yhzl.mapper;

import com.efs.common.database.Page;
import com.efs.common.database.PageDataBunder;


/**
 * 
 * com.efs.bus.fee.yhzl.mapper.TcYhzlMapper
 * @author xwh
 * 2020-10-18 16:11:27
 * 用户信息表
 *
 */
public interface TcYhzlMapper
{
	/**
	 * 根据主键ID获取TcYhzl
	 * @param yhbh
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
	 * @param yhbh
	 */
	public void deleteTcYhzl(String yhbh) throws Exception;
	
	
	/**
	 * 列举员工信息，带分页
	 * @param TcYhzl
	 * @return
	 */
	public PageDataBunder listTcYhzl(TcYhzl paramBean,Page page) throws Exception;
	
}
