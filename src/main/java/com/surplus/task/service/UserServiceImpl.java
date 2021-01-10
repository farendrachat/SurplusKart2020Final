package com.surplus.task.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import com.surplus.task.domain.User;
import com.surplus.task.domain.UserDtls;
import com.surplus.task.repository.UserDtlsRepository;
import com.surplus.task.repository.UserRepository;
import com.surplus.task.utils.Constants;
import com.surplus.task.utils.NoDataFoundException;
import com.surplus.task.utils.UserAlreadyExistException;


@Service
public class UserServiceImpl implements UserService {
	private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	private UserRepository userRepository; 
	private UserDtlsRepository userDtlsRepository; 
	
	UserServiceImpl(UserRepository userRepository,UserDtlsRepository userDtlsRepository){
		this.userRepository = userRepository;	
		this.userDtlsRepository = userDtlsRepository;
	}

	@Override
	public boolean saveUser(User user) {
		logger.info("Executing add method with User details : " + user);
		List<User> users = userRepository.findByUserName(user.getUserName());
		if (users.size() > 0) {
			logger.warn("User already exist with name : " + user.getUserName());
			throw new UserAlreadyExistException(Constants.USER_ALREADY_EXIST);
		} else {			
			userRepository.save(user);
			logger.info("User added successfully with details : " + user);
			return true;
		}
	}	
	
	@Override
	public boolean saveUserDtls(UserDtls userDtls) {
		logger.info("Executing add method with User details : " + userDtls);
		UserDtls userDtlsTemp = userDtlsRepository.findByUserName(userDtls.getUserName());
		if (userDtlsTemp != null) {
			logger.warn("User already exist with name : " + userDtls.getUserName());
			throw new UserAlreadyExistException(Constants.USER_ALREADY_EXIST);
		} else {
			logger.info("User added successfully with details : " + userDtls);
			 userDtlsRepository.save(userDtls);
			 return true;
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
		logger.info("Executing getUser method with id : " + userId);
		Optional<User> user = userRepository.findById(userId);
		if (user.isPresent())
			return user.get();
		else {
			logger.warn("No User found with id : " + userId);
			throw new NoDataFoundException(Constants.NO_DATA_AVALIABLE);
		}
	}
	
	@Override
	public UserDtls getUserDtls(int userDtlId) {		
		logger.info("Executing getUserDtls method with id : " + userDtlId);
		Optional<UserDtls> userDtls = userDtlsRepository.findByUserDtlId(userDtlId);
		if (userDtls.isPresent())
			return userDtls.get();
		else {
			logger.warn("No UserDtls found with userid : " + userDtlId);
			throw new NoDataFoundException(Constants.NO_DATA_AVALIABLE);
		}
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
	
	public User updateUser(User user) {
		logger.info("Executing update meothod with User details : " + user);
		List<User> users = userRepository.findByUserName(user.getUserName());
		if (users.size() > 0) {
			User savedUser = users.get(0);
			user.setUserId(savedUser.getUserId());
			user.getUserDtls().setUserDtlId(savedUser.getUserDtls().getUserDtlId());
//			savedUser.setPassword(user.getPassword());
//			savedUser.setRole(user.getRole());
//			savedUser.setUserName(user.getUserName());
			userRepository.save(user);
			logger.info("User details with updated successfully with User details : " + user);
			return user;
		} else {
			logger.warn("No User found with name : " + user.getUserName());
			throw new NoDataFoundException(Constants.USER_NOT_EXIST);
		}
	}
}
