package com.efs.bus.edu.scorestatic.mapper;

import com.efs.common.database.BaseMapper;
import com.efs.common.database.Page;
import com.efs.common.database.PageDataBunder;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Repository("eduClassStaticInfoMapper")
public class EduClassStaticInfoMapperImpl extends BaseMapper implements EduClassStaticInfoMapper
{

	@Resource(name = "sqlSession")
	private SqlSessionTemplate sqlSession;
	
	@Override
	public EduClassStaticInfo getEduClassStaticInfo(String csTerm) throws Exception
	{
		return sqlSession.selectOne("com.efs.bus.edu.scorestatic.mapper.EduClassStaticInfoMapper.getEduClassStaticInfo", csTerm);
	}

	@Override
	public void addEduClassStaticInfo(EduClassStaticInfo eduClassStaticInfo) throws Exception
	{
		sqlSession.insert("com.efs.bus.edu.scorestatic.mapper.EduClassStaticInfoMapper.addEduClassStaticInfo", eduClassStaticInfo);
	}

	@Override
	public void updateEduClassStaticInfo(EduClassStaticInfo eduClassStaticInfo) throws Exception
	{
		sqlSession.update("com.efs.bus.edu.scorestatic.mapper.EduClassStaticInfoMapper.updateEduClassStaticInfo", eduClassStaticInfo);
	}

	@Override
	public void deleteEduClassStaticInfo(String csTerm) throws Exception
	{
		sqlSession.delete("com.efs.bus.edu.scorestatic.mapper.EduClassStaticInfoMapper.deleteEduClassStaticInfo", csTerm);
	}
	
	@Override
	public PageDataBunder listEduClassStaticInfo(EduClassStaticInfo paramBean,Page page) throws Exception
	{
		return queryPagedResult(sqlSession, "com.efs.bus.edu.scorestatic.mapper.EduClassStaticInfoMapper.listEduClassStaticInfo", paramBean, page);
	}

	/**
	 * 获取班级的分数统计结果
	 *
	 * @param paramBean
	 * @return
	 * @throws Exception
	 */
	@Override
	public EduClassStaticResult getClassStaticResult(EduClassStaticResult paramBean) throws Exception
	{
		return sqlSession.selectOne("com.efs.bus.edu.scorestatic.mapper.EduClassStaticInfoMapper.getClassStaticResult",paramBean);
	}

	/**
	 * 查询学校成绩统计报表
	 *
	 * @param paramBean
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<EduClassStaticInfo> listSchoolStatic(EduClassStaticInfo paramBean) throws Exception
	{
		return sqlSession.selectList("com.efs.bus.edu.scorestatic.mapper.EduClassStaticInfoMapper.listSchoolStatic",paramBean);
	}
}
