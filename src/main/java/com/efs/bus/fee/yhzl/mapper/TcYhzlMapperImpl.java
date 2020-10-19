package com.efs.bus.fee.yhzl.mapper;

import com.efs.common.database.BaseMapper;
import com.efs.common.database.Page;
import com.efs.common.database.PageDataBunder;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

@Repository("tcYhzlMapper")
public class TcYhzlMapperImpl extends BaseMapper implements TcYhzlMapper
{

	@Resource(name = "sqlSession")
	private SqlSessionTemplate sqlSession;
	
	@Override
	public TcYhzl getTcYhzl(String yhbh) throws Exception
	{
		return sqlSession.selectOne("com.efs.bus.fee.yhzl.mapper.TcYhzlMapper.getTcYhzl", yhbh);
	}

	@Override
	public void addTcYhzl(TcYhzl tcYhzl) throws Exception
	{
		sqlSession.insert("com.efs.bus.fee.yhzl.mapper.TcYhzlMapper.addTcYhzl", tcYhzl);
	}

	@Override
	public void updateTcYhzl(TcYhzl tcYhzl) throws Exception
	{
		sqlSession.update("com.efs.bus.fee.yhzl.mapper.TcYhzlMapper.updateTcYhzl", tcYhzl);
	}

	@Override
	public void deleteTcYhzl(String yhbh) throws Exception
	{
		sqlSession.delete("com.efs.bus.fee.yhzl.mapper.TcYhzlMapper.deleteTcYhzl", yhbh);
	}
	
	@Override
	public PageDataBunder listTcYhzl(TcYhzl paramBean,Page page) throws Exception
	{
		return queryPagedResult(sqlSession, "com.efs.bus.fee.yhzl.mapper.TcYhzlMapper.listTcYhzl", paramBean, page);
	}
}
