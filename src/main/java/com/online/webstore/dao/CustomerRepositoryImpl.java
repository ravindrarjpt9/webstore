package com.online.webstore.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.online.webstore.model.Customer;

@Repository
public class CustomerRepositoryImpl extends AbstractDao implements CustomerRepository{

	
	@Override
	public List<Customer> getAllCustomers() {

		return null;
	}
}
