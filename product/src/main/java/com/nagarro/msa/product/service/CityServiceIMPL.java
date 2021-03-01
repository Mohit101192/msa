package com.nagarro.msa.product.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.nagarro.msa.product.model.City;

@Service
public class CityServiceIMPL implements CityService{

	
	@Autowired
	@Qualifier("cityList")
	private List<City> cityListAtStart;
	
	@Override
	public List<City> cityList() {
		return cityListAtStart;
	}
	
	
	
	
	

}
