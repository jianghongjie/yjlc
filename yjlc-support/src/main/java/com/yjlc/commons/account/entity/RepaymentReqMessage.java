package com.yjlc.commons.account.entity;

import java.math.BigDecimal;

/**
 * 还款请求明细
 * @author:	zyt  
 * @date:	2016年8月1日 上午10:24:14
 */
public class RepaymentReqMessage {
	/** 前置交易流水号 **/
	private String frontTrdNum;
	/** 出账客户号 */
	private String outCustId;
	/** 订单号 */
	private String subOrdId;
	/** 订单日期  **/
	private String subOrdDate;
	/** 还款本金 */
	private BigDecimal principalAmt;
	/** 还款利息 */
	private BigDecimal interestAmt;
	/** 入账客户号 */
	private String inCustId;
	/** 分账账户串 */
	private String divDetails;
	/** 商户后台 应答地址 */
	private String bgRetUrl;

	public String getFrontTrdNum() {
		return frontTrdNum;
	}
	public void setFrontTrdNum(String frontTrdNum) {
		this.frontTrdNum = frontTrdNum;
	}
	public String getOutCustId() {
		return outCustId;
	}
	public void setOutCustId(String outCustId) {
		this.outCustId = outCustId;
	}
	public String getSubOrdId() {
		return subOrdId;
	}
	public void setSubOrdId(String subOrdId) {
		this.subOrdId = subOrdId;
	}
	public String getSubOrdDate() {
		return subOrdDate;
	}
	public void setSubOrdDate(String subOrdDate) {
		this.subOrdDate = subOrdDate;
	}
	public BigDecimal getPrincipalAmt() {
		return principalAmt;
	}
	public void setPrincipalAmt(BigDecimal principalAmt) {
		this.principalAmt = principalAmt;
	}
	public BigDecimal getInterestAmt() {
		return interestAmt;
	}
	public void setInterestAmt(BigDecimal interestAmt) {
		this.interestAmt = interestAmt;
	}
	public String getInCustId() {
		return inCustId;
	}
	public void setInCustId(String inCustId) {
		this.inCustId = inCustId;
	}
	public String getDivDetails() {
		return divDetails;
	}
	public void setDivDetails(String divDetails) {
		this.divDetails = divDetails;
	}
	public String getBgRetUrl() {
		return bgRetUrl;
	}
	public void setBgRetUrl(String bgRetUrl) {
		this.bgRetUrl = bgRetUrl;
	}

}
