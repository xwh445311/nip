package com.efs.bus.lib.booktype.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.efs.bus.lib.bookinfo.mapper.LibBooksInfo;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.efs.bus.lib.booktype.mapper.LibBookTypeInfoMapper;
import com.efs.bus.lib.booktype.mapper.LibBookTypeInfo;
import com.efs.common.database.Page;
import com.efs.common.database.PageDataBunder;

@Service("libBookTypeInfoService")
public class LibBookTypeInfoServiceImpl implements LibBookTypeInfoService
{
	@Resource(name="libBookTypeInfoMapper")
	private LibBookTypeInfoMapper libBookTypeInfoMapper;
	
	@Override
	public LibBookTypeInfo getLibBookTypeInfo(String btId) throws Exception
	{
		return libBookTypeInfoMapper.getLibBookTypeInfo(btId);
	}

	@Override
	public void addLibBookTypeInfo(LibBookTypeInfo libBookTypeInfo) throws Exception
	{
		libBookTypeInfoMapper.addLibBookTypeInfo(libBookTypeInfo);
	}

	@Override
	public void updateLibBookTypeInfo(LibBookTypeInfo libBookTypeInfo) throws Exception
	{
		libBookTypeInfoMapper.updateLibBookTypeInfo(libBookTypeInfo);
	}

	@Override
	public void deleteLibBookTypeInfo(String btId) throws Exception
	{
		libBookTypeInfoMapper.deleteLibBookTypeInfo(btId);
	}

	@Override
	public List<LibBookTypeInfo> listLibBookTypeInfo(LibBookTypeInfo paramBean) throws Exception
	{
		List<LibBookTypeInfo> typeInfoList = libBookTypeInfoMapper.listLibBookTypeInfo(paramBean);
		if(typeInfoList != null && typeInfoList.size() > 0)
		{
			for (LibBookTypeInfo bookTypeInfo : typeInfoList)
			{
				paramBean.setBtId(bookTypeInfo.getBtId());
				bookTypeInfo.setChildren(libBookTypeInfoMapper.listChildrenBookType(paramBean));
			}
		}
		return typeInfoList;
	}

	/**
	 * 获取下一下数据库主键
	 *
	 * @return
	 * @throws Exception
	 */
	@Override
	public Integer getNextDbId() throws Exception
	{
		return libBookTypeInfoMapper.getNextDbId();
	}

	@Override
	public List<LibBookTypeInfo> listAllChildBookType() throws Exception
	{
		return libBookTypeInfoMapper.listAllChildBookType();
	}
}
