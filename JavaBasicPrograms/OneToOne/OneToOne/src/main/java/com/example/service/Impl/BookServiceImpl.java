package com.example.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Book;
import com.example.entity.Story;
import com.example.repository.BookRepository;

@Service
public class BookServiceImpl  {

    @Autowired
    private BookRepository bookRepository;

    public Book saveBook(Book book)
    {
        Story story = book.getStory();
        story.setBook(book);
        book = bookRepository.save(book);
        return book;
        }

    public Book findByBookId(int bookId) {
        Book book = bookRepository.findByBookId(bookId);
        return book;
    }
    public List<Book> getAllBook(){
    	return bookRepository.getAllBook();
    	}
    
    public List<Book> getBookByBookName(String book_name){
    	return bookRepository.getBookByBookName(book_name);
    	}

    public List<Book> getBookByBookNameOrId(String book_name,int id){
    	return bookRepository.getBookByBookNameOrId(book_name,id);
    	}
    
    public List<Book> getAll(){
    	return bookRepository.getAll();
    	}
}

	