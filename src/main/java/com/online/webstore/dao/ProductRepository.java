package com.online.webstore.dao;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.online.webstore.model.Product;

public interface ProductRepository {

	public List<Product> getAllList();
	
	Product getProductById(Integer productID);
	
	public void insertTestData();
	
	List<Product> getProductsByCategory(String category);
	
	Set<Product> getProductsByFilter(Map<String, List<String>> filterParams);
	
	void addProduct(Product product);
}
