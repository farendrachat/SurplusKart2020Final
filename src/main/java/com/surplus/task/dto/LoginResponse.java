package com.surplus.task.dto;

import java.util.Date;

public class LoginResponse {
	
	private String username;
	
	private String status;
	
	private String role;
	
	private Date loginTime;
	
	private String message;
	
	private String code;
	
	private Integer userId;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public String getRole() {
		return role;
	}


	public void setRole(String role) {
		this.role = role;
	}


	public Date getLoginTime() {
		return loginTime;
	}


	public void setLoginTime(Date loginTime) {
		this.loginTime = loginTime;
	}


	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}


	public String getCode() {
		return code;
	}


	public void setCode(String code) {
		this.code = code;
	}


	@Override
	public String toString() {
		return "LoginResponse [username=" + username + ", status=" + status + ", role=" + role + ", loginTime="
				+ loginTime + ", message=" + message + ", code=" + code + "]";
	}



}
