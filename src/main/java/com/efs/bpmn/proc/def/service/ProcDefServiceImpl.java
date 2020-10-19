package com.efs.bpmn.proc.def.service;

import com.efs.bpmn.proc.def.mapper.WorkProcessDefBean;
import com.efs.common.database.PageDataBunder;
import com.xwh.util.EFSUtil;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.ProcessDefinition;
import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@Service("procDefService")
public class ProcDefServiceImpl implements ProcDefService
{
	@Resource(name="repositoryService")
	private RepositoryService repositoryService;
	
	@Override
	public PageDataBunder listAllProcDefInfo(String sysId) throws Exception
	{
		List<ProcessDefinition> defList;
		List<WorkProcessDefBean> defBeanList = new ArrayList<>();
		PageDataBunder pb = new PageDataBunder();
		
		defList = repositoryService.createProcessDefinitionQuery().processDefinitionCategory(sysId).orderByProcessDefinitionName().asc().orderByProcessDefinitionVersion().desc().list();
		if(!EFSUtil.isEmptyList(defList))
		{
			for(ProcessDefinition def : defList)
			{
				defBeanList.add(convertProc(def));
			}
		}
		
		pb.setRows(defBeanList);
		pb.setTotal((int)(repositoryService.createProcessDefinitionQuery().count()));
		
		return pb;
	}



	@Override
	public WorkProcessDefBean getProcDef(String wokProsId) throws Exception
	{
		ProcessDefinition procDef = repositoryService.createProcessDefinitionQuery().processDefinitionId(wokProsId).singleResult();
		
		return convertProc(procDef);
	}

	private WorkProcessDefBean convertProc(ProcessDefinition procDef) throws Exception
	{
		WorkProcessDefBean defBean = null;
		if(procDef != null)
		{
			defBean = new WorkProcessDefBean();
			defBean.setWokProsId(procDef.getId());
			defBean.setWorkDeployId(procDef.getDeploymentId());
			defBean.setWokProsKey(procDef.getKey());
			defBean.setWokProsName(procDef.getName());
			defBean.setWokProsImgName(procDef.getDiagramResourceName());
			defBean.setWorkProcXmlName(procDef.getResourceName());
			defBean.setWokProsDesc(procDef.getDescription());
			
			defBean.setWokProsVersion(String.valueOf(procDef.getVersion()));
		}
		
		return defBean;
	}

	@Override
	public InputStream getProcessDefImage(String wokProsId) throws Exception
	{
		InputStream is = null;
		is = repositoryService.getProcessDiagram(wokProsId);
		return is;
	}

	@Override
	public String getProcDefParameter(String procDefId, String key) throws Exception
	{
		ProcessDefinition procDef = repositoryService.getProcessDefinition(procDefId);
		String val = IOUtils.toString(repositoryService.getResourceAsStream(procDef.getDeploymentId(),key));
		return val;
	}

	
}
