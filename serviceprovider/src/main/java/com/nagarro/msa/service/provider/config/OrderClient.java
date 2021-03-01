package com.nagarro.msa.service.provider.config;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.nagarro.msa.service.provider.model.User;


@FeignClient(name="cart")
public interface OrderClient {

	@RequestMapping(method = RequestMethod.POST, value = "/spAssigned")
    String spAssigned(@RequestParam("orderId") int orderId);
	
	@RequestMapping(method = RequestMethod.POST, value = "/orderCompleted")
    String orderCompleted(@RequestParam("orderId") int orderId);
	
	
}
