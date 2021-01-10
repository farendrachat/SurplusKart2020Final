package com.surplus.task.dto;

import java.util.List;

import com.surplus.task.domain.User;

import lombok.Data;

@Data
public class UsersResponse {
	
	private String status;	
	private String message;	
	List<User> users;
	

}
