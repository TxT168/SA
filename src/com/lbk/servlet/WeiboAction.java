package com.lbk.servlet;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lbk.bean.WbAccount;
import com.lbk.bean.WbArticle;
import com.lbk.service.WbaccountService;
import com.lbk.service.WbaccountServiceImp;
import com.lbk.service.WbarticleService;
import com.lbk.service.WbarticleServiceImp;
import com.lbk.service.observable.Modifyenum;
import com.lbk.service.observable.WbObservable;
import com.lbk.service.observable.WbObservableImp;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;


/** 
  * @author  LTC 
  * @date 创建时间：2017年12月20日 下午9:17:14 
  * @version 1.0 
  * @parameter  
  * @since  
  * @return  
  */
public class WeiboAction {
	
	private WbaccountService wbaccountService = new WbaccountServiceImp();//用户事务对象
	private WbarticleService wbarticleService = new WbarticleServiceImp();//微博事务对象
	private WbObservable wbObserable = new WbObservableImp();
	
	/**
	 * 获取最火前100名用户的最新100条微博
	 * @param request
	 * @param response
	 */
	public void lastestWbArticle(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Vector<WbArticle> vector = wbarticleService.readRecentWbarticle();
		List<JSONObject> jsonObjects = new ArrayList<JSONObject>();//通过一个list来进行json数据的嵌套传输
		for (int i = 0; i < vector.size(); i++) {
			WbArticle wbArticle = (WbArticle)vector.get(i);
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("id", wbArticle.getC_id());
			jsonObject.put("authorid", wbArticle.getC_authorid());
			jsonObject.put("content", wbArticle.getC_content());
			String date = wbArticle.getC_date().toString();
			jsonObject.put("date", date);
			jsonObject.put("browsertime", wbArticle.getC_browsertime());
			jsonObjects.add(jsonObject);
		}
		JSONArray json = JSONArray.fromObject(jsonObjects);
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(json.toString());
		//System.out.println("到这"+vector.size());
		//request.setAttribute("lastestWbArticle", vector);
	}
	
	/**
	 * 发布微博
	 * @param request
	 * @param response
	 */
	public void pubWeibo(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int id = Integer.valueOf(request.getParameter("id"));
		//System.out.println("daodao"+id);
		String content = request.getParameter("content");
		WbArticle wbArticle = new WbArticle();
		wbArticle.setC_authorid(id);
		wbArticle.setC_content(content);
		wbObserable.notifyUpdate(wbArticle, Modifyenum.add);
		//System.out.println("pubweibo!");
		request.setAttribute("id", id);
		request.getRequestDispatcher("/home.jsp").forward(request, response);
		
		
//		Vector<WbArticle> vector = wbarticleService.readRecentWbarticle();
//		request.setAttribute("lastestWbArticle", vector);
//		request.setAttribute("id", id);
//		request.getRequestDispatcher("/home.jsp").forward(request, response);
		//response.sendRedirect("/home.jsp?id="+request.getParameter("id"));
	}
	
	/**
	 * 读取微博
	 * @param request
	 * @param response
	 */
	public void viewWeibo(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int c_id = Integer.valueOf(request.getParameter("pid"));
		System.out.println(c_id+"nihaoma");
		WbArticle wbArticle = new WbArticle();
		wbArticle.setC_id(c_id);
		wbArticle = wbObserable.notifyUpdate(wbArticle, Modifyenum.read);
		int a_id = wbArticle.getC_authorid();
		WbAccount wbAccount = wbaccountService.getWbaccountById(a_id);
		String name = wbAccount.getA_name();
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("name", name);
		jsonObject.put("date", wbArticle.getC_date().toString());
		jsonObject.put("content", wbArticle.getC_content());
		JSONArray json = JSONArray.fromObject(jsonObject);
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(json.toString());
	}
	
	/**
	 * 删除微博
	 * @param request
	 * @param response
	 */
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
	
	/**
	 * 回复微博
	 * @param request
	 * @param response
	 */
	public void repWeibo(HttpServletRequest request, HttpServletResponse response) {
		
	}
}
