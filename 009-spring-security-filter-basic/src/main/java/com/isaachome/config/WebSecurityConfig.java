package com.isaachome.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import com.isaachome.filters.AuthenticationLoggingFilter;
import com.isaachome.filters.RequestValidationFilter;

@Configuration
public class WebSecurityConfig {

	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

		return http
				.addFilterBefore(
					new RequestValidationFilter(),
					BasicAuthenticationFilter.class)
				.addFilterAfter(
					new AuthenticationLoggingFilter(),
					BasicAuthenticationFilter.class)
				.authorizeHttpRequests()
				.anyRequest()
				.permitAll()
				.and()
				.build();
	}
}
