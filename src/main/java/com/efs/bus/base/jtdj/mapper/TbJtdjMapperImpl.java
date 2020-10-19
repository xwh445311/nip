package com.efs.bus.base.jtdj.mapper;

import com.efs.common.database.BaseMapper;
import com.efs.common.database.Page;
import com.efs.common.database.PageDataBunder;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

@Repository("tbJtdjMapper")
public class TbJtdjMapperImpl extends BaseMapper implements TbJtdjMapper
{

	@Resource(name = "sqlSession")
	private SqlSessionTemplate sqlSession;
	
	@Override
	public TbJtdj getTbJtdj(String dbId) throws Exception
	{
		return sqlSession.selectOne("com.efs.bus.base.jtdj.mapper.TbJtdjMapper.getTbJtdj", dbId);
	}

	@Override
	public void addTbJtdj(TbJtdj tbJtdj) throws Exception
	{
		sqlSession.insert("com.efs.bus.base.jtdj.mapper.TbJtdjMapper.addTbJtdj", tbJtdj);
	}

	@Override
	public void updateTbJtdj(TbJtdj tbJtdj) throws Exception
	{
		sqlSession.update("com.efs.bus.base.jtdj.mapper.TbJtdjMapper.updateTbJtdj", tbJtdj);
	}

	@Override
	public void deleteTbJtdj(String dbId) throws Exception
	{
		sqlSession.delete("com.efs.bus.base.jtdj.mapper.TbJtdjMapper.deleteTbJtdj", dbId);
	}
	
	@Override
	public PageDataBunder listTbJtdj(TbJtdj paramBean,Page page) throws Exception
	{
		return queryPagedResult(sqlSession, "com.efs.bus.base.jtdj.mapper.TbJtdjMapper.listTbJtdj", paramBean, page);
	}
}
