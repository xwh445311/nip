package com.efs.bus.fee.sbzl.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.efs.bus.fee.sbzl.mapper.TcSbzlMapper;
import com.efs.bus.fee.sbzl.mapper.TcSbzl;

import com.efs.common.database.Page;
import com.efs.common.database.PageDataBunder;
import org.springframework.stereotype.Service;

@Service("tcSbzlService")
public class TcSbzlServiceImpl implements TcSbzlService
{
	@Resource(name="tcSbzlMapper")
	private TcSbzlMapper tcSbzlMapper;
	
	@Override
	public TcSbzl getTcSbzl(String sbxh) throws Exception
	{
		return tcSbzlMapper.getTcSbzl(sbxh);
	}

	@Override
	public void addTcSbzl(TcSbzl tcSbzl) throws Exception
	{
		tcSbzlMapper.addTcSbzl(tcSbzl);
	}

	@Override
	public void updateTcSbzl(TcSbzl tcSbzl) throws Exception
	{
		tcSbzlMapper.updateTcSbzl(tcSbzl);
	}

	@Override
	public void deleteTcSbzl(String sbxh) throws Exception
	{
		tcSbzlMapper.deleteTcSbzl(sbxh);
	}

	@Override
	public PageDataBunder listTcSbzl(TcSbzl paramBean,Page page) throws Exception
	{
		return tcSbzlMapper.listTcSbzl(paramBean,page);
	}
	
}
