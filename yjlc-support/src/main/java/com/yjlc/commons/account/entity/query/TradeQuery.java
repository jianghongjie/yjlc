package com.yjlc.commons.account.entity.query;

import com.joinwe.common.api.dto.BaseQuery;

/**
 * 通道交易流水表查询实体类
 * 
 * @author wangxiushan(2015-01-17)
 * 
 */
public class TradeQuery extends BaseQuery {

	private static final long serialVersionUID = 1L;
	
	/** 通道号 **/
	private String chlCode;

	/** 网关交易流水号 **/
	private String trdNum;

	/** 通道交易流水号 **/
	private String chlTrdNum;

	/** 前置交易流水号 **/
	private String frtTrdNum;
	
	/** 三方交易流水号 **/
	private String chlRetNum;
	
	/** 状态 **/
	private String status;

	public String getChlRetNum() {
		return chlRetNum;
	}

	public void setChlRetNum(String chlRetNum) {
		this.chlRetNum = chlRetNum;
	}

	public String getChlCode() {
		return chlCode;
	}

	public void setChlCode(String chlCode) {
		this.chlCode = chlCode;
	}

	public String getTrdNum() {
		return trdNum;
	}

	public void setTrdNum(String trdNum) {
		this.trdNum = trdNum;
	}

	public String getChlTrdNum() {
		return chlTrdNum;
	}

	public void setChlTrdNum(String chlTrdNum) {
		this.chlTrdNum = chlTrdNum;
	}

	public String getFrtTrdNum() {
		return frtTrdNum;
	}

	public void setFrtTrdNum(String frtTrdNum) {
		this.frtTrdNum = frtTrdNum;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
