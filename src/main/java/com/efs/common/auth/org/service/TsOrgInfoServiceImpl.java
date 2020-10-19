package com.efs.common.auth.org.service;

import com.efs.common.auth.org.mapper.TsOrgInfo;
import com.efs.common.auth.org.mapper.TsOrgInfoMapper;
import com.efs.common.database.Page;
import com.efs.common.database.PageDataBunder;
import com.xwh.bean.SelectBean;
import com.xwh.util.EFSUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("tsOrgInfoService")
public class TsOrgInfoServiceImpl implements TsOrgInfoService
{
	@Resource(name="tsOrgInfoMapper")
	private TsOrgInfoMapper tsOrgInfoMapper;
	
	@Override
	public TsOrgInfo getTsOrgInfo(String oiCode) throws Exception
	{
		return tsOrgInfoMapper.getTsOrgInfo(oiCode);
	}

	@Override
	public void addTsOrgInfo(TsOrgInfo tsOrgInfo) throws Exception
	{
		tsOrgInfoMapper.addTsOrgInfo(tsOrgInfo);
	}

	@Override
	public void updateTsOrgInfo(TsOrgInfo tsOrgInfo) throws Exception
	{
		tsOrgInfoMapper.updateTsOrgInfo(tsOrgInfo);
	}

	@Override
	public void deleteTsOrgInfo(String oiCode) throws Exception
	{
		tsOrgInfoMapper.deleteTsOrgInfo(oiCode);
	}

	@Override
	public PageDataBunder listTsOrgInfo(TsOrgInfo paramBean,Page page) throws Exception
	{
		return tsOrgInfoMapper.listTsOrgInfo(paramBean,page);
	}

	/**
	 * 列举所有可用的组织机构
	 *
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<TsOrgInfo> listActiveOrgInfo() throws Exception
	{
		return tsOrgInfoMapper.listActiveOrgInfo();
	}

	/**
	 * 检查机构代码是否已经被使用
	 *
	 * @param oiCode
	 * @return
	 * @throws Exception
	 */
	@Override
	public boolean checkOrgHasUsed(String oiCode) throws Exception
	{
		Integer res = tsOrgInfoMapper.getUserOrgCount(oiCode);

		return res > 0;
	}

	/**
	 * 查询所有公司及分公司
	 *
	 * @return
	 */
	@Override
	public List<TsOrgInfo> listBranchOrg()
	{
		return tsOrgInfoMapper.listBranchOrg();
	}

	/**
	 * 查询下拉列表的机构
	 *
	 * @return
	 */
	@Override
	public List<SelectBean> listBranchOrgSelect() throws Exception
	{
		List<TsOrgInfo> tsOrgInfoList = tsOrgInfoMapper.listBranchOrg();
		List<SelectBean> selectBeans = EFSUtil.convertBeanToSelectBean(tsOrgInfoList,"oiCode","oiName");
		return selectBeans;
	}
}
