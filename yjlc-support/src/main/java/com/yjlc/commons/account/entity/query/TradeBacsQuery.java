package com.yjlc.commons.account.entity.query;

import com.joinwe.common.api.dto.BaseQuery;

/**
 * 核心账务前置交易查询类
 * 
 * @author xiushan.w（2015-03-11）
 */
public class TradeBacsQuery extends BaseQuery {
	private static final long serialVersionUID = 1L;

	/** 前置交易流水号 **/
	private String frtTrdNum;
	/** 交易代码 **/
	private String trdCode;
	/** 业务类型 **/
	private String bizType;
	/** 网关交易流水号 **/
	private String trdNum;
	/** 状态 **/
	private String status;

	public String getFrtTrdNum() {
		return frtTrdNum;
	}

	public void setFrtTrdNum(String frtTrdNum) {
		this.frtTrdNum = frtTrdNum;
	}

	public String getTrdNum() {
		return trdNum;
	}

	public void setTrdNum(String trdNum) {
		this.trdNum = trdNum;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getTrdCode() {
		return trdCode;
	}

	public void setTrdCode(String trdCode) {
		this.trdCode = trdCode;
	}

	public String getBizType() {
		return bizType;
	}

	public void setBizType(String bizType) {
		this.bizType = bizType;
	}

}
