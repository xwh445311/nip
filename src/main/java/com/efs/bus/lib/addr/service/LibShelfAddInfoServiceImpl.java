package com.efs.bus.lib.addr.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.efs.bus.lib.addr.mapper.LibShelfAddInfoMapper;
import com.efs.bus.lib.addr.mapper.LibShelfAddInfo;
import com.efs.common.database.Page;
import com.efs.common.database.PageDataBunder;

@Service("libShelfAddInfoService")
public class LibShelfAddInfoServiceImpl implements LibShelfAddInfoService
{
	@Resource(name="libShelfAddInfoMapper")
	private LibShelfAddInfoMapper libShelfAddInfoMapper;
	
	@Override
	public LibShelfAddInfo getLibShelfAddInfo(String siCode) throws Exception
	{
		return libShelfAddInfoMapper.getLibShelfAddInfo(siCode);
	}

	@Override
	public void addLibShelfAddInfo(List<LibShelfAddInfo> libShelfAddInfoList) throws Exception
	{
		if(libShelfAddInfoList != null && libShelfAddInfoList.size() > 0)
		{
			LibShelfAddInfo info = libShelfAddInfoList.get(0);
			int shelfNo = Integer.parseInt(info.getSiCode().substring(0,2));
			libShelfAddInfoMapper.deleteLibAddrWithShelf(shelfNo);

			libShelfAddInfoMapper.addLibShelfAddInfo(libShelfAddInfoList);
		}

	}

	@Override
	public void updateLibShelfAddInfo(LibShelfAddInfo libShelfAddInfo) throws Exception
	{
		libShelfAddInfoMapper.updateLibShelfAddInfo(libShelfAddInfo);
	}

	@Override
	public void deleteLibShelfAddInfo(String siCode) throws Exception
	{
		libShelfAddInfoMapper.deleteLibShelfAddInfo(siCode);
	}

	@Override
	public PageDataBunder listLibShelfAddInfo(LibShelfAddInfo paramBean,Page page) throws Exception
	{
		return libShelfAddInfoMapper.listLibShelfAddInfo(paramBean,page);
	}
	
}
