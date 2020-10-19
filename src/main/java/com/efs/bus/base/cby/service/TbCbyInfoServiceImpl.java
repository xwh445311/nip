package com.efs.bus.base.cby.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.efs.bus.base.cby.mapper.TbCbyInfoMapper;
import com.efs.bus.base.cby.mapper.TbCbyInfo;

import com.efs.common.database.Page;
import com.efs.common.database.PageDataBunder;
import org.springframework.stereotype.Service;

@Service("tbCbyInfoService")
public class TbCbyInfoServiceImpl implements TbCbyInfoService
{
	@Resource(name="tbCbyInfoMapper")
	private TbCbyInfoMapper tbCbyInfoMapper;
	
	@Override
	public TbCbyInfo getTbCbyInfo(String dbId) throws Exception
	{
		return tbCbyInfoMapper.getTbCbyInfo(dbId);
	}

	@Override
	public void addTbCbyInfo(TbCbyInfo tbCbyInfo) throws Exception
	{
		tbCbyInfoMapper.addTbCbyInfo(tbCbyInfo);
	}

	@Override
	public void updateTbCbyInfo(TbCbyInfo tbCbyInfo) throws Exception
	{
		tbCbyInfoMapper.updateTbCbyInfo(tbCbyInfo);
	}

	@Override
	public void deleteTbCbyInfo(String dbId) throws Exception
	{
		tbCbyInfoMapper.deleteTbCbyInfo(dbId);
	}

	@Override
	public PageDataBunder listTbCbyInfo(TbCbyInfo paramBean,Page page) throws Exception
	{
		return tbCbyInfoMapper.listTbCbyInfo(paramBean,page);
	}
	
}
