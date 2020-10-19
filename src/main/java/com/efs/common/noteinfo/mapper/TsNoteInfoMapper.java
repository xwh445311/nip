package com.efs.common.noteinfo.mapper;

import com.efs.common.database.Page;
import com.efs.common.database.PageDataBunder;

import java.util.List;


/**
 * 
 * com.efs.common.noteinfo.mapper.TsNoteInfoMapper
 * @author xwh
 * 2017-08-30 17:22:24
 * 系统消息表
 *
 */
public interface TsNoteInfoMapper
{
	/**
	 * 根据主键ID获取TsNoteInfo
	 * @param ntId
	 * @return
	 */
	public TsNoteInfo getTsNoteInfo(String ntId) throws Exception;
	
	/**
	 * 增加TsNoteInfo
	 * @param tsNoteInfo
	 */
	public void addTsNoteInfo(TsNoteInfo tsNoteInfo) throws Exception;
	
	/**
	 * 更新TsNoteInfo
	 * @param empBean
	 */
	public void updateTsNoteInfo(TsNoteInfo tsNoteInfo) throws Exception;
	
	/**
	 * 删除TsNoteInfo
	 * @param ntId
	 */
	public void deleteTsNoteInfo(String ntId) throws Exception;
	
	
	/**
	 * 列举员工信息，带分页
	 * @param TsNoteInfo
	 * @return
	 */
	public PageDataBunder listTsNoteInfo(TsNoteInfo paramBean, Page page) throws Exception;

	/**
	 * 获取未读信息的数量
	 * @param userId
	 * @return
	 * @throws Exception
	 */
	public int getUnReadInfoCount(String userId) throws Exception;

	/**
	 * 列舉所有用戶未讀信息
	 * @param userId
	 * @return
	 * @throws Exception
	 */
	public List<TsNoteInfo> listUserUnReadNotes(String userId) throws Exception;

	/**
	 * 设置读消息
	 * @param ntId
	 * @param userId
	 * @throws Exception
	 */
	public void readNoteInfo(String ntId, String ntReadUser) throws Exception;

	/**
	 * 删除消息的所有阅读记录
	 * @param ntId
	 * @throws Exception
	 */
	public void deleteNoteReadInfo(String ntId) throws Exception;
}
