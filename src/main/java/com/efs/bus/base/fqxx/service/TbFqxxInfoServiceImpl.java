package com.efs.bus.base.fqxx.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.efs.bus.base.fqxx.mapper.TbFqxxInfoMapper;
import com.efs.bus.base.fqxx.mapper.TbFqxxInfo;

import com.efs.common.database.Page;
import com.efs.common.database.PageDataBunder;
import org.springframework.stereotype.Service;

@Service("tbFqxxInfoService")
public class TbFqxxInfoServiceImpl implements TbFqxxInfoService
{
	@Resource(name="tbFqxxInfoMapper")
	private TbFqxxInfoMapper tbFqxxInfoMapper;
	
	@Override
	public TbFqxxInfo getTbFqxxInfo(String qyId) throws Exception
	{
		return tbFqxxInfoMapper.getTbFqxxInfo(qyId);
	}

	@Override
	public void addTbFqxxInfo(TbFqxxInfo tbFqxxInfo) throws Exception
	{
		tbFqxxInfoMapper.addTbFqxxInfo(tbFqxxInfo);
	}

	@Override
	public void updateTbFqxxInfo(TbFqxxInfo tbFqxxInfo) throws Exception
	{
		tbFqxxInfoMapper.updateTbFqxxInfo(tbFqxxInfo);
	}

	@Override
	public void deleteTbFqxxInfo(String qyId) throws Exception
	{
		tbFqxxInfoMapper.deleteTbFqxxInfo(qyId);
	}

	@Override
	public PageDataBunder listTbFqxxInfo(TbFqxxInfo paramBean,Page page) throws Exception
	{
		return tbFqxxInfoMapper.listTbFqxxInfo(paramBean,page);
	}
	
}
