package com.efs.bpmn.proc.def.mapper;

import org.activiti.engine.identity.Group;

public class MyGroup implements Group
{
	
	private String id;
	
	private String name;
	
	private String type;

	/**
	 * 
	 */
	private static final long serialVersionUID = 7210812071979533873L;

	@Override
	public String getId()
	{
		return id;
	}

	@Override
	public void setId(String id)
	{
		this.id = id;
	}

	@Override
	public String getName()
	{
		return name;
	}

	@Override
	public void setName(String name)
	{
		this.name = name;
	}

	@Override
	public String getType()
	{
		return type;
	}

	@Override
	public void setType(String type)
	{
		this.type = type;
	}

}
