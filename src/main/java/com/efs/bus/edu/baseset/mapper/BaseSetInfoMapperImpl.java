package com.efs.bus.edu.baseset.mapper;

import com.efs.common.database.BaseMapper;
import com.efs.common.database.Page;
import com.efs.common.database.PageDataBunder;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@Repository("baseSetInfoMapper")
public class BaseSetInfoMapperImpl extends BaseMapper implements BaseSetInfoMapper
{

	@Resource(name = "sqlSession")
	private SqlSessionTemplate sqlSession;
	
	@Override
	public BaseSetInfo getBaseSetInfo(String bsTerm) throws Exception
	{
		return sqlSession.selectOne("com.efs.bus.edu.baseset.mapper.BaseSetInfoMapper.getBaseSetInfo", bsTerm);
	}

	@Override
	public void addBaseSetInfo(BaseSetInfo baseSetInfo) throws Exception
	{
		sqlSession.insert("com.efs.bus.edu.baseset.mapper.BaseSetInfoMapper.addBaseSetInfo", baseSetInfo);
	}

	@Override
	public String updateBaseSetInfo(BaseSetInfo baseSetInfo) throws Exception
	{
		Map<String,String> paramMap = new HashMap<>();
		paramMap.put("bsTerm",baseSetInfo.getBsTerm());
		paramMap.put("bsUser",baseSetInfo.getBsUser());

		String res = null;
		paramMap.put("res",res);
		sqlSession.selectOne("com.efs.bus.edu.baseset.mapper.BaseSetInfoMapper.updateBaseSetInfo", paramMap);

		return paramMap.get("res");
	}

	@Override
	public void deleteBaseSetInfo(String bsTerm) throws Exception
	{
		sqlSession.delete("com.efs.bus.edu.baseset.mapper.BaseSetInfoMapper.deleteBaseSetInfo", bsTerm);
	}
	
	@Override
	public PageDataBunder listBaseSetInfo(BaseSetInfo paramBean,Page page) throws Exception
	{
		return queryPagedResult(sqlSession, "com.efs.bus.edu.baseset.mapper.BaseSetInfoMapper.listBaseSetInfo", paramBean, page);
	}

	/**
	 * 检查基础信息是否已经设置过，TRUE表示已经设置，FALSE表示未设置
	 *
	 * @param bsTerm
	 * @return
	 * @throws Exception
	 */
	@Override
	public boolean checkHasBaseSet(String bsTerm) throws Exception
	{
		int res = sqlSession.selectOne("com.efs.bus.edu.baseset.mapper.BaseSetInfoMapper.checkHasBaseSet",bsTerm);
		return res > 0;
	}
}
