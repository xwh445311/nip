package com.efs.common.auth.func.service;

import com.efs.common.auth.func.mapper.TsFuncIfno;
import com.efs.common.database.Page;
import com.efs.common.database.PageDataBunder;

import java.util.List;

/**
 * 
 * com.efs.common.auth.func.mapper.TsFuncIfnoService
 * @author xuwh
 * 2017-06-25 15:53:43
 * 系统功能表
 *
 */
public interface TsFuncIfnoService
{
	/**
	 * 根据主键ID获取TsFuncIfno
	 *
	 * @param dbId
	 * @return
	 */
	public TsFuncIfno getTsFuncIfno(String muDbId) throws Exception;

	/**
	 * 增加TsFuncIfno
	 *
	 * @param tsFuncIfno
	 */
	public void addTsFuncIfno(TsFuncIfno tsFuncIfno) throws Exception;

	/**
	 * 更新TsFuncIfno
	 *
	 * @param empBean
	 */
	public void updateTsFuncIfno(TsFuncIfno tsFuncIfno) throws Exception;

	/**
	 * 删除TsFuncIfno
	 *
	 * @param dbId
	 */
	public void deleteTsFuncIfno(String muDbId) throws Exception;


	/**
	 * 列举员工信息，带分页
	 *
	 * @param TsFuncIfno
	 * @return
	 */
	public PageDataBunder listTsFuncIfno(TsFuncIfno paramBean, Page page) throws Exception;

	/**
	 * 查询用户的菜单
	 *
	 * @param userId
	 * @return
	 * @throws Exception
	 */
	public List<TsFuncIfno> listUserFuncList(String userId) throws Exception;

	/**
	 * 查询用户的快捷菜单
	 *
	 * @param userId
	 * @return
	 * @throws Exception
	 */
	public List<TsFuncIfno> listUserQuickFuncList(String userId) throws Exception;

	/**
	 * 查询用户的功能ID
	 *
	 * @param userId
	 * @return
	 * @throws Exception
	 */
	public List<String> listUserFuncIds(String userId) throws Exception;

	/**
	 * 查询所有菜单树
	 *
	 * @return
	 * @throws Exception
	 */
	public List<TsFuncIfno> listAllFuncList(String isSuperUser) throws Exception;

	/**
	 * 查询菜单树JSON字符串
	 *
	 * @return
	 * @throws Exception
	 */
	public String getFuncJson(String isSuperUser) throws Exception;

	/**
	 * 获取菜单树JSON字符串，并且默认选中此角色的功能
	 * @param roleId
	 * @return
	 * @throws Exception
	 */
	public String getFuncJsonWithRole(String roleId, String isSuperUser) throws Exception;

	/**
	 * 检查指定的MUID是否存在
	 *
	 * @param muId
	 * @return
	 * @throws Exception
	 */
	public boolean getFuncMuIdExists(String muId) throws Exception;

	/**
	 * 更新菜单信息
	 *
	 * @param parentId
	 * @param dbId
	 * @param newTreeList
	 * @throws Exception
	 */
	public void updateFuncOrders(String parentId, String dbId, List<TsFuncIfno> newTreeList) throws Exception;

	/**
	 * 读取角色下拉列表功能树
	 *
	 * @param roleId
	 * @return
	 * @throws Exception
	 */
	public String getRolesFuncTreeJson(String roleId, String isSuperUser) throws Exception;

	/**
	 * 查询用户角色的可显示 的菜单树
	 * @param userId
	 * @return
	 * @throws Exception
	 */
	public String getUserQuickFuncTreeJson(String userId) throws  Exception;

	/**
	 * 添加快捷菜单
	 * @param userId
	 * @param funcId
	 * @throws Exception
	 */
	public void addQuickLinkFunc(String userId, String funcId) throws Exception;

	/**
	 * 删除快捷菜单
	 * @param userId
	 * @param funcId
	 * @throws Exception
	 */
	public void delQuickLinkFunc(String userId, String funcId) throws Exception;

	/**
	 * 查询用户的快捷菜单
	 * @param userId
	 * @return
	 * @throws Exception
	 */
	public List<TsFuncIfno> listQucikFunc(String userId) throws Exception;

	/**
	 * 根据菜单ID获取菜单信息
	 * @param muId
	 * @return
	 */
	public TsFuncIfno getFuncFromId(String muId) throws Exception;

}