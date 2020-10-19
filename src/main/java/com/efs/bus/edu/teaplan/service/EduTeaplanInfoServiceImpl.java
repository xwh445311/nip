package com.efs.bus.edu.teaplan.service;

import com.efs.bus.edu.course.mapper.BaseSchScoreInfo;
import com.efs.bus.edu.course.mapper.BaseSchScoreInfoMapper;
import com.efs.bus.edu.semcal.mapper.BaseSemesterCal;
import com.efs.bus.edu.semcal.mapper.BaseSemesterCalMapper;
import com.efs.bus.edu.teaplan.mapper.EduTeaplanInfo;
import com.efs.bus.edu.teaplan.mapper.EduTeaplanInfoMapper;
import com.efs.common.database.Page;
import com.efs.common.database.PageDataBunder;
import com.xwh.util.EFSUtil;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service("eduTeaplanInfoService")
public class EduTeaplanInfoServiceImpl implements EduTeaplanInfoService
{
	@Resource(name="eduTeaplanInfoMapper")
	private EduTeaplanInfoMapper eduTeaplanInfoMapper;

	@Resource(name="baseSemesterCalMapper")
	private BaseSemesterCalMapper baseSemesterCalMapper;

	@Resource(name="baseSchScoreInfoMapper")
	private BaseSchScoreInfoMapper baseSchScoreInfoMapper;
	
	@Override
	public EduTeaplanInfo getEduTeaplanInfo(String tiDbId) throws Exception
	{
		return eduTeaplanInfoMapper.getEduTeaplanInfo(tiDbId);
	}

	@Override
	public void addEduTeaplanInfo(EduTeaplanInfo eduTeaplanInfo) throws Exception
	{
		List<EduTeaplanInfo> dataList = new ArrayList<>();
		EduTeaplanInfo data;

		//获得批次号
		String batchId = getNextBatchId();

		//产生需要哪些老师提交
		BaseSchScoreInfo param = new BaseSchScoreInfo();
		param.setSsTerm(eduTeaplanInfo.getTiTerm());
		param.setSsScore(eduTeaplanInfo.getTiCourCode());
		List<BaseSchScoreInfo> scoreInfoList = baseSchScoreInfoMapper.listBaseSchScoreInfoNoPage(param);

		if(CollectionUtils.isNotEmpty(scoreInfoList))
		{
			for (BaseSchScoreInfo score : scoreInfoList)
			{
				data = new EduTeaplanInfo();
				data.setTiBatchId(batchId);
				data.setTiTerm(eduTeaplanInfo.getTiTerm());
				data.setTiClass(score.getSsClass());
				data.setTiCourCode(score.getSsScore());
				data.setTiCheckedUser(score.getSsTeacher());
				data.setTiStatus("0");
				data.setTiEndDate(eduTeaplanInfo.getTiEndDate());
				data.setTiIssueCommon(eduTeaplanInfo.getTiIssueCommon());

				data.setTiIssueDate(EFSUtil.getSysFormatDate());
				data.setTiIssueTime(EFSUtil.getSysFormatTime());
				data.setTiIssueUser(eduTeaplanInfo.getTiIssueUser());

				dataList.add(data);
			}

			eduTeaplanInfoMapper.addEduTeaplanInfo(dataList);
		}
	}

	@Override
	public void updateEduTeaplanInfo(EduTeaplanInfo eduTeaplanInfo) throws Exception
	{
		eduTeaplanInfoMapper.updateEduTeaplanInfo(eduTeaplanInfo);
	}

	@Override
	public void deleteEduTeaplanInfo(String tiDbId) throws Exception
	{
		eduTeaplanInfoMapper.deleteEduTeaplanInfo(tiDbId);
	}

	@Override
	public PageDataBunder listEduTeaplanInfo(EduTeaplanInfo paramBean,Page page) throws Exception
	{
		return eduTeaplanInfoMapper.listEduTeaplanInfo(paramBean,page);
	}

	/**
	 * 查询发布记录列表
	 *
	 * @param paramBean
	 * @param page
	 * @return
	 * @throws Exception
	 */
	@Override
	public PageDataBunder listIssueInfo(EduTeaplanInfo paramBean, Page page) throws Exception
	{
		return eduTeaplanInfoMapper.listIssueInfo(paramBean,page);
	}

	/**
	 * 获得下一个批次号
	 *
	 * @return
	 * @throws Exception
	 */
	@Override
	public String getNextBatchId() throws Exception
	{
		String maxBatchId = eduTeaplanInfoMapper.getMaxBatchId();
		String nextBatchId;
		if(StringUtils.isEmpty(maxBatchId))
		{
			BaseSemesterCal cal = baseSemesterCalMapper.getCurrentSemester();
			if(cal == null)
			{
				throw new RuntimeException("系统还未设置学期日历");
			}

			nextBatchId = cal.getScTerm() + "01";
		}
		else
		{
			int cur = Integer.parseInt(maxBatchId.substring(6));
			cur += 1;
			nextBatchId = maxBatchId.substring(0,6) + StringUtils.leftPad(cur+"",2,'0');
		}
		return nextBatchId;
	}

	/**
	 * 批次删除教案信息
	 *
	 * @param tiBatchId
	 * @throws Exception
	 */
	@Override
	public void deleteBatchTeaplan(String tiBatchId) throws Exception
	{
		eduTeaplanInfoMapper.deleteBatchTeaplan(tiBatchId);
	}

	/**
	 * 提交教案信息
	 *
	 * @param eduTeaplanInfo
	 * @throws Exception
	 */
	@Override
	public void addSubmitTeaplan(EduTeaplanInfo eduTeaplanInfo) throws Exception
	{
		eduTeaplanInfoMapper.addSubmitTeaplan(eduTeaplanInfo);
	}

	/**
	 * 评定教案
	 *
	 * @param eduTeaplanInfo
	 * @throws Exception
	 */
	@Override
	public void addEvalTeaplan(EduTeaplanInfo eduTeaplanInfo) throws Exception
	{
		eduTeaplanInfoMapper.addEvalTeaplan(eduTeaplanInfo);
	}

	/**
	 * 查找某个批次的各个状态的教师信息
	 *
	 * @param tiBatchId
	 * @param tiStatus
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<EduTeaplanInfo> listStatusTeacher(String tiBatchId, String tiStatus) throws Exception
	{
		return eduTeaplanInfoMapper.listStatusTeacher(tiBatchId, tiStatus);
	}

	/**
	 * 查询所有批次信息
	 *
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<String> listBatchids() throws Exception
	{
		return eduTeaplanInfoMapper.listBatchids();
	}
}
