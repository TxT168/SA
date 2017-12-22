package com.lbk.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.lbk.bean.WbArticle;
import com.lbk.util.Datalink;

public class NumberDao {
	
	private WbarticleDao wbarticleDao = new WbarticleDao();
	private Datalink datalink = new Datalink();
	private Connection conn;
	
	/*
	 * read the content of weibo
	 */
	public void updatebrowsertimes(int c_id) {
		try{
			System.out.println(c_id);
			conn = datalink.getConnection(); 
			PreparedStatement ps1;
			PreparedStatement ps2;
			String sql = "update wb_article set c_browsertime=c_browsertime+1 where c_id = ?";
			ps1 = conn.prepareStatement(sql);
			ps1.setInt(1, c_id);
			ps1.executeUpdate();
			WbArticle wbArticle = wbarticleDao.read(c_id);
			int a_id = wbArticle.getC_authorid();
			String sql1 = "update wb_account set a_accessnum=a_accessnum+1 where a_id=?";
			ps2 = conn.prepareStatement(sql1);
			ps2.setInt(1, a_id);
			ps2.executeUpdate();
			ps2.close();
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
