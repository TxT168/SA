package com.lbk.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import com.lbk.bean.WbAccount;
import com.lbk.bean.WbArticle;
import com.lbk.util.Datalink;

/** 
  * @author  LTC 
  * @date 创建时间：2017年12月20日 下午8:02:31 
  * @version 1.0 
  * @parameter  
  * @since  
  * @return  
  */
public class WbsubscribeDao {
	private Datalink datalink = new Datalink();
	private Connection conn;
	
	/**
	 * 返回好友列表
	 * @param masterid
	 * @return
	 */
	public Vector<WbAccount> getFollowByMaster(int followerid){
		Vector<WbAccount> vector = new Vector<WbAccount>();
		try {
			conn = datalink.getConnection();
			String sql = "select s_master_id from wb_subscribe where s_follower_id = ?";
			String sql1 = "select * from wb_account where a_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			PreparedStatement ps1 = conn.prepareStatement(sql1);
			ps.setInt(1, followerid);
			ResultSet rs = ps.executeQuery();
			WbAccount wbAccount = new WbAccount();
			while(rs.next()) {
				ps1.setInt(1,rs.getInt(1));
				ResultSet rs1 = ps1.executeQuery();
				while(rs1.next()) {
					wbAccount = new WbAccount();
					wbAccount.setA_id(rs1.getInt(1));
					wbAccount.setA_name(rs1.getString(2));;
					wbAccount.setA_password(rs1.getString(3));
					wbAccount.setA_age(rs1.getInt(4));
					wbAccount.setA_desc(rs1.getString(5));
					wbAccount.setA_accessnum(rs1.getInt(6));
					vector.add(wbAccount);
				}
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
	
	/**
	 * 关注一个用户
	 * @param s_follower_id
	 * @param s_master_id
	 */
	public void addFollower(int s_follower_id,int s_master_id) {
		try {
			conn = datalink.getConnection();
			String sql = "insert into wb_subscribe(s_master_id,s_follower_id) values(?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, s_master_id);
			ps.setInt(2, s_follower_id);
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
