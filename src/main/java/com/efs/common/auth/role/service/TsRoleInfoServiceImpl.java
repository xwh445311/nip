package com.efs.common.auth.role.service;

import com.efs.common.Util.SysUtils;
import com.efs.common.auth.role.mapper.TsRoleInfo;
import com.efs.common.auth.role.mapper.TsRoleInfoMapper;
import com.efs.common.database.Page;
import com.efs.common.database.PageDataBunder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("tsRoleInfoService")
public class TsRoleInfoServiceImpl implements TsRoleInfoService
{
	@Resource(name="tsRoleInfoMapper")
	private TsRoleInfoMapper tsRoleInfoMapper;
	
	@Override
	public TsRoleInfo getTsRoleInfo(String riId) throws Exception
	{
		return tsRoleInfoMapper.getTsRoleInfo(riId);
	}

	@Override
	public void addTsRoleInfo(TsRoleInfo tsRoleInfo) throws Exception
	{
		//先产生ROLE_ID
		String roleDbId = SysUtils.genDBID("R");
		tsRoleInfo.setRiId(roleDbId);

		//保存角色基本信息
		tsRoleInfoMapper.addTsRoleInfo(tsRoleInfo);

		//保存角色对应的功能
		tsRoleInfoMapper.addSysRoleFunc(roleDbId,tsRoleInfo.getFuncList());
	}

	@Override
	public void updateTsRoleInfo(TsRoleInfo tsRoleInfo) throws Exception
	{
		//保存角色基本信息
		tsRoleInfoMapper.updateTsRoleInfo(tsRoleInfo);

		//刪除角色對應的功能
		tsRoleInfoMapper.delSysRoleFunc(tsRoleInfo.getRiId());

		//保存角色对应的功能
		tsRoleInfoMapper.addSysRoleFunc(tsRoleInfo.getRiId(),tsRoleInfo.getFuncList());
	}

	@Override
	public void deleteTsRoleInfo(String riId) throws Exception
	{
		//刪除用戶關聯的角色
		tsRoleInfoMapper.delSysRoleUser(riId);

		//刪除角色關聯的功能
		tsRoleInfoMapper.delSysRoleFunc(riId);

		//刪除角色本身的信息
		tsRoleInfoMapper.deleteTsRoleInfo(riId);
	}

	@Override
	public PageDataBunder listTsRoleInfo(TsRoleInfo paramBean, Page page) throws Exception
	{
		return tsRoleInfoMapper.listTsRoleInfo(paramBean,page);
	}

	/**
	 * 獲取分配了該角色的用戶數量
	 *
	 * @param roleId
	 * @return
	 * @throws Exception
	 */
	@Override
	public int getRoleUserCount(String roleId) throws Exception
	{
		return tsRoleInfoMapper.getRoleUserCount(roleId);
	}

	/**
	 * 查询系统中所有可用的角色信息
	 *
	 * @param isSuperUser
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<TsRoleInfo> listAllEnableRole(String isSuperUser) throws Exception
	{
		return tsRoleInfoMapper.listAllEnableRole(isSuperUser);
	}

	/**
	 * 查询用户的所有角色
	 *
	 * @param userId
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<TsRoleInfo> listUserRole(String userId) throws Exception
	{
		return tsRoleInfoMapper.listUserRole(userId);
	}
}
