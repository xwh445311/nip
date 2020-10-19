package com.efs.common.sysparam.service;

import com.efs.common.database.Page;
import com.efs.common.database.PageDataBunder;
import com.efs.common.sysparam.mapper.TsParamInfo;
import com.xwh.bean.SelectBean;

import java.util.List;

/**
 * 
 * com.efs.common.sysparam.mapper.TsParamInfoService
 * @author xuwh
 * 2020-08-13 22:47:02
 * 
 *
 */
public interface TsParamInfoService
{
	/**
	 * 根据主键ID获取TsParamInfo
	 * @param dbId
	 * @return
	 */
	public TsParamInfo getTsParamInfo(String dbId) throws Exception;
	
	/**
	 * 增加TsParamInfo
	 * @param tsParamInfo
	 */
	public void addTsParamInfo(TsParamInfo tsParamInfo) throws Exception;
	
	/**
	 * 更新TsParamInfo
	 * @param empBean
	 */
	public void updateTsParamInfo(TsParamInfo tsParamInfo) throws Exception;
	
	/**
	 * 删除TsParamInfo
	 * @param dbId
	 */
	public void deleteTsParamInfo(String dbId) throws Exception;
	
	
	/**
	 * 列举员工信息，带分页
	 * @param TsParamInfo
	 * @return
	 */
	public PageDataBunder listTsParamInfo(TsParamInfo paramBean,Page page) throws Exception;

	/**
	 * 根据类型查询参数列表
	 * @param type
	 * @return
	 * @throws Exception
	 */
	public List<TsParamInfo> listTsParamByType(String type);

	/**
	 * 根据类别和KEY查询参数值
	 * @param tsParamInfo
	 * @return
	 */
	public String getTsParamValue(TsParamInfo tsParamInfo);

	/**
	 * 根据类型查询下拉参数列表
	 * @param type
	 * @return
	 */
	public List<SelectBean> listTsParamSelectType(String type) throws Exception;
	
}
