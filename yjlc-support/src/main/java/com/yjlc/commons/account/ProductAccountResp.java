package com.yjlc.commons.account;

import com.yjlc.commons.ApiServiceMessage;

/**
 * 标的登记响应
 * 
 * @author wangxiushan(2015-01-12)
 * 
 */
public class ProductAccountResp extends ApiServiceMessage {

	private static final long serialVersionUID = 1L;
	
	/** 网关流水号 M **/
	private String bsspTrdNum;
	
	/** 银行交易状态 0 **/
	private String bankRespCode;
	
	/** 银行状态描述 0 **/
	private String bankRespMsg;

	public String getBankRespMsg() {
		return bankRespMsg;
	}

	public void setBankRespMsg(String bankRespMsg) {
		this.bankRespMsg = bankRespMsg;
	}

	public String getBankRespCode() {
		return bankRespCode;
	}

	public void setBankRespCode(String bankRespCode) {
		this.bankRespCode = bankRespCode;
	}

	public String getBsspTrdNum() {
		return bsspTrdNum;
	}

	public void setBsspTrdNum(String bsspTrdNum) {
		this.bsspTrdNum = bsspTrdNum;
	}

}
