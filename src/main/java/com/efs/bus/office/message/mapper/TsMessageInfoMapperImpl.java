package com.efs.bus.office.message.mapper;

import com.efs.common.database.BaseMapper;
import com.efs.common.database.Page;
import com.efs.common.database.PageDataBunder;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository("tsMessageInfoMapper")
public class TsMessageInfoMapperImpl extends BaseMapper implements TsMessageInfoMapper
{

	@Resource(name = "sqlSession")
	private SqlSessionTemplate sqlSession;
	
	@Override
	public TsMessageInfo getTsMessageInfo(String miCode) throws Exception
	{
		return sqlSession.selectOne("com.efs.bus.office.message.mapper.TsMessageInfoMapper.getTsMessageInfo", miCode);
	}

	@Override
	public void addTsMessageInfo(TsMessageInfo tsMessageInfo) throws Exception
	{
		sqlSession.insert("com.efs.bus.office.message.mapper.TsMessageInfoMapper.addTsMessageInfo", tsMessageInfo);
	}

	@Override
	public void updateTsMessageInfo(TsMessageInfo tsMessageInfo) throws Exception
	{
		sqlSession.update("com.efs.bus.office.message.mapper.TsMessageInfoMapper.updateTsMessageInfo", tsMessageInfo);
	}

	@Override
	public void deleteTsMessageInfo(String miCode) throws Exception
	{
		sqlSession.delete("com.efs.bus.office.message.mapper.TsMessageInfoMapper.deleteTsMessageInfo", miCode);
	}
	
	@Override
	public PageDataBunder listTsMessageInfo(TsMessageInfo paramBean,Page page) throws Exception
	{
		return queryPagedResult(sqlSession, "com.efs.bus.office.message.mapper.TsMessageInfoMapper.listTsMessageInfo", paramBean, page);
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
		Map<String,Object> paramMap = new HashMap<>();

		paramMap.put("showType",showType);
		paramMap.put("userType",userType);
		return sqlSession.selectList("com.efs.bus.office.message.mapper.TsMessageInfoMapper.listMyMessage",paramMap);
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
		Map<String,Object> paramMap = new HashMap<>();
		paramMap.put("miCode",miCode);
		paramMap.put("userId",userId);
		int res = sqlSession.selectOne("com.efs.bus.office.message.mapper.TsMessageInfoMapper.checkUserIssueMessage",paramMap);
		return res > 0;
	}
}
