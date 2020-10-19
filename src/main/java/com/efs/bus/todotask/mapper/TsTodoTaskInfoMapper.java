package com.efs.bus.todotask.mapper;

import com.efs.common.database.Page;
import com.efs.common.database.PageDataBunder;

import java.util.List;
import java.util.Map;


/**
 * 
 * com.efs.bus.todotask.mapper.TsTodoTaskInfoMapper
 * @author xwh
 * 2018-05-23 23:13:27
 * 待办任务信息表
 *
 */
public interface TsTodoTaskInfoMapper
{

	/**
	 * 列举员工信息，带分页
	 * @param TsTodoTaskInfo
	 * @return
	 */
	public List<TsTodoTaskInfo> listTsTodoTaskInfo(Map<String,Object> paramMap) throws Exception;
	
}
