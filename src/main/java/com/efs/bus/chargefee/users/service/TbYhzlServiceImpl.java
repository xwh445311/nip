package com.efs.bus.chargefee.users.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.efs.bus.chargefee.users.mapper.TbYhzlMapper;
import com.efs.bus.chargefee.users.mapper.TbYhzl;

import com.efs.common.database.Page;
import com.efs.common.database.PageDataBunder;
import org.springframework.stereotype.Service;

@Service("tbYhzlService")
public class TbYhzlServiceImpl implements TbYhzlService
{
	@Resource(name="tbYhzlMapper")
	private TbYhzlMapper tbYhzlMapper;
	
	@Override
	public TbYhzl getTbYhzl(String yhbh) throws Exception
	{
		return tbYhzlMapper.getTbYhzl(yhbh);
	}

	@Override
	public void addTbYhzl(TbYhzl tbYhzl) throws Exception
	{
		tbYhzlMapper.addTbYhzl(tbYhzl);
	}

	@Override
	public void updateTbYhzl(TbYhzl tbYhzl) throws Exception
	{
		tbYhzlMapper.updateTbYhzl(tbYhzl);
	}

	@Override
	public void deleteTbYhzl(String yhbh) throws Exception
	{
		tbYhzlMapper.deleteTbYhzl(yhbh);
	}

	@Override
	public PageDataBunder listTbYhzl(TbYhzl paramBean,Page page) throws Exception
	{
		return tbYhzlMapper.listTbYhzl(paramBean,page);
	}
	
}
