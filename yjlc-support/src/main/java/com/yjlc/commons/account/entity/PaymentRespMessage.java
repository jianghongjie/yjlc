package com.yjlc.commons.account.entity;

import java.math.BigDecimal;

/**
 * 
 * 备付金转账单条返回明细节点
 * @author:	zyt  
 * @date:	2016年7月31日 上午11:42:29
 */
public class PaymentRespMessage {
	/** 前置交易流水号 **/
	private String frontTrdNum;
	/** 网关流水号 M **/
	private String bsspTrdNum;
	/** 银行交易状态 0 **/
	private String bankRespCode;
	/** 银行状态描述 0 **/
	private String bankRespMsg;
	/** 订单号 */
	private String ordId;
	/** 交易金额 & M **/
	private BigDecimal trdAmount;
	/** 付款人用户号 & M **/
	private String outCusCode;
	/** 付款人账户 & M **/
	private String outAccCode;
	/** 收款人用户号 & M **/
	private String inCusCode;
	/** 收款人账户 & M **/
	private String inAccCode;
	/** 私有域 **/
	private String merPriv;

	public String getBankRespMsg() {
		return bankRespMsg;
	}

	public void setBankRespMsg(String bankRespMsg) {
		this.bankRespMsg = bankRespMsg;
	}

	public String getBankRespCode() {
		return bankRespCode;
	}

	public void setBankRespCode(String bankRespCode) {
		this.bankRespCode = bankRespCode;
	}

	public String getBsspTrdNum() {
		return bsspTrdNum;
	}

	public void setBsspTrdNum(String bsspTrdNum) {
		this.bsspTrdNum = bsspTrdNum;
	}

	public String getFrontTrdNum() {
		return frontTrdNum;
	}

	public void setFrontTrdNum(String frontTrdNum) {
		this.frontTrdNum = frontTrdNum;
	}

	public String getOrdId() {
		return ordId;
	}

	public void setOrdId(String ordId) {
		this.ordId = ordId;
	}

	public BigDecimal getTrdAmount() {
		return trdAmount;
	}

	public void setTrdAmount(BigDecimal trdAmount) {
		this.trdAmount = trdAmount;
	}

	public String getOutCusCode() {
		return outCusCode;
	}

	public void setOutCusCode(String outCusCode) {
		this.outCusCode = outCusCode;
	}

	public String getOutAccCode() {
		return outAccCode;
	}

	public void setOutAccCode(String outAccCode) {
		this.outAccCode = outAccCode;
	}

	public String getInCusCode() {
		return inCusCode;
	}

	public void setInCusCode(String inCusCode) {
		this.inCusCode = inCusCode;
	}

	public String getInAccCode() {
		return inAccCode;
	}

	public void setInAccCode(String inAccCode) {
		this.inAccCode = inAccCode;
	}

	public String getMerPriv() {
		return merPriv;
	}

	public void setMerPriv(String merPriv) {
		this.merPriv = merPriv;
	}
}
