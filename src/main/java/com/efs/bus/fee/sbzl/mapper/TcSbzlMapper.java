package com.efs.bus.fee.sbzl.mapper;

import com.efs.common.database.Page;
import com.efs.common.database.PageDataBunder;


/**
 * 
 * com.efs.bus.fee.sbzl.mapper.TcSbzlMapper
 * @author xwh
 * 2020-10-18 16:16:33
 * 用户水表资料
 *
 */
public interface TcSbzlMapper
{
	/**
	 * 根据主键ID获取TcSbzl
	 * @param sbxh
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
	 * @param sbxh
	 */
	public void deleteTcSbzl(String sbxh) throws Exception;
	
	
	/**
	 * 列举员工信息，带分页
	 * @param TcSbzl
	 * @return
	 */
	public PageDataBunder listTcSbzl(TcSbzl paramBean,Page page) throws Exception;
	
}
