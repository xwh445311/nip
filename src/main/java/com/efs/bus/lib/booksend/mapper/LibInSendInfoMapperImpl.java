package com.efs.bus.lib.booksend.mapper;

import com.efs.common.database.BaseMapper;
import com.efs.common.database.Page;
import com.efs.common.database.PageDataBunder;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@Repository("libInSendInfoMapper")
public class LibInSendInfoMapperImpl extends BaseMapper implements LibInSendInfoMapper
{

	@Resource(name = "sqlSession")
	private SqlSessionTemplate sqlSession;
	
	@Override
	public LibInSendInfo getLibInSendInfo(String isId) throws Exception
	{
		return sqlSession.selectOne("com.efs.bus.lib.booksend.mapper.LibInSendInfoMapper.getLibInSendInfo", isId);
	}

	@Override
	public void addLibInSendInfo(LibInSendInfo libInSendInfo) throws Exception
	{
		sqlSession.insert("com.efs.bus.lib.booksend.mapper.LibInSendInfoMapper.addLibInSendInfo", libInSendInfo);
	}

	@Override
	public void updateLibInSendInfo(LibInSendInfo libInSendInfo) throws Exception
	{
		sqlSession.update("com.efs.bus.lib.booksend.mapper.LibInSendInfoMapper.updateLibInSendInfo", libInSendInfo);
	}

	@Override
	public void deleteLibInSendInfo(String isId) throws Exception
	{
		sqlSession.delete("com.efs.bus.lib.booksend.mapper.LibInSendInfoMapper.deleteLibInSendInfo", isId);
	}
	
	@Override
	public PageDataBunder listUserInSendInfo(String userId, Page page) throws Exception
	{
		return queryPagedResult(sqlSession, "com.efs.bus.lib.booksend.mapper.LibInSendInfoMapper.listUserInSendInfo", userId, page);
	}

	/**
	 * 检查用户是否可以借阅某本书
	 *
	 * @param userId
	 * @param bookCode
	 * @return
	 * @throws Exception
	 */
	@Override
	public String checkUserSendBook(String userId, String bookCode) throws Exception
	{
		Map<String,String> paramMap = new HashMap<>();
		paramMap.put("userId",userId);
		paramMap.put("bookCode",bookCode);
		paramMap.put("res",null);

		sqlSession.selectOne("com.efs.bus.lib.booksend.mapper.LibInSendInfoMapper.checkUserSendBook",paramMap);
		return paramMap.get("res");
	}

	@Override
	public LibInSendInfo getSendUserInfo(String userId) throws Exception
	{
		return sqlSession.selectOne("com.efs.bus.lib.booksend.mapper.LibInSendInfoMapper.getSendUserInfo",userId);
	}

	/**
	 * 检查用户是否可以归还图书<br/>
	 *
	 * @param userId
	 * @param bookCode
	 * @return 00:可归还<br/>
	 * 01：图书尚未入库<br/>
	 * 02：图书尚未借出<br/>
	 * 03：图书不是由当前用户借出<br/>
	 * @throws Exception
	 */
	@Override
	public String checkUserBackBook(String userId, String bookCode) throws Exception
	{
		Map<String,String> paramMap = new HashMap<>();
		paramMap.put("userId",userId);
		paramMap.put("bookCode",bookCode);
		paramMap.put("res",null);

		sqlSession.selectOne("com.efs.bus.lib.booksend.mapper.LibInSendInfoMapper.checkUserBackBook",paramMap);
		return paramMap.get("res");
	}

	/**
	 * 进行图书归还动作
	 *
	 * @param libInSendInfo
	 * @throws Exception
	 */
	@Override
	public void doBacckBook(LibInSendInfo libInSendInfo) throws Exception
	{
		sqlSession.update("com.efs.bus.lib.booksend.mapper.LibInSendInfoMapper.doBacckBook",libInSendInfo);
	}

	/**
	 * 图书挂失
	 *
	 * @param libInSendInfo
	 * @throws Exception
	 */
	@Override
	public void doRegLosBook(LibInSendInfo libInSendInfo) throws Exception
	{
		sqlSession.update("com.efs.bus.lib.booksend.mapper.LibInSendInfoMapper.doRegLosBook",libInSendInfo);
	}

	/**
	 * 处理图书解挂流程
	 *
	 * @param libInSendInfo
	 * @throws Exception
	 */
	@Override
	public void doCompBook(LibInSendInfo libInSendInfo) throws Exception
	{
		sqlSession.update("com.efs.bus.lib.booksend.mapper.LibInSendInfoMapper.doCompBook",libInSendInfo);
	}

	/**
	 * 检查用户是否可以解挂图书<br/>
	 *
	 * @param userId
	 * @param bookCode
	 * @return 00:可归还<br/>
	 * 01：图书尚未入库<br/>
	 * 02：图书尚未挂失<br/>
	 * 03：图书不是由当前用户挂失<br/>
	 * @throws Exception
	 */
	@Override
	public String checkUserCompBook(String userId, String bookCode) throws Exception
	{
		Map<String,String> paramMap = new HashMap<>();
		paramMap.put("userId",userId);
		paramMap.put("bookCode",bookCode);
		paramMap.put("res",null);

		sqlSession.selectOne("com.efs.bus.lib.booksend.mapper.LibInSendInfoMapper.checkUserCompBook",paramMap);
		return paramMap.get("res");
	}

	/**
	 * 查询用户的借阅记录
	 *
	 * @param userId
	 * @param page
	 * @return
	 */
	@Override
	public PageDataBunder listUserAllSendInfo(LibInSendInfo libInSendInfo, Page page) throws Exception
	{
		return queryPagedResult(sqlSession, "com.efs.bus.lib.booksend.mapper.LibInSendInfoMapper.listUserAllSendInfo", libInSendInfo, page);
	}
}
