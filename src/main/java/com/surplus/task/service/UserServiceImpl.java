package com.surplus.task.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import com.surplus.task.domain.User;
import com.surplus.task.repository.UserRepository;
import com.surplus.task.utils.Constants;
import com.surplus.task.utils.NoDataFoundException;
import com.surplus.task.utils.UserAlreadyExistException;


@Service
public class UserServiceImpl implements UserService {
	private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	private UserRepository userRepository; 
	
	UserServiceImpl(UserRepository userRepository){
		this.userRepository = userRepository;		
	}

	@Override
	public User save(User user) {
		logger.info("Executing add method with User details : " + user);
		List<User> users = userRepository.findByName(user.getName());
		if (users.size() > 0) {
			logger.warn("User already exist with name : " + user.getName());
			throw new UserAlreadyExistException(Constants.USER_ALREADY_EXIST);
		} else {
			logger.info("User added successfully with details : " + user);
			return userRepository.save(user);
		}
	}	
	public boolean deleteUser(int userId){
		User user = null;
		boolean isDelete = true;
		try{
		user = this.userRepository.findByUserId(userId);
		 this.userRepository.delete(user);
		}catch(Exception ex)
		{
			isDelete  = false;
			System.out.println("exception in UserServiceImpl is  :"+ex);
		}
		return isDelete;
	}

	@Override
	public User getUser(int userId) {
		User user = userRepository.findByUserId(userId);
		return user;
	}

	@Override
	public List<User> getAllUsers() {
		logger.info("Executing getAllUsers method");
		List<User> users = userRepository.findAll();
		if (null == users || users.isEmpty()) {
			logger.warn("No Users found in the database");
			throw new NoDataFoundException(Constants.NO_DATA_AVALIABLE);
		} else {
			logger.info("Completed getAllUsers method with users : " + users);
			return users;
		}
	}
}
