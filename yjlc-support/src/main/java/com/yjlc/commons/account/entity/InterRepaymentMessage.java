package com.yjlc.commons.account.entity;

import java.math.BigDecimal;

/**
 * 还款 投资人明细节点
 * 
 * @author: zyt
 * @date: 2016年8月6日 下午3:51:19
 */
public class InterRepaymentMessage {
	// 投资人二级交易账号
	private String accCode;

	public String getAccCode() {
		return accCode;
	}

	public void setAccCode(String accCode) {
		this.accCode = accCode;
	}

	// 交易明细流水号
	private String dtTrdNum;

	public String getDtTrdNum() {
		return dtTrdNum;
	}

	public void setDtTrdNum(String dtTrdNum) {
		this.dtTrdNum = dtTrdNum;
	}

	// 投资金额（还款金额包含红包的金额+收益金额）
	private BigDecimal trdAmt;

	public BigDecimal getTrdAmt() {
		return trdAmt;
	}

	public void setTrdAmt(BigDecimal trdAmt) {
		this.trdAmt = trdAmt;
	}

	// 用户应收金额(除体验金外的本金加利息<包含体验金产生的利息>)
	private BigDecimal receivableAmt;

	// 平台代投资支出金额(体验金)
	private BigDecimal expAmt;

	public BigDecimal getReceivableAmt() {
		return receivableAmt;
	}

	public void setReceivableAmt(BigDecimal receivableAmt) {
		this.receivableAmt = receivableAmt;
	}

	public BigDecimal getExpAmt() {
		return expAmt;
	}

	public void setExpAmt(BigDecimal expAmt) {
		this.expAmt = expAmt;
	}
}
