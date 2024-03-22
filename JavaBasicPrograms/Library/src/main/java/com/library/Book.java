package com.library;

public class Book {
private int id,cost,total_number_of_copies,available_copies;
private String book_name,author_name;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public int getCost() {
	return cost;
}
public void setCost(int cost) {
	this.cost = cost;
}
public int getTotal_number_of_copies() {
	return total_number_of_copies;
}
public void setTotal_number_of_copies(int total_number_of_copies) {
	this.total_number_of_copies = total_number_of_copies;
}
public int getAvailable_copies() {
	return available_copies;
}
public void setAvailable_copies(int available_copies) {
	this.available_copies = available_copies;
}
public String getBook_name() {
	return book_name;
}
public void setBook_name(String book_name) {
	this.book_name = book_name;
}
public String getAuthor_name() {
	return author_name;
}
public void setAuthor_name(String author_name) {
	this.author_name = author_name;
}


}
