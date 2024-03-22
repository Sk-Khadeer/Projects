package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Book;

import com.example.service.Impl.BookServiceImpl;

@RestController

@RequestMapping(value = "/book")
public class BookController {


    @Autowired
    private BookServiceImpl bookService;
    @PostMapping( "/savebook")
     public Book saveBook(@RequestBody Book book) {
        Book bookResponse = bookService.saveBook(book);
        return bookResponse;
    }
    @GetMapping("/{bookId}")
    public Book getBookDetails(@PathVariable int bookId) {
        Book bookResponse = bookService.findByBookId(bookId);
        return bookResponse;
    }
    @GetMapping("/getAll")
    public List<Book> getAllBook(){
    	return bookService.getAllBook();
    	
    }
    
    @GetMapping("/getAll/{book_name}")
    public List<Book> getBookByBookName(@PathVariable String book_name){
    	return bookService.getBookByBookName(book_name);
    }
    @GetMapping("/getAll/{book_name}/{id}")
     public List<Book> getBookByBookNameOrId(@PathVariable String book_name,@PathVariable int id){
    	return bookService.getBookByBookNameOrId(book_name, id);
    	
    }
    
    @GetMapping("/getAllBooks")
    public List<Book> getBook(){
    	return bookService.getAll();
    	
    }
}

