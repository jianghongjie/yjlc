package com.yjlc.commons.account;

import com.yjlc.commons.ApiServiceMessage;

/**
 * 绑卡和换绑响应实体类
 * 
 * M：必填 O：可空
 * 
 * @author zshen（2015-10-10）
 */
public class AccountBindBankReq extends ApiServiceMessage {

	private static final long serialVersionUID = 1L;

	/** 客户（企业）编号 & M **/
	private String cusCode;

	/** 卡号 & M **/
	private String cardNum;

	/** 银行号 & M **/
	private String bankCode;

	public String getCusCode() {
		return cusCode;
	}

	public void setCusCode(String cusCode) {
		this.cusCode = cusCode;
	}

	public String getCardNum() {
		return cardNum;
	}

	public void setCardNum(String cardNum) {
		this.cardNum = cardNum;
	}

	public String getBankCode() {
		return bankCode;
	}

	public void setBankCode(String bankCode) {
		this.bankCode = bankCode;
	}

}
