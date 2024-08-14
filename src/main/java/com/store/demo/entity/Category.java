package com.store.demo.entity;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
@SuppressWarnings("serial")
@Data
@Entity 
@Table(name = "Categories")
public class Category implements Serializable{

	@Id
	@Column(name = "Id")
	private String id;

	@Column(name = "Name")
	private String name;

	@JsonIgnore
	@OneToMany(mappedBy = "category")
	private List<Product> products;
	
}
