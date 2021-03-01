package com.nagarro.msa.product.model;

import java.util.List;

import lombok.Data;

@Data
public class Product {

	private int id;
	private String name;
	private List<SubProduct> subProductList;
	
}
