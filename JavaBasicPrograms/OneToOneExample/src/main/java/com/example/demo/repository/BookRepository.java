package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.Book;



public interface BookRepository  extends JpaRepository<Book, String>  {
	 public Book findByBookId(int bookId);
	    
	    @Query("select b from Book b")
	    public List<Book> getAllBook();
	    
	    @Query("select b from Book b where book_name=:n")
	public List<Book> getBookByBookName(@Param("n") String book_name);

	    @Query("select b from Book b where book_name=:n or id=:p")
	    public List<Book> getBookByBookNameOrId(@Param("n") String book_name,@Param("p") int id);
	    
	    @Query(value="select * from book where book_name=:n",nativeQuery = true)
	    public List<Book> getAll(@Param("n") String e);
	    
}




