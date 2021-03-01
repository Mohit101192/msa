package com.nagarro.msa.service.provider.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.msa.service.provider.model.ServiceProviderUser;
import com.nagarro.msa.service.provider.service.ServiceProviderService;

@RestController
public class ServiceProviderController {

	@Autowired
	private ServiceProviderService spService;
	
	@PostMapping("/assignSP")
	public String assignSp(String username,int orderId)
	{
		return spService.assignSp(username, orderId);
	}
	
	
	@GetMapping("spList")
	public List<ServiceProviderUser> spList(int cityId)
	{
		return spService.spList(cityId);
	}
	
	@GetMapping("fetchOrders")
	public List<Integer> fetchOrders(String username)
	{
		return spService.fetchOrders(username);
	}
	
	@GetMapping("updateOrder")
	public String updateOrder(String username,int orderId)
	{
		return spService.updateOrder(username, orderId);
	}
	
}
