package com.enterprise.java.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class MyUserDetailsService implements UserDetailsService{
	@Autowired
	private MyUserDetailsRepository myUserDetailsRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
		MyUserDetails mud = myUserDetailsRepository.findByUsername(username);
		
		if(mud == null) throw new UsernameNotFoundException("User not found");
		
		return mud;
	}
}
