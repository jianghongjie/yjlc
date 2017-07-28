package com.yjlc.commons.account;

import com.yjlc.commons.ApiServiceMessage;

/**
 * 账户余额查询请求实体类
 * 
 * M：必填  O：可空
 * 
 * @author wangxiushan(2015-01-21)
 *
 */
public class AccountBalanceQueryReq extends ApiServiceMessage {

	private static final long serialVersionUID = 1L;

	/** 二级交易账号 M **/
	private String seAccCode;
	
	/** 币种  M **/
	private String crCode;
	
	/** 账户状态(功能户状态 0#初始化 1#已激活 9#已注销) M **/
	private String accStatus;

	/**
	 * 二级交易账号开户模板:  (5:平台备用金账户)
	 */
	private Integer accType;

	public Integer getAccType() {
		return accType;
	}

	public void setAccType(Integer accType) {
		this.accType = accType;
	}

	public AccountBalanceQueryReq(){
		this.accStatus = "1";
	}

	public String getSeAccCode() {
		return seAccCode;
	}

	public void setSeAccCode(String seAccCode) {
		this.seAccCode = seAccCode;
	}

	public String getCrCode() {
		return crCode;
	}

	public void setCrCode(String crCode) {
		this.crCode = crCode;
	}

	public String getAccStatus() {
		return accStatus;
	}

	public void setAccStatus(String accStatus) {
		this.accStatus = accStatus;
	}

}
