package com.yjlc.commons.account.entity;

import com.joinwe.common.api.dto.BaseEntity;

public class Email extends BaseEntity {

	private static final long serialVersionUID = 1L;

	/** 邮件ID **/
	private int emlId;
	/** 发送方 **/
	private String emlFrom;
	/** 邮件接收方 **/
	private String emlTo;
	/** 邮件标题 **/
	private String emlTitle;
	/** 邮件内容 **/
	private String emlContent;
	/** 状态 **/
	private String status;
	/** 发送时间 **/
	private String emlTime;

	public int getEmlId() {
		return emlId;
	}

	public void setEmlId(int emlId) {
		this.emlId = emlId;
	}

	public String getEmlFrom() {
		return emlFrom;
	}

	public void setEmlFrom(String emlFrom) {
		this.emlFrom = emlFrom;
	}

	public String getEmlTo() {
		return emlTo;
	}

	public void setEmlTo(String emlTo) {
		this.emlTo = emlTo;
	}

	public String getEmlTitle() {
		return emlTitle;
	}

	public void setEmlTitle(String emlTitle) {
		this.emlTitle = emlTitle;
	}

	public String getEmlContent() {
		return emlContent;
	}

	public void setEmlContent(String emlContent) {
		this.emlContent = emlContent;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getEmlTime() {
		return emlTime;
	}

	public void setEmlTime(String emlTime) {
		this.emlTime = emlTime;
	}

}
