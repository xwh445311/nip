package com.efs.bus.edu.semcal.mapper;

import java.util.List;
import java.util.Map;

import com.efs.common.database.Page;
import com.efs.common.database.PageDataBunder;


/**
 * 
 * com.efs.bus.edu.semcal.mapper.BaseSemesterCalMapper
 * @author xwh
 * 2018-04-24 17:16:20
 * 学期日历
 *
 */
public interface BaseSemesterCalMapper
{
	/**
	 * 根据主键ID获取BaseSemesterCal
	 * @param scTerm
	 * @return
	 */
	public BaseSemesterCal getBaseSemesterCal(String scTerm) throws Exception;
	
	/**
	 * 增加BaseSemesterCal
	 * @param baseSemesterCal
	 */
	public void addBaseSemesterCal(BaseSemesterCal baseSemesterCal) throws Exception;
	
	/**
	 * 更新BaseSemesterCal
	 * @param empBean
	 */
	public void updateBaseSemesterCal(BaseSemesterCal baseSemesterCal) throws Exception;
	
	/**
	 * 删除BaseSemesterCal
	 * @param scTerm
	 */
	public void deleteBaseSemesterCal(String scTerm) throws Exception;
	
	
	/**
	 * 列举员工信息，带分页
	 * @param BaseSemesterCal
	 * @return
	 */
	public PageDataBunder listBaseSemesterCal(BaseSemesterCal paramBean, Page page) throws Exception;

	/**
	 *  查询学期列表（不含分页)
	 * @param paramBean
	 * @return
	 * @throws Exception
	 */
	List<BaseSemesterCal> listBaseSemesterCalNoPage(BaseSemesterCal paramBean) throws Exception;

    /**
     * 获取当前学期
     * @return
     * @throws Exception
     */
	BaseSemesterCal getCurrentSemester() throws Exception;
	
}
