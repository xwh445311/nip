package com.efs.bus.base.qylsl.mapper;

import com.efs.common.database.BaseMapper;
import com.efs.common.database.Page;
import com.efs.common.database.PageDataBunder;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

@Repository("tbSbqylMapper")
public class TbSbqylMapperImpl extends BaseMapper implements TbSbqylMapper
{

	@Resource(name = "sqlSession")
	private SqlSessionTemplate sqlSession;
	
	@Override
	public TbSbqyl getTbSbqyl(String dbId) throws Exception
	{
		return sqlSession.selectOne("com.efs.bus.base.qylsl.mapper.TbSbqylMapper.getTbSbqyl", dbId);
	}

	@Override
	public void addTbSbqyl(TbSbqyl tbSbqyl) throws Exception
	{
		sqlSession.insert("com.efs.bus.base.qylsl.mapper.TbSbqylMapper.addTbSbqyl", tbSbqyl);
	}

	@Override
	public void updateTbSbqyl(TbSbqyl tbSbqyl) throws Exception
	{
		sqlSession.update("com.efs.bus.base.qylsl.mapper.TbSbqylMapper.updateTbSbqyl", tbSbqyl);
	}

	@Override
	public void deleteTbSbqyl(String dbId) throws Exception
	{
		sqlSession.delete("com.efs.bus.base.qylsl.mapper.TbSbqylMapper.deleteTbSbqyl", dbId);
	}
	
	@Override
	public PageDataBunder listTbSbqyl(TbSbqyl paramBean,Page page) throws Exception
	{
		return queryPagedResult(sqlSession, "com.efs.bus.base.qylsl.mapper.TbSbqylMapper.listTbSbqyl", paramBean, page);
	}
}
