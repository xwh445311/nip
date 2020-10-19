package com.efs.bus.edu.baseset.service;

import com.efs.bus.edu.baseset.mapper.BaseSetInfo;
import com.efs.bus.edu.baseset.mapper.BaseSetInfoMapper;
import com.efs.common.database.Page;
import com.efs.common.database.PageDataBunder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("baseSetInfoService")
public class BaseSetInfoServiceImpl implements BaseSetInfoService
{
	@Resource(name="baseSetInfoMapper")
	private BaseSetInfoMapper baseSetInfoMapper;
	
	@Override
	public BaseSetInfo getBaseSetInfo(String bsTerm) throws Exception
	{
		return baseSetInfoMapper.getBaseSetInfo(bsTerm);
	}

	@Override
	public void addBaseSetInfo(BaseSetInfo baseSetInfo) throws Exception
	{
		//调用后台更新信息
		String res = baseSetInfoMapper.updateBaseSetInfo(baseSetInfo);
		if("1".equals(res))
		{
			throw new RuntimeException("初始化错误，该学期的信息已经初始化过了，不能重复初始化");
		}

		baseSetInfoMapper.addBaseSetInfo(baseSetInfo);
	}

	@Override
	public String updateBaseSetInfo(BaseSetInfo baseSetInfo) throws Exception
	{
		return baseSetInfoMapper.updateBaseSetInfo(baseSetInfo);
	}

	@Override
	public void deleteBaseSetInfo(String bsTerm) throws Exception
	{
		baseSetInfoMapper.deleteBaseSetInfo(bsTerm);
	}

	@Override
	public PageDataBunder listBaseSetInfo(BaseSetInfo paramBean,Page page) throws Exception
	{
		return baseSetInfoMapper.listBaseSetInfo(paramBean,page);
	}

	/**
	 * 检查基础信息是否已经设置过，TRUE表示已经设置，FALSE表示未设置
	 *
	 * @param bsTerm
	 * @return
	 * @throws Exception
	 */
	@Override
	public boolean checkHasBaseSet(String bsTerm) throws Exception
	{
		return baseSetInfoMapper.checkHasBaseSet(bsTerm);
	}
}
