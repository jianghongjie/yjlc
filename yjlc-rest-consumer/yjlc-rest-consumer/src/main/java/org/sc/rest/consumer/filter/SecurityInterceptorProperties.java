package org.sc.rest.consumer.filter;

import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "authorizationFilter")
public class SecurityInterceptorProperties {
	private List<String> ignoredUriList;
	
	public List<String> getIgnoredUriList() {
		return ignoredUriList;
	}
	public void setIgnoredUriList(List<String> ignoredUriList) {
		this.ignoredUriList = ignoredUriList;
	}
}
