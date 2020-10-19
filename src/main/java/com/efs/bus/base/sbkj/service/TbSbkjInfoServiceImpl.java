package com.efs.bus.base.sbkj.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.efs.bus.base.sbkj.mapper.TbSbkjInfoMapper;
import com.efs.bus.base.sbkj.mapper.TbSbkjInfo;

import com.efs.common.database.Page;
import com.efs.common.database.PageDataBunder;
import com.xwh.bean.SelectBean;
import com.xwh.util.EFSUtil;
import org.springframework.stereotype.Service;

@Service("tbSbkjInfoService")
public class TbSbkjInfoServiceImpl implements TbSbkjInfoService
{
	@Resource(name="tbSbkjInfoMapper")
	private TbSbkjInfoMapper tbSbkjInfoMapper;
	
	@Override
	public TbSbkjInfo getTbSbkjInfo(String sbkj) throws Exception
	{
		return tbSbkjInfoMapper.getTbSbkjInfo(sbkj);
	}

	@Override
	public void addTbSbkjInfo(TbSbkjInfo tbSbkjInfo) throws Exception
	{
		tbSbkjInfoMapper.addTbSbkjInfo(tbSbkjInfo);
	}

	@Override
	public void updateTbSbkjInfo(TbSbkjInfo tbSbkjInfo) throws Exception
	{
		tbSbkjInfoMapper.updateTbSbkjInfo(tbSbkjInfo);
	}

	@Override
	public void deleteTbSbkjInfo(String sbkj) throws Exception
	{
		tbSbkjInfoMapper.deleteTbSbkjInfo(sbkj);
	}

	@Override
	public PageDataBunder listTbSbkjInfo(TbSbkjInfo paramBean,Page page) throws Exception
	{
		return tbSbkjInfoMapper.listTbSbkjInfo(paramBean,page);
	}

	@Override
	public List<SelectBean> listAllSbkjSelectBean() throws Exception
	{

		return EFSUtil.convertBeanToSelectBean(tbSbkjInfoMapper.listAllValidSbkj(),"sbkj","sbkj");
	}
}
