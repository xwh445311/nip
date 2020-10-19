package com.efs.common.database;

import java.util.List;

/**
 * 绑定JQUERY EASY UI DATA GRID数据
 * @author xwh
 *
 */
public class PageDataBunder
{
	private int total;
	
	private List<?> rows;

	public int getTotal()
	{
		return total;
	}

	public void setTotal(int total)
	{
		this.total = total;
	}

	public List<?> getRows()
	{
		return rows;
	}

	public void setRows(List<?> rows)
	{
		this.rows = rows;
	}

	
	
	
}
