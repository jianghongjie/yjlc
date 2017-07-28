package com.yjlc.commons.account;

import com.yjlc.commons.ApiServiceMessage;

/**
 * 企业开户请求(5.2.2 企业融资人开户申请)
 * 
 * M：必须字段 O：可选子段
 * 
 * @author wangxiushan(2015-01-12)
 * 
 */
public class CorpAccountReq extends ApiServiceMessage {

	private static final long serialVersionUID = 1L;

	/** 客户（企业）编号 & M **/
	private String cusCode;

	/** 真实姓名 & M **/
	private String realName;

	/** 开户证件类型 & M **/
	private String idType;

	/** 开户证件号 & M **/
	private String idNum;

	/** 联系人手机号 & M **/
	private String cusMobile;

	/** 银行编号 & M **/
	private String bankCode;

	/** 商户银行账户号 & M **/
	private String cardNum;

	/** 开户银行名称 & O **/
	private String bankName;

	/** 是否需要验证 & M & 0：不需要 **/
	private String isVerify;

	public String getCusCode() {
		return cusCode;
	}

	public void setCusCode(String cusCode) {
		this.cusCode = cusCode;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getIdType() {
		return idType;
	}

	public void setIdType(String idType) {
		this.idType = idType;
	}

	public String getIdNum() {
		return idNum;
	}

	public void setIdNum(String idNum) {
		this.idNum = idNum;
	}

	public String getCusMobile() {
		return cusMobile;
	}

	public void setCusMobile(String cusMobile) {
		this.cusMobile = cusMobile;
	}

	public String getBankCode() {
		return bankCode;
	}

	public void setBankCode(String bankCode) {
		this.bankCode = bankCode;
	}

	public String getCardNum() {
		return cardNum;
	}

	public void setCardNum(String cardNum) {
		this.cardNum = cardNum;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getIsVerify() {
		return isVerify;
	}

	public void setIsVerify(String isVerify) {
		this.isVerify = isVerify;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
