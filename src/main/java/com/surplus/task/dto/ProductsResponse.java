package com.surplus.task.dto;

import java.util.List;

import com.surplus.task.domain.Product;


public class ProductsResponse {
	
	private String status;
	
	private String message;
	
	List<Product> products;
	

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	@Override
	public String toString() {
		return "ProductsResponse [status=" + status + ", message=" + message + ", products=" + products + "]";
	}


}
