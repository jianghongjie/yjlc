package com.yjlc.commons.account.entity;

import java.math.BigDecimal;

/**
 * 功能户实体
 */
public class FunctionalMessage {

	/** 功能户自增ID **/
	private Integer id;
	/** 模板ID **/
	private Integer mId;
	/** 功能户号 **/
	private String accCode;
	/**
	 * 功能户类型 功能户类型1#流动资金户 2#贷款资金户 3#待还资金户 4#在途资金户 5#在投资金户 6#内部转账户 7#还款专用户、8 红包账户
	 **/
	private Integer accType;
	/** 功能户状态 0#初始化 1#已激活 9#已注销 **/
	private String accStatus;
	/** 所属二级交易账号 **/
	private String seCode;
	/** 交易币种 **/
	private String crCode;
	/** 账户余额 **/
	private BigDecimal balance;
	/** 不可用金额（冻结金额）不带符号 只能是正数 **/
	private BigDecimal lockedBal;
	/** 交易金额设定上限金额 **/
	private BigDecimal accCeiling;
	/** 交易金额设定下限金额 **/
	private BigDecimal accFloor;
	/** 账户性质 1#资产 2#负债 3#临时 **/
	private Integer accNature;
	/** 余额账户透支类型 0#不可透支 1#可透支 **/
	private Integer balType;
	/** 备注 **/
	private String accMemo;
	/** 扩展字段json格式 **/
	private String exProps;
	/** 创建人 **/
	private String createBy;
	/** 创建时间 **/
	private String createTime;
	/** 修改人 **/
	private String modfiyBy;
	/** 修改时间 **/
	private String modfiyTime;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getmId() {
		return mId;
	}

	public void setmId(Integer mId) {
		this.mId = mId;
	}

	public String getAccCode() {
		return accCode;
	}

	public void setAccCode(String accCode) {
		this.accCode = accCode;
	}

	public Integer getAccType() {
		return accType;
	}

	public void setAccType(Integer accType) {
		this.accType = accType;
	}

	public String getAccStatus() {
		return accStatus;
	}

	public void setAccStatus(String accStatus) {
		this.accStatus = accStatus;
	}

	public String getSeCode() {
		return seCode;
	}

	public void setSeCode(String seCode) {
		this.seCode = seCode;
	}

	public String getCrCode() {
		return crCode;
	}

	public void setCrCode(String crCode) {
		this.crCode = crCode;
	}

	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

	public BigDecimal getLockedBal() {
		return lockedBal;
	}

	public void setLockedBal(BigDecimal lockedBal) {
		this.lockedBal = lockedBal;
	}

	public BigDecimal getAccCeiling() {
		return accCeiling;
	}

	public void setAccCeiling(BigDecimal accCeiling) {
		this.accCeiling = accCeiling;
	}

	public BigDecimal getAccFloor() {
		return accFloor;
	}

	public void setAccFloor(BigDecimal accFloor) {
		this.accFloor = accFloor;
	}

	public Integer getAccNature() {
		return accNature;
	}

	public void setAccNature(Integer accNature) {
		this.accNature = accNature;
	}

	public Integer getBalType() {
		return balType;
	}

	public void setBalType(Integer balType) {
		this.balType = balType;
	}

	public String getAccMemo() {
		return accMemo;
	}

	public void setAccMemo(String accMemo) {
		this.accMemo = accMemo;
	}

	public String getExProps() {
		return exProps;
	}

	public void setExProps(String exProps) {
		this.exProps = exProps;
	}

	public String getCreateBy() {
		return createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getModfiyBy() {
		return modfiyBy;
	}

	public void setModfiyBy(String modfiyBy) {
		this.modfiyBy = modfiyBy;
	}

	public String getModfiyTime() {
		return modfiyTime;
	}

	public void setModfiyTime(String modfiyTime) {
		this.modfiyTime = modfiyTime;
	}
}
