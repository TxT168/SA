package com.lbk.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Vector;

import com.lbk.bean.WbArticle;
import com.lbk.util.Datalink;

public class WbarticleDao {
	
	private Datalink datalink = new Datalink();
	private Connection conn;
	
	public WbArticle read(int c_id) {
		try{
			conn = datalink.getConnection();
			conn.setAutoCommit(false); 
			String sql = "select * from wb_article where c_id = ?";//read weibo
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, c_id);
			
			ResultSet rs = ps.executeQuery();//read
			WbArticle wbArticle = new WbArticle();
			while(rs.next()) {
				wbArticle.setC_id(rs.getInt(1));
				wbArticle.setC_authorid(rs.getInt(2));;
				wbArticle.setC_content(rs.getString(3));
				wbArticle.setC_date(rs.getTimestamp(4));
				wbArticle.setC_browsertime(rs.getInt(5));
			}
			conn.commit();
			ps.close();
			conn.close();
			return wbArticle;
		}catch(Exception e){
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
			return null;
		}
	}
	
	public int add(WbArticle wb_article) {
		try {
			conn = datalink.getConnection();
			conn.setAutoCommit(false); 
			String sql = "insert into wb_article(c_authorid,c_content,c_date,c_browsertime) values(?,?,?,?)";
			String sql1 = "select max(c_id) from wb_article";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, wb_article.getC_authorid());
			ps.setString(2, wb_article.getC_content());
			Timestamp c_date = new Timestamp(System.currentTimeMillis());
			ps.setTimestamp(3, c_date);
			ps.setInt(4, 0);
			ps.executeUpdate();
			PreparedStatement ps1 = conn.prepareStatement(sql1);
			ResultSet rs = ps1.executeQuery();
			if(rs.next()) {
				int c_id = rs.getInt(1);
				conn.commit();
				ps.close();
				ps1.close();
				conn.close();
				return c_id;
			}
			
		}catch(Exception e){
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		return -1;
	}
	public void delete(int c_id) {
		try {
			conn = datalink.getConnection();
			conn.setAutoCommit(false); 
			String sql = "delete from wb_article where c_id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, c_id);
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
	public void update(WbArticle wb_article) {
		int c_id = wb_article.getC_id();
		String c_content = wb_article.getC_content();
		try {
			conn = datalink.getConnection();
			conn.setAutoCommit(false); 
			String sql = "update wb_article set c_content = ? where c_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, c_content);
			ps.setInt(2, c_id);
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
	
	public Vector<WbArticle> getWbArticleVector() {
		Vector<WbArticle> vector = new Vector<WbArticle>();
		try {
			conn = datalink.getConnection(); 
			String sql = "select * from wb_article join (SELECT a_id FROM wb_account order by wb_account.a_accessnum desc limit 0,100) as topuserid "
	    			+ "on wb_article.c_authorid = topuserid.a_id order by c_date desc limit 0,100";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();//read
			WbArticle wbArticle = new WbArticle();
			while(rs.next()) {
				wbArticle = new WbArticle();
				wbArticle.setC_id(rs.getInt(1));
				wbArticle.setC_authorid(rs.getInt(2));;
				wbArticle.setC_content(rs.getString(3));
				wbArticle.setC_date(rs.getTimestamp(4));
				wbArticle.setC_browsertime(rs.getInt(5));
				vector.add(wbArticle);
			}
			ps.close();
			conn.close();
			return vector;
		}catch(Exception e){
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
			return null;
		}
	}
}
