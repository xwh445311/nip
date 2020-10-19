package com.efs.bus.lib.booktype.mapper;

import javax.annotation.Resource;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.efs.common.database.BaseMapper;
import com.efs.common.database.Page;
import com.efs.common.database.PageDataBunder;

import java.util.List;

@Repository("libBookTypeInfoMapper")
public class LibBookTypeInfoMapperImpl extends BaseMapper implements LibBookTypeInfoMapper
{

	@Resource(name = "sqlSession")
	private SqlSessionTemplate sqlSession;
	
	@Override
	public LibBookTypeInfo getLibBookTypeInfo(String btId) throws Exception
	{
		return sqlSession.selectOne("com.efs.bus.lib.booktype.mapper.LibBookTypeInfoMapper.getLibBookTypeInfo", btId);
	}

	@Override
	public void addLibBookTypeInfo(LibBookTypeInfo libBookTypeInfo) throws Exception
	{
		sqlSession.insert("com.efs.bus.lib.booktype.mapper.LibBookTypeInfoMapper.addLibBookTypeInfo", libBookTypeInfo);
	}

	@Override
	public void updateLibBookTypeInfo(LibBookTypeInfo libBookTypeInfo) throws Exception
	{
		sqlSession.update("com.efs.bus.lib.booktype.mapper.LibBookTypeInfoMapper.updateLibBookTypeInfo", libBookTypeInfo);
	}

	@Override
	public void deleteLibBookTypeInfo(String btId) throws Exception
	{
		sqlSession.delete("com.efs.bus.lib.booktype.mapper.LibBookTypeInfoMapper.deleteLibBookTypeInfo", btId);
	}
	
	@Override
	public List<LibBookTypeInfo> listLibBookTypeInfo(LibBookTypeInfo paramBean) throws Exception
	{
		return sqlSession.selectList("com.efs.bus.lib.booktype.mapper.LibBookTypeInfoMapper.listLibBookTypeInfo",paramBean);
	}

	/**
	 * 列举子类型
	 *
	 * @param btId
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<LibBookTypeInfo> listChildrenBookType(LibBookTypeInfo paramBean) throws Exception
	{
		return sqlSession.selectList("com.efs.bus.lib.booktype.mapper.LibBookTypeInfoMapper.listChildrenBookType",paramBean);
	}

	/**
	 * 获取下一下数据库主键
	 *
	 * @return
	 * @throws Exception
	 */
	@Override
	public Integer getNextDbId() throws Exception
	{
		return sqlSession.selectOne("com.efs.bus.lib.booktype.mapper.LibBookTypeInfoMapper.getNextDbId");
	}

	/**
	 * 查询所有子类分类
	 *
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<LibBookTypeInfo> listAllChildBookType() throws Exception
	{
		return sqlSession.selectList("com.efs.bus.lib.booktype.mapper.LibBookTypeInfoMapper.listAllChildBookType");
	}
}
