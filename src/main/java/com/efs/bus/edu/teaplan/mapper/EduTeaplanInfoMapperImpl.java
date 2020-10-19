package com.efs.bus.edu.teaplan.mapper;

import com.efs.common.database.BaseMapper;
import com.efs.common.database.Page;
import com.efs.common.database.PageDataBunder;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository("eduTeaplanInfoMapper")
public class EduTeaplanInfoMapperImpl extends BaseMapper implements EduTeaplanInfoMapper
{

	@Resource(name = "sqlSession")
	private SqlSessionTemplate sqlSession;
	
	@Override
	public EduTeaplanInfo getEduTeaplanInfo(String tiDbId) throws Exception
	{
		return sqlSession.selectOne("com.efs.bus.edu.teaplan.mapper.EduTeaplanInfoMapper.getEduTeaplanInfo", tiDbId);
	}

	@Override
	public void addEduTeaplanInfo(List<EduTeaplanInfo> eduTeaplanInfoList) throws Exception
	{
		sqlSession.insert("com.efs.bus.edu.teaplan.mapper.EduTeaplanInfoMapper.addEduTeaplanInfo", eduTeaplanInfoList);
	}

	@Override
	public void updateEduTeaplanInfo(EduTeaplanInfo eduTeaplanInfo) throws Exception
	{
		sqlSession.update("com.efs.bus.edu.teaplan.mapper.EduTeaplanInfoMapper.updateEduTeaplanInfo", eduTeaplanInfo);
	}

	@Override
	public void deleteEduTeaplanInfo(String tiDbId) throws Exception
	{
		sqlSession.delete("com.efs.bus.edu.teaplan.mapper.EduTeaplanInfoMapper.deleteEduTeaplanInfo", tiDbId);
	}
	
	@Override
	public PageDataBunder listEduTeaplanInfo(EduTeaplanInfo paramBean,Page page) throws Exception
	{
		return queryPagedResult(sqlSession, "com.efs.bus.edu.teaplan.mapper.EduTeaplanInfoMapper.listEduTeaplanInfo", paramBean, page);
	}

	/**
	 * 查询发布记录列表
	 *
	 * @param paramBean
	 * @param page
	 * @return
	 * @throws Exception
	 */
	@Override
	public PageDataBunder listIssueInfo(EduTeaplanInfo paramBean, Page page) throws Exception
	{
		return queryPagedResult(sqlSession, "com.efs.bus.edu.teaplan.mapper.EduTeaplanInfoMapper.listIssueInfo", paramBean, page);
	}

	/**
	 * 获得系统中最大的批次号
	 *
	 * @return
	 * @throws Exception
	 */
	@Override
	public String getMaxBatchId() throws Exception
	{
		return sqlSession.selectOne("com.efs.bus.edu.teaplan.mapper.EduTeaplanInfoMapper.getMaxBatchId");
	}

	/**
	 * 批次删除教案信息
	 *
	 * @param tiBatchId
	 * @throws Exception
	 */
	@Override
	public void deleteBatchTeaplan(String tiBatchId) throws Exception
	{
		sqlSession.delete("com.efs.bus.edu.teaplan.mapper.EduTeaplanInfoMapper.deleteBatchTeaplan",tiBatchId);
	}

    /**
     * 提交教案信息
     *
     * @param eduTeaplanInfo
     * @throws Exception
     */
    @Override
    public void addSubmitTeaplan(EduTeaplanInfo eduTeaplanInfo) throws Exception
    {
        sqlSession.update("com.efs.bus.edu.teaplan.mapper.EduTeaplanInfoMapper.addSubmitTeaplan",eduTeaplanInfo);
    }

	/**
	 * 评定教案
	 *
	 * @param eduTeaplanInfo
	 * @throws Exception
	 */
	@Override
	public void addEvalTeaplan(EduTeaplanInfo eduTeaplanInfo) throws Exception
	{
		sqlSession.update("com.efs.bus.edu.teaplan.mapper.EduTeaplanInfoMapper.addEvalTeaplan",eduTeaplanInfo);
	}

	/**
	 * 查找某个批次的各个状态的教师信息
	 *
	 * @param tiBatchId
	 * @param tiStatus
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<EduTeaplanInfo> listStatusTeacher(String tiBatchId, String tiStatus) throws Exception
	{
		Map<String,Object> paramMap = new HashMap<>();
		paramMap.put("tiBatchId",tiBatchId);
		paramMap.put("tiStatus",tiStatus);
		return sqlSession.selectList("com.efs.bus.edu.teaplan.mapper.EduTeaplanInfoMapper.listStatusTeacher",paramMap);
	}

	/**
	 * 查询所有批次信息
	 *
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<String> listBatchids() throws Exception
	{
		return sqlSession.selectList("com.efs.bus.edu.teaplan.mapper.EduTeaplanInfoMapper.listBatchids");
	}
}
