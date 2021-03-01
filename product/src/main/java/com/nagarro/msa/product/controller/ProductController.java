package com.nagarro.msa.product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.msa.product.model.Product;
import com.nagarro.msa.product.model.SubProduct;
import com.nagarro.msa.product.service.ProductService;

@RestController
public class ProductController {

	
	@Autowired
	private ProductService productService;
	
	@GetMapping("/productList")
	public List<Product> productList(@RequestParam String cityId)
	{
		return productService.productList(cityId);	
	}
	
	@GetMapping("/productDetails")
	public SubProduct productDetails(@RequestParam("cityId") String cityId,@RequestParam int productId, @RequestParam int subProductId)
	{
		return productService.productDetails(cityId,productId,subProductId);	
	}
}
