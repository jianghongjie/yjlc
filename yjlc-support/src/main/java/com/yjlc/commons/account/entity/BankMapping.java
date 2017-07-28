package com.yjlc.commons.account.entity;

import com.joinwe.common.api.dto.BaseEntity;

/**
 * 三方映射表实体类
 * 
 * @author wangxiushan(2015-01-14)
 *
 */
public class BankMapping extends BaseEntity {

	private static final long serialVersionUID = 1L;

	/** 映射ID  **/
	private String mappingId;
	
	/** 银行名称  **/
	private String bankName;
	
	/** 银行编号  **/
	private String bankCode;
	
	/** 三方编号  **/
	private String chlCode;
	
	/** 三方银行编号 **/
	private String chlBankCode;
	
	/** 状态  **/
	private String status;
	
	/** 提现渠道  **/
	private String cashChl;

	public String getMappingId() {
		return mappingId;
	}

	public void setMappingId(String mappingId) {
		this.mappingId = mappingId;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCashChl() {
		return cashChl;
	}

	public void setCashChl(String cashChl) {
		this.cashChl = cashChl;
	}

}
