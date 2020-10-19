package com.efs.bus.edu.classes.service;

import java.util.List;
import java.util.Map;

import com.efs.common.database.Page;
import com.efs.common.database.PageDataBunder;
import com.efs.bus.edu.classes.mapper.BaseSchClassInfo;

/**
 * 
 * com.efs.bus.edu.classes.mapper.BaseSchClassInfoService
 * @author xwh
 * 2018-04-26 20:43:12
 * 学校班级设置信息表
 *
 */
public interface BaseSchClassInfoService
{
	/**
	 * 根据主键ID获取BaseSchClassInfo
	 * @param dbId
	 * @return
	 */
	public BaseSchClassInfo getBaseSchClassInfo(String scId) throws Exception;
	
	/**
	 * 增加BaseSchClassInfo
	 * @param baseSchClassInfo
	 */
	public void addBaseSchClassInfo(BaseSchClassInfo baseSchClassInfo) throws Exception;
	
	/**
	 * 更新BaseSchClassInfo
	 * @param empBean
	 */
	public void updateBaseSchClassInfo(BaseSchClassInfo baseSchClassInfo) throws Exception;
	
	/**
	 * 删除BaseSchClassInfo
	 * @param dbId
	 */
	public void deleteBaseSchClassInfo(String scId) throws Exception;
	
	
	/**
	 * 列举员工信息，带分页
	 * @param BaseSchClassInfo
	 * @return
	 */
	public PageDataBunder listBaseSchClassInfo(BaseSchClassInfo paramBean, Page page) throws Exception;

	/**
	 * 批量产生班级信息
	 * @param scTerm
	 * @param gradeCnt
	 * @param clsCnt
	 * @throws Exception
	 */
	void batchAddClasses(String scTerm, int gradeCnt, int clsCnt,String userId) throws Exception;

	/**
	 * 检查班级班主任是否已经重复
	 * @param paramBean
	 * @return
	 * @throws Exception
	 */
	boolean checkClassLeaderExist(BaseSchClassInfo paramBean) throws Exception;

	/**
	 * 校验是否可以删除班级信息
	 * @param scId
	 * @return
	 * @throws Exception
	 */
	boolean checkCanDelClass(String scId) throws Exception;

	/**
	 * 查询班级信息，不带分页
	 * @param paramBean
	 * @return
	 * @throws Exception
	 */
	List<BaseSchClassInfo> listBaseSchClassInfoNoPage(BaseSchClassInfo paramBean) throws Exception;

	/**
	 * 获取班级表中的最近的学期
	 * @return
	 * @throws Exception
	 */
	String getLastTerm() throws Exception;

	/**
	 * 检查老师是否是某个班的班主任
	 * @param scTerm
	 * @param scClass
	 * @param leaderId
	 * @return
	 * @throws Exception
	 */
	boolean checkUserIsClassLeader(String scTerm,String scClass,String leaderId) throws Exception;
	
}
