package com.nagarro.msa.cartandorder.constants;

public enum PaymentStatus {

	PAYMENT_PENDING(1),
	PAYMENT_COMPLETED(2),
	SERVICE_PROVIDE_ASSIGNED(3),
	ORDER_COMPLETED(4);
	
	private final int value;
	
	PaymentStatus(int i) {
		value=i;
	}
	
	public int value()
	{
		return value;
	}
	
}
