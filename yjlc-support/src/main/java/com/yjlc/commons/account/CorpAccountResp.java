package com.yjlc.commons.account;

import com.yjlc.commons.ApiServiceMessage;

/**
 * 企业开户响应
 * 
 * M：必须字段 O：可选子段
 * 
 * @author wangxiushan(2015-01-12)
 */
public class CorpAccountResp extends ApiServiceMessage {

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
