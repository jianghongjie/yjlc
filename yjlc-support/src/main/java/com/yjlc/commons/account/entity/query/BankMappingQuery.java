package com.yjlc.commons.account.entity.query;

import com.joinwe.common.api.dto.BaseQuery;

/**
 * 银行三方映射表查询实体类
 * 
 * @author wangxiushan(2015-01-17)
 *
 */
public class BankMappingQuery extends BaseQuery {
	
	private static final long serialVersionUID = 1L;
	
	/** 银行编号 **/
	private String bankCode;
	
	/** 三方编号 **/
	private String chlCode;
	
	/** 三方银行编号 **/
	private String chlBankCode;
	
	public String getBankCode() {
		return bankCode;
	}

	public void setBankCode(String bankCode) {
		this.bankCode = bankCode;
	}

	public String getChlCode() {
		return chlCode;
	}

	public void setChlCode(String chlCode) {
		this.chlCode = chlCode;
	}

	public String getChlBankCode() {
		return chlBankCode;
	}

	public void setChlBankCode(String chlBankCode) {
		this.chlBankCode = chlBankCode;
	}

}
