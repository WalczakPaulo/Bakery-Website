package com.luv2code.springdemo.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="customer")
public class Customer {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="email")
	private String email;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "customer", orphanRemoval = true, cascade = CascadeType.ALL)
	private List<OrderOfCustomer> orders;

	public List<OrderOfCustomer> getOrders() {
		return orders;
	}

	public void setOrders(List<OrderOfCustomer> orders) {
		this.orders = orders;
	}

	public Customer() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + "]";
	}

	public void addOrder(OrderOfCustomer order) {
		if(orders == null) {
			orders = new ArrayList<>();
		}

		orders.add(order);

		order.setCustomer(this);
	}
		
}





