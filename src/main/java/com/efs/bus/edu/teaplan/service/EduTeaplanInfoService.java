package com.efs.bus.edu.teaplan.service;

import com.efs.common.database.Page;
import com.efs.common.database.PageDataBunder;
import com.efs.bus.edu.teaplan.mapper.EduTeaplanInfo;

import java.util.List;

/**
 * 
 * com.efs.bus.edu.teaplan.mapper.EduTeaplanInfoService
 * @author xwh
 * 2018-05-22 14:25:16
 * 教案检查信息表
 *
 */
public interface EduTeaplanInfoService
{
	/**
	 * 根据主键ID获取EduTeaplanInfo
	 * @param dbId
	 * @return
	 */
	public EduTeaplanInfo getEduTeaplanInfo(String tiDbId) throws Exception;
	
	/**
	 * 增加EduTeaplanInfo
	 * @param eduTeaplanInfo
	 */
	public void addEduTeaplanInfo(EduTeaplanInfo eduTeaplanInfo) throws Exception;
	
	/**
	 * 更新EduTeaplanInfo
	 * @param empBean
	 */
	public void updateEduTeaplanInfo(EduTeaplanInfo eduTeaplanInfo) throws Exception;
	
	/**
	 * 删除EduTeaplanInfo
	 * @param dbId
	 */
	public void deleteEduTeaplanInfo(String tiDbId) throws Exception;
	
	
	/**
	 * 列举员工信息，带分页
	 * @param EduTeaplanInfo
	 * @return
	 */
	public PageDataBunder listEduTeaplanInfo(EduTeaplanInfo paramBean, Page page) throws Exception;

	/**
	 * 查询发布记录列表
	 * @param paramBean
	 * @param page
	 * @return
	 * @throws Exception
	 */
	PageDataBunder listIssueInfo(EduTeaplanInfo paramBean,Page page) throws Exception;

	/**
	 * 获得下一个批次号
	 * @return
	 * @throws Exception
	 */
	String getNextBatchId() throws Exception;

	/**
	 * 批次删除教案信息
	 * @param tiBatchId
	 * @throws Exception
	 */
	void deleteBatchTeaplan(String tiBatchId) throws Exception;

	/**
	 * 提交教案信息
	 * @param eduTeaplanInfo
	 * @throws Exception
	 */
	void addSubmitTeaplan(EduTeaplanInfo eduTeaplanInfo) throws Exception;

	/**
	 * 评定教案
	 * @param eduTeaplanInfo
	 * @throws Exception
	 */
	void addEvalTeaplan(EduTeaplanInfo eduTeaplanInfo) throws Exception;

	/**
	 * 查找某个批次的各个状态的教师信息
	 * @param tiBatchId
	 * @param tiStatus
	 * @return
	 * @throws Exception
	 */
	List<EduTeaplanInfo> listStatusTeacher(String tiBatchId, String tiStatus) throws Exception;

	/**
	 * 查询所有批次信息
	 * @return
	 * @throws Exception
	 */
	List<String> listBatchids() throws Exception;
}
