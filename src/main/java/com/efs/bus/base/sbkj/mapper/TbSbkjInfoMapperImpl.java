package com.efs.bus.base.sbkj.mapper;

import com.efs.common.database.BaseMapper;
import com.efs.common.database.Page;
import com.efs.common.database.PageDataBunder;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Repository("tbSbkjInfoMapper")
public class TbSbkjInfoMapperImpl extends BaseMapper implements TbSbkjInfoMapper
{

	@Resource(name = "sqlSession")
	private SqlSessionTemplate sqlSession;
	
	@Override
	public TbSbkjInfo getTbSbkjInfo(String sbkj) throws Exception
	{
		return sqlSession.selectOne("com.efs.bus.base.sbkj.mapper.TbSbkjInfoMapper.getTbSbkjInfo", sbkj);
	}

	@Override
	public void addTbSbkjInfo(TbSbkjInfo tbSbkjInfo) throws Exception
	{
		sqlSession.insert("com.efs.bus.base.sbkj.mapper.TbSbkjInfoMapper.addTbSbkjInfo", tbSbkjInfo);
	}

	@Override
	public void updateTbSbkjInfo(TbSbkjInfo tbSbkjInfo) throws Exception
	{
		sqlSession.update("com.efs.bus.base.sbkj.mapper.TbSbkjInfoMapper.updateTbSbkjInfo", tbSbkjInfo);
	}

	@Override
	public void deleteTbSbkjInfo(String sbkj) throws Exception
	{
		sqlSession.delete("com.efs.bus.base.sbkj.mapper.TbSbkjInfoMapper.deleteTbSbkjInfo", sbkj);
	}
	
	@Override
	public PageDataBunder listTbSbkjInfo(TbSbkjInfo paramBean,Page page) throws Exception
	{
		return queryPagedResult(sqlSession, "com.efs.bus.base.sbkj.mapper.TbSbkjInfoMapper.listTbSbkjInfo", paramBean, page);
	}

	@Override
	public List<TbSbkjInfo> listAllValidSbkj() throws Exception
	{
		return sqlSession.selectList("com.efs.bus.base.sbkj.mapper.TbSbkjInfoMapper.listAllValidSbkj");
	}
}
