package com.isaachome.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.isaachome.config.security.authentication.filters.CustomAuthenticationFilter;

import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class SecurityConfig {

	private final CustomAuthenticationFilter customAuthenticationFilter;
	
	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http)throws Exception {
		return http
				.addFilterAt(customAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
				.authorizeRequests()
				.anyRequest()
				.authenticated()
				.and()
				.build();
	}
}
