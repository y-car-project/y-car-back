package com.back.ycar.dto;

import java.util.Date;

public class Login {

	private String user_id, user_token;
	private Date user_loginTime;

	public Login(String user_id, String user_token, Date user_loginTime) {
		super();
		this.user_id = user_id;
		this.user_token = user_token;
		this.user_loginTime = user_loginTime;
	}

	public Login() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getUser_token() {
		return user_token;
	}

	public void setUser_token(String user_token) {
		this.user_token = user_token;
	}

	public Date getUser_loginTime() {
		return user_loginTime;
	}

	public void setUser_loginTime(Date user_loginTime) {
		this.user_loginTime = user_loginTime;
	}

	@Override
	public String toString() {
		return "Login [user_id=" + user_id + ", user_token=" + user_token + ", user_loginTime=" + user_loginTime + "]";
	}



}
