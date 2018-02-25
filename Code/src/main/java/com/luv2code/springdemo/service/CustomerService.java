package com.luv2code.springdemo.service;

import java.util.List;

import com.luv2code.springdemo.entity.Customer;
import com.luv2code.springdemo.entity.OrderOfCustomer;
import com.luv2code.springdemo.entity.Product;
import org.springframework.transaction.annotation.Transactional;

public interface CustomerService {

	public List<Customer> getCustomers();

	public void saveCustomer(Customer theCustomer);

	public Customer getCustomer(int theId);

	public void deleteCustomer(int theId);

	public List<Customer> searchCustomers(String theSearchName);

	public List<Product> getProducts();

	public Product getProduct(int theID);

	public List<OrderOfCustomer> getOrders();

	public void saveOrderOfCustomer(OrderOfCustomer theOrder);
}
