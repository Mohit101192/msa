package com.nagarro.msa.payment.service;

import org.springframework.web.bind.annotation.RequestBody;

import com.nagarro.msa.payment.model.Payment;

public interface PaymentService {

	public String completePayment(int orderId,@RequestBody Payment payment);
	
}
