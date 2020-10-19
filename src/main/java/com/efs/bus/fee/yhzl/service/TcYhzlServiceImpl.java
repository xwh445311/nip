package com.efs.bus.fee.yhzl.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.efs.bus.fee.yhzl.mapper.TcYhzlMapper;
import com.efs.bus.fee.yhzl.mapper.TcYhzl;

import com.efs.common.database.Page;
import com.efs.common.database.PageDataBunder;
import org.springframework.stereotype.Service;

@Service("tcYhzlService")
public class TcYhzlServiceImpl implements TcYhzlService
{
	@Resource(name="tcYhzlMapper")
	private TcYhzlMapper tcYhzlMapper;
	
	@Override
	public TcYhzl getTcYhzl(String yhbh) throws Exception
	{
		return tcYhzlMapper.getTcYhzl(yhbh);
	}

	@Override
	public void addTcYhzl(TcYhzl tcYhzl) throws Exception
	{
		tcYhzlMapper.addTcYhzl(tcYhzl);
	}

	@Override
	public void updateTcYhzl(TcYhzl tcYhzl) throws Exception
	{
		tcYhzlMapper.updateTcYhzl(tcYhzl);
	}

	@Override
	public void deleteTcYhzl(String yhbh) throws Exception
	{
		tcYhzlMapper.deleteTcYhzl(yhbh);
	}

	@Override
	public PageDataBunder listTcYhzl(TcYhzl paramBean,Page page) throws Exception
	{
		return tcYhzlMapper.listTcYhzl(paramBean,page);
	}
	
}
