package com.POJOS;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class OrderHeader {
		
	@Id
	@GeneratedValue
	int OrderID;
	
	@Column
	Date orderDate;
	
	@ManyToOne
	@JoinColumn(name="CustomerID") 	
	Customer customer;
	
    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(name="OrderItem", 
                joinColumns={@JoinColumn(name="OrderID")},     
                inverseJoinColumns={@JoinColumn(name="ProductID")})
    Set<Product> products = new HashSet<Product>();	
	
	@OneToOne(mappedBy = "orderheader")
	 Shipment shipment;    
    
	 public Set<Product> getProducts() {
		return products;
	}
	public void setProducts(Set<Product> products) {
		this.products = products;
	}
    
	public int getOrderID() {
		return OrderID;
	}
	public void setOrderID(int orderID) {
		OrderID = orderID;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
							
}
