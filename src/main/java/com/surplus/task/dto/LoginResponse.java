package com.surplus.task.dto;

import java.util.Date;

import lombok.Data;

@Data

public class LoginResponse {
	
	private String userName;
	
	private String status;
	
	private String role;
	
	private Date loginTime;
	
	private String message;
	
	private String code;
	
	private Integer userId;

	



}
