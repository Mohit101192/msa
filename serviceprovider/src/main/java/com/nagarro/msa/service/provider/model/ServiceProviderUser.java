package com.nagarro.msa.service.provider.model;

import lombok.Data;

@Data
public class ServiceProviderUser {

	private String username;
	private String address;
	private String email;
	private String phone;
	private int cityId;
	
}
