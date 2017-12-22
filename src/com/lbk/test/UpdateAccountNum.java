package com.lbk.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.lbk.util.Datalink;

/** 
  * @author  LTC 
  * @date 创建时间：2017年12月11日 下午4:18:45 
  * @version 1.0 
  * @parameter  
  * @since  
  * @return  
  */
public class UpdateAccountNum {

	private static Datalink datalink = new Datalink();
	private static Connection conn;
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			//建立连接
			conn = datalink.getConnection();
			String sql = "select sum(c_browsertime) from wb_article where c_authorid=?";
			String sql1 = "";
			PreparedStatement ps = conn.prepareStatement(sql);
			PreparedStatement ps1;
			int author_accessnum = 0;
			for(int i=0;i<=1100;i++){
				ps.setInt(1, i);
				ResultSet rs = ps.executeQuery();
				while(rs.next()){
					author_accessnum = rs.getInt(1);
					sql1 = "update wb_account set a_accessnum = ? where a_id = ?";
					ps1 = conn.prepareStatement(sql1);
					ps1.setInt(1, author_accessnum);
					ps1.setInt(2, i);
					ps1.executeUpdate();
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
	}

}
