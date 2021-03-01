package com.nagarro.msa.cartandorder.config;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.nagarro.msa.cartandorder.model.Cart;
import com.nagarro.msa.cartandorder.model.Order;

@Configuration
public class AppConfig {

	@Bean("cartTable")
	@Scope("singleton")
	public ConcurrentHashMap<String, Cart> cartTable()
	{
		return new ConcurrentHashMap<String,Cart>();
	}
	
	@Bean("orderTable")
	@Scope("singleton")
	public List<Order> orderTable()
	{
		return new ArrayList<>();
	}
}
