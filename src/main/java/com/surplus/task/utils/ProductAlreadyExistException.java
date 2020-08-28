package com.surplus.task.utils;

public class ProductAlreadyExistException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public ProductAlreadyExistException(String message) {
		super(message);
	}

}
