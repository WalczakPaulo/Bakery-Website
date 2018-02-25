package com.luv2code.springdemo.dao;

import com.luv2code.springdemo.entity.OrderOfCustomer;

import java.util.List;

public interface OrderOfCustomerDAO {

    public List<OrderOfCustomer> getOrders();

    public void saveOrderOfCustomer(OrderOfCustomer theOrder);

}
