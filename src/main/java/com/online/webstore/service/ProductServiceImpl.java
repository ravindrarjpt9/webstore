package com.online.webstore.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.online.webstore.dao.ProductRepository;
import com.online.webstore.model.Product;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	private ProductRepository productRepository;
	
	@Override
	@Transactional(readOnly=true)
	public List<Product> getAllList() {
		return productRepository.getAllList();
	}
	
	@Override
	@Transactional()
	public void insertTestData() {
		productRepository.insertTestData();
	}

	@Override
	@Transactional(readOnly=true)
	public List<Product> getProductsByCategory(String category) {
		return productRepository.getProductsByCategory(category);
	}
	
	@Override
	@Transactional(readOnly=true)
	public Set<Product> getProductsByFilter(Map<String, List<String>> filterParams) {

		return productRepository.getProductsByFilter(filterParams);
	}
	
	@Override
	@Transactional(readOnly=true)
	public Product getProductById(Integer productID) {
		
		return productRepository.getProductById(productID);
	}

	@Override
	@Transactional
	public void addProduct(Product product) {
		productRepository.addProduct(product);
	}
}
