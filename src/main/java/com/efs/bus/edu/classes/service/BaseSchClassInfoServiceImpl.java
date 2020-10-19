package com.efs.bus.edu.classes.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.efs.bus.edu.semcal.mapper.BaseSemesterCal;
import com.efs.bus.edu.semcal.mapper.BaseSemesterCalMapper;
import com.efs.bus.util.BusUtil;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.efs.bus.edu.classes.mapper.BaseSchClassInfoMapper;
import com.efs.bus.edu.classes.mapper.BaseSchClassInfo;
import com.efs.common.database.Page;
import com.efs.common.database.PageDataBunder;

@Service("baseSchClassInfoService")
public class BaseSchClassInfoServiceImpl implements BaseSchClassInfoService
{
	@Resource(name="baseSchClassInfoMapper")
	private BaseSchClassInfoMapper baseSchClassInfoMapper;

	@Resource(name="baseSemesterCalMapper")
	private BaseSemesterCalMapper baseSemesterCalMapper;
	
	@Override
	public BaseSchClassInfo getBaseSchClassInfo(String scId) throws Exception
	{
		return baseSchClassInfoMapper.getBaseSchClassInfo(scId);
	}

	@Override
	public void addBaseSchClassInfo(BaseSchClassInfo baseSchClassInfo) throws Exception
	{
		baseSchClassInfoMapper.addBaseSchClassInfo(baseSchClassInfo);
	}

	@Override
	public void updateBaseSchClassInfo(BaseSchClassInfo baseSchClassInfo) throws Exception
	{
		baseSchClassInfoMapper.updateBaseSchClassInfo(baseSchClassInfo);
	}

	@Override
	public void deleteBaseSchClassInfo(String scId) throws Exception
	{
		baseSchClassInfoMapper.deleteBaseSchClassInfo(scId);
	}

	@Override
	public PageDataBunder listBaseSchClassInfo(BaseSchClassInfo paramBean,Page page) throws Exception
	{
		return baseSchClassInfoMapper.listBaseSchClassInfo(paramBean,page);
	}

	/**
	 * 批量产生班级信息
	 *
	 * @param scTerm
	 * @param gradeCnt
	 * @param clsCnt
	 * @throws Exception
	 */
	@Override
	public void batchAddClasses(String scTerm, int gradeCnt, int clsCnt,String userId) throws Exception
	{
		baseSchClassInfoMapper.batchAddClasses(scTerm, gradeCnt, clsCnt,userId);
	}

	/**
	 * 检查班级班主任是否已经重复
	 *
	 * @param paramBean
	 * @return
	 * @throws Exception
	 */
	@Override
	public boolean checkClassLeaderExist(BaseSchClassInfo paramBean) throws Exception
	{
		return baseSchClassInfoMapper.checkClassLeaderExist(paramBean);
	}

	/**
	 * 校验是否可以删除班级信息
	 *
	 * @param scId
	 * @return
	 * @throws Exception
	 */
	@Override
	public boolean checkCanDelClass(String scId) throws Exception
	{
		BaseSchClassInfo classInfo = baseSchClassInfoMapper.getBaseSchClassInfo(scId);
		BaseSemesterCal cal = baseSemesterCalMapper.getBaseSemesterCal(classInfo.getScTerm());

		int res = BusUtil.getCurSemCal(cal);

		//如果当前学期已经是历史学期
		if(res == 1)
		{
			return false;
		}
		else
		{
			return true;
		}
	}

	/**
	 * 查询班级信息，不带分页
	 *
	 * @param paramBean
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<BaseSchClassInfo> listBaseSchClassInfoNoPage(BaseSchClassInfo paramBean) throws Exception
	{
		return baseSchClassInfoMapper.listBaseSchClassInfoNoPage(paramBean);
	}

	/**
	 * 获取班级表中的最近的学期
	 *
	 * @return
	 * @throws Exception
	 */
	@Override
	public String getLastTerm() throws Exception
	{
		return baseSchClassInfoMapper.getLastTerm();
	}

	/**
	 * 检查老师是否是某个班的班主任
	 *
	 * @param scTerm
	 * @param scClass
	 * @param leaderId
	 * @return
	 * @throws Exception
	 */
	@Override
	public boolean checkUserIsClassLeader(String scTerm, String scClass, String leaderId) throws Exception
	{
		Integer res = baseSchClassInfoMapper.checkUserIsClassLeader(scTerm, scClass, leaderId);
		return res > 0;
	}
}
