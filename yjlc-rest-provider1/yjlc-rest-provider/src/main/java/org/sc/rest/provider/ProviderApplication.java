package org.sc.rest.provider;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;


@EnableDiscoveryClient
@SpringBootApplication
//@EnableWebMvc
@MapperScan(basePackages = "org.sc.rest.provider.mapper")
@ComponentScan("org.sc.rest.provider")//扫描所有的@Component注解
public class ProviderApplication{
	public static void main(String[] args) {
		new SpringApplicationBuilder(ProviderApplication.class).web(true).run(args);
	}
}
