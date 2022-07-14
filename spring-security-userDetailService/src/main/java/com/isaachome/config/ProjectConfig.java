package com.isaachome.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.isaachome.service.JPAUserDetailsService;

@Configuration
public class ProjectConfig {

	@Bean
	UserDetailsService userDetailsService() {
		return new JPAUserDetailsService();
	}

	@Bean
	PasswordEncoder passwordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}
}
