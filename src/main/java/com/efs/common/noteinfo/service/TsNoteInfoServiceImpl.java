package com.efs.common.noteinfo.service;

import com.efs.common.database.Page;
import com.efs.common.database.PageDataBunder;
import com.efs.common.noteinfo.mapper.TsNoteInfo;
import com.efs.common.noteinfo.mapper.TsNoteInfoMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("tsNoteInfoService")
public class TsNoteInfoServiceImpl implements TsNoteInfoService
{
	@Resource(name="tsNoteInfoMapper")
	private TsNoteInfoMapper tsNoteInfoMapper;
	
	@Override
	public TsNoteInfo getTsNoteInfo(String ntId) throws Exception
	{
		return tsNoteInfoMapper.getTsNoteInfo(ntId);
	}

	@Override
	public void addTsNoteInfo(TsNoteInfo tsNoteInfo) throws Exception
	{
		tsNoteInfoMapper.addTsNoteInfo(tsNoteInfo);
	}

	@Override
	public void updateTsNoteInfo(TsNoteInfo tsNoteInfo) throws Exception
	{
		tsNoteInfoMapper.updateTsNoteInfo(tsNoteInfo);

		//删除阅读记录
		tsNoteInfoMapper.deleteNoteReadInfo(tsNoteInfo.getNtId());
	}

	@Override
	public void deleteTsNoteInfo(String ntId) throws Exception
	{
		tsNoteInfoMapper.deleteTsNoteInfo(ntId);

		//删除阅读记录
		tsNoteInfoMapper.deleteNoteReadInfo(ntId);
	}

	@Override
	public PageDataBunder listTsNoteInfo(TsNoteInfo paramBean, Page page) throws Exception
	{
		return tsNoteInfoMapper.listTsNoteInfo(paramBean,page);
	}

	/**
	 * 获取未读信息的数量
	 *
	 * @param userId
	 * @return
	 * @throws Exception
	 */
	@Override
	public int getUnReadInfoCount(String userId) throws Exception
	{
		return tsNoteInfoMapper.getUnReadInfoCount(userId);
	}

	/**
	 * 列舉所有用戶未讀信息
	 *
	 * @param userId
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<TsNoteInfo> listUserUnReadNotes(String userId) throws Exception
	{
		return tsNoteInfoMapper.listUserUnReadNotes(userId);
	}

	/**
	 * 设置读消息
	 *
	 * @param ntId
	 * @param ntReadUser
	 * @throws Exception
	 */
	@Override
	public void updateReadNoteInfo(String ntId, String ntReadUser) throws Exception
	{
		tsNoteInfoMapper.readNoteInfo(ntId,ntReadUser);
	}
}
