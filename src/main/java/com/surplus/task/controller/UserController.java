package com.surplus.task.controller;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.surplus.task.domain.User;
import com.surplus.task.dto.Response;
import com.surplus.task.dto.UsersResponse;
import com.surplus.task.service.UserService;
import com.surplus.task.utils.Constants;

import io.swagger.annotations.Api;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/user")
@Api(value="Surplus Kart", description="Operations pertaining to users in the Application") 
public class UserController {
	
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	private UserService userService;
	
	UserController(UserService userService)
	{
		this.userService = userService;
	}
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping(value="/users",produces = MediaType.APPLICATION_JSON_VALUE)
	public UsersResponse listUser()
	{
		logger.info("Get all Users request received");
		UsersResponse response=new UsersResponse();
		response.setMessage(Constants.SUCCESS);
		response.setStatus(Constants.SUCCESS);
		response.setUsers(userService.getAllUsers());
		logger.info("Get all Users request completed");
		return response;
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/save")
	public Response saveUser(@RequestBody User user)
	{	
		logger.info("Add User request received with user details : "+user);
		Response response=new Response();
		User addedUser=userService.save(user);
		response.setMessage(Constants.USER_ADDED_SUCCSESSFULLY);
		response.setStatus(Constants.SUCCESS);
		response.setUsername(addedUser.getName());
		logger.info("Add User request completed");
		return response;
	}
	
	
	@DeleteMapping("/delete")
	@CrossOrigin(origins = "http://localhost:4200")
	public boolean deleteUser(@RequestParam(value="userId",required=true) int userId)
	{		
		return userService.deleteUser(userId);
	}

}
