package org.sc.rest.provider.service.account;

import com.yjlc.commons.account.AccMaintainReq;
import com.yjlc.commons.account.AccMaintainResp;
import com.yjlc.commons.account.AccountBalanceQueryReq;
import com.yjlc.commons.account.AccountBalanceQueryResp;
import com.yjlc.commons.account.AccountDetailedQueryReq;
import com.yjlc.commons.account.AccountDetailedQueryResp;
import com.yjlc.commons.account.OpenAccountReq;
import com.yjlc.commons.account.OpenAccountResp;
import com.yjlc.commons.account.SeAccQueryReq;
import com.yjlc.commons.account.SeAccQueryResp;

public interface InterAccountService {
	
	/**
     * 开户申请
     * @param openAccountReq 开户申请对象
     * @return 开户响应对象
     */
    OpenAccountResp openAccount(OpenAccountReq openAccountReq);
    
    /**
	 * 单个二级交易账户查询（包括二级交易账户余额汇总及功能户）
	 * @param accountBalanceQueryReq 账户余额查询请求对象
	 * @return 账户余额查询响应对象
	 */
    AccountBalanceQueryResp accBalanceQuery(AccountBalanceQueryReq accountBalanceQueryReq);
    
    /**
     * 二级交易账户分页查询
     * @param seAccQueryReq
     * @return
     */
    SeAccQueryResp seAccQuery(SeAccQueryReq seAccQueryReq);
    
    /**
     * 账户资金明细查询
     * @param accountDetailedQueryReq 账户明细查询请求对象
     * @return 账户明细查询响应对象
     */
    AccountDetailedQueryResp accDetailedQuery(AccountDetailedQueryReq accountDetailedQueryReq);
    
    /**
     * 账户状态维护
     * @param accMaintainReq 账户状态维护请求对象
     * @return 账户状态维护响应对象
     */
    AccMaintainResp maintainAccStat(AccMaintainReq accMaintainReq);
}
