package com.lbk.service;

import com.lbk.bean.WbAccount;
import com.lbk.dao.WbaccountDao;

/** 
  * @author  LTC 
  * @date 创建时间：2017年12月19日 下午10:08:16 
  * @version 1.0 
  * @parameter  
  * @since  
  * @return  
  */
public class WbaccountServiceImp implements WbaccountService {
	
	private WbaccountDao wbaccountDao = new WbaccountDao();

	@Override
	public WbAccount getWbaccountById(int a_id) {
		// TODO Auto-generated method stub
		return wbaccountDao.getWbaccountById(a_id);
	}

	@Override
	public void addWbaccount(WbAccount wbAccount) {
		// TODO Auto-generated method stub
		wbaccountDao.add(wbAccount);
	}

	@Override
	public void deleteWbaccount(int a_id) {
		// TODO Auto-generated method stub
		wbaccountDao.delete(a_id);
	}

	@Override
	public boolean getWbaccountByName(String username) {
		// TODO Auto-generated method stub
		return wbaccountDao.getWbaccountByName(username);
	}

	@Override
	public WbAccount getWbaccountByNameandpas(String username, String password) {
		// TODO Auto-generated method stub
		return wbaccountDao.getWbaccountByNameandpas(username, password);
	}

}
