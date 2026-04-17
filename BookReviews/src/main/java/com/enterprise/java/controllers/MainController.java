//Assignment 3: Book Reviews App
//Sarah-Anne Green + Rongjun Zhang
//Purpose: Create a book review database and web application to manage the 
// books and reviews. Utilze ansynchronous requests, and implement security 
// to restrict access requiring user authentication.
//April 14, 2026

package com.enterprise.java.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.enterprise.java.data.BookRepository;
import com.enterprise.java.data.ReviewRepository;
import com.enterprise.java.models.Book;
import com.enterprise.java.models.Review;

//Beginning of Controller class
@Controller
public class MainController {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private ReviewRepository reviewRepository;

    // Method to handle the home page request
    @RequestMapping("/")
    public String index(Model model) {
    	List<Book> allBooks = bookRepository.findAll();
        model.addAttribute("books", allBooks);
        return "index"; 
    }
    
    //Method to handle the restricted page request
    @RequestMapping("/confidential")
    public String confidential(Model model) {
        return "confidential"; 
    }

    //Method to handle the add book page request
    @RequestMapping("/book")
    public String showAddBookForm(Model model) {
        model.addAttribute("book", new Book());
        return "book";
    }

    //Method to handle the save book request
    @RequestMapping("/savebook")
    public String saveBook(Book book) {
        bookRepository.save(book);
        return "redirect:/"; // redirect to index when finished
    }
    
    //Method to handle the book review page request
    //Creates a new review form and adds it to the repository
    @RequestMapping("/review/{id}")
    public String showBookReview(@PathVariable("id") int id, Model model) {
		Book book = bookRepository.findById(id).orElse(null);
        Review reviewForm = new Review();
        reviewForm.setBookId(id);
		model.addAttribute("book", book);
        model.addAttribute("reviewForm", reviewForm);
		return "review";
	}

    //Method to handle the book details request
    //Returns the book and its reviews as a JSON response, is an asyncchronous request
    //utilizing the reviewscript.js to fetch the data and update the page without a full reload
    @RequestMapping("/books/{id}/details")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> getBookDetails(@PathVariable("id") int id) {
        return bookRepository.findById(id)
                .map(book -> ResponseEntity.ok(Map.of(
                        "book", book,
                        "reviews", reviewRepository.findByBookId(id))))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }//load async details, no page reload

    //Method to handle the save review request
    @RequestMapping("/savereview")
    public String saveReview(@ModelAttribute("reviewForm") Review newReview) {
        reviewRepository.save(newReview);
        return "redirect:/"; // redirect to index when finished
    }
}//End of Controller class

//References:
//ResponseEntity (Spring Framework 7.0.6 API). (n.d.). 
//     https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/http/ResponseEntity.html
