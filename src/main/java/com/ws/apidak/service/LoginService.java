package com.ws.apidak.service;

import java.util.List;

import com.ws.apidak.dto.response.LoginResponseDto;

public interface LoginService {

	public LoginResponseDto findByUserName(String userName) throws Exception;
	public List<LoginResponseDto> findAll() throws Exception;
}
