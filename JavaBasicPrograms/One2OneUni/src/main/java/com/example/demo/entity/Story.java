package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;
@Data
@Entity

public class Story {
	 @Id
	    @GeneratedValue
	    private int storyId;
	    @Column(name = "story_name")
	    private String storyName;
	    @Column(name = "rating")
	    private Integer rating;
}
