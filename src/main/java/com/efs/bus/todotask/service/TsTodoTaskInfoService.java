package com.efs.bus.todotask.service;

import com.efs.bus.todotask.mapper.TsTodoTaskInfo;

import java.util.List;
import java.util.Map;

/**
 * 
 * com.efs.bus.todotask.mapper.TsTodoTaskInfoService
 * @author xwh
 * 2018-05-23 23:13:27
 * 待办任务信息表
 *
 */
public interface TsTodoTaskInfoService
{

	/**
	 * 列举员工信息，带分页
	 * @param TsTodoTaskInfo
	 * @return
	 */
	public List<TsTodoTaskInfo> listTsTodoTaskInfo(Map<String,Object> paramMap) throws Exception;
	
}
