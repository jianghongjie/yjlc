package com.yjlc.commons.account.entity;

import com.joinwe.common.api.dto.BaseEntity;

/**
 * 通道交易流水表实体类
 * 
 * @author wangxiushan(2015-01-14)
 * 
 */
public class Trade extends BaseEntity {

	private static final long serialVersionUID = 1L;

	/** 交易ID **/
	private String trdId;

	/** 网关交易流水号 **/
	private String trdNum;

	/** 通道号 **/
	private String chlCode;

	/** 通道交易流水号 **/
	private String chlTrdNum;

	/** 前置交易流水号 **/
	private String frtTrdNum;
	
	/** 业务类型 **/
	private String bizType;

	/** 交易日期 **/
	private String trdDate;

	/** 通道交易代码 **/
	private String chlTrdCode;

	/** 接入系统编号 **/
	private String sysCode;

	/** 状态 0#初始化交易 1#交易成功 9#交易失败 **/
	private String status;

	/** 预交易时间 **/
	private String preTime;

	/** 完成交易时间 **/
	private String endTime;
	
	private String chlRetNum;

	/** 通道返回码 **/
	private String chlRespCode;

	/** 通道返回信息 **/
	private String chlRespInfo;

	/** 对账状态 0#未对账 1#已对账 **/
	private String checkStatus;

	/** 对账时间 **/
	private String checkTime;

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

	public String getChlCode() {
		return chlCode;
	}

	public void setChlCode(String chlCode) {
		this.chlCode = chlCode;
	}

	public String getChlTrdNum() {
		return chlTrdNum;
	}

	public void setChlTrdNum(String chlTrdNum) {
		this.chlTrdNum = chlTrdNum;
	}

	public String getFrtTrdNum() {
		return frtTrdNum;
	}

	public void setFrtTrdNum(String frtTrdNum) {
		this.frtTrdNum = frtTrdNum;
	}

	public String getTrdDate() {
		return trdDate;
	}

	public void setTrdDate(String trdDate) {
		this.trdDate = trdDate;
	}

	public String getChlTrdCode() {
		return chlTrdCode;
	}

	public void setChlTrdCode(String chlTrdCode) {
		this.chlTrdCode = chlTrdCode;
	}

	public String getSysCode() {
		return sysCode;
	}

	public void setSysCode(String sysCode) {
		this.sysCode = sysCode;
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

	public String getChlRetNum() {
		return chlRetNum;
	}

	public void setChlRetNum(String chlRetNum) {
		this.chlRetNum = chlRetNum;
	}

	public String getChlRespCode() {
		return chlRespCode;
	}

	public void setChlRespCode(String chlRespCode) {
		this.chlRespCode = chlRespCode;
	}

	public String getChlRespInfo() {
		return chlRespInfo;
	}

	public void setChlRespInfo(String chlRespInfo) {
		this.chlRespInfo = chlRespInfo;
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
