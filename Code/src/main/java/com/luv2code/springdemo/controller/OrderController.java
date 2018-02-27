package com.luv2code.springdemo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.luv2code.springdemo.OrderHelper;
import com.luv2code.springdemo.entity.OrderItem;
import com.luv2code.springdemo.entity.OrderOfCustomer;
import com.luv2code.springdemo.entity.Product;
import com.luv2code.validation.CourseCode;
import com.luv2code.validation.CourseCodeConstraintValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.NumberUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import com.luv2code.springdemo.entity.Customer;
import com.luv2code.springdemo.service.CustomerService;

import javax.annotation.PostConstruct;
import javax.validation.Valid;

@Controller
@RequestMapping("/order")
public class OrderController {

    // need to inject our customer service
    @Autowired
    private CustomerService customerService;

    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }


    @GetMapping("list")
    public String listOrders(Model theModel) {

        // get customers from the service

        List<OrderOfCustomer> theOrders = customerService.getOrders();

        for(OrderOfCustomer order: theOrders) {
            int tempSum = 0;
            List<OrderItem> orderItems = order.getOrderedItems();
            for(OrderItem orderItem: orderItems)
                tempSum = orderItem.getProduct().getPrice() * orderItem.getQuantity();
            order.setOrderValue(tempSum);
        }

        theModel.addAttribute("orders", theOrders);
        return "list-orders";
    }

    @GetMapping("/make")
    public String makeOrder(Model theModel) {

        // get customers from the service
        OrderOfCustomer newOrder = new OrderOfCustomer();

        List<Customer> theCustomers = customerService.getCustomers();
        List<Product> theProducts = customerService.getProducts();
        OrderHelper orderHelper = new OrderHelper();

        theModel.addAttribute("order", newOrder);
        theModel.addAttribute("products", theProducts);
        theModel.addAttribute("customers", theCustomers);
        theModel.addAttribute("orderHelper", orderHelper);

        return "order-form";
    }

    @PostMapping("/saveOrder")
    public String saveCustomer(@Valid @ModelAttribute("orderHelper") OrderHelper theOrderHelper, BindingResult theBindingResult) {

        if (theBindingResult.hasErrors()) {
            return "order-form-error";
        }

        List<Integer> quantities = new ArrayList<Integer>();
        for(String s : theOrderHelper.getQuantities())
            quantities.add(Integer.valueOf(s));
        Customer theCustomer = customerService.getCustomer(theOrderHelper.getCustomer_id());
        OrderOfCustomer theOrder = new OrderOfCustomer();
        int chosenProductId = 1;
        for(int quantity: quantities) {
            if(quantity != 0) {
                Product tempProduct = customerService.getProduct(chosenProductId);
                OrderItem tempOrderItem = new OrderItem(tempProduct, quantity);
                theOrder.addOrderItem(tempOrderItem);
            }
            chosenProductId += 1;
        }
        // save the customer using our service
        theCustomer.addOrder(theOrder);
        customerService.saveCustomer(theCustomer);

        return "redirect:/customer/list";
    }




}










