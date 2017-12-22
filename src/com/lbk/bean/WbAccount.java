package com.lbk.bean;

public class WbAccount {
	private int a_id;
	private String a_name;
	private String a_password;
	private int a_age;
	private String a_desc;
	private int a_accessnum;
	
	public WbAccount() {
		
	}
	
	public WbAccount(String a_name,String a_password) {
		this.a_name = a_name;
		this.a_password = a_password;
	}
	public WbAccount(int a_id,String a_name,String a_password) {
		this.a_id = a_id;
		this.a_name = a_name;
		this.a_password = a_password;
	}
	
	public int getA_accessnum() {
		return a_accessnum;
	}
	public void setA_accessnum(int a_accessnum) {
		this.a_accessnum = a_accessnum;
	}
	public String getA_password() {
		return a_password;
	}
	public void setA_password(String a_password) {
		this.a_password = a_password;
	}
	public int getA_id() {
		return a_id;
	}
	public void setA_id(int a_id) {
		this.a_id = a_id;
	}
	public String getA_name() {
		return a_name;
	}
	public void setA_name(String a_name) {
		this.a_name = a_name;
	}
	public int getA_age() {
		return a_age;
	}
	public void setA_age(int a_age) {
		this.a_age = a_age;
	}
	public String getA_desc() {
		return a_desc;
	}
	public void setA_desc(String a_desc) {
		this.a_desc = a_desc;
	}
	
}
