package com.efs.bus.edu.semcal.mapper;

import com.efs.common.database.BaseMapper;
import com.efs.common.database.Page;
import com.efs.common.database.PageDataBunder;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Repository("baseSemesterCalMapper")
public class BaseSemesterCalMapperImpl extends BaseMapper implements BaseSemesterCalMapper
{

	@Resource(name = "sqlSession")
	private SqlSessionTemplate sqlSession;
	
	@Override
	public BaseSemesterCal getBaseSemesterCal(String scTerm) throws Exception
	{
		return sqlSession.selectOne("com.efs.bus.edu.semcal.mapper.BaseSemesterCalMapper.getBaseSemesterCal", scTerm);
	}

	@Override
	public void addBaseSemesterCal(BaseSemesterCal baseSemesterCal) throws Exception
	{
		sqlSession.insert("com.efs.bus.edu.semcal.mapper.BaseSemesterCalMapper.addBaseSemesterCal", baseSemesterCal);
	}

	@Override
	public void updateBaseSemesterCal(BaseSemesterCal baseSemesterCal) throws Exception
	{
		sqlSession.update("com.efs.bus.edu.semcal.mapper.BaseSemesterCalMapper.updateBaseSemesterCal", baseSemesterCal);
	}

	@Override
	public void deleteBaseSemesterCal(String scTerm) throws Exception
	{
		sqlSession.delete("com.efs.bus.edu.semcal.mapper.BaseSemesterCalMapper.deleteBaseSemesterCal", scTerm);
	}
	
	@Override
	public PageDataBunder listBaseSemesterCal(BaseSemesterCal paramBean,Page page) throws Exception
	{
		return queryPagedResult(sqlSession, "com.efs.bus.edu.semcal.mapper.BaseSemesterCalMapper.listBaseSemesterCal", paramBean, page);
	}

	/**
	 * 查询学期列表（不含分页)
	 *
	 * @param paramBean
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<BaseSemesterCal> listBaseSemesterCalNoPage(BaseSemesterCal paramBean) throws Exception
	{
		return sqlSession.selectList("com.efs.bus.edu.semcal.mapper.BaseSemesterCalMapper.listBaseSemesterCal",paramBean);
	}

	/**
	 * 获取当前学期
	 *
	 * @return
	 * @throws Exception
	 */
	@Override
	public BaseSemesterCal getCurrentSemester() throws Exception
	{
		return sqlSession.selectOne("com.efs.bus.edu.semcal.mapper.BaseSemesterCalMapper.getCurrentSemester");
	}
}
