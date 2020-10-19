package com.efs.bus.base.jtdj.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.efs.bus.base.jtdj.mapper.TbJtdj;
import com.efs.bus.base.jtdj.mapper.TbJtdjMapper;
import com.efs.common.database.Page;
import com.efs.common.database.PageDataBunder;
import org.springframework.stereotype.Service;

@Service("tbJtdjService")
public class TbJtdjServiceImpl implements TbJtdjService
{
	@Resource(name="tbJtdjMapper")
	private TbJtdjMapper tbJtdjMapper;
	
	@Override
	public TbJtdj getTbJtdj(String dbId) throws Exception
	{
		return tbJtdjMapper.getTbJtdj(dbId);
	}

	@Override
	public void addTbJtdj(TbJtdj tbJtdj) throws Exception
	{
		tbJtdjMapper.addTbJtdj(tbJtdj);
	}

	@Override
	public void updateTbJtdj(TbJtdj tbJtdj) throws Exception
	{
		tbJtdjMapper.updateTbJtdj(tbJtdj);
	}

	@Override
	public void deleteTbJtdj(String dbId) throws Exception
	{
		tbJtdjMapper.deleteTbJtdj(dbId);
	}

	@Override
	public PageDataBunder listTbJtdj(TbJtdj paramBean,Page page) throws Exception
	{
		return tbJtdjMapper.listTbJtdj(paramBean,page);
	}
	
}
