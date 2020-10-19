package com.efs.bus.base.ysxz.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.efs.bus.base.ysxz.mapper.TbYsxzInfoMapper;
import com.efs.bus.base.ysxz.mapper.TbYsxzInfo;

import com.efs.common.database.Page;
import com.efs.common.database.PageDataBunder;
import com.xwh.bean.SelectBean;
import com.xwh.util.EFSUtil;
import org.springframework.stereotype.Service;

@Service("tbYsxzInfoService")
public class TbYsxzInfoServiceImpl implements TbYsxzInfoService
{
	@Resource(name="tbYsxzInfoMapper")
	private TbYsxzInfoMapper tbYsxzInfoMapper;
	
	@Override
	public TbYsxzInfo getTbYsxzInfo(String xzdm) throws Exception
	{
		return tbYsxzInfoMapper.getTbYsxzInfo(xzdm);
	}

	@Override
	public void addTbYsxzInfo(TbYsxzInfo tbYsxzInfo) throws Exception
	{
		tbYsxzInfoMapper.addTbYsxzInfo(tbYsxzInfo);
	}

	@Override
	public void updateTbYsxzInfo(TbYsxzInfo tbYsxzInfo) throws Exception
	{
		tbYsxzInfoMapper.updateTbYsxzInfo(tbYsxzInfo);
	}

	@Override
	public void deleteTbYsxzInfo(String xzdm) throws Exception
	{
		tbYsxzInfoMapper.deleteTbYsxzInfo(xzdm);
	}

	@Override
	public PageDataBunder listTbYsxzInfo(TbYsxzInfo paramBean,Page page) throws Exception
	{
		return tbYsxzInfoMapper.listTbYsxzInfo(paramBean,page);
	}

	@Override
	public List<SelectBean> listAllValidYsxzSelect() throws Exception
	{
		List<TbYsxzInfo> tbYsxzInfoList = tbYsxzInfoMapper.listAllValidYsxz();
		return EFSUtil.convertBeanToSelectBean(tbYsxzInfoList,"xzdm","xzmc");
	}
}
