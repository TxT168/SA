package com.lbk.redis;

import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/** 
  * @author  LTC 
  * @date 创建时间：2017年12月10日 下午4:53:30 
  * @version 1.0 
  * @parameter  
  * @since  
  * @return  
  */
public class RedisPool {
	public JedisPool getJedisPool(){
		JedisPoolConfig config=new JedisPoolConfig(); // 连接池的配置对象
		config.setMaxTotal(100); // 设置最大连接数
		config.setMaxIdle(10); // 设置最大空闲连接数
		JedisPool jedisPool=new JedisPool(config,"127.0.0.1",6379);
		return jedisPool;
	}
}
