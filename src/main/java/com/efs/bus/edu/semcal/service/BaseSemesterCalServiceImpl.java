package com.efs.bus.edu.semcal.service;

import com.efs.bus.edu.semcal.mapper.BaseSemesterCal;
import com.efs.bus.edu.semcal.mapper.BaseSemesterCalMapper;
import com.efs.common.database.Page;
import com.efs.common.database.PageDataBunder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("baseSemesterCalService")
public class BaseSemesterCalServiceImpl implements BaseSemesterCalService
{
	@Resource(name="baseSemesterCalMapper")
	private BaseSemesterCalMapper baseSemesterCalMapper;
	
	@Override
	public BaseSemesterCal getBaseSemesterCal(String scTerm) throws Exception
	{
		return baseSemesterCalMapper.getBaseSemesterCal(scTerm);
	}

	@Override
	public void addBaseSemesterCal(BaseSemesterCal baseSemesterCal) throws Exception
	{
		baseSemesterCalMapper.addBaseSemesterCal(baseSemesterCal);
	}

	@Override
	public void updateBaseSemesterCal(BaseSemesterCal baseSemesterCal) throws Exception
	{
		baseSemesterCalMapper.updateBaseSemesterCal(baseSemesterCal);
	}

	@Override
	public void deleteBaseSemesterCal(String scTerm) throws Exception
	{
		baseSemesterCalMapper.deleteBaseSemesterCal(scTerm);
	}

	@Override
	public PageDataBunder listBaseSemesterCal(BaseSemesterCal paramBean,Page page) throws Exception
	{
		return baseSemesterCalMapper.listBaseSemesterCal(paramBean,page);
	}

	/**
	 * 查询学期列表（不含分页)
	 *
	 * @param paramBean
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<BaseSemesterCal> listBaseSemesterCalNoPage(BaseSemesterCal paramBean) throws Exception
	{
		return baseSemesterCalMapper.listBaseSemesterCalNoPage(paramBean);
	}

	/**
	 * 获取当前学期
	 *
	 * @return
	 * @throws Exception
	 */
	@Override
	public BaseSemesterCal getCurrentSemester() throws Exception
	{
		return baseSemesterCalMapper.getCurrentSemester();
	}
}
