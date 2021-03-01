package com.nagarro.msa.payment.config;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name="cart")
public interface CartClient {

	@RequestMapping(method = RequestMethod.GET, value = "/orderAmount")
    int getCartAmount(@RequestParam("orderId") int orderId);
	
	@RequestMapping(method = RequestMethod.POST, value = "/paymentCompleted")
	String paymentCompleted(@RequestParam("orderId") int orderId);
	
}
