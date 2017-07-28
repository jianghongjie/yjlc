package org.sc.rest.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;

@EnableDiscoveryClient
@SpringBootApplication
public class ConsumerApplication {
	
	@Bean
	@LoadBalanced//开启负载均衡
	RestTemplate getRestTemplate() {
        return new RestTemplate();
	}
	
	 @Bean
    public IRule ribbonRule() {
        return new RandomRule();//这里配置策略，和配置文件对应
    }

	public static void main(String[] args) {
		SpringApplication.run(ConsumerApplication.class, args);
	}
}
