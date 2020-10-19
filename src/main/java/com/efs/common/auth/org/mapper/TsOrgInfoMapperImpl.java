package com.efs.common.auth.org.mapper;

import com.efs.common.database.BaseMapper;
import com.efs.common.database.Page;
import com.efs.common.database.PageDataBunder;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Repository("tsOrgInfoMapper")
public class TsOrgInfoMapperImpl extends BaseMapper implements TsOrgInfoMapper
{

	@Resource(name = "sqlSession")
	private SqlSessionTemplate sqlSession;
	
	@Override
	public TsOrgInfo getTsOrgInfo(String oiCode) throws Exception
	{
		return sqlSession.selectOne("com.efs.common.auth.org.mapper.TsOrgInfoMapper.getTsOrgInfo", oiCode);
	}

	@Override
	public void addTsOrgInfo(TsOrgInfo tsOrgInfo) throws Exception
	{
		sqlSession.insert("com.efs.common.auth.org.mapper.TsOrgInfoMapper.addTsOrgInfo", tsOrgInfo);
	}

	@Override
	public void updateTsOrgInfo(TsOrgInfo tsOrgInfo) throws Exception
	{
		sqlSession.update("com.efs.common.auth.org.mapper.TsOrgInfoMapper.updateTsOrgInfo", tsOrgInfo);
	}

	@Override
	public void deleteTsOrgInfo(String oiCode) throws Exception
	{
		sqlSession.delete("com.efs.common.auth.org.mapper.TsOrgInfoMapper.deleteTsOrgInfo", oiCode);
	}
	
	@Override
	public PageDataBunder listTsOrgInfo(TsOrgInfo paramBean,Page page) throws Exception
	{
		return queryPagedResult(sqlSession, "com.efs.common.auth.org.mapper.TsOrgInfoMapper.listTsOrgInfo", paramBean, page);
	}

	/**
	 * 列举所有可用的组织机构
	 *
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<TsOrgInfo> listActiveOrgInfo() throws Exception
	{
		return sqlSession.selectList("com.efs.common.auth.org.mapper.TsOrgInfoMapper.listActiveOrgInfo");
	}

	/**
	 * 获取某个机构被用户关联的数量
	 *
	 * @param oiCode@return
	 * @throws Exception
	 */
	@Override
	public Integer getUserOrgCount(String oiCode) throws Exception
	{
		Integer res = sqlSession.selectOne("com.efs.common.auth.org.mapper.TsOrgInfoMapper.getUserOrgCount",oiCode);
		return res;
	}

	/**
	 * 查询所有公司及分公司
	 *
	 * @return
	 */
	@Override
	public List<TsOrgInfo> listBranchOrg()
	{
		return sqlSession.selectList("com.efs.common.auth.org.mapper.TsOrgInfoMapper.listBranchOrg");
	}
}
