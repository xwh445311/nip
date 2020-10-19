package com.efs.bus.todotask.mapper;

import com.efs.common.database.BaseMapper;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Repository("tsTodoTaskInfoMapper")
public class TsTodoTaskInfoMapperImpl extends BaseMapper implements TsTodoTaskInfoMapper
{

	@Resource(name = "sqlSession")
	private SqlSessionTemplate sqlSession;
	
	@Override
	public List<TsTodoTaskInfo> listTsTodoTaskInfo(Map<String,Object> paramMap) throws Exception
	{
		return sqlSession.selectList("com.efs.bus.todotask.mapper.TsTodoTaskInfoMapper.listTsTodoTaskInfo",paramMap);
	}
}
