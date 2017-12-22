package com.lbk.redis;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Vector;

import com.lbk.bean.WbArticle;
import com.lbk.util.Datalink;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/** 
  * @author  LTC 
  * @date 创建时间：2017年12月10日 下午3:53:02 
  * @version 1.0 
  * @parameter  
  * @since  
  * @return  
  */
public class Redis {
	
	private Datalink datalink = new Datalink();
	private Connection conn;
	private RedisPool redisPool = new RedisPool();
	private JedisPool pool = redisPool.getJedisPool();
	private Jedis jedis = pool.getResource();
    
    /**
     * 将最热的100位用户的最新的100条微博存入缓存
     */
    public void setArticleRedis(){
    	jedis.flushAll();
    	String sql = "select * from wb_article join (SELECT a_id FROM wb_account order by wb_account.a_accessnum desc limit 0,100) as topuserid "
    			+ "on wb_article.c_authorid = topuserid.a_id order by c_date desc limit 0,100";
    	
    	try {
    		conn = datalink.getConnection();
    		PreparedStatement psm = conn.prepareStatement(sql);
    		ResultSet rs = psm.executeQuery();
    		System.out.println(rs);
        	while(rs.next()){
        		Map<String, String> map = new HashMap<String,String>();
        		map.put("c_authorid", String.valueOf(rs.getInt(2)));
        		map.put("c_content", rs.getString(3));
        		map.put("c_date", rs.getDate(4).toString());
        		map.put("c_browsertime", String.valueOf(rs.getInt(5)));
        		jedis.hmset(String.valueOf(rs.getInt(1)), map);
        	}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			if(jedis!=null){
				jedis.close();
            }
			if(pool!=null){
				pool.close();
			}
		}
    }
    
    /**
     * 从缓存中根据ID读取一篇微博
     * @param c_id
     * @return WbArticle
     * @throws Exception
     */
    public WbArticle getArticleRedis(int c_id) throws Exception{
    	String cid = String.valueOf(c_id);
    	List<String> rsmap = jedis.hmget(cid, "c_authorid","c_content","c_date","c_browsertime");
    	WbArticle wbArticle;
    	if(rsmap.get(0)!=null){
    		int c_authorid = Integer.valueOf(rsmap.get(0));
        	String c_content = rsmap.get(1);
        	//SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        	//Date c_date = sdf.parse(rsmap.get(2));
        	Timestamp c_date = Timestamp.valueOf(rsmap.get(2));
        	int c_browsertime = Integer.valueOf(rsmap.get(3));
        	
        	wbArticle = new WbArticle();
        	wbArticle.setC_authorid(c_authorid);
        	wbArticle.setC_content(c_content);
        	wbArticle.setC_date(c_date);
        	wbArticle.setC_browsertime(c_browsertime);
        	return wbArticle;
    	}
    	else{
    		wbArticle = new WbArticle();
    		wbArticle.setC_id(-1);
    		return wbArticle;
    	}
    }
    
    /**
     * 返回最火前100用户的100条最新微博
     * @return Vector<WbArticle>
     */
    public Vector<WbArticle> getArticleVector(){
    	Vector<WbArticle> vector = new Vector<WbArticle>();
    	Set s = jedis.keys("*");//获取所有的键值
    	Iterator it = s.iterator();
    	WbArticle wbArticle = new WbArticle();
    	while (it.hasNext()) {
			String key = (String) it.next();
			List<String> rsmap = jedis.hmget(key, "c_authorid","c_content","c_date","c_browsertime");
			
			int c_authorid = Integer.valueOf(rsmap.get(0));
        	String c_content = rsmap.get(1);
        	//SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        	//Date c_date = sdf.parse(rsmap.get(2));
        	Timestamp c_date = Timestamp.valueOf(rsmap.get(2));
        	int c_browsertime = Integer.valueOf(rsmap.get(3));
        	
        	int c_id = Integer.valueOf(key);
        	wbArticle.setC_id(c_id);
        	wbArticle.setC_authorid(c_authorid);
        	wbArticle.setC_content(c_content);
        	wbArticle.setC_date(c_date);
        	wbArticle.setC_browsertime(c_browsertime);
        	vector.add(wbArticle);
		}
    	return vector;
    }
}
