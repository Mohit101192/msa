package com.nagarro.msa.cartandorder.model;

import java.util.List;

import lombok.Data;

@Data
public class OrderDetail {

	
	private String orderStatus;
	private List<SubProduct> productList;
	private int totalAmount;
}
