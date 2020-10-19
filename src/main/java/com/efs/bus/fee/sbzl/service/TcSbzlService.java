package com.efs.bus.fee.sbzl.service;

import com.efs.common.database.Page;
import com.efs.common.database.PageDataBunder;
import com.efs.bus.fee.sbzl.mapper.TcSbzl;

/**
 * 
 * com.efs.bus.fee.sbzl.mapper.TcSbzlService
 * @author xwh
 * 2020-10-18 16:16:33
 * 用户水表资料
 *
 */
public interface TcSbzlService
{
	/**
	 * 根据主键ID获取TcSbzl
	 * @param dbId
	 * @return
	 */
	public TcSbzl getTcSbzl(String sbxh) throws Exception;
	
	/**
	 * 增加TcSbzl
	 * @param tcSbzl
	 */
	public void addTcSbzl(TcSbzl tcSbzl) throws Exception;
	
	/**
	 * 更新TcSbzl
	 * @param empBean
	 */
	public void updateTcSbzl(TcSbzl tcSbzl) throws Exception;
	
	/**
	 * 删除TcSbzl
	 * @param dbId
	 */
	public void deleteTcSbzl(String sbxh) throws Exception;
	
	
	/**
	 * 列举员工信息，带分页
	 * @param TcSbzl
	 * @return
	 */
	public PageDataBunder listTcSbzl(TcSbzl paramBean,Page page) throws Exception;
	
}
