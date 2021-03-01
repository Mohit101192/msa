package com.nagarro.msa.product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.msa.product.model.City;
import com.nagarro.msa.product.service.CityService;

@RestController
public class CityController {

	@Autowired
	private CityService cityService;
	
	@GetMapping("/cityList")
	public List<City> cityList()
	{
		
		return cityService.cityList();
		
	}
	
	
}
