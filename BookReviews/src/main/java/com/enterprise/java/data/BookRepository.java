//Assignment 3: Book Reviews App
//Sarah-Anne Green + Rongjun Zhang
//Purpose: Create a book review database and web application to manage the 
// books and reviews. Utilze ansynchronous requests, and implement security 
// to restrict access requiring user authentication.
//April 14, 2026

package com.enterprise.java.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.enterprise.java.models.Book;

//Book Repository interface, uses JPA to provide CRUD operations
@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
}