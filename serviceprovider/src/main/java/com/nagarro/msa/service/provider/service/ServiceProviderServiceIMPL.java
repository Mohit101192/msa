package com.nagarro.msa.service.provider.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.nagarro.msa.service.provider.config.OrderClient;
import com.nagarro.msa.service.provider.config.UserClient;
import com.nagarro.msa.service.provider.model.ServiceProviderUser;
import com.nagarro.msa.service.provider.model.User;

@Service
public class ServiceProviderServiceIMPL implements ServiceProviderService{

	@Autowired
	private UserClient userClient;
	
	@Autowired
	private OrderClient orderClient;
	
	@Autowired
	@Qualifier("spOrderList")
	private Map<String, List<Integer>> spOrderList;
	
	@Override
	public String assignSp(String username, int orderId) {
		if(spOrderList.get(username)==null)
		{
			List<Integer> orderList = new ArrayList<>();
			spOrderList.put(username, orderList);
		}
		else
		{
		
			List<Integer> orderList = spOrderList.get(username);
			orderList.add(orderId);
			
		}
		return orderClient.spAssigned(orderId);
	}

	@Override
	public List<ServiceProviderUser> spList(int cityId) {
		List<User> userList = userClient.spList(cityId);
		List<ServiceProviderUser> spList = new ArrayList<>();
		for(User user: userList)
		{
			System.out.println(user);
			ServiceProviderUser spUser = new ServiceProviderUser();
			spUser.setAddress(user.getShopAddress());
			spUser.setCityId(user.getCityId());
			spUser.setUsername(user.getUsername());
			spUser.setPhone(user.getMobile());
			spList.add(spUser);
		}

	return spList;
	}

	@Override
	public List<Integer> fetchOrders(String username) {
		return spOrderList.get(username);
	}

	@Override
	public String updateOrder(String username, int orderId) {
		if(spOrderList.get(username)!=null)
		{
			List<Integer> orderList = spOrderList.get(username);
			int loc =0;
			for(int i:orderList)
			{
				if(i==orderId)
				{
					break;
				}
				loc++;
			}
			orderList.remove(loc);
		}

		return orderClient.orderCompleted(orderId);
	}


}
