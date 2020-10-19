package com.efs.common.auth.user.service;

import com.efs.bus.edu.classes.mapper.BaseSchClassInfo;
import com.efs.bus.edu.classes.mapper.BaseSchClassInfoMapper;
import com.efs.bus.edu.course.mapper.BaseSchScoreInfoMapper;
import com.efs.bus.edu.semcal.mapper.BaseSemesterCal;
import com.efs.bus.edu.semcal.mapper.BaseSemesterCalMapper;
import com.efs.bus.util.BusConstant;
import com.efs.common.Util.IDUtil;
import com.efs.common.Util.SysConstant;
import com.efs.common.auth.user.mapper.TsUserInfo;
import com.efs.common.auth.user.mapper.TsUserInfoMapper;
import com.efs.common.database.Page;
import com.efs.common.database.PageDataBunder;
import com.xwh.bean.SelectBean;
import com.xwh.util.EFSUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service("tsUserInfoService")
public class TsUserInfoServiceImpl implements TsUserInfoService
{
	@Resource(name="tsUserInfoMapper")
	private TsUserInfoMapper tsUserInfoMapper;

	@Resource(name="baseSchClassInfoMapper")
	private BaseSchClassInfoMapper baseSchClassInfoMapper;

	@Resource(name="baseSemesterCalMapper")
	private BaseSemesterCalMapper baseSemesterCalMapper;

	@Resource(name="baseSchScoreInfoMapper")
	private BaseSchScoreInfoMapper baseSchScoreInfoMapper;
	
	@Override
	public TsUserInfo getTsUserInfo(String dbId) throws Exception
	{
		TsUserInfo tsUserInfo = tsUserInfoMapper.getTsUserInfo(dbId);
		return tsUserInfo;
	}

	@Override
	public void addTsUserInfo(TsUserInfo tsUserInfo) throws Exception
	{
		//添加用戶基本信息
		tsUserInfoMapper.addTsUserInfo(tsUserInfo);
	}

	@Override
	public void updateTsUserInfo(TsUserInfo tsUserInfo) throws Exception
	{
		tsUserInfoMapper.updateTsUserInfo(tsUserInfo);
	}

	@Override
	public void deleteTsUserInfo(String uiId) throws Exception
	{
		tsUserInfoMapper.deleteTsUserInfo(uiId);
		tsUserInfoMapper.deleteUserRole(uiId);
	}

	@Override
	public PageDataBunder listTsUserInfo(TsUserInfo paramBean, Page page) throws Exception
	{
		return tsUserInfoMapper.listTsUserInfo(paramBean,page);
	}

	@Override
	public void updateUserLoginInfo(TsUserInfo tsUserInfo) throws Exception
	{
		tsUserInfoMapper.updateUserLoginInfo(tsUserInfo);
	}

	/**
	 * 添加或更新用戶角色信息
	 *
	 * @param tsUserInfo
	 * @throws Exception
	 */
	@Override
	public void addUserRole(TsUserInfo tsUserInfo) throws Exception
	{
		//刪除舊有角色
		tsUserInfoMapper.deleteUserRole(tsUserInfo.getUiId());

		//添加新的角色
		tsUserInfoMapper.addUserRole(tsUserInfo.getUiId(),tsUserInfo.getUiRoles());
	}

	@Override
	public void addUsserOrgs(TsUserInfo tsUserInfo) throws Exception
	{
		//删除旧有机构
		tsUserInfoMapper.deleteUserOrgs(tsUserInfo.getUiId());

		//新增机构
		tsUserInfoMapper.addUserOrgs(tsUserInfo.getUiId(),tsUserInfo.getUserOrgList());
	}

	/**
	 * 查询学生信息，带分页
	 *
	 * @param paramBean
	 * @param page
	 * @return
	 */
	@Override
	public PageDataBunder listStudentInfo(TsUserInfo paramBean, Page page) throws Exception
	{
		return tsUserInfoMapper.listStudentInfo(paramBean, page);
	}

	/**
	 * 查询所有在职的教师信息
	 *
	 * @param paramBean
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<TsUserInfo> listTeacherInfoNoPage(TsUserInfo paramBean) throws Exception
	{
		return tsUserInfoMapper.listTeacherInfoNoPage(paramBean);
	}

	/**
	 * 修改学生信息
	 *
	 * @param paramBean
	 * @throws Exception
	 */
	@Override
	public void updateStudentInfo(TsUserInfo paramBean) throws Exception
	{
		tsUserInfoMapper.updateStudentInfo(paramBean);

		if("02,04".contains(paramBean.getUsSchStatus()))
		{
			//对于离校学生，将用户失效
			paramBean.setUiStatus("0");
			List<TsUserInfo> userInfoList = new ArrayList<>();
			userInfoList.add(paramBean);

			tsUserInfoMapper.updateUserStatus(userInfoList);
		}
	}

	/**
	 * 批量上传学生信息
	 *
	 * @param studentList
	 * @param loginUserId
	 * @throws Exception
	 */
	@Override
	public void addBatchStudentInfo(List<TsUserInfo> studentList, String loginUserId) throws Exception
	{
		if(studentList != null && studentList.size() > 0)
		{

			for (TsUserInfo tsUserInfo:studentList)
			{
				tsUserInfo.setUiAddUser(loginUserId);
				tsUserInfo.setUiUpdUser(loginUserId);

				//对于新增用户，密码默认使用用户名
				tsUserInfo.setUiPassword(tsUserInfo.getUiId());

				//默认角色为学生
				tsUserInfo.setUiBusType(SysConstant.USER_BUS_TYPE_STUDENT);
				tsUserInfo.setUserRoles(new String[]{BusConstant.ROLE_STUDENT_ID});
				tsUserInfo.setUiStatus("1");
				tsUserInfo.setUiMobile(tsUserInfo.getUsFirstPhone());

				tsUserInfo.specHand4Save();

				addTsUserInfo(tsUserInfo);
				addUserRole(tsUserInfo);
				addUsserOrgs(tsUserInfo);
			}
		}
	}

	/**
	 * 列举教师信息列表
	 *
	 * @param paramBean
	 * @param page
	 * @return
	 * @throws Exception
	 */
	@Override
	public PageDataBunder listTeacherInfo(TsUserInfo paramBean, Page page) throws Exception
	{
		return tsUserInfoMapper.listTeacherInfo(paramBean, page);
	}

	/**
	 * 批量保存教师信息
	 *
	 * @param teacherList
	 * @param loginUserId
	 * @throws Exception
	 */
	@Override
	public void addBatchTeacherInfo(List<TsUserInfo> teacherList, String loginUserId) throws Exception
	{
		if(teacherList != null && teacherList.size() > 0)
		{

			for (TsUserInfo tsUserInfo:teacherList)
			{
				tsUserInfo.setUiId(IDUtil.getId("ID_SYS_USER_ID"));
				tsUserInfo.setUiAddUser(loginUserId);
				tsUserInfo.setUiUpdUser(loginUserId);

				//对于新增用户，密码默认使用用户名
				tsUserInfo.setUiPassword(tsUserInfo.getUiId());

				//默认角色为学生
				tsUserInfo.setUiBusType(SysConstant.USER_BUS_TYPE_TEACHER);
				tsUserInfo.setUserRoles(new String[]{BusConstant.ROLE_TEACHER_ID});
				tsUserInfo.setUiStatus("1");

				tsUserInfo.specHand4Save();

				addTsUserInfo(tsUserInfo);
				addUserRole(tsUserInfo);
				addUsserOrgs(tsUserInfo);
			}
		}
	}

	/**
	 * 检查简称是否已经存在，如果为NULL，也返回不存在
	 *
	 * @param uiShortName
	 * @throws Exception
	 */
	@Override
	public boolean checkShortNameExist(String uiShortName,String userId) throws Exception
	{
		if(StringUtils.isEmpty(uiShortName))
		{
			return false;
		}


		return tsUserInfoMapper.checkShortNameExist(uiShortName,userId);
	}

	/**
	 * 修改教师信息
	 *
	 * @param paramBean
	 * @throws Exception
	 */
	@Override
	public void updateTeacherInfo(TsUserInfo paramBean) throws Exception
	{
		tsUserInfoMapper.updateTeacherInfo(paramBean);

		if(!"01".equals(paramBean.getUtWorkStatus()))
		{
			//对于非在职的人员，将用户失效
			paramBean.setUiStatus("0");
			List<TsUserInfo> userInfoList = new ArrayList<>();
			userInfoList.add(paramBean);

			tsUserInfoMapper.updateUserStatus(userInfoList);
		}
	}

	/**
	 * 查询学生信息不带分布
	 *
	 * @param paramBean
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<TsUserInfo> listStudentNoPage(TsUserInfo paramBean) throws Exception
	{
		return tsUserInfoMapper.listStudentNoPage(paramBean);
	}

	/**
	 * 修改用户密码
	 *
	 * @param uiId
	 * @param password
	 * @throws Exception
	 */
	@Override
	public void updateUserPassword(String uiId, String password) throws Exception
	{
		tsUserInfoMapper.updateUserPassword(uiId, password);
	}

	/**
	 * 查询快捷通讯录
	 *
	 * @param keyWork
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<TsUserInfo> listAddressBook(String keyWork) throws Exception
	{
		return tsUserInfoMapper.listAddressBook(keyWork);
	}

	/**
	 * 用户首次更新密码
	 *
	 * @param uiId
	 * @param password
	 * @throws Exception
	 */
	@Override
	public void updateUserPasswordFirst(String uiId, String password) throws Exception
	{
		tsUserInfoMapper.updateUserPasswordFirst(uiId, password);
	}

	/**
	 * 重置用户的密码
	 *
	 * @param uiId
	 * @param password
	 * @throws Exception
	 */
	@Override
	public void updateResetPassword(String uiId, String password) throws Exception
	{
		tsUserInfoMapper.updateResetPassword(uiId, password);
	}

	@Override
	public List<TsUserInfo> listUserInOrg(String userOrg)
	{
		return tsUserInfoMapper.listUserInOrg(userOrg);
	}

	@Override
	public List<SelectBean> listUserInOrgSelect(String userOrg) throws Exception
	{
		List<TsUserInfo> tsUserInfoList = tsUserInfoMapper.listUserInOrg(userOrg);
		return EFSUtil.convertBeanToSelectBean(tsUserInfoList,"uiId","uiName");
	}
}
