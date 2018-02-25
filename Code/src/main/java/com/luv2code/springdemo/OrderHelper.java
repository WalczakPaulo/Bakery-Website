package com.luv2code.springdemo;

import com.luv2code.validation.CourseCode;
import org.springframework.stereotype.Component;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.List;

public class OrderHelper {

    private int id;

    private int customer_id;
    private List<Integer> products_id;

    @CourseCode(value = "0", message = "You have commited an error")
    private List<String> quantities;

    public OrderHelper() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public List<Integer> getProducts_id() {
        return products_id;
    }

    public void setProducts_id(List<Integer> products_id) {
        this.products_id = products_id;
    }

    public List<String> getQuantities() {
        return quantities;
    }

    public void setQuantities(List<String> quantities) {
        this.quantities = quantities;
    }
}
