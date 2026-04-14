package com.enterprise.java.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.enterprise.java.data.BookRepository;
import com.enterprise.java.models.Book;

@Controller
public class MainController {

    @Autowired
    private BookRepository bookRepository;

    @RequestMapping("/")
    public String index(Model model) {
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
        return "redirect:/";
    }
}
