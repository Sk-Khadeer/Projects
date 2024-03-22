package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.entity.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, String> {
    public Book findByBookId(int bookId);
    
    @Query("select b from Book b")
    public List<Book> getAllBook();
    
    @Query("select b from Book b where book_name=:n")
public List<Book> getBookByBookName(@Param("n") String book_name);

    @Query("select b from Book b where book_name=:n or id=:p")
    public List<Book> getBookByBookNameOrId(@Param("n") String book_name,@Param("p") int id);

    @Query(value="select * from Book ",nativeQuery = true)
    public List<Book> getAll();
    
}



