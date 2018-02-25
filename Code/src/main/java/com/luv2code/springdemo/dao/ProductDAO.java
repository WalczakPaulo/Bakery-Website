package com.luv2code.springdemo.dao;

import com.luv2code.springdemo.entity.Product;

import java.util.List;

public interface ProductDAO {

    public List<Product> getProducts();

    public Product getProduct(int theID);

}
