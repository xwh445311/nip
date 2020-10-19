package com.efs.bus.base.tsbz.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.efs.bus.base.tsbz.mapper.TbTsbzMapper;
import com.efs.bus.base.tsbz.mapper.TbTsbz;

import com.efs.common.database.Page;
import com.efs.common.database.PageDataBunder;
import org.springframework.stereotype.Service;

@Service("tbTsbzService")
public class TbTsbzServiceImpl implements TbTsbzService
{
	@Resource(name="tbTsbzMapper")
	private TbTsbzMapper tbTsbzMapper;
	
	@Override
	public TbTsbz getTbTsbz(String bm) throws Exception
	{
		return tbTsbzMapper.getTbTsbz(bm);
	}

	@Override
	public void addTbTsbz(TbTsbz tbTsbz) throws Exception
	{
		tbTsbzMapper.addTbTsbz(tbTsbz);
	}

	@Override
	public void updateTbTsbz(TbTsbz tbTsbz) throws Exception
	{
		tbTsbzMapper.updateTbTsbz(tbTsbz);
	}

	@Override
	public void deleteTbTsbz(String bm) throws Exception
	{
		tbTsbzMapper.deleteTbTsbz(bm);
	}

	@Override
	public PageDataBunder listTbTsbz(TbTsbz paramBean,Page page) throws Exception
	{
		return tbTsbzMapper.listTbTsbz(paramBean,page);
	}
	
}
