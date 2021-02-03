package com.surplus.task.dto;

import com.surplus.task.domain.Product;

import lombok.Data;

@Data
public class TransactionResponse {
	
	private String status;	
	private String message;	
	private Product product;
	

}
