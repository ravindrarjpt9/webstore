package com.online.webstore.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.online.webstore.model.Product;

public interface ProductService {

	public List<Product> getAllList();
	public void insertTestData();
	List<Product> getProductsByCategory(String category);
	Set<Product> getProductsByFilter(Map<String, List<String>> filterParams);
	Product getProductById(Integer productID);
	public void addProduct(Product product);
}
