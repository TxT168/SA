package com.lbk.bean;

import java.sql.Timestamp;

public class WbLog {
	private int l_id;
	private int l_article_id;
	private String l_opt;
	private Timestamp l_time;
	public int getL_id() {
		return l_id;
	}
	public void setL_id(int l_id) {
		this.l_id = l_id;
	}
	public int getL_article_id() {
		return l_article_id;
	}
	public void setL_article_id(int l_article_id) {
		this.l_article_id = l_article_id;
	}
	public String getL_opt() {
		return l_opt;
	}
	public void setL_opt(String l_opt) {
		this.l_opt = l_opt;
	}
	public Timestamp getL_time() {
		return l_time;
	}
	public void setL_time(Timestamp l_time) {
		this.l_time = l_time;
	}
}
