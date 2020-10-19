package com.efs.bus.upload.service;

import com.efs.common.database.Page;
import com.efs.common.database.PageDataBunder;
import com.efs.bus.upload.mapper.TsFileUpload;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.File;
import java.util.List;

/**
 * 
 * com.efs.bus.upload.mapper.TsFileUploadService
 * @author xwh
 * 2018-05-22 14:03:14
 * 系统文件上传表
 *
 */
public interface TsFileUploadService
{
	/**
	 * 根据主键ID获取TsFileUpload
	 * @param dbId
	 * @return
	 */
	public TsFileUpload getTsFileUpload(String fpId,String pathKey) throws Exception;
	
	/**
	 * 增加TsFileUpload
	 * @param tsFileUpload
	 */
	public String addTsFileUpload(CommonsMultipartFile srcFile, String addUser,String pathKey) throws Exception;
	
	/**
	 * 更新TsFileUpload
	 * @param empBean
	 */
	public void updateTsFileUpload(TsFileUpload tsFileUpload) throws Exception;
	
	/**
	 * 删除TsFileUpload
	 * @param dbId
	 */
	public void deleteTsFileUpload(String fpId) throws Exception;
	
	
	/**
	 * 列举员工信息，带分页
	 * @param TsFileUpload
	 * @return
	 */
	public PageDataBunder listTsFileUpload(TsFileUpload paramBean, Page page) throws Exception;

	/**
	 * 查询文件列表
	 * @param paramBean
	 * @return
	 * @throws Exception
	 */
	List<TsFileUpload> listFiles(TsFileUpload paramBean) throws Exception;
}
