package com.luv2code.springdemo.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="product")
public class Product {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="product_name")
    private String productName;


    @Column(name="price")
    private int price;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private List<OrderItem> orderedBy;

    public Product() {

    }

    public List<OrderItem> getOrderedBy() {
        return orderedBy;
    }

    public void setOrderedBy(List<OrderItem> orderedBy) {
        this.orderedBy = orderedBy;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", productName='" + productName + '\'' +
                ", price=" + price +
                '}';
    }
}





