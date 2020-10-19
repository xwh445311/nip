package com.efs.common.auth.role.mapper;

import com.efs.common.database.BaseMapper;
import com.efs.common.database.Page;
import com.efs.common.database.PageDataBunder;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository("tsRoleInfoMapper")
public class TsRoleInfoMapperImpl extends BaseMapper implements TsRoleInfoMapper
{

	@Resource(name = "sqlSession")
	private SqlSessionTemplate sqlSession;
	
	@Override
	public TsRoleInfo getTsRoleInfo(String riId) throws Exception
	{
		return sqlSession.selectOne("com.efs.common.auth.role.mapper.TsRoleInfoMapper.getTsRoleInfo", riId);
	}

	@Override
	public void addTsRoleInfo(TsRoleInfo tsRoleInfo) throws Exception
	{
		sqlSession.insert("com.efs.common.auth.role.mapper.TsRoleInfoMapper.addTsRoleInfo", tsRoleInfo);
	}

	@Override
	public void updateTsRoleInfo(TsRoleInfo tsRoleInfo) throws Exception
	{
		sqlSession.update("com.efs.common.auth.role.mapper.TsRoleInfoMapper.updateTsRoleInfo", tsRoleInfo);
	}

	@Override
	public void deleteTsRoleInfo(String riId) throws Exception
	{
		sqlSession.delete("com.efs.common.auth.role.mapper.TsRoleInfoMapper.deleteTsRoleInfo", riId);
	}
	
	@Override
	public PageDataBunder listTsRoleInfo(TsRoleInfo paramBean,Page page) throws Exception
	{
		return queryPagedResult(sqlSession, "com.efs.common.auth.role.mapper.TsRoleInfoMapper.listTsRoleInfo", paramBean, page);
	}

	/**
	 * 插入某个角色关联的功能
	 *
	 * @param roleId
	 * @param funcList
	 * @throws Exception
	 */
	@Override
	public void addSysRoleFunc(String roleId, List<String> funcList) throws Exception
	{
		Map<String,Object> paramMap = new HashMap<>();
		paramMap.put("roleId",roleId);
		paramMap.put("funcList",funcList);
		sqlSession.insert("com.efs.common.auth.role.mapper.TsRoleInfoMapper.addSysRoleFunc",paramMap);
	}

	/**
	 * 删除某个角色关联的功能
	 *
	 * @param roleId
	 * @throws Exception
	 */
	@Override
	public void delSysRoleFunc(String roleId) throws Exception
	{
		sqlSession.delete("com.efs.common.auth.role.mapper.TsRoleInfoMapper.delSysRoleFunc",roleId);
	}

	/**
	 * 刪除用戶對應的此角色信息
	 *
	 * @param roleId
	 * @throws Exception
	 */
	@Override
	public void delSysRoleUser(String roleId) throws Exception
	{
		sqlSession.delete("com.efs.common.auth.role.mapper.TsRoleInfoMapper.delSysRoleUser",roleId);
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
		int res = sqlSession.selectOne("com.efs.common.auth.role.mapper.TsRoleInfoMapper.getRoleUserCount",roleId);
		return res;
	}

	/**
	 * 查询系统中所有可用的角色信息
	 *
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<TsRoleInfo> listAllEnableRole(String isSuperUser) throws Exception
	{
		Map<String,Object> paramMap = new HashMap<>();
		paramMap.put("isSuperUser",isSuperUser);
		return sqlSession.selectList("com.efs.common.auth.role.mapper.TsRoleInfoMapper.listAllEnableRole",paramMap);
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
		return sqlSession.selectList("com.efs.common.auth.role.mapper.TsRoleInfoMapper.listUserRole",userId);
	}
}
