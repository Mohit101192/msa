package com.nagarro.msa.user.signup.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.msa.user.constants.IApplicationConstants;
import com.nagarro.msa.user.signup.model.SignUpResponse;
import com.nagarro.msa.user.signup.model.User;
import com.nagarro.msa.user.signup.service.SignUpService;

@RestController
public class SignUpController {

	@Autowired
	private SignUpService signUpService;
	
	private static final Logger logger = LogManager.getLogger(SignUpController.class);
	
	
	@PostMapping("/signup")
	public SignUpResponse signUp(@RequestBody User user)
	{
		logger.info(">> ResponseEntity<String> signUp(@RequestBody User user)");
		SignUpResponse response = signUpService.signUp(user);
		if(response.getStatus().equals(IApplicationConstants.SUCCESS_STATUS))
		{
			response.setStatusCode(HttpStatus.ACCEPTED.value());
		}
		else
		{
			response.setStatusCode(HttpStatus.BAD_REQUEST.value());
		}
		logger.info("Response from signup service: "+response);
		
		logger.info(">> ResponseEntity<String> signUp(@RequestBody User user)");
		return response;
	}
	
	
}
