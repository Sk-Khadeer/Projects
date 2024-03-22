package com.example.demo.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Data
public class Company {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private long id;
private String name;

@OneToMany(targetEntity = Food.class,cascade = CascadeType.ALL)
@JsonIgnore
private Set<Food> foods;
}
