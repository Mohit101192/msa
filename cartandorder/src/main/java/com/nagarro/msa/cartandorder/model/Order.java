package com.nagarro.msa.cartandorder.model;

import lombok.Data;

@Data
public class Order {

	private Cart cart;
	private String username;
	private int addressId;
	private int status;
	private int cityId;
}
