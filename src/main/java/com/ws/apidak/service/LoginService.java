package com.ws.apidak.service;

import com.ws.apidak.dto.response.LoginResponseDto;

public interface LoginService {

	public LoginResponseDto findByUserNameAndPassword(String userName, String password) throws Exception;
}
