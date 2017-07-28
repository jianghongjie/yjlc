package org.sc.rest.provider.server.jedis;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import javax.annotation.PreDestroy;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.sc.rest.provider.server.config.RedisProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.JedisSentinelPool;
import redis.clients.util.Pool;

@Configuration
public class JedisConfiguration {
	
	@Autowired
	private RedisProperties properties;
	
	private Pool<Jedis> jedisPool;
	protected Logger log = LoggerFactory.getLogger(getClass());  
    private static ConcurrentHashMap<String,Pool<Jedis>> maps  
    					= new ConcurrentHashMap<String,Pool<Jedis>>();  
  
    @Bean(name = "jedisPool", destroyMethod = "destroy")
	public Pool<Jedis> createJedisPool() {
    	log.info("jedisPool is create!");
    	jedisPool = getSentinelPool();
    	return jedisPool;
    }
    
    @PreDestroy
    public void destroy() { 
    	log.info("jedisPool is destroy");
    	if(jedisPool!=null){
    		jedisPool.destroy();
    	}
    } 
    
    private JedisSentinelPool getSentinelPool()
    {
        
        JedisSentinelPool sentinelPool = null;
         try{    
        	 int database = properties.getDatabase();
        	 String key = "dc_sentinel_pool_"+database; 
        	 if(maps.containsKey(key)) {  
        		 return (JedisSentinelPool)maps.get(key);
        	 }
        	 
        	 String masterName = properties.getMaster();
        	 Set<String> sentinels = getSentinels(properties.getSentinels());
        	 GenericObjectPoolConfig config = getDefaultPoolConfig();
        	 String password = properties.getPassword();
        	 if(StringUtils.isEmpty(password)){
        		 password = null;
        	 }
        	 int timeout = properties.getTimeout();
         	 sentinelPool = new JedisSentinelPool(masterName, sentinels,
         			config,timeout,password,database);
         	 maps.putIfAbsent(key,sentinelPool);
         } catch(Exception e) {  
             log.error("redis配置错误!");
             return null;
         }  
         
    	return sentinelPool;
    }
      
    private static GenericObjectPoolConfig getDefaultPoolConfig()
    {
       	JedisPoolConfig config = new JedisPoolConfig();  
       	config.setMaxTotal(500);
		config.setLifo(true);
		config.setMinIdle(30);
		config.setMaxIdle(300);
		config.setMaxWaitMillis(5000);
		config.setTestOnBorrow(true);
		config.setTestOnReturn(true);

		config.setTestWhileIdle(true);
		config.setTimeBetweenEvictionRunsMillis(60000);
		config.setNumTestsPerEvictionRun(10);
		config.setMinEvictableIdleTimeMillis(1800000);
        return config;
    }
    
    private static Set<String> getSentinels(String nodes)
	{
		
		if(nodes==null)
		{
			return null;
		}
		Set<String> sentinelsSet = new HashSet<String>();
		String[]arrs = nodes.split(",");
		for(String one:arrs)
		{
			sentinelsSet.add(one);
		}
		return sentinelsSet;
	}
}
