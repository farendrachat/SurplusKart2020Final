package com.surplus.task.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.surplus.task.domain.User;

public interface UserRepository extends JpaRepository<User,Integer>
{
	public User findByUserId(int userId);
	public List<User> findByNameAndPassword(String name,String password);	
	List<User> findByName(String name);
	

}
