package com.online.webstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.online.webstore.service.OrderService;

@Controller
public class OrderController {

	@Autowired
	private OrderService orderService;

	@RequestMapping("/order/{productId}/{qty}")
	public String process(@PathVariable("productId") int productId,@PathVariable("qty") int qty) {
		orderService.processOrder(productId, qty);
		return "redirect:/products";
	}

}
