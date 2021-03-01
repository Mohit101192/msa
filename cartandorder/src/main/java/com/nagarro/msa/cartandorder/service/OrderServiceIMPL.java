package com.nagarro.msa.cartandorder.service;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.nagarro.msa.cartandorder.config.ProductClient;
import com.nagarro.msa.cartandorder.constants.IApplicationConstants;
import com.nagarro.msa.cartandorder.constants.PaymentStatus;
import com.nagarro.msa.cartandorder.model.Cart;
import com.nagarro.msa.cartandorder.model.CartProduct;
import com.nagarro.msa.cartandorder.model.Order;
import com.nagarro.msa.cartandorder.model.OrderDetail;
import com.nagarro.msa.cartandorder.model.SubProduct;

@Service
public class OrderServiceIMPL implements OrderService{

	@Autowired
	@Qualifier("orderTable")
	private List<Order> orderTable;
	
	@Autowired
	@Qualifier("cartTable")
	private ConcurrentHashMap<String, Cart> cartTable;
	
	@Autowired
	private CartService cartService;
	
	@Autowired
	private ProductClient productClient;
	
	@Override
	public int placeOrder(String username, int addressId,int cityId) {
		
		Cart cart = cartTable.get(username);
		
		Order order = new Order();
		order.setCart(cart);
		order.setAddressId(addressId);
		order.setStatus(PaymentStatus.PAYMENT_PENDING.value());
		order.setCityId(cityId);
		int size = orderTable.size();
		orderTable.add(order);
		return size;
	}

	@Override
	public int orderAmount(int orderId) {
		
		int orderAmount = 0;
		if(orderTable.size()>=orderId)
		{
			Order order = orderTable.get(orderId);
			Cart cart = order.getCart();
			
			for(CartProduct product : cart.getProductList())
			{
				SubProduct subProduct = productClient.getProductDetail(order.getCityId(),product.getProductId(), product.getSubProductId());
				orderAmount+=subProduct.getPrice();
			}
		}
		
		return orderAmount;
	}

	@Override
	public String paymentCompleted(int orderId) {
		if(orderTable.size()>=orderId)
		{
			Order order = orderTable.get(orderId);
			order.setStatus(PaymentStatus.PAYMENT_COMPLETED.value());
		}
		return IApplicationConstants.SUCCESS_STATUS;
	}

	@Override
	public OrderDetail orderDetail(int orderId) {
		OrderDetail orderDetail = new OrderDetail();
		
		if(orderTable.size()>=orderId)
		{
			Order order = orderTable.get(orderId);
			
			for(PaymentStatus paymenStatus : PaymentStatus.values())
			{
				if(paymenStatus.value()==order.getStatus())
				{
					orderDetail.setOrderStatus(paymenStatus.toString());
					break;
				}
			}
			orderDetail.setTotalAmount(orderAmount(orderId));
			
			orderDetail.setProductList(cartService.cartDetails(order.getUsername(), order.getCityId()));
		}

		
		return orderDetail;
	}

	@Override
	public String spAssigned(int orderId) {
		if(orderTable.size()>=orderId)
		{
			Order order = orderTable.get(orderId);
			order.setStatus(PaymentStatus.SERVICE_PROVIDE_ASSIGNED.value());
		}
		return IApplicationConstants.SUCCESS_STATUS;
	}

	@Override
	public String orderCompleted(int orderId) {
		if(orderTable.size()>=orderId)
		{
			Order order = orderTable.get(orderId);
			order.setStatus(PaymentStatus.ORDER_COMPLETED.value());
		}
		return IApplicationConstants.SUCCESS_STATUS;
	}

	
	
}
