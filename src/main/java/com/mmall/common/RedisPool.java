package com.mmall.common;

import com.mmall.util.PropertiesUtil;
import redis.clients.jedis.JedisPool;

public class RedisPool {
    private static JedisPool pool;//jedis连接池
    private static Integer maxTotal = Integer.parseInt(PropertiesUtil.getProperty("redis.max.total","20"));//最大连接数
    private static Integer maxIdle = //在jedispool中最大的idle状态（空闲的）的jedis实例的个数
    private static Integer minIdle = //在jedispool中最小的idle状态（空闲的）的jedis实例的个数
    private static Boolean testOnBorrow = //在borrow一个jedis实例的时候，是否要进行验证操作，如果赋值true, 则得到的jedis实例肯定是可以用的。
    private static Boolean testOnReturn = //在return一个jedis实例的时候，是否要进行验证操作，如果赋值true, 则放回jedispool的jedis实例肯定是可以用的。
}
