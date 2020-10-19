package com.efs.common.sysparam.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.efs.common.sysparam.mapper.TsParamInfoMapper;
import com.efs.common.sysparam.mapper.TsParamInfo;

import com.efs.common.database.Page;
import com.efs.common.database.PageDataBunder;
import com.xwh.bean.SelectBean;
import com.xwh.util.EFSUtil;
import org.springframework.stereotype.Service;

@Service("tsParamInfoService")
public class TsParamInfoServiceImpl implements TsParamInfoService
{
	@Resource(name="tsParamInfoMapper")
	private TsParamInfoMapper tsParamInfoMapper;
	
	@Override
	public TsParamInfo getTsParamInfo(String dbId) throws Exception
	{
		return tsParamInfoMapper.getTsParamInfo(dbId);
	}

	@Override
	public void addTsParamInfo(TsParamInfo tsParamInfo) throws Exception
	{
		tsParamInfoMapper.addTsParamInfo(tsParamInfo);
	}

	@Override
	public void updateTsParamInfo(TsParamInfo tsParamInfo) throws Exception
	{
		tsParamInfoMapper.updateTsParamInfo(tsParamInfo);
	}

	@Override
	public void deleteTsParamInfo(String dbId) throws Exception
	{
		tsParamInfoMapper.deleteTsParamInfo(dbId);
	}

	@Override
	public PageDataBunder listTsParamInfo(TsParamInfo paramBean,Page page) throws Exception
	{
		return tsParamInfoMapper.listTsParamInfo(paramBean,page);
	}

	@Override
	public List<TsParamInfo> listTsParamByType(String type)
	{
		return tsParamInfoMapper.listTsParamByType(type);
	}

	@Override
	public String getTsParamValue(TsParamInfo tsParamInfo)
	{
		return tsParamInfoMapper.getTsParamValue(tsParamInfo);
	}

	@Override
	public List<SelectBean> listTsParamSelectType(String type) throws Exception
	{
		return EFSUtil.convertBeanToSelectBean(tsParamInfoMapper.listTsParamByType(type),"paKey","paValue");
	}
}
