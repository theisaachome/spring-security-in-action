package com.isaachome.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class UserManagementConfig {

	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	@Bean
	UserDetailsService userDetailsService() {
		var userService = new InMemoryUserDetailsManager();
		var user = User.withUsername("mary")
				.password(passwordEncoder().encode("12345"))
				.authorities("READ")
				.build();
		userService.createUser(user);
		return userService;
				
	}
	
}
