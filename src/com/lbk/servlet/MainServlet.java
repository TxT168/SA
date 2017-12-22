package com.lbk.servlet;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lbk.util.XMLMapping;

/**
 * Servlet implementation class MainServlet
 */
@WebServlet("/MainServlet")
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private XMLMapping xmlMapping;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MainServlet() {
        xmlMapping = new XMLMapping();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub、
		// 设置编码为UTF-8
		request.setCharacterEncoding("UTF-8");
		// 获取方法名字
        String servletPath = request.getServletPath();// /xxxxxx.do
        // 去掉斜杠和.do
        String methodName = servletPath.substring(1, servletPath.length() - 3);// xxxxxx
        
        try {
            // 利用反射获取方法
        	System.out.println(methodName);
            Method method = xmlMapping.getMethod(methodName);
            System.out.println(method.getName());
            // 执行相应的方法
            method.invoke(method.getDeclaringClass().newInstance(), request, response);
        } catch (Exception e) {
            // TODO: handle exception
        }
	}
	
	/*
	 * 注册一个新的微博用户
	 
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
	
	
	 * 登录了一个新的用户
	 
	public void login(HttpServletRequest request, HttpServletResponse response) {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		WbAccount wbAccount = wbaccountService.getWbaccountByNameandpas(username,password);
		System.out.println(wbAccount.getA_name());
		if(wbAccount.getA_name().equals(username)) {
			System.out.println(111);
			try {
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
	
	*//**
	 * 获取最火前100名用户的最新100条微博
	 * @param request
	 * @param response
	 *//*
	public void lastestWbArticle(HttpServletRequest request, HttpServletResponse response) {
		Vector<WbArticle> vector = wbarticleService.readRecentWbarticle();
		request.setAttribute("lastestWbArticle", vector);
	}
	
	*//**
	 * 发布微博
	 * @param request
	 * @param response
	 *//*
	public void pubWeibo(HttpServletRequest request, HttpServletResponse response) {
		String head = request.getParameter("head");
		String head2 = request.getParameter("head");
		String head3 = request.getParameter("head");
		WbArticle wbArticle = new WbArticle("""""");
		wbObserable.notifyUpdate(wbArticle, Modifyenum.add);
	}
	
	*//**
	 * 读取微博
	 * @param request
	 * @param response
	 *//*
	public void viewWeibo(HttpServletRequest request, HttpServletResponse response) {
		int c_id = Integer.valueOf(request.getParameter("cid"));
		WbArticle wbArticle = new WbArticle();
		wbArticle.setC_id(c_id);
		wbArticle = wbObserable.notifyUpdate(wbArticle, Modifyenum.read);
	}
	
	*//**
	 * 删除微博
	 * @param request
	 * @param response
	 *//*
	public void delWeibo(HttpServletRequest request, HttpServletResponse response) {
		int c_id = Integer.valueOf(request.getParameter("cid"));
		WbArticle wbArticle = new WbArticle();
		wbArticle.setC_id(c_id);
		try {
			wbObserable.notifyUpdate(wbArticle, Modifyenum.delete);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	*//**
	 * 回复微博
	 * @param request
	 * @param response
	 *//*
	public void repWeibo(HttpServletRequest request, HttpServletResponse response) {
		
	}*/
	
}
