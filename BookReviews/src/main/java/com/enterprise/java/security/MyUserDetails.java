//Assignment 3: Book Reviews App
//Sarah-Anne Green + Rongjun Zhang
//Purpose: Create a book review database and web application to manage the 
// books and reviews. Utilze ansynchronous requests, and implement security 
// to restrict access requiring user authentication.
//April 14, 2026

package com.enterprise.java.security;

import java.util.Arrays;
import java.util.Collection;

import org.springframework.context.annotation.Bean;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data

//MyUserDetails class implements UserDetails interface to provide user 
// information to Spring Security - this is who is registed to access the 
// restricted pages in the application, specifically addBook
public class MyUserDetails implements UserDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	private String username;
	private String password;
	private String roles;
	
	private boolean accountNonExpired = true;
	private boolean accountNonLocked = true;
	private boolean credentialsNonExpired = true;
	private boolean enabled = true;
	
	@Bean
	public PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}
	
	@Override
	public String getPassword(){
		return passwordEncoder().encode(password);
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities(){
		SimpleGrantedAuthority authority = new SimpleGrantedAuthority(roles);
		return Arrays.asList(authority);
	}

}//end of MyUserDetails class