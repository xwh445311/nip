package com.efs.bus.edu.course.service;

import com.efs.bus.edu.course.mapper.BaseSchScoreInfo;
import com.efs.bus.edu.course.mapper.BaseSchScoreInfoMapper;
import com.efs.common.database.Page;
import com.efs.common.database.PageDataBunder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("baseSchScoreInfoService")
public class BaseSchScoreInfoServiceImpl implements BaseSchScoreInfoService
{
	@Resource(name="baseSchScoreInfoMapper")
	private BaseSchScoreInfoMapper baseSchScoreInfoMapper;
	
	@Override
	public BaseSchScoreInfo getBaseSchScoreInfo(String ssId) throws Exception
	{
		return baseSchScoreInfoMapper.getBaseSchScoreInfo(ssId);
	}

	@Override
	public void addBaseSchScoreInfo(BaseSchScoreInfo baseSchScoreInfo) throws Exception
	{
		baseSchScoreInfoMapper.addBaseSchScoreInfo(baseSchScoreInfo);
	}

	@Override
	public void updateBaseSchScoreInfo(BaseSchScoreInfo baseSchScoreInfo) throws Exception
	{
		baseSchScoreInfoMapper.updateBaseSchScoreInfo(baseSchScoreInfo);
	}

	@Override
	public void deleteBaseSchScoreInfo(String ssId) throws Exception
	{
		baseSchScoreInfoMapper.deleteBaseSchScoreInfo(ssId);
	}

	@Override
	public PageDataBunder listBaseSchScoreInfo(BaseSchScoreInfo paramBean,Page page) throws Exception
	{
		return baseSchScoreInfoMapper.listBaseSchScoreInfo(paramBean,page);
	}

	/**
	 * 批量拷贝某学期、某班的课程安排
	 *
	 * @param paramBean
	 * @throws Exception
	 */
	@Override
	public void copyBaseSchScoreInfo(BaseSchScoreInfo paramBean) throws Exception
	{
		baseSchScoreInfoMapper.copyBaseSchScoreInfo(paramBean);
	}

	/**
	 * 检查指定的学期或班级是否已经安排了课程
	 *
	 * @param ssTerm
	 * @param ssClass
	 * @return
	 * @throws Exception
	 */
	@Override
	public boolean checkTermHasCourse(String ssTerm, String ssClass) throws Exception
	{
		return baseSchScoreInfoMapper.getTermHasCourse(ssTerm, ssClass) > 0;
	}
}
