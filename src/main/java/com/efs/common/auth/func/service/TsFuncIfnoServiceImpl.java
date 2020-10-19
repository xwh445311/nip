package com.efs.common.auth.func.service;

import com.alibaba.fastjson.JSON;
import com.efs.common.Util.SysUtils;
import com.efs.common.auth.func.mapper.TsFuncIfno;
import com.efs.common.auth.func.mapper.TsFuncIfnoMapper;
import com.efs.common.database.Page;
import com.efs.common.database.PageDataBunder;
import com.xwh.util.EFSUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service("tsFuncIfnoService")
public class TsFuncIfnoServiceImpl implements TsFuncIfnoService
{
	@Resource(name="tsFuncIfnoMapper")
	private TsFuncIfnoMapper tsFuncIfnoMapper;
	
	@Override
	public TsFuncIfno getTsFuncIfno(String muDbId) throws Exception
	{
		return tsFuncIfnoMapper.getTsFuncIfno(muDbId);
	}

	@Override
	public void addTsFuncIfno(TsFuncIfno tsFuncIfno) throws Exception
	{
		tsFuncIfno.setMuDbId(SysUtils.genDBID("MU"));
		tsFuncIfno.setMuOrders((tsFuncIfnoMapper.getMaxFuncMenuOrder(tsFuncIfno.getMuParDbId()) + 1)+ "");
		tsFuncIfnoMapper.addTsFuncIfno(tsFuncIfno);
	}

	@Override
	public void updateTsFuncIfno(TsFuncIfno tsFuncIfno) throws Exception
	{
		tsFuncIfnoMapper.updateTsFuncIfno(tsFuncIfno);
	}

	@Override
	public void deleteTsFuncIfno(String muDbId) throws Exception
	{
		//删除角色关联的菜单
		tsFuncIfnoMapper.deleteRoleFunc(muDbId);

		//删除功能及子菜单
		tsFuncIfnoMapper.deleteTsFuncIfno(muDbId);
	}

	@Override
	public PageDataBunder listTsFuncIfno(TsFuncIfno paramBean,Page page) throws Exception
	{
		return tsFuncIfnoMapper.listTsFuncIfno(paramBean,page);
	}

	/**
	 * 查询用户的菜单
	 *
	 * @param userId
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<TsFuncIfno> listUserFuncList(String userId) throws Exception
	{
		List<TsFuncIfno> allFunc = null;
		List<TsFuncIfno> childFunc = null;

		allFunc = tsFuncIfnoMapper.listFirstLevelFunc(userId);

		if(allFunc != null)
		{
			for(TsFuncIfno func : allFunc)
			{
				childFunc = tsFuncIfnoMapper.listChilddFunc(userId,func.getMuDbId());
				if(childFunc != null && childFunc.size() > 0)
				{
					func.setChildFuncs(childFunc);
				}
			}
		}

		return allFunc;
	}

	/**
	 * 查询用户的功能ID
	 *
	 * @param userId
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<String> listUserFuncIds(String userId) throws Exception
	{
		return tsFuncIfnoMapper.listUserFuncIds(userId);
	}

	/**
	 * 查询所有菜单树
	 *
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<TsFuncIfno> listAllFuncList(String isSuperUser) throws Exception
	{
		List<TsFuncIfno> funcList = tsFuncIfnoMapper.listAllFirstLevelFunc(isSuperUser);
		if(!EFSUtil.isEmptyList(funcList))
		{
			for (TsFuncIfno func : funcList)
			{
				listChildFuncInfo(func,isSuperUser);
			}
		}
		return funcList;
	}

	private void listChildFuncInfo(TsFuncIfno parentFunc,String isSuperUser) throws Exception
	{
		if(null != parentFunc)
		{
			List<TsFuncIfno> childFuncList = tsFuncIfnoMapper.listAllSecondLevelFunc(parentFunc.getMuDbId(),isSuperUser);
			if(null != childFuncList && childFuncList.size() > 0)
			{
				parentFunc.setChildFuncs(childFuncList);
				for(TsFuncIfno func : childFuncList)
				{
					listChildFuncInfo(func,isSuperUser);
				}
			}
		}
	}

	/**
	 * 查询菜单树JSON字符串
	 *
	 * @return
	 * @throws Exception
	 */
	@Override
	public String getFuncJson(String isSuperUser) throws Exception
	{
		List<TsFuncIfno> funcList =  listAllFuncList(isSuperUser);
		List<SysFuncJsonBean> jsonList = new ArrayList<SysFuncJsonBean>();
		TsFuncIfno root = new TsFuncIfno();
		root.setMuDbId("0");
		root.setMuName("根菜單");
		root.setMuParDbId("0");


		funcList.add(0,root);
		if(funcList != null && funcList.size() > 0)
		{

			for(TsFuncIfno func : funcList)
			{
				packFuncTreeJsonBean(func, jsonList);
			}
		}

		String jsonStr = JSON.toJSONString(jsonList);
		return jsonStr;
	}


	private void packFuncTreeJsonBean(TsFuncIfno funcInfo,List<SysFuncJsonBean> jsonList)
	{
		SysFuncJsonBean jsonBean = null;

		if(funcInfo != null)
		{
			jsonBean = packFuncToJson(funcInfo);
			if(null != jsonBean)
			{
				jsonList.add(jsonBean);

				List<TsFuncIfno> funcList = funcInfo.getChildFuncs();
				if(funcList != null && funcList.size() > 0)
				{
					for(TsFuncIfno func : funcList)
					{
						packFuncTreeJsonBean(func, jsonList);
					}
				}
			}
		}
	}

	public SysFuncJsonBean packFuncToJson(TsFuncIfno funcInfo)
	{
		SysFuncJsonBean jsonBean = null;
		if(null != funcInfo)
		{
			jsonBean = new SysFuncJsonBean();
			jsonBean.setId(funcInfo.getMuDbId());
			jsonBean.setpId(funcInfo.getMuParDbId());
			jsonBean.setDrag(true);
			jsonBean.setDrop(true);
			jsonBean.setOpen(true);
			jsonBean.setChecked(funcInfo.isChecked());
			jsonBean.setChkDisabled(funcInfo.isChkDisabled());
			jsonBean.setName(funcInfo.getMuName());
		}

		return jsonBean;
	}

	/**
	 * 检查指定的MUID是否存在
	 *
	 * @param muId
	 * @return
	 * @throws Exception
	 */
	@Override
	public boolean getFuncMuIdExists(String muId) throws Exception
	{
		return tsFuncIfnoMapper.getFuncMuIdExists(muId);
	}

	/**
	 * 更新菜单信息
	 *
	 * @param parentId
	 * @param dbId
	 * @param newTreeList
	 * @throws Exception
	 */
	@Override
	public void updateFuncOrders(String parentId, String dbId, List<TsFuncIfno> newTreeList) throws Exception
	{
		//更新菜单父ID
		tsFuncIfnoMapper.updateSysFuncParentId(dbId,parentId);

		//更新菜单顺序
		tsFuncIfnoMapper.updateSysFuncOrder(newTreeList);
	}

	/**
	 * 读取角色下拉列表功能树JSON
	 *
	 * @param roleId
	 * @return
	 * @throws Exception
	 */
	@Override
	public String getRolesFuncTreeJson(String roleId,String isSuperUser) throws Exception
	{
		List<String> roleFuncList = null;
		List<TsFuncIfno> allFuncList = null;
		List<SysFuncSelectInfo> selectJsonList = new ArrayList<SysFuncSelectInfo>();

		//查询当前角色已经有的功能
		if(!StringUtils.isBlank(roleId))
		{
			roleFuncList = tsFuncIfnoMapper.listRoleFuncList(roleId);
		}

		//查询所有菜单
		allFuncList = listAllFuncList(isSuperUser);

		for(TsFuncIfno funcInfo : allFuncList)
		{
			packFuncSelectJsonList(funcInfo, roleFuncList, selectJsonList);
		}

		String jsonStr = JSON.toJSONString(selectJsonList);
		return jsonStr;
	}

	/**
	 * 組裝下拉框功能樹JSON LIST
	 * @param funcInfo
	 * @param roleFuncList
	 * @param jsonList
	 */
	private void packFuncSelectJsonList(TsFuncIfno funcInfo,List<String> roleFuncList,List<SysFuncSelectInfo> jsonList)
	{
		if(null == funcInfo)
		{
			return;
		}

		SysFuncSelectInfo selInfo = new SysFuncSelectInfo();
		selInfo.setId(funcInfo.getMuDbId());
		if(roleFuncList == null || roleFuncList.size() == 0)
		{
			selInfo.setChecked(false);
		}
		else
		{
			selInfo.setChecked(roleFuncList.contains(funcInfo.getMuDbId()));
		}
		selInfo.setText(funcInfo.getMuName());

		if(funcInfo.getChildFuncs() != null && funcInfo.getChildFuncs().size() > 0)
		{
			selInfo.setChildren(new ArrayList<SysFuncSelectInfo>());
			for(TsFuncIfno func : funcInfo.getChildFuncs())
			{
				packFuncSelectJsonList(func, roleFuncList, selInfo.getChildren());
			}
		}

		jsonList.add(selInfo);
	}

	/**
	 * 获取菜单树JSON字符串，并且默认选中此角色的功能
	 *
	 * @param roleId
	 * @return
	 * @throws Exception
	 */
	@Override
	public String getFuncJsonWithRole(String roleId,String isSuperUser) throws Exception
	{
		List<TsFuncIfno> funcList =  listAllFuncList(isSuperUser);
		List<String> roleFuncList = tsFuncIfnoMapper.listRoleFuncList(roleId);
		List<SysFuncJsonBean> jsonList = new ArrayList<SysFuncJsonBean>();
		TsFuncIfno root = new TsFuncIfno();
		root.setMuDbId("0");
		root.setMuName("根菜單");
		root.setMuParDbId("0");


		funcList.add(0,root);

		//处理角色选定菜单树
		handRoleFuncChecked(roleFuncList,funcList);

		if(funcList != null && funcList.size() > 0)
		{

			for(TsFuncIfno func : funcList)
			{
				packFuncTreeJsonBean(func, jsonList);
			}
		}

		String jsonStr = JSON.toJSONString(jsonList);
		return jsonStr;
	}

	private void handRoleFuncChecked(List<String> roleFuncList,List<TsFuncIfno> funcList)
	{
		for (TsFuncIfno func : funcList)
		{
			if (func.getChildFuncs() != null && func.getChildFuncs().size() > 0)
			{
				handRoleFuncChecked(roleFuncList,func.getChildFuncs());
			}

			if(checkRoleHasFunc(roleFuncList,func))
			{
				func.setChecked(true);
				func.setChkDisabled(true);
			}
		}
	}

	private boolean checkRoleHasFunc(List<String> roleFuncList,TsFuncIfno func)
	{
		if(roleFuncList != null && roleFuncList.size()>0)
		{
			for (String funcId : roleFuncList)
			{
				if (funcId.equals(func.getMuDbId()))
				{
					return true;
				}
			}
		}

		return false;
	}

	/**
	 * 查询用户的快捷菜单
	 *
	 * @param userId
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<TsFuncIfno> listUserQuickFuncList(String userId) throws Exception
	{
		List<TsFuncIfno> allFunc = null;

		allFunc = tsFuncIfnoMapper.listQuickFirstLevelFunc(userId);

		if(allFunc != null)
		{
			for(TsFuncIfno func : allFunc)
			{
				listQuickChildFuncInfo(func,userId);
			}
		}

		return allFunc;
	}

	private void listQuickChildFuncInfo(TsFuncIfno parentFunc,String userId) throws Exception
	{
		if(null != parentFunc)
		{
			List<TsFuncIfno> childFuncList = tsFuncIfnoMapper.listQuickChilddFunc(userId,parentFunc.getMuDbId());
			if(null != childFuncList && childFuncList.size() > 0)
			{
				parentFunc.setChildFuncs(childFuncList);
				for(TsFuncIfno func : childFuncList)
				{
					listQuickChildFuncInfo(func,userId);
				}
			}
		}
	}



	/**
	 * 查询用户角色的可显示 的菜单树
	 *
	 * @param userId
	 * @return
	 * @throws Exception
	 */
	@Override
	public String getUserQuickFuncTreeJson(String userId) throws Exception
	{
		List<TsFuncIfno> funcList =  listUserQuickFuncList(userId);
		List<SysFuncJsonBean> jsonList = new ArrayList<SysFuncJsonBean>();
		List<String> quiclLinkList = tsFuncIfnoMapper.listQuickLinkList(userId);
		TsFuncIfno root = new TsFuncIfno();
		root.setMuDbId("0");
		root.setMuName("根菜單");
		root.setMuParDbId("0");


		funcList.add(0,root);
		if(funcList != null && funcList.size() > 0)
		{

			for(TsFuncIfno func : funcList)
			{
				packQuickMenuTreeJsonBean(func, jsonList,quiclLinkList);
			}
		}

		String jsonStr = JSON.toJSONString(jsonList);
		return jsonStr;
	}

	/**
	 * 组装我的快捷菜单JSON
	 * @param funcInfo
	 * @param jsonList
	 */
	private void packQuickMenuTreeJsonBean(TsFuncIfno funcInfo, List<SysFuncJsonBean> jsonList, List<String> selList)
	{
		SysFuncJsonBean jsonBean = null;

		if(funcInfo != null)
		{
			if(StringUtils.isEmpty(funcInfo.getMuUrl()) && !"1".equals(funcInfo.getMuQuickLink()))
			{
				funcInfo.setChkDisabled(true);
			}

			if(selList != null && selList.size() > 0)
			{
				for (String funcId : selList)
				{
					if (funcId.equals(funcInfo.getMuDbId()))
					{
						funcInfo.setChecked(true);
						break;
					}
				}
			}

			jsonBean = packFuncToJson(funcInfo);
			if(null != jsonBean)
			{
				jsonList.add(jsonBean);

				List<TsFuncIfno> funcList = funcInfo.getChildFuncs();
				if(funcList != null && funcList.size() > 0)
				{
					for(TsFuncIfno func : funcList)
					{
						packQuickMenuTreeJsonBean(func, jsonList,selList);
					}
				}
			}
		}
	}

	/**
	 * 添加快捷菜单
	 *
	 * @param userId
	 * @param funcId
	 * @throws Exception
	 */
	@Override
	public void addQuickLinkFunc(String userId, String funcId) throws Exception
	{
		tsFuncIfnoMapper.addQuickLinkFunc(userId,funcId);
	}

	/**
	 * 删除快捷菜单
	 *
	 * @param userId
	 * @param funcId
	 * @throws Exception
	 */
	@Override
	public void delQuickLinkFunc(String userId, String funcId) throws Exception
	{
		tsFuncIfnoMapper.delQuickLinkFunc(userId, funcId);
	}

	/**
	 * 查询用户的快捷菜单
	 *
	 * @param userId
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<TsFuncIfno> listQucikFunc(String userId) throws Exception
	{
		return tsFuncIfnoMapper.listQucikFunc(userId);
	}

	/**
	 * 根据菜单ID获取菜单信息
	 *
	 * @param muId
	 * @return
	 */
	@Override
	public TsFuncIfno getFuncFromId(String muId) throws Exception
	{
		return tsFuncIfnoMapper.getFuncFromId(muId);
	}
}
