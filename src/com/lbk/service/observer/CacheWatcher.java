package com.lbk.service.observer;

import com.lbk.bean.WbArticle;

/** 
  * @author  LTC 
  * @date 创建时间：2017年12月11日 下午5:04:13 
  * @version 1.0 
  * @parameter  
  * @since  
  * @return  
  */
public interface CacheWatcher {
	public void updateWbCache();//更新缓存
	public WbArticle readWbCache(int c_id) throws Exception ;//读取缓存
}
