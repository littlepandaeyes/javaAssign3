package com.enterprise.java.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.enterprise.java.models.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
}