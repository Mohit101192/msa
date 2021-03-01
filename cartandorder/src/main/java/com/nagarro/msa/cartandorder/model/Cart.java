package com.nagarro.msa.cartandorder.model;

import java.util.List;
import lombok.Data;

@Data
public class Cart {

	private List<CartProduct> productList;
	
}
