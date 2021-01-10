package com.surplus.task.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.surplus.task.domain.Task;
import com.surplus.task.domain.UserDtls;

public interface UserDtlsRepository extends JpaRepository<UserDtls,Integer>
{
	
	public UserDtls findByUserName(String userName);
	public Optional<UserDtls> findByUserDtlId(int userDtlId);

}
