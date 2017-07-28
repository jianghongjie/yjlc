package org.sc.rest.consumer.filter;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Component
@ConfigurationProperties(prefix = "authorizationFilter")
public class SecurityInterceptorConfig extends WebMvcConfigurerAdapter{
	@Autowired
	private SecurityInterceptor securityInterceptor;
	
	@Autowired
	private SecurityInterceptorProperties properties;

	/** 
     * 配置拦截器 
     * @author 姜宏杰 
     * @param registry 
     * date：2017年4月4日15:56:28
     */  
    public void addInterceptors(InterceptorRegistry registry) {  
    	InterceptorRegistration registration = registry.addInterceptor(securityInterceptor);
    	registration.addPathPatterns("/**");//拦截所有的请求
    	if(properties!=null){
    		List<String> ignoredUriList = properties.getIgnoredUriList();
    		if(ignoredUriList!=null && ignoredUriList.size()>0){
    			for(String url:ignoredUriList){
    				registration.excludePathPatterns(url);
    			}
    		}
    	}
        super.addInterceptors(registry);
    }  
}
