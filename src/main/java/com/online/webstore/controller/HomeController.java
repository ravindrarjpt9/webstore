package com.online.webstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.online.webstore.service.ProductService;

@Controller
public class HomeController {

	@Autowired
	private ProductService productService;
	
	@RequestMapping("/")
	public String welcome(Model model){
		productService.insertTestData();
		return "redirect:/products";
	}
}
