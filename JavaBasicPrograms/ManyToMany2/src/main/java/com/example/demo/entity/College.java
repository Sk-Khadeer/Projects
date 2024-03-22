package com.example.demo.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import lombok.Data;
@Data
@Entity
public class College {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String collegeName;

	@ManyToMany(mappedBy="college",cascade= {CascadeType.PERSIST,CascadeType.REFRESH},fetch = FetchType.LAZY)
	private Set<Course> courses;
}
