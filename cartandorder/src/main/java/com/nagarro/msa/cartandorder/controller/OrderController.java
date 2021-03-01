package com.nagarro.msa.cartandorder.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.msa.cartandorder.model.OrderDetail;
import com.nagarro.msa.cartandorder.service.OrderService;

@RestController
public class OrderController {

	@Autowired
	private OrderService orderService;
	
	@PostMapping("placeOrder")
	public int placeOrder(String username,int addressId,int cityId)
	{
		return orderService.placeOrder(username, addressId,cityId);
	}
	
	
	@PostMapping("paymentCompleted")
	public String paymentCompleted(int orderId)
	{
		return orderService.paymentCompleted( orderId);
	}
	
	@GetMapping("orderAmount")
	public int orderAmount(int orderId)
	{
		return orderService.orderAmount(orderId);
	}
	
	
	@GetMapping("/orderDetail")
	public OrderDetail orderDetail(int orderId)
	{
		return orderService.orderDetail(orderId);
	}
	
	
	@PostMapping("orderCompleted")
	public String orderCompleted(int orderId)
	{
		return orderService.orderCompleted( orderId);
	}
	
	@PostMapping("spAssigned")
	public String spAssigned(int orderId)
	{
		return orderService.spAssigned( orderId);
	}
}
