package com.surplus.task.utils;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.surplus.task.dto.LoginResponse;
import com.surplus.task.dto.Response;
import com.surplus.task.dto.UsersResponse;


@RestControllerAdvice
public class ExceptionHandler {
	
	private static final Logger logger = LoggerFactory.getLogger(ExceptionHandler.class);
	
	@ResponseStatus(code = HttpStatus.UNAUTHORIZED)
	@org.springframework.web.bind.annotation.ExceptionHandler(value = InvalidCredentialsException.class)
	private LoginResponse invalidCredentialsException(InvalidCredentialsException exception) {
		logger.debug("InvalidCredentialsException exception : ", exception);
		LoginResponse response=new LoginResponse();
		response.setStatus(Constants.FAILURE);
		response.setMessage(Constants.NO_USER_FOUND);
		response.setLoginTime(new Date());
		return response;
	}
	
	@ResponseStatus(code=HttpStatus.OK)
	@org.springframework.web.bind.annotation.ExceptionHandler(value=NoDataFoundException.class)
	private UsersResponse NoDataFoundException(NoDataFoundException exception) {
		logger.debug("NoDataFoundException exception : ", exception);
		UsersResponse response=new UsersResponse();
		response.setMessage(exception.getMessage());
		response.setStatus(Constants.FAILURE);
		return response;
	}
	
	@ResponseStatus(code=HttpStatus.OK)
	@org.springframework.web.bind.annotation.ExceptionHandler(value=UserAlreadyExistException.class)
	private Response userAlreadyExistException(UserAlreadyExistException exception) {
		logger.debug("UserAlreadyExistException exception : ", exception);
		Response response=new Response();
		response.setMessage(exception.getMessage());
		response.setStatus(Constants.FAILURE);
		return response;
	}
	
	@ResponseStatus(code=HttpStatus.OK)
	@org.springframework.web.bind.annotation.ExceptionHandler(value=ProductAlreadyExistException.class)
	private Response productAlreadyExistException(ProductAlreadyExistException exception) {
		logger.debug("ProductAlreadyExistException exception : ", exception);
		Response response=new Response();
		response.setMessage(exception.getMessage());
		response.setStatus(Constants.FAILURE);
		return response;
	}
	
	
	@org.springframework.web.bind.annotation.ExceptionHandler(value = NullPointerException.class)
	private LoginResponse nullPointerException(NullPointerException exception) {
		logger.debug("NullPointerException exception : ", exception);
		LoginResponse response=new LoginResponse();
		response.setStatus(Constants.FAILURE);
		response.setMessage(exception.getMessage());
		response.setLoginTime(new Date());
		return response;
	}
	
	@org.springframework.web.bind.annotation.ExceptionHandler(value = Exception.class)
	private LoginResponse exception(Exception exception) {
		logger.debug("Exception : ", exception);
		LoginResponse response=new LoginResponse();
		response.setStatus(Constants.FAILURE);
		response.setMessage(Constants.SERVER_ERROR);
		response.setLoginTime(new Date());
		return response;
	}
	

}
