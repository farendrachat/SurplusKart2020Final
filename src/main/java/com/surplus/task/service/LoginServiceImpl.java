package com.surplus.task.service;



import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.surplus.task.controller.LoginController;
import com.surplus.task.domain.User;
import com.surplus.task.dto.LoginRequest;
import com.surplus.task.dto.LoginResponse;
import com.surplus.task.repository.UserRepository;
import com.surplus.task.utils.Constants;
import com.surplus.task.utils.InvalidCredentialsException;


@Service
public class LoginServiceImpl implements LoginService {
	
	private static final Logger logger = LoggerFactory.getLogger(LoginServiceImpl.class);
	
	private UserRepository userRepository; 
	
	LoginServiceImpl(UserRepository userRepository){
		this.userRepository = userRepository;		
	}

	@Override
	public LoginResponse login(LoginRequest loginRequest) {
		logger.info("Executing login method with username : " + loginRequest.getUsername());
		LoginResponse response = null;
		List<User> users = userRepository.findByNameAndPassword(loginRequest.getUsername(), loginRequest.getPassword());
		if (null == users || users.isEmpty()) {
			logger.warn("No user found with given details for username : " + loginRequest.getUsername());
			throw new InvalidCredentialsException(Constants.NO_USER_FOUND);
		} else {
			response = new LoginResponse();
			response.setStatus(Constants.SUCCESS);
			response.setLoginTime(new Date());
			response.setRole(users.get(0).getRole());
			response.setUsername(users.get(0).getName());
			response.setMessage(Constants.SUCCESS_MESSAGE_LOGIN);
			logger.info("Completed login method with status as Success");
		}
		return response;
	}
}
