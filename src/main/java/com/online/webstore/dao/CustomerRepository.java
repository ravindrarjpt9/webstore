package com.online.webstore.dao;

import java.util.List;

import com.online.webstore.model.Customer;

public interface CustomerRepository {

	List<Customer> getAllCustomers();
}
