package com.nagarro.msa.user.signup.model;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class UserValidation {

	private boolean isValid;
	private List<String> failureMessageList = new ArrayList<>();

	
	
}
