package com.efs.bpmn.proc.def.ext;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.efs.bpmn.proc.def.mapper.MyGroupMapper;
import org.activiti.engine.identity.Group;
import org.activiti.engine.impl.GroupQueryImpl;
import org.activiti.engine.impl.Page;
import org.activiti.engine.impl.persistence.entity.GroupEntityManager;


public class CustomerGroupManager extends GroupEntityManager
{
	@Resource(name="myGroupMapper")
	private MyGroupMapper myGroupMapper;

	@Override
	public List<Group> findGroupByQueryCriteria(GroupQueryImpl query, Page page)
	{
		// TODO Auto-generated method stub
		return super.findGroupByQueryCriteria(query, page);
	}

	@Override
	public long findGroupCountByQueryCriteria(GroupQueryImpl query)
	{
		// TODO Auto-generated method stub
		return super.findGroupCountByQueryCriteria(query);
	}

	@Override
	public List<Group> findGroupsByUser(String userId)
	{
		return myGroupMapper.findGroupsByUser(userId);
	}

	@Override
	public List<Group> findGroupsByNativeQuery(Map<String, Object> parameterMap, int firstResult, int maxResults)
	{
		// TODO Auto-generated method stub
		return super.findGroupsByNativeQuery(parameterMap, firstResult, maxResults);
	}

	@Override
	public long findGroupCountByNativeQuery(Map<String, Object> parameterMap)
	{
		// TODO Auto-generated method stub
		return super.findGroupCountByNativeQuery(parameterMap);
	}
	
}
