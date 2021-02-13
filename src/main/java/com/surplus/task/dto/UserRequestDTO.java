package com.surplus.task.dto;

import lombok.Data;

@Data

public class UserRequestDTO {

	protected String fullName;
	protected String password;
	protected String role;
	protected String userName;	
	protected String designation;
	protected String mobile;
	protected String primaryEmail;
	protected String company;
	protected String faxNo;
	protected String address;
	protected String city;
	protected String state;
	protected int pinCode;

}
