package com.nagarro.msa.cartandorder.config;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.nagarro.msa.cartandorder.model.SubProduct;

@FeignClient(name="product")
public interface ProductClient {

	@RequestMapping(method = RequestMethod.GET, value = "/productDetails")
    SubProduct getProductDetail(@RequestParam("cityId") int cityId,@RequestParam("productId") int productId,@RequestParam("subProductId") int subProductId);
	
}
