package com.yjlc.commons.exception;
/**
 * 描述: 抛出业务异常
 * 作者: Administrator
 * 公司: 深圳市前海巨应信息技术有限公司
 * 日期: 2017-4-1 下午10:26:07 
 * 版本号: V1.0
 */
public class ServiceException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private Integer resultCode;

	public ServiceException(Integer resultCode, String message) {
		super(message);
		this.resultCode = resultCode;
	}

	public ServiceException(String message) {
		super(message);
	}

	public Integer getResultCode() {
		return resultCode;
	}

}
