package com.nagarro.msa.user.constants;

public interface IApplicationConstants {

	String USERNAME_DUPLICATE_MESSAGE = "Username already exists.";
	String EMAIL_DUPLICATE_MESSAGE = "Email already exists.";
	String MOBILE_DUPLICATE_MESSAGE = "Mobile already exists.";
	String SUCCESS_STATUS = "SUCCESS";
	String FAIL_STATUS = "FAILED";
	String CITY_UPDATE_SUCCESS_MESSAGE = "City has been updated successfully";
	String USER_NOT_FOUND_MESSAGE = "User does not exist.";
	
	String DEFAULT_ADDRESS_UPDATE_SUCCESS_MESSAGE = "Default address has been updated successfully";
	String ADDRESS_NOT_FOUND_MESSAGE = "Address does not exist.";
	String ADDRESS_ADDED_SUCCESS_MESSAGE = "Address has been added successfully";
	String ADDRESS_REMOVED_SUCCESS_MESSAGE = "Address has been removed successfully";
	
	
	String USER_ROLE="USER";
	String ADMIN_ROLE="ADMIN";
	String SERVICE_PROVIDER_ROLE="SP";
}
