package com.efs.bus.base.qylsl.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.efs.bus.base.qylsl.mapper.TbSbqylMapper;
import com.efs.bus.base.qylsl.mapper.TbSbqyl;

import com.efs.common.database.Page;
import com.efs.common.database.PageDataBunder;
import org.springframework.stereotype.Service;

@Service("tbSbqylService")
public class TbSbqylServiceImpl implements TbSbqylService
{
	@Resource(name="tbSbqylMapper")
	private TbSbqylMapper tbSbqylMapper;
	
	@Override
	public TbSbqyl getTbSbqyl(String dbId) throws Exception
	{
		return tbSbqylMapper.getTbSbqyl(dbId);
	}

	@Override
	public void addTbSbqyl(TbSbqyl tbSbqyl) throws Exception
	{
		tbSbqylMapper.addTbSbqyl(tbSbqyl);
	}

	@Override
	public void updateTbSbqyl(TbSbqyl tbSbqyl) throws Exception
	{
		tbSbqylMapper.updateTbSbqyl(tbSbqyl);
	}

	@Override
	public void deleteTbSbqyl(String dbId) throws Exception
	{
		tbSbqylMapper.deleteTbSbqyl(dbId);
	}

	@Override
	public PageDataBunder listTbSbqyl(TbSbqyl paramBean,Page page) throws Exception
	{
		return tbSbqylMapper.listTbSbqyl(paramBean,page);
	}
	
}
