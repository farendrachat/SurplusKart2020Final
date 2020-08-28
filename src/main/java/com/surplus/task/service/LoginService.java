package com.surplus.task.service;

import com.surplus.task.dto.LoginRequest;
import com.surplus.task.dto.LoginResponse;

public interface LoginService {
	LoginResponse login(LoginRequest loginRequest);

}
