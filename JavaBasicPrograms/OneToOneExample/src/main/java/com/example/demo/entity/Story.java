package com.example.demo.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import javax.persistence.OneToOne;



import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Data;
@Data
@Entity

public class Story  {

    @Id
    @GeneratedValue
    private int storyId;
    @Column(name = "story_name")
    private String storyName;
    @Column(name = "rating")
    private Integer rating;
   
	@OneToOne(cascade = CascadeType.ALL)
	
		@JsonBackReference
    private Book book;
    
}