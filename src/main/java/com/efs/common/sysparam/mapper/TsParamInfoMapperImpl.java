package com.efs.common.sysparam.mapper;

import com.efs.common.database.BaseMapper;
import com.efs.common.database.Page;
import com.efs.common.database.PageDataBunder;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Repository("tsParamInfoMapper")
public class TsParamInfoMapperImpl extends BaseMapper implements TsParamInfoMapper
{

	@Resource(name = "sqlSession")
	private SqlSessionTemplate sqlSession;
	
	@Override
	public TsParamInfo getTsParamInfo(String dbId) throws Exception
	{
		return sqlSession.selectOne("com.efs.common.sysparam.mapper.TsParamInfoMapper.getTsParamInfo", dbId);
	}

	@Override
	public void addTsParamInfo(TsParamInfo tsParamInfo) throws Exception
	{
		sqlSession.insert("com.efs.common.sysparam.mapper.TsParamInfoMapper.addTsParamInfo", tsParamInfo);
	}

	@Override
	public void updateTsParamInfo(TsParamInfo tsParamInfo) throws Exception
	{
		sqlSession.update("com.efs.common.sysparam.mapper.TsParamInfoMapper.updateTsParamInfo", tsParamInfo);
	}

	@Override
	public void deleteTsParamInfo(String dbId) throws Exception
	{
		sqlSession.delete("com.efs.common.sysparam.mapper.TsParamInfoMapper.deleteTsParamInfo", dbId);
	}
	
	@Override
	public PageDataBunder listTsParamInfo(TsParamInfo paramBean,Page page) throws Exception
	{
		return queryPagedResult(sqlSession, "com.efs.common.sysparam.mapper.TsParamInfoMapper.listTsParamInfo", paramBean, page);
	}

	@Override
	public List<TsParamInfo> listTsParamByType(String type)
	{
		return sqlSession.selectList("com.efs.common.sysparam.mapper.TsParamInfoMapper.listTsParamByType",type);
	}

	@Override
	public String getTsParamValue(TsParamInfo tsParamInfo)
	{
		return sqlSession.selectOne("com.efs.common.sysparam.mapper.TsParamInfoMapper.getTsParamValue",tsParamInfo);
	}
}
