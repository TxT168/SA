package com.lbk.service.observer;

import com.lbk.dao.NumberDao;

public class NumberWatcherImp implements NumberWatcher {
	
	private NumberDao numberDao = new NumberDao();
	
	@Override
	public void updatebrowsertimes(int c_id) throws Exception {
		// TODO Auto-generated method stub
		numberDao.updatebrowsertimes(c_id);
		System.out.println("更新了这条微博的阅读量！");
	}

}
