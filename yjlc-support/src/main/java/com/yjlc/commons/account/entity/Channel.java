package com.yjlc.commons.account.entity;

import com.joinwe.common.api.dto.BaseEntity;

/**
 * 通道信息配置表实体类
 * 
 * @author wangxiushan(2015-01-14)
 *
 */
public class Channel extends BaseEntity {

	private static final long serialVersionUID = 1L;

	/** 通道ID  **/
	private String chlId;
	
	/** 通道号  **/
	private String chlCode;
	
	/** 通道名称  **/
	private String chlName;
	
	/** 通道用户号  **/
	private String chlMerCode;
	
	/** 通道商户号 **/
	private String chlMerAcc;
	
	/** 通道类型  **/
	private String chlType;
	
	/** 通道证书  **/
	private String chlCert;
	
	/** 通道属性  **/
	private String chlProps;
	
	/** 通道备注  **/
	private String chlRemark;
	
	/** 状态  **/
	private String status;

	public String getChlMerAcc() {
		return chlMerAcc;
	}

	public void setChlMerAcc(String chlMerAcc) {
		this.chlMerAcc = chlMerAcc;
	}

	public String getChlId() {
		return chlId;
	}

	public void setChlId(String chlId) {
		this.chlId = chlId;
	}

	public String getChlCode() {
		return chlCode;
	}

	public void setChlCode(String chlCode) {
		this.chlCode = chlCode;
	}

	public String getChlName() {
		return chlName;
	}

	public void setChlName(String chlName) {
		this.chlName = chlName;
	}

	public String getChlMerCode() {
		return chlMerCode;
	}

	public void setChlMerCode(String chlMerCode) {
		this.chlMerCode = chlMerCode;
	}

	public String getChlType() {
		return chlType;
	}

	public void setChlType(String chlType) {
		this.chlType = chlType;
	}

	public String getChlCert() {
		return chlCert;
	}

	public void setChlCert(String chlCert) {
		this.chlCert = chlCert;
	}

	public String getChlProps() {
		return chlProps;
	}

	public void setChlProps(String chlProps) {
		this.chlProps = chlProps;
	}

	public String getChlRemark() {
		return chlRemark;
	}

	public void setChlRemark(String chlRemark) {
		this.chlRemark = chlRemark;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
