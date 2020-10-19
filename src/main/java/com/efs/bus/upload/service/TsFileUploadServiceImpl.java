package com.efs.bus.upload.service;

import java.io.File;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.efs.bus.upload.mapper.TsFileUploadMapper;
import com.efs.bus.upload.mapper.TsFileUpload;

import com.efs.common.Util.IDUtil;
import com.efs.common.database.Page;
import com.efs.common.database.PageDataBunder;
import com.xwh.util.EFSUtil;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

@Service("tsFileUploadService")
public class TsFileUploadServiceImpl implements TsFileUploadService
{
	@Resource(name="tsFileUploadMapper")
	private TsFileUploadMapper tsFileUploadMapper;
	
	@Override
	public TsFileUpload getTsFileUpload(String fpId,String pathKey) throws Exception
	{
		TsFileUpload  upload = tsFileUploadMapper.getTsFileUpload(fpId);
		upload.setFullFileName(EFSUtil.getSystemConfig(pathKey) + upload.getFpLocName());
		return upload;
	}

	@Override
	public String addTsFileUpload(CommonsMultipartFile srcFile, String addUser, String pathKey) throws Exception
	{
		TsFileUpload tsFileUpload = new TsFileUpload();
		tsFileUpload.setFpId(IDUtil.getId("ID_SYS_FILE_UPLOAAD"));

		String extension = FilenameUtils.getExtension(srcFile.getOriginalFilename());
		String locName ="F_" + EFSUtil.getTimeStamp() + "." + extension;

		File newFile = new File(EFSUtil.getSystemConfig(pathKey) + locName);

		tsFileUpload.setFpLocName(locName);
		tsFileUpload.setFpName(srcFile.getOriginalFilename());
		tsFileUpload.setFpAddDate(EFSUtil.getSysFormatDate());
		tsFileUpload.setFpAddTime(EFSUtil.getSysFormatTime());
		tsFileUpload.setFpAddUser(addUser);

		srcFile.transferTo(newFile);

		tsFileUploadMapper.addTsFileUpload(tsFileUpload);

		return tsFileUpload.getFpId();
	}

	@Override
	public void updateTsFileUpload(TsFileUpload tsFileUpload) throws Exception
	{
		tsFileUploadMapper.updateTsFileUpload(tsFileUpload);
	}

	@Override
	public void deleteTsFileUpload(String fpId) throws Exception
	{
		tsFileUploadMapper.deleteTsFileUpload(fpId);
	}

	@Override
	public PageDataBunder listTsFileUpload(TsFileUpload paramBean,Page page) throws Exception
	{
		return tsFileUploadMapper.listTsFileUpload(paramBean,page);
	}

	/**
	 * 查询文件列表
	 *
	 * @param paramBean
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<TsFileUpload> listFiles(TsFileUpload paramBean) throws Exception
	{
		return tsFileUploadMapper.listFiles(paramBean);
	}
}
