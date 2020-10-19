package com.efs.bus.lib.booksend.service;

import com.efs.bus.lib.bookinfo.mapper.LibBooksInfoMapper;
import com.efs.bus.lib.booksend.mapper.LibInSendInfo;
import com.efs.bus.lib.booksend.mapper.LibInSendInfoMapper;
import com.efs.bus.util.BusConstant;
import com.efs.common.database.Page;
import com.efs.common.database.PageDataBunder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("libInSendInfoService")
public class LibInSendInfoServiceImpl implements LibInSendInfoService
{
	@Resource(name="libInSendInfoMapper")
	private LibInSendInfoMapper libInSendInfoMapper;

	@Resource(name="libBooksInfoMapper")
	private LibBooksInfoMapper libBooksInfoMapper;
	
	@Override
	public LibInSendInfo getLibInSendInfo(String isId) throws Exception
	{
		return libInSendInfoMapper.getLibInSendInfo(isId);
	}

	@Override
	public void addLibInSendInfo(LibInSendInfo libInSendInfo) throws Exception
	{
		libInSendInfoMapper.addLibInSendInfo(libInSendInfo);
	}

	@Override
	public void updateLibInSendInfo(LibInSendInfo libInSendInfo) throws Exception
	{
		libInSendInfoMapper.updateLibInSendInfo(libInSendInfo);
	}

	@Override
	public void deleteLibInSendInfo(String isId) throws Exception
	{
		libInSendInfoMapper.deleteLibInSendInfo(isId);
	}

	@Override
	public PageDataBunder listUserInSendInfo(String userId, Page page) throws Exception
	{
		return libInSendInfoMapper.listUserInSendInfo(userId,page);
	}

	/**
	 * 检查用户是否可以借阅某本书
	 *
	 * @param userId
	 * @param bookCode
	 * @return
	 * 00：可以借<br/>
	 * 01：用于没有借书的权限<br/>
	 * 02：该图书已经借出<br/>
	 * 03：用户的图书已经借满<br/>
	 * 04：用户存在挂失未处理的图书<br/>
	 * 05：该图书已经丢失或作废，不可再借<br/>
	 * @throws Exception
	 */
	@Override
	public String checkUserSendBook(String userId, String bookCode) throws Exception
	{
		return libInSendInfoMapper.checkUserSendBook(userId,bookCode);
	}

	@Override
	public LibInSendInfo getSendUserInfo(String userId) throws Exception
	{
		return libInSendInfoMapper.getSendUserInfo(userId);
	}

	/**
	 * 借阅图书
	 *
	 * @param libInSendInfo
	 * @throws Exception
	 */
	@Override
	public void donSendBooks(LibInSendInfo libInSendInfo) throws Exception
	{
		//插入到借阅表
		libInSendInfoMapper.addLibInSendInfo(libInSendInfo);

		//更新图书表状态
		libBooksInfoMapper.updateBookStatus(libInSendInfo.getIsBookCode(),BusConstant.BOOK_STATUS_SEND);

	}

	/**
	 * 检查用户是否可以归还图书<br/>
	 *
	 * @param userId
	 * @param bookCode
	 * @return 00:可归还<br/>
	 * 01：图书尚未入库<br/>
	 * 02：图书尚未借出<br/>
	 * 03：图书不是由当前用户借出<br/>
	 * @throws Exception
	 */
	@Override
	public String checkUserBackBook(String userId, String bookCode) throws Exception
	{
		return libInSendInfoMapper.checkUserBackBook(userId, bookCode);
	}

	/**
	 * 归还图书
	 *
	 * @param libInSendInfo
	 * @throws Exception
	 */
	@Override
	public void donBackBooks(LibInSendInfo libInSendInfo) throws Exception
	{
		//处理还书信息
		libInSendInfoMapper.doBacckBook(libInSendInfo);

		//更新图书表状态
		libBooksInfoMapper.updateBookStatus(libInSendInfo.getIsBookCode(),BusConstant.BOOK_STATUS_INLIB);
	}

	/**
	 * 图书挂失
	 *
	 * @param libInSendInfo
	 * @throws Exception
	 */
	@Override
	public void donRegLosBook(LibInSendInfo libInSendInfo) throws Exception
	{
		//处理还书信息
		libInSendInfoMapper.doRegLosBook(libInSendInfo);

		//更新图书表状态
		libBooksInfoMapper.updateBookStatus(libInSendInfo.getIsBookCode(),BusConstant.BOOK_STATUS_REGLOSE);
	}

	/**
	 * 处理图书解挂流程
	 *
	 * @param libInSendInfo
	 * @throws Exception
	 */
	@Override
	public void donCompBook(LibInSendInfo libInSendInfo) throws Exception
	{
		libInSendInfoMapper.doCompBook(libInSendInfo);
	}

	/**
	 * 检查用户是否可以解挂图书<br/>
	 *
	 * @param userId
	 * @param bookCode
	 * @return 00:可归还<br/>
	 * 01：图书尚未入库<br/>
	 * 02：图书尚未挂失<br/>
	 * 03：图书不是由当前用户挂失<br/>
	 * @throws Exception
	 */
	@Override
	public String checkUserCompBook(String userId, String bookCode) throws Exception
	{
		return libInSendInfoMapper.checkUserCompBook(userId, bookCode);
	}

	/**
	 * 查询用户的借阅记录
	 *
	 * @param libInSendInfo
	 * @param page
	 * @return
	 */
	@Override
	public PageDataBunder listUserAllSendInfo(LibInSendInfo libInSendInfo, Page page) throws Exception
	{
		return libInSendInfoMapper.listUserAllSendInfo(libInSendInfo,page);
	}
}
