package com.lbk.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

import com.lbk.util.Datalink;

public class LogDao {
	
	private Datalink datalink = new Datalink();
	private Connection conn;
	
	public void addLog(int c_id, String operation) {
		try {
			conn = datalink.getConnection();
			conn.setAutoCommit(false); 
			String sql = "insert into wb_log(l_article_id,l_ope,l_time) values(?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, c_id);
			ps.setString(2, operation);
			Timestamp c_date = new Timestamp(System.currentTimeMillis());
			ps.setTimestamp(3, c_date);
			ps.executeUpdate();
			conn.commit();
			ps.close();
			conn.close();
		}catch(Exception e){
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
	}
}
