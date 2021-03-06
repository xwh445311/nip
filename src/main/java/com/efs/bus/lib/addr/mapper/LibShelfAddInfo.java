package com.efs.bus.lib.addr.mapper;

/**
 * 
 * com.efs.bus.lib.addr.mapper.LibShelfAddInfo
 * @author xwh
 * 2018-03-20 23:46:18
 * 书架信息表
 *
 */
public class LibShelfAddInfo
{
	/**
	 * 地址编号:由架号+层号+列号组成
	 */
	private String siCode;
	
	/**
	 * 书架号
	 */
	private Integer siShelfNo;
	
	/**
	 * 所在层号
	 */
	private Integer siRow;
	
	/**
	 * 所在列号
	 */
	private Integer siCol;
	
	/**
	 * 地址状态:0未用，1使用中，3：用满
	 */
	private String siStatus;

	/**
	 * 对应的CSS字符串
	 */
	private String siStatusCss;
	
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
	 * 地址编号:由架号+层号+列号组成<br/>
	 * @return String siCode
	 */
	public String getSiCode()
	{
		return siCode;
	}

	/**
	 * 地址编号:由架号+层号+列号组成<br/>
	 * @param String siCode
	 */
	public void setSiCode(String siCode)
	{
		this.siCode = siCode;
	}
	
	/**
	 * 书架号<br/>
	 * @return Integer siShelfNo
	 */
	public Integer getSiShelfNo()
	{
		return siShelfNo;
	}

	/**
	 * 书架号<br/>
	 * @param Integer siShelfNo
	 */
	public void setSiShelfNo(Integer siShelfNo)
	{
		this.siShelfNo = siShelfNo;
	}
	
	/**
	 * 所在层号<br/>
	 * @return Integer siRow
	 */
	public Integer getSiRow()
	{
		return siRow;
	}

	/**
	 * 所在层号<br/>
	 * @param Integer siRow
	 */
	public void setSiRow(Integer siRow)
	{
		this.siRow = siRow;
	}
	
	/**
	 * 所在列号<br/>
	 * @return Integer siCol
	 */
	public Integer getSiCol()
	{
		return siCol;
	}

	/**
	 * 所在列号<br/>
	 * @param Integer siCol
	 */
	public void setSiCol(Integer siCol)
	{
		this.siCol = siCol;
	}
	
	/**
	 * 地址状态:0未用，1使用中，3：用满<br/>
	 * @return String siStatus
	 */
	public String getSiStatus()
	{
		return siStatus;
	}

	/**
	 * 地址状态:0未用，1使用中，3：用满<br/>
	 * @param String siStatus
	 */
	public void setSiStatus(String siStatus)
	{
		this.siStatus = siStatus;
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

	public String getSiStatusCss()
	{
		siStatusCss = "";

		if("0".equals(siStatus))
		{
			siStatusCss = "BOOK_EMPTY";
		}
		else if("1".equals(siStatus))
		{
			siStatusCss = "BOOK_USE";
		}
		else
		{
			siStatusCss = "BOOK_FULL";
		}

		return siStatusCss;
	}

	@Override
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		
		sb.append("siCode=" + siCode).append("\n");
		sb.append("siShelfNo=" + siShelfNo).append("\n");
		sb.append("siRow=" + siRow).append("\n");
		sb.append("siCol=" + siCol).append("\n");
		sb.append("siStatus=" + siStatus).append("\n");
		sb.append("addDate=" + addDate).append("\n");
		sb.append("addTime=" + addTime).append("\n");
		sb.append("addUser=" + addUser).append("\n");
		return sb.toString();
	}
}
