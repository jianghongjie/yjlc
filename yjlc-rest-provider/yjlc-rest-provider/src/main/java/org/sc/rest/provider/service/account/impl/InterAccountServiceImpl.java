//package org.sc.rest.provider.service.account.impl;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import javax.annotation.Resource;
//
//import org.apache.commons.lang3.StringUtils;
//import org.sc.rest.provider.service.account.InterAccountService;
//import org.sc.rest.provider.service.transaction.TradeBacsTran;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.joinwe.common.api.dto.BizException;
//import com.joinwe.common.api.dto.PagingData;
//import com.joinwe.common.util.ComUtil;
//import com.joinwe.common.util.MessageSourceAccessor;
//import com.yjlc.commons.account.AccMaintainReq;
//import com.yjlc.commons.account.AccMaintainResp;
//import com.yjlc.commons.account.AccountBalanceQueryReq;
//import com.yjlc.commons.account.AccountBalanceQueryResp;
//import com.yjlc.commons.account.AccountDetailedQueryReq;
//import com.yjlc.commons.account.AccountDetailedQueryResp;
//import com.yjlc.commons.account.AccountDetailedQueryResp.Balance;
//import com.yjlc.commons.account.OpenAccountReq;
//import com.yjlc.commons.account.OpenAccountResp;
//import com.yjlc.commons.account.SeAccQueryReq;
//import com.yjlc.commons.account.SeAccQueryResp;
//import com.yjlc.commons.account.SeAccQueryResp.SeAccInfo;
//import com.yjlc.commons.account.entity.FunctionalMessage;
//import com.yjlc.commons.account.entity.SeSummaryMessage;
//import com.yjlc.commons.account.entity.SecondaryMessage;
//import com.yjlc.commons.account.entity.TradeBacs;
//import com.yjlc.commons.account.entity.query.TradeBacsQuery;
//import com.yjlc.commons.exception.MessageCode;
//import com.yjlc.commons.sms.ServiceMessageBuilder;
//
///**
// * 描述: 账户操作实现类
// * 作者: 扫地僧
// * 公司: 深圳市前海技术有限公司
// * 日期: 2017-4-6 下午1:56:33 
// * 版本号: V1.0
// */
//@Service
//public class InterAccountServiceImpl implements InterAccountService
//{
//
//	/** 账户服务核心代理类 **/
//	@Resource(name = "p2PAccountServiceProxy")
//	private P2PAccountService p2pAccountServiceProxy;
//
//	/** 通道交易流水表操作类 **/
//	@Autowired
//	private TradeBacsTran trdbacsTran;
//
//	/** 错误信息处理类 **/
//	@Autowired
//	private MessageSourceAccessor msa;
//
//	/** 日志处理类 **/
//	private final static Logger LOGGER = LoggerFactory.getLogger(InterAccountServiceImpl.class);
//
//	@Override
//	public OpenAccountResp openAccount(OpenAccountReq openAccountReq)
//	{
//		OpenAccountResp openAccountResp = null;
//
//		try
//		{
//			// 实例化并封装返回对象
//			openAccountResp = ServiceMessageBuilder.buildRespMessage(OpenAccountResp.class, openAccountReq);
//
//			LOGGER.info("内部开户申请--收到请求报文:" + openAccountReq.toJsonString());
//
//			// 验证公共参数（系统编号、业务类型、前置交易流水号）
//			String errParam = ComUtil.checkServiceReqMsg(openAccountReq, OpenAccountReq.class, ComUtil.CHECK_YES_TRDNUM);
//			if (!ComUtil.CHECK_YES.equals(errParam))
//			{
//				throw new BizException(MessageCode.M1000, msa.getMessage(MessageCode.M1000, errParam));
//			}
//			// 校验内部开户必填参数
//			if (openAccountReq.getCrCode() == null || StringUtils.isEmpty(openAccountReq.getCrCode()))
//			{
//				throw new BizException(MessageCode.M1000, msa.getMessage(MessageCode.M1000, "openAccountReq.crCode"));
//			}
//			if (openAccountReq.getIdNum() == null || StringUtils.isEmpty(openAccountReq.getIdNum()))
//			{
//				throw new BizException(MessageCode.M1000, msa.getMessage(MessageCode.M1000, "openAccountReq.idNum"));
//			}
//
//			// 封装查询对象
//			TradeBacsQuery trdBacsQuery = new TradeBacsQuery();
//			trdBacsQuery.setFrtTrdNum(openAccountReq.getFrontTrdNum());
//			trdBacsQuery.setTrdCode(BacsTradeCode.OPEN_ACCOUNT);
//			trdBacsQuery.setBizType(openAccountReq.getBizType());
//
//			// 查询账户核心前置交易流水记录
//			TradeBacs tradeBacs = trdbacsTran.selectTrdInfo(trdBacsQuery);
//
//			String trdNumStr = "";
//			// 如果查询有记录且状态不为初始化状态 则将当前状态返回给调用者
//			if (tradeBacs != null)
//			{
//				if (!(TranStatus.INIT_STATUS.equals(tradeBacs.getStatus())))
//				{
//					openAccountResp.setFrontTrdNum(openAccountReq.getFrontTrdNum());
//					openAccountResp.setBsspTrdNum(tradeBacs.getTrdNum());
//					openAccountResp.setAccName(openAccountReq.getAccName());
//					openAccountResp.setSeAccCode(tradeBacs.getAccTrdNo());
//					openAccountResp.setRespCode(tradeBacs.getAccRespCode());
//					openAccountResp.setRespMsg(tradeBacs.getAccRespInfo());
//					return openAccountResp;
//				} else
//				{
//					trdNumStr = tradeBacs.getTrdNum(); // 网关核心交易流水号
//				}
//			} else
//			{
//				trdNumStr = trdbacsTran.selectBySeqNum(TrdNumSeqName.SEQ_GA_NUM); // 网关核心交易流水号
//				trdNumStr = ComUtil.getGwTrdNum(TrdNumSeqName.TRD_GANUM_TOP, trdNumStr);
//
//				LOGGER.info("InterAccountServiceImpl.openAccount INFO:准备保存账户核心前置流水记录");
//				// 记录账户核心前置流水
//				TradeBacs trdBacs = new TradeBacs();
//				trdBacs.setTrdNum(trdNumStr);
//				trdBacs.setFrtTrdNum(openAccountReq.getFrontTrdNum());
//				trdBacs.setTrdCode(BacsTradeCode.OPEN_ACCOUNT);
//				trdBacs.setBizType(openAccountReq.getBizType());
//				trdBacs.setStatus(TranStatus.INIT_STATUS);
//				trdBacs.setCheckStatus(ReconciliationStatus.NOT_RECONCILIATION_STATUS);
//
//				trdbacsTran.insertTradeData(trdBacs); // 保存数据库
//				LOGGER.info("InterAccountServiceImpl.openAccount INFO:保存账户核心前置流水记录成功");
//			}
//
//			CreateAccReq createAccReq = ServiceMessageBuilder.buildReqMessageByAnotherMessage(CreateAccReq.class, openAccountReq);
//			createAccReq.setAccMemo(openAccountReq.getAccMemo());
//			createAccReq.setAccName(openAccountReq.getAccName());
//			createAccReq.setAccType(openAccountReq.getAccType());
//			createAccReq.setCrCode(openAccountReq.getCrCode());
//			createAccReq.setIdNum(openAccountReq.getIdNum());
//			createAccReq.setFrontTrdNum(trdNumStr);
//
//			LOGGER.info("InterAccountServiceImpl.openAccount INFO:准备调用账户核心开户接口");
//
//			// 调用核心账户开户接口
//			CreateAccResp createAccResp = p2pAccountServiceProxy.createAcc(createAccReq);
//			String statusCode = "";
//			if (createAccResp.successful())
//			{
//				statusCode = TranStatus.SUCCESS_STATUS;
//			} else
//			{
//				statusCode = TranStatus.FAILURE_STATUS;
//			}
//
//			openAccountResp.setRespCode(createAccResp.getRespCode());
//			openAccountResp.setRespMsg(createAccResp.getRespMsg());
//
//			LOGGER.info("InterAccountServiceImpl.openAccount INFO:调用账户核心开户接口成功");
//			LOGGER.info("InterAccountServiceImpl.openAccount INFO:准备更新账户核心前置流水信息");
//
//			// 成功则更新账户核心前置流水状态
//			TradeBacs trdBacs = new TradeBacs();
//			trdBacs.setTrdNum(trdNumStr);
//			trdBacs.setAccRespCode(createAccResp.getRespCode());
//			trdBacs.setAccRespInfo(createAccResp.getRespMsg());
//			trdBacs.setAccTrdNo(createAccResp.getAccCode()); // 二级交易账户号
//			trdBacs.setStatus(statusCode);
//
//			try
//			{
//				trdbacsTran.updateByTrdStatus(trdBacs);// 更新数据库
//			} catch (BizException b)
//			{
//				BsspComUtils.checkBacsTrdState(trdbacsTran, b, trdBacsQuery, openAccountResp);
//			}
//
//			LOGGER.info("InterAccountServiceImpl.openAccount INFO:更新账户核心前置流水信息成功");
//
//			openAccountResp.setFrontTrdNum(openAccountReq.getFrontTrdNum());
//			openAccountResp.setBsspTrdNum(trdNumStr);
//			openAccountResp.setAccName(openAccountReq.getAccName());
//			openAccountResp.setSeAccCode(createAccResp.getAccCode());
//		} catch (BizException be)
//		{
//			LOGGER.error("InterAccountServiceImpl.openAccount BIZ_ERROR:", be);
//			if (openAccountResp == null)
//			{
//				openAccountResp = new OpenAccountResp();
//			}
//			openAccountResp.setRespCode(be.getErrorInfo().getErrorCode());
//			openAccountResp.setRespMsg(be.getErrorInfo().getErrorMessage());
//		} catch (Exception e)
//		{
//			LOGGER.error("InterAccountServiceImpl.openAccount ERROR:", e);
//			if (openAccountResp == null)
//			{
//				openAccountResp = new OpenAccountResp();
//			}
//			openAccountResp.setRespCode(MessageCode.M9999);
//			openAccountResp.setRespMsg(msa.getMessage(MessageCode.M9999));
//		}
//		return openAccountResp;
//	}
//
//	@Override
//	public AccountBalanceQueryResp accBalanceQuery(AccountBalanceQueryReq accountBalanceQueryReq)
//	{
//		AccountBalanceQueryResp accountBalanceQueryResp = null;
//
//		try
//		{
//			// 封装账户余额查询响应对象
//			accountBalanceQueryResp = ServiceMessageBuilder.buildRespMessage(AccountBalanceQueryResp.class, accountBalanceQueryReq);
//
//			LOGGER.info("账户资金查询--BSSP接收请求报文:" + accountBalanceQueryReq.toJsonString());
//
//			// 验证公共参数（系统编号、业务类型）
//			String errParam = ComUtil.checkServiceReqMsg(accountBalanceQueryReq, AccountBalanceQueryReq.class, ComUtil.CHECK_NO_TRDNUM);
//			if (!ComUtil.CHECK_YES.equals(errParam))
//			{
//				throw new BizException(MessageCode.M1000, msa.getMessage(MessageCode.M1000, errParam));
//			}
//			// 校验二级交易账户查询必填参数
//			if (accountBalanceQueryReq.getAccType() == null || accountBalanceQueryReq.getAccType() != 5)
//			{
//				if (accountBalanceQueryReq.getSeAccCode() == null || StringUtils.isEmpty(accountBalanceQueryReq.getSeAccCode()))
//				{
//					throw new BizException(MessageCode.M1000, msa.getMessage(MessageCode.M1000, "AccountBalanceQueryReq.seAccCode"));
//				}
//			}
//			if (accountBalanceQueryReq.getAccStatus() == null || StringUtils.isEmpty(accountBalanceQueryReq.getAccStatus()))
//			{
//				throw new BizException(MessageCode.M1000, msa.getMessage(MessageCode.M1000, "AccountBalanceQueryReq.accStatus"));
//			}
//			if (accountBalanceQueryReq.getCrCode() == null || StringUtils.isEmpty(accountBalanceQueryReq.getCrCode()))
//			{
//				throw new BizException(MessageCode.M1000, msa.getMessage(MessageCode.M1000, "AccountBalanceQueryReq.crCode"));
//			}
//
//			// 调用核心账户查询余额接口获取账户余额信息
//			QueryAccReq queryAccReq = ServiceMessageBuilder.buildReqMessageByAnotherMessage(QueryAccReq.class, accountBalanceQueryReq);
//			queryAccReq.setAccCode(accountBalanceQueryReq.getSeAccCode());
//			queryAccReq.setAccStatus(accountBalanceQueryReq.getAccStatus());
//			queryAccReq.setCrCode(accountBalanceQueryReq.getCrCode());
//			queryAccReq.setAccType(accountBalanceQueryReq.getAccType());
//			QueryAccResp queryAccResp = p2pAccountServiceProxy.queryAcc(queryAccReq);
//
//			String respCode = "", respInfo = "";
//			if (queryAccResp.successful())
//			{
//				respCode = MessageCode.M0000;
//				respInfo = msa.getMessage(MessageCode.M0000);
//			} else
//			{
//				respCode = MessageCode.M1011;
//				respInfo = msa.getMessage(MessageCode.M1011);
//			}
//
//			// 封装返回对象
//			accountBalanceQueryResp.setRespCode(respCode);
//			accountBalanceQueryResp.setRespMsg(respInfo);
//			if (queryAccResp.getSeSummary() != null)
//			{
//				// 二级交易账户 资产汇总信息
//				SeSummaryMessage seSummary = new SeSummaryMessage();
//				seSummary.setAccCode(queryAccResp.getSeSummary().getAccCode());
//				seSummary.setAvaAssert(queryAccResp.getSeSummary().getAvaAssert());
//				seSummary.setCrCode(queryAccResp.getSeSummary().getCrCode());
//				seSummary.setDebtAssert(queryAccResp.getSeSummary().getDebtAssert());
//				seSummary.setId(queryAccResp.getSeSummary().getId());
//				seSummary.setLockAssert(queryAccResp.getSeSummary().getLockAssert());
//				accountBalanceQueryResp.setSeSummary(seSummary);
//			}
//			if (queryAccResp.getSecondary() != null)
//			{
//				// 二级交易账户信息
//				SecondaryMessage secondary = new SecondaryMessage();
//				secondary.setAccCode(queryAccResp.getSecondary().getAccCode());
//				secondary.setAccMemo(queryAccResp.getSecondary().getAccMemo());
//				secondary.setAccName(queryAccResp.getSecondary().getAccName());
//				secondary.setAccStatus(queryAccResp.getSecondary().getAccStatus());
//				secondary.setAccType(queryAccResp.getSecondary().getAccType());
//				secondary.setCreateBy(queryAccResp.getSecondary().getCreateBy());
//				secondary.setCreateTime(queryAccResp.getSecondary().getCreateTime());
//				secondary.setMasterCode(queryAccResp.getSecondary().getMasterCode());
//				secondary.setModifyBy(queryAccResp.getSecondary().getModifyBy());
//				secondary.setModifyTime(queryAccResp.getSecondary().getModifyTime());
//				accountBalanceQueryResp.setSecondary(secondary);
//			}
//			if (queryAccResp.getFunctionalList() != null && !queryAccResp.getFunctionalList().isEmpty())
//			{
//				// 功能户集合
//				ArrayList<FunctionalMessage> functionalList = new ArrayList<FunctionalMessage>();
//				for (int i = 0; i < queryAccResp.getFunctionalList().size(); i++)
//				{
//					FunctionalMessage functional = new FunctionalMessage();
//					functional.setAccCeiling(queryAccResp.getFunctionalList().get(i).getAccCeiling());
//					functional.setAccCode(queryAccResp.getFunctionalList().get(i).getAccCode());
//					functional.setAccFloor(queryAccResp.getFunctionalList().get(i).getAccFloor());
//					functional.setAccMemo(queryAccResp.getFunctionalList().get(i).getAccMemo());
//					functional.setAccNature(queryAccResp.getFunctionalList().get(i).getAccNature());
//					functional.setAccStatus(queryAccResp.getFunctionalList().get(i).getAccStatus());
//					functional.setAccType(queryAccResp.getFunctionalList().get(i).getAccType());
//					functional.setBalance(queryAccResp.getFunctionalList().get(i).getBalance());
//					functional.setBalType(queryAccResp.getFunctionalList().get(i).getBalType());
//					functional.setCrCode(queryAccResp.getFunctionalList().get(i).getCrCode());
//					functional.setCreateBy(queryAccResp.getFunctionalList().get(i).getCreateBy());
//					functional.setCreateTime(queryAccResp.getFunctionalList().get(i).getCreateTime());
//					functional.setExProps(queryAccResp.getFunctionalList().get(i).getExProps());
//					functional.setId(queryAccResp.getFunctionalList().get(i).getId());
//					functional.setLockedBal(queryAccResp.getFunctionalList().get(i).getLockedBal());
//					functional.setmId(queryAccResp.getFunctionalList().get(i).getmId());
//					functional.setModfiyBy(queryAccResp.getFunctionalList().get(i).getModfiyBy());
//					functional.setModfiyTime(queryAccResp.getFunctionalList().get(i).getModfiyTime());
//					functional.setSeCode(queryAccResp.getFunctionalList().get(i).getSeCode());
//					functionalList.add(functional);
//				}
//				accountBalanceQueryResp.setFunctionalList(functionalList);
//			}
//
//		} catch (BizException be)
//		{
//			LOGGER.error("InterAccountServiceImpl.accBalanceQuery BIZ_ERROR:", be);
//			if (accountBalanceQueryResp == null)
//			{
//				accountBalanceQueryResp = new AccountBalanceQueryResp();
//			}
//			accountBalanceQueryResp.setRespCode(be.getErrorInfo().getErrorCode());
//			accountBalanceQueryResp.setRespMsg(be.getErrorInfo().getErrorMessage());
//		} catch (Exception e)
//		{
//			LOGGER.error("InterAccountServiceImpl.accBalanceQuery ERROR:", e);
//			if (accountBalanceQueryResp == null)
//			{
//				accountBalanceQueryResp = new AccountBalanceQueryResp();
//			}
//			accountBalanceQueryResp.setRespCode(MessageCode.M9999);
//			accountBalanceQueryResp.setRespMsg(msa.getMessage(MessageCode.M9999));
//		}
//		LOGGER.info("账户资金查询--BSSP返回响应报文:" + accountBalanceQueryResp.toJsonString());
//		return accountBalanceQueryResp;
//	}
//
//	@Override
//	public AccountDetailedQueryResp accDetailedQuery(AccountDetailedQueryReq accountDetailedQueryReq)
//	{
//		AccountDetailedQueryResp accountDetailedQueryResp = null;
//
//		try
//		{
//
//			// 实例化并封装账户资金明细查询响应对象
//			accountDetailedQueryResp = ServiceMessageBuilder.buildRespMessage(AccountDetailedQueryResp.class, accountDetailedQueryReq);
//
//			LOGGER.info("账户资金明细查询--PBAP发送请求报文:" + accountDetailedQueryReq.toJsonString());
//
//			// 验证公共参数（系统编号、业务类型）
//			String errParam = ComUtil.checkServiceReqMsg(accountDetailedQueryReq, AccountDetailedQueryReq.class, ComUtil.CHECK_NO_TRDNUM);
//			if (!ComUtil.CHECK_YES.equals(errParam))
//			{
//				throw new BizException(MessageCode.M1000, msa.getMessage(MessageCode.M1000, errParam));
//			}
//			// 校验资金明细查询必填参数
//			if (accountDetailedQueryReq.getSeAccCode() == null || StringUtils.isEmpty(accountDetailedQueryReq.getSeAccCode()))
//			{
//				throw new BizException(MessageCode.M1000, msa.getMessage(MessageCode.M1000, "AccountDetailedQueryReq.seAccCode"));
//			}
//			if (accountDetailedQueryReq.getPageNum() <= 0)
//			{
//				throw new BizException(MessageCode.M1000, msa.getMessage(MessageCode.M1000, "AccountDetailedQueryReq.pageNum"));
//			}
//			if (accountDetailedQueryReq.getPageSize() <= 0)
//			{
//				throw new BizException(MessageCode.M1000, msa.getMessage(MessageCode.M1000, "AccountDetailedQueryReq.pageSize"));
//			}
//			if (accountDetailedQueryReq.getCrCode() == null || StringUtils.isEmpty(accountDetailedQueryReq.getCrCode()))
//			{
//				throw new BizException(MessageCode.M1000, msa.getMessage(MessageCode.M1000, "AccountDetailedQueryReq.crCode"));
//			}
//			if (accountDetailedQueryReq.getBgnDate() == null || StringUtils.isEmpty(accountDetailedQueryReq.getBgnDate()))
//			{
//				throw new BizException(MessageCode.M1000, msa.getMessage(MessageCode.M1000, "AccountDetailedQueryReq.bgnDate"));
//			}
//			if (accountDetailedQueryReq.getEndDate() == null || StringUtils.isEmpty(accountDetailedQueryReq.getEndDate()))
//			{
//				throw new BizException(MessageCode.M1000, msa.getMessage(MessageCode.M1000, "AccountDetailedQueryReq.endDate"));
//			}
//
//			// 调用核心账户查询余额接口获取账户余额信息
//			PagingQueryFncListReq pagingQueryFncListReq = ServiceMessageBuilder.buildReqMessageByAnotherMessage(PagingQueryFncListReq.class, accountDetailedQueryReq);
//			pagingQueryFncListReq.setFnType(accountDetailedQueryReq.getFnType());
//			pagingQueryFncListReq.setFnTypeArry(accountDetailedQueryReq.getFnTypeArry());
//			pagingQueryFncListReq.setAccCode(accountDetailedQueryReq.getSeAccCode());
//			pagingQueryFncListReq.setCrCode(accountDetailedQueryReq.getCrCode());
//			pagingQueryFncListReq.setAccName(accountDetailedQueryReq.getAccName());
//			pagingQueryFncListReq.setBeginTime(accountDetailedQueryReq.getBgnDate());
//			pagingQueryFncListReq.setEndTime(accountDetailedQueryReq.getEndDate());
//			pagingQueryFncListReq.setFlowType(accountDetailedQueryReq.getFlowFunds());
//			pagingQueryFncListReq.setPageIndex(accountDetailedQueryReq.getPageNum());
//			pagingQueryFncListReq.setPageSize(accountDetailedQueryReq.getPageSize());
//
//			PagingQueryFncListResp pagingQueryFncListResp = p2pAccountServiceProxy.pagingQueryFncList(pagingQueryFncListReq);
//			String respCode = "", respInfo = "";
//			if (pagingQueryFncListResp.successful())
//			{
//				respCode = MessageCode.M0000;
//				respInfo = msa.getMessage(MessageCode.M0000);
//			} else
//			{
//				respCode = MessageCode.M1012;
//				respInfo = msa.getMessage(MessageCode.M1012);
//			}
//
//			// 封装返回对象
//			accountDetailedQueryResp.setRespCode(respCode);
//			accountDetailedQueryResp.setRespMsg(respInfo);
//			// 二级交易账户流水记录
//			if (pagingQueryFncListResp.getBalanceDataList() != null && pagingQueryFncListResp.getBalanceDataList().getDataList() != null && !pagingQueryFncListResp.getBalanceDataList().getDataList().isEmpty())
//			{
//				accountDetailedQueryResp.setTotalCount(pagingQueryFncListResp.getBalanceDataList().getTotalCount());
//				accountDetailedQueryResp.setTotalPage(pagingQueryFncListResp.getBalanceDataList().getTotalPage());
//				ArrayList<Balance> balanceList = new ArrayList<Balance>();
//				for (int i = 0; i < pagingQueryFncListResp.getBalanceDataList().getDataList().size(); i++)
//				{
//					if (pagingQueryFncListResp.getBalanceDataList().getDataList().get(i) == null)
//					{
//						continue;
//					}
//					Balance balance = accountDetailedQueryResp.new Balance();
//					balance.setAccTrdNo(pagingQueryFncListResp.getBalanceDataList().getDataList().get(i).getAccTrdNo());
//					balance.setBalance(pagingQueryFncListResp.getBalanceDataList().getDataList().get(i).getBalance());
//					balance.setBalanceFig(pagingQueryFncListResp.getBalanceDataList().getDataList().get(i).getBalanceFig());
//					balance.setCrCode(pagingQueryFncListResp.getBalanceDataList().getDataList().get(i).getCrCode());
//					balance.setFnCode(pagingQueryFncListResp.getBalanceDataList().getDataList().get(i).getFnCode());
//					balance.setFnType(pagingQueryFncListResp.getBalanceDataList().getDataList().get(i).getFnType());
//					balance.setFrtTrdNo(pagingQueryFncListResp.getBalanceDataList().getDataList().get(i).getFrtTrdNo());
//					balance.setId(pagingQueryFncListResp.getBalanceDataList().getDataList().get(i).getId());
//					balance.setLockBalance(pagingQueryFncListResp.getBalanceDataList().getDataList().get(i).getLockBalance());
//					balance.setSeCode(pagingQueryFncListResp.getBalanceDataList().getDataList().get(i).getSeCode());
//					balance.setTrdAmt(pagingQueryFncListResp.getBalanceDataList().getDataList().get(i).getTrdAmt());
//					balance.setTrdCode(pagingQueryFncListResp.getBalanceDataList().getDataList().get(i).getTrdCode());
//					balance.setTrdMemo(pagingQueryFncListResp.getBalanceDataList().getDataList().get(i).getTrdMemo());
//					balance.setTrdTime(pagingQueryFncListResp.getBalanceDataList().getDataList().get(i).getTrdTime());
//					balanceList.add(balance);
//				}
//				accountDetailedQueryResp.setBalanceList(balanceList);
//			}
//
//		} catch (BizException be)
//		{
//			LOGGER.error("InterAccountServiceImpl.accDetailedQuery BIZ_ERROR:", be);
//			if (accountDetailedQueryResp == null)
//			{
//				accountDetailedQueryResp = new AccountDetailedQueryResp();
//			}
//			accountDetailedQueryResp.setRespCode(be.getErrorInfo().getErrorCode());
//			accountDetailedQueryResp.setRespMsg(be.getErrorInfo().getErrorMessage());
//		} catch (Exception e)
//		{
//			LOGGER.error("InterAccountServiceImpl.accDetailedQuery ERROR:", e);
//			if (accountDetailedQueryResp == null)
//			{
//				accountDetailedQueryResp = new AccountDetailedQueryResp();
//			}
//			accountDetailedQueryResp.setRespCode(MessageCode.M9999);
//			accountDetailedQueryResp.setRespMsg(msa.getMessage(MessageCode.M9999));
//		}
//
//		return accountDetailedQueryResp;
//	}
//
//	@Override
//	public AccMaintainResp maintainAccStat(AccMaintainReq accMaintainReq)
//	{
//		AccMaintainResp accMaintainResp = null;
//		try
//		{
//			accMaintainResp = ServiceMessageBuilder.buildRespMessage(AccMaintainResp.class, accMaintainReq);
//
//			LOGGER.info("账户状态维护--PBAP发送请求报文:" + accMaintainReq.toJsonString());
//
//			// 验证公共参数（系统编号、业务类型、前置交易流水号）
//			String errParam = ComUtil.checkServiceReqMsg(accMaintainReq, AccMaintainReq.class, ComUtil.CHECK_YES_TRDNUM);
//			if (!ComUtil.CHECK_YES.equals(errParam))
//			{
//				throw new BizException(MessageCode.M1000, msa.getMessage(MessageCode.M1000, errParam));
//			}
//			// 校验账户状态维护必填参数
//			if (accMaintainReq.getSeAccCode() == null || StringUtils.isEmpty(accMaintainReq.getSeAccCode()))
//			{
//				throw new BizException(MessageCode.M1000, msa.getMessage(MessageCode.M1000, "AccMaintainReq.seAccCode"));
//			}
//			if (accMaintainReq.getModifyBy() == null || StringUtils.isEmpty(accMaintainReq.getModifyBy()))
//			{
//				throw new BizException(MessageCode.M1000, msa.getMessage(MessageCode.M1000, "AccMaintainReq.modifyBy"));
//			}
//			if (accMaintainReq.getAccStatus() == null || StringUtils.isEmpty(accMaintainReq.getAccStatus()))
//			{
//				throw new BizException(MessageCode.M1000, msa.getMessage(MessageCode.M1000, "AccMaintainReq.accStatus"));
//			}
//
//			// 封装查询对象
//			// TradeBacsQuery trdBacsQuery = new TradeBacsQuery();
//			// trdBacsQuery.setFrtTrdNum(accMaintainReq.getFrontTrdNum());
//
//			// 查询账户核心前置交易流水记录
//			// TradeBacs tradeBacs = trdbacsTran.selectTrdInfo(trdBacsQuery);
//
//			// String trdNumStr = "";
//			// 如果查询有记录且状态不为初始化状态 则将当前状态返回给调用者
//			// if (tradeBacs != null) {
//			// if (!(TranStatus.INIT_STATUS.equals(tradeBacs.getStatus()))) {
//			// accMaintainResp.setFrontTrdNum(accMaintainReq.getFrontTrdNum());
//			// accMaintainResp.setBsspTrdNum(tradeBacs.getTrdNum());
//			// accMaintainResp.setSeAccCode(accMaintainReq.getSeAccCode());
//			// accMaintainResp.setRespCode(tradeBacs.getAccRespCode());
//			// accMaintainResp.setRespMsg(tradeBacs.getAccRespInfo());
//			// return accMaintainResp;
//			// } else {
//			// trdNumStr = tradeBacs.getTrdNum(); // 网关核心交易流水号
//			// }
//			// } else {
//			// trdNumStr = trdbacsTran.selectBySeqNum(TrdNumSeqName.SEQ_GA_NUM);
//			// // 网关核心交易流水号
//			// trdNumStr = ComUtil.getGwTrdNum(TrdNumSeqName.TRD_GANUM_TOP,
//			// trdNumStr);
//			//
//			// LOGGER.info("InterAccountServiceImpl.maintainAccStat
//			// INFO:准备保存账户核心前置流水记录");
//			// // 记录账户核心前置流水
//			// TradeBacs trdBacs = new TradeBacs();
//			// trdBacs.setTrdNum(trdNumStr);
//			// trdBacs.setFrtTrdNum(accMaintainReq.getFrontTrdNum());
//			// trdBacs.setStatus(TranStatus.INIT_STATUS);
//			// trdBacs.setCheckStatus(ReconciliationStatus.NOT_RECONCILIATION_STATUS);
//			//
//			// trdbacsTran.insertTradeData(trdBacs); // 保存数据库
//			// LOGGER.info("InterAccountServiceImpl.maintainAccStat
//			// INFO:保存账户核心前置流水记录成功");
//			// }
//
//			ModifyAccReq modifyAccReq = ServiceMessageBuilder.buildReqMessageByAnotherMessage(ModifyAccReq.class, accMaintainReq);
//			// modifyAccReq.setFrontTrdNum(trdNumStr);
//			modifyAccReq.setAccCode(accMaintainReq.getSeAccCode());
//			modifyAccReq.setAccMemo(accMaintainReq.getRemark());
//			modifyAccReq.setAccStatus(accMaintainReq.getAccStatus());
//			modifyAccReq.setModifyBy(accMaintainReq.getModifyBy());
//
//			LOGGER.info("InterAccountServiceImpl.maintainAccStat INFO:准备调用账户核心账户状态维护接口");
//
//			// 调用账户核心账户状态维护接口
//			ModifyAccResp modifyAccResp = p2pAccountServiceProxy.modifyAcc(modifyAccReq);
//			// String statusCode = "";
//			// if (modifyAccResp.successful()) {
//			// statusCode = TranStatus.SUCCESS_STATUS;
//			// } else {
//			// statusCode = TranStatus.FAILURE_STATUS;
//			// }
//
//			accMaintainResp.setRespCode(modifyAccResp.getRespCode());
//			accMaintainResp.setRespMsg(modifyAccResp.getRespMsg());
//
//			LOGGER.info("InterAccountServiceImpl.maintainAccStat INFO:调用账户核心账户状态维护接口成功");
//			LOGGER.info("InterAccountServiceImpl.maintainAccStat INFO:准备更新账户核心前置流水信息");
//
//			// 成功则更新账户核心前置流水状态
//			// TradeBacs trdBacs = new TradeBacs();
//			// trdBacs.setTrdNum(trdNumStr);
//			// trdBacs.setAccRespCode(modifyAccResp.getRespCode());
//			// trdBacs.setAccRespInfo(modifyAccResp.getRespMsg());
//			// trdBacs.setAccTrdNo(accMaintainReq.getSeAccCode()); // 二级交易账户号
//			// trdBacs.setStatus(statusCode);
//			//
//			// try {
//			// trdbacsTran.updateByTrdStatus(trdBacs); // 更新数据库
//			// } catch (BizException b) {
//			// BsspComUtils.checkBacsTrdState(trdbacsTran, b, trdBacsQuery,
//			// accMaintainResp);
//			// }
//			//
//			// LOGGER.info("InterAccountServiceImpl.maintainAccStat
//			// INFO:更新账户核心前置流水信息成功");
//
//			accMaintainResp.setFrontTrdNum(accMaintainReq.getFrontTrdNum());
//			// accMaintainResp.setBsspTrdNum(trdNumStr);
//			accMaintainResp.setSeAccCode(accMaintainReq.getSeAccCode());
//		} catch (BizException be)
//		{
//			LOGGER.error("InterAccountServiceImpl.maintainAccStat BIZ_ERROR:", be);
//			if (accMaintainResp == null)
//			{
//				accMaintainResp = new AccMaintainResp();
//			}
//			accMaintainResp.setRespCode(be.getErrorInfo().getErrorCode());
//			accMaintainResp.setRespMsg(be.getErrorInfo().getErrorMessage());
//		} catch (Exception e)
//		{
//			LOGGER.error("InterAccountServiceImpl.maintainAccStat ERROR:", e);
//			if (accMaintainResp == null)
//			{
//				accMaintainResp = new AccMaintainResp();
//			}
//			accMaintainResp.setRespCode(MessageCode.M9999);
//			accMaintainResp.setRespMsg(msa.getMessage(MessageCode.M9999));
//		}
//		return accMaintainResp;
//	}
//
//	@Override
//	public SeAccQueryResp seAccQuery(SeAccQueryReq seAccQueryReq)
//	{
//		SeAccQueryResp seAccQueryResp = null;
//
//		try
//		{
//			// 封装账户余额查询响应对象
//			seAccQueryResp = ServiceMessageBuilder.buildRespMessage(SeAccQueryResp.class, seAccQueryReq);
//			LOGGER.info("二级交易账户分页查询--PBMS发送请求报文:" + seAccQueryReq.toJsonString());
//			// 验证公共参数（系统编号、业务类型）
//			String errParam = ComUtil.checkServiceReqMsg(seAccQueryReq, SeAccQueryReq.class, ComUtil.CHECK_NO_TRDNUM);
//			if (!ComUtil.CHECK_YES.equals(errParam))
//			{
//				throw new BizException(MessageCode.M1000, msa.getMessage(MessageCode.M1000, errParam));
//			}
//			// 校验二级交易账户分页查询必填参数
//			if (seAccQueryReq.getBeginTime() == null || StringUtils.isEmpty(seAccQueryReq.getBeginTime()))
//			{
//				throw new BizException(MessageCode.M1000, msa.getMessage(MessageCode.M1000, "SeAccQueryReq.beginTime"));
//			}
//			if (seAccQueryReq.getEndTime() == null || StringUtils.isEmpty(seAccQueryReq.getEndTime()))
//			{
//				throw new BizException(MessageCode.M1000, msa.getMessage(MessageCode.M1000, "SeAccQueryReq.endTime"));
//			}
//			if (seAccQueryReq.getPageIndex() == null || seAccQueryReq.getPageIndex() <= 0)
//			{
//				throw new BizException(MessageCode.M1000, msa.getMessage(MessageCode.M1000, "SeAccQueryReq.pageIndex"));
//			}
//			if (seAccQueryReq.getPageSize() == null || seAccQueryReq.getPageSize() <= 0)
//			{
//				throw new BizException(MessageCode.M1000, msa.getMessage(MessageCode.M1000, "SeAccQueryReq.pageSize"));
//			}
//			PagingQueryAccListReq pagingQueryAccListReq = ServiceMessageBuilder.buildReqMessageByAnotherMessage(PagingQueryAccListReq.class, seAccQueryReq);
//			pagingQueryAccListReq.setAccCode(seAccQueryReq.getSeAccCode());
//			pagingQueryAccListReq.setAccName(seAccQueryReq.getSeAccName());
//			pagingQueryAccListReq.setAccStatus(seAccQueryReq.getAccStatus());
//			pagingQueryAccListReq.setCrCode(seAccQueryReq.getCrCode());
//			pagingQueryAccListReq.setBeginTime(seAccQueryReq.getBeginTime());
//			pagingQueryAccListReq.setEndTime(seAccQueryReq.getEndTime());
//			pagingQueryAccListReq.setPageIndex(seAccQueryReq.getPageIndex());
//			pagingQueryAccListReq.setPageSize(seAccQueryReq.getPageSize());
//			// 调用核心账户二级交易账户查询数据
//			PagingQueryAccListResp pagingQueryAccListResp = p2pAccountServiceProxy.pagingQueryAccList(pagingQueryAccListReq);
//			String respCode = "", respInfo = "";
//			if (pagingQueryAccListResp.successful())
//			{
//				respCode = MessageCode.M0000;
//				respInfo = msa.getMessage(MessageCode.M0000);
//			} else
//			{
//				respCode = MessageCode.M1024;
//				respInfo = msa.getMessage(MessageCode.M1024);
//			}
//			// 封装返回对象
//			seAccQueryResp.setRespCode(respCode);
//			seAccQueryResp.setRespMsg(respInfo);
//			if (pagingQueryAccListResp.getSecoundaryViewList() != null && pagingQueryAccListResp.getSecoundaryViewList().getDataList() != null && !pagingQueryAccListResp.getSecoundaryViewList().getDataList().isEmpty())
//			{
//				PagingData<SeAccInfo> seAccPagingData = new PagingData<SeAccInfo>();
//				seAccPagingData.setPageIndex(pagingQueryAccListResp.getSecoundaryViewList().getPageIndex());
//				seAccPagingData.setPageSize(pagingQueryAccListResp.getSecoundaryViewList().getPageSize());
//				seAccPagingData.setTotalCount(pagingQueryAccListResp.getSecoundaryViewList().getTotalCount());
//				seAccPagingData.setTotalPage(pagingQueryAccListResp.getSecoundaryViewList().getTotalCount(), pagingQueryAccListResp.getSecoundaryViewList().getPageSize());
//				List<SecoundaryView> seAccViewList = pagingQueryAccListResp.getSecoundaryViewList().getDataList();
//				List<SeAccInfo> seAccList = new ArrayList<SeAccInfo>();
//				for (int i = 0; i < seAccViewList.size(); i++)
//				{
//					SeAccInfo seAccInfo = seAccQueryResp.new SeAccInfo();
//					seAccInfo.setAccCode(seAccViewList.get(i).getAccCode());
//					seAccInfo.setAccMemo(seAccViewList.get(i).getAccMemo());
//					seAccInfo.setAccName(seAccViewList.get(i).getAccName());
//					seAccInfo.setAccStatus(seAccViewList.get(i).getAccStatus());
//					seAccInfo.setAccType(seAccViewList.get(i).getAccType());
//					seAccInfo.setAvaAssert(seAccViewList.get(i).getAvaAssert());
//					seAccInfo.setCrCode(seAccViewList.get(i).getCrCode());
//					seAccInfo.setCreateBy(seAccViewList.get(i).getCreateBy());
//					seAccInfo.setCreateTime(seAccViewList.get(i).getCreateTime());
//					seAccInfo.setDebtAssert(seAccViewList.get(i).getDebtAssert());
//					seAccInfo.setFrtTrdNum(seAccViewList.get(i).getFrtTrdNum());
//					seAccInfo.setId(seAccViewList.get(i).getId());
//					seAccInfo.setLockAssert(seAccViewList.get(i).getLockAssert());
//					seAccInfo.setMasterCode(seAccViewList.get(i).getMasterCode());
//					seAccInfo.setModfiyBy(seAccViewList.get(i).getModfiyBy());
//					seAccInfo.setModfiyTime(seAccViewList.get(i).getModfiyTime());
//					seAccList.add(seAccInfo);
//				}
//				seAccPagingData.setDataList(seAccList);
//				seAccQueryResp.setSecoundaryViewList(seAccPagingData);
//			}
//		} catch (BizException be)
//		{
//			LOGGER.error("InterAccountServiceImpl.seAccQuery BIZ_ERROR:", be);
//			if (seAccQueryResp == null)
//			{
//				seAccQueryResp = new SeAccQueryResp();
//			}
//			seAccQueryResp.setRespCode(be.getErrorInfo().getErrorCode());
//			seAccQueryResp.setRespMsg(be.getErrorInfo().getErrorMessage());
//		} catch (Exception e)
//		{
//			LOGGER.error("InterAccountServiceImpl.seAccQuery ERROR:", e);
//			if (seAccQueryResp == null)
//			{
//				seAccQueryResp = new SeAccQueryResp();
//			}
//			seAccQueryResp.setRespCode(MessageCode.M9999);
//			seAccQueryResp.setRespMsg(msa.getMessage(MessageCode.M9999));
//		}
//
//		return seAccQueryResp;
//	}
//
//}