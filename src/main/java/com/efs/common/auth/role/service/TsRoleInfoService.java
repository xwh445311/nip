package com.efs.common.auth.role.service;

import com.efs.common.auth.role.mapper.TsRoleInfo;
import com.efs.common.database.Page;
import com.efs.common.database.PageDataBunder;

import java.util.List;

/**
 * 
 * com.efs.common.auth.role.mapper.TsRoleInfoService
 * @author xwh
 * 2017-06-21 23:24:56
 * 系统角色表
 *
 */
public interface TsRoleInfoService
{
	/**
	 * 根据主键ID获取TsRoleInfo
	 * @param dbId
	 * @return
	 */
	public TsRoleInfo getTsRoleInfo(String riId) throws Exception;
	
	/**
	 * 增加TsRoleInfo
	 * @param tsRoleInfo
	 */
	public void addTsRoleInfo(TsRoleInfo tsRoleInfo) throws Exception;
	
	/**
	 * 更新TsRoleInfo
	 * @param empBean
	 */
	public void updateTsRoleInfo(TsRoleInfo tsRoleInfo) throws Exception;
	
	/**
	 * 删除TsRoleInfo
	 * @param dbId
	 */
	public void deleteTsRoleInfo(String riId) throws Exception;
	
	
	/**
	 * 列举员工信息，带分页
	 * @param TsRoleInfo
	 * @return
	 */
	public PageDataBunder listTsRoleInfo(TsRoleInfo paramBean, Page page) throws Exception;

	/**
	 * 獲取分配了該角色的用戶數量
	 * @param roleId
	 * @return
	 * @throws Exception
	 */
	public int getRoleUserCount(String roleId) throws Exception;

	/**
	 * 查询系统中所有可用的角色信息
	 * @return
	 * @throws Exception
	 */
	public List<TsRoleInfo> listAllEnableRole(String isSuperUser) throws Exception;

	/**
	 * 查询用户的所有角色
	 * @param userId
	 * @return
	 * @throws Exception
	 */
	List<TsRoleInfo> listUserRole(String userId) throws Exception;
}
