package com.efs.bus.libary.mapper;

import javax.annotation.Resource;

import com.efs.bus.lib.addr.mapper.LibShelfAddInfo;
import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.efs.common.database.BaseMapper;
import com.efs.common.database.Page;
import com.efs.common.database.PageDataBunder;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository("libShelfInfoMapper")
public class LibShelfInfoMapperImpl extends BaseMapper implements LibShelfInfoMapper
{

	@Resource(name = "sqlSession")
	private SqlSessionTemplate sqlSession;
	
	@Override
	public LibShelfInfo getLibShelfInfo(String lsNo) throws Exception
	{
		return sqlSession.selectOne("com.efs.bus.libary.mapper.LibShelfInfoMapper.getLibShelfInfo", lsNo);
	}

	@Override
	public void addLibShelfInfo(LibShelfInfo libShelfInfo) throws Exception
	{
		sqlSession.insert("com.efs.bus.libary.mapper.LibShelfInfoMapper.addLibShelfInfo", libShelfInfo);
	}

	@Override
	public void updateLibShelfInfo(LibShelfInfo libShelfInfo) throws Exception
	{
		sqlSession.update("com.efs.bus.libary.mapper.LibShelfInfoMapper.updateLibShelfInfo", libShelfInfo);
	}

	@Override
	public void deleteLibShelfInfo(String lsNo) throws Exception
	{
		sqlSession.delete("com.efs.bus.libary.mapper.LibShelfInfoMapper.deleteLibShelfInfo", lsNo);
	}
	
	@Override
	public PageDataBunder listLibShelfInfo(LibShelfInfo paramBean,Page page) throws Exception
	{
		return queryPagedResult(sqlSession, "com.efs.bus.libary.mapper.LibShelfInfoMapper.listLibShelfInfo", paramBean, page);
	}

	@Override
	public int getNexShelfNo() throws Exception
	{
		return sqlSession.selectOne("com.efs.bus.libary.mapper.LibShelfInfoMapper.getNexShelfNo");
	}

	/**
	 * 获得某个书架的所有书柜
	 *
	 * @param lsNo
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<LibShelfAddInfo> listShelfAddr(String lsNo) throws Exception
	{
		return sqlSession.selectList("com.efs.bus.libary.mapper.LibShelfInfoMapper.listShelfAddr",lsNo);
	}

    /**
     * 列举所有的书架信息
     *
     * @return
     * @throws Exception
     */
    @Override
    public List<LibShelfInfo> listAllShelf() throws Exception
    {
        return sqlSession.selectList("com.efs.bus.libary.mapper.LibShelfInfoMapper.listAllShelf");
    }

	@Override
	public List<LibShelfAddInfo> listAllAddr() throws Exception
	{
		return sqlSession.selectList("com.efs.bus.libary.mapper.LibShelfInfoMapper.listAllAddr");
	}

	/**
	 * 更新书架的使用状态
	 *
	 * @param siCode
	 * @param status
	 * @throws Exception
	 */
	@Override
	public void updateAddUseStatus(String siCode, String status) throws Exception
	{
		Map<String,String> paramMap = new HashMap<>();
		paramMap.put("siCode",siCode);
		paramMap.put("status",status);
		sqlSession.insert("com.efs.bus.libary.mapper.LibShelfInfoMapper.updateAddUseStatus",paramMap);
	}
}
