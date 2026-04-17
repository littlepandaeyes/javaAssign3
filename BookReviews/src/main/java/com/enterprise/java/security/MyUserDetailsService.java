//Assignment 3: Book Reviews App
//Sarah-Anne Green + Rongjun Zhang
//Purpose: Create a book review database and web application to manage the 
// books and reviews. Utilze ansynchronous requests, and implement security 
// to restrict access requiring user authentication.
//April 14, 2026

package com.enterprise.java.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

//The service class for MyUserDetails, manages the retrival of the username and thus user
public class MyUserDetailsService implements UserDetailsService{
	@Autowired
	private MyUserDetailsRepository myUserDetailsRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
		MyUserDetails mud = myUserDetailsRepository.findByUsername(username);
		
		if(mud == null) throw new UsernameNotFoundException("User not found");
		
		return mud;
	}
}//end of MyUserDetailsService class
