package com.efs.bus.office.message.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.efs.bus.office.message.mapper.TsMessageInfoMapper;
import com.efs.bus.office.message.mapper.TsMessageInfo;

import com.efs.common.database.Page;
import com.efs.common.database.PageDataBunder;
import org.springframework.stereotype.Service;

@Service("tsMessageInfoService")
public class TsMessageInfoServiceImpl implements TsMessageInfoService
{
	@Resource(name="tsMessageInfoMapper")
	private TsMessageInfoMapper tsMessageInfoMapper;
	
	@Override
	public TsMessageInfo getTsMessageInfo(String miCode) throws Exception
	{
		return tsMessageInfoMapper.getTsMessageInfo(miCode);
	}

	@Override
	public void addTsMessageInfo(TsMessageInfo tsMessageInfo) throws Exception
	{
		tsMessageInfoMapper.addTsMessageInfo(tsMessageInfo);
	}

	@Override
	public void updateTsMessageInfo(TsMessageInfo tsMessageInfo) throws Exception
	{
		tsMessageInfoMapper.updateTsMessageInfo(tsMessageInfo);
	}

	@Override
	public void deleteTsMessageInfo(String miCode) throws Exception
	{
		tsMessageInfoMapper.deleteTsMessageInfo(miCode);
	}

	@Override
	public PageDataBunder listTsMessageInfo(TsMessageInfo paramBean,Page page) throws Exception
	{
		return tsMessageInfoMapper.listTsMessageInfo(paramBean,page);
	}

	/**
	 * 查询首页显示的通知信息
	 * showType=1:显示最近的10，2：显示所有的
	 *
	 * @param showType
	 * @param userType
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<TsMessageInfo> listMyMessage(String showType, String userType) throws Exception
	{
		return tsMessageInfoMapper.listMyMessage(showType, userType);
	}

	/**
	 * 检查该通知是否是指定用户所发
	 *
	 * @param miCode
	 * @param userId
	 * @return
	 * @throws Exception
	 */
	@Override
	public boolean checkUserIssueMessage(String miCode, String userId) throws Exception
	{
		return tsMessageInfoMapper.checkUserIssueMessage(miCode, userId);
	}
}
