package com.nagarro.msa.product.service;

import java.util.List;

import com.nagarro.msa.product.model.Product;
import com.nagarro.msa.product.model.SubProduct;

public interface ProductService {

	public List<Product> productList(String cityId);
	public SubProduct productDetails(String cityId,int productId,int subProductId);
}
