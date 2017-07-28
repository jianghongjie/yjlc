package org.sc.rest.provider.util;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
/**
 * 描述: 请求帮助
 * 作者: 扫地僧
 * 公司: 深圳市前海技术有限公司
 * 日期: 2017-4-2 下午6:15:22 
 * 版本号: V1.0
 */
public class ReqUtil {
	/**
	 * 获取当前登录用户id
	 * 参数: @return
	 * 返回值类型: int
	 * 作者: 扫地僧 
	 * 日期: 2017-4-2 下午4:42:33
	 */
	public static int getUserId() {
        return getUserId(getToken());
	}
	
	/**
	 * 描述: 根据token 获取用户id
	 * 参数: @param token
	 * 参数: @return
	 * 返回值类型: int
	 * 作者: 扫地僧 
	 * 日期: 2017-4-2 下午4:42:22
	 */
	public static int getUserId(String token) {
	    //String userId = RedisUtil.hget(KeyBuilder.getCacheKey(Constants.CacheKeyPre.Session), "userId");
//		String userId=RedisUtil.get(KeyBuilder.getCacheKey(Constants.CacheKeyPre.Session,token));
//		
//		if(StringUtils.isEmpty(userId)){
//		}else{
//			return Integer.parseInt(userId);
//		}
		
			return 0;
//        return StringUtil.isBlank(userId) ? 0 : Integer.parseInt(userId);
	}
	public static  HttpServletRequest getRequest() {
		if (RequestContextHolder.getRequestAttributes() == null) {
    		return null;
    	}
		return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
	}
	
	
	public static boolean isBDJL() {
		boolean isBDJL = false;
		HttpServletRequest req = getRequest();
		if(req != null){
			String header = req.getHeader("User-Agent");
			isBDJL = StringUtils.containsIgnoreCase(header, "bdjl");
			if(!isBDJL){
				String webAgent = req.getHeader("Web-Agent");
				isBDJL = StringUtils.containsIgnoreCase(webAgent, "bdjl");
			}
		}
		return isBDJL;
	}
	
	/**
	 * 是否来自微信服务号H5调用
	 * @return
	 * @author xieping
	 */
	public static boolean isFromWechat() {
		HttpServletRequest req = getRequest();
		if(req != null){
			String webAgent = req.getHeader("Web-Agent");
			return StringUtils.containsIgnoreCase(webAgent, "Wechat");
		}
		return false;
	}

	
	/**
	 * 描述: TODO(用一句话描述该文件做什么) 
	 * 参数: @return
	 * 返回值类型: String
	 * 作者: 扫地僧 
	 * 日期: 2017-4-2 下午2:40:32
	 */
    public static String getToken() {
    	if (getRequest() == null) {
    		return "";
    	}
        return getRequest().getParameter("access_token");
    }
    
    /**
     * 描述: 获取请求的IP
     * 参数: @return
     * 返回值类型: String
     * 作者: 扫地僧 
     * 日期: 2017-4-2 下午2:40:45
     */
    public static String getRequestIp() {
		HttpServletRequest request = getRequest();
		String requestIp = request.getHeader("x-forwarded-for");

		if (requestIp == null || requestIp.isEmpty() || "unknown".equalsIgnoreCase(requestIp)) {
			requestIp = request.getHeader("X-Real-IP");
		}
		if (requestIp == null || requestIp.isEmpty() || "unknown".equalsIgnoreCase(requestIp)) {
			requestIp = request.getHeader("Proxy-Client-IP");
		}
		if (requestIp == null || requestIp.isEmpty() || "unknown".equalsIgnoreCase(requestIp)) {
			requestIp = request.getHeader("WL-Proxy-Client-IP");
		}
		if (requestIp == null || requestIp.isEmpty() || "unknown".equalsIgnoreCase(requestIp)) {
			requestIp = request.getHeader("HTTP_CLIENT_IP");
		}
		if (requestIp == null || requestIp.isEmpty() || "unknown".equalsIgnoreCase(requestIp)) {
			requestIp = request.getHeader("HTTP_X_FORWARDED_FOR");
		}
		if (requestIp == null || requestIp.isEmpty() || "unknown".equalsIgnoreCase(requestIp)) {
			requestIp = request.getRemoteAddr();
		}
		if (requestIp == null || requestIp.isEmpty() || "unknown".equalsIgnoreCase(requestIp)) {
			requestIp = request.getRemoteHost();
		}

		return requestIp;
	}
    
}
