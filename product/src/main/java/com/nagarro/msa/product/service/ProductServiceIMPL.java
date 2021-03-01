package com.nagarro.msa.product.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.nagarro.msa.product.model.Product;
import com.nagarro.msa.product.model.SubProduct;

@Service
public class ProductServiceIMPL implements ProductService{

	@Autowired
	@Qualifier("productMap")
	public Map<String, List<Product>> productMap;
	
	@Override
	public List<Product> productList(String cityId) {
		// TODO Auto-generated method stub
		return productMap.get(cityId);
	}

	@Override
	public SubProduct productDetails(String cityId,int productId, int subProductId) {
		SubProduct subProduct = new SubProduct();
		System.out.println("CityId :" +cityId);
		List<Product> productList = productList(cityId);
		
		for(Product product : productList)
		{
			if(product.getId()==productId)
			{
				for(SubProduct subProductPresent: product.getSubProductList())
				{
					if(subProductPresent.getId()==subProductId)
					{
						subProduct = subProductPresent;
						break;
					}
				}
			}
		}
		return subProduct;
	}
	
}
