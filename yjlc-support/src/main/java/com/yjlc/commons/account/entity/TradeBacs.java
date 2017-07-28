package com.yjlc.commons.account.entity;

/**
 * 账户核心前置流水表实体类
 * 
 * @author wangxiushan(2015-01-20)
 * 
 */
public class TradeBacs {

	/** 交易ID **/
	private String trdId;
	/** 网关交易流水号 **/
	private String trdNum;
	/** 前置交易流水号 **/
	private String frtTrdNum;
	/** 交易代码 **/
	private String trdCode;
	/** 业务类型 **/
	private String bizType;
	/** 交易日期 **/
	private String trdDate;
	/** 状态 **/
	private String status;
	/** 预交易时间 **/
	private String preTime;
	/** 完成交易时间 **/
	private String endTime;
	/** 账户核心返回码 **/
	private String accRespCode;
	/** 账户核心返回信息 **/
	private String accRespInfo;
	/** 账户交易流水号 **/
	private String accTrdNo;
	/** 对账状态 **/
	private String checkStatus;
	/** 对账时间 **/
	private String checkTime;

	public String getFrtTrdNum() {
		return frtTrdNum;
	}

	public void setFrtTrdNum(String frtTrdNum) {
		this.frtTrdNum = frtTrdNum;
	}

	public String getTrdCode() {
		return trdCode;
	}

	public void setTrdCode(String trdCode) {
		this.trdCode = trdCode;
	}

	public String getTrdId() {
		return trdId;
	}

	public void setTrdId(String trdId) {
		this.trdId = trdId;
	}

	public String getTrdNum() {
		return trdNum;
	}

	public void setTrdNum(String trdNum) {
		this.trdNum = trdNum;
	}

	public String getTrdDate() {
		return trdDate;
	}

	public void setTrdDate(String trdDate) {
		this.trdDate = trdDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getPreTime() {
		return preTime;
	}

	public void setPreTime(String preTime) {
		this.preTime = preTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getAccRespCode() {
		return accRespCode;
	}

	public void setAccRespCode(String accRespCode) {
		this.accRespCode = accRespCode;
	}

	public String getAccRespInfo() {
		return accRespInfo;
	}

	public void setAccRespInfo(String accRespInfo) {
		this.accRespInfo = accRespInfo;
	}

	public String getAccTrdNo() {
		return accTrdNo;
	}

	public void setAccTrdNo(String accTrdNo) {
		this.accTrdNo = accTrdNo;
	}

	public String getCheckStatus() {
		return checkStatus;
	}

	public void setCheckStatus(String checkStatus) {
		this.checkStatus = checkStatus;
	}

	public String getCheckTime() {
		return checkTime;
	}

	public void setCheckTime(String checkTime) {
		this.checkTime = checkTime;
	}

	public String getBizType() {
		return bizType;
	}

	public void setBizType(String bizType) {
		this.bizType = bizType;
	}

}
