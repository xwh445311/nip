package com.efs.bus.lib.addr.mapper;

import javax.annotation.Resource;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.efs.common.database.BaseMapper;
import com.efs.common.database.Page;
import com.efs.common.database.PageDataBunder;

import java.util.List;

@Repository("libShelfAddInfoMapper")
public class LibShelfAddInfoMapperImpl extends BaseMapper implements LibShelfAddInfoMapper
{

	@Resource(name = "sqlSession")
	private SqlSessionTemplate sqlSession;
	
	@Override
	public LibShelfAddInfo getLibShelfAddInfo(String siCode) throws Exception
	{
		return sqlSession.selectOne("com.efs.bus.lib.addr.mapper.LibShelfAddInfoMapper.getLibShelfAddInfo", siCode);
	}

	@Override
	public void addLibShelfAddInfo(List<LibShelfAddInfo> libShelfAddInfoList) throws Exception
	{
		sqlSession.insert("com.efs.bus.lib.addr.mapper.LibShelfAddInfoMapper.addLibShelfAddInfo", libShelfAddInfoList);
	}

	@Override
	public void updateLibShelfAddInfo(LibShelfAddInfo libShelfAddInfo) throws Exception
	{
		sqlSession.update("com.efs.bus.lib.addr.mapper.LibShelfAddInfoMapper.updateLibShelfAddInfo", libShelfAddInfo);
	}

	@Override
	public void deleteLibShelfAddInfo(String siCode) throws Exception
	{
		sqlSession.delete("com.efs.bus.lib.addr.mapper.LibShelfAddInfoMapper.deleteLibShelfAddInfo", siCode);
	}
	
	@Override
	public PageDataBunder listLibShelfAddInfo(LibShelfAddInfo paramBean,Page page) throws Exception
	{
		return queryPagedResult(sqlSession, "com.efs.bus.lib.addr.mapper.LibShelfAddInfoMapper.listLibShelfAddInfo", paramBean, page);
	}

	/**
	 * 根据箱子删除地址
	 *
	 * @param siShelfNo
	 * @throws Exception
	 */
	@Override
	public void deleteLibAddrWithShelf(int siShelfNo) throws Exception
	{
		sqlSession.delete("com.efs.bus.lib.addr.mapper.LibShelfAddInfoMapper.deleteLibAddrWithShelf",siShelfNo);
	}
}
