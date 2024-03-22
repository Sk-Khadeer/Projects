package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Book;
import com.example.demo.entity.Story;
import com.example.demo.repository.BookRepository;

@Service
public class BookService {
	@Autowired
	 private BookRepository bookRepository;

	    public Book saveBook(Book book)
	    {
	        Story story = book.getStory();
	        book.setStory(story);
	        book = bookRepository.save(book);
	        return book;
	        }
}
