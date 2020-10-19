package com.efs.bus.todotask.service;

import com.efs.bus.todotask.mapper.TsTodoTaskInfo;
import com.efs.bus.todotask.mapper.TsTodoTaskInfoMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service("tsTodoTaskInfoService")
public class TsTodoTaskInfoServiceImpl implements TsTodoTaskInfoService
{
	@Resource(name="tsTodoTaskInfoMapper")
	private TsTodoTaskInfoMapper tsTodoTaskInfoMapper;
	
	@Override
	public List<TsTodoTaskInfo> listTsTodoTaskInfo(Map<String,Object> paramMap) throws Exception
	{
		List<TsTodoTaskInfo> tsTodoTaskInfos = new ArrayList<>();
		//return tsTodoTaskInfoMapper.listTsTodoTaskInfo(paramMap);
		return tsTodoTaskInfos;
	}
	
}
