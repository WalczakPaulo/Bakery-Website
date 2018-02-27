package com.luv2code.springdemo.entity;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="order_of_customer")
public class OrderOfCustomer {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name="customer_id", updatable = false)
    private Customer customer;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "orderOfCustomer", cascade =  CascadeType.ALL)
    private List<OrderItem> orderedItems;

    @Transient
    private int orderValue;

    public OrderOfCustomer() {

    }

    public OrderOfCustomer(Customer customer) {
        this.customer = customer;
    }

    public OrderOfCustomer(Customer customer, List<OrderItem> orderedItems, int orderValue) {
        this.customer = customer;
        this.orderedItems = orderedItems;
        this.orderValue = orderValue;
    }

    public int getOrderValue() {
        return orderValue;
    }

    public void setOrderValue(int orderValue) {
        this.orderValue = orderValue;
    }

    public List<OrderItem> getOrderedItems() {
        return orderedItems;
    }

    public void setOrderedItems(List<OrderItem> orderedItems) {
        this.orderedItems = orderedItems;
    }

    public void addOrderItem(OrderItem orderItem) {
        if(orderedItems == null) {
            orderedItems = new ArrayList<OrderItem>();
        }

        orderedItems.add(orderItem);
        orderItem.setOrderOfCustomer(this);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", customer=" + customer +
                '}';
    }
}





