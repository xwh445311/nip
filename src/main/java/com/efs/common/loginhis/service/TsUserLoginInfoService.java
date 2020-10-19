package com.efs.common.loginhis.service;

import com.efs.common.database.Page;
import com.efs.common.database.PageDataBunder;
import com.efs.common.loginhis.mapper.TsUserLoginInfo;

import java.util.List;
import java.util.Map;

/**
 * 
 * com.efs.bus.loginhis.mapper.TsUserLoginInfoService
 * @author xwh
 * 2017-06-23 09:34:15
 * 用户登录日志表
 *
 */
public interface TsUserLoginInfoService
{
	/**
	 * 根据主键ID获取TsUserLoginInfo
	 * @param dbId
	 * @return
	 */
	public TsUserLoginInfo getTsUserLoginInfo(String ulDbId) throws Exception;
	
	/**
	 * 增加TsUserLoginInfo
	 * @param tsUserLoginInfo
	 */
	public void addTsUserLoginInfo(TsUserLoginInfo tsUserLoginInfo) throws Exception;
	
	/**
	 * 更新TsUserLoginInfo
	 * @param empBean
	 */
	public void updateTsUserLoginInfo(TsUserLoginInfo tsUserLoginInfo) throws Exception;
	
	/**
	 * 删除TsUserLoginInfo
	 * @param dbId
	 */
	public void deleteTsUserLoginInfo(String ulDbId) throws Exception;
	
	
	/**
	 * 列举员工信息，带分页
	 * @param TsUserLoginInfo
	 * @return
	 */
	public PageDataBunder listTsUserLoginInfo(TsUserLoginInfo paramBean, Page page) throws Exception;

	/**
	 * 获取用户的登录信息
	 * @return
	 * @throws Exception
	 */
	public List<Map<String,Object>> getUserLoginStatics() throws Exception;

	/**
	 * 获取当前用户的登录统计信息
	 * @return
	 * @throws Exception
	 */
	public List<Map<String,Object>> getCurrUserLoginStatics(String userId) throws Exception;
}
