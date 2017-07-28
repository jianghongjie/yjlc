package com.yjlc.commons.account;

import com.yjlc.commons.ApiServiceMessage;

/**
 * 个人投资客户分段开户响应(开始)（第二步，绑卡及换绑卡）
 * 
 *  M：必须字段 O：可选子段
 * 
 * @author wangxiushan(2015-01-15)
 * 
 */
public class PersonalBindAccountStartResp extends ApiServiceMessage {

	private static final long serialVersionUID = 1L;

	/** form表单 M **/
	private String form;
	
	/** 网关流水号 M **/
	private String bsspTrdNum;

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

}
