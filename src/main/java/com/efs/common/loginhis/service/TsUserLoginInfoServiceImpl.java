package com.efs.common.loginhis.service;

import com.efs.common.database.Page;
import com.efs.common.database.PageDataBunder;
import com.efs.common.loginhis.mapper.TsUserLoginInfo;
import com.efs.common.loginhis.mapper.TsUserLoginInfoMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service("tsUserLoginInfoService")
public class TsUserLoginInfoServiceImpl implements TsUserLoginInfoService
{
	@Resource(name="tsUserLoginInfoMapper")
	private TsUserLoginInfoMapper tsUserLoginInfoMapper;
	
	@Override
	public TsUserLoginInfo getTsUserLoginInfo(String ulDbId) throws Exception
	{
		return tsUserLoginInfoMapper.getTsUserLoginInfo(ulDbId);
	}

	@Override
	public void addTsUserLoginInfo(TsUserLoginInfo tsUserLoginInfo) throws Exception
	{
		tsUserLoginInfoMapper.addTsUserLoginInfo(tsUserLoginInfo);
	}

	@Override
	public void updateTsUserLoginInfo(TsUserLoginInfo tsUserLoginInfo) throws Exception
	{
		tsUserLoginInfoMapper.updateTsUserLoginInfo(tsUserLoginInfo);
	}

	@Override
	public void deleteTsUserLoginInfo(String ulDbId) throws Exception
	{
		tsUserLoginInfoMapper.deleteTsUserLoginInfo(ulDbId);
	}

	@Override
	public PageDataBunder listTsUserLoginInfo(TsUserLoginInfo paramBean, Page page) throws Exception
	{
		return tsUserLoginInfoMapper.listTsUserLoginInfo(paramBean,page);
	}

	/**
	 * 获取用户的登录信息
	 *
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<Map<String, Object>> getUserLoginStatics() throws Exception
	{
		return tsUserLoginInfoMapper.getUserLoginStatics();
	}

	/**
	 * 获取当前用户的登录统计信息
	 *
	 * @param userId
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<Map<String, Object>> getCurrUserLoginStatics(String userId) throws Exception
	{
		return tsUserLoginInfoMapper.getCurrUserLoginStatics(userId);
	}
}
