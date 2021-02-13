package com.surplus.task.domain;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.Data;

@javax.persistence.Entity
@Data
public class UserDtls {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	protected int userDtlId;
	protected String userName;
	protected String fullName;
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
