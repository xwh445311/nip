package com.efs.bus.edu.scorerecord.mapper;

import com.efs.common.database.Page;
import com.efs.common.database.PageDataBunder;

import java.util.List;
import java.util.Map;


/**
 * 
 * com.efs.bus.edu.scorerecord.mapper.EduRecordInfoMapper
 * @author xuwh
 * 2018-05-04 23:25:56
 * 学生学习成绩信息表
 *
 */
public interface EduRecordInfoMapper
{
	/**
	 * 根据主键ID获取EduRecordInfo
	 * @param riId
	 * @return
	 */
	public EduRecordInfo getEduRecordInfo(String riId) throws Exception;
	
	/**
	 * 增加EduRecordInfo
	 * @param eduRecordInfo
	 */
	public void addEduRecordInfo(List<EduRecordInfo> eduRecordInfos,EduRecordInfo paramBean) throws Exception;
	
	/**
	 * 更新EduRecordInfo
	 * @param empBean
	 */
	public void updateEduRecordInfo(EduRecordInfo eduRecordInfo) throws Exception;
	
	/**
	 * 删除EduRecordInfo
	 * @param riId
	 */
	public void deleteEduRecordInfo(String riId) throws Exception;
	
	
	/**
	 * 列举员工信息，带分页
	 * @param EduRecordInfo
	 * @return
	 */
	public PageDataBunder listEduRecordInfo(EduRecordInfo paramBean, Page page) throws Exception;

	/**
	 * 查询指定学期，期中/期末，班级的是否已经上传过成绩
	 * @param paramBean
	 * @return
	 * @throws Exception
	 */
	int getRecordCount(EduRecordInfo paramBean) throws Exception;

	/**
	 * 根据条件删除某个班的成绩
	 * @param paramBean
	 * @throws Exception
	 */
	void deleteEduRecordFromCls(EduRecordInfo paramBean) throws Exception;

	/**
	 * 获取最近的学期和期中期末
	 * @return
	 * @throws Exception
	 */
	EduRecordInfo getMaxTermAndMid() throws Exception;

	/**
	 * 更新班主任评价
	 * @param paramBean
	 * @throws Exception
	 */
	void updateLeaderCommont(EduRecordInfo paramBean) throws Exception;

	/**
	 * 获取学生参加考试的场次信息
	 * @param stuId
	 * @return
	 * @throws Exception
	 */
	List<String> getStudentRecordTerm(String stuId) throws Exception;

	/**
	 * 获取学生某一门课程的历史班级排名信息
	 * @param stuId
	 * @param coursDbCol
	 * @return
	 * @throws Exception
	 */
	List<Integer> getStudentScoreRank(String stuId,String coursDbCol) throws Exception;

	/**
	 * 查询学生记录信息
	 * @param paramBean
	 * @param page
	 * @return
	 * @throws Exception
	 */
	PageDataBunder listStudentRecordInfo(EduRecordInfo paramBean, Page page) throws Exception;

	/**
	 * 查询供下载的班级成绩统计表
	 * @param paramBean
	 * @return
	 * @throws Exception
	 */
	List<EduRecordInfo> listDownClassRecord(EduRecordInfo paramBean) throws Exception;
}
