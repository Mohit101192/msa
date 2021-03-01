package com.nagarro.msa.cartandorder.model;

import lombok.Data;

@Data
public class ServiceResponse {

	private String status;
	private String message;
	private int statusCode;
	
	
}
