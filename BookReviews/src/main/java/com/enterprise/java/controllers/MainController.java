package com.enterprise.java.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.enterprise.java.data.BookRepository;
import com.enterprise.java.models.Book;

@Controller
public class MainController {

    @Autowired
    private BookRepository bookRepository;

    @RequestMapping("/")
    public String index(Model model) {
    	List<Book> allBooks = bookRepository.findAll();
        model.addAttribute("books", allBooks);
        return "index"; 
    }
    
    @RequestMapping("/confidential")
    public String confidential(Model model) {
        return "confidential"; 
    }

    @RequestMapping("/book")
    public String showAddBookForm(Model model) {
        model.addAttribute("book", new Book());
        return "book";
    }

    @RequestMapping("/savebook")
    public String saveBook(Book book) {
        bookRepository.save(book);
        return "redirect:/"; // redirect to index when finished
    }
    
    @RequestMapping("/review/{id}")
    public String showBookReview(@PathVariable("id") Long id, Model model) {
		Book book = bookRepository.findById(id).orElse(null);
		if (book != null) {
			model.addAttribute("book", book);
			return "review";
		} else {
			return "redirect:/"; // redirect to index if book not found
		}
	}
}
