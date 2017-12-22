package com.lbk.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.lbk.bean.WbAccount;
import com.lbk.util.Datalink;

/** 
  * @author  LTC 
  * @date 创建时间：2017年12月19日 下午9:29:02 
  * @version 1.0 
  * @parameter  
  * @since  
  * @return  
  */
public class WbaccountDao {
	private Datalink datalink = new Datalink();
	private Connection conn;
	
	/**
	 * 增加微博用户
	 */
	public void add(WbAccount wbAccount) {
		try {
			conn = datalink.getConnection();
			String sql = "insert into wb_account(a_name,a_password) values(?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, wbAccount.getA_name());
			ps.setString(2, wbAccount.getA_password());
			ps.executeUpdate();
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
	
	/**
	 * 删除微博用户
	 */
	public void delete(int a_id) {
		try {
			conn = datalink.getConnection();
			conn.setAutoCommit(false); 
			String sql = "delete from wb_account where a_id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, a_id);
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
	
	/**
	 * 根据id获取微博用户
	 */
	public WbAccount getWbaccountById(int a_id) {
		try{
			conn = datalink.getConnection();
			conn.setAutoCommit(false); 
			String sql = "select * from wb_account where a_id = ?";//read weibo
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, a_id);
			
			ResultSet rs = ps.executeQuery();//read
			WbAccount wbAccount = new WbAccount();
			while(rs.next()) {
				wbAccount.setA_id(rs.getInt(1));
				wbAccount.setA_name(rs.getString(2));;
				wbAccount.setA_password(rs.getString(3));
				wbAccount.setA_age(rs.getInt(4));
				wbAccount.setA_desc(rs.getString(5));
				wbAccount.setA_accessnum(rs.getInt(6));
			}
			conn.commit();
			ps.close();
			conn.close();
			return wbAccount;
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
	 * 根据用户名判断微博用户的唯一性
	 */
	public boolean getWbaccountByName(String a_name) {
		try{
			conn = datalink.getConnection();
			conn.setAutoCommit(false); 
			String sql = "select * from wb_account where a_name = ?";//read weibo
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, a_name);
			ResultSet rs = ps.executeQuery();//read
			conn.commit();
			if(rs.next()) {
				ps.close();
				conn.close();
				return true; 
			}
			else  {
				ps.close();
				conn.close();
				return false; 
			}
		}catch(Exception e){
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
			return false;
		}
	}
	
	/**
	 * 根据用户名和密码获取微博用户
	 */
	public WbAccount getWbaccountByNameandpas(String a_name,String a_password) {
		try{
			
			conn = datalink.getConnection();
			System.out.println("nihao");
			String sql = "select * from wb_account where a_name = ? and a_password = ?";//read weibo
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, a_name);
			ps.setString(2, a_password);
			ResultSet rs = ps.executeQuery();//read
			WbAccount wbAccount = new WbAccount();
			if(rs.next()) {
				System.out.println("zheli");
				wbAccount = new WbAccount(rs.getInt(1),rs.getString(2),rs.getString(3));
				ps.close();
				conn.close();
				return wbAccount;
			}
			else  {
				System.out.println("nali");
				ps.close();
				conn.close();
				return wbAccount; 
			}
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
