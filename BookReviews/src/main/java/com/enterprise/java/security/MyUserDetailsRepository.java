package com.enterprise.java.security;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MyUserDetailsRepository extends JpaRepository<MyUserDetails, Integer>{
	public MyUserDetails findByUsername(String username);
}