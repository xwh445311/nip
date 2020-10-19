package com.efs.common.loginhis.mapper;

import com.efs.common.database.BaseMapper;
import com.efs.common.database.Page;
import com.efs.common.database.PageDataBunder;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Repository("tsUserLoginInfoMapper")
public class TsUserLoginInfoMapperImpl extends BaseMapper implements TsUserLoginInfoMapper
{

	@Resource(name = "sqlSession")
	private SqlSessionTemplate sqlSession;
	
	@Override
	public TsUserLoginInfo getTsUserLoginInfo(String ulDbId) throws Exception
	{
		return sqlSession.selectOne("com.efs.common.loginhis.mapper.TsUserLoginInfoMapper.getTsUserLoginInfo", ulDbId);
	}

	@Override
	public void addTsUserLoginInfo(TsUserLoginInfo tsUserLoginInfo) throws Exception
	{
		sqlSession.insert("com.efs.common.loginhis.mapper.TsUserLoginInfoMapper.addTsUserLoginInfo", tsUserLoginInfo);
	}

	@Override
	public void updateTsUserLoginInfo(TsUserLoginInfo tsUserLoginInfo) throws Exception
	{
		sqlSession.update("com.efs.common.loginhis.mapper.TsUserLoginInfoMapper.updateTsUserLoginInfo", tsUserLoginInfo);
	}

	@Override
	public void deleteTsUserLoginInfo(String ulDbId) throws Exception
	{
		sqlSession.delete("com.efs.common.loginhis.mapper.TsUserLoginInfoMapper.deleteTsUserLoginInfo", ulDbId);
	}
	
	@Override
	public PageDataBunder listTsUserLoginInfo(TsUserLoginInfo paramBean, Page page) throws Exception
	{
		return queryPagedResult(sqlSession, "com.efs.common.loginhis.mapper.TsUserLoginInfoMapper.listTsUserLoginInfo", paramBean, page);
	}

	/**
	 * 获取用户的登录信息
	 *
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<Map<String, Object>> getUserLoginStatics() throws Exception
	{
		return sqlSession.selectList("com.efs.common.loginhis.mapper.TsUserLoginInfoMapper.getUserLoginStatics");
	}

	/**
	 * 获取当前用户的登录统计信息
	 *
	 * @param userId
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<Map<String, Object>> getCurrUserLoginStatics(String userId) throws Exception
	{
		return sqlSession.selectList("com.efs.common.loginhis.mapper.TsUserLoginInfoMapper.getCurrUserLoginStatics",userId);
	}
}
