package com.lbk.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.lbk.util.Datalink;

/** 
  * @author  LTC 
  * @date 创建时间：2017年12月10日 下午10:14:32 
  * @version 1.0 
  * @parameter  
  * @since  
  * @return  
  */
public class InsertDataForMycat {

	private static Datalink datalink = new Datalink();
	private static Connection conn;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*try {
			//建立连接
			conn = datalink.getConnection();
			//插入数据
			//预处理语句
			String prefix = "insert into wb_article(c_id,c_authorid,c_content,c_date,c_browsertime) values ";
			//设置事务为非自动提交
			conn.setAutoCommit(false);
			PreparedStatement ps = conn.prepareStatement("");
			//保存SQL后缀
			StringBuffer suffix = new StringBuffer();
			int[] authorid={1,256,512};
			String content="";
			Timestamp date=null;
			int browsertime = 0;
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			int n=1;
			int m;
			int author_id;
			for(int i=0;i<300;i++){
				m = i%3;
				author_id = authorid[m];
				suffix = new StringBuffer();
				for(int j=0;j<5000;j++){
					String chars = "abcdefghijklmnopqrstuvwxyz";
					content = "";
					for(int k=0;k<3;k++){
						content = content+chars.charAt((int)(Math.random() * 26));
					}
					date = new Timestamp(System.currentTimeMillis());
					browsertime = (int)(Math.random() * 10);
					suffix.append("("+n+","+author_id+",'"+content+"','"+date+"',"+browsertime+"),");
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
		}*/
		
		try {
			//建立连接
			conn = datalink.getConnection();
			//插入数据
			//预处理语句
			String prefix = "insert into wb_article(c_id,c_authorid,c_content,c_date,c_browsertime) values ";
			//设置事务为非自动提交
			conn.setAutoCommit(false);
			PreparedStatement ps = conn.prepareStatement("");
			//保存SQL后缀
			StringBuffer suffix = new StringBuffer();
			String content="";
			Timestamp date = null;
			int browsertime = 0;
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			int n=1500001;
			int author_id;
			for(int i=0;i<100;i++){
				suffix = new StringBuffer();
				for(int j=0;j<1000;j++){
					String chars = "abcdefghijklmnopqrstuvwxyz";
					author_id = (int)(Math.random() * 1000);
					content = "";
					for(int k=0;k<3;k++){
						content = content+chars.charAt((int)(Math.random() * 26));
					}
					date = new Timestamp(System.currentTimeMillis());
					browsertime = (int)(Math.random() * 10);
					suffix.append("("+n+","+author_id+",'"+content+"','"+date+"',"+browsertime+"),");
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
