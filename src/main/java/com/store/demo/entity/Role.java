package com.store.demo.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@SuppressWarnings("serial")
@Data
@Entity
@Table(name = "roles")
public class Role  implements Serializable {

	@Id
	@Column(name = "Id")
	private String id;

	@Column(name = "Name")
	private String name;

	@JsonIgnore
	@OneToMany(mappedBy = "role")
	List<Authority> authorities;
}