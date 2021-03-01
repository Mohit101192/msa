package com.nagarro.msa.cartandorder.service;

import java.util.List;

import com.nagarro.msa.cartandorder.model.CartProduct;
import com.nagarro.msa.cartandorder.model.SubProduct;

public interface CartService {

	public String addToCart(String username,CartProduct cartProduct);
	public String removeFromCart(String username,CartProduct cartProduct);
	public List<SubProduct> cartDetails(String username,int cityId);
}
