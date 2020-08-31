package com.surplus.task.dto;

import com.surplus.task.domain.Product;


public class ProductResponse {
	
	private String status;
	
	private String message;
	
	private Product product;
	

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

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

	@Override
	public String toString() {
		return "ProductsResponse [status=" + status + ", message=" + message + ", product=" + product + "]";
	}


}
