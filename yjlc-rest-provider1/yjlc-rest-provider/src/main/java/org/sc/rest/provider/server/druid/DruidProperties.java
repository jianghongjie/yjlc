package org.sc.rest.provider.server.druid;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 描述: 数据库连接池设置
 * 作者: jhj
 * 公司: 深圳市前海巨应信息技术有限公司
 * 日期: 2017-3-30 下午9:52:38 
 * 版本号: V1.0
 */
@ConfigurationProperties(prefix = "druid")
public class DruidProperties {
    private String url;//数据库链接地址
    private String username;//数据库用户名
    private String password;//密码
    private String driverClass;//驱动

    private int     maxActive;//最大连接数
    private int     minIdle;
    private int     initialSize;
    private boolean testOnBorrow;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDriverClass() {
        return driverClass;
    }

    public void setDriverClass(String driverClass) {
        this.driverClass = driverClass;
    }

    public int getMaxActive() {
        return maxActive;
    }

    public void setMaxActive(int maxActive) {
        this.maxActive = maxActive;
    }

    public int getMinIdle() {
        return minIdle;
    }

    public void setMinIdle(int minIdle) {
        this.minIdle = minIdle;
    }

    public int getInitialSize() {
        return initialSize;
    }

    public void setInitialSize(int initialSize) {
        this.initialSize = initialSize;
    }

    public boolean isTestOnBorrow() {
        return testOnBorrow;
    }

    public void setTestOnBorrow(boolean testOnBorrow) {
        this.testOnBorrow = testOnBorrow;
    }
}
