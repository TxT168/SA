package com.lbk.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Vector;

import com.lbk.bean.WbComment;
import com.lbk.util.Datalink;

/** 
  * @author  LTC 
  * @date 创建时间：2017年12月20日 下午9:26:59 
  * @version 1.0 
  * @parameter  
  * @since  
  * @return  
  */
public class WbcommentDao {
	private Datalink datalink = new Datalink();
	private Connection conn;
	
	/**
	 * 读取一篇微博的多条评论
	 * @param articleid
	 * @return
	 */
	public Vector<WbComment> readWbCommentVector(int articleid){
		Vector<WbComment> vector = new Vector<WbComment>();
		try {
			conn = datalink.getConnection();
			String sql = "select * from wb_comment where r_article_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, articleid);
			ResultSet rs = ps.executeQuery();
			WbComment wbComment = new WbComment();
			while(rs.next()) {
				wbComment.setR_id(rs.getInt(1));
				wbComment.setR_article_id(rs.getInt(2));;
				wbComment.setR_account_id(rs.getInt(3));
				wbComment.setR_comment(rs.getString(4));
				wbComment.setR_date(rs.getTimestamp(5));
				vector.add(wbComment);
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
	
	public void addWbComment(int articleid, int accountid, String comment) {
		try {
			conn = datalink.getConnection();
			String sql = "insert into wb_comment(r_article_id,r_account_id,r_comment,c_date)"
					+ " values(?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, articleid);
			ps.setInt(2, accountid);
			ps.setString(3, comment);
			Timestamp c_date = new Timestamp(System.currentTimeMillis());
			ps.setTimestamp(4, c_date);
			ps.executeUpdate();
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
