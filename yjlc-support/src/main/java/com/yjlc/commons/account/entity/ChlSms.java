package com.yjlc.commons.account.entity;

import com.joinwe.common.api.dto.BaseEntity;

/**
 * 短信流水表实体类
 * 
 * @author wangxiushan(2015-01-22)
 *
 */
public class ChlSms extends BaseEntity {

	private static final long serialVersionUID = 1L;

	/** 短信ID **/
	private int smsId;
	
	/** 发送方 **/
	private String smsFrom;
	
	/** 短信接收方 **/
	private String smsTo;
	
	/** 短信内容 **/
	private String smsContent;
	
	/** 发送时间 **/
	private String smsTime;
	
	/** 短信类型 **/
	private int smsType;
	public int getSmsId() {
		return smsId;
	}

	public void setSmsId(int smsId) {
		this.smsId = smsId;
	}

	public String getSmsFrom() {
		return smsFrom;
	}

	public void setSmsFrom(String smsFrom) {
		this.smsFrom = smsFrom;
	}

	public String getSmsTo() {
		return smsTo;
	}

	public void setSmsTo(String smsTo) {
		this.smsTo = smsTo;
	}

	public String getSmsContent() {
		return smsContent;
	}

	public void setSmsContent(String smsContent) {
		this.smsContent = smsContent;
	}

	public String getSmsTime() {
		return smsTime;
	}

	public void setSmsTime(String smsTime) {
		this.smsTime = smsTime;
	}

	public int getSmsType() {
		return smsType;
	}

	public void setSmsType(int smsType) {
		this.smsType = smsType;
	}

	
}
