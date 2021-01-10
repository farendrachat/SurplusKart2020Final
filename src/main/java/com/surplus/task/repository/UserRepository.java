package com.surplus.task.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.surplus.task.domain.User;

public interface UserRepository extends JpaRepository<User,Integer>
{
	public User findByUserId(int userId);
	public List<User> findByUserNameAndPassword(String userName,String password);	
	List<User> findByUserName(String userName);
	

}
