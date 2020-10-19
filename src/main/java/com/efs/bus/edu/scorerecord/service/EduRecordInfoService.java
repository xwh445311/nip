package com.efs.bus.edu.scorerecord.service;

import com.efs.bus.edu.scorestatic.mapper.EduClassStaticInfo;
import com.efs.bus.edu.scorestatic.mapper.EduClassStaticResult;
import com.efs.common.database.Page;
import com.efs.common.database.PageDataBunder;
import com.efs.bus.edu.scorerecord.mapper.EduRecordInfo;
import org.apache.poi.ss.usermodel.Workbook;

import java.util.List;
import java.util.Map;

/**
 * 
 * com.efs.bus.edu.scorerecord.mapper.EduRecordInfoService
 * @author xuwh
 * 2018-05-04 23:25:56
 * 学生学习成绩信息表
 *
 */
public interface EduRecordInfoService
{
	/**
	 * 根据主键ID获取EduRecordInfo
	 * @param dbId
	 * @return
	 */
	public EduRecordInfo getEduRecordInfo(String riId) throws Exception;
	
	/**
	 * 增加EduRecordInfo
	 * @param eduRecordInfo
	 */
	public void addEduRecordInfoPerClass(List<EduRecordInfo> eduRecordInfoList,EduRecordInfo paramBean) throws Exception;
	
	/**
	 * 更新EduRecordInfo
	 * @param empBean
	 */
	public void updateEduRecordInfo(EduRecordInfo eduRecordInfo) throws Exception;
	
	/**
	 * 删除EduRecordInfo
	 * @param dbId
	 */
	public void deleteEduRecordInfo(String riId) throws Exception;
	
	
	/**
	 * 列举员工信息，带分页
	 * @param EduRecordInfo
	 * @return
	 */
	public PageDataBunder listEduRecordInfo(EduRecordInfo paramBean, Page page) throws Exception;

	/**
	 * 根据用户选择的信息生成成绩上传模板
	 * @param paramBean
	 * @return
	 * @throws Exception
	 */
	String getRecoredModel(EduRecordInfo paramBean) throws Exception;

    /**
     * 查询指定学期，期中/期末，班级的是否已经上传过成绩
     * @param paramBean
     * @return
     * @throws Exception
     */
    boolean checkRepeatRecored(EduRecordInfo paramBean) throws Exception;

	/**
	 * 获取最近的学期和期中期末
	 * @return
	 * @throws Exception
	 */
	EduRecordInfo getMaxTermAndMid() throws Exception;

	/**
	 * 查询班级统计信息
	 *
	 * @param paramBean
	 * @return
	 * @throws Exception
	 */
	List<EduClassStaticResult> listClassStatics(EduRecordInfo paramBean) throws Exception;

	/**
	 * 查询页面上显示的班级统计信息
	 * @param EduClassStaticInfo
	 * @return
	 */
	PageDataBunder listEduClassStaticInfo(EduClassStaticInfo paramBean, Page page) throws Exception;

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
	List<Map<String,Object>> getStudentScoreRecord(String stuId) throws Exception;

	/**
	 * 查询学生记录信息
	 * @param paramBean
	 * @param page
	 * @return
	 * @throws Exception
	 */
	PageDataBunder listStudentRecordInfo(EduRecordInfo paramBean, Page page) throws Exception;

	/**
	 * 下载班级成绩统计
	 * @param paramBean
	 * @return
	 * @throws Exception
	 */
	String downloadClassRecord(EduRecordInfo paramBean) throws Exception;

	/**
	 * 下载学校成绩统计表
	 * @param paramBean
	 * @return
	 * @throws Exception
	 */
	String downloadSchoolStatic(EduRecordInfo paramBean) throws Exception;
}
