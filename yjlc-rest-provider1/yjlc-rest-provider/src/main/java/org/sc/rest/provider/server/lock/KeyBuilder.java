//package org.sc.rest.provider.server.lock;
//
//import org.sc.rest.provider.server.lock.RedisLock.LockType;
//import org.sc.rest.provider.util.ReqUtil;
//
//
//public class KeyBuilder {
//    public static final String HotMsgIdListTemplate = "msg.id.hot.list:%1$s";
//
//    public static final String HotMsgListTemplate = "msg.hot.list:%1$s";
//
//    public static final String LatestMsgIdListTemplate = "msg.id.latest.list:%1$s";
//
//    public static final String LatestMsgListTemplate = "msg.latest.list:%1$s";
//
//    public static final String UserHotMsgIdTemplate = "user.msg.hot:%1$s";
//
//    public static final String UserLatestMsgIdTemplate = "user.msg.latest:%1$s";
//
//    public static final String SMSRandCodePrefix = "password_reset_rand_code:%1$s";
//    
//    public static final String LockPrefix = "lock:%1$s:%2$s";
//    
//
//	/**
//	 * 缓存订单预约时间
//	 * 1、当患者支付成功的时候，往此缓存增加数据：key：z_schedule_pool:guide；score：预约时间；member：guideId+":"+订单Id
//	 * 2、当导医结束服务的时候，删除对应的数据：key：z_schedule_pool:guide；score：预约时间；member：guideId+":"+订单Id
//	 */
//	public final static String Z_SCHEDULE_POOL ="z_schedule_pool";
//	
//    // user:%1$s
//    // user:id:%1$s
//    // user:access_token:%1$s
//    /**
//     * 根据telephone ,userType生成获取accessToken的键
//     * 
//     * @param telephone
//     * @return uk_${telephone}_${userType}
//     */
//    public static String atKey(String telephone, Integer userType) {
//        return String.format("uk_%1$s_%2$d", telephone, userType);
//    }
//
//    /**
//     * 根据accessToken生成获取userId的键
//     * 
//     * @param accessToken
//     * @return at_${accessToken}
//     */
//    public static String userIdKey(String accessToken) {
//        return String.format("at_%1$s", accessToken);
//    }
//
//    /**
//     * 根据userId生成获取用户数据的键
//     * 
//     * @param userId
//     *            用户Id
//     * @return
//     */
//    public static String userKey(Integer userId) {
//        return String.format("u_%1$s", userId);
//    }
//
//    public static String getCacheKey(String cacheKeyPre, String token) {
//        return String.format("%1$s:%2$s", cacheKeyPre, token);
//    }
//
//    /**
//     * 描述: 获取
//     * 参数: @param cacheKeyPre
//     * 参数: @return
//     * 返回值类型: String
//     * 作者: 扫地僧 
//     * 日期: 2017-4-2 下午2:41:58
//     */
//    public static String getCacheKey(String cacheKeyPre) {
//        return getCacheKey(cacheKeyPre, ReqUtil.getRequest().getParameter("access_token"));
//    }
//    
//
//    public static String getSMSRandCodeKey(String id) {
//        return String.format(SMSRandCodePrefix, id);
//    }
//    
//    /**
//     * 根据user_id生成获取userId的键
//     * @param userId
//     * @return user_id_${userId}
//     */
//    public static String userIdKey(Integer userId) {
//        return String.format("user:%1$s", userId);
//    }
//    
//    public static void main(String[] args) {
//		System.out.println(userIdKey(999999999));
//	}
//    
//    /**
//     * 根据type生成获取lock的键
//     * @param type
//     * @param pk
//     * @return lock:{type}:{pk}
//     */
//    public static String buildLockKey(LockType type,String pk) {
//        return String.format(LockPrefix, type.name(),pk);
//    }
//}
