package com.efs.bus.libary.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.efs.bus.lib.addr.mapper.LibShelfAddInfo;
import com.efs.bus.lib.addr.mapper.LibShelfAddInfoMapper;
import com.efs.common.Util.SysUtils;
import com.xwh.util.EFSUtil;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.efs.bus.libary.mapper.LibShelfInfoMapper;
import com.efs.bus.libary.mapper.LibShelfInfo;
import com.efs.common.database.Page;
import com.efs.common.database.PageDataBunder;

@Service("libShelfInfoService")
public class LibShelfInfoServiceImpl implements LibShelfInfoService
{
	@Resource(name="libShelfInfoMapper")
	private LibShelfInfoMapper libShelfInfoMapper;

	@Resource(name="libShelfAddInfoMapper")
	private LibShelfAddInfoMapper libShelfAddInfoMapper;
	
	@Override
	public LibShelfInfo getLibShelfInfo(String lsNo) throws Exception
	{
		return libShelfInfoMapper.getLibShelfInfo(lsNo);
	}

	@Override
	public void addLibShelfInfo(LibShelfInfo libShelfInfo,List<String> addrList) throws Exception
	{
		//添加书架信息
		libShelfInfoMapper.addLibShelfInfo(libShelfInfo);

		//删除书架地址信息
		libShelfAddInfoMapper.deleteLibAddrWithShelf(libShelfInfo.getLsNo());


		//添加书架地址信息
		List<LibShelfAddInfo> addList = packShelfAdd(addrList,libShelfInfo);
		libShelfAddInfoMapper.addLibShelfAddInfo(addList);
	}

	@Override
	public void updateLibShelfInfo(LibShelfInfo libShelfInfo) throws Exception
	{
		libShelfInfoMapper.updateLibShelfInfo(libShelfInfo);
	}

	@Override
	public void deleteLibShelfInfo(String lsNo) throws Exception
	{
		libShelfInfoMapper.deleteLibShelfInfo(lsNo);

		libShelfAddInfoMapper.deleteLibAddrWithShelf(Integer.parseInt(lsNo));
	}

	@Override
	public PageDataBunder listLibShelfInfo(LibShelfInfo paramBean,Page page) throws Exception
	{
		return libShelfInfoMapper.listLibShelfInfo(paramBean,page);
	}

	/**
	 * 获取下一个书架号
	 *
	 * @return
	 * @throws Exception
	 */
	@Override
	public int getNexShelfNo() throws Exception
	{
		return libShelfInfoMapper.getNexShelfNo();
	}

	private List<LibShelfAddInfo> packShelfAdd(List<String> addrList,LibShelfInfo libShelfInfo)
	{
		List<LibShelfAddInfo> addInfoList = new ArrayList<>();
		if(addrList != null && addrList.size() >0)
		{
			for(String str : addrList)
			{
				LibShelfAddInfo addInfo = new LibShelfAddInfo();
				addInfo.setSiCode(str);
				addInfo.setSiStatus("0");
				addInfo.setAddUser(libShelfInfo.getAddUser());
				addInfo.setAddDate(EFSUtil.getSysFormatDate());
				addInfo.setAddTime(EFSUtil.getSysFormatTime());

				addInfoList.add(addInfo);
			}
		}

		return addInfoList;
	}

	/**
	 * 列举所有的书架信息
	 *
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<LibShelfInfo> listAllShelf() throws Exception
	{
		return libShelfInfoMapper.listAllShelf();
	}

	@Override
	public List<LibShelfAddInfo> listAllAddr() throws Exception
	{
		return libShelfInfoMapper.listAllAddr();
	}
}
