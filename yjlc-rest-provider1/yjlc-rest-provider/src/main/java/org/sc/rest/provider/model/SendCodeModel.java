package org.sc.rest.provider.model;

import com.joinwe.common.api.dto.BaseEntity;

public class SendCodeModel extends BaseEntity{
	
	private static final long serialVersionUID = 1L;
	
	/** 手机 **/
	private String cusMobile;
	/** 验证码 **/
	private String randNum;
	/** 验证码失效时间 **/
	private String LostTime;
	/** 发送内容 **/
	private String sendInfo;
	/** 用户编号 **/
	private String cusCode;
	/** 短信类型 **/
	private int smsType;
	
	public String getCusMobile() {
		return cusMobile;
	}
	public void setCusMobile(String cusMobile) {
		this.cusMobile = cusMobile;
	}
	public String getRandNum() {
		return randNum;
	}
	public void setRandNum(String randNum) {
		this.randNum = randNum;
	}
	public String getLostTime() {
		return LostTime;
	}
	public void setLostTime(String lostTime) {
		LostTime = lostTime;
	}
	public String getSendInfo() {
		return sendInfo;
	}
	public void setSendInfo(String sendInfo) {
		this.sendInfo = sendInfo;
	}
	public int getSmsType() {
		return smsType;
	}
	public void setSmsType(int smsType) {
		this.smsType = smsType;
	}

	public String getCusCode() {
		return cusCode;
	}

	public void setCusCode(String cusCode) {
		this.cusCode = cusCode;
	}
}
