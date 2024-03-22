package com.example.demo.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
@Entity
@Data
public class Country {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
private Integer id;
private String countryName;
private String countryCode;
@JsonIgnore
@OneToMany

private Set<City> cities;
}
