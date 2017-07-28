package com.yjlc.commons.account;

import java.util.List;

import com.yjlc.commons.ApiServiceMessage;
import com.yjlc.commons.account.entity.FunctionalMessage;
import com.yjlc.commons.account.entity.SeSummaryMessage;
import com.yjlc.commons.account.entity.SecondaryMessage;

/**
 * 账户余额查询响应实体类
 * 
 * M：必填 O：可空
 * 
 * @author wangxiushan(2015-01-21)
 * 
 */
public class AccountBalanceQueryResp extends ApiServiceMessage {

	private static final long serialVersionUID = 1L;

	/** 二级交易账户集合 **/
	private SecondaryMessage secondary;

	/** 二级交易账户 资产汇总信息 **/
	private SeSummaryMessage seSummary;

	/** 功能户集合 **/
	private List<FunctionalMessage> functionalList;

	public SecondaryMessage getSecondary() {
		return secondary;
	}

	public void setSecondary(SecondaryMessage secondary) {
		this.secondary = secondary;
	}

	public SeSummaryMessage getSeSummary() {
		return seSummary;
	}

	public void setSeSummary(SeSummaryMessage seSummary) {
		this.seSummary = seSummary;
	}

	public List<FunctionalMessage> getFunctionalList() {
		return functionalList;
	}

	public void setFunctionalList(List<FunctionalMessage> functionalList) {
		this.functionalList = functionalList;
	}

}
