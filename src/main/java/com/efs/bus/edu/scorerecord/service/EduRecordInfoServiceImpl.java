package com.efs.bus.edu.scorerecord.service;

import com.efs.bus.edu.classes.mapper.BaseSchClassInfo;
import com.efs.bus.edu.classes.mapper.BaseSchClassInfoMapper;
import com.efs.bus.edu.scorerecord.mapper.EduRecordInfo;
import com.efs.bus.edu.scorerecord.mapper.EduRecordInfoMapper;
import com.efs.bus.edu.scorestatic.mapper.EduClassStaticInfo;
import com.efs.bus.edu.scorestatic.mapper.EduClassStaticInfoMapper;
import com.efs.bus.edu.scorestatic.mapper.EduClassStaticResult;
import com.efs.bus.util.BusUtil;
import com.efs.common.Util.SysConstant;
import com.efs.common.auth.user.mapper.TsUserInfo;
import com.efs.common.auth.user.mapper.TsUserInfoMapper;
import com.efs.common.database.Page;
import com.efs.common.database.PageDataBunder;
import com.xwh.exceldownload.util.ExcelDownloadUtil;
import com.xwh.util.EFSUtil;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.ss.util.RegionUtil;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("eduRecordInfoService")
public class EduRecordInfoServiceImpl implements EduRecordInfoService
{
    @Resource(name = "eduRecordInfoMapper")
    private EduRecordInfoMapper eduRecordInfoMapper;

    @Resource(name = "tsUserInfoMapper")
    private TsUserInfoMapper tsUserInfoMapper;

    @Resource(name = "eduClassStaticInfoMapper")
    private EduClassStaticInfoMapper eduClassStaticInfoMapper;

    @Resource(name = "baseSchClassInfoMapper")
    private BaseSchClassInfoMapper baseSchClassInfoMapper;

    @Override
    public EduRecordInfo getEduRecordInfo(String riId) throws Exception
    {
        return eduRecordInfoMapper.getEduRecordInfo(riId);
    }

    /**
     * 增加EduRecordInfo
     *
     * @param eduRecordInfoList
     * @param paramBean
     */
    @Override
    public void addEduRecordInfoPerClass(List<EduRecordInfo> eduRecordInfoList, EduRecordInfo paramBean) throws Exception
    {
        if (CollectionUtils.isNotEmpty(eduRecordInfoList))
        {
            //先删除该班的数据
            eduRecordInfoMapper.deleteEduRecordFromCls(paramBean);

            //再批量添加
            eduRecordInfoMapper.addEduRecordInfo(eduRecordInfoList, paramBean);
        }
    }

    @Override
    public void updateEduRecordInfo(EduRecordInfo eduRecordInfo) throws Exception
    {
        eduRecordInfoMapper.updateEduRecordInfo(eduRecordInfo);
    }

    @Override
    public void deleteEduRecordInfo(String riId) throws Exception
    {
        eduRecordInfoMapper.deleteEduRecordInfo(riId);
    }

    @Override
    public PageDataBunder listEduRecordInfo(EduRecordInfo paramBean, Page page) throws Exception
    {
        return eduRecordInfoMapper.listEduRecordInfo(paramBean, page);
    }

    /**
     * 根据用户选择的信息生成成绩上传模板
     *
     * @param paramBean
     * @return
     * @throws Exception
     */
    @Override
    public String getRecoredModel(EduRecordInfo paramBean) throws Exception
    {
        TsUserInfo userParam = new TsUserInfo();


        Workbook workbook;
        Cell cell;
        Sheet sheet;
        Row row;
        CellStyle borderStyle;
        int cellIndex;

        userParam.setUsClass(paramBean.getRiClass());
        userParam.setUsSchStatus("01");
        List<TsUserInfo> studentList = tsUserInfoMapper.listStudentNoPage(userParam);


        File modelFile = new File(SysConstant.SYSTEM_MODEL_PATH + "上传成绩模板.xlsx");
        File tmpFile = new File(EFSUtil.getSystemConfig("sys.temp.path") + "\\CJ_" + EFSUtil.getTimeStamp() + ".xlsx");

        //对EXCEL进行编辑
        String title = "官店民族小学" + BusUtil.getTermNameFromCode(paramBean.getRiTerm()) + EFSUtil.getDBParamValue("BASE_MID_TERM", paramBean.getRiMidTerm()) + "成绩统计表";
        String subTitle = "官店民族小学校 " + BusUtil.getClassDescFromCode(paramBean.getRiClass());


        workbook = new XSSFWorkbook(new FileInputStream(modelFile));
        sheet = workbook.getSheetAt(0);

        //设置边框样式
        borderStyle = workbook.createCellStyle();
        borderStyle.setBorderBottom(BorderStyle.THIN);
        borderStyle.setBorderLeft(BorderStyle.THIN);
        borderStyle.setBorderTop(BorderStyle.THIN);
        borderStyle.setBorderRight(BorderStyle.THIN);

        //更 新标题
        row = sheet.getRow(0);
        cell = row.getCell(0);
        cell.setCellValue(title);

        //更新副标题
        row = sheet.getRow(1);
        cell = row.getCell(0);
        cell.setCellValue(subTitle);

        //更新学生信息
        if (CollectionUtils.isNotEmpty(studentList))
        {
            for (int i = 0; i < studentList.size(); i++)
            {
                row = sheet.createRow(i + 3);
                cellIndex = 0;
                TsUserInfo student = studentList.get(i);

                //设置学号
                cell = row.createCell(cellIndex++);
                cell.setCellValue(student.getUiId());
                cell.setCellStyle(borderStyle);

                //考号
                cell = row.createCell(cellIndex++);
                cell.setCellStyle(borderStyle);

                //设置姓名
                cell = row.createCell(cellIndex++);
                cell.setCellValue(student.getUiName());
                cell.setCellStyle(borderStyle);

                //语文
                cell = row.createCell(cellIndex++);
                cell.setCellStyle(borderStyle);

                //数学
                cell = row.createCell(cellIndex++);
                cell.setCellStyle(borderStyle);

                //英语
                cell = row.createCell(cellIndex++);
                cell.setCellStyle(borderStyle);

                //品德
                cell = row.createCell(cellIndex++);
                cell.setCellStyle(borderStyle);

                //科学
                cell = row.createCell(cellIndex++);
                cell.setCellStyle(borderStyle);

                //总分
                cell = row.createCell(cellIndex++);
                cell.setCellStyle(borderStyle);

                //名次
                cell = row.createCell(cellIndex++);
                cell.setCellStyle(borderStyle);
            }
        }


        workbook.write(new FileOutputStream(tmpFile));
        return tmpFile.getAbsolutePath();
    }

    /**
     * 查询指定学期，期中/期末，班级的是否已经上传过成绩
     *
     * @param paramBean
     * @return
     * @throws Exception
     */
    @Override
    public boolean checkRepeatRecored(EduRecordInfo paramBean) throws Exception
    {
        return eduRecordInfoMapper.getRecordCount(paramBean) > 0;
    }

    /**
     * 获取最近的学期和期中期末
     *
     * @return
     * @throws Exception
     */
    @Override
    public EduRecordInfo getMaxTermAndMid() throws Exception
    {
        return eduRecordInfoMapper.getMaxTermAndMid();
    }

    /**
     * 查询班级统计信息
     *
     * @param paramBean
     * @return
     * @throws Exception
     */
    @Override
    public List<EduClassStaticResult> listClassStatics(EduRecordInfo paramBean) throws Exception
    {
        List<EduClassStaticResult> resultList = new ArrayList<>();
        Map<String, Object> typeMap = EFSUtil.getDBParamMap("EDU_CLS_STATIC_FIELD");
        EduClassStaticResult staticResultBean = new EduClassStaticResult();

        staticResultBean.setCsTerm(paramBean.getRiTerm());
        staticResultBean.setCsMidTerm(paramBean.getRiMidTerm());
        staticResultBean.setCsClass(paramBean.getRiClass());

        for (Map.Entry<String, Object> entry : typeMap.entrySet())
        {
            staticResultBean.setStaticType(entry.getKey());
            staticResultBean.setStaticDesc((String) entry.getValue());
            EduClassStaticResult res = eduClassStaticInfoMapper.getClassStaticResult(staticResultBean);

            resultList.add(res);

        }

        return resultList;
    }

    /**
     * 查询页面上显示的班级统计信息
     *
     * @param paramBean
     * @param page
     * @return
     */
    @Override
    public PageDataBunder listEduClassStaticInfo(EduClassStaticInfo paramBean, Page page) throws Exception
    {
        return eduClassStaticInfoMapper.listEduClassStaticInfo(paramBean, page);
    }

    /**
     * 更新班主任评价
     *
     * @param paramBean
     * @throws Exception
     */
    @Override
    public void updateLeaderCommont(EduRecordInfo paramBean) throws Exception
    {
        eduRecordInfoMapper.updateLeaderCommont(paramBean);
    }

    /**
     * 获取学生参加考试的场次信息
     *
     * @param stuId
     * @return
     * @throws Exception
     */
    @Override
    public List<String> getStudentRecordTerm(String stuId) throws Exception
    {
        return eduRecordInfoMapper.getStudentRecordTerm(stuId);
    }

    /**
     * 获取学生某一门课程的历史班级排名信息
     *
     * @param stuId
     * @return
     * @throws Exception
     */
    @Override
    public List<Map<String, Object>> getStudentScoreRecord(String stuId) throws Exception
    {
        String[] cols = {"RI_YW_CLS_RAN", "RI_SX_CLS_RAN", "RI_ENG_CLS_RAN", "RI_KX_CLS_RAN", "RI_PS_CLS_RAN", "RI_CLASS_RAN"};
        List<Map<String, Object>> charSearList = new ArrayList<>();
        Map<String, Object> searMap;
        String seName = "";

        //语文
        for (int i = 0; i < cols.length; i++)
        {
            searMap = new HashMap<>();

            switch (i)
            {
                case 0:
                    seName = "语文";
                    break;
                case 1:
                    seName = "数学";
                    break;
                case 2:
                    seName = "英语";
                    break;
                case 3:
                    seName = "科学";
                    break;
                case 4:
                    seName = "品德与社会";
                    break;
                case 5:
                    seName = "总分";
                    break;
            }

            searMap.put("name", seName);
            searMap.put("type", "line");
            //searMap.put("stack","总量");
            searMap.put("data", eduRecordInfoMapper.getStudentScoreRank(stuId, cols[i]));
            charSearList.add(searMap);
        }

        return charSearList;
    }

    /**
     * 查询学生记录信息
     *
     * @param paramBean
     * @param page
     * @return
     * @throws Exception
     */
    @Override
    public PageDataBunder listStudentRecordInfo(EduRecordInfo paramBean, Page page) throws Exception
    {
        return eduRecordInfoMapper.listStudentRecordInfo(paramBean, page);
    }

    /**
     * 下载班级成绩统计
     *
     * @param paramBean
     * @return
     * @throws Exception
     */
    @Override
    public String downloadClassRecord(EduRecordInfo paramBean) throws Exception
    {
        List<EduRecordInfo> recordInfoList = eduRecordInfoMapper.listDownClassRecord(paramBean);
        String title = "官店民族小学" + BusUtil.getTermNameFromCode(paramBean.getRiTerm()) + EFSUtil.getDBParamValue("BASE_MID_TERM", paramBean.getRiMidTerm()) + "成绩统计表";
        String subTitle = "官店民族小学校 " + BusUtil.getClassDescFromCode(paramBean.getRiClass());

        paramBean.setRiTermName(title);
        paramBean.setRiClassName(subTitle);

        Workbook workbook = ExcelDownloadUtil.downloadExcel("classRecord", paramBean, recordInfoList);

        packDownData(listClassStatics(paramBean), workbook, recordInfoList.size());

        //保存到临时文件
        File tmpFile = new File(EFSUtil.getSystemConfig("sys.temp.path") + "\\BJ_" + EFSUtil.getTimeStamp() + ".xlsx");
        workbook.write(new FileOutputStream(tmpFile));
        return tmpFile.getAbsolutePath();
    }

    private void packDownData(List<EduClassStaticResult> resList, Workbook book, int size)
    {
        Sheet sheet = book.getSheetAt(0);
        Row row;
        Cell cell;
        int index = size + 3;
        int cellIndex = 0;
        int i = 0;
        CellStyle borderStyle = book.createCellStyle();
        borderStyle.setBorderBottom(BorderStyle.THIN);
        borderStyle.setBorderLeft(BorderStyle.THIN);
        borderStyle.setBorderTop(BorderStyle.THIN);
        borderStyle.setBorderRight(BorderStyle.THIN);


        if (CollectionUtils.isNotEmpty(resList))
        {
            for (EduClassStaticResult res : resList)
            {
                if (res == null)
                {
                    break;
                }

                cellIndex = 0;
                row = sheet.createRow(index);

                cell = row.createCell(cellIndex++);
                cell.setCellValue("");
                cell.setCellStyle(borderStyle);

                cell = row.createCell(cellIndex++);
                cell.setCellValue(res.getCsDesc1());
                cell.setCellStyle(borderStyle);

                cell = row.createCell(cellIndex++);
                cell.setCellValue(res.getCsDesc2());
                cell.setCellStyle(borderStyle);

                if (i == 2 || i == 6 || i == 8 || i == 10 || i == 12)
                {
                    cell = row.createCell(cellIndex++);
                    cell.setCellValue(convertToRate(res.getYuw()));
                    cell.setCellStyle(borderStyle);

                    cell = row.createCell(cellIndex++);
                    cell.setCellValue(convertToRate(res.getShx()));
                    cell.setCellStyle(borderStyle);

                    cell = row.createCell(cellIndex++);
                    cell.setCellValue(convertToRate(res.getYiw()));
                    cell.setCellStyle(borderStyle);

                    cell = row.createCell(cellIndex++);
                    cell.setCellValue(convertToRate(res.getPis()));
                    cell.setCellStyle(borderStyle);

                    cell = row.createCell(cellIndex++);
                    cell.setCellValue(convertToRate(res.getKex()));
                    cell.setCellStyle(borderStyle);
                } else
                {
                    cell = row.createCell(cellIndex++);
                    cell.setCellValue(res.getYuw());
                    cell.setCellStyle(borderStyle);

                    cell = row.createCell(cellIndex++);
                    cell.setCellValue(res.getShx());
                    cell.setCellStyle(borderStyle);

                    cell = row.createCell(cellIndex++);
                    cell.setCellValue(res.getYiw());
                    cell.setCellStyle(borderStyle);

                    cell = row.createCell(cellIndex++);
                    cell.setCellValue(res.getPis());
                    cell.setCellStyle(borderStyle);

                    cell = row.createCell(cellIndex++);
                    cell.setCellValue(res.getKex());
                    cell.setCellStyle(borderStyle);
                }

                cell = row.createCell(cellIndex++);
                cell.setCellValue("");
                cell.setCellStyle(borderStyle);

                cell = row.createCell(cellIndex++);
                cell.setCellValue("");
                cell.setCellStyle(borderStyle);

                index++;
                i++;
            }
        }
    }

    private String convertToRate(String input)
    {
        DecimalFormat format = new DecimalFormat("0.###%");
        if (input != null)
        {
            double di = Double.parseDouble(input);
            return format.format(di);
        } else
        {
            return "";
        }
    }

    /**
     * 下载学校成绩统计表
     *
     * @param paramBean
     * @return
     * @throws Exception
     */
    @Override
    public String downloadSchoolStatic(EduRecordInfo paramBean) throws Exception
    {
        String title = "官店镇" + BusUtil.getTermNameFromCode(paramBean.getRiTerm()) + "季" + EFSUtil.getDBParamValue("BASE_MID_TERM", paramBean.getRiMidTerm()) + "教学质量检测成绩统计表";
        String modelPath = EFSUtil.getSystemConfig("sys.model.path") + "\\ExpSchoolModel.xlsx";
        Workbook book = new XSSFWorkbook(new FileInputStream(modelPath));
        Sheet sheet = book.getSheetAt(0);
        Font font;
        Row row;
        Cell cell;
        int rowIndex;
        int cellIndex = 2;

        int startRow=0;
        int endRow=0;
        EduClassStaticInfo tmpStatic;

        CellStyle borderStyle = book.createCellStyle();
        borderStyle.setBorderBottom(BorderStyle.THIN);
        borderStyle.setBorderLeft(BorderStyle.THIN);
        borderStyle.setBorderTop(BorderStyle.THIN);
        borderStyle.setBorderRight(BorderStyle.THIN);
        borderStyle.setVerticalAlignment(VerticalAlignment.CENTER);
        borderStyle.setAlignment(HorizontalAlignment.CENTER);

        font = book.createFont();
        font.setFontName("宋体");
        font.setFontHeightInPoints((short)9);
        borderStyle.setFont(font);

        CellStyle gradStyle = book.createCellStyle();
        gradStyle.setWrapText(true);
        gradStyle.setBorderBottom(BorderStyle.THIN);
        gradStyle.setBorderLeft(BorderStyle.THIN);
        gradStyle.setBorderTop(BorderStyle.THIN);
        gradStyle.setBorderRight(BorderStyle.THIN);
        gradStyle.setVerticalAlignment(VerticalAlignment.CENTER);
        gradStyle.setAlignment(HorizontalAlignment.CENTER);
        gradStyle.setFont(font);


        //处理标题
        row = sheet.getRow(0);
        cell = row.getCell(0);
        cell.setCellValue(title);

        //处理日期
        row = sheet.getRow(1);
        cell = row.getCell(23);
        cell.setCellValue("填表日期：" + EFSUtil.getSysFormatDate());

        //初始化年级班级列
        List<BaseSchClassInfo> classInfoList = baseSchClassInfoMapper.listGradeClsCnt(paramBean.getRiTerm(), "1");
        if (CollectionUtils.isNotEmpty(classInfoList))
        {
            rowIndex = 4;
            for (BaseSchClassInfo cls : classInfoList)
            {
                int grand = cls.getScGrade();
                int clsCnt = cls.getClsCnt();

                for (int i = 0; i < clsCnt; i++)
                {
                    row = sheet.createRow(rowIndex + i);
                    cell = row.createCell(0);

                    if (i == 0)
                    {
                        cell.setCellValue(EFSUtil.getChDigit(grand) + "年级");
                    } else
                    {
                        cell.setCellValue("");
                    }

                    cell.setCellStyle(gradStyle);

                    //填充班
                    cell = row.createCell(1);
                    cell.setCellValue(i + 1);
                    cell.setCellStyle(borderStyle);

                    //签名标签
                    if(grand == 2 && i==0)
                    {
                        startRow = rowIndex + 1;

                        CellRangeAddress cra = new CellRangeAddress(rowIndex,rowIndex,15,32);
                        sheet.addMergedRegion(cra);

                        RegionUtil.setBorderBottom(1,cra,sheet);
                        RegionUtil.setBorderLeft(1,cra,sheet);
                        RegionUtil.setBorderTop(1,cra,sheet);
                        RegionUtil.setBorderRight(1,cra,sheet);

                        cell = row.getCell(15);
                        cell.setCellValue("老      师      签      名");
                        cell.setCellStyle(borderStyle);
                    }
                }

                //合并年级单元格
                CellRangeAddress cra = new CellRangeAddress(rowIndex,rowIndex + clsCnt-1,0,0);
                sheet.addMergedRegion(cra);

                RegionUtil.setBorderBottom(1,cra,sheet);
                RegionUtil.setBorderLeft(1,cra,sheet);
                RegionUtil.setBorderTop(1,cra,sheet);
                RegionUtil.setBorderRight(1,cra,sheet);

                rowIndex += clsCnt;
                //插入空行

                if(grand != 1)
                {
                    //一年级之后就不用添加新行了
                    int lastCol =32;
                    if(grand < 3)
                    {
                        lastCol = 14;
                    }
                    CellRangeAddress cra2 = new CellRangeAddress(rowIndex,rowIndex,0,lastCol);
                    sheet.addMergedRegion(cra2);

                    RegionUtil.setBorderBottom(1,cra2,sheet);
                    RegionUtil.setBorderLeft(1,cra2,sheet);
                    RegionUtil.setBorderTop(1,cra2,sheet);
                    RegionUtil.setBorderRight(1,cra2,sheet);
                }

                if(grand == 1)
                {
                    endRow = rowIndex-1;
                }

                rowIndex++;
            }

            //合并签名栏
            if(startRow != 0)
            {
                CellRangeAddress cra2 = new CellRangeAddress(startRow,endRow,15,32);
                sheet.addMergedRegion(cra2);

                RegionUtil.setBorderBottom(1,cra2,sheet);
                RegionUtil.setBorderLeft(1,cra2,sheet);
                RegionUtil.setBorderTop(1,cra2,sheet);
                RegionUtil.setBorderRight(1,cra2,sheet);
            }
        }

        //写入数据
        EduClassStaticInfo param = new EduClassStaticInfo();
        param.setCsTerm(paramBean.getRiTerm());
        param.setCsMidTerm(paramBean.getRiMidTerm());
        List<EduClassStaticInfo> classStaticInfos = eduClassStaticInfoMapper.listSchoolStatic(param);

        if(CollectionUtils.isNotEmpty(classStaticInfos))
        {
            String lastCls = "";
            rowIndex = 4;
            for(int i=0;i<classStaticInfos.size();i++)
            {
                tmpStatic = classStaticInfos.get(i);

                //初始化
                if(StringUtils.isEmpty(lastCls))
                {
                    lastCls = tmpStatic.getCsClass();
                    row = sheet.getRow(rowIndex);
                    rowIndex++;
                }

                //判断是否一行数据已经完成
                if(tmpStatic.getCsClass().startsWith(lastCls.substring(0,2))  && !tmpStatic.getCsClass().equals(lastCls))
                {
                    //同一年级不同班,新取一行
                    row = sheet.getRow(rowIndex);
                    rowIndex++;
                }
                else if(!tmpStatic.getCsClass().startsWith(lastCls.substring(0,2)))
                {
                    //不同年级，跨行
                    row = sheet.getRow(rowIndex+1);
                    rowIndex+=2;
                }

                if(!tmpStatic.getCsClass().equals(lastCls))
                {
                    //只要不同班，初始化列序号
                    cellIndex=2;
                }

                //填充数据

                if(cellIndex == 2)
                {
                    //填充考试人数
                    cell = row.createCell(cellIndex++);
                    cell.setCellValue(handNullValue(tmpStatic.getCsKsrs()));
                    cell.setCellStyle(borderStyle);
                }

                //人均分
                cell = row.createCell(cellIndex++);
                cell.setCellValue(handNullValue(tmpStatic.getCsCourJf()));
                cell.setCellStyle(borderStyle);

                //及格率
                cell = row.createCell(cellIndex++);
                cell.setCellValue(handNullValue(tmpStatic.getCsCourJglVal()));
                cell.setCellStyle(borderStyle);

                //优分率
                cell = row.createCell(cellIndex++);
                cell.setCellValue(handNullValue(tmpStatic.getCsCourYflVal()));
                cell.setCellStyle(borderStyle);

                //高分率
                cell = row.createCell(cellIndex++);
                cell.setCellValue(handNullValue(tmpStatic.getCsCourGflVal()));
                cell.setCellStyle(borderStyle);

                //低分率
                cell = row.createCell(cellIndex++);
                cell.setCellValue(handNullValue(tmpStatic.getCsCourDflVal()));
                cell.setCellStyle(borderStyle);

                //执教者
                cell = row.createCell(cellIndex++);
                cell.setCellValue(handNullValue(tmpStatic.getCsCourTeacherNm()));
                cell.setCellStyle(borderStyle);

                lastCls = tmpStatic.getCsClass();

            }
        }


        //保存到临时文件
        File tmpFile = new File(EFSUtil.getSystemConfig("sys.temp.path") + "\\XX_" + EFSUtil.getTimeStamp() + ".xlsx");
        book.write(new FileOutputStream(tmpFile));
        return tmpFile.getAbsolutePath();
    }

    private static String handNullValue(Object input)
    {
        if(input == null)
        {
            return "";
        }

        return input.toString();

    }
}
