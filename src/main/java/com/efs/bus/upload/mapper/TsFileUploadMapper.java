package com.efs.bus.upload.mapper;

import com.efs.common.database.Page;
import com.efs.common.database.PageDataBunder;

import java.util.List;


/**
 * 
 * com.efs.bus.upload.mapper.TsFileUploadMapper
 * @author xwh
 * 2018-05-22 14:03:14
 * 系统文件上传表
 *
 */
public interface TsFileUploadMapper
{
	/**
	 * 根据主键ID获取TsFileUpload
	 * @param fpId
	 * @return
	 */
	public TsFileUpload getTsFileUpload(String fpId) throws Exception;
	
	/**
	 * 增加TsFileUpload
	 * @param tsFileUpload
	 */
	public void addTsFileUpload(TsFileUpload tsFileUpload) throws Exception;
	
	/**
	 * 更新TsFileUpload
	 * @param empBean
	 */
	public void updateTsFileUpload(TsFileUpload tsFileUpload) throws Exception;
	
	/**
	 * 删除TsFileUpload
	 * @param fpId
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
