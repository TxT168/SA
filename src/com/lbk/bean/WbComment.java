package com.lbk.bean;

import java.sql.Timestamp;

/** 
  * @author  LTC 
  * @date 创建时间：2017年12月20日 下午9:29:38 
  * @version 1.0 
  * @parameter  
  * @since  
  * @return  
  */
public class WbComment {
	private int r_id;
	private int r_article_id;
	private int r_account_id;
	private String r_comment;
	private Timestamp r_date;
	
	public int getR_id() {
		return r_id;
	}
	public void setR_id(int r_id) {
		this.r_id = r_id;
	}
	public int getR_article_id() {
		return r_article_id;
	}
	public void setR_article_id(int r_article_id) {
		this.r_article_id = r_article_id;
	}
	public int getR_account_id() {
		return r_account_id;
	}
	public void setR_account_id(int r_account_id) {
		this.r_account_id = r_account_id;
	}
	public String getR_comment() {
		return r_comment;
	}
	public void setR_comment(String r_comment) {
		this.r_comment = r_comment;
	}
	public Timestamp getR_date() {
		return r_date;
	}
	public void setR_date(Timestamp r_date) {
		this.r_date = r_date;
	}
	
}
