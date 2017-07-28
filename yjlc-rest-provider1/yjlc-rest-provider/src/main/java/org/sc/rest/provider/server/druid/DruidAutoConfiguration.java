package org.sc.rest.provider.server.druid;

import javax.sql.DataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.alibaba.druid.pool.DruidDataSource;

/**
 * 描述: 数据库连接池设置
 * 作者: jhj
 * 公司: 深圳市前海巨应信息技术有限公司
 * 日期: 2017-3-30 下午9:52:38 
 * 版本号: V1.0
 */
@Configuration
public class DruidAutoConfiguration {
@Bean  
@ConfigurationProperties(prefix = "spring.datasource")  
public DataSource druidDataSource() {  
    DruidDataSource druidDataSource = new DruidDataSource();  
    return druidDataSource;  
}  
}
