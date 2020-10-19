package com.efs.common.database;

/**
 * 系统分页类
 * @author xwh
 *
 */
public class Page
{
	/**
	 * 当前页
	 */
	private int page;
	
	//每页多少行
	private int rows = 50;
	
	//总共多少条数据
	private int total;

	/**
	 * 因为使用了PAGE插件，OFFSET取当前页
	 * @return
	 */
	public int getOffset()
	{
		//return (page-1) * rows;
		return page;
	}
	
	public int getOffsetRow()
	{
		return (page-1) * rows;
	}
	
	public int getPage()
	{
		return page;
	}

	public void setPage(int page)
	{
		this.page = page;
	}

	public int getRows()
	{
		return rows;
	}

	public void setRows(int rows)
	{
		this.rows = rows;
	}

	public int getTotal()
	{
		return total;
	}

	public void setTotal(int total)
	{
		this.total = total;
	}
	
	
}
