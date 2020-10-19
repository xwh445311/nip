package com.efs.bus.upload.mapper;

import com.efs.common.database.BaseMapper;
import com.efs.common.database.Page;
import com.efs.common.database.PageDataBunder;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Repository("tsFileUploadMapper")
public class TsFileUploadMapperImpl extends BaseMapper implements TsFileUploadMapper
{

	@Resource(name = "sqlSession")
	private SqlSessionTemplate sqlSession;
	
	@Override
	public TsFileUpload getTsFileUpload(String fpId) throws Exception
	{
		return sqlSession.selectOne("com.efs.bus.upload.mapper.TsFileUploadMapper.getTsFileUpload", fpId);
	}

	@Override
	public void addTsFileUpload(TsFileUpload tsFileUpload) throws Exception
	{
		sqlSession.insert("com.efs.bus.upload.mapper.TsFileUploadMapper.addTsFileUpload", tsFileUpload);
	}

	@Override
	public void updateTsFileUpload(TsFileUpload tsFileUpload) throws Exception
	{
		sqlSession.update("com.efs.bus.upload.mapper.TsFileUploadMapper.updateTsFileUpload", tsFileUpload);
	}

	@Override
	public void deleteTsFileUpload(String fpId) throws Exception
	{
		sqlSession.delete("com.efs.bus.upload.mapper.TsFileUploadMapper.deleteTsFileUpload", fpId);
	}
	
	@Override
	public PageDataBunder listTsFileUpload(TsFileUpload paramBean,Page page) throws Exception
	{
		return queryPagedResult(sqlSession, "com.efs.bus.upload.mapper.TsFileUploadMapper.listTsFileUpload", paramBean, page);
	}

	/**
	 * 查询文件列表
	 *
	 * @param paramBean
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<TsFileUpload> listFiles(TsFileUpload paramBean) throws Exception
	{
		return sqlSession.selectList("com.efs.bus.upload.mapper.TsFileUploadMapper.listTsFileUpload",paramBean);
	}
}
