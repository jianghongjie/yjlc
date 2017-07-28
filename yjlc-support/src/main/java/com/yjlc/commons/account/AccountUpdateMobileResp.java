package com.yjlc.commons.account;

import com.yjlc.commons.ApiServiceMessage;

/**
 * 5.2.33	客户手机号变更响应实体类
 * 
 * @author zshen（2015-11-16）
 */
public class AccountUpdateMobileResp extends ApiServiceMessage {

	private static final long serialVersionUID = 1L;

	/** 成功状态码  */
	private static final String SUCCESS_CODE = "C000000000";
	
	/** 处理中状态码  */
	private static final String PROCESSING_CODE = "W000000000";
	
	/** 交易代码 M */
	private String trancode;

	/** 报文类型 (请求报文应该为：0001) M */
	private String msgtype = "0001";

	/** 业务流水号(业务流水号需要以商户号开头) M */
	private String bussflowno;

	/** 商户号 M */
	private String merchantno;

	/** 版本号(初始值：1.0.0) M */
	private String version = "1.0.0";

	/** 渠道号(第三方商户固定“HM”) M */
	private String channelno = "HM";

	/** 客户端交易日期(格式：YYYYMMDD) M */
	private String trandate;

	/** 客户端交易时间(格式：HHMMSS) M */
	private String trantime;

	/** 交易状态 (业务处理返回报文时才会出现该字段 C000000000 为交易成功，其他为失败或可疑) O */
	private String respcode;

	/** 状态描述(业务处理返回报文时才会出现该字段) O */
	private String respmsg;
	
	/** 网关流水号 M **/
	private String bsspTrdNum;
	
	public boolean successful() {
		return SUCCESS_CODE.equals(respcode);
	}
	
	public boolean processingful() {
		return PROCESSING_CODE.equals(respcode);
	}

	public String getTrancode() {
		return trancode;
	}

	public void setTrancode(String trancode) {
		this.trancode = trancode;
	}

	public String getMsgtype() {
		return msgtype;
	}

	public void setMsgtype(String msgtype) {
		this.msgtype = msgtype;
	}

	public String getBussflowno() {
		return bussflowno;
	}

	public void setBussflowno(String bussflowno) {
		this.bussflowno = bussflowno;
	}

	public String getMerchantno() {
		return merchantno;
	}

	public void setMerchantno(String merchantno) {
		this.merchantno = merchantno;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getChannelno() {
		return channelno;
	}

	public void setChannelno(String channelno) {
		this.channelno = channelno;
	}

	public String getTrandate() {
		return trandate;
	}

	public void setTrandate(String trandate) {
		this.trandate = trandate;
	}

	public String getTrantime() {
		return trantime;
	}

	public void setTrantime(String trantime) {
		this.trantime = trantime;
	}

	public String getRespcode() {
		return respcode;
	}

	public void setRespcode(String respcode) {
		this.respcode = respcode;
	}

	public String getRespmsg() {
		return respmsg;
	}

	public void setRespmsg(String respmsg) {
		this.respmsg = respmsg;
	}

	public String getBsspTrdNum() {
		return bsspTrdNum;
	}

	public void setBsspTrdNum(String bsspTrdNum) {
		this.bsspTrdNum = bsspTrdNum;
	}
	
}
