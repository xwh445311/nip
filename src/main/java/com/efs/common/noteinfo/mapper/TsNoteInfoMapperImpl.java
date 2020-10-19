package com.efs.common.noteinfo.mapper;

import com.efs.common.database.BaseMapper;
import com.efs.common.database.Page;
import com.efs.common.database.PageDataBunder;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository("tsNoteInfoMapper")
public class TsNoteInfoMapperImpl extends BaseMapper implements TsNoteInfoMapper
{

	@Resource(name = "sqlSession")
	private SqlSessionTemplate sqlSession;
	
	@Override
	public TsNoteInfo getTsNoteInfo(String ntId) throws Exception
	{
		return sqlSession.selectOne("com.efs.common.noteinfo.mapper.TsNoteInfoMapper.getTsNoteInfo", ntId);
	}

	@Override
	public void addTsNoteInfo(TsNoteInfo tsNoteInfo) throws Exception
	{
		sqlSession.insert("com.efs.common.noteinfo.mapper.TsNoteInfoMapper.addTsNoteInfo", tsNoteInfo);
	}

	@Override
	public void updateTsNoteInfo(TsNoteInfo tsNoteInfo) throws Exception
	{
		sqlSession.update("com.efs.common.noteinfo.mapper.TsNoteInfoMapper.updateTsNoteInfo", tsNoteInfo);
	}

	@Override
	public void deleteTsNoteInfo(String ntId) throws Exception
	{
		sqlSession.delete("com.efs.common.noteinfo.mapper.TsNoteInfoMapper.deleteTsNoteInfo", ntId);
	}
	
	@Override
	public PageDataBunder listTsNoteInfo(TsNoteInfo paramBean, Page page) throws Exception
	{
		return queryPagedResult(sqlSession, "com.efs.common.noteinfo.mapper.TsNoteInfoMapper.listTsNoteInfo", paramBean, page);
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
		return sqlSession.selectOne("com.efs.common.noteinfo.mapper.TsNoteInfoMapper.getUnReadInfoCount",userId);
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
		return sqlSession.selectList("com.efs.common.noteinfo.mapper.TsNoteInfoMapper.listUserUnReadNotes",userId);
	}

	/**
	 * 设置读消息
	 *
	 * @param ntId
	 * @param userId
	 * @throws Exception
	 */
	@Override
	public void readNoteInfo(String ntId, String ntReadUser) throws Exception
	{
		Map<String,Object> paramMap = new HashMap<>();
		paramMap.put("ntId",ntId);
		paramMap.put("ntReadUser",ntReadUser);

		sqlSession.update("com.efs.common.noteinfo.mapper.TsNoteInfoMapper.readNoteInfo",paramMap);
	}

	/**
	 * 删除消息的所有阅读记录
	 *
	 * @param ntId
	 * @throws Exception
	 */
	@Override
	public void deleteNoteReadInfo(String ntId) throws Exception
	{
		sqlSession.delete("com.efs.common.noteinfo.mapper.TsNoteInfoMapper.deleteNoteReadInfo",ntId);
	}
}
