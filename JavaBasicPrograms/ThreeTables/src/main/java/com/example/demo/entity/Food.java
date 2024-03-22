package com.example.demo.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Data
public class Food {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
private long id;
	private String food_name;
	private String type;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn
	private Company company;
	@JsonIgnore
	@OneToMany(targetEntity = Sale.class,cascade = CascadeType.ALL)
	private Set<Sale> sales;
}
