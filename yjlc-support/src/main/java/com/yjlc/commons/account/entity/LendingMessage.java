package com.yjlc.commons.account.entity;

import java.math.BigDecimal;

public class LendingMessage {
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

	// 投资金额（放款金额包含红包的金额）
	private BigDecimal trdAmt;

	public BigDecimal getTrdAmt() {
		return trdAmt;
	}

	public void setTrdAmt(BigDecimal trdAmt) {
		this.trdAmt = trdAmt;
	}

	// 收益金额
	private BigDecimal icAmt;

	public BigDecimal getIcAmt() {
		return icAmt;
	}

	public void setIcAmt(BigDecimal icAmt) {
		this.icAmt = icAmt;
	}

	// 抵扣金额
	private BigDecimal dedAmt;

	public BigDecimal getDedAmt() {
		return dedAmt;
	}

	public void setDedAmt(BigDecimal dedAmt) {
		this.dedAmt = dedAmt;
	}
}