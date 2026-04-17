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

import com.enterprise.java.data.ReviewRepository;
import com.enterprise.java.models.Review;

@Service	

//Service class to handle business logic related to reviews
public class ReviewService {

	@Autowired
	private ReviewRepository reviewRepository;
	
	@Autowired
	private NamedParameterJdbcTemplate jdbc;
	
	public Review saveReview(Review review) {
		return reviewRepository.save(review);
	}
	
	public List<Review> getAllReviews() {
		return (List<Review>)reviewRepository.findAll();
	}
	
	public Optional<Review> getReview(int id){
		return reviewRepository.findById(id);
	}
	
	public void deleteReview(int id) {
		reviewRepository.deleteById(id);
	}
}//end of review service class
