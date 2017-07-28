package com.yjlc.commons.account;

import com.yjlc.commons.ApiServiceMessage;
 

/**
 * 开户请求实体类
 * 
 * @author wangxiushan(2015-01-20)
 *
 */
public class OpenAccountReq extends ApiServiceMessage {
	
	private static final long serialVersionUID = 1L;
	
	/** 账户名称 **/
	private String accName;
	
	/** 账户类型  1#个人投资人 2#个人借款人 3#企业投资人 4#企业借款人5吆鸡理财平台 6吆鸡理财用户 **/
	private int accType;
	
	/** 币种 **/
	private String crCode;
	
	/** 身份证号后4位或企业机构号4位 **/
	private String idNum;
	
	/** 备注 **/
	private String accMemo;

	public String getAccName() {
		return accName;
	}

	public void setAccName(String accName) {
		this.accName = accName;
	}

	public int getAccType() {
		return accType;
	}

	public void setAccType(int accType) {
		this.accType = accType;
	}

	public String getCrCode() {
		return crCode;
	}

	public void setCrCode(String crCode) {
		this.crCode = crCode;
	}

	public String getIdNum() {
		return idNum;
	}

	public void setIdNum(String idNum) {
		this.idNum = idNum;
	}

	public String getAccMemo() {
		return accMemo;
	}

	public void setAccMemo(String accMemo) {
		this.accMemo = accMemo;
	}

}
