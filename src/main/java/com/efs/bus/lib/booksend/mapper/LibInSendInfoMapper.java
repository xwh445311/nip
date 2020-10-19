package com.efs.bus.lib.booksend.mapper;

import java.util.List;
import java.util.Map;

import com.efs.common.database.Page;
import com.efs.common.database.PageDataBunder;


/**
 * 
 * com.efs.bus.lib.booksend.mapper.LibInSendInfoMapper
 * @author xwh
 * 2018-04-04 15:23:31
 * 在借图书信息表
 *
 */
public interface LibInSendInfoMapper
{
	/**
	 * 根据主键ID获取LibInSendInfo
	 * @param isId
	 * @return
	 */
	public LibInSendInfo getLibInSendInfo(String isId) throws Exception;
	
	/**
	 * 增加LibInSendInfo
	 * @param libInSendInfo
	 */
	public void addLibInSendInfo(LibInSendInfo libInSendInfo) throws Exception;
	
	/**
	 * 更新LibInSendInfo
	 * @param empBean
	 */
	public void updateLibInSendInfo(LibInSendInfo libInSendInfo) throws Exception;
	
	/**
	 * 删除LibInSendInfo
	 * @param isId
	 */
	public void deleteLibInSendInfo(String isId) throws Exception;
	
	
	/**
	 * 列举员工信息，带分页
	 * @param LibInSendInfo
	 * @return
	 */
	public PageDataBunder listUserInSendInfo(String userId, Page page) throws Exception;

	/**
	 * 检查用户是否可以借阅某本书
	 * @param userId
	 * @param bookCode
	 * @return
	 * 00：可以借
	 * 01：用于没有借书的权限
	 * 02：该图书已经借出
	 * 03：用户的图书已经借满
	 * 04：用户存在挂失未处理的图书
	 * 05：该图书已经丢失或作废，不可再借
	 * @throws Exception
	 */
	public String checkUserSendBook(String userId,String bookCode) throws Exception;

	/**
	 * 获得借书人的用户信息
	 * @param userId
	 * @return
	 * @throws Exception
	 */
	public LibInSendInfo getSendUserInfo(String userId) throws Exception;

	/**
	 * 检查用户是否可以归还图书<br/>
	 * @param userId
	 * @param bookCode
	 * @return
	 * 00:可归还<br/>
	 * 01：图书尚未入库<br/>
	 * 02：图书尚未借出<br/>
	 * 03：图书不是由当前用户借出<br/>
	 * @throws Exception
	 */
	public String checkUserBackBook(String userId,String bookCode) throws Exception;


	/**
	 * 进行图书归还动作
	 * @param libInSendInfo
	 * @throws Exception
	 */
	void doBacckBook(LibInSendInfo libInSendInfo) throws Exception;

	/**
	 * 图书挂失
	 * @param libInSendInfo
	 * @throws Exception
	 */
	void doRegLosBook(LibInSendInfo libInSendInfo) throws Exception;

	/**
	 * 处理图书解挂流程
	 * @param libInSendInfo
	 * @throws Exception
	 */
	void doCompBook(LibInSendInfo libInSendInfo) throws Exception;

	/**
	 * 检查用户是否可以解挂图书<br/>
	 * @param userId
	 * @param bookCode
	 * @return
	 * 00:可归还<br/>
	 * 01：图书尚未入库<br/>
	 * 02：图书尚未挂失<br/>
	 * 03：图书不是由当前用户挂失<br/>
	 * @throws Exception
	 */
	String checkUserCompBook(String userId,String bookCode) throws Exception;

	/**
	 * 查询用户的借阅记录
	 * @param LibInSendInfo
	 * @return
	 */
	public PageDataBunder listUserAllSendInfo(LibInSendInfo libInSendInfo, Page page) throws Exception;
	
}
