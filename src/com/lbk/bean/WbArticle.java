package com.lbk.bean;

import java.sql.Timestamp;

public class WbArticle {
	
	private int c_id;
	private int c_authorid;
	private String c_content;
	private Timestamp c_date;
	private int c_browsertime;
	
	public WbArticle(){
		
	}
	
	public WbArticle(int c_authorid, String c_content, Timestamp c_date, int c_browsertime) {
		this.c_authorid = c_authorid;
		this.c_content = c_content;
		this.c_date = c_date;
		this.c_browsertime = c_browsertime;
	}
	
	public int getC_id() {
		return c_id;
	}
	public void setC_id(int c_id) {
		this.c_id = c_id;
	}
	public int getC_authorid() {
		return c_authorid;
	}
	public void setC_authorid(int c_authorid) {
		this.c_authorid = c_authorid;
	}
	public String getC_content() {
		return c_content;
	}
	public void setC_content(String c_content) {
		this.c_content = c_content;
	}
	public Timestamp getC_date() {
		return c_date;
	}
	public void setC_date(Timestamp c_date) {
		this.c_date = c_date;
	}
	public int getC_browsertime() {
		return c_browsertime;
	}
	public void setC_browsertime(int c_browsertime) {
		this.c_browsertime = c_browsertime;
	}
	
}
