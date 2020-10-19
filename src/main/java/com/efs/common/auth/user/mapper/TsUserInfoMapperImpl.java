package com.efs.common.auth.user.mapper;

import com.efs.common.auth.org.mapper.TsOrgInfo;
import com.efs.common.auth.role.mapper.TsRoleInfo;
import com.efs.common.database.BaseMapper;
import com.efs.common.database.Page;
import com.efs.common.database.PageDataBunder;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository("tsUserInfoMapper")
public class TsUserInfoMapperImpl extends BaseMapper implements TsUserInfoMapper
{

	@Resource(name = "sqlSession")
	private SqlSessionTemplate sqlSession;
	
	@Override
	public TsUserInfo getTsUserInfo(String uiId) throws Exception
	{
		return sqlSession.selectOne("com.efs.common.auth.user.mapper.TsUserInfoMapper.getTsUserInfo", uiId);
	}

	@Override
	public void addTsUserInfo(TsUserInfo tsUserInfo) throws Exception
	{
		sqlSession.insert("com.efs.common.auth.user.mapper.TsUserInfoMapper.addTsUserInfo", tsUserInfo);
	}

	@Override
	public void updateTsUserInfo(TsUserInfo tsUserInfo) throws Exception
	{
		sqlSession.update("com.efs.common.auth.user.mapper.TsUserInfoMapper.updateTsUserInfo", tsUserInfo);
	}

	@Override
	public void deleteTsUserInfo(String uiId) throws Exception
	{
		sqlSession.delete("com.efs.common.auth.user.mapper.TsUserInfoMapper.deleteTsUserInfo", uiId);
	}
	
	@Override
	public PageDataBunder listTsUserInfo(TsUserInfo paramBean, Page page) throws Exception
	{
		return queryPagedResult(sqlSession, "com.efs.common.auth.user.mapper.TsUserInfoMapper.listTsUserInfo", paramBean, page);
	}

	@Override
	public void updateUserLoginInfo(TsUserInfo tsUserInfo) throws Exception
	{
		sqlSession.update("com.efs.common.auth.user.mapper.TsUserInfoMapper.updateUserLoginInfo", tsUserInfo);
	}

	/**
	 * 刪除用戶的角色信息
	 *
	 * @param userId
	 * @throws Exception
	 */
	@Override
	public void deleteUserRole(String userId) throws Exception
	{
		sqlSession.delete("com.efs.common.auth.user.mapper.TsUserInfoMapper.deleteUserRole",userId);
	}

	/**
	 * 添加用戶的角色信息
	 *
	 * @param userId
	 * @param roleList
	 */
	@Override
	public void addUserRole(String userId, List<TsRoleInfo> roleList)
	{
		Map<String,Object> paramMap = new HashMap<>();
		paramMap.put("userId",userId);
		paramMap.put("roleList",roleList);
		sqlSession.insert("com.efs.common.auth.user.mapper.TsUserInfoMapper.addUserRole",paramMap);
	}

	@Override
	public void deleteUserOrgs(String userId) throws Exception
	{
		sqlSession.delete("com.efs.common.auth.user.mapper.TsUserInfoMapper.deleteUserOrgs",userId);
	}

	@Override
	public void addUserOrgs(String userId, List<TsOrgInfo> orgList) throws Exception
	{
		if(orgList == null || orgList.size() == 0)
		{
			return;
		}

		Map<String,Object> paramMap = new HashMap<>();
		paramMap.put("userId",userId);
		paramMap.put("orgList",orgList);
		sqlSession.insert("com.efs.common.auth.user.mapper.TsUserInfoMapper.addUserOrgs",paramMap);
	}

	/**
	 * 查询学生信息，带分页
	 *
	 * @param paramBean
	 * @param page
	 * @return
	 */
	@Override
	public PageDataBunder listStudentInfo(TsUserInfo paramBean, Page page) throws Exception
	{
		return queryPagedResult(sqlSession, "com.efs.common.auth.user.mapper.TsUserInfoMapper.listStudentInfo", paramBean, page);
	}

	/**
	 * 查询所有在职的教师信息
	 *
	 * @param paramBean
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<TsUserInfo> listTeacherInfoNoPage(TsUserInfo paramBean) throws Exception
	{
		return sqlSession.selectList("com.efs.common.auth.user.mapper.TsUserInfoMapper.listTeacherInfoNoPage",paramBean);
	}

	/**
	 * 修改学生信息
	 *
	 * @param paramBean
	 * @throws Exception
	 */
	@Override
	public void updateStudentInfo(TsUserInfo paramBean) throws Exception
	{
		sqlSession.update("com.efs.common.auth.user.mapper.TsUserInfoMapper.updateStudentInfo",paramBean);
	}

	/**
	 * 列举教师信息列表
	 *
	 * @param paramBean
	 * @param page
	 * @return
	 * @throws Exception
	 */
	@Override
	public PageDataBunder listTeacherInfo(TsUserInfo paramBean, Page page) throws Exception
	{
		return queryPagedResult(sqlSession, "com.efs.common.auth.user.mapper.TsUserInfoMapper.listTeacherInfoNoPage", paramBean, page);
	}

	/**
	 * 检查简称是否已经存在，如果为NULL，也返回不存在
	 *
	 * @param uiShortName
	 * @throws Exception
	 */
	@Override
	public boolean checkShortNameExist(String uiShortName,String userId) throws Exception
	{
		Map<String,Object> paramMap = new HashMap<>();
		paramMap.put("uiShortName",uiShortName);
		paramMap.put("userId",userId);
		int cnt = sqlSession.selectOne("com.efs.common.auth.user.mapper.TsUserInfoMapper.checkShortNameExist",paramMap);
		if(cnt >0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	/**
	 * 更新学生信息
	 *
	 * @param paramBean
	 * @throws Exception
	 */
	@Override
	public void updateTeacherInfo(TsUserInfo paramBean) throws Exception
	{
		sqlSession.update("com.efs.common.auth.user.mapper.TsUserInfoMapper.updateTeacherInfo",paramBean);
	}

	/**
	 * 更新单个用户的状态
	 *
	 * @param uiId
	 * @param uiStatus
	 * @throws Exception
	 */
	@Override
	public void updateUserStatus(List<TsUserInfo> userList) throws Exception
	{
		sqlSession.update("com.efs.common.auth.user.mapper.TsUserInfoMapper.updateUserStatus",userList);
	}

	/**
	 * 查询用户信息不带分布
	 *
	 * @param paramBean
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<TsUserInfo> listStudentNoPage(TsUserInfo paramBean) throws Exception
	{
		return sqlSession.selectList("com.efs.common.auth.user.mapper.TsUserInfoMapper.listStudentInfo",paramBean);
	}

	/**
	 * 修改用户密码
	 *
	 * @param uiId
	 * @param password
	 * @throws Exception
	 */
	@Override
	public void updateUserPassword(String uiId, String password) throws Exception
	{
		Map<String,Object> paramMap = new HashMap<>();
		paramMap.put("uiId",uiId);
		paramMap.put("password",password);

		sqlSession.update("com.efs.common.auth.user.mapper.TsUserInfoMapper.updateUserPassword",paramMap);
	}

	/**
	 * 查询快捷通讯录
	 *
	 * @param keyWork
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<TsUserInfo> listAddressBook(String keyWork) throws Exception
	{
		Map<String,Object> paramMap = new HashMap<>();
		paramMap.put("keyWork",keyWork);

		return sqlSession.selectList("com.efs.common.auth.user.mapper.TsUserInfoMapper.listAddressBook",paramMap);
	}

	/**
	 * 用户首次更新密码
	 *
	 * @param uiId
	 * @param password
	 * @throws Exception
	 */
	@Override
	public void updateUserPasswordFirst(String uiId, String password) throws Exception
	{
		Map<String,Object> paramMap = new HashMap<>();
		paramMap.put("uiId",uiId);
		paramMap.put("password",password);
		paramMap.put("uiChangePass","1");
		sqlSession.update("com.efs.common.auth.user.mapper.TsUserInfoMapper.updateUserPassword",paramMap);
	}

	/**
	 * 重置用户的密码
	 *
	 * @param uiId
	 * @param password
	 * @throws Exception
	 */
	@Override
	public void updateResetPassword(String uiId, String password) throws Exception
	{
		Map<String,Object> paramMap = new HashMap<>();
		paramMap.put("uiId",uiId);
		paramMap.put("password",password);
		paramMap.put("uiChangePass","0");
		sqlSession.update("com.efs.common.auth.user.mapper.TsUserInfoMapper.updateUserPassword",paramMap);
	}

	@Override
	public List<TsUserInfo> listUserInOrg(String userOrg)
	{
		return sqlSession.selectList("com.efs.common.auth.user.mapper.TsUserInfoMapper.listUserInOrg",userOrg);
	}
}
