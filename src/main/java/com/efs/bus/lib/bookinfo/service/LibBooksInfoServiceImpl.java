package com.efs.bus.lib.bookinfo.service;

import com.efs.bus.lib.bookinfo.mapper.LibBooksInfo;
import com.efs.bus.lib.bookinfo.mapper.LibBooksInfoMapper;
import com.efs.bus.lib.booktype.mapper.LibBookTypeInfo;
import com.efs.bus.lib.booktype.mapper.LibBookTypeInfoMapper;
import com.efs.bus.libary.mapper.LibShelfInfoMapper;
import com.efs.bus.util.BusConstant;
import com.efs.bus.util.BusUtil;
import com.efs.common.database.Page;
import com.efs.common.database.PageDataBunder;
import com.xwh.bean.SelectBean;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

@Service("libBooksInfoService")
public class LibBooksInfoServiceImpl implements LibBooksInfoService
{
	@Resource(name="libBooksInfoMapper")
	private LibBooksInfoMapper libBooksInfoMapper;

	@Resource(name="libBookTypeInfoMapper")
	private LibBookTypeInfoMapper libBookTypeInfoMapper;

	@Resource(name="libShelfInfoMapper")
	private LibShelfInfoMapper libShelfInfoMapper;
	
	@Override
	public LibBooksInfo getLibBooksInfo(String biCode) throws Exception
	{
		return libBooksInfoMapper.getLibBooksInfo(biCode);
	}

	@Override
	public void addLibBooksInfo(List<LibBooksInfo> libBookInfoList) throws Exception
	{

		libBooksInfoMapper.addLibBooksInfo(libBookInfoList);

		//更新书架使用状态

		libBookInfoList.forEach(item->{
			try
			{
				libShelfInfoMapper.updateAddUseStatus(item.getBiAddr(),BusConstant.ADDR_STATUS_INUSE);
			}
			catch (Exception ex)
			{
				throw new RuntimeException(ex);
			}
		});
	}

	@Override
	public void updateLibBooksInfo(LibBooksInfo libBooksInfo) throws Exception
	{
		libBooksInfoMapper.updateLibBooksInfo(libBooksInfo);
	}

	@Override
	public void deleteLibBooksInfo(LibBooksInfo libBooksInfo) throws Exception
	{

		LibBooksInfo dbBook = libBooksInfoMapper.getLibBooksInfo(libBooksInfo.getBiCode());

		if(BusUtil.checkBookDelete(dbBook))
		{
			//将图书信息移动删除表中
			libBooksInfoMapper.addToDelInfo(libBooksInfo);

			//删除原表中的图书
			libBooksInfoMapper.deleteLibBooksInfo(libBooksInfo.getBiCode());
		}

	}

	@Override
	public PageDataBunder listLibBooksInfo(LibBooksInfo paramBean,Page page) throws Exception
	{
		return libBooksInfoMapper.listLibBooksInfo(paramBean,page);
	}

	@Override
	public LibBooksInfo findBookInfoFromISBN(String isbn) throws Exception
	{
		LibBooksInfo libBooksInfo;
		List<LibBookTypeInfo> libBookTypeInfoList = libBookTypeInfoMapper.listAllChildBookType();

		//先检查本地是否已经有了一类书
		LibBooksInfo locLibBooksInfo = libBooksInfoMapper.findLibBooksInfoFromIsbn(isbn);

		if(locLibBooksInfo != null)
		{
			//本地已经 找到，可以返回
			libBooksInfo = copyBooksInfo(locLibBooksInfo);
			return libBooksInfo;
		}

		//本地未找到，从豆瓣上去找
		libBooksInfo = BusUtil.getBooksInfoFromDouBan(isbn,libBookTypeInfoList);

		return libBooksInfo;
	}



	/**
	 * 将原来的BOOK的部分属性复制给对象图书类型
	 * @param resBooksInfo
	 * @param libBooksInfo
	 */
	private LibBooksInfo copyBooksInfo(LibBooksInfo resBooksInfo)
	{
		LibBooksInfo libBooksInfo;

		if(null == resBooksInfo)
		{
			return null;
		}

		libBooksInfo = new LibBooksInfo();

		libBooksInfo.setBiIsbn(resBooksInfo.getBiIsbn());
		libBooksInfo.setBiAuth(resBooksInfo.getBiAuth());
		libBooksInfo.setBiPublishDate(resBooksInfo.getBiPublishDate());
		libBooksInfo.setBiRemSmImg(resBooksInfo.getBiRemSmImg());
		libBooksInfo.setBiTranslater(resBooksInfo.getBiTranslater());
		libBooksInfo.setBiPageCount(resBooksInfo.getBiPageCount());
		libBooksInfo.setBiRemLgImg(resBooksInfo.getBiRemLgImg());
		libBooksInfo.setBiPress(resBooksInfo.getBiPress());
		libBooksInfo.setBiName(resBooksInfo.getBiName());
		libBooksInfo.setBiPrice(resBooksInfo.getBiPrice());
		libBooksInfo.setBiBookBrief(resBooksInfo.getBiBookBrief());
		libBooksInfo.setBiType(resBooksInfo.getBiType());
		libBooksInfo.setBiTypeCode(resBooksInfo.getBiTypeCode());
		libBooksInfo.setBiOriName(resBooksInfo.getBiOriName());
		libBooksInfo.setBiBookCata(resBooksInfo.getBiBookCata());
		libBooksInfo.setBiBookSize(resBooksInfo.getBiBookSize());
		libBooksInfo.setBiEbookUrl(resBooksInfo.getBiEbookUrl());
		libBooksInfo.setBiAuthInfo(resBooksInfo.getBiAuthInfo());

		return libBooksInfo;
	}

    @Override
    public List<SelectBean> listBookPress() throws Exception
    {
        List<String> strList = libBooksInfoMapper.listLibPress();
        List<SelectBean> pressList = strList.stream().map(item->{
            SelectBean sb = new SelectBean();
            sb.setKey(item);
            sb.setValue(item);
            return sb;
        }).collect(Collectors.toList());


        return pressList;
    }

	/**
	 * 检查图书是在借阅中出现过
	 *
	 * @param biCode
	 * @return
	 * @throws Exception
	 */
	@Override
	public boolean checkBookInSend(String biCode) throws Exception
	{
		return libBooksInfoMapper.checkBookInSend(biCode) > 0 ? true : false;
	}
}
