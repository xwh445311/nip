package com.efs.common.sysparam.mapper;

import java.math.BigDecimal;

/**
 * 
 * com.efs.common.sysparam.mapper.TsParamInfo
 * @author xuwh
 * 2020-08-13 22:47:02
 * 
 *
 */
public class TsParamInfo
{
	/**
	 * 
	 */
	private String paType;
	
	/**
	 * 
	 */
	private String paKey;
	
	/**
	 * 
	 */
	private String paValue;
	
	/**
	 * 
	 */
	private String paSesc;
	
	/**
	 * 
	 */
	private Integer paOrder;
	
	/**
	 * 
	 */
	private String paStatus;
	
	
	/**
	 * <br/>
	 * @return String paType
	 */
	public String getPaType()
	{
		return paType;
	}

	/**
	 * <br/>
	 * @param String paType
	 */
	public void setPaType(String paType)
	{
		this.paType = paType;
	}
	
	/**
	 * <br/>
	 * @return String paKey
	 */
	public String getPaKey()
	{
		return paKey;
	}

	/**
	 * <br/>
	 * @param String paKey
	 */
	public void setPaKey(String paKey)
	{
		this.paKey = paKey;
	}
	
	/**
	 * <br/>
	 * @return String paValue
	 */
	public String getPaValue()
	{
		return paValue;
	}

	/**
	 * <br/>
	 * @param String paValue
	 */
	public void setPaValue(String paValue)
	{
		this.paValue = paValue;
	}
	
	/**
	 * <br/>
	 * @return String paSesc
	 */
	public String getPaSesc()
	{
		return paSesc;
	}

	/**
	 * <br/>
	 * @param String paSesc
	 */
	public void setPaSesc(String paSesc)
	{
		this.paSesc = paSesc;
	}
	
	/**
	 * <br/>
	 * @return BigDecimal paOrder
	 */
	public Integer getPaOrder()
	{
		return paOrder;
	}

	/**
	 * <br/>
	 * @param BigDecimal paOrder
	 */
	public void setPaOrder(Integer paOrder)
	{
		this.paOrder = paOrder;
	}
	
	/**
	 * <br/>
	 * @return String paStatus
	 */
	public String getPaStatus()
	{
		return paStatus;
	}

	/**
	 * <br/>
	 * @param String paStatus
	 */
	public void setPaStatus(String paStatus)
	{
		this.paStatus = paStatus;
	}
	
	
	@Override
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		
		sb.append("paType=" + paType).append("\n");
		sb.append("paKey=" + paKey).append("\n");
		sb.append("paValue=" + paValue).append("\n");
		sb.append("paSesc=" + paSesc).append("\n");
		sb.append("paOrder=" + paOrder).append("\n");
		sb.append("paStatus=" + paStatus).append("\n");
		return sb.toString();
	}
}
