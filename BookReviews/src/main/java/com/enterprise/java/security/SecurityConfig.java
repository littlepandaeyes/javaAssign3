package com.enterprise.java.security;

import org.springframework.boot.security.autoconfigure.web.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public InMemoryUserDetailsManager userDetailsService() {
		UserDetails bob = User.withUsername("bob")
		.password(passwordEncoder().encode("pass"))
		.roles("USER")
		.build();
		UserDetails amy = User.withUsername("amy")
		.password(passwordEncoder().encode("pass"))
		.roles("ADMIN")
		.build();
		return new InMemoryUserDetailsManager(bob, amy);
	}
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http)
	throws Exception {
		http.authorizeHttpRequests(auth -> auth
		.requestMatchers("/").permitAll() // index is not authenticated
		.requestMatchers(PathRequest.toH2Console()).permitAll()
		.anyRequest().authenticated())
		.httpBasic(Customizer.withDefaults())
		.formLogin(Customizer.withDefaults());
		http.csrf((csrf) -> csrf.disable());
		http.headers((headers) -> headers.frameOptions((frame) -> frame.sameOrigin()));
		return http.build();
	}
}
