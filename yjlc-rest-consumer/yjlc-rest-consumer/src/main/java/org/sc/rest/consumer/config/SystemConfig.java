package org.sc.rest.consumer.config;

import org.springframework.beans.BeansException;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "system")
public class SystemConfig implements ApplicationContextAware {
	private static ApplicationContext context;

	public static SystemConfig getInstance() {
		return context.getBean(SystemConfig.class);
	}

	private String baseUrl;
//	private String orgUrl;
//	private String imUrl;

	@Override
	public void setApplicationContext(ApplicationContext arg0) throws BeansException {
		context = arg0;
	}

	public String getBaseUrl() {
		return baseUrl==null?null:baseUrl.trim();
	}

	public void setBaseUrl(String baseUrl) {
		this.baseUrl = baseUrl;
	}
//	public String getOrgUrl() {
//		return orgUrl;
//	}
//
//	public void setOrgUrl(String orgUrl) {
//		this.orgUrl = orgUrl;
//	}
//	
//	public String getImUrl() {
//		return imUrl;
//	}
//
//	public void setImUrl(String imUrl) {
//		this.imUrl = imUrl;
//	}

	@SuppressWarnings("unchecked")
	public static <T> T getBean(Class<?> requiredType) {
		return (T) context.getBean(requiredType);
	}


}