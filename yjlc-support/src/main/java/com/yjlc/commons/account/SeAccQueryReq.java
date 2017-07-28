package com.yjlc.commons.account;

import com.yjlc.commons.ApiServiceMessage;

/**
 * 二级交易账户分页查询请求类
 * 
 * @author wangxiushan(2015-02-13)
 */
public class SeAccQueryReq extends ApiServiceMessage{

	private static final long serialVersionUID = 1L;
	
	/** 二级交易账户号 **/
	private String seAccCode;
	/** 账户名称 **/
	private String seAccName;
	/** 币种 **/
	private String crCode;
	/** 二级交易账户状态0#初始化 1#已激活 9#已注销 **/
	private String accStatus;
	/** 查询开始时间  格式：yyyy-MM-dd**/
	private String beginTime;
	/** 查询结束时间  格式：yyyy-MM-dd**/
	private String endTime;
	/** 当前页码 **/
	private Integer pageIndex;
	/** 分页步长 **/
	private Integer pageSize;

	public String getSeAccCode() {
		return seAccCode;
	}

	public void setSeAccCode(String seAccCode) {
		this.seAccCode = seAccCode;
	}

	public String getSeAccName() {
		return seAccName;
	}

	public void setSeAccName(String seAccName) {
		this.seAccName = seAccName;
	}

	public String getBeginTime() {
		return beginTime;
	}

	public void setBeginTime(String beginTime) {
		this.beginTime = beginTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public Integer getPageIndex() {
		return pageIndex;
	}

	public void setPageIndex(Integer pageIndex) {
		this.pageIndex = pageIndex;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public String getCrCode() {
		return crCode;
	}

	public void setCrCode(String crCode) {
		this.crCode = crCode;
	}

	public String getAccStatus() {
		return accStatus;
	}

	public void setAccStatus(String accStatus) {
		this.accStatus = accStatus;
	}
	
}
