package com.efs.common.auth.org.service;

import com.efs.common.auth.org.mapper.TsOrgInfo;
import com.efs.common.database.Page;
import com.efs.common.database.PageDataBunder;
import com.xwh.bean.SelectBean;
import org.omg.CORBA.PUBLIC_MEMBER;

import java.util.List;

/**
 * 
 * com.efs.common.auth.org.mapper.TsOrgInfoService
 * @author xwh
 * 2018-03-15 09:54:12
 * 组织机构信息表
 *
 */
public interface TsOrgInfoService
{
	/**
	 * 根据主键ID获取TsOrgInfo
	 * @param dbId
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
	 * @param dbId
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
	 * 检查机构代码是否已经被使用
	 * @param oiCode
	 * @return
	 * @throws Exception
	 */
	public boolean checkOrgHasUsed(String oiCode) throws Exception;

	/**
	 * 查询所有公司及分公司
	 * @return
	 */
	public List<TsOrgInfo> listBranchOrg();

	/**
	 * 查询下拉列表的机构
	 * @return
	 */
	public List<SelectBean> listBranchOrgSelect() throws Exception;
	
}
