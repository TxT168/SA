package com.lbk.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.lbk.util.Datalink;

/** 
  * @author  LTC 
  * @date 创建时间：2017年12月11日 下午3:32:13 
  * @version 1.0 
  * @parameter  
  * @since  
  * @return  
  */
public class InsertAccountData {

	private static Datalink datalink = new Datalink();
	private static Connection conn;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			//建立连接
			conn = datalink.getConnection();
			//插入数据
			//预处理语句
			String prefix = "insert into wb_account(a_id,a_name,a_age,a_desc,a_accessnum) values ";
			//设置事务为非自动提交
			conn.setAutoCommit(false);
			PreparedStatement ps = conn.prepareStatement("");
			//保存SQL后缀
			StringBuffer suffix = new StringBuffer();
			String name="";
			int age=0;
			String desc="";
			int n=101;
			for(int i=0;i<100;i++){
				suffix = new StringBuffer();
				for(int j=0;j<10;j++){
					String chars = "abcdefghijklmnopqrstuvwxyz";
					age = 0;
					name = "";
					desc = "";
					for(int k=0;k<3;k++){
						name = name+chars.charAt((int)(Math.random() * 26));
						desc = desc+chars.charAt((int)(Math.random() * 26));
					}
					age = (int)(Math.random() * 100);
					suffix.append("("+n+",'"+name+"',"+age+",'"+desc+"',"+0+"),");
					n++;
				}
				//构建完整的SQL语句
				String sql = prefix+suffix.substring(0, suffix.length()-1);
				//添加执行SQL
				ps.addBatch(sql);
				//执行操作
				ps.executeBatch();
				//提交事务
				conn.commit();
				//清空上一次添加的数据
				suffix = new StringBuffer();
			}
			ps.close();
			conn.close();
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
