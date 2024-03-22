package com.example.demo.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;


import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
@Data
@Entity
public class Course {


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String courseName;
	
	@ManyToMany(cascade= CascadeType.REFRESH,fetch = FetchType.LAZY)
@JoinTable(name="college_course",joinColumns = @JoinColumn(name="course_id"),
                                             inverseJoinColumns = @JoinColumn(name="college_id"))
@JsonIgnore
private Set<College> college;
}
