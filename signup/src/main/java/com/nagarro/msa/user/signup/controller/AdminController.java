package com.nagarro.msa.user.signup.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.msa.user.signup.service.UserService;

@RestController("/admin")
public class AdminController {

	@Autowired
	private UserService userService;
	
	@PostMapping("/enablesp")
	public String enableServiceProvider(String username)
	{
		return userService.enableServiceProvider(username);
	}
	
}
