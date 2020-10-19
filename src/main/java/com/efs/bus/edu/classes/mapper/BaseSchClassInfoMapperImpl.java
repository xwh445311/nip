package com.efs.bus.edu.classes.mapper;

import com.efs.common.database.BaseMapper;
import com.efs.common.database.Page;
import com.efs.common.database.PageDataBunder;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository("baseSchClassInfoMapper")
public class BaseSchClassInfoMapperImpl extends BaseMapper implements BaseSchClassInfoMapper
{

	@Resource(name = "sqlSession")
	private SqlSessionTemplate sqlSession;
	
	@Override
	public BaseSchClassInfo getBaseSchClassInfo(String scId) throws Exception
	{
		return sqlSession.selectOne("com.efs.bus.edu.classes.mapper.BaseSchClassInfoMapper.getBaseSchClassInfo", scId);
	}

	@Override
	public void addBaseSchClassInfo(BaseSchClassInfo baseSchClassInfo) throws Exception
	{
		sqlSession.insert("com.efs.bus.edu.classes.mapper.BaseSchClassInfoMapper.addBaseSchClassInfo", baseSchClassInfo);
	}

	@Override
	public void updateBaseSchClassInfo(BaseSchClassInfo baseSchClassInfo) throws Exception
	{
		sqlSession.update("com.efs.bus.edu.classes.mapper.BaseSchClassInfoMapper.updateBaseSchClassInfo", baseSchClassInfo);
	}

	@Override
	public void deleteBaseSchClassInfo(String scId) throws Exception
	{
		sqlSession.delete("com.efs.bus.edu.classes.mapper.BaseSchClassInfoMapper.deleteBaseSchClassInfo", scId);
	}
	
	@Override
	public PageDataBunder listBaseSchClassInfo(BaseSchClassInfo paramBean,Page page) throws Exception
	{
		return queryPagedResult(sqlSession, "com.efs.bus.edu.classes.mapper.BaseSchClassInfoMapper.listBaseSchClassInfo", paramBean, page);
	}

	/**
	 * 批量产生班级信息
	 *
	 * @param scTerm
	 * @param gradeCnt
	 * @param clsCnt
	 * @throws Exception
	 */
	@Override
	public void batchAddClasses(String scTerm, int gradeCnt, int clsCnt,String userId) throws Exception
	{
		Map<String,Object> paramMap = new HashMap<>();
		paramMap.put("scTerm",scTerm);
		paramMap.put("gradeCnt",gradeCnt);
		paramMap.put("clsCnt",clsCnt);
		paramMap.put("userId",userId);
		sqlSession.update("com.efs.bus.edu.classes.mapper.BaseSchClassInfoMapper.batchAddClasses",paramMap);
	}

	/**
	 * 检查班级班主任是否已经重复
	 *
	 * @param paramBean
	 * @return
	 * @throws Exception
	 */
	@Override
	public boolean checkClassLeaderExist(BaseSchClassInfo paramBean) throws Exception
	{
		int cnt = sqlSession.selectOne("com.efs.bus.edu.classes.mapper.BaseSchClassInfoMapper.checkClassLeaderExist",paramBean);
		return cnt > 0 ? true : false;
	}

	/**
	 * 查询班级信息，不带分页
	 *
	 * @param paramBean
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<BaseSchClassInfo> listBaseSchClassInfoNoPage(BaseSchClassInfo paramBean) throws Exception
	{
		return sqlSession.selectList("com.efs.bus.edu.classes.mapper.BaseSchClassInfoMapper.listBaseSchClassInfo",paramBean);
	}

	/**
	 * 获取班级表中的最近的学期
	 *
	 * @return
	 * @throws Exception
	 */
	@Override
	public String getLastTerm() throws Exception
	{
		return sqlSession.selectOne("com.efs.bus.edu.classes.mapper.BaseSchClassInfoMapper.getLastTerm");
	}

	/**
	 * 返回指定学期的该老师为主任的某个班
	 *
	 * @param scTerm
	 * @param leaderId
	 * @return
	 * @throws Exception
	 */
	@Override
	public BaseSchClassInfo getClassFromLeader(String scTerm, String leaderId) throws Exception
	{
		Map<String,Object> paramMap = new HashMap<>();
		paramMap.put("scTerm",scTerm);
		paramMap.put("leaderId",leaderId);
		return sqlSession.selectOne("com.efs.bus.edu.classes.mapper.BaseSchClassInfoMapper.getClassFromLeader",paramMap);
	}

	/**
	 * 检查老师是否是某个班的班主任
	 *
	 * @param scTerm
	 * @param scClass
	 * @param leaderId
	 * @return
	 * @throws Exception
	 */
	@Override
	public Integer checkUserIsClassLeader(String scTerm, String scClass, String leaderId) throws Exception
	{
		Map<String,Object> paramMap = new HashMap<>();
		paramMap.put("scTerm",scTerm);
		paramMap.put("leaderId",leaderId);
		paramMap.put("scClass",scClass);

		Integer res = sqlSession.selectOne("com.efs.bus.edu.classes.mapper.BaseSchClassInfoMapper.checkUserIsClassLeader",paramMap);

		return res;
	}

	/**
	 * 查询每个年级的班级数量
	 * type=0:查询当前学期的所有年级，
	 * type =1：查询在班级成绩统计表中存在的年级
	 *
	 * @param scTerm
	 * @param type
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<BaseSchClassInfo> listGradeClsCnt(String scTerm, String type) throws Exception
	{
		Map<String,Object> paramMap = new HashMap<>();
		paramMap.put("scTerm",scTerm);
		paramMap.put("type",type);
		return sqlSession.selectList("com.efs.bus.edu.classes.mapper.BaseSchClassInfoMapper.listGradeClsCnt",paramMap);
	}
}
