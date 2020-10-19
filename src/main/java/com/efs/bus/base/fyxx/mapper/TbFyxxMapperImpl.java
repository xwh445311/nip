package com.efs.bus.base.fyxx.mapper;

import com.efs.common.database.BaseMapper;
import com.efs.common.database.Page;
import com.efs.common.database.PageDataBunder;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Repository("tbFyxxMapper")
public class TbFyxxMapperImpl extends BaseMapper implements TbFyxxMapper
{

	@Resource(name = "sqlSession")
	private SqlSessionTemplate sqlSession;
	
	@Override
	public TbFyxx getTbFyxx(String fydm) throws Exception
	{
		return sqlSession.selectOne("com.efs.bus.base.fyxx.mapper.TbFyxxMapper.getTbFyxx", fydm);
	}

	@Override
	public void addTbFyxx(TbFyxx tbFyxx) throws Exception
	{
		sqlSession.insert("com.efs.bus.base.fyxx.mapper.TbFyxxMapper.addTbFyxx", tbFyxx);
	}

	@Override
	public void updateTbFyxx(TbFyxx tbFyxx) throws Exception
	{
		sqlSession.update("com.efs.bus.base.fyxx.mapper.TbFyxxMapper.updateTbFyxx", tbFyxx);
	}

	@Override
	public void deleteTbFyxx(String fydm) throws Exception
	{
		sqlSession.delete("com.efs.bus.base.fyxx.mapper.TbFyxxMapper.deleteTbFyxx", fydm);
	}
	
	@Override
	public PageDataBunder listTbFyxx(TbFyxx paramBean,Page page) throws Exception
	{
		return queryPagedResult(sqlSession, "com.efs.bus.base.fyxx.mapper.TbFyxxMapper.listTbFyxx", paramBean, page);
	}

	@Override
	public List<TbFyxx> listAllFyxx()
	{
		return sqlSession.selectList("com.efs.bus.base.fyxx.mapper.TbFyxxMapper.listAllFyxx");
	}
}
