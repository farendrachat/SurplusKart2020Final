package com.surplus.task.service;

import java.util.List;

import com.surplus.task.domain.User;
import com.surplus.task.domain.UserDtls;

public interface UserService {
	
	List<User> getAllUsers();
	//public User save (User user);
	public User getUser(int userId);
	public boolean deleteUser(int userId);
	public User updateUser(User user);
	boolean saveUserDtls(UserDtls user);
	boolean saveUser(User user);
	UserDtls getUserDtls(int userId);

}
