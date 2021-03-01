package com.nagarro.msa.service.provider.model;

import java.util.List;

import lombok.Data;

@Data
public class User {

	
	private String firstName;
	private String lastName;
	private String username;
	private String dob;
	private String mobile;
	private String password;
	private List<Address> addressList;
	private int defaultAddressId;
	private int cityId;
	private String role;
	private String shopAddress;
}