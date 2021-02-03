package com.surplus.task.dto;

import com.surplus.task.domain.Product;

import lombok.Data;

@Data
public class ProductResponse {
	
	private String status;	
	private String message;	
	private Product product;
	

}
