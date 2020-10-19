package com.efs.bpmn.proc.def.ext;

import org.activiti.engine.impl.interceptor.Session;
import org.activiti.engine.impl.interceptor.SessionFactory;
import org.activiti.engine.impl.persistence.entity.UserEntityManager;
import org.activiti.engine.impl.persistence.entity.UserIdentityManager;
import org.springframework.beans.factory.annotation.Autowired;

public class CustomUserManagerFactory implements SessionFactory 
{

	private UserEntityManager userEntityManager;
	
	
	@Autowired
	public void setUserEntityManager(UserEntityManager userEntityManager)
	{
		this.userEntityManager = userEntityManager;
	}

	@Override
	public Class<?> getSessionType()
	{
		return UserIdentityManager.class;
	}

	@Override
	public Session openSession()
	{
		return userEntityManager;
	}
	
}
