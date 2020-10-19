package com.efs.bus.office.message.mapper;

import com.efs.common.database.Page;
import com.efs.common.database.PageDataBunder;

import java.util.List;


/**
 * 
 * com.efs.bus.office.message.mapper.TsMessageInfoMapper
 * @author xwh
 * 2018-05-24 13:41:27
 * 系统通知消息表
 *
 */
public interface TsMessageInfoMapper
{
	/**
	 * 根据主键ID获取TsMessageInfo
	 * @param miCode
	 * @return
	 */
	public TsMessageInfo getTsMessageInfo(String miCode) throws Exception;
	
	/**
	 * 增加TsMessageInfo
	 * @param tsMessageInfo
	 */
	public void addTsMessageInfo(TsMessageInfo tsMessageInfo) throws Exception;
	
	/**
	 * 更新TsMessageInfo
	 * @param empBean
	 */
	public void updateTsMessageInfo(TsMessageInfo tsMessageInfo) throws Exception;
	
	/**
	 * 删除TsMessageInfo
	 * @param miCode
	 */
	public void deleteTsMessageInfo(String miCode) throws Exception;
	
	
	/**
	 * 列举员工信息，带分页
	 * @param TsMessageInfo
	 * @return
	 */
	public PageDataBunder listTsMessageInfo(TsMessageInfo paramBean, Page page) throws Exception;

	/**
	 * 查询首页显示的通知信息
	 * showType=1:显示最近的10，2：显示所有的
	 * @param userType
	 * @return
	 * @throws Exception
	 */
	public List<TsMessageInfo> listMyMessage(String showType,String userType) throws Exception;

	/**
	 * 检查该通知是否是指定用户所发
	 * @param miCode
	 * @param userId
	 * @return
	 * @throws Exception
	 */
	boolean checkUserIssueMessage(String miCode,String userId) throws Exception;
}
