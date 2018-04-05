package com.online.webstore.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="CUSTOMER")
public class Customer {

	@Id
	@Column(name="CUSTOMER_ID")
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="SEQ_CUSTOMER")
	@SequenceGenerator(name="SEQ_CUSTOMER",sequenceName="SEQ_CUSTOMER")
	private int customerId;
	@Column(name="NAME")
	private String name;
	@Column(name="ADDRESS")
	private String address;
	@Column(name="NO_OF_ORDER_MADE")
	private int noOfOrderMade;
	
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getNoOfOrderMade() {
		return noOfOrderMade;
	}
	public void setNoOfOrderMade(int noOfOrderMade) {
		this.noOfOrderMade = noOfOrderMade;
	}
}
