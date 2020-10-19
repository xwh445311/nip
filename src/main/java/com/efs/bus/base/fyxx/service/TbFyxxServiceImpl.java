package com.efs.bus.base.fyxx.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.efs.bus.base.fyxx.mapper.TbFyxxMapper;
import com.efs.bus.base.fyxx.mapper.TbFyxx;

import com.efs.common.database.Page;
import com.efs.common.database.PageDataBunder;
import com.xwh.bean.SelectBean;
import com.xwh.util.EFSUtil;
import org.springframework.stereotype.Service;

@Service("tbFyxxService")
public class TbFyxxServiceImpl implements TbFyxxService
{
	@Resource(name="tbFyxxMapper")
	private TbFyxxMapper tbFyxxMapper;
	
	@Override
	public TbFyxx getTbFyxx(String fydm) throws Exception
	{
		return tbFyxxMapper.getTbFyxx(fydm);
	}

	@Override
	public void addTbFyxx(TbFyxx tbFyxx) throws Exception
	{
		tbFyxxMapper.addTbFyxx(tbFyxx);
	}

	@Override
	public void updateTbFyxx(TbFyxx tbFyxx) throws Exception
	{
		tbFyxxMapper.updateTbFyxx(tbFyxx);
	}

	@Override
	public void deleteTbFyxx(String fydm) throws Exception
	{
		tbFyxxMapper.deleteTbFyxx(fydm);
	}

	@Override
	public PageDataBunder listTbFyxx(TbFyxx paramBean,Page page) throws Exception
	{
		return tbFyxxMapper.listTbFyxx(paramBean,page);
	}

	@Override
	public List<SelectBean> listAllFyxxSelect() throws Exception
	{
		List<TbFyxx> tbFyxxList = tbFyxxMapper.listAllFyxx();
		return EFSUtil.convertBeanToSelectBean(tbFyxxList,"fydm","fymc");
	}
}
