package com.online.webstore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.online.webstore.dao.CustomerRepository;
import com.online.webstore.model.Customer;

@Service
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	private CustomerRepository customerRepository;
	
	@Override
	@Transactional(readOnly=true)
	public List<Customer> getAllCustomers() {
		return customerRepository.getAllCustomers();
	}
}
