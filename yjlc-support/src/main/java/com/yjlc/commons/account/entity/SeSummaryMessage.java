package com.yjlc.commons.account.entity;

import java.math.BigDecimal;

/**
 * 二级交易账户 资产汇总信息
 */
public class SeSummaryMessage {

	/** 编号 **/
	private Integer id;
	/** 二级交易账号 **/
	private String accCode;
	/** 账户余额 总和 **/
	private BigDecimal avaAssert;
	/** 不可用金额（冻结金额）总和 **/
	private BigDecimal lockAssert;
	/** 负债金额 总和 **/
	private BigDecimal debtAssert;
	/** 币种 **/
	private String crCode;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAccCode() {
		return accCode;
	}

	public void setAccCode(String accCode) {
		this.accCode = accCode;
	}

	public BigDecimal getAvaAssert() {
		return avaAssert;
	}

	public void setAvaAssert(BigDecimal avaAssert) {
		this.avaAssert = avaAssert;
	}

	public BigDecimal getLockAssert() {
		return lockAssert;
	}

	public void setLockAssert(BigDecimal lockAssert) {
		this.lockAssert = lockAssert;
	}

	public BigDecimal getDebtAssert() {
		return debtAssert;
	}

	public void setDebtAssert(BigDecimal debtAssert) {
		this.debtAssert = debtAssert;
	}

	public String getCrCode() {
		return crCode;
	}

	public void setCrCode(String crCode) {
		this.crCode = crCode;
	}
}
