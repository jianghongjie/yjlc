package com.yjlc.commons.account;

import java.math.BigDecimal;
import java.util.List;

import com.yjlc.commons.ApiServiceMessage;

/**
 * 账户交易明细查询响应类
 * 
 * M:必填 O:可空
 * 
 * @author wangxiushan(2015-01-21)
 * 
 */
public class AccountDetailedQueryResp extends ApiServiceMessage {
	
	private static final long serialVersionUID = 1L;
	
	// 二级交易账户集合
	private List<Balance> balanceList;
	// 总记录数
	private Integer totalCount;
	// 总页数
	private Integer totalPage;

	public class Balance {
		/** 自增长ID **/
		private Integer id;
		/** 二级交易账号 二级交易账号 **/
		private String seCode;
		/** 功能账户 功能账户 **/
		private String fnCode;
		/** 交易流水号 交易流水号 **/
		private String accTrdNo;
		/** 前置交易流水号 前置交易流水号 **/
		private String frtTrdNo;
		/** 交易金额 交易金额 **/
		private BigDecimal trdAmt;
		/** 交易类型 交易类型 **/
		private String trdCode;
		/** 交易时间 交易时间 **/
		private String trdTime;
		/** 余额变动方向 0#增 1#减 余额变动方向 0#增 1#减 **/
		private Integer balanceFig;
		/** 交易后的账户余额 交易后的账户余额 **/
		private BigDecimal balance;
		/** 交易后的不可用金额（冻结金额） 交易后的不可用金额（冻结金额） **/
		private BigDecimal lockBalance;
		/** 交易备注 交易备注 **/
		private String trdMemo;
		/**
		 * 功能账户类型 1#流动资金户 2#贷款资金户 3#待还资金户 4#在途资金户 5#在投资金户 6#内部转账户 7#还款专用户8#红包账户
		 * 
		 **/
		private int fnType;
		/** 币种 **/
		private String crCode;

		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		public String getSeCode() {
			return seCode;
		}

		public void setSeCode(String seCode) {
			this.seCode = seCode;
		}

		public String getFnCode() {
			return fnCode;
		}

		public void setFnCode(String fnCode) {
			this.fnCode = fnCode;
		}

		public String getAccTrdNo() {
			return accTrdNo;
		}

		public void setAccTrdNo(String accTrdNo) {
			this.accTrdNo = accTrdNo;
		}

		public String getFrtTrdNo() {
			return frtTrdNo;
		}

		public void setFrtTrdNo(String frtTrdNo) {
			this.frtTrdNo = frtTrdNo;
		}

		public BigDecimal getTrdAmt() {
			return trdAmt;
		}

		public void setTrdAmt(BigDecimal trdAmt) {
			this.trdAmt = trdAmt;
		}

		public String getTrdCode() {
			return trdCode;
		}

		public void setTrdCode(String trdCode) {
			this.trdCode = trdCode;
		}

		public String getTrdTime() {
			return trdTime;
		}

		public void setTrdTime(String trdTime) {
			this.trdTime = trdTime;
		}

		public Integer getBalanceFig() {
			return balanceFig;
		}

		public void setBalanceFig(Integer balanceFig) {
			this.balanceFig = balanceFig;
		}

		public BigDecimal getBalance() {
			return balance;
		}

		public void setBalance(BigDecimal balance) {
			this.balance = balance;
		}

		public BigDecimal getLockBalance() {
			return lockBalance;
		}

		public void setLockBalance(BigDecimal lockBalance) {
			this.lockBalance = lockBalance;
		}

		public String getTrdMemo() {
			return trdMemo;
		}

		public void setTrdMemo(String trdMemo) {
			this.trdMemo = trdMemo;
		}

		public int getFnType() {
			return fnType;
		}

		public void setFnType(int fnType) {
			this.fnType = fnType;
		}

		public String getCrCode() {
			return crCode;
		}

		public void setCrCode(String crCode) {
			this.crCode = crCode;
		}
	}

	public List<Balance> getBalanceList() {
		return balanceList;
	}

	public void setBalanceList(List<Balance> balanceList) {
		this.balanceList = balanceList;
	}

	public Integer getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}

	public Integer getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}
}
