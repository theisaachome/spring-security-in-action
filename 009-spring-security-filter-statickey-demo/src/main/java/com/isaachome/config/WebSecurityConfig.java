package com.isaachome.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import com.isaachome.filters.StaticKeyAuthenticationFilter;

@Configuration
public class WebSecurityConfig {
	
	@Autowired
	private StaticKeyAuthenticationFilter filter;
	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http)throws Exception{
		return http
				.addFilterAt(
				filter,
				BasicAuthenticationFilter.class)
				.build();
	}
}
