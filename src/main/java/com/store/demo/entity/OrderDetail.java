package com.store.demo.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import lombok.Data;

@SuppressWarnings("serial")
@Data
@Entity 
@Table(name = "Orderdetails")
public class OrderDetail  implements Serializable{

	@Id
	@Column(name = "Id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "Price")
	private Double price;

	@Column(name = "Quantity")
	private Integer quantity;

	@ManyToOne
	@JoinColumn(name = "Productid")
	private Product product;

	@ManyToOne
	@JoinColumn(name = "Orderid")
	private Order order;
}
