package com.yjlc.commons.account.entity;

import java.math.BigDecimal;

/**
 * 还款返回响应明细
 * @author:	zyt  
 * @date:	2016年8月1日 上午10:31:36
 */
public class RepaymentRespMessage {
	/** 银行交易状态 0 **/
	private String bankRespCode;
	/** 银行状态描述 0 **/
	private String bankRespMsg;
	/** 前置交易流水号 **/
	private String frontTrdNum;
	/** 网关流水号 M **/
	private String bsspTrdNum;

	/** 订单号 */
	private String OrdId;
	/** 订单日期 */
	private String OrdDate;
	/** 出账客户号 */
	private String OutCustId;
	/** 订单号 */
	private String SubOrdId;
	/** 订单日期 */
	private String SubOrdDate;
	/** 出账子账户 */
	private String OutAcctId;
	/** 还款本金 */
	private BigDecimal PrincipalAmt;
	/** 还款利息 */
	private BigDecimal InterestAmt;
	/** 扣款手续费 */
	private BigDecimal Fee;
	/** 入账客户号 */
	private String InCustId;
	/** 入账子账户 */
	private String InAcctId;
	/** 商户私有域 */
	private String MerPriv;

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


	public String getOrdId() {
		return OrdId;
	}

	public void setOrdId(String ordId) {
		OrdId = ordId;
	}

	public String getOrdDate() {
		return OrdDate;
	}

	public void setOrdDate(String ordDate) {
		OrdDate = ordDate;
	}

	public String getOutCustId() {
		return OutCustId;
	}

	public void setOutCustId(String outCustId) {
		OutCustId = outCustId;
	}

	public String getSubOrdId() {
		return SubOrdId;
	}

	public void setSubOrdId(String subOrdId) {
		SubOrdId = subOrdId;
	}

	public String getSubOrdDate() {
		return SubOrdDate;
	}

	public void setSubOrdDate(String subOrdDate) {
		SubOrdDate = subOrdDate;
	}

	public String getOutAcctId() {
		return OutAcctId;
	}

	public void setOutAcctId(String outAcctId) {
		OutAcctId = outAcctId;
	}

	public BigDecimal getPrincipalAmt() {
		return PrincipalAmt;
	}

	public void setPrincipalAmt(BigDecimal principalAmt) {
		PrincipalAmt = principalAmt;
	}

	public BigDecimal getInterestAmt() {
		return InterestAmt;
	}

	public void setInterestAmt(BigDecimal interestAmt) {
		InterestAmt = interestAmt;
	}

	public BigDecimal getFee() {
		return Fee;
	}

	public void setFee(BigDecimal fee) {
		Fee = fee;
	}

	public String getInCustId() {
		return InCustId;
	}

	public void setInCustId(String inCustId) {
		InCustId = inCustId;
	}

	public String getInAcctId() {
		return InAcctId;
	}

	public void setInAcctId(String inAcctId) {
		InAcctId = inAcctId;
	}

	public String getMerPriv() {
		return MerPriv;
	}

	public void setMerPriv(String merPriv) {
		MerPriv = merPriv;
	}

	public String getFrontTrdNum() {
		return frontTrdNum;
	}

	public void setFrontTrdNum(String frontTrdNum) {
		this.frontTrdNum = frontTrdNum;
	}

	public String getBsspTrdNum() {
		return bsspTrdNum;
	}

	public void setBsspTrdNum(String bsspTrdNum) {
		this.bsspTrdNum = bsspTrdNum;
	}

}
