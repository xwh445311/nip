package com.efs.bus.edu.course.service;

import com.efs.bus.edu.course.mapper.BaseSchScoreInfo;
import com.efs.common.database.Page;
import com.efs.common.database.PageDataBunder;

/**
 * 
 * com.efs.bus.edu.course.mapper.BaseSchScoreInfoService
 * @author xwh
 * 2018-05-03 15:47:43
 * 学校学期内开课信息表
 *
 */
public interface BaseSchScoreInfoService
{
	/**
	 * 根据主键ID获取BaseSchScoreInfo
	 * @param dbId
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
	 * @param dbId
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
	boolean checkTermHasCourse(String ssTerm,String ssClass) throws Exception;
	
}
