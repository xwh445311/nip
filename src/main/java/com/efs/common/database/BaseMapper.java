package com.efs.common.database;

import com.github.pagehelper.PageHelper;
import org.apache.ibatis.session.SqlSession;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
* @Title: BaseMapper.java 
* @Package com.efs.common.database 
* @Description: MAPPTER基础类
* @author xwh-徐武海
* @date 2016年7月31日 下午12:20:12 
* @version V1.0
 */
public class BaseMapper
{
	/**
	 * 查询数据，并封装分页结果
	 * @param session
	 * @param param
	 * @param page
	 * @return
	 */
	public PageDataBunder queryPagedResult(SqlSession session, String mapId , Object param, Page page)
	{
		PageDataBunder bunder = new PageDataBunder();
		PageHelper.startPage(page.getPage(), page.getRows(),true);
		List<?> resList = null;
		int total = 0;
		
		if(param != null)
		{
			resList = session.selectList(mapId, param);
		}
		else
		{
			resList = session.selectList(mapId);
		}
		
		total = (int)((com.github.pagehelper.Page<?>) resList).getTotal();
		
		bunder.setRows(resList);
		bunder.setTotal(total);
		
		return bunder;
		 
	}
	
	/**
	 * 查询数据，并封装分页结果
	 * @param session
	 * @param mapId
	 * @param page
	 * @return
	 */
	public PageDataBunder queryPagedResult(SqlSession session, String mapId , Page page)
	{
		return queryPagedResult(session,mapId,null,page);
	}

	/**
	 * 根据方法名称自动封装查询参数为MAP。此方法必须使用JDK1.8以上，且在编译时，必须加上-parameters参数.<br/>
	 * <strong>注意：此方法不适用于具重载方法的类，如果方法具有重载方法，只以第一个方法名称为准</strong>
	 * @param clazz
	 * @param mathedName
	 * @param params:参数值的个数和顺序必须和声明时的一致
	 * @return
	 */
	public Map<String,Object> packParamater(Class clazz, String mathedName,Object... params)
	{
		Map<String,Object> paramMap = new HashMap<String,Object>();
		Method targetMeth = null;
		Parameter parameter = null;

		Method[] methods = clazz.getMethods();
		for(Method meth : methods)
		{
			if(meth.getName().equals(mathedName))
			{
				targetMeth = meth;
				break;
			}
		}

		if(targetMeth == null)
		{
			throw  new RuntimeException("封装查询参数错误，未找到指定的方法名称【"+ clazz.getName() +"】,方法名：【"+ mathedName +"】");
		}

		Parameter[] parameters = targetMeth.getParameters();

		if(parameters == null)
		{
			throw  new RuntimeException("封装查询参数错误，目标方法没有任何需要封装的参数");
		}

		if(parameters.length != params.length)
		{
			throw  new RuntimeException("封装查询参数错误，目标方法参数个数与传递的参数个数不一致");
		}

		for(int i=0;i<parameters.length;i++)
		{
			parameter = parameters[i];
			paramMap.put(parameter.getName(),params[i]);
		}

		return paramMap;


	}
}
