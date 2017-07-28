package org.sc.rest.provider.server.jedis;

import javax.annotation.Resource;

import org.sc.rest.provider.server.base.SystemConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.exceptions.JedisConnectionException;
import redis.clients.util.Pool;

import com.yjlc.commons.serialize.SerializeUtil;

@Component
public class JedisWrap {
	private static Logger logger = LoggerFactory.getLogger(JedisWrap.class);

	@Resource(name = "jedisPool")
	private Pool<Jedis> jedisPool;
	
	private static JedisWrap INSTANCE;
	
	private JedisWrap()
	{
		INSTANCE = this;
	}
	public static JedisWrap getInstance()
	{
		if(INSTANCE==null)
		{
			INSTANCE = SystemConfig.getBean(JedisWrap.class);
		}
		return INSTANCE;
	}
	
	private void close(Jedis jedis) {
		try {
			logger.info("jedis is closed.");
			jedisPool.returnResource(jedis);;
		} catch (Exception e) {
			jedis.close();
		}
	}

	private Jedis getJedis()
	{
		Jedis jedis  = null;  
        int count =0;  
        do{  
            try{ 
                jedis = jedisPool.getResource();  
            } catch (Exception e) {  
                 // 销毁对象    
            	if(jedis!=null)
            	{
            		jedis.close();    
            	}
            }  
            count++;  
        }while(jedis==null&&count<3);  
		if (jedis == null) {
			throw new JedisConnectionException("redis 连接失败!");
		}
		return jedis;
	}


	public Long expire(final String key, final int seconds) {
		Jedis jedis = getJedis();
		try {
			return jedis.expire(key, seconds);
		} catch (JedisConnectionException ex) {
			throw ex;
		} catch (ClassCastException ex) {
			throw ex;
		} finally {
			close(jedis);
		}
	}

	public Long ttl(final String key) {
		Jedis jedis = getJedis();
		try {
			return jedis.ttl(key);
		} catch (JedisConnectionException ex) {
			throw ex;
		} catch (ClassCastException ex) {
			throw ex;
		} finally {
			close(jedis);
		}
	}

	public Long decr(final String key) {
		Jedis jedis = getJedis();
		try {
			return jedis.decr(key);
		} catch (JedisConnectionException ex) {
			throw ex;
		} catch (ClassCastException ex) {
			throw ex;
		} finally {
			close(jedis);
		}
	}

	public void del(final String... keys) {
		Jedis jedis = getJedis();
		try {
			jedis.del(keys);
		} catch (JedisConnectionException ex) {
			throw ex;
		} catch (ClassCastException ex) {
			throw ex;
		} finally {
			close(jedis);
		}
	}

	public Boolean keyExists(final String key) {

		Jedis jedis = getJedis();
		try {
			return jedis.exists(key);
		} catch (JedisConnectionException ex) {
			throw ex;
		} catch (ClassCastException ex) {
			throw ex;
		} finally {
			close(jedis);
		}
	}

	public void flushDB() {
		Jedis jedis = getJedis();
		try {
			jedis.flushDB();
		} catch (JedisConnectionException ex) {
			throw ex;
		} catch (ClassCastException ex) {
			throw ex;
		} finally {
			close(jedis);
		}

	}

	public String get(final String key) {

		Jedis jedis = getJedis();
		try {
			return jedis.get(key);
		} catch (JedisConnectionException ex) {
			throw ex;
		} catch (ClassCastException ex) {
			throw ex;
		} finally {
			close(jedis);
		}
	}
	

	public void rpush(final String key, final String... values) {

		Jedis jedis = getJedis();
		try {
			jedis.rpush(key, values);
		} catch (JedisConnectionException ex) {
			throw ex;
		} catch (ClassCastException ex) {
			throw ex;
		} finally {
			close(jedis);
		}
	}
	public String lpop(final String key) {
		Jedis jedis = getJedis();
		try {
			return jedis.lpop(key);
		} catch (JedisConnectionException ex) {
			throw ex;
		} catch (ClassCastException ex) {
			throw ex;
		} finally {
			close(jedis);
		}
	}

	public void set(final String key, final String value) {

		Jedis jedis = getJedis();
		try {
			jedis.set(key, value);
		} catch (JedisConnectionException ex) {
			throw ex;
		} catch (ClassCastException ex) {
			throw ex;
		} finally {
			close(jedis);
		}
	}
	/**
	 * 描述: 寸处对象
	 * 参数: @param key
	 * 参数: @param obj
	 * 返回值类型: void
	 * 作者: 扫地僧 
	 * 日期: 2017-4-2 下午9:47:55
	 */
	public void setObject(String key,Object obj) {
		Jedis jedis = getJedis();
		try {
			jedis.set(key.getBytes(), SerializeUtil.serialize(obj));
			logger.info("刚刚存入的redis：key--》"+key+";value--》"+jedis.get(key));
		} catch (JedisConnectionException ex) {
			throw ex;
		} catch (ClassCastException ex) {
			throw ex;
		} finally {
			close(jedis);
		}
	}

	public void setex(final String key, final String value, final int seconds) {

		Jedis jedis = getJedis();
		try {
			jedis.setex(key, seconds, value);
		} catch (JedisConnectionException ex) {
			throw ex;
		} catch (ClassCastException ex) {
			throw ex;
		} finally {
			close(jedis);
		}
	}

	public Boolean setnx(final String key, final String value) {
		Jedis jedis = getJedis();
		try {
			return jedis.setnx(key, value) == 1 ? true : false;
		} catch (JedisConnectionException ex) {
			throw ex;
		} catch (ClassCastException ex) {
			throw ex;
		} finally {
			close(jedis);
		}

	}
}
