package com.nagarro.msa.payment.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.msa.payment.config.CartClient;
import com.nagarro.msa.payment.constants.IApplicationConstants;
import com.nagarro.msa.payment.model.Payment;

@Service
public class PaymentServiceIMPL implements PaymentService{

	@Autowired
	private CartClient cartClient;
	
	@Override
	public String completePayment(int orderId, Payment payment) {
		
		
		int orderCost = cartClient.getCartAmount(orderId);
		
		if(orderCost == payment.getPaymentAmount())
		{
			cartClient.paymentCompleted(orderId);
		}
		
		return IApplicationConstants.SUCCESS_STATUS;
	}

}
