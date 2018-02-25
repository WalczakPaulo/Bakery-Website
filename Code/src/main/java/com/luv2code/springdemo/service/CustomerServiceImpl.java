package com.luv2code.springdemo.service;

import java.util.List;

import com.luv2code.springdemo.dao.OrderOfCustomerDAO;
import com.luv2code.springdemo.dao.ProductDAO;
import com.luv2code.springdemo.entity.OrderOfCustomer;
import com.luv2code.springdemo.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.springdemo.dao.CustomerDAO;
import com.luv2code.springdemo.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {

	// need to inject customer dao
	@Autowired
	private CustomerDAO customerDAO;

	@Autowired
	private ProductDAO productDAO;

	@Autowired
	private OrderOfCustomerDAO orderOfCustomerDAO;

	@Override
	@Transactional
	public List<Customer> getCustomers() {
		return customerDAO.getCustomers();
	}

	@Override
	@Transactional
	public void saveCustomer(Customer theCustomer) {

		customerDAO.saveCustomer(theCustomer);
	}

	@Override
	@Transactional
	public Customer getCustomer(int theId) {
		
		return customerDAO.getCustomer(theId);
	}

	@Override
	@Transactional
	public Product getProduct(int theId) {

		return productDAO.getProduct(theId);
	}

	@Override
	@Transactional
	public void deleteCustomer(int theId) {
		
		customerDAO.deleteCustomer(theId);
	}

	@Override
	@Transactional
	public List<Customer> searchCustomers(String theSearchName) {
		return customerDAO.searchCustomers(theSearchName);
	}

	@Override
	@Transactional
	public List<Product> getProducts() {
		return productDAO.getProducts();
	}

	@Override
	@Transactional
	public List<OrderOfCustomer> getOrders() {
		return orderOfCustomerDAO.getOrders();
	}


	@Override
	@Transactional
	public void saveOrderOfCustomer(OrderOfCustomer theOrder) {
		orderOfCustomerDAO.saveOrderOfCustomer(theOrder);
	}
}





