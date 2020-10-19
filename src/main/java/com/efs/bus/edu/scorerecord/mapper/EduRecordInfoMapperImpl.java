package com.efs.bus.edu.scorerecord.mapper;

import com.efs.common.database.BaseMapper;
import com.efs.common.database.Page;
import com.efs.common.database.PageDataBunder;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.ListUtils;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository("eduRecordInfoMapper")
public class EduRecordInfoMapperImpl extends BaseMapper implements EduRecordInfoMapper
{

	@Resource(name = "sqlSession")
	private SqlSessionTemplate sqlSession;
	
	@Override
	public EduRecordInfo getEduRecordInfo(String riId) throws Exception
	{
		return sqlSession.selectOne("com.efs.bus.edu.scorerecord.mapper.EduRecordInfoMapper.getEduRecordInfo", riId);
	}

	@Override
	public void addEduRecordInfo(List<EduRecordInfo> eduRecordInfos,EduRecordInfo paramBean) throws Exception
	{
		Map<String,Object> paramMap = new HashMap<>();

		paramMap.put("paramBean",paramBean);

		if(CollectionUtils.isNotEmpty(eduRecordInfos))
		{
			//对于大LIST进行分解添加
			List<List<EduRecordInfo>> subList = ListUtils.partition(eduRecordInfos,10);
			for (List<EduRecordInfo> edus : subList)
			{
				paramMap.put("dataList",edus);
				sqlSession.insert("com.efs.bus.edu.scorerecord.mapper.EduRecordInfoMapper.addEduRecordInfo", paramMap);
			}
		}
	}

	@Override
	public void updateEduRecordInfo(EduRecordInfo eduRecordInfo) throws Exception
	{
		sqlSession.update("com.efs.bus.edu.scorerecord.mapper.EduRecordInfoMapper.updateEduRecordInfo", eduRecordInfo);
	}

	@Override
	public void deleteEduRecordInfo(String riId) throws Exception
	{
		sqlSession.delete("com.efs.bus.edu.scorerecord.mapper.EduRecordInfoMapper.deleteEduRecordInfo", riId);
	}
	
	@Override
	public PageDataBunder listEduRecordInfo(EduRecordInfo paramBean,Page page) throws Exception
	{
		return queryPagedResult(sqlSession, "com.efs.bus.edu.scorerecord.mapper.EduRecordInfoMapper.listEduRecordInfo", paramBean, page);
	}

	/**
	 * 查询指定学期，期中/期末，班级的是否已经上传过成绩
	 *
	 * @param paramBean
	 * @return
	 * @throws Exception
	 */
	@Override
	public int getRecordCount(EduRecordInfo paramBean) throws Exception
	{
		return sqlSession.selectOne("com.efs.bus.edu.scorerecord.mapper.EduRecordInfoMapper.getRecordCount",paramBean);
	}

	/**
	 * 根据条件删除某个班的成绩
	 *
	 * @param paramBean
	 * @throws Exception
	 */
	@Override
	public void deleteEduRecordFromCls(EduRecordInfo paramBean) throws Exception
	{
		sqlSession.delete("com.efs.bus.edu.scorerecord.mapper.EduRecordInfoMapper.deleteEduRecordFromCls",paramBean);
	}

	/**
	 * 获取最近的学期和期中期末
	 *
	 * @return
	 * @throws Exception
	 */
	@Override
	public EduRecordInfo getMaxTermAndMid() throws Exception
	{
		return sqlSession.selectOne("com.efs.bus.edu.scorerecord.mapper.EduRecordInfoMapper.getMaxTermAndMid");
	}

	/**
	 * 更新班主任评价
	 *
	 * @param paramBean
	 * @throws Exception
	 */
	@Override
	public void updateLeaderCommont(EduRecordInfo paramBean) throws Exception
	{
		sqlSession.update("com.efs.bus.edu.scorerecord.mapper.EduRecordInfoMapper.updateLeaderCommont",paramBean);
	}

	/**
	 * 获取学生参加考试的场次信息
	 *
	 * @param stuId
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<String> getStudentRecordTerm(String stuId) throws Exception
	{
		return sqlSession.selectList("com.efs.bus.edu.scorerecord.mapper.EduRecordInfoMapper.getStudentRecordTerm",stuId);
	}

	/**
	 * 获取学生某一门课程的历史班级排名信息
	 *
	 * @param stuId
	 * @param coursDbCol
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<Integer> getStudentScoreRank(String stuId, String coursDbCol) throws Exception
	{
		Map<String,Object> paramMap = new HashMap<>();
		paramMap.put("stuId",stuId);
		paramMap.put("coursDbCol",coursDbCol);

		return sqlSession.selectList("com.efs.bus.edu.scorerecord.mapper.EduRecordInfoMapper.getStudentScoreRank",paramMap);
	}

	/**
	 * 查询学生记录信息
	 *
	 * @param paramBean
	 * @param page
	 * @return
	 * @throws Exception
	 */
	@Override
	public PageDataBunder listStudentRecordInfo(EduRecordInfo paramBean, Page page) throws Exception
	{
		return queryPagedResult(sqlSession, "com.efs.bus.edu.scorerecord.mapper.EduRecordInfoMapper.listStudentRecordInfo", paramBean, page);
	}

	/**
	 * 查询供下载的班级成绩统计表
	 *
	 * @param paramBean
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<EduRecordInfo> listDownClassRecord(EduRecordInfo paramBean) throws Exception
	{
		return sqlSession.selectList("com.efs.bus.edu.scorerecord.mapper.EduRecordInfoMapper.listDownClassRecord",paramBean);
	}
}
