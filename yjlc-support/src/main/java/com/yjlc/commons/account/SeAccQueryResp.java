package com.yjlc.commons.account;

import java.math.BigDecimal;

import com.joinwe.common.api.dto.PagingData;
import com.yjlc.commons.ApiServiceMessage;

/**
 * 描述:二级交易账户分页查询响应类
 * 作者: 扫地僧
 * 公司: 深圳市前海技术有限公司
 * 日期: 2017-4-6 下午1:21:18 
 * 版本号: V1.0
 */
public class SeAccQueryResp extends ApiServiceMessage{

	private static final long serialVersionUID = 1L;

	/** 二级交易账户集合 **/
	private PagingData<SeAccInfo> secoundaryViewList;

	public class SeAccInfo {
		/** 自增长编号 **/
		private Integer id;
		/** 二级交易账号 二级交易账号 **/
		private String accCode;
		/** 二级交易账户名称 二级交易账户名称 **/
		private String accName;
		/** 所属总户表账号 所属总户表账号 **/
		private String masterCode;
		/** 二级账户开户业务类型（开户模板） 二级账户开户业务类型（开户模板） **/
		private String accType;
		/** 二级交易账户状态 二级交易账户状态0#初始化 1#已激活 9#已注销 **/
		private String accStatus;
		/** 二级交易账号备注 二级交易账号备注 **/
		private String accMemo;
		/** 二级交易账号备注 二级交易账号备注 **/
		private String createBy;
		/** 二级交易账户创建时间 二级交易账户创建时间 **/
		private String createTime;
		/** 修改人 修改人 **/
		private String modfiyBy;
		/** 修改时间 修改时间 **/
		private String modfiyTime;
		/** 基础平台流水号 **/
		private String frtTrdNum;
		/** 账户余额 总和 **/
		private BigDecimal avaAssert;
		/** 不可用金额（冻结金额）总和 **/
		private BigDecimal lockAssert;
		/** 负债金额 总和 **/
		private BigDecimal debtAssert;
		/** 币种 **/
		private String crCode;

		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

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

		public String getModfiyBy() {
			return modfiyBy;
		}

		public void setModfiyBy(String modfiyBy) {
			this.modfiyBy = modfiyBy;
		}

		public String getModfiyTime() {
			return modfiyTime;
		}

		public void setModfiyTime(String modfiyTime) {
			this.modfiyTime = modfiyTime;
		}

		public String getFrtTrdNum() {
			return frtTrdNum;
		}

		public void setFrtTrdNum(String frtTrdNum) {
			this.frtTrdNum = frtTrdNum;
		}

		public BigDecimal getAvaAssert() {
			return avaAssert;
		}

		public void setAvaAssert(BigDecimal avaAssert) {
			this.avaAssert = avaAssert;
		}

		public BigDecimal getLockAssert() {
			return lockAssert;
		}

		public void setLockAssert(BigDecimal lockAssert) {
			this.lockAssert = lockAssert;
		}

		public BigDecimal getDebtAssert() {
			return debtAssert;
		}

		public void setDebtAssert(BigDecimal debtAssert) {
			this.debtAssert = debtAssert;
		}

		public String getCrCode() {
			return crCode;
		}

		public void setCrCode(String crCode) {
			this.crCode = crCode;
		}
	}

	
	public PagingData<SeAccInfo> getSecoundaryViewList() {
		return secoundaryViewList;
	}

	public void setSecoundaryViewList(PagingData<SeAccInfo> secoundaryViewList) {
		this.secoundaryViewList = secoundaryViewList;
	}
}
