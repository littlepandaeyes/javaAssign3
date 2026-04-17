//Assignment 3: Book Reviews App
//Sarah-Anne Green + Rongjun Zhang
//Purpose: Create a book review database and web application to manage the 
// books and reviews. Utilze ansynchronous requests, and implement security 
// to restrict access requiring user authentication.
//April 14, 2026

package com.enterprise.java.security;

import org.springframework.data.jpa.repository.JpaRepository;

//MyUserDeatails Repository uses JPA, can find user by username
public interface MyUserDetailsRepository extends JpaRepository<MyUserDetails, Integer>{
	public MyUserDetails findByUsername(String username);
}