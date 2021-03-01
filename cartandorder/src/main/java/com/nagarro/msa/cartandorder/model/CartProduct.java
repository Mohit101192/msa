package com.nagarro.msa.cartandorder.model;


public class CartProduct {

	private int productId;
	private int subProductId;
	public int getProductId() {
		return productId;
	}


	public void setProductId(int productId) {
		this.productId = productId;
	}


	public int getSubProductId() {
		return subProductId;
	}


	public void setSubProductId(int subProductId) {
		this.subProductId = subProductId;
	}



	
	
@Override
public boolean equals(Object obj) {
	if(obj instanceof CartProduct)
	{
		CartProduct curr = (CartProduct)obj;
		
		return(curr.productId==productId && curr.subProductId==subProductId);
	}
	return false;
}
}
