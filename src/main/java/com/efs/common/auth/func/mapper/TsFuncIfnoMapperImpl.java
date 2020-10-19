package com.efs.common.auth.func.mapper;

import com.efs.common.database.BaseMapper;
import com.efs.common.database.Page;
import com.efs.common.database.PageDataBunder;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository("tsFuncIfnoMapper")
public class TsFuncIfnoMapperImpl extends BaseMapper implements TsFuncIfnoMapper
{

	@Resource(name = "sqlSession")
	private SqlSessionTemplate sqlSession;
	
	@Override
	public TsFuncIfno getTsFuncIfno(String muDbId) throws Exception
	{
		return sqlSession.selectOne("com.efs.common.auth.func.mapper.TsFuncIfnoMapper.getTsFuncIfno", muDbId);
	}

	@Override
	public void addTsFuncIfno(TsFuncIfno tsFuncIfno) throws Exception
	{
		sqlSession.insert("com.efs.common.auth.func.mapper.TsFuncIfnoMapper.addTsFuncIfno", tsFuncIfno);
	}

	@Override
	public void updateTsFuncIfno(TsFuncIfno tsFuncIfno) throws Exception
	{
		sqlSession.update("com.efs.common.auth.func.mapper.TsFuncIfnoMapper.updateTsFuncIfno", tsFuncIfno);
	}

	@Override
	public void deleteTsFuncIfno(String muDbId) throws Exception
	{
		sqlSession.delete("com.efs.common.auth.func.mapper.TsFuncIfnoMapper.deleteTsFuncIfno", muDbId);
	}
	
	@Override
	public PageDataBunder listTsFuncIfno(TsFuncIfno paramBean,Page page) throws Exception
	{
		return queryPagedResult(sqlSession, "com.efs.common.auth.func.mapper.TsFuncIfnoMapper.listTsFuncIfno", paramBean, page);
	}

	/**
	 * 查询用户第一层菜单
	 *
	 * @param userId
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<TsFuncIfno> listFirstLevelFunc(String userId) throws Exception
	{
		return sqlSession.selectList("com.efs.common.auth.func.mapper.TsFuncIfnoMapper.listFirstLevelFunc",userId);
	}

	/**
	 * 查询用户第二层菜单
	 *
	 * @param userId
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<TsFuncIfno> listChilddFunc(String userId,String funcId) throws Exception
	{
		Map<String,Object> paramMap = new HashMap<>();
		paramMap.put("userId",userId);
		paramMap.put("funcId",funcId);
		return sqlSession.selectList("com.efs.common.auth.func.mapper.TsFuncIfnoMapper.listChilddFunc",paramMap);
	}

	/**
	 * 查询用户快捷第一层菜单
	 *
	 * @param userId
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<TsFuncIfno> listQuickFirstLevelFunc(String userId) throws Exception
	{
		return sqlSession.selectList("com.efs.common.auth.func.mapper.TsFuncIfnoMapper.listQuickFirstLevelFunc",userId);
	}

	/**
	 * 查询用户快捷第二层菜单
	 *
	 * @param userId
	 * @param funcId
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<TsFuncIfno> listQuickChilddFunc(String userId, String funcId) throws Exception
	{
		Map<String,Object> paramMap = new HashMap<>();
		paramMap.put("userId",userId);
		paramMap.put("funcId",funcId);
		return sqlSession.selectList("com.efs.common.auth.func.mapper.TsFuncIfnoMapper.listQuickChilddFunc",paramMap);
	}

	/**
	 *
	 * @param userId
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<String> listUserFuncIds(String userId) throws Exception
	{
		return sqlSession.selectList("com.efs.common.auth.func.mapper.TsFuncIfnoMapper.listUserFuncIds",userId);
	}

	/**
	 * 所查询所有的第一层菜单信息
	 *
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<TsFuncIfno> listAllFirstLevelFunc(String isSuperUser) throws Exception
	{
		Map<String,Object> paramMap = new HashMap<>();
		paramMap.put("isSuperUser",isSuperUser);
		return sqlSession.selectList("com.efs.common.auth.func.mapper.TsFuncIfnoMapper.listAllFirstLevelFunc",paramMap);
	}

	/**
	 * 查询所有第二层菜单信息
	 *
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<TsFuncIfno> listAllSecondLevelFunc(String muParDbId,String isSuperUser) throws Exception
	{
		Map<String,Object> paramMap = new HashMap<>();
		paramMap.put("isSuperUser",isSuperUser);
		paramMap.put("muParDbId",muParDbId);
		return sqlSession.selectList("com.efs.common.auth.func.mapper.TsFuncIfnoMapper.listAllSecondLevelFunc",paramMap);
	}

	/**
	 * 獲取父節點下的子節點的最大排序號
	 *
	 * @param muParDbId
	 * @return
	 * @throws Exception
	 */
	@Override
	public int getMaxFuncMenuOrder(String muParDbId) throws Exception
	{
		Integer res = sqlSession.selectOne("com.efs.common.auth.func.mapper.TsFuncIfnoMapper.getMaxFuncMenuOrder",muParDbId);
		if(res == null)
		{
			res = 0;
		}

		return res;
	}

	/**
	 * 删除系统角色中关联的菜单ID和子菜单
	 *
	 * @param muDbId
	 * @throws Exception
	 */
	@Override
	public void deleteRoleFunc(String muDbId) throws Exception
	{
		sqlSession.delete("com.efs.common.auth.func.mapper.TsFuncIfnoMapper.deleteRoleFunc", muDbId);
	}

	/**
	 * 检查指定的MUID是否存在
	 *
	 * @param muId
	 * @return
	 * @throws Exception
	 */
	@Override
	public boolean getFuncMuIdExists(String muId) throws Exception
	{
		Integer count = sqlSession.selectOne("com.efs.common.auth.func.mapper.TsFuncIfnoMapper.getFuncMuIdExists",muId);

		if(count > 0)
		{
			return true;
		}


		return false;
	}

	/**
	 * 更新父ID
	 *
	 * @param muDbId
	 * @param muParDbId
	 * @throws Exception
	 */
	@Override
	public void updateSysFuncParentId(String muDbId, String muParDbId) throws Exception
	{
		Map<String,Object> paramMap = packParamater(this.getClass(),"updateSysFuncParentId",muDbId,muParDbId);
		sqlSession.update("com.efs.common.auth.func.mapper.TsFuncIfnoMapper.updateSysFuncParentId",paramMap);
	}

	/**
	 * 更新菜单顺序
	 *
	 * @param funcList
	 * @throws Exception
	 */
	@Override
	public void updateSysFuncOrder(List<TsFuncIfno> funcList) throws Exception
	{
		sqlSession.update("com.efs.common.auth.func.mapper.TsFuncIfnoMapper.updateSysFuncOrder",funcList);
	}

	/**
	 * 查询角色对应的功能ID
	 *
	 * @param roleId
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<String> listRoleFuncList(String roleId) throws Exception
	{
		return sqlSession.selectList("com.efs.common.auth.func.mapper.TsFuncIfnoMapper.listRoleFuncList",roleId);
	}

	/**
	 * 查询当前用户的快捷菜单
	 *
	 * @param userId
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<String> listQuickLinkList(String userId) throws Exception
	{
		return sqlSession.selectList("com.efs.common.auth.func.mapper.TsFuncIfnoMapper.listQuickLinkList",userId);
	}

	/**
	 * 添加快捷菜单
	 *
	 * @param userId
	 * @param funcId
	 * @throws Exception
	 */
	@Override
	public void addQuickLinkFunc(String userId, String funcId) throws Exception
	{
		Map<String,Object> param = new HashMap<String,Object>();

		param.put("userId",userId);
		param.put("funcId",funcId);

		sqlSession.insert("com.efs.common.auth.func.mapper.TsFuncIfnoMapper.addQuickLinkFunc",param);
	}

	/**
	 * 删除快捷菜单
	 *
	 * @param userId
	 * @param funcId
	 * @throws Exception
	 */
	@Override
	public void delQuickLinkFunc(String userId, String funcId) throws Exception
	{
		Map<String,Object> param = new HashMap<String,Object>();

		param.put("userId",userId);
		param.put("funcId",funcId);

		sqlSession.delete("com.efs.common.auth.func.mapper.TsFuncIfnoMapper.delQuickLinkFunc",param);
	}

	/**
	 * 查询用户的快捷菜单
	 *
	 * @param userId
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<TsFuncIfno> listQucikFunc(String userId) throws Exception
	{
		return sqlSession.selectList("com.efs.common.auth.func.mapper.TsFuncIfnoMapper.listQucikFunc",userId);
	}

	/**
	 * 根据菜单ID获取菜单信息
	 *
	 * @param muId
	 * @return
	 */
	@Override
	public TsFuncIfno getFuncFromId(String muId)
	{
		return sqlSession.selectOne("com.efs.common.auth.func.mapper.TsFuncIfnoMapper.getFuncFromId",muId);
	}
}
