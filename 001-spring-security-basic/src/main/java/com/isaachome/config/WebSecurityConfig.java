package com.isaachome.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class WebSecurityConfig {

	@Bean
	UserDetailsService userDetailsService() {
		
		var uds = new InMemoryUserDetailsManager();
		var user = User.withUsername("bill")
				.password("12345")
				.authorities("read")
				.build();
		
		uds.createUser(user);
		
		return uds;
	}
	
	@Bean
	PasswordEncoder passwordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}
}
