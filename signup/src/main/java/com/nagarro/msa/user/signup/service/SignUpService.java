package com.nagarro.msa.user.signup.service;

import com.nagarro.msa.user.signup.model.SignUpResponse;
import com.nagarro.msa.user.signup.model.User;

public interface SignUpService {

	public SignUpResponse signUp(User user);
	
}
