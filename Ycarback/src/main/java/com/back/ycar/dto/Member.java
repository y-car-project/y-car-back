package com.back.ycar.dto;

import java.util.Date;

public class Member {
	
	private String user_id, user_name, user_email, user_pwd, user_phone;

	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getUser_email() {
		return user_email;
	}
	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}
	public String getUser_pwd() {
		return user_pwd;
	}
	public void setUser_pwd(String user_pwd) {
		this.user_pwd = user_pwd;
	}
	public String getUser_phone() {
		return user_phone;
	}
	public void setUser_phone(String user_phone) {
		this.user_phone = user_phone;
	}
	public Member() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Member(String user_id, String user_name, String user_email, String user_pwd, String user_phone) {
		super();
		this.user_id = user_id;
		this.user_name = user_name;
		this.user_email = user_email;
		this.user_pwd = user_pwd;
		this.user_phone = user_phone;
	}
	@Override
	public String toString() {
		return "Member [user_id=" + user_id + ", user_name=" + user_name + ", user_email=" + user_email + ", user_pwd="
				+ user_pwd + ", user_phone=" + user_phone + "]";
	}
	
	

}
