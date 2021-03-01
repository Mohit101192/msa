package com.nagarro.msa.user.signup.controller;

import java.security.Principal;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.nagarro.msa.user.signup.model.MSAUser;
import com.nagarro.msa.user.signup.model.ServiceResponse;
import com.nagarro.msa.user.signup.model.User;
import com.nagarro.msa.user.signup.service.UserService;

@RestController
public class UserController {

	private final Logger logger = LogManager.getLogger(UserController.class);
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/user")
	public MSAUser fetchUser(@RequestParam("username") String username)
	{
		return userService.loadUserByUsername(username);
	}
	
	@PutMapping("/updateCity")
	public ServiceResponse updateCity(String username,int cityId)
	{
		return userService.updateCity(username, cityId);
	}
	
	@PutMapping("/updateDefaultAddress")
	public ServiceResponse updateDefaultAddress(String username,int addressId)
	{
		return userService.updateDefaultAddress(username, addressId);
	}
	
	@PostMapping("/addAddress")
	public ServiceResponse removeAddress(String username,int addressId)
	{
		return userService.removeAddress(username, addressId);
	}
	@GetMapping("/cityId")
	public int cityId(String username)
	{
		return userService.cityId(username);
	}
	
	
	@GetMapping("/spList")
	public List<User> spList(int cityId)
	{
		logger.info(">> spList(int cityId)");
		
		logger.info("CityId: "+cityId);
		return userService.spList(cityId);
	}
}
