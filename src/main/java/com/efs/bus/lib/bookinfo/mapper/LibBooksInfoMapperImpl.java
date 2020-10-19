package com.efs.bus.lib.bookinfo.mapper;

import javax.annotation.Resource;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.efs.common.database.BaseMapper;
import com.efs.common.database.Page;
import com.efs.common.database.PageDataBunder;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository("libBooksInfoMapper")
public class LibBooksInfoMapperImpl extends BaseMapper implements LibBooksInfoMapper
{

	@Resource(name = "sqlSession")
	private SqlSessionTemplate sqlSession;
	
	@Override
	public LibBooksInfo getLibBooksInfo(String biCode) throws Exception
	{
		return sqlSession.selectOne("com.efs.bus.lib.bookinfo.mapper.LibBooksInfoMapper.getLibBooksInfo", biCode);
	}

	@Override
	public void addLibBooksInfo(List<LibBooksInfo> libBookInfoList) throws Exception
	{
		sqlSession.insert("com.efs.bus.lib.bookinfo.mapper.LibBooksInfoMapper.addLibBooksInfo", libBookInfoList);
	}

	@Override
	public void updateLibBooksInfo(LibBooksInfo libBooksInfo) throws Exception
	{
		sqlSession.update("com.efs.bus.lib.bookinfo.mapper.LibBooksInfoMapper.updateLibBooksInfo", libBooksInfo);
	}

	@Override
	public void deleteLibBooksInfo(String biCode) throws Exception
	{
		sqlSession.delete("com.efs.bus.lib.bookinfo.mapper.LibBooksInfoMapper.deleteLibBooksInfo", biCode);
	}
	
	@Override
	public PageDataBunder listLibBooksInfo(LibBooksInfo paramBean,Page page) throws Exception
	{
		return queryPagedResult(sqlSession, "com.efs.bus.lib.bookinfo.mapper.LibBooksInfoMapper.listLibBooksInfo", paramBean, page);
	}

	@Override
	public LibBooksInfo findLibBooksInfoFromIsbn(String isbn) throws Exception
	{
		return sqlSession.selectOne("com.efs.bus.lib.bookinfo.mapper.LibBooksInfoMapper.findLibBooksInfoFromIsbn", isbn);
	}

	@Override
	public List<String> listLibPress() throws Exception
	{
		return sqlSession.selectList("com.efs.bus.lib.bookinfo.mapper.LibBooksInfoMapper.listLibPress");
	}

	/**
	 * 将图书信息插入到删除表中
	 *
	 * @param paramBean
	 * @throws Exception
	 */
	@Override
	public void addToDelInfo(LibBooksInfo paramBean) throws Exception
	{
		sqlSession.delete("com.efs.bus.lib.bookinfo.mapper.LibBooksInfoMapper.addToDelInfo",paramBean);
	}

	@Override
	public void updateBookStatus(String biCode, String status) throws Exception
	{
		Map<String,String> paramMap = new HashMap<>();
		paramMap.put("biCode",biCode);
		paramMap.put("status",status);
		sqlSession.update("com.efs.bus.lib.bookinfo.mapper.LibBooksInfoMapper.updateBookStatus",paramMap);
	}

	/**
	 * 检查图书是否在借阅表中出现过
	 *
	 * @param biCode
	 * @throws Exception
	 * @return: 大于0表示出现过，0未出现
	 */
	@Override
	public int checkBookInSend(String biCode) throws Exception
	{
		return sqlSession.selectOne("com.efs.bus.lib.bookinfo.mapper.LibBooksInfoMapper.checkBookInSend", biCode);
	}
}
