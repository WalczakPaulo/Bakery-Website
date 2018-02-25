package com.luv2code.springdemo.entity;

import javax.persistence.*;

@Entity
@Table(name = "order_item")
public class OrderItem {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name="order_id")
    private OrderOfCustomer orderOfCustomer;


    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name="product_id")
    private Product product;

    @Column(name="quantity")
    private int quantity;

    public OrderItem() {

    }

    public OrderItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public OrderItem(OrderOfCustomer orderOfCustomer, Product product, int quantity) {
        this.orderOfCustomer = orderOfCustomer;
        this.product = product;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public OrderOfCustomer getOrderOfCustomer() {
        return orderOfCustomer;
    }

    public void setOrderOfCustomer(OrderOfCustomer orderOfCustomer) {
        this.orderOfCustomer = orderOfCustomer;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "OrderItem{" +
                "id=" + id +
                ", orderOfCustomer=" + orderOfCustomer +
                ", product=" + product +
                ", quantity=" + quantity +
                '}';
    }
}
