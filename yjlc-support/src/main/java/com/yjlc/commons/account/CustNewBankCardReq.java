package com.yjlc.commons.account;

import com.yjlc.commons.ApiServiceMessage;

/**
 * 5.2.46.1	个人客户银行卡绑定AE0046
 * 
 * M：必须字段  O：可选子段
 * 
 * @author zshen(2015-11-11)
 * 
 */
public class CustNewBankCardReq  extends ApiServiceMessage  {

	private static final long serialVersionUID = 1L;
	
	/** 银行卡手机预留号  M*/ 
	private String mobile;

	/** 外部用户号 M */
	private String cusCode;

	/** 卡号 O */
	private String cardNo;

	/** 银行类别 O */
	private String bankNo;

	/** 页面通知地址 M **/
	private String webUrl;

	/** 页面跳转地址 M **/
	private String pageUrl;
	
	/** 手机验证码 M*/ 
	private String validateCode;

	/** 用户客户号 */
	private String	usrCustId;
	/** 商户私有域 */
	private String	merPriv;

	public String getCusCode() {
		return cusCode;
	}

	public void setCusCode(String cusCode) {
		this.cusCode = cusCode;
	}

	public String getCardNo() {
		return cardNo;
	}

	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}

	public String getBankNo() {
		return bankNo;
	}

	public void setBankNo(String bankNo) {
		this.bankNo = bankNo;
	}

	public String getWebUrl() {
		return webUrl;
	}

	public void setWebUrl(String webUrl) {
		this.webUrl = webUrl;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getValidateCode() {
		return validateCode;
	}

	public void setValidateCode(String validateCode) {
		this.validateCode = validateCode;
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

	public String getPageUrl() {
		return pageUrl;
	}

	public void setPageUrl(String pageUrl) {
		this.pageUrl = pageUrl;
	}
	
	
}
