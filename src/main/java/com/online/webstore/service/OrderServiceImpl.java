package com.online.webstore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.online.webstore.dao.ProductRepository;
import com.online.webstore.model.Product;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private ProductRepository productRepository;

	@Transactional
	public void processOrder(Integer productId, long quantity) {
		Product productById = productRepository.getProductById(productId);

		if (productById.getUnitsInStock() < quantity) {
			throw new IllegalArgumentException(
					"Out of Stock. Available Units in stock" + productById.getUnitsInStock());
		}

		productById.setUnitsInStock(productById.getUnitsInStock() - quantity);
	}

}
