package com.luv2code.springdemo.controller;

import java.util.List;

import com.luv2code.springdemo.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.luv2code.springdemo.entity.Customer;
import com.luv2code.springdemo.service.CustomerService;

import javax.annotation.PostConstruct;

@Controller
@RequestMapping("/product")
public class ProductController {

    // need to inject our customer service
    @Autowired
    private CustomerService customerService;

    @GetMapping("/list")
    public String listProducts(Model theModel) {

        // get customers from the service
        List<Product> theProducts = customerService.getProducts();

        // add the customers to the model
        theModel.addAttribute("products", theProducts);

        return "list-products";
    }


}










