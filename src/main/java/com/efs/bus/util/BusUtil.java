package com.efs.bus.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.efs.bus.edu.classes.mapper.BaseSchClassInfo;
import com.efs.bus.edu.scorerecord.mapper.EduRecordInfo;
import com.efs.bus.edu.semcal.mapper.BaseSemesterCal;
import com.efs.bus.lib.bookinfo.mapper.LibBooksInfo;
import com.efs.bus.lib.booktype.mapper.LibBookTypeInfo;
import com.efs.common.Util.SysConstant;
import com.efs.common.auth.user.mapper.TsUserInfo;
import com.efs.common.httpclient.NewWebConnection;
import com.efs.common.httpclient.WebUrl;
import com.xwh.util.EFSUtil;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.net.URI;
import java.time.LocalDate;
import java.util.*;

/**
 * <strong>类全名</strong><br/>
 * com.efs.bus.util.BusUtil <br/>
 * <strong>包名</strong><br/>
 * com.efs.bus.util <br/>
 * <strong>作者</strong><br/>
 * xuwh <br/>
 * <strong>日期</strong><br/>
 * 2018/3/25 20:11 <br/>
 * <strong>JDK</strong><br/>
 * 1.8
 * <strong>版本</strong><br/>
 * v1.0 <br/>
 * <strong>描述</strong><br/>
 * 业务工具类
 */
public class BusUtil
{
    private static Log logger = LogFactory.getLog(BusUtil.class);
    private static Map<String,String> sendBookCheckStatus;
    private static Map<String,String> backBookCheckStatus;
    private static Map<String,String> compBookCheckStatus;


    private static Map<String,String> fileModelMap;

    static
    {
        fileModelMap = new HashMap<>();
        fileModelMap.put("uploadStudentModel","学生信息上传模板.xlsx");

        sendBookCheckStatus = new HashMap<>();
        sendBookCheckStatus.put("00","借阅成功");
        sendBookCheckStatus.put("01","此用户没有借阅权限，请联系系统管理员开通借阅权限！");
        sendBookCheckStatus.put("02","此图书已经借出！");
        sendBookCheckStatus.put("03","此用户已经达到最大借阅量！");
        sendBookCheckStatus.put("04","此用户还有挂失图书未处理！");
        sendBookCheckStatus.put("05","此图书已经挂失或作废！");
        sendBookCheckStatus.put("06","此图书尚未入库！");

        backBookCheckStatus = new HashMap<>();
        backBookCheckStatus.put("00","归还成功");
        backBookCheckStatus.put("01","此图书尚未入库！");
        backBookCheckStatus.put("02","此图书尚未借出！");
        backBookCheckStatus.put("03","该用户并未借阅此图书！");

        compBookCheckStatus = new HashMap<>();
        compBookCheckStatus.put("00","解挂成功");
        compBookCheckStatus.put("01","此图书尚未入库！");
        compBookCheckStatus.put("02","此图书并未挂失！");
        compBookCheckStatus.put("03","该图书并非由当前用户挂失！");
        compBookCheckStatus.put("04","该图书与书编码不一致！");
        compBookCheckStatus.put("05","新图书尚未入库！");
    }

    /**
     * 从豆瓣网上根据ISBN获取图书信息
     * @param isbn
     * @return
     * @throws Exception
     */
    public static LibBooksInfo getBooksInfoFromDouBan(String isbn, List<LibBookTypeInfo>typeInfoList) throws Exception
    {
        String urlStr = EFSUtil.getSystemConfig("book.douban.url");
        String charset = EFSUtil.getSystemConfig("book.douban.charset");
        NewWebConnection client = null;
        WebUrl url;
        JSONObject jobj;
        LibBooksInfo libBooksInfo = null;

        try
        {
            url = new WebUrl();
            url.setUrl(urlStr + isbn);
            url.setMethod(NewWebConnection.METHOD_GET);
            client = NewWebConnection.createWebConnection(url,charset);
            String resStr = client.executeRequest(NewWebConnection.RES_TYPE_AJAX);

            logger.debug("查找图书ISBN["+isbn +"]的结果为>"+ resStr +"<");

            if(StringUtils.isEmpty(resStr))
            {
                //返回内容为空，直接返回
                return null;
            }

            if(resStr.startsWith("null"))
            {
                resStr = resStr.substring(4);
            }

            jobj = JSON.parseObject(resStr);
            String formatStr = JSON.toJSONString(jobj, SerializerFeature.PrettyFormat,SerializerFeature.BeanToArray,SerializerFeature.WriteMapNullValue);
            logger.debug("查找图书ISBN["+isbn +"]的格式化结果为>\n"+ formatStr +"\n<");

            //检查是否找到有效的图书信息
            String ss = jobj.getString("isbn13");
            if(StringUtils.isEmpty(ss) || !isbn.equals(ss))
            {
                return  null;
            }

            libBooksInfo = convertBookInfo(jobj,isbn,typeInfoList);

            //保存图片信息
            saveBookImg(libBooksInfo);

        } catch (Exception e)
        {
            e.printStackTrace();
            logger.warn("查找ISBN为["+ isbn +"]的图书信息时出错",e);
        } finally
        {
            client.shutDownClient();
        }

        return libBooksInfo;
    }

    /**
     * 将JSON OBJECT转换为对象类型
     * @param jobject
     * @return
     */
    private static LibBooksInfo convertBookInfo(JSONObject jobject, String isbn,List<LibBookTypeInfo>typeInfoList)
    {
        LibBooksInfo libBooksInfo;

        libBooksInfo = new LibBooksInfo();
        libBooksInfo.setBiIsbn(isbn);
        libBooksInfo.setBiAuth(StringUtils.join(jobject.getJSONArray("author"),','));
        libBooksInfo.setBiPublishDate(jobject.getString("pubdate"));
        libBooksInfo.setBiRemSmImg(jobject.getString("image"));
        libBooksInfo.setBiTranslater(StringUtils.join(jobject.getJSONArray("translator"),','));
        libBooksInfo.setBiPageCount(jobject.getString("pages"));
        libBooksInfo.setBiRemLgImg(jobject.getJSONObject("images").getString("large"));
        libBooksInfo.setBiPress(jobject.getString("publisher"));

        String title = jobject.getString("title");
        String subTitle = jobject.getString("subtitle");
        if(StringUtils.isNotEmpty(subTitle) && !subTitle.equals(title))
        {
            subTitle = " " + subTitle;
        }
        else
        {
            subTitle = "";
        }

        libBooksInfo.setBiName(jobject.getString("title") + subTitle);
        libBooksInfo.setBiOriName(jobject.getString("origin_title"));
        libBooksInfo.setBiPrice(jobject.getString("price"));
        libBooksInfo.setBiBookBrief(jobject.getString("summary"));
        libBooksInfo.setBiBookCata(jobject.getString("catalog"));
        libBooksInfo.setBiBookSize(jobject.getString("binding"));
        libBooksInfo.setBiEbookUrl(jobject.getString("ebook_url"));
        libBooksInfo.setBiAuthInfo(jobject.getString("author_intro"));

        LibBookTypeInfo type = getBookTypeInfo(jobject.getJSONArray("tags"),typeInfoList);
        if(type != null)
        {
            libBooksInfo.setBiType(type.getBtName());
            libBooksInfo.setBiTypeCode(type.getBtCode());
        }

        return libBooksInfo;
    }

    private static LibBookTypeInfo getBookTypeInfo(JSONArray tags, List<LibBookTypeInfo>typeInfoList )
    {
        if(tags == null || tags.size() == 0)
        {
            return null;
        }

        if(typeInfoList == null || typeInfoList.size() == 0)
        {
            return null;
        }

        List<JSONObject> jsonList = tags.toJavaList(JSONObject.class);

        for(JSONObject obj : jsonList)
        {
            if(StringUtils.isNotEmpty(obj.getString("name")))
            {
                String tgname = obj.getString("name").toLowerCase();
                for(LibBookTypeInfo type : typeInfoList)
                {
                    String btKey = StringUtils.isEmpty(type.getBtKeyword()) ? "" : type.getBtKeyword().toLowerCase();
                    String btName = StringUtils.isEmpty(type.getBtName()) ? "" : type.getBtName().toLowerCase();

                    if(StringUtils.isNotEmpty(btKey))
                    {
                        if(Arrays.stream(btKey.split("[,，]")).anyMatch(item->tgname.contains(item)))
                        {
                            return type;
                        }
                    }

                    if(btKey.contains(tgname) || btName.contains(tgname) || (StringUtils.isNotEmpty(btName) && tgname.contains(btName)))
                    {
                        return type;
                    }
                }
            }
        }

        return null;
    }

    /**
     * 保存网络图片
     * @param booksInfo
     */
    private static void saveBookImg(LibBooksInfo booksInfo)
    {
        String largeRootPath = SysConstant.SYSTEM_ROOT_FULL_PATH + "bookimg\\large\\";
        String smallRootPath = SysConstant.SYSTEM_ROOT_FULL_PATH + "bookimg\\small\\";
        String tmpName;
        try
        {
            if(booksInfo == null)
            {
                return ;
            }

            if(StringUtils.isNotEmpty(booksInfo.getBiRemLgImg()))
            {
                //有大图片存在
                String img = booksInfo.getBiRemLgImg();
                tmpName = booksInfo.getBiIsbn() + "_" + EFSUtil.getTimeStamp() + img.substring(img.lastIndexOf("."));
                EFSUtil.saveUrlContentToLocal(new URI(img),largeRootPath + tmpName);
                booksInfo.setBiLocLgImg(tmpName);
                logger.debug("成功保存图书大图片:" + largeRootPath + tmpName);
            }

            if(StringUtils.isNotEmpty(booksInfo.getBiRemSmImg()))
            {
                //有大图片存在
                String img = booksInfo.getBiRemSmImg();
                tmpName = booksInfo.getBiIsbn() + "_" + EFSUtil.getTimeStamp() + img.substring(img.lastIndexOf("."));
                EFSUtil.saveUrlContentToLocal(new URI(img),smallRootPath + tmpName);
                booksInfo.setBiLocSmImg(tmpName);
                logger.debug("成功保存图书小图片:" + smallRootPath + tmpName);
            }
        }
        catch (Exception ex)
        {
            logger.error("保存网络图书图片失败",ex);
        }
    }

    /**
     * 检查图书信息是否可以删除
     * @param booksInfo
     * @return
     */
    public static boolean checkBookDelete(LibBooksInfo booksInfo)
    {
        if(booksInfo == null || "00".equals(booksInfo.getBiStatus()) || "03".equals(booksInfo.getBiStatus()) )
        {
            return true;
        }

        return false;
    }

    /**
     * 返回图书借阅检查状态描述
     * @param checkCode
     * @return
     */
    public static String getSendBookChkStr(String checkCode)
    {
        String res = sendBookCheckStatus.get(checkCode);

        if(StringUtils.isEmpty(res))
        {
            res = "";
        }

        return res;
    }

    /**
     * 返回图书归还检查状态描述
     * @param checkCode
     * @return
     */
    public static String getBackBookChkStr(String checkCode)
    {
        String res = backBookCheckStatus.get(checkCode);

        if(StringUtils.isEmpty(res))
        {
            res = "";
        }

        return res;
    }

    /**
     * 返回图书解挂检查状态描述
     * @param checkCode
     * @return
     */
    public static String getCompBookChkStr(String checkCode)
    {
        String res = compBookCheckStatus.get(checkCode);

        if(StringUtils.isEmpty(res))
        {
            res = "";
        }

        return res;
    }

    /**
     * 获取图书图片
     * @return
     */
    public static String getShowImgUrl(String biLocLgImg,String biLocSmImg,String biRemLgImg,String biRemSmImg)
    {
        String showImgUrl = null;

        if(StringUtils.isNotEmpty(biLocLgImg) || StringUtils.isNotEmpty(biLocSmImg))
        {
            showImgUrl = StringUtils.isNotEmpty(biLocLgImg) ? (SysConstant.SYSTEM_ROOT_URL_PATH + "/bookimg/large/" + biLocLgImg) : (SysConstant.SYSTEM_ROOT_URL_PATH +"/bookimg/small/" +biLocSmImg);
        }
        else
        {
            showImgUrl = StringUtils.isNotEmpty(biRemLgImg) ? biRemLgImg : biRemSmImg;
        }

        return showImgUrl;
    }

    /**
     * 判断当前日期与学期的关系：<Br/>
     * 0:表示当前系统日期处理学期范围内
     * 1：表示当前系统日期大于处理学期
     * －1：表示当前系统日期还没有到指定的学期
     * @param cal
     * @return
     */
    public static int getCurSemCal(BaseSemesterCal cal)
    {
        LocalDate startDate = LocalDate.parse(cal.getScStartDate());
        LocalDate endDate = LocalDate.parse(cal.getScEndDate());
        LocalDate curDate = LocalDate.now();

        if(curDate.isBefore(startDate))
        {
            return -1;
        }
        else if(curDate.isAfter(endDate))
        {
            return 1;
        }
        else
        {
            return 0;
        }
    }

    /**
     * 根据指定的数量生成班级信息
     * @param gradeNo
     * @param classNo
     * @return
     */
    public static List<BaseSchClassInfo> genClassesInfo(int gradeNo, int classNo)
    {
        List<BaseSchClassInfo> clsList = new ArrayList<>();
        String gradStr = "";
        String clsStr = "";
        String code = "";
        String clsVal = "";

        for(int i=1;i<=gradeNo;i++)
        {
            gradStr = StringUtils.leftPad(i + "",2,'0');
            for(int j=1;j<=classNo;j++)
            {
                clsStr = StringUtils.leftPad(j + "",2,'0');
                code = gradStr + clsStr;
                clsVal = getClassDescFromCode(code);

                BaseSchClassInfo ci = new BaseSchClassInfo();
                ci.setScClassCode(code);
                ci.setScClassName(clsVal);

                clsList.add(ci);
            }
        }

        return clsList;
    }

    /**
     * 根据班级CODE返回班级名称
     * @param classCode
     * @return
     * @throws Exception
     */
    public static String getClassDescFromCode(String classCode)
    {
        int grade = Integer.parseInt(classCode.substring(0,2));
        int classes = Integer.parseInt(classCode.substring(2,4));

        String res = EFSUtil.getChDigit(grade) + "（" + classes + "）班";
        return res;
    }

    /**
     * 根据学期CODE获取学期中文名
     * @param termCode
     * @return
     */
    public static String getTermNameFromCode(String termCode)
    {
        String title;
        String term;

        title = termCode.substring(0,4) + " 年 ";
        term = termCode.substring(4);
        title += term.equals("01") ? "春" : "秋";

        return title;
    }

    /**
     * 根据模板ID获取模板名称
     * @param modelId
     * @return
     */
    public static String getFileModelName(String modelId)
    {
        return fileModelMap.get(modelId);
    }

    /**
     * 根据班级名称获得CLASS代码
     * @param clsName
     * @return
     */
    public static String getClassCodeFromName(String clsName)
    {
        String res = null;
        String[] tmpArr ;
        if(StringUtils.isNotEmpty(clsName))
        {
            clsName = clsName.replaceAll("[(（)）]",",");
            tmpArr = clsName.split(",");

            res = StringUtils.leftPad(EFSUtil.getDigitFromCh(tmpArr[0]).toString(),2,'0') +
                    StringUtils.leftPad(tmpArr[1],2,'0');
        }

        return res;
    }

    /**
     * 对成绩排名进行格显示格式化
     * @param recordInfos
     * @throws Exception
     */
    public static void formatShowRecord(List<EduRecordInfo> recordInfos) throws Exception
    {
        if(CollectionUtils.isNotEmpty(recordInfos))
        {
            for (EduRecordInfo record : recordInfos)
            {
                handRecordBean(record);
            }
        }
    }
    
    private static void handRecordBean(EduRecordInfo recordInfo) throws Exception
    {
        String propName;
        String chgName;
        String rankName;
        BeanInfo beanInfo = Introspector.getBeanInfo(recordInfo.getClass());
        PropertyDescriptor[] propertyes = beanInfo.getPropertyDescriptors();
        PropertyDescriptor chgPd;
        PropertyDescriptor rankPd;

        for (PropertyDescriptor pd : propertyes)
        {
            propName = pd.getName();
            if(propName.endsWith("2Val") || propName.endsWith("ChgVal"))
            {
                chgName = propName.replace("Val","");
                rankName = chgName.replace("Chg","");
                chgPd = new PropertyDescriptor(chgName,recordInfo.getClass());
                rankPd = new PropertyDescriptor(rankName,recordInfo.getClass());
                pd.getWriteMethod().invoke(recordInfo,formatRank((Integer)rankPd.getReadMethod().invoke(recordInfo),(Integer)chgPd.getReadMethod().invoke(recordInfo)));
            }
        }
    }

    /**
     * 返回排名变动格式字符串
     * @param rank
     * @param rankChg
     * @return
     */
    private static String formatRank(Integer rank,Integer rankChg)
    {

        String rnkStr ;
        String rnkChgStr;

        if(rank == null)
        {
            rnkStr = "";
        }
        else
        {
            rnkStr = rank.toString();
        }

        if(rankChg == null || rankChg == 0)
        {
            rnkChgStr = " &nbsp;-";
        }
        else if(rankChg >0)
        {
            rnkChgStr = " &nbsp;<font color='red'>" + rankChg + " ↑</font>";
        }
        else
        {
            rnkChgStr = " &nbsp;<font color='green'>" + Math.abs(rankChg) + " ↓</font>";
        }

        rnkChgStr = rnkStr + rnkChgStr;

        return rnkChgStr;
    }

    /**
     * 将通讯录转为HTML字符串
     * @param userInfoList
     * @param basePath
     * @return
     */
    public static String genAddressBookHtml(List<TsUserInfo> userInfoList,String basePath)
    {
        if(CollectionUtils.isEmpty(userInfoList))
        {
            return "没有找到相关信息";
        }
        
        StringBuilder sb = new StringBuilder();
        for (TsUserInfo user : userInfoList)
        {
            sb.append("<li class=\"list-group-item\">")
                    .append("<a class=\"thumb pull-left notea\" href=\"#\"> <img src=\""+basePath+"/resource/images/user3.png\" style=\"height: 22px;\"> </a>")
                    .append("<a class=\"notea\" href=\"javascript:void(0)\" onclick=\"showBarCodeImg('"+user.getUiId()+"')\"> <strong>"+user.getUiName()+"</strong>")
                    .append("<span>手机号："+user.getUiMobile()+"&nbsp;");

            if(StringUtils.isNotEmpty(user.getUtDuty()))
            {
                sb.append("职务：" + user.getUtDuty() + "&nbsp;");
            }

            if(StringUtils.isNotEmpty(user.getUsClassName()))
            {
                sb.append("班级：" + user.getUsClassName() + "&nbsp;");
            }

            if(StringUtils.isNotEmpty(user.getUsAddr()))
            {
                sb.append("住址：" + user.getUsAddr() + "&nbsp;");
            }
            sb.append("</span></a></li>");
        }

        return sb.toString();
    }

    /**
     * 以VCARD的格式获得通讯录信息
     * @param tsUserInfo
     * @return
     */
    public static String genVCArdString(TsUserInfo tsUserInfo)
    {
        StringBuilder sb = new StringBuilder();

        if(tsUserInfo == null)
        {
            return "";
        }

        sb.append("BEGIN:VCARD\n");
        sb.append("VERSION:3.0\n");
        sb.append("FN:"+tsUserInfo.getUiName()+"\n");
        sb.append("TEL;CELL:"+tsUserInfo.getUiMobile()+"\n");
        sb.append("TITLE:"+tsUserInfo.getUtDuty()+"\n");
        sb.append("ORG:"+tsUserInfo.getUtOrg()+"\n");
        sb.append("END:VCARD");

        return sb.toString();

    }
}
