package com.nagarro.msa.cartandorder.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.msa.cartandorder.constants.IApplicationConstants;
import com.nagarro.msa.cartandorder.model.CartProduct;
import com.nagarro.msa.cartandorder.model.ServiceResponse;
import com.nagarro.msa.cartandorder.model.SubProduct;
import com.nagarro.msa.cartandorder.service.CartService;

@RestController
public class CartController {

	
	@Autowired
	private CartService cartService;
	
	@PostMapping("/addToCart")
	public ServiceResponse addToCart(@RequestBody CartProduct cartProduct,@RequestParam String username )
	{
		
		String message = cartService.addToCart(username, cartProduct);
		ServiceResponse sr = new ServiceResponse();
		sr.setMessage(message);
		sr.setStatus(IApplicationConstants.SUCCESS_STATUS);
		sr.setStatusCode(HttpStatus.ACCEPTED.value());
		
		return sr;
	}
	@PostMapping("/removeFromCart")
	public ServiceResponse removeFromCart(@RequestBody CartProduct cartProduct,@RequestParam String username )
	{
		
		String message = cartService.removeFromCart(username, cartProduct);
		ServiceResponse sr = new ServiceResponse();
		sr.setMessage(message);
		sr.setStatus(IApplicationConstants.SUCCESS_STATUS);
		sr.setStatusCode(HttpStatus.ACCEPTED.value());
		
		return sr;
	}
	
	@GetMapping("productDetails")
	public List<SubProduct> productDetails(@RequestParam String username,@RequestParam int cityId)
	{
		return cartService.cartDetails(username, cityId);
	}
}
