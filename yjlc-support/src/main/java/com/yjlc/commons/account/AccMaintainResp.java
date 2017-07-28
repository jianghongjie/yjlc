package com.yjlc.commons.account;

import com.yjlc.commons.ApiServiceMessage;


public class AccMaintainResp extends ApiServiceMessage{

	private static final long serialVersionUID = 1L;
	
	/** 二级交易账户 **/
	private String seAccCode;
	
	/** 网关流水号 **/
	private String bsspTrdNum;

	public String getSeAccCode() {
		return seAccCode;
	}

	public void setSeAccCode(String seAccCode) {
		this.seAccCode = seAccCode;
	}

	public String getBsspTrdNum() {
		return bsspTrdNum;
	}

	public void setBsspTrdNum(String bsspTrdNum) {
		this.bsspTrdNum = bsspTrdNum;
	}
	
}
