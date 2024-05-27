package com.ws.apidak.dto.response;



import java.sql.Timestamp;

import lombok.Data;

@Data
public class LoginResponseDto{

	private Long id;
	private String userName;
	private String password;
	private Integer roleId;
	private String status;
	private Integer loginFail;
	private String createBy;
	private Timestamp createDate;
	private String updateBy;
	private Timestamp updateDate;
}
