package com.yjlc.commons.account.entity;

import com.joinwe.common.api.dto.BaseEntity;

public class SwitcherOptions extends BaseEntity {

	// 托管通道
	private String custody;

	// 支付方式id
	private String payType;

	public String getPayType() {
		return payType;
	}

	public void setPayType(String payType) {
		this.payType = payType;
	}

	public String getCustody() {
		return custody;
	}

	public void setCustody(String custody) {
		this.custody = custody;
	}
	
}