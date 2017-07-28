package org.sc.rest.provider.server.lock;

import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import redis.clients.jedis.Transaction;

/**
 * ClassName： RedisLock<br>
 * Description：<br>
 * redis锁+事务处理并发流程:Object lock<br>
 *  1.检查key(get)是否存在，<br>
 *      a.如果存在则终止<br>
 *      b.如果不存则添加(setnx)<br>
 *      c.休眠10毫秒后再次获取key(get)值是否变化<br>
 *          d.如果值变化则终止<br>
 *          e.如果值未变化，开启事务(watch,multi)<br>
 *  2.删除key(del)<br>
 *  3.提交事务(exec)，如果事务失败，则mysql事务回滚，如果事务成功，则成功 <br>
 * 描述: TODO(用一句话描述该文件做什么) 
 * 作者: Administrator
 * 公司: 深圳市前海巨应信息技术有限公司
 * 日期: 2017-4-2 上午10:13:28 
 * 版本号: V1.0
 */
public class RedisLock {

    private final static Logger logger=LoggerFactory.getLogger(RedisLock.class);
    
    public static final String LockPrefix = "lock:%1$s:%2$s";
    
//    private static JedisTemplate jedisTemplate = SpringBeansUtils.getBean("jedisTemplate");
    private  Transaction tx = null;

//    /**
//     * 描述: 添加锁
//     * 参数: @param key
//     * 参数: @param lockType
//     * 参数: @return
//     * 返回值类型: boolean
//     * 作者: 扫地僧 
//     * 日期: 2017-4-2 下午1:21:25
//     */
//    public boolean lock(String key, LockType lockType) {
//        /*key = "lock_" + key;*/
//        key=KeyBuilder.buildLockKey(lockType, key);
//
//        String value = jedisTemplate.get(key);
//
//        if (StringUtils.isNotBlank(value)) {
//        	logger.info("LockType : "+lockType + " key : " + key+" has locked");
////            RedisUtil.returnJedis(jedis);
//            return false;
//        }
//
//        try {
//            value = System.nanoTime() + StringUtil.random4Code();
//            boolean ok = jedisTemplate.setnx(key, value);
//            //已存在，添加失败
//            if(!ok){
//            	logger.info("LockType : "+lockType + " key : " + key+" has locked");
////                RedisUtil.returnJedis(jedis);
//                return false;
//            }
//            jedisTemplate.expire(key, Constants.Expire.MINUTE1);// 设置10分钟失效
//
//            TimeUnit.MILLISECONDS.sleep(10);// 休眠10毫秒
//
//            // 再次获取锁
//            String newValue = jedisTemplate.get(key);
//
//            // 判断锁中的值是否与设置的一致
//            if (!StringUtil.equals(value, newValue)) {
//            	logger.info("LockType : "+lockType + " key : " + key+" has locked");
////                RedisUtil.returnJedis(jedis);
//                return false;
//            }
//
//            // 事务开始
//            jedisTemplate.watch(key);
//            tx = jedisTemplate.multi();
//
//        } catch (Exception e) {
//            logger.info("LockType : "+lockType + " key : " + key+"  lock fail");
//            jedisTemplate.unwatch();
////            RedisUtil.returnJedis(jedis);
//            return false;
//        }
//        return true;
//    }
//
//   
//    /**
//     * </p>删除锁</p>
//     * @param key
//     * @param lockType
//     * @return true or false 为false的时候需事务回滚
//     * @author 李淼淼
//     * @date 2015年9月16日
//     */
//    public boolean unlock(String key, LockType lockType) {
//        /*key = "lock_" + key;*/
//        key=KeyBuilder.buildLockKey(lockType, key);
//        try {
//            logger.info("LockType : "+lockType + " key : " + key+" unlock");
//            tx.del(key);
//            List<Object> result = tx.exec();
//
//            if (result == null || result.isEmpty()) {
//                return false;
//            }
//        } catch (Exception e) {
//            logger.info("LockType : "+lockType + " key : " + key+"  unlock fail");
//            return false;
//        } finally {
////            RedisUtil.returnJedis(jedis);
//        }
//        return true;
//    }

    public enum LockType {
        recharge(1, "充值"), 
        refund(2, "退款"), 
        withdraw(3, "提现"), 
        consume(4, "消费"), 
        finish(5, "结算"),
        order(6, "订单"),
        ordercheckAndAutoClose(7, "订单自动关闭"),
        orderpay(8, "订单支付"),
    	outPatientOrderCancel(9,"门诊取消订单");
    	
        private int index;

        private String title;

        private LockType(int index, String title) {
            this.index = index;
            this.title = title;
        }

        public int getIndex() {
            return index;
        }

        public void setIndex(int index) {
            this.index = index;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

    }
    
    
    public static String random4Code() {
		return "" + (new Random().nextInt(8999) + 1000);
	}

    /**
     * 根据type生成获取lock的键
     * @param type
     * @param pk
     * @return lock:{type}:{pk}
     */
    public static String buildLockKey(LockType type,String pk) {
        return String.format(LockPrefix, type.name(),pk);
    }
}
