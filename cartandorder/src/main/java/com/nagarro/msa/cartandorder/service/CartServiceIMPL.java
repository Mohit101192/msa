package com.nagarro.msa.cartandorder.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.nagarro.msa.cartandorder.config.ProductClient;
import com.nagarro.msa.cartandorder.constants.IApplicationConstants;
import com.nagarro.msa.cartandorder.model.Cart;
import com.nagarro.msa.cartandorder.model.CartProduct;
import com.nagarro.msa.cartandorder.model.SubProduct;

@Service
public class CartServiceIMPL implements CartService{

	
	@Autowired
	@Qualifier("cartTable")
	private ConcurrentHashMap<String, Cart> cartTable;
	
	@Autowired
	private ProductClient productClient;
	
	@Override
	public String addToCart(String username,CartProduct cartProduct) {
		
		if(cartTable.containsKey(username))
		{
			Cart presentCart = cartTable.get(username);
			presentCart.getProductList().add(cartProduct);
		}
		else
		{

			Cart presentCart = new Cart();
			List<CartProduct> productList = new ArrayList<>();
			productList.add(cartProduct);
			presentCart.setProductList(productList);
			cartTable.put(username, presentCart);
		}
		
		return IApplicationConstants.PRODUCT_ADDED_SUCCESS_MESSAGE;
	}

	@Override
	public List<SubProduct> cartDetails(String username,int cityId) {
		List<SubProduct> productList = new ArrayList<>();
		
		if(cartTable.containsKey(username))
		{
			Cart userCart = cartTable.get(username);
			
			List<CartProduct> cartProductList = userCart.getProductList();
			
			for(CartProduct cartProduct : cartProductList)
			{
				productList.add(productClient.getProductDetail(cityId,cartProduct.getProductId(), cartProduct.getSubProductId()));
			}
		}
		return productList;
	}

	@Override
	public String removeFromCart(String username, CartProduct cartProduct) {
		if(cartTable.containsKey(username))
		{
			Cart presentCart = cartTable.get(username);
			presentCart.getProductList().remove(cartProduct);
		}
		return IApplicationConstants.PRODUCT_REMOVED_SUCCESS_MESSAGE;
	}

}
