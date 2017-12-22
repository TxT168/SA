package com.lbk.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lbk.bean.WbAccount;
import com.lbk.service.WbaccountService;
import com.lbk.service.WbaccountServiceImp;


/** 
  * @author  LTC 
  * @date 创建时间：2017年12月20日 下午9:15:25 
  * @version 1.0 
  * @parameter  
  * @since  
  * @return  
  */
public class RegisterAction {
	private WbaccountService wbaccountService = new WbaccountServiceImp();//用户事务对象
	
	/*
	 * 注册一个新的微博用户
	 */
	public void register(HttpServletRequest request, HttpServletResponse response) {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		if(wbaccountService.getWbaccountByName(username)) {
			try {
				request.getRequestDispatcher("/register.jsp").forward(request, response);
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else {
			WbAccount wbAccount = new WbAccount(username,password);
			wbaccountService.addWbaccount(wbAccount);
			try {
				request.getRequestDispatcher("/login.jsp").forward(request, response);
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}
