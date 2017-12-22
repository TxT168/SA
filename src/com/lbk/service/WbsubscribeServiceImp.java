package com.lbk.service;

import java.util.Vector;

import com.lbk.bean.WbAccount;
import com.lbk.dao.WbsubscribeDao;

/** 
  * @author  LTC 
  * @date 创建时间：2017年12月20日 下午8:45:50 
  * @version 1.0 
  * @parameter  
  * @since  
  * @return  
  */
public class WbsubscribeServiceImp implements WbsubscribeService {
	private WbsubscribeDao wbsubscribeDao = new WbsubscribeDao();
	
	@Override
	public Vector<WbAccount> getFollowByMaster(int masterid) {
		// TODO Auto-generated method stub
		return wbsubscribeDao.getFollowByMaster(masterid);
	}

	@Override
	public void addFollower(int s_follower_id, int s_master_id) {
		// TODO Auto-generated method stub
		wbsubscribeDao.addFollower(s_follower_id, s_master_id);
	}

}
