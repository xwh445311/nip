package com.efs.bpmn.proc.def.mapper;

import java.util.List;

import javax.annotation.Resource;

import org.activiti.engine.identity.Group;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

@Repository("myGroupMapper")
public class MyGroupMapperImpl implements MyGroupMapper
{
	
	@Resource(name = "sqlSession")
	private SqlSessionTemplate sqlSession;

	@Override
	public List<Group> findGroupsByUser(String userId)
	{
		return sqlSession.selectList("com.efs.common.flow.procdef.mapper.MyGroupMapper.findGroupsByUser", userId);
	}

}
