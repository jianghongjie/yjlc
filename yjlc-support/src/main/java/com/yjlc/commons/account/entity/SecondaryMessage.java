package com.yjlc.commons.account.entity;

/***
 * 二级交易账户实体
 */
public class SecondaryMessage {
	// 二级交易账号
	private String accCode;
	// 二级交易账户名称
	private String accName;
	// 所属总户表账号
	private String masterCode;
	// 二级账户开户业务类型（开户模板）
	private String accType;
	// 二级交易账户状态0#初始化 1#已激活 9#已注销
	private String accStatus;
	// 二级交易账号备注
	private String accMemo;
	// 创建人
	private String createBy;
	// 创建时间
	private String createTime;
	// 修改人
	private String modifyBy;
	// 修改时间
	private String modifyTime;

	public String getAccCode() {
		return accCode;
	}

	public void setAccCode(String accCode) {
		this.accCode = accCode;
	}

	public String getAccName() {
		return accName;
	}

	public void setAccName(String accName) {
		this.accName = accName;
	}

	public String getMasterCode() {
		return masterCode;
	}

	public void setMasterCode(String masterCode) {
		this.masterCode = masterCode;
	}

	public String getAccType() {
		return accType;
	}

	public void setAccType(String accType) {
		this.accType = accType;
	}

	public String getAccStatus() {
		return accStatus;
	}

	public void setAccStatus(String accStatus) {
		this.accStatus = accStatus;
	}

	public String getAccMemo() {
		return accMemo;
	}

	public void setAccMemo(String accMemo) {
		this.accMemo = accMemo;
	}

	public String getCreateBy() {
		return createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getModifyBy() {
		return modifyBy;
	}

	public void setModifyBy(String modifyBy) {
		this.modifyBy = modifyBy;
	}

	public String getModifyTime() {
		return modifyTime;
	}

	public void setModifyTime(String modifyTime) {
		this.modifyTime = modifyTime;
	}
}
