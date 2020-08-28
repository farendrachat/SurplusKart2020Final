package com.surplus.task.utils;

public class UserAlreadyExistException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public UserAlreadyExistException(String message) {
		super(message);
	}

}
