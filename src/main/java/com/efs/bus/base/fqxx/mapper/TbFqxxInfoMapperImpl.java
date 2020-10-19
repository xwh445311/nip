package com.efs.bus.base.fqxx.mapper;

import com.efs.common.database.BaseMapper;
import com.efs.common.database.Page;
import com.efs.common.database.PageDataBunder;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

@Repository("tbFqxxInfoMapper")
public class TbFqxxInfoMapperImpl extends BaseMapper implements TbFqxxInfoMapper
{

	@Resource(name = "sqlSession")
	private SqlSessionTemplate sqlSession;
	
	@Override
	public TbFqxxInfo getTbFqxxInfo(String qyId) throws Exception
	{
		return sqlSession.selectOne("com.efs.bus.base.fqxx.mapper.TbFqxxInfoMapper.getTbFqxxInfo", qyId);
	}

	@Override
	public void addTbFqxxInfo(TbFqxxInfo tbFqxxInfo) throws Exception
	{
		sqlSession.insert("com.efs.bus.base.fqxx.mapper.TbFqxxInfoMapper.addTbFqxxInfo", tbFqxxInfo);
	}

	@Override
	public void updateTbFqxxInfo(TbFqxxInfo tbFqxxInfo) throws Exception
	{
		sqlSession.update("com.efs.bus.base.fqxx.mapper.TbFqxxInfoMapper.updateTbFqxxInfo", tbFqxxInfo);
	}

	@Override
	public void deleteTbFqxxInfo(String qyId) throws Exception
	{
		sqlSession.delete("com.efs.bus.base.fqxx.mapper.TbFqxxInfoMapper.deleteTbFqxxInfo", qyId);
	}
	
	@Override
	public PageDataBunder listTbFqxxInfo(TbFqxxInfo paramBean,Page page) throws Exception
	{
		return queryPagedResult(sqlSession, "com.efs.bus.base.fqxx.mapper.TbFqxxInfoMapper.listTbFqxxInfo", paramBean, page);
	}
}
