package com.efs.common.auth.org.mapper;

import com.efs.common.database.Page;
import com.efs.common.database.PageDataBunder;

import java.util.List;


/**
 * 
 * com.efs.common.auth.org.mapper.TsOrgInfoMapper
 * @author xwh
 * 2018-03-15 09:54:12
 * 组织机构信息表
 *
 */
public interface TsOrgInfoMapper
{
	/**
	 * 根据主键ID获取TsOrgInfo
	 * @param oiCode
	 * @return
	 */
	public TsOrgInfo getTsOrgInfo(String oiCode) throws Exception;
	
	/**
	 * 增加TsOrgInfo
	 * @param tsOrgInfo
	 */
	public void addTsOrgInfo(TsOrgInfo tsOrgInfo) throws Exception;
	
	/**
	 * 更新TsOrgInfo
	 * @param empBean
	 */
	public void updateTsOrgInfo(TsOrgInfo tsOrgInfo) throws Exception;
	
	/**
	 * 删除TsOrgInfo
	 * @param oiCode
	 */
	public void deleteTsOrgInfo(String oiCode) throws Exception;
	
	
	/**
	 * 列举员工信息，带分页
	 * @param TsOrgInfo
	 * @return
	 */
	public PageDataBunder listTsOrgInfo(TsOrgInfo paramBean, Page page) throws Exception;

	/**
	 * 列举所有可用的组织机构
	 * @return
	 * @throws Exception
	 */
	public List<TsOrgInfo> listActiveOrgInfo() throws Exception;

	/**
	 * 获取某个机构被用户关联的数量
	 * @param userId
	 * @return
	 * @throws Exception
	 */
	public Integer getUserOrgCount(String oiCode) throws Exception;

	/**
	 * 查询所有公司及分公司
	 * @return
	 */
	public List<TsOrgInfo> listBranchOrg();


	
}
