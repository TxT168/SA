package com.lbk.servlet;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lbk.bean.WbAccount;
import com.lbk.bean.WbArticle;
import com.lbk.service.WbaccountService;
import com.lbk.service.WbaccountServiceImp;
import com.lbk.service.WbarticleService;
import com.lbk.service.WbarticleServiceImp;

/** 
  * @author  LTC 
  * @date 创建时间：2017年12月20日 下午9:09:03 
  * @version 1.0 
  * @parameter  
  * @since  
  * @return  
  */
public class LoginAction {
	
	private WbaccountService wbaccountService = new WbaccountServiceImp();//用户事务对象
	private WbarticleService wbarticleService = new WbarticleServiceImp();//微博事务对象
	
	
	/*
	 * 登录了一个新的用户
	 */
	public void login(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("hahahha");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		System.out.println(password);
		WbAccount wbAccount = wbaccountService.getWbaccountByNameandpas(username,password);
		System.out.println(wbAccount.getA_name());
		if(wbAccount.getA_name().equals(username)) {
			System.out.println(111);
			try {
				Vector<WbArticle> vector = wbarticleService.readRecentWbarticle();
				request.setAttribute("lastestWbArticle", vector);
				int id = wbAccount.getA_id();
				
				request.setAttribute("id", id);
				request.getRequestDispatcher("/home.jsp").forward(request, response);
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else {
			System.out.println(111);
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
