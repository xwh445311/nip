package com.efs.bpmn.proc.def.ext;

import org.activiti.engine.impl.interceptor.Session;
import org.activiti.engine.impl.interceptor.SessionFactory;
import org.activiti.engine.impl.persistence.entity.GroupEntityManager;
import org.activiti.engine.impl.persistence.entity.GroupIdentityManager;
import org.springframework.beans.factory.annotation.Autowired;

public class CustomerGroupManagerFactory implements SessionFactory
{
	
	private GroupEntityManager groupEntityManager;
	
	@Autowired
	public void setGroupEntityManager(GroupEntityManager groupEntityManager)
	{
		this.groupEntityManager = groupEntityManager;
	}

	@Override
	public Class<?> getSessionType()
	{
		return GroupIdentityManager.class;
	}

	@Override
	public Session openSession()
	{
		return groupEntityManager;
	}
	
}
