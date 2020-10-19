package com.efs.bus.edu.course.mapper;

import com.efs.common.database.Page;
import com.efs.common.database.PageDataBunder;

import java.util.List;


/**
 * 
 * com.efs.bus.edu.course.mapper.BaseSchScoreInfoMapper
 * @author xwh
 * 2018-05-03 15:47:43
 * 学校学期内开课信息表
 *
 */
public interface BaseSchScoreInfoMapper
{
	/**
	 * 根据主键ID获取BaseSchScoreInfo
	 * @param ssId
	 * @return
	 */
	public BaseSchScoreInfo getBaseSchScoreInfo(String ssId) throws Exception;
	
	/**
	 * 增加BaseSchScoreInfo
	 * @param baseSchScoreInfo
	 */
	public void addBaseSchScoreInfo(BaseSchScoreInfo baseSchScoreInfo) throws Exception;
	
	/**
	 * 更新BaseSchScoreInfo
	 * @param empBean
	 */
	public void updateBaseSchScoreInfo(BaseSchScoreInfo baseSchScoreInfo) throws Exception;
	
	/**
	 * 删除BaseSchScoreInfo
	 * @param ssId
	 */
	public void deleteBaseSchScoreInfo(String ssId) throws Exception;
	
	
	/**
	 * 列举员工信息，带分页
	 * @param BaseSchScoreInfo
	 * @return
	 */
	public PageDataBunder listBaseSchScoreInfo(BaseSchScoreInfo paramBean, Page page) throws Exception;

	/**
	 * 批量拷贝某学期、某班的课程安排
	 * @param paramBean
	 * @throws Exception
	 */
	public void copyBaseSchScoreInfo(BaseSchScoreInfo paramBean) throws Exception;

	/**
	 * 检查指定的学期或班级是否已经安排了课程
	 * @param ssTerm
	 * @param ssClass
	 * @return
	 * @throws Exception
	 */
	public int getTermHasCourse(String ssTerm,String ssClass) throws Exception;

	/**
	 * 获得某个教师指定学期有课的所有班级
	 * @param ssTerm
	 * @param teacherId
	 * @return
	 * @throws Exception
	 */
	List<String> listTeacherHasCourClass(String ssTerm,String teacherId) throws Exception;

	/**
	 * 查询某学期各班的的参加考试的列表
	 * @param ssTerm
	 * @param ssClass
	 * @return
	 * @throws Exception
	 */
	List<BaseSchScoreInfo> listTermClassCourForTest(String ssTerm,String ssClass) throws Exception;

	/**
	 * 查询课程 信息－不带分页
	 * @param paramBean
	 * @return
	 * @throws Exception
	 */
	List<BaseSchScoreInfo> listBaseSchScoreInfoNoPage(BaseSchScoreInfo paramBean) throws Exception;
}
