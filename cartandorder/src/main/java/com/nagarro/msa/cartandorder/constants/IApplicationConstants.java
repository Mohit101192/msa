package com.nagarro.msa.cartandorder.constants;

public interface IApplicationConstants {

	String PRODUCT_ADDED_SUCCESS_MESSAGE = "Product has been added successfully to cart.";
	String PRODUCT_REMOVED_SUCCESS_MESSAGE = "Product has been removed successfully to cart.";
	String SUCCESS_STATUS = "SUCCESS";
	String FAIL_STATUS = "FAILED";
	int PAYMENT_PENDING_ORDER = 1;
	int PAYMENT_COMPLETED_ORDER = 2;
	int SERVICE_PROVIDER_ASSIGNED_ORDER = 3;
	int SERVICE_COMPLETED_ORDER = 4;
}
