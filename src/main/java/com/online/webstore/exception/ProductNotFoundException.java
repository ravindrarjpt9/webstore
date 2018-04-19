package com.online.webstore.exception;

public class ProductNotFoundException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2210341927061468150L;

	public ProductNotFoundException() {

	}
	
	
	
	public ProductNotFoundException(String productId) {
		
		this.productId = productId;
	}



	private String productId;


	public String getProductId() {
		return productId;
	}


	public void setProductId(String productId) {
		this.productId = productId;
	}


	
	
	
}
