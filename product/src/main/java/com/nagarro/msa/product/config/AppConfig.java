package com.nagarro.msa.product.config;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.core.io.ClassPathResource;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.nagarro.msa.product.model.City;
import com.nagarro.msa.product.model.Product;

@Configuration
public class AppConfig {

	
	
	@Bean("cityList")
	@Scope("singleton")
	public List<City> cityList() throws IOException
	{
		
		
		
		List<City> cityList = new ArrayList<>();
		File file = new ClassPathResource("city.json").getFile();
		
		Gson gson = new Gson();
		Type listOfMyClassObject = new TypeToken<List<City>>() {}.getType();

		cityList = gson.fromJson(new FileReader(file), listOfMyClassObject);
		
		return cityList;
		
	}
	
	@Bean("productMap")
	@Scope("singleton")
	public Map<String, List<Product>> productMap() throws IOException
	{
		HashMap<String, List<Product>> initProductMap ;
		
		File file = new ClassPathResource("product.json").getFile();
		
		Gson gson = new Gson();
		Type listOfMyClassObject = new TypeToken<HashMap<String, List<Product>>>() {}.getType();
		initProductMap = gson.fromJson(new FileReader(file), listOfMyClassObject);
		return initProductMap;
	}
	
	
}
