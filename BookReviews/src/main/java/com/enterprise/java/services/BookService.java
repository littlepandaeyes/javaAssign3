//Assignment 3: Book Reviews App
//Sarah-Anne Green + Rongjun Zhang
//Purpose: Create a book review database and web application to manage the 
// books and reviews. Utilze ansynchronous requests, and implement security 
// to restrict access requiring user authentication.
//April 14, 2026

package com.enterprise.java.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

import com.enterprise.java.data.BookRepository;
import com.enterprise.java.models.Book;

@Service

//Service class to handle business logic related to books
public class BookService {

	@Autowired
	private BookRepository bookRepository;
	
	@Autowired
	private NamedParameterJdbcTemplate jdbc;
	
	public Book saveBook(Book book) {
		return bookRepository.save(book);
	}
	
	public List<Book> getAllBooks() {
		return (List<Book>)bookRepository.findAll();
	}
	
	public Optional<Book> getBook(int id){
		return bookRepository.findById(id);
	}

	public void deleteBook(int id) {
		bookRepository.deleteById(id);
	}
	
}//end of book service class
