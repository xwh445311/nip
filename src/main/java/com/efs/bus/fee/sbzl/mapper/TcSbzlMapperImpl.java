package com.efs.bus.fee.sbzl.mapper;

import com.efs.common.database.BaseMapper;
import com.efs.common.database.Page;
import com.efs.common.database.PageDataBunder;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

@Repository("tcSbzlMapper")
public class TcSbzlMapperImpl extends BaseMapper implements TcSbzlMapper
{

	@Resource(name = "sqlSession")
	private SqlSessionTemplate sqlSession;
	
	@Override
	public TcSbzl getTcSbzl(String sbxh) throws Exception
	{
		return sqlSession.selectOne("com.efs.bus.fee.sbzl.mapper.TcSbzlMapper.getTcSbzl", sbxh);
	}

	@Override
	public void addTcSbzl(TcSbzl tcSbzl) throws Exception
	{
		sqlSession.insert("com.efs.bus.fee.sbzl.mapper.TcSbzlMapper.addTcSbzl", tcSbzl);
	}

	@Override
	public void updateTcSbzl(TcSbzl tcSbzl) throws Exception
	{
		sqlSession.update("com.efs.bus.fee.sbzl.mapper.TcSbzlMapper.updateTcSbzl", tcSbzl);
	}

	@Override
	public void deleteTcSbzl(String sbxh) throws Exception
	{
		sqlSession.delete("com.efs.bus.fee.sbzl.mapper.TcSbzlMapper.deleteTcSbzl", sbxh);
	}
	
	@Override
	public PageDataBunder listTcSbzl(TcSbzl paramBean,Page page) throws Exception
	{
		return queryPagedResult(sqlSession, "com.efs.bus.fee.sbzl.mapper.TcSbzlMapper.listTcSbzl", paramBean, page);
	}
}
