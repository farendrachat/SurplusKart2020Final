package com.surplus.task.dto;

import java.util.List;

import com.surplus.task.domain.Product;

import lombok.Data;

@Data
public class ProductsResponse {
	
	private String status;	
	private String message;	
	List<Product> products;
}
