package com.yjlc.commons;

import com.joinwe.common.api.dto.ServiceMessage;

public class ApiServiceMessage extends ServiceMessage {

	private static final long serialVersionUID = 1L;

	/** 托管通道 **/
	private String custodyChannel;
	/** 请求类型 1 form表单方式 2 后台Post请求方式 **/
	private String requestType;

	public String getCustodyChannel() {
		return custodyChannel;
	}

	public void setCustodyChannel(String custodyChannel) {
		this.custodyChannel = custodyChannel;
	}

	public String getRequestType() {
		return requestType;
	}

	public void setRequestType(String requestType) {
		this.requestType = requestType;
	}

}
