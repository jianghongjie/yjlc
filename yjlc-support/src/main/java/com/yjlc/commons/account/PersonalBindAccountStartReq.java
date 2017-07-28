package com.yjlc.commons.account;

import com.yjlc.commons.ApiServiceMessage;

/**
 * 个人投资客户分段开户请求(开始)（第二步，绑卡及换绑卡）
 * 
 * M：必须字段 O：可选子段
 * 
 * @author wangxiushan(2015-01-15)
 * 
 */
public class PersonalBindAccountStartReq extends ApiServiceMessage {

	private static final long serialVersionUID = 1L;

	/** 客户（企业）编号 & M **/
	private String cusCode;

	/** 卡号 & M **/
	private String cardNum;

	/** 银行号 & M **/
	private String bankCode;

	/** 返回地址 & M **/
	private String webUrl;

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

	public String getWebUrl() {
		return webUrl;
	}

	public void setWebUrl(String webUrl) {
		this.webUrl = webUrl;
	}

}
