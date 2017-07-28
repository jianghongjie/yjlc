package com.yjlc.commons.account;

import com.yjlc.commons.ApiServiceMessage;

/**
 * 开户响应实体类
 * 
 * @author wangxiushan(2015-01-20)
 *
 */
public class OpenAccountResp extends ApiServiceMessage{

	private static final long serialVersionUID = 1L;
	
	/** 二级交易账户 **/
	private String seAccCode;
	
	/** 账户名称 **/
	private String accName;
	
	/** 网关流水号 **/
	private String bsspTrdNum;

	public String getSeAccCode() {
		return seAccCode;
	}

	public void setSeAccCode(String seAccCode) {
		this.seAccCode = seAccCode;
	}

	public String getAccName() {
		return accName;
	}

	public void setAccName(String accName) {
		this.accName = accName;
	}

	public String getBsspTrdNum() {
		return bsspTrdNum;
	}

	public void setBsspTrdNum(String bsspTrdNum) {
		this.bsspTrdNum = bsspTrdNum;
	}
	
}
