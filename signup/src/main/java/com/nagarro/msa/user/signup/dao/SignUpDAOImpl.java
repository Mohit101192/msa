package com.nagarro.msa.user.signup.dao;

import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import com.nagarro.msa.user.constants.IApplicationConstants;
import com.nagarro.msa.user.signup.model.User;


@Repository
public class SignUpDAOImpl implements SignUpDAO{

	@Autowired
	@Qualifier("userMap")
	private Map<String, User> userMap;
	
	@Autowired
	@Qualifier("userEnableMap")
	private Map<String,Boolean> userEnableMap;
	
	@Autowired
	@Qualifier("mobileIndex")
	private Map<String, String> mobileIndex;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	
	@Override
	public String createUser(User user) {
		
		Optional<String> rawPasswordOp = Optional.ofNullable(user.getPassword());
		
		if(rawPasswordOp.isPresent())
		user.setPassword(passwordEncoder.encode(rawPasswordOp.get()));
		
		userMap.put(user.getUsername(), user);
		mobileIndex.put(user.getMobile(), user.getUsername());
		if(user.getRole().equalsIgnoreCase(IApplicationConstants.USER_ROLE))
		{
			userEnableMap.put(user.getUsername(), true);
		}
		
		return "User Created Successfully";
	}

	
	
	
}
