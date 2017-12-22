package com.lbk.service.observable;

import com.lbk.bean.WbArticle;
import com.lbk.service.WbarticleServiceImp;
import com.lbk.service.observer.CacheWatcherImp;
import com.lbk.service.observer.LogWatcherImp;
import com.lbk.service.observer.NumberWatcherImp;

/** 
  * @author  LTC 
  * @date 创建时间：2017年12月10日 下午7:37:17 
  * @version 1.0 
  * @parameter  
  * @since  
  * @return  
  */
public class WbObservableImp implements WbObservable {

	private LogWatcherImp logWatcherImp = new LogWatcherImp();
	private WbarticleServiceImp wbarticleImp = new WbarticleServiceImp();
	private NumberWatcherImp numberWatchImp = new NumberWatcherImp();
	private CacheWatcherImp cacheWatcherImp = new CacheWatcherImp();

	@Override
	public WbArticle notifyUpdate(WbArticle wbArticle , Modifyenum modifyenum) throws Exception {
		// TODO Auto-generated method stub
		int c_id;
		switch(modifyenum){
		case add:
			c_id = wbarticleImp.addWbarticle(wbArticle);
			cacheWatcherImp.updateWbCache();
			logWatcherImp.addLog("add");
			return null;
		case delete:
			c_id = wbArticle.getC_id();
			wbarticleImp.deleteWbarticle(c_id);
			cacheWatcherImp.updateWbCache();
			logWatcherImp.addLog("delete");
			return null;
		case update:
			wbarticleImp.updateWbarticle(wbArticle);
			cacheWatcherImp.updateWbCache();
			logWatcherImp.addLog("update");
			return null;
		case read:
			cacheWatcherImp.updateWbCache();
			c_id = wbArticle.getC_id();
			WbArticle wbArticle2 = cacheWatcherImp.readWbCache(c_id);
			if(wbArticle2.getC_id()!=-1){
				numberWatchImp.updatebrowsertimes(c_id);
				System.out.println("从缓存中获取的微博");
				return wbArticle2;
			}
			else{
				wbArticle2 = wbarticleImp.readWbarticle(c_id);
				numberWatchImp.updatebrowsertimes(c_id);
				System.out.println("从原来的数据库获取的微博");
				return wbArticle2;
			}
		default:
			return null;
		}
	}

}
