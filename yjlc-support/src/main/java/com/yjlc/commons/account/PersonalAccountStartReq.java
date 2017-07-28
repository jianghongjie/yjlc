package com.yjlc.commons.account;

import com.yjlc.commons.ApiServiceMessage;

/**
 * 个人开户申请(开始)(个人投资客户分段开户（第一步开内部户）)
 * 
 * M：必须字段 O：可选子段
 * 
 * @author wangxiushan(2015-01-12)
 * 
 */
public class PersonalAccountStartReq extends ApiServiceMessage {

	private static final long serialVersionUID = 1L;

	/** 外部用户号 M */
	private String cusCode;

	/** 用户名称 M */
	private String realName;

	/** 开户证件类型 M */
	private String idType;

	/** 证件号 M 0:身份证 1：户口簿 */
	private String idNum;

	/** 手机号 M */
	private String cusMobile;

	/** 邮件地址 O */
	private String cusEmail;

	/** 页面通知地址 M **/
	private String webUrl;

	/** 页面跳转地址 M **/
	private String pageUrl;

	/** 用户客户号 */
	private String usrCustId;
	/** 商户私有域 */
	private String merPriv;

	public String getCusCode() {
		return cusCode;
	}

	public void setCusCode(String cusCode) {
		this.cusCode = cusCode;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getIdType() {
		return idType;
	}

	public void setIdType(String idType) {
		this.idType = idType;
	}

	public String getIdNum() {
		return idNum;
	}

	public void setIdNum(String idNum) {
		this.idNum = idNum;
	}

	public String getCusMobile() {
		return cusMobile;
	}

	public void setCusMobile(String cusMobile) {
		this.cusMobile = cusMobile;
	}

	public String getCusEmail() {
		return cusEmail;
	}

	public void setCusEmail(String cusEmail) {
		this.cusEmail = cusEmail;
	}

	public String getWebUrl() {
		return webUrl;
	}

	public void setWebUrl(String webUrl) {
		this.webUrl = webUrl;
	}

	public String getPageUrl() {
		return pageUrl;
	}

	public void setPageUrl(String pageUrl) {
		this.pageUrl = pageUrl;
	}

	public String getUsrCustId() {
		return usrCustId;
	}

	public void setUsrCustId(String usrCustId) {
		this.usrCustId = usrCustId;
	}

	public String getMerPriv() {
		return merPriv;
	}

	public void setMerPriv(String merPriv) {
		this.merPriv = merPriv;
	}

}
