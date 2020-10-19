package com.efs.bus.lib.bookinfo.mapper;

import com.efs.bus.util.BusUtil;
import com.efs.common.Util.SysConstant;
import com.efs.common.Util.SysUtils;
import com.xwh.util.EFSUtil;
import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;

/**
 * 
 * com.efs.bus.lib.bookinfo.mapper.LibBooksInfo
 * @author xuwh
 * 2018-03-25 21:59:04
 * 图书信息表
 *
 */
public class LibBooksInfo implements Serializable
{
	/**
	 * 图书编码-系统产生唯一编号
	 */
	private String biCode;
	
	/**
	 * 图书状态：来源于参数表，在库，借出，丢失，作废等
	 */
	private String biStatus;

	/**
	 * 状态值
	 */
	private String biStatusVal;
	
	/**
	 * 0：不可借，1：可借
	 */
	private String biSendStatus;
	
	/**
	 * 图书名称
	 */
	private String biName;
	
	/**
	 * 图书原名称
	 */
	private String biOriName;
	
	/**
	 * ISBN码
	 */
	private String biIsbn;
	
	/**
	 * 出版日期
	 */
	private String biPublishDate;
	
	/**
	 * 作者
	 */
	private String biAuth;
	
	/**
	 * 翻译者
	 */
	private String biTranslater;
	
	/**
	 * 版次
	 */
	private String biVersion;
	
	/**
	 * 分类号
	 */
	private String biTypeCode;
	
	/**
	 * 图书类别
	 */
	private String biType;
	
	/**
	 * 出版社
	 */
	private String biPress;
	
	/**
	 * 单价
	 */
	private String biPrice;
	
	/**
	 * 页数
	 */
	private String biPageCount;
	
	/**
	 * 书籍开本
	 */
	private String biBookSize;
	
	/**
	 * 内容简介
	 */
	private String biBookBrief;
	
	/**
	 * 图书目录
	 */
	private String biBookCata;
	
	/**
	 * 图书远程小图片
	 */
	private String biRemSmImg;
	
	/**
	 * 图书远程大图片
	 */
	private String biRemLgImg;
	
	/**
	 * 图书本地小图片
	 */
	private String biLocSmImg;
	
	/**
	 * 图书本地大图片
	 */
	private String biLocLgImg;
	
	/**
	 * 所在书架
	 */
	private String biAddr;
	
	/**
	 * 电子图书网址
	 */
	private String biEbookUrl;
	
	/**
	 * 作者信息
	 */
	private String biAuthInfo;
	
	/**
	 * 入库日期
	 */
	private String biInDate;
	
	/**
	 * 入库人
	 */
	private String biInUser;

	/**
	 * 批次号
	 */
	private String biInBatchNo;
	
	/**
	 * 创建日期
	 */
	private String addDate;
	
	/**
	 * 创建时间
	 */
	private String addTime;
	
	/**
	 * 创建人
	 */
	private String addUser;
	
	/**
	 * 最后修改日期
	 */
	private String updDate;
	
	/**
	 * 最后修改时间
	 */
	private String updTime;
	
	/**
	 * 最后修改人
	 */
	private String updUser;

	/**
	 * 重复添加本数
	 */
	private String repeatCont;

	/**
	 * 删除日期
	 */
	private String delDate;

	/**
	 * 删除时间
	 */
	private String delTime;

	/**
	 * 删除人
	 */
	private String delUser;

	/**
	 * 删除原因
	 */
	private String delReason;

    /**
     * 展示使用的URL
     */
	private String showImgUrl;

	/**
	 * 普通用户查询，不显示作废和注销的信息
	 */
	private String isUser;

	private String sendUserId;

	private String sendUserName;

	public String getSendUserId()
	{
		return sendUserId;
	}

	public void setSendUserId(String sendUserId)
	{
		this.sendUserId = sendUserId;
	}

	public String getSendUserName()
	{
		return sendUserName;
	}

	public void setSendUserName(String sendUserName)
	{
		this.sendUserName = sendUserName;
	}

	public String getIsUser()
	{
		return isUser;
	}

	public void setIsUser(String isUser)
	{
		this.isUser = isUser;
	}


    public String getShowImgUrl()
    {
        showImgUrl = BusUtil.getShowImgUrl(biLocLgImg,biLocSmImg,biRemLgImg,biRemSmImg);

        return showImgUrl;
    }

    public String getDelDate()
	{
		return delDate;
	}

	public void setDelDate(String delDate)
	{
		this.delDate = delDate;
	}

	public String getDelTime()
	{
		return delTime;
	}

	public void setDelTime(String delTime)
	{
		this.delTime = delTime;
	}

	public String getDelUser()
	{
		return delUser;
	}

	public void setDelUser(String delUser)
	{
		this.delUser = delUser;
	}

	public String getDelReason()
	{
		return delReason;
	}

	public void setDelReason(String delReason)
	{
		this.delReason = delReason;
	}

	public String getRepeatCont()
	{
		return repeatCont;
	}

	public void setRepeatCont(String repeatCont)
	{
		this.repeatCont = repeatCont;
	}

	public String getBiInBatchNo()
	{
		return biInBatchNo;
	}

	public void setBiInBatchNo(String biInBatchNo)
	{
		this.biInBatchNo = biInBatchNo;
	}

	public String getBiStatusVal()
	{
		try
		{
			biStatusVal = (String)EFSUtil.getDBParamValue(SysConstant.DB_PARAM_TYPE_BOOK_STATUS,biStatus);
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		return biStatusVal;
	}

	/**
	 * 图书编码-系统产生唯一编号<br/>
	 * @return String biCode
	 */
	public String getBiCode()
	{
		return biCode;
	}

	/**
	 * 图书编码-系统产生唯一编号<br/>
	 * @param String biCode
	 */
	public void setBiCode(String biCode)
	{
		this.biCode = biCode;
	}
	
	/**
	 * 图书状态：来源于参数表，在库，借出，丢失，作废等<br/>
	 * @return String biStatus
	 */
	public String getBiStatus()
	{
		return biStatus;
	}

	/**
	 * 图书状态：来源于参数表，在库，借出，丢失，作废等<br/>
	 * @param String biStatus
	 */
	public void setBiStatus(String biStatus)
	{
		this.biStatus = biStatus;
	}
	
	/**
	 * 0：不可借，1：可借<br/>
	 * @return String biSendStatus
	 */
	public String getBiSendStatus()
	{
		return biSendStatus;
	}

	/**
	 * 0：不可借，1：可借<br/>
	 * @param String biSendStatus
	 */
	public void setBiSendStatus(String biSendStatus)
	{
		this.biSendStatus = biSendStatus;
	}
	
	/**
	 * 图书名称<br/>
	 * @return String biName
	 */
	public String getBiName()
	{
		return biName;
	}

	/**
	 * 图书名称<br/>
	 * @param String biName
	 */
	public void setBiName(String biName)
	{
		this.biName = biName;
	}
	
	/**
	 * 图书原名称<br/>
	 * @return String biOriName
	 */
	public String getBiOriName()
	{
		return biOriName;
	}

	/**
	 * 图书原名称<br/>
	 * @param String biOriName
	 */
	public void setBiOriName(String biOriName)
	{
		this.biOriName = biOriName;
	}
	
	/**
	 * ISBN码<br/>
	 * @return String biIsbn
	 */
	public String getBiIsbn()
	{
		return biIsbn;
	}

	/**
	 * ISBN码<br/>
	 * @param String biIsbn
	 */
	public void setBiIsbn(String biIsbn)
	{
		this.biIsbn = biIsbn;
	}
	
	/**
	 * 出版日期<br/>
	 * @return String biPublishDate
	 */
	public String getBiPublishDate()
	{
		return biPublishDate;
	}

	/**
	 * 出版日期<br/>
	 * @param String biPublishDate
	 */
	public void setBiPublishDate(String biPublishDate)
	{
		this.biPublishDate = biPublishDate;
	}
	
	/**
	 * 作者<br/>
	 * @return String biAuth
	 */
	public String getBiAuth()
	{
		return biAuth;
	}

	/**
	 * 作者<br/>
	 * @param String biAuth
	 */
	public void setBiAuth(String biAuth)
	{
		this.biAuth = biAuth;
	}
	
	/**
	 * 翻译者<br/>
	 * @return String biTranslater
	 */
	public String getBiTranslater()
	{
		return biTranslater;
	}

	/**
	 * 翻译者<br/>
	 * @param String biTranslater
	 */
	public void setBiTranslater(String biTranslater)
	{
		this.biTranslater = biTranslater;
	}
	
	/**
	 * 版次<br/>
	 * @return String biVersion
	 */
	public String getBiVersion()
	{
		return biVersion;
	}

	/**
	 * 版次<br/>
	 * @param String biVersion
	 */
	public void setBiVersion(String biVersion)
	{
		this.biVersion = biVersion;
	}
	
	/**
	 * 分类号<br/>
	 * @return String biTypeCode
	 */
	public String getBiTypeCode()
	{
		return biTypeCode;
	}

	/**
	 * 分类号<br/>
	 * @param String biTypeCode
	 */
	public void setBiTypeCode(String biTypeCode)
	{
		this.biTypeCode = biTypeCode;
	}
	
	/**
	 * 图书类别<br/>
	 * @return String biType
	 */
	public String getBiType()
	{
		return biType;
	}

	/**
	 * 图书类别<br/>
	 * @param String biType
	 */
	public void setBiType(String biType)
	{
		this.biType = biType;
	}
	
	/**
	 * 出版社<br/>
	 * @return String biPress
	 */
	public String getBiPress()
	{
		return biPress;
	}

	/**
	 * 出版社<br/>
	 * @param String biPress
	 */
	public void setBiPress(String biPress)
	{
		this.biPress = biPress;
	}
	
	/**
	 * 单价<br/>
	 * @return String biPrice
	 */
	public String getBiPrice()
	{
		return biPrice;
	}

	/**
	 * 单价<br/>
	 * @param String biPrice
	 */
	public void setBiPrice(String biPrice)
	{
		this.biPrice = biPrice;
	}
	
	/**
	 * 页数<br/>
	 * @return String biPageCount
	 */
	public String getBiPageCount()
	{
		return biPageCount;
	}

	/**
	 * 页数<br/>
	 * @param String biPageCount
	 */
	public void setBiPageCount(String biPageCount)
	{
		this.biPageCount = biPageCount;
	}
	
	/**
	 * 书籍开本<br/>
	 * @return String biBookSize
	 */
	public String getBiBookSize()
	{
		return biBookSize;
	}

	/**
	 * 书籍开本<br/>
	 * @param String biBookSize
	 */
	public void setBiBookSize(String biBookSize)
	{
		this.biBookSize = biBookSize;
	}
	
	/**
	 * 内容简介<br/>
	 * @return String biBookBrief
	 */
	public String getBiBookBrief()
	{
		return biBookBrief;
	}

	/**
	 * 内容简介<br/>
	 * @param String biBookBrief
	 */
	public void setBiBookBrief(String biBookBrief)
	{
		this.biBookBrief = biBookBrief;
	}
	
	/**
	 * 图书目录<br/>
	 * @return String biBookCata
	 */
	public String getBiBookCata()
	{
		return biBookCata;
	}

	/**
	 * 图书目录<br/>
	 * @param String biBookCata
	 */
	public void setBiBookCata(String biBookCata)
	{
		this.biBookCata = biBookCata;
	}
	
	/**
	 * 图书远程小图片<br/>
	 * @return String biRemSmImg
	 */
	public String getBiRemSmImg()
	{
		return biRemSmImg;
	}

	/**
	 * 图书远程小图片<br/>
	 * @param String biRemSmImg
	 */
	public void setBiRemSmImg(String biRemSmImg)
	{
		this.biRemSmImg = biRemSmImg;
	}
	
	/**
	 * 图书远程大图片<br/>
	 * @return String biRemLgImg
	 */
	public String getBiRemLgImg()
	{
		return biRemLgImg;
	}

	/**
	 * 图书远程大图片<br/>
	 * @param String biRemLgImg
	 */
	public void setBiRemLgImg(String biRemLgImg)
	{
		this.biRemLgImg = biRemLgImg;
	}
	
	/**
	 * 图书本地小图片<br/>
	 * @return String biLocSmImg
	 */
	public String getBiLocSmImg()
	{
		return biLocSmImg;
	}

	/**
	 * 图书本地小图片<br/>
	 * @param String biLocSmImg
	 */
	public void setBiLocSmImg(String biLocSmImg)
	{
		this.biLocSmImg = biLocSmImg;
	}
	
	/**
	 * 图书本地大图片<br/>
	 * @return String biLocLgImg
	 */
	public String getBiLocLgImg()
	{
		return biLocLgImg;
	}

	/**
	 * 图书本地大图片<br/>
	 * @param String biLocLgImg
	 */
	public void setBiLocLgImg(String biLocLgImg)
	{
		this.biLocLgImg = biLocLgImg;
	}
	
	/**
	 * 所在书架<br/>
	 * @return String biAddr
	 */
	public String getBiAddr()
	{
		return biAddr;
	}

	/**
	 * 所在书架<br/>
	 * @param String biAddr
	 */
	public void setBiAddr(String biAddr)
	{
		this.biAddr = biAddr;
	}
	
	/**
	 * 电子图书网址<br/>
	 * @return String biEbookUrl
	 */
	public String getBiEbookUrl()
	{
		return biEbookUrl;
	}

	/**
	 * 电子图书网址<br/>
	 * @param String biEbookUrl
	 */
	public void setBiEbookUrl(String biEbookUrl)
	{
		this.biEbookUrl = biEbookUrl;
	}
	
	/**
	 * 作者信息<br/>
	 * @return String biAuthInfo
	 */
	public String getBiAuthInfo()
	{
		return biAuthInfo;
	}

	/**
	 * 作者信息<br/>
	 * @param String biAuthInfo
	 */
	public void setBiAuthInfo(String biAuthInfo)
	{
		this.biAuthInfo = biAuthInfo;
	}
	
	/**
	 * 入库日期<br/>
	 * @return String biInDate
	 */
	public String getBiInDate()
	{
		return biInDate;
	}

	/**
	 * 入库日期<br/>
	 * @param String biInDate
	 */
	public void setBiInDate(String biInDate)
	{
		this.biInDate = biInDate;
	}
	
	/**
	 * 入库人<br/>
	 * @return String biInUser
	 */
	public String getBiInUser()
	{
		return biInUser;
	}

	/**
	 * 入库人<br/>
	 * @param String biInUser
	 */
	public void setBiInUser(String biInUser)
	{
		this.biInUser = biInUser;
	}
	
	/**
	 * 创建日期<br/>
	 * @return String addDate
	 */
	public String getAddDate()
	{
		return addDate;
	}

	/**
	 * 创建日期<br/>
	 * @param String addDate
	 */
	public void setAddDate(String addDate)
	{
		this.addDate = addDate;
	}
	
	/**
	 * 创建时间<br/>
	 * @return String addTime
	 */
	public String getAddTime()
	{
		return addTime;
	}

	/**
	 * 创建时间<br/>
	 * @param String addTime
	 */
	public void setAddTime(String addTime)
	{
		this.addTime = addTime;
	}
	
	/**
	 * 创建人<br/>
	 * @return String addUser
	 */
	public String getAddUser()
	{
		return addUser;
	}

	/**
	 * 创建人<br/>
	 * @param String addUser
	 */
	public void setAddUser(String addUser)
	{
		this.addUser = addUser;
	}
	
	/**
	 * 最后修改日期<br/>
	 * @return String updDate
	 */
	public String getUpdDate()
	{
		return updDate;
	}

	/**
	 * 最后修改日期<br/>
	 * @param String updDate
	 */
	public void setUpdDate(String updDate)
	{
		this.updDate = updDate;
	}
	
	/**
	 * 最后修改时间<br/>
	 * @return String updTime
	 */
	public String getUpdTime()
	{
		return updTime;
	}

	/**
	 * 最后修改时间<br/>
	 * @param String updTime
	 */
	public void setUpdTime(String updTime)
	{
		this.updTime = updTime;
	}
	
	/**
	 * 最后修改人<br/>
	 * @return String updUser
	 */
	public String getUpdUser()
	{
		return updUser;
	}

	/**
	 * 最后修改人<br/>
	 * @param String updUser
	 */
	public void setUpdUser(String updUser)
	{
		this.updUser = updUser;
	}

	public static void specHandForShow(LibBooksInfo libBooksInfo)
	{
		if(libBooksInfo == null)
		{
			return;
		}

		if(StringUtils.isNotEmpty(libBooksInfo.getBiBookCata()))
		{
			String cat = libBooksInfo.getBiBookCata();
			cat = cat.replaceAll("(\\r\\n|\\r|\\n|\\n\\r)","<br/>");
			libBooksInfo.setBiBookCata(cat);
		}
	}
	
	
	@Override
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		
		sb.append("biCode=" + biCode).append("\n");
		sb.append("biStatus=" + biStatus).append("\n");
		sb.append("biSendStatus=" + biSendStatus).append("\n");
		sb.append("biName=" + biName).append("\n");
		sb.append("biOriName=" + biOriName).append("\n");
		sb.append("biIsbn=" + biIsbn).append("\n");
		sb.append("biPublishDate=" + biPublishDate).append("\n");
		sb.append("biAuth=" + biAuth).append("\n");
		sb.append("biTranslater=" + biTranslater).append("\n");
		sb.append("biVersion=" + biVersion).append("\n");
		sb.append("biTypeCode=" + biTypeCode).append("\n");
		sb.append("biType=" + biType).append("\n");
		sb.append("biPress=" + biPress).append("\n");
		sb.append("biPrice=" + biPrice).append("\n");
		sb.append("biPageCount=" + biPageCount).append("\n");
		sb.append("biBookSize=" + biBookSize).append("\n");
		sb.append("biBookBrief=" + biBookBrief).append("\n");
		sb.append("biBookCata=" + biBookCata).append("\n");
		sb.append("biRemSmImg=" + biRemSmImg).append("\n");
		sb.append("biRemLgImg=" + biRemLgImg).append("\n");
		sb.append("biLocSmImg=" + biLocSmImg).append("\n");
		sb.append("biLocLgImg=" + biLocLgImg).append("\n");
		sb.append("biAddr=" + biAddr).append("\n");
		sb.append("biEbookUrl=" + biEbookUrl).append("\n");
		sb.append("biAuthInfo=" + biAuthInfo).append("\n");
		sb.append("biInDate=" + biInDate).append("\n");
		sb.append("biInUser=" + biInUser).append("\n");
		sb.append("addDate=" + addDate).append("\n");
		sb.append("addTime=" + addTime).append("\n");
		sb.append("addUser=" + addUser).append("\n");
		sb.append("updDate=" + updDate).append("\n");
		sb.append("updTime=" + updTime).append("\n");
		sb.append("updUser=" + updUser).append("\n");
		return sb.toString();
	}
}
