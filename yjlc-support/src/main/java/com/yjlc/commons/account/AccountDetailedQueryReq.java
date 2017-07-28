package com.yjlc.commons.account;

import com.yjlc.commons.ApiServiceMessage;

/**
 * 账户交易明细查询请求类
 * 
 * M:必填  O:可空
 * 
 * @author wangxiushan(2015-01-21)
 *
 */
public class AccountDetailedQueryReq extends ApiServiceMessage {

	private static final long serialVersionUID = 1L;

	/** 二级交易账户  M**/
	private String seAccCode;
	
	/** 账户名称 O **/
	private String accName;
	
	/** 币种 M **/
	private String crCode;
	
	/** 功能户类型  O **/
	private Integer fnType;
	
	/** 功能户类型数组  O **/
	private Integer fnTypeArry[];
	
	/** 查询页码 M **/
	private int pageNum;
	
	/** 每页记录数  M **/
	private int pageSize;
	
	/** 资金变动类型(资金流向) O **/
	private Integer flowFunds;
	
	/** 查询开始时间 M yyyy-MM-dd **/
	private String bgnDate;
	
	/** 查询结束时间 M yyyy-MM-dd **/
	private String endDate;

	public Integer getFnType() {
		return fnType;
	}

	public void setFnType(Integer fnType) {
		this.fnType = fnType;
	}

	public String getSeAccCode() {
		return seAccCode;
	}

	public void setSeAccCode(String seAccCode) {
		this.seAccCode = seAccCode;
	}
	
	public String getAccName() {
		return accName;
	}

	public void setAccName(String accName) {
		this.accName = accName;
	}

	public String getCrCode() {
		return crCode;
	}

	public void setCrCode(String crCode) {
		this.crCode = crCode;
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
	
	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getFlowFunds() {
		return flowFunds;
	}

	public void setFlowFunds(Integer flowFunds) {
		this.flowFunds = flowFunds;
	}
	
	public Integer[] getFnTypeArry() {
		return fnTypeArry;
	}

	public void setFnTypeArry(Integer[] fnTypeArry) {
		this.fnTypeArry = fnTypeArry;
	}

	public String getBgnDate() {
		return bgnDate;
	}

	public void setBgnDate(String bgnDate) {
		this.bgnDate = bgnDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

}
