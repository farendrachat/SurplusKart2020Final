package com.surplus.task.dto;

import com.surplus.task.domain.User;
import com.surplus.task.domain.UserDtls;

import lombok.Data;


@Data
public class UserResponse {
	
	private String status;	
	private String message;	
	private User user;
	private UserDtls userDtls;
	

}
