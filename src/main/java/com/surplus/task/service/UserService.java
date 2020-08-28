package com.surplus.task.service;

import java.util.List;

import com.surplus.task.domain.User;

public interface UserService {
	
	List<User> getAllUsers();
	public User save (User user);
	public User getUser(int userId);
	public boolean deleteUser(int userId);

}
