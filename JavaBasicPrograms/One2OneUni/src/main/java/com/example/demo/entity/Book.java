package com.example.demo.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.Data;
@Data
@Entity

public class Book {
	 @Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    private int bookId;
	    @Column(name = "book_name")
	    private String bookName;
	    @Column(name = "book_author")
	   private String author;
	    
		@OneToOne(cascade = CascadeType.ALL,targetEntity = Story.class)
		@JoinColumn(name="story_id")
	
	   private Story story;
	   
}
