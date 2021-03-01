package com.nagarro.msa.service.provider.service;

import java.util.List;

import com.nagarro.msa.service.provider.model.ServiceProviderUser;

public interface ServiceProviderService {

	public String assignSp(String username,int orderId);
	public List<ServiceProviderUser> spList(int cityId);
	public List<Integer> fetchOrders(String username);
	public String updateOrder(String username,int orderId);
}
