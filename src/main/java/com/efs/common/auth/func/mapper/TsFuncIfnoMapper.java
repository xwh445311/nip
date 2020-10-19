package com.efs.common.auth.func.mapper;

import com.efs.common.database.Page;
import com.efs.common.database.PageDataBunder;

import java.util.List;


/**
 * 
 * com.efs.common.auth.func.mapper.TsFuncIfnoMapper
 * @author xuwh
 * 2017-06-25 15:53:43
 * 系统功能表
 *
 */
public interface TsFuncIfnoMapper
{
	/**
	 * 根据主键ID获取TsFuncIfno
	 * @param muDbId
	 * @return
	 */
	public TsFuncIfno getTsFuncIfno(String muDbId) throws Exception;
	
	/**
	 * 增加TsFuncIfno
	 * @param tsFuncIfno
	 */
	public void addTsFuncIfno(TsFuncIfno tsFuncIfno) throws Exception;
	
	/**
	 * 更新TsFuncIfno
	 * @param empBean
	 */
	public void updateTsFuncIfno(TsFuncIfno tsFuncIfno) throws Exception;
	
	/**
	 * 删除TsFuncIfno
	 * @param muDbId
	 */
	public void deleteTsFuncIfno(String muDbId) throws Exception;
	
	
	/**
	 * 列举员工信息，带分页
	 * @param TsFuncIfno
	 * @return
	 */
	public PageDataBunder listTsFuncIfno(TsFuncIfno paramBean, Page page) throws Exception;

	/**
	 * 查询用户第一层菜单
	 * @param userId
	 * @return
	 * @throws Exception
	 */
	public List<TsFuncIfno> listFirstLevelFunc(String userId) throws Exception;

	/**
	 * 查询用户第二层菜单
	 * @param userId
	 * @return
	 * @throws Exception
	 */
	public List<TsFuncIfno> listChilddFunc(String userId, String funcId) throws Exception;

	/**
	 * 查询用户快捷第一层菜单
	 * @param userId
	 * @return
	 * @throws Exception
	 */
	public List<TsFuncIfno> listQuickFirstLevelFunc(String userId) throws Exception;

	/**
	 * 查询用户快捷第二层菜单
	 * @param userId
	 * @return
	 * @throws Exception
	 */
	public List<TsFuncIfno> listQuickChilddFunc(String userId, String funcId) throws Exception;

	/**
	 * 查询用户的功能ID
	 * @param userId
	 * @return
	 * @throws Exception
	 */
	public List<String> listUserFuncIds(String userId) throws  Exception;

	/**
	 * 所查询所有的第一层菜单信息
	 * @return
	 * @throws Exception
	 */
	public List<TsFuncIfno> listAllFirstLevelFunc(String isSuperUser) throws Exception;

	/**
	 * 查询所有第二层菜单信息
	 * @return
	 * @throws Exception
	 */
	public List<TsFuncIfno> listAllSecondLevelFunc(String muParDbId, String isSuperUser) throws Exception;

	/**
	 * 獲取父節點下的子節點的最大排序號
	 * @param muParDbId
	 * @return
	 * @throws Exception
	 */
	public int getMaxFuncMenuOrder(String muParDbId) throws Exception;

	/**
	 * 删除系统角色中关联的菜单ID和子菜单
	 * @param muDbId
	 * @throws Exception
	 */
	public void deleteRoleFunc(String muDbId) throws Exception;

	/**
	 * 检查指定的MUID是否存在
	 * @param muId
	 * @return
	 * @throws Exception
	 */
	public boolean getFuncMuIdExists(String muId) throws Exception;

	/**
	 * 更新父ID
	 * @param muDbId
	 * @param muParDbId
	 * @throws Exception
	 */
	public void updateSysFuncParentId(String muDbId, String muParDbId) throws Exception;

	/**
	 * 更新菜单顺序
	 * @param funcList
	 * @throws Exception
	 */
	public void updateSysFuncOrder(List<TsFuncIfno> funcList) throws Exception;

	/**
	 * 查询角色对应的功能ID
	 * @param roleId
	 * @return
	 * @throws Exception
	 */
	public List<String> listRoleFuncList(String roleId) throws Exception;

	/**
	 * 查询当前用户的快捷菜单
	 * @param userId
	 * @return
	 * @throws Exception
	 */
	public List<String> listQuickLinkList(String userId) throws Exception;

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
