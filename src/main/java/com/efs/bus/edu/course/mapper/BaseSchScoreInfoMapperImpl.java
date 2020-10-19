package com.efs.bus.edu.course.mapper;

import com.efs.common.database.BaseMapper;
import com.efs.common.database.Page;
import com.efs.common.database.PageDataBunder;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository("baseSchScoreInfoMapper")
public class BaseSchScoreInfoMapperImpl extends BaseMapper implements BaseSchScoreInfoMapper
{

	@Resource(name = "sqlSession")
	private SqlSessionTemplate sqlSession;
	
	@Override
	public BaseSchScoreInfo getBaseSchScoreInfo(String ssId) throws Exception
	{
		return sqlSession.selectOne("com.efs.bus.edu.course.mapper.BaseSchScoreInfoMapper.getBaseSchScoreInfo", ssId);
	}

	@Override
	public void addBaseSchScoreInfo(BaseSchScoreInfo baseSchScoreInfo) throws Exception
	{
		sqlSession.insert("com.efs.bus.edu.course.mapper.BaseSchScoreInfoMapper.addBaseSchScoreInfo", baseSchScoreInfo);
	}

	@Override
	public void updateBaseSchScoreInfo(BaseSchScoreInfo baseSchScoreInfo) throws Exception
	{
		sqlSession.update("com.efs.bus.edu.course.mapper.BaseSchScoreInfoMapper.updateBaseSchScoreInfo", baseSchScoreInfo);
	}

	@Override
	public void deleteBaseSchScoreInfo(String ssId) throws Exception
	{
		sqlSession.delete("com.efs.bus.edu.course.mapper.BaseSchScoreInfoMapper.deleteBaseSchScoreInfo", ssId);
	}
	
	@Override
	public PageDataBunder listBaseSchScoreInfo(BaseSchScoreInfo paramBean,Page page) throws Exception
	{
		return queryPagedResult(sqlSession, "com.efs.bus.edu.course.mapper.BaseSchScoreInfoMapper.listBaseSchScoreInfo", paramBean, page);
	}

	/**
	 * 批量拷贝某学期、某班的课程安排
	 *
	 * @param paramBean
	 * @throws Exception
	 */
	@Override
	public void copyBaseSchScoreInfo(BaseSchScoreInfo paramBean) throws Exception
	{
		sqlSession.insert("com.efs.bus.edu.course.mapper.BaseSchScoreInfoMapper.copyBaseSchScoreInfo",paramBean);
	}

	/**
	 * 检查指定的学期或班级是否已经安排了课程
	 *
	 * @param ssTerm
	 * @param ssClass
	 * @return
	 * @throws Exception
	 */
	@Override
	public int getTermHasCourse(String ssTerm, String ssClass) throws Exception
	{
		Map<String,Object> paramMap = new HashMap<>();
		paramMap.put("ssTerm",ssTerm);
		paramMap.put("ssClass",ssClass);
		return sqlSession.selectOne("com.efs.bus.edu.course.mapper.BaseSchScoreInfoMapper.getTermHasCourse",paramMap);
	}

	/**
	 * 获得某个教师指定学期有课的所有班级
	 *
	 * @param ssTerm
	 * @param teacherId
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<String> listTeacherHasCourClass(String ssTerm, String teacherId) throws Exception
	{
		Map<String,Object> paramMap = new HashMap<>();
		paramMap.put("ssTerm",ssTerm);
		paramMap.put("teacherId",teacherId);
		return sqlSession.selectList("com.efs.bus.edu.course.mapper.BaseSchScoreInfoMapper.listTeacherHasCourClass",paramMap);
	}

	/**
	 * 查询某学期各班的的参加考试的列表
	 *
	 * @param ssTerm
	 * @param ssClass
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<BaseSchScoreInfo> listTermClassCourForTest(String ssTerm, String ssClass) throws Exception
	{
		Map<String,Object> paramMap = new HashMap<>();
		paramMap.put("ssTerm",ssTerm);
		paramMap.put("ssClass",ssClass);
		return sqlSession.selectList("com.efs.bus.edu.course.mapper.BaseSchScoreInfoMapper.listTermClassCourForTest",paramMap);
	}

	/**
	 * 查询课程 信息－不带分页
	 *
	 * @param paramBean
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<BaseSchScoreInfo> listBaseSchScoreInfoNoPage(BaseSchScoreInfo paramBean) throws Exception
	{
		return sqlSession.selectList("com.efs.bus.edu.course.mapper.BaseSchScoreInfoMapper.listBaseSchScoreInfo",paramBean);
	}
}
