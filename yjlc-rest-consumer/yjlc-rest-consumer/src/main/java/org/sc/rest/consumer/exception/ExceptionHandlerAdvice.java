package org.sc.rest.consumer.exception;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.alibaba.fastjson.JSON;
import com.yjlc.commons.exception.ServiceException;
/**
 * 描述: 自定义异常处理，即在Controller中抛出自定义的异常时，客户端收到更友好的JSON格式的提示。而不是常见的报错页面。
 * 作者: 扫地僧
 * 公司: 深圳市前海技术有限公司
 * 日期: 2017-4-4 下午5:34:42 
 * 版本号: V1.0
 */
@ControllerAdvice
public class ExceptionHandlerAdvice {
	private static final Logger LOGGER = LoggerFactory.getLogger(ExceptionHandlerAdvice.class);
	
	@ExceptionHandler(value = { Exception.class, RuntimeException.class })
	public void handleErrors(HttpServletRequest request, HttpServletResponse response, Exception e) throws Exception {
		LOGGER.error("接口请求错误：{}",request.getRequestURI());
		e.printStackTrace();
		int resultCode = 100100;
		String resultMsg = "服务器繁忙，请稍后再试！";
		String detailMsg = "";

		if (e instanceof MissingServletRequestParameterException || e instanceof BindException) {
			resultCode = 100101;
			resultMsg = "请求参数验证失败，缺少必填参数或参数错误";
		} else if (e instanceof ServiceException) {//我们自己抛出的业务异常
			ServiceException ex = ((ServiceException) e);
			resultCode = null == ex.getResultCode() ? 0 : ex.getResultCode();
			resultMsg = ex.getMessage();
		} else {
			detailMsg = e.getMessage();
		}
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("resultCode", resultCode);
		map.put("resultMsg", resultMsg);
		map.put("detailMsg", detailMsg);
		String text = JSON.toJSONString(map);
		response.setContentType("application/json; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(text);
		response.getWriter().flush();
	}
}
