package com.efs.bpmn.proc.def.mapper;

import java.util.List;

import org.activiti.engine.identity.Group;

public interface MyGroupMapper
{
	/**
	 * 根据用户ID查询用户组
	 * @param userId
	 * @return
	 */
	public List<Group> findGroupsByUser(String userId);
}
