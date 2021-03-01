package com.nagarro.msa.user.signup.model;

import java.util.List;

import lombok.Data;

@Data
public class SignUpResponse {

	private String status;
	private List<String> messageList;
	private int statusCode;
	
}
