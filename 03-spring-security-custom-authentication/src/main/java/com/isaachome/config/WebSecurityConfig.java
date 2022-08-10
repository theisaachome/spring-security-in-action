package com.isaachome.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.isaachome.security.filters.CustomAuthenticationFilter;

import lombok.AllArgsConstructor;

@Configuration
@AllArgsConstructor
public class WebSecurityConfig {

	private final CustomAuthenticationFilter filter;
	
	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http)throws Exception {
		return http.
				addFilterAt(filter,UsernamePasswordAuthenticationFilter.class)
				.authorizeRequests().anyRequest().authenticated()
				.and()
				.build();
	}
}
