package com.lbk.service;

import com.lbk.bean.WbAccount;

/** 
  * @author  LTC 
  * @date 创建时间：2017年12月19日 下午10:05:21 
  * @version 1.0 
  * @parameter  
  * @since  
  * @return  
  */
public interface WbaccountService {
	public WbAccount getWbaccountById(int a_id);// 读取微博对象
	public boolean getWbaccountByName(String username);//判读微博用户名的唯一性
	public WbAccount getWbaccountByNameandpas(String username,String password);
	public void addWbaccount(WbAccount wbAccount);//增加微博对象
	public void deleteWbaccount(int a_id);//删除微博对象
}
