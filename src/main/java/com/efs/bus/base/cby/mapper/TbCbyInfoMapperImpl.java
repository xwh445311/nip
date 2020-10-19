package com.efs.bus.base.cby.mapper;

import com.efs.common.database.BaseMapper;
import com.efs.common.database.Page;
import com.efs.common.database.PageDataBunder;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

@Repository("tbCbyInfoMapper")
public class TbCbyInfoMapperImpl extends BaseMapper implements TbCbyInfoMapper
{

	@Resource(name = "sqlSession")
	private SqlSessionTemplate sqlSession;
	
	@Override
	public TbCbyInfo getTbCbyInfo(String dbId) throws Exception
	{
		return sqlSession.selectOne("com.efs.bus.base.cby.mapper.TbCbyInfoMapper.getTbCbyInfo", dbId);
	}

	@Override
	public void addTbCbyInfo(TbCbyInfo tbCbyInfo) throws Exception
	{
		sqlSession.insert("com.efs.bus.base.cby.mapper.TbCbyInfoMapper.addTbCbyInfo", tbCbyInfo);
	}

	@Override
	public void updateTbCbyInfo(TbCbyInfo tbCbyInfo) throws Exception
	{
		sqlSession.update("com.efs.bus.base.cby.mapper.TbCbyInfoMapper.updateTbCbyInfo", tbCbyInfo);
	}

	@Override
	public void deleteTbCbyInfo(String dbId) throws Exception
	{
		sqlSession.delete("com.efs.bus.base.cby.mapper.TbCbyInfoMapper.deleteTbCbyInfo", dbId);
	}
	
	@Override
	public PageDataBunder listTbCbyInfo(TbCbyInfo paramBean,Page page) throws Exception
	{
		return queryPagedResult(sqlSession, "com.efs.bus.base.cby.mapper.TbCbyInfoMapper.listTbCbyInfo", paramBean, page);
	}
}
