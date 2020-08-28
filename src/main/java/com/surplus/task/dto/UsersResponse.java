package com.surplus.task.dto;

import java.util.List;

import com.surplus.task.domain.User;


public class UsersResponse {
	
	private String status;
	
	private String message;
	
	List<User> users;
	

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

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	@Override
	public String toString() {
		return "UsersResponse [status=" + status + ", message=" + message + ", users=" + users + "]";
	}


}
