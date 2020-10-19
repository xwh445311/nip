package com.efs.bpmn.proc.def.service;

import com.efs.bpmn.proc.def.mapper.WorkProcessDefBean;
import com.efs.common.database.PageDataBunder;

import java.io.InputStream;

/**
 * 流程定义SERVICE
 * @author xwh
 *
 */
public interface ProcDefService
{

	/**
	 * 查询系统中所有流程定义BEAN,不分页
	 * @param paramBean
	 * @param page
	 * @return
	 * @throws Exception
	 */
	public PageDataBunder listAllProcDefInfo(String sysId) throws Exception;

	/**
	 * 获取流程定义图片
	 * @param workProsId
	 * @param imgName
	 * @return
	 * @throws Exception
	 */
	public InputStream getProcessDefImage(String wokProsId) throws Exception;

	/**
	 * 根據流程定義ID獲得流程定義信息
	 * @param wokProsId
	 * @return
	 * @throws Exception
	 */
	public WorkProcessDefBean getProcDef(String wokProsId) throws Exception;
	
	/**
	 * 获取流程定义的参数
	 * @param procDeployId
	 * @param key
	 * @return
	 * @throws Exception
	 */
	public String getProcDefParameter(String procDefId, String key) throws Exception;

}
