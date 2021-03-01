package com.nagarro.msa.cartandorder.service;

import com.nagarro.msa.cartandorder.model.OrderDetail;

public interface OrderService {

	public int placeOrder(String username,int addressId,int cityId);
	public int orderAmount(int orderId);
	public String paymentCompleted(int orderId);
	public String spAssigned(int orderId);
	public String orderCompleted(int orderId);
	public OrderDetail orderDetail(int orderId);
}
