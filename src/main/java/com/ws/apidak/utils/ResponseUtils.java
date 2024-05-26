package com.ws.apidak.utils;


import java.sql.Timestamp;
import java.util.Date;

import org.springframework.http.HttpStatus;

import com.ws.apidak.dto.response.ApiResponse;

import lombok.Data;

@Data
public class ResponseUtils {

	public static ApiResponse getSavedSuccessResponse(Object data) {
		String messageKey = ConstantUtils.messageSaveOk;
		return ApiResponse.builder()
				.success(true)
				.code(Integer.toString(HttpStatus.OK.value()))
				.data(data)
				.date(new Timestamp(System.currentTimeMillis()))
				.message(messageKey)
				.build();
	}
	
	public static ApiResponse getOkResponse(Object data) {
		String messageKey = ConstantUtils.messageOk;
		return ApiResponse.builder()
				.success(true)
				.code(Integer.toString(HttpStatus.OK.value()))
				.data(data)
				.date(new Timestamp(System.currentTimeMillis()))
				.message(messageKey)
				.build();
	}
	
	public static ApiResponse getErrorResponse(String messageKey) {
		return ApiResponse.builder()
				.success(false)
				.code(Integer.toString(HttpStatus.INTERNAL_SERVER_ERROR.value()))
				.data(null)
				.date(new Timestamp(System.currentTimeMillis()))
				.message(messageKey)
				.build();
	}
}

