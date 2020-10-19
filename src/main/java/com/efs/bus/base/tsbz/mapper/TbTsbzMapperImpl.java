package com.efs.bus.base.tsbz.mapper;

import com.efs.common.database.BaseMapper;
import com.efs.common.database.Page;
import com.efs.common.database.PageDataBunder;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

@Repository("tbTsbzMapper")
public class TbTsbzMapperImpl extends BaseMapper implements TbTsbzMapper
{

	@Resource(name = "sqlSession")
	private SqlSessionTemplate sqlSession;
	
	@Override
	public TbTsbz getTbTsbz(String bm) throws Exception
	{
		return sqlSession.selectOne("com.efs.bus.base.tsbz.mapper.TbTsbzMapper.getTbTsbz", bm);
	}

	@Override
	public void addTbTsbz(TbTsbz tbTsbz) throws Exception
	{
		sqlSession.insert("com.efs.bus.base.tsbz.mapper.TbTsbzMapper.addTbTsbz", tbTsbz);
	}

	@Override
	public void updateTbTsbz(TbTsbz tbTsbz) throws Exception
	{
		sqlSession.update("com.efs.bus.base.tsbz.mapper.TbTsbzMapper.updateTbTsbz", tbTsbz);
	}

	@Override
	public void deleteTbTsbz(String bm) throws Exception
	{
		sqlSession.delete("com.efs.bus.base.tsbz.mapper.TbTsbzMapper.deleteTbTsbz", bm);
	}
	
	@Override
	public PageDataBunder listTbTsbz(TbTsbz paramBean,Page page) throws Exception
	{
		return queryPagedResult(sqlSession, "com.efs.bus.base.tsbz.mapper.TbTsbzMapper.listTbTsbz", paramBean, page);
	}
}
