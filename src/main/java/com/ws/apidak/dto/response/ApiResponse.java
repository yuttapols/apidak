package com.ws.apidak.dto.response;



import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonPropertyOrder({
	"code",
	"message",
	"data"
})
public class ApiResponse {

	private String message;
	private String code;
	private Object data;
	private Timestamp date;
	private Boolean success;
}
