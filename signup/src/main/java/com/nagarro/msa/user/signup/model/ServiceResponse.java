package com.nagarro.msa.user.signup.model;

import lombok.Data;

@Data
public class ServiceResponse {

	private String status;
	private String message;
	private int statusCode;
	
	
}
