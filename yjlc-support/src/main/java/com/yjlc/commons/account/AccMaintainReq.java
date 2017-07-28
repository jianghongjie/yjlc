package com.yjlc.commons.account;

import com.yjlc.commons.ApiServiceMessage;

/**
 * 账户状态维护请求类
 * 
 * @author wangxiushan(2015-02-02)
 *
 */
public class AccMaintainReq extends ApiServiceMessage{
	
	private static final long serialVersionUID = 1L;
	
	/** 二级交易账户号 M**/
	private String seAccCode;

	/** 修改人 M**/
	private String modifyBy;

	/** 状态  二级交易账户状态 0#初始化 1#已激活 9#已注销  M**/
	private String accStatus;

	/** 备注 O **/
	private String remark;

	public String getSeAccCode() {
		return seAccCode;
	}

	public void setSeAccCode(String seAccCode) {
		this.seAccCode = seAccCode;
	}

	public String getModifyBy() {
		return modifyBy;
	}

	public void setModifyBy(String modifyBy) {
		this.modifyBy = modifyBy;
	}

	public String getAccStatus() {
		return accStatus;
	}

	public void setAccStatus(String accStatus) {
		this.accStatus = accStatus;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
	
}
