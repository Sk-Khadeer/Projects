package com.example.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "story")
public class Story {

    @Id
    @GeneratedValue
    private int storyId;
    @Column(name = "story_name")
    private String storyName;
    @Column(name = "rating")
    private Integer rating;
    public Integer getRating() {
		return rating;
	}
	public void setRating(Integer rating) {
		this.rating = rating;
	}
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "book_id")
    @JsonBackReference
    private Book book;
    public int getStoryId() {
        return storyId;
    }
    public void setStoryId(int storyId) {
        this.storyId = storyId;
    }
    public String getStoryName() {
        return storyName;
    }
    public void setStoryName(String storyName) {
        this.storyName = storyName;
    }
    public Book getBook() {
        return book;
    }
    public void setBook(Book book) {
        this.book = book;
    }
}