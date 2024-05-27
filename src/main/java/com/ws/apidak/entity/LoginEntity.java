package com.ws.apidak.entity;



import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

@Data
@Table(name = "login")
@Entity
public class LoginEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "username")
	private String userName;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "role_id")
	private Integer roleId;
	
	@Column(name = "status")
	private String status;
	
	@Column(name = "login_fail")
	private Integer loginFail;
	
	@Column(name = "create_by")
	private String createBy;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "create_date")
	private Timestamp createDate;
	
	@Column(name = "update_by")
	private String updateBy;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "update_date")
	private Timestamp updateDate;

}
