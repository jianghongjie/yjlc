package org.sc.rest.consumer.filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.sc.rest.consumer.jedis.JedisWrap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.yjlc.commons.Result;
import com.yjlc.commons.exception.ServiceException;

@Component
public class SecurityInterceptor implements HandlerInterceptor{
	@Autowired
	JedisWrap jedisWrap;
	@Override
	public void afterCompletion(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2, ModelAndView arg3) throws Exception {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
			Object handler) throws Exception {
		//在请求处理之前进行调用（Controller方法调用之前）
		String accessToken = request.getHeader("access_token");
        if(StringUtils.isEmpty(accessToken)){
        	accessToken = request.getParameter("access-token");
        }
        if (StringUtils.isEmpty(accessToken)) {
        	throw new ServiceException(Result.TOKEN_ERROR,"token不能为空");
        }
        String userId = jedisWrap.get(accessToken);//redis里取值
        if(StringUtils.isEmpty(userId)){
        	throw new ServiceException(Result.TOKEN_INVALID,"token无效。");
        }
		return true;  
	}

}
