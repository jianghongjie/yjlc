package com.yjlc.commons.account;

import java.math.BigDecimal;

import com.yjlc.commons.ApiServiceMessage;

/**
 * 标的登记请求(5.2.3 产品开户申请)
 * 
 * M：必须字段 O：可选子段
 * 
 * @author wangxiushan(2015-01-12)
 */
public class ProductAccountReq extends ApiServiceMessage {

	private static final long serialVersionUID = 1L;

	/** 产品ID & M **/
	private String prdCode;

	/** 产品名称 & M **/
	private String prdName;

	/** 收款人 编号& M **/
	private String cusCode;

	/** 产品描述 & O **/
	private String remark;

	/** 产品总金额 & O **/
	private BigDecimal prdAmount;

	/** 标的类型 & O & 0：公司借款  1：个人借款  99：其他（默认值） **/
	private String prdType;
	
	public ProductAccountReq() {
		this.prdType = "";
		this.remark = "";
	}

	public String getPrdCode() {
		return prdCode;
	}

	public void setPrdCode(String prdCode) {
		this.prdCode = prdCode;
	}

	public String getPrdName() {
		return prdName;
	}

	public void setPrdName(String prdName) {
		this.prdName = prdName;
	}

	public String getCusCode() {
		return cusCode;
	}

	public void setCusCode(String cusCode) {
		this.cusCode = cusCode;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public BigDecimal getPrdAmount() {
		return prdAmount;
	}

	public void setPrdAmount(BigDecimal prdAmount) {
		this.prdAmount = prdAmount;
	}

	public String getPrdType() {
		return prdType;
	}

	public void setPrdType(String prdType) {
		this.prdType = prdType;
	}

}
