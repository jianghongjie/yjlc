package com.yjlc.commons.account.entity;

import java.math.BigDecimal;

/**
 * 
 * 备付金转账单条明细节点
 * @author:	zyt  
 * @date:	2016年7月31日 上午11:42:29
 */
public class PaymentReqMessage {
	/** 前置交易流水号 **/
	private String frontTrdNum;

	/** 交易金额 & M **/
	private BigDecimal trdAmount;

	/** 收款人用户号 & M **/
	private String cusCode;

	/** 收款人账户 & M **/
	private String accCode;

	/** 用户类型 & M & 1:融资人 3:投资人 **/
	private String userType;

	/** 商户后台应答地址 & M **/
	private String bgRetUrl;

	/** 私有域 **/
	private String merPriv;


	public PaymentReqMessage() {
	}

	public String getFrontTrdNum() {
		return frontTrdNum;
	}

	public void setFrontTrdNum(String frontTrdNum) {
		this.frontTrdNum = frontTrdNum;
	}

	public BigDecimal getTrdAmount() {
		return trdAmount;
	}

	public void setTrdAmount(BigDecimal trdAmount) {
		this.trdAmount = trdAmount;
	}

	public String getCusCode() {
		return cusCode;
	}

	public void setCusCode(String cusCode) {
		this.cusCode = cusCode;
	}

	public String getAccCode() {
		return accCode;
	}

	public void setAccCode(String accCode) {
		this.accCode = accCode;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public String getBgRetUrl() {
		return bgRetUrl;
	}

	public void setBgRetUrl(String bgRetUrl) {
		this.bgRetUrl = bgRetUrl;
	}

	public String getMerPriv() {
		return merPriv;
	}

	public void setMerPriv(String merPriv) {
		this.merPriv = merPriv;
	}

}
