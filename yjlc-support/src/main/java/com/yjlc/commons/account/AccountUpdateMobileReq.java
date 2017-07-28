package com.yjlc.commons.account;

import com.yjlc.commons.ApiServiceMessage;


/**
 * 5.2.33	客户手机号变更
 * 
 * M:必填  O:可空
 * 
 * @author zshen(2015-11-16)
 *
 */
public class AccountUpdateMobileReq extends ApiServiceMessage {

	private static final long serialVersionUID = 1L;

	/** 客户编号  M**/
	private String cusCode;
	
	/** 手机号码 M **/
	private String mobile;

	public String getCusCode() {
		return cusCode;
	}

	public void setCusCode(String cusCode) {
		this.cusCode = cusCode;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
}
