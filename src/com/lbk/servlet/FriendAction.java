package com.lbk.servlet;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lbk.bean.WbAccount;
import com.lbk.bean.WbSubscribe;
import com.lbk.service.WbsubscribeService;
import com.lbk.service.WbsubscribeServiceImp;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/** 
  * @author  LTC 
  * @date 创建时间：2017年12月21日 下午10:53:52 
  * @version 1.0 
  * @parameter  
  * @since  
  * @return  
  */
public class FriendAction {
	private WbsubscribeService wbsubscribeService = new WbsubscribeServiceImp();
	
	public void getFriendVector(HttpServletRequest request, HttpServletResponse response) throws Exception{
		int s_follower_id = Integer.valueOf(request.getParameter("id"));
		Vector<WbAccount> vector = wbsubscribeService.getFollowByMaster(s_follower_id);
		List<JSONObject> jsonObjects = new ArrayList<JSONObject>();//通过一个list来进行json数据的嵌套传输
		for (int i = 0; i < vector.size(); i++) {
			WbAccount wbAccount = (WbAccount)vector.get(i);
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("name", wbAccount.getA_name());
			jsonObjects.add(jsonObject);
		}
		JSONArray json = JSONArray.fromObject(jsonObjects);
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(json.toString());
	}
}
