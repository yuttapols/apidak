package com.ws.apidak.controller;

import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ws.apidak.dto.response.ApiResponse;
import com.ws.apidak.dto.response.LoginResponseDto;
import com.ws.apidak.service.LoginService;
import com.ws.apidak.utils.ResponseUtils;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api/v1/login")
public class LoginController {

	@Autowired
	LoginService loginService;
	
	@GetMapping("/findByUserName")
	public ApiResponse findByUserName(HttpServletRequest request ,@RequestParam(name = "userName") String userName) {
		
		LoginResponseDto dataResponse = new LoginResponseDto();
		try {
			dataResponse = loginService.findByUserName(userName);
		} catch (Exception e) {
			// TODO: handle exception
			return ResponseUtils.getErrorResponse(e.getMessage());
		}

		return ResponseUtils.getOkResponse(dataResponse);
	}
	
	@GetMapping("/findAll")
	public ApiResponse findAll() {
		List<LoginResponseDto> dataResponse = new ArrayList<>();
		try {
			dataResponse = loginService.findAll();
		} catch (Exception e) {
			// TODO: handle exception
			return ResponseUtils.getErrorResponse(e.getMessage());
		}
		return ResponseUtils.getOkResponse(dataResponse);
	}
}
