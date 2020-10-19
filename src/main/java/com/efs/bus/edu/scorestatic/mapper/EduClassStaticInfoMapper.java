package com.efs.bus.edu.scorestatic.mapper;

import com.efs.common.database.Page;
import com.efs.common.database.PageDataBunder;

import java.util.List;


/**
 * 
 * com.efs.bus.edu.scorestatic.mapper.EduClassStaticInfoMapper
 * @author xuwh
 * 2018-05-12 21:06:11
 * 班级成绩统计表
 *
 */
public interface EduClassStaticInfoMapper
{
	/**
	 * 根据主键ID获取EduClassStaticInfo
	 * @param csTerm
	 * @return
	 */
	public EduClassStaticInfo getEduClassStaticInfo(String csTerm) throws Exception;
	
	/**
	 * 增加EduClassStaticInfo
	 * @param eduClassStaticInfo
	 */
	public void addEduClassStaticInfo(EduClassStaticInfo eduClassStaticInfo) throws Exception;
	
	/**
	 * 更新EduClassStaticInfo
	 * @param empBean
	 */
	public void updateEduClassStaticInfo(EduClassStaticInfo eduClassStaticInfo) throws Exception;
	
	/**
	 * 删除EduClassStaticInfo
	 * @param csTerm
	 */
	public void deleteEduClassStaticInfo(String csTerm) throws Exception;
	
	
	/**
	 * 列举员工信息，带分页
	 * @param EduClassStaticInfo
	 * @return
	 */
	public PageDataBunder listEduClassStaticInfo(EduClassStaticInfo paramBean,Page page) throws Exception;

	/**
	 * 获取班级的分数统计结果
	 * @param paramBean
	 * @return
	 * @throws Exception
	 */
	EduClassStaticResult getClassStaticResult(EduClassStaticResult paramBean) throws Exception;

	/**
	 * 查询学校成绩统计报表
	 * @param paramBean
	 * @return
	 * @throws Exception
	 */
	List<EduClassStaticInfo> listSchoolStatic(EduClassStaticInfo paramBean) throws Exception;
}
