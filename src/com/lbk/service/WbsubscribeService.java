package com.lbk.service;

import java.util.Vector;

import com.lbk.bean.WbAccount;

/** 
  * @author  LTC 
  * @date 创建时间：2017年12月20日 下午8:42:39 
  * @version 1.0 
  * @parameter  
  * @since  
  * @return  
  */
public interface WbsubscribeService {
	public Vector<WbAccount> getFollowByMaster(int followerid); //显示好友列表
	public void addFollower(int s_follower_id,int s_master_id); //关注一名用户
}
