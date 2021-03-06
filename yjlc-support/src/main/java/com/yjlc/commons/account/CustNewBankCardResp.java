package com.yjlc.commons.account;

import com.yjlc.commons.ApiServiceMessage;

/**
 * 5.2.46.1	个人客户银行卡绑定AE0046
 * 
 * M：必须字段 O：可选子段
 * 
 * @author zshen(2015-11-11)
 * 
 */
public class CustNewBankCardResp extends ApiServiceMessage {

	private static final long serialVersionUID = 1L;

	/** form表单 M **/
	private String form;
	
	/** 网关流水号 M **/
	private String bsspTrdNum;
	
	/** 银行交易状态 M **/
	private String bankRespCode;

	/** 银行状态描述 0 **/
	private String bankRespMsg;

	public String getBsspTrdNum() {
		return bsspTrdNum;
	}

	public void setBsspTrdNum(String bsspTrdNum) {
		this.bsspTrdNum = bsspTrdNum;
	}

	public String getForm() {
		return form;
	}

	public void setForm(String form) {
		this.form = form;
	}

	public String getBankRespCode() {
		return bankRespCode;
	}

	public void setBankRespCode(String bankRespCode) {
		this.bankRespCode = bankRespCode;
	}

	public String getBankRespMsg() {
		return bankRespMsg;
	}

	public void setBankRespMsg(String bankRespMsg) {
		this.bankRespMsg = bankRespMsg;
	}
	
	

}