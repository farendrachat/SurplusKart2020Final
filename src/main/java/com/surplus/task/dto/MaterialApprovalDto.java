package com.surplus.task.dto;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Temporal;

import lombok.Data;

@Data
@Entity
public class MaterialApprovalDto {

	@Column(nullable = false)
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	protected int transId;
	
	@Column(nullable = false)
	protected String name;	
	protected String brand;	
	protected String qtyExpressed;	
	protected double packSize;

	/*
	 *  inserting and fetching BLOB data such as images requires two steps: 
	 *  a>define database column type as “BLOB” and 
	 *  b>have a field in entity of type “byte array”.
	 *  Strings are mapped to database type CLOB and byte[] to BLOB
	 */
	/*@Lob
   // @Column(name = "IMAGE")	
	protected byte[] pic1;
	protected byte[] pic2;
	protected byte[] pic3;
	protected byte[] coa;*/
	
	protected Date dateManufacture;	
	protected Date dateExpire;
	//@Temporal(javax.persistence.TemporalType.DATE)
	protected Date updateOn;
	protected int loadedBy;
	protected boolean approved;
	protected int approvedBy;	


}
