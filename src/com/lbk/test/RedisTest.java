package com.lbk.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.lbk.bean.WbArticle;
import com.lbk.redis.Redis;
import com.lbk.redis.RedisPool;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/** 
  * @author  LTC 
  * @date 创建时间：2017年12月10日 下午7:19:34 
  * @version 1.0 
  * @parameter  
  * @since  
  * @return  
  */
public class RedisTest {
	/*private static RedisPool redisPool = new RedisPool();
	private static Jedis jedis;
    private static JedisPool pool;*/
	
	private static Redis redisDao = new Redis();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*pool = redisPool.getJedisPool();
		jedis = pool.getResource();
		Map<String, String> map = new HashMap<String, String>();
        map.put("name", "xinxin");
        map.put("age", "22");
        map.put("qq", "123456");
        jedis.hmset("user", map);
        // 取出user中的name，执行结果:[minxr]-->注意结果是一个泛型的List
        // 第一个参数是存入redis中map对象的key，后面跟的是放入map中的对象的key，后面的key可以跟多个，是可变参数
        List<String> rsmap = jedis.hmget("user", "name", "age", "qq");
        System.out.println(rsmap.get(0));*/
		
		redisDao.setArticleRedis();
		try {
			WbArticle wbArticle = redisDao.getArticleRedis(1572217);
			System.out.println(wbArticle.getC_authorid()+"  "+wbArticle.getC_content());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
