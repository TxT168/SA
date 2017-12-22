package com.lbk.service.observer;

import com.lbk.bean.WbArticle;
import com.lbk.redis.Redis;

/** 
  * @author  LTC 
  * @date 创建时间：2017年12月11日 下午5:07:18 
  * @version 1.0 
  * @parameter  
  * @since  
  * @return  
  */
public class CacheWatcherImp implements CacheWatcher {
	
	private Redis redisDao = new Redis();

	@Override
	public void updateWbCache() {
		// TODO Auto-generated method stub
		redisDao.setArticleRedis();
	}

	@Override
	public WbArticle readWbCache(int c_id) throws Exception {
		// TODO Auto-generated method stub
		return redisDao.getArticleRedis(c_id);
	}

}
