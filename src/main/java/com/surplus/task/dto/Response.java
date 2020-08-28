package com.surplus.task.dto;

public class Response {
	
	private String status;
	
	private String message;

	private String username;
	
	
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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public String toString() {
		return "Response [status=" + status + ", message=" + message + ", username=" + username + "]";
	}

}
