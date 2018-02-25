package com.luv2code.springdemo.dao;

import com.luv2code.springdemo.entity.OrderItem;

import java.util.List;

public interface OrderItemDAO {

    public List<OrderItem> getOrderedItems();

}
