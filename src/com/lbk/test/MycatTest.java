package com.lbk.test;

import java.sql.Connection;
import java.sql.Statement;

import com.lbk.util.Datalink;

/** 
  * @author  LTC 
  * @date 创建时间：2017年12月10日 下午1:53:16 
  * @version 1.0 
  * @parameter  
  * @since  
  * @return  
  */
public class MycatTest {
	private static Datalink datalink = new Datalink();
	public static void main(String[] args) throws Exception {
		Connection conn = datalink.getConnection();
		Statement st = conn.createStatement();
		String sql = "insert into item(id,value,indate) values(0,555,now())";
		st.executeUpdate(sql);
	}
}
