package com.surplus.task.dto;

import java.util.Date;

import com.surplus.task.utils.EnumUserRoles;

import lombok.Data;

@Data

public class LoginResponse {
	
	private String userName;
	
	private String status;
	
	private EnumUserRoles role;
	
	private Date loginTime;
	
	private String message;
	
	private String code;
	
	private Integer userId;

	



}
