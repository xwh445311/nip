package com.efs.common.auth.user.mapper;

import com.efs.common.auth.org.mapper.TsOrgInfo;
import com.efs.common.auth.role.mapper.TsRoleInfo;
import com.efs.common.database.Page;
import com.efs.common.database.PageDataBunder;

import java.util.List;


/**
 * 
 * com.efs.common.auth.user.mapper.TsUserInfoMapper
 * @author xwh
 * 2017-06-21 23:16:28
 * 系统用户信息表
 *
 */
public interface TsUserInfoMapper
{
	/**
	 * 根据主键ID获取TsUserInfo
	 * @param uiId
	 * @return
	 */
	public TsUserInfo getTsUserInfo(String uiId) throws Exception;
	
	/**
	 * 增加TsUserInfo
	 * @param tsUserInfo
	 */
	public void addTsUserInfo(TsUserInfo tsUserInfo) throws Exception;
	
	/**
	 * 更新TsUserInfo
	 * @param empBean
	 */
	public void updateTsUserInfo(TsUserInfo tsUserInfo) throws Exception;
	
	/**
	 * 删除TsUserInfo
	 * @param uiId
	 */
	public void deleteTsUserInfo(String uiId) throws Exception;
	
	
	/**
	 * 列举员工信息，带分页
	 * @param TsUserInfo
	 * @return
	 */
	public PageDataBunder listTsUserInfo(TsUserInfo paramBean, Page page) throws Exception;

	/**
	 * 修改用户登录信息
	 * @param userBean
	 * @throws Exception
	 */
	public void updateUserLoginInfo(TsUserInfo tsUserInfo) throws Exception;

	/**
	 * 刪除用戶的角色信息
	 * @param userId
	 * @throws Exception
	 */
	public void deleteUserRole(String userId) throws Exception;

	/**
	 * 添加用戶的角色信息
	 * @param userId
	 * @param roleList
	 */
	public void addUserRole(String userId, List<TsRoleInfo> roleList);

	/**
	 * 删除用户所属机构
	 * @param userId
	 * @throws Exception
	 */
	public void deleteUserOrgs(String userId) throws Exception;


	/**
	 * 添加用户机构
	 * @param userId
	 * @param orgList
	 * @throws Exception
	 */
	void addUserOrgs(String userId, List<TsOrgInfo> orgList) throws Exception;


	/**
	 * 查询学生信息，带分页
	 * @param TsUserInfo
	 * @return
	 */
	public PageDataBunder listStudentInfo(TsUserInfo paramBean, Page page) throws Exception;

	/**
	 * 查询所有在职的教师信息
	 * @param paramBean
	 * @return
	 * @throws Exception
	 */
	List<TsUserInfo> listTeacherInfoNoPage(TsUserInfo paramBean) throws Exception;

    /**
     * 修改学生信息
     * @param paramBean
     * @throws Exception
     */
	void updateStudentInfo(TsUserInfo paramBean) throws Exception;

	/**
	 * 列举教师信息列表
	 * @param paramBean
	 * @param page
	 * @return
	 * @throws Exception
	 */
	PageDataBunder listTeacherInfo(TsUserInfo paramBean, Page page) throws Exception;

	/**
	 * 检查简称是否已经存在，如果为NULL，也返回不存在
	 * @param uiShortName
	 * @throws Exception
	 */
	boolean checkShortNameExist(String uiShortName,String userId) throws Exception;

	/**
	 * 更新学生信息
	 * @param paramBean
	 * @throws Exception
	 */
	void updateTeacherInfo(TsUserInfo paramBean) throws Exception;

	/**
	 * 更新单个用户的状态
	 * @param uiId
	 * @param uiStatus
	 * @throws Exception
	 */
	void updateUserStatus(List<TsUserInfo> userList) throws Exception;

	/**
	 * 查询学生信息不带分布
	 * @param paramBean
	 * @return
	 * @throws Exception
	 */
	List<TsUserInfo> listStudentNoPage(TsUserInfo paramBean) throws Exception;

	/**
	 * 修改用户密码
	 * @param uiId
	 * @param password
	 * @throws Exception
	 */
	void updateUserPassword(String uiId,String password) throws Exception;

	/**
	 * 查询快捷通讯录
	 * @param keyWork
	 * @return
	 * @throws Exception
	 */
	List<TsUserInfo> listAddressBook(String keyWork) throws Exception;

	/**
	 * 用户首次更新密码
	 * @param uiId
	 * @param password
	 * @throws Exception
	 */
	void updateUserPasswordFirst(String uiId,String password) throws Exception;

	/**
	 * 重置用户的密码
	 * @param uiId
	 * @param password
	 * @throws Exception
	 */
	void updateResetPassword(String uiId,String password) throws Exception;

	/**
	 * 查询机构下的用户信息
	 * @param userOrg
	 * @return
	 */
	List<TsUserInfo> listUserInOrg(String userOrg) ;
}
