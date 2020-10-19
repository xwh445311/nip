package com.efs.bus.chargefee.users.mapper;

import com.efs.common.database.BaseMapper;
import com.efs.common.database.Page;
import com.efs.common.database.PageDataBunder;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

@Repository("tbYhzlMapper")
public class TbYhzlMapperImpl extends BaseMapper implements TbYhzlMapper
{

	@Resource(name = "sqlSession")
	private SqlSessionTemplate sqlSession;
	
	@Override
	public TbYhzl getTbYhzl(String yhbh) throws Exception
	{
		return sqlSession.selectOne("com.efs.bus.chargefee.users.mapper.TbYhzlMapper.getTbYhzl", yhbh);
	}

	@Override
	public void addTbYhzl(TbYhzl tbYhzl) throws Exception
	{
		sqlSession.insert("com.efs.bus.chargefee.users.mapper.TbYhzlMapper.addTbYhzl", tbYhzl);
	}

	@Override
	public void updateTbYhzl(TbYhzl tbYhzl) throws Exception
	{
		sqlSession.update("com.efs.bus.chargefee.users.mapper.TbYhzlMapper.updateTbYhzl", tbYhzl);
	}

	@Override
	public void deleteTbYhzl(String yhbh) throws Exception
	{
		sqlSession.delete("com.efs.bus.chargefee.users.mapper.TbYhzlMapper.deleteTbYhzl", yhbh);
	}
	
	@Override
	public PageDataBunder listTbYhzl(TbYhzl paramBean,Page page) throws Exception
	{
		return queryPagedResult(sqlSession, "com.efs.bus.chargefee.users.mapper.TbYhzlMapper.listTbYhzl", paramBean, page);
	}
}
