package com.surplus.task.dto;

import java.util.List;

import com.surplus.task.domain.User;



public class UserResponse {
	
	private String status;
	
	private String message;
	
	private User user;
	

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "UserResponse [status=" + status + ", message=" + message + ", user=" + user + "]";
	}



}
