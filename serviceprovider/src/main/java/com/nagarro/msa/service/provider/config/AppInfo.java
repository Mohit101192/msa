package com.nagarro.msa.service.provider.config;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;


@Configuration
public class AppInfo {

	private final Map<String, List<Integer>> spOrderList = new ConcurrentHashMap<>();
	
	@Bean("spOrderList")
	@Scope("singleton")
	public Map<String, List<Integer>> spOrderList()
	{
		return spOrderList;
		
	}
}
