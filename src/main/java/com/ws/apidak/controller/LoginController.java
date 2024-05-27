package com.ws.apidak.controller;

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
	
	@GetMapping("/authen")
	public ApiResponse findByUserName(HttpServletRequest request , @RequestParam(name = "userName") String userName, @RequestParam(name = "password") String password) {
		
		LoginResponseDto dataResponse = new LoginResponseDto();
		try {
			dataResponse = loginService.findByUserNameAndPassword(userName, password);
		} catch (Exception e) {
			// TODO: handle exception
			return ResponseUtils.getErrorResponse(e.getMessage());
		}

		return ResponseUtils.getOkResponse(dataResponse);
	}
	
}
