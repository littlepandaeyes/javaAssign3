//Assignment 3: Book Reviews App
//Sarah-Anne Green + Rongjun Zhang
//Purpose: Create a book review database and web application to manage the 
// books and reviews. Utilze ansynchronous requests, and implement security 
// to restrict access requiring user authentication.
//April 14, 2026

package com.enterprise.java.data;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.enterprise.java.models.Review;

//Review repository interface uses JPA to provide CRUD operations
@Repository
public interface ReviewRepository extends JpaRepository<Review, Integer> {
    List<Review> findByBookId(int bookId);
}
