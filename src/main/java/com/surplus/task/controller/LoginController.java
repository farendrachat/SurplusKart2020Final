package com.surplus.task.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.surplus.task.dto.LoginRequest;
import com.surplus.task.dto.LoginResponse;
import com.surplus.task.service.LoginService;

import io.swagger.annotations.Api;


@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/api/security")
@Api(value="Surplus Kart", description="Operations pertaining to products in Application") 
public class LoginController {
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	
//	@Autowired
	private LoginService loginService;
	
	LoginController(LoginService loginService)
	{
		this.loginService = loginService;
	}
	
	@PostMapping(value = "/login", consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
	private LoginResponse login(@RequestBody LoginRequest request) {
		logger.info("Login request received with : "+request);
		return loginService.login(request);
		
	}
	

}
