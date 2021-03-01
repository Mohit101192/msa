package com.nagarro.msa.user.signup.config;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.core.io.ClassPathResource;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.nagarro.msa.user.signup.model.User;

@Configuration
public class AppConfig {

	private Map<String, String> mobileIndex = new HashMap<>();
	
	private Map<String,Boolean> userEnableMap = new ConcurrentHashMap<String, Boolean>();
	
	@Bean("userEnableMap")
	@Scope("singleton")
	public Map<String,Boolean> userEnableMap() throws IOException
	{
		
	return userEnableMap;
	}
	
	@Bean("userMap")
	@Scope("singleton")
	public Map<String,User> userMapBean() throws IOException
	{
		
		Map<String, User> userMap ;
		
		File file = new ClassPathResource("user.json").getFile();
		
		Gson gson = new Gson();
		Type listOfMyClassObject = new TypeToken<ConcurrentHashMap<String, User>>() {}.getType();
		userMap = gson.fromJson(new FileReader(file), listOfMyClassObject);
		
		for(String user: userMap.keySet())
		{
			userEnableMap.put(user, true);
		}
		
		for(User user : userMap.values())
		{
			user.setPassword(passwordEncoder().encode(user.getPassword()));
		}
		
		return userMap;
	}
	
	@Bean("mobileIndex")
	@Scope("singleton")
	public Map<String,String> mobileIndex()
	{
		return mobileIndex;
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
}
