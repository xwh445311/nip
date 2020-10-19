package com.efs.bus.base.ysxz.mapper;

import com.efs.common.database.BaseMapper;
import com.efs.common.database.Page;
import com.efs.common.database.PageDataBunder;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Repository("tbYsxzInfoMapper")
public class TbYsxzInfoMapperImpl extends BaseMapper implements TbYsxzInfoMapper
{

	@Resource(name = "sqlSession")
	private SqlSessionTemplate sqlSession;
	
	@Override
	public TbYsxzInfo getTbYsxzInfo(String xzdm) throws Exception
	{
		return sqlSession.selectOne("com.efs.bus.base.ysxz.mapper.TbYsxzInfoMapper.getTbYsxzInfo", xzdm);
	}

	@Override
	public void addTbYsxzInfo(TbYsxzInfo tbYsxzInfo) throws Exception
	{
		sqlSession.insert("com.efs.bus.base.ysxz.mapper.TbYsxzInfoMapper.addTbYsxzInfo", tbYsxzInfo);
	}

	@Override
	public void updateTbYsxzInfo(TbYsxzInfo tbYsxzInfo) throws Exception
	{
		sqlSession.update("com.efs.bus.base.ysxz.mapper.TbYsxzInfoMapper.updateTbYsxzInfo", tbYsxzInfo);
	}

	@Override
	public void deleteTbYsxzInfo(String xzdm) throws Exception
	{
		sqlSession.delete("com.efs.bus.base.ysxz.mapper.TbYsxzInfoMapper.deleteTbYsxzInfo", xzdm);
	}
	
	@Override
	public PageDataBunder listTbYsxzInfo(TbYsxzInfo paramBean,Page page) throws Exception
	{
		return queryPagedResult(sqlSession, "com.efs.bus.base.ysxz.mapper.TbYsxzInfoMapper.listTbYsxzInfo", paramBean, page);
	}

	@Override
	public List<TbYsxzInfo> listAllValidYsxz()
	{
		return sqlSession.selectList("com.efs.bus.base.ysxz.mapper.TbYsxzInfoMapper.listAllValidYsxz");
	}
}
