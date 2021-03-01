package com.nagarro.msa.payment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.msa.payment.model.Payment;
import com.nagarro.msa.payment.service.PaymentService;

@RestController
public class PaymentController {

	@Autowired
	private PaymentService paymentService;
	
	public String completePayment(int orderId,@RequestBody Payment payment)
	{
		
		return paymentService.completePayment(orderId, payment);
	}
}
