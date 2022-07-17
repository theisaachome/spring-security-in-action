package com.isaachome.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import com.isaachome.security.providers.OtpAuthenticationProvider;
import com.isaachome.security.providers.UsernamePasswordAuthProvider;

//@Configuration
//@EnableWebSecurity 
public class SecurityConfiguration {
	
//	
//	@Autowired
//	private UsernamePasswordAuthProvider usernamePasswordAuthProvider;
//	@Autowired
//	private OtpAuthenticationProvider otpAuthenticationProvider;
//	@Autowired
//	private  UsernamePasswordAuthenticationFilter usernamePasswordAuthenticationFilter;
//	
//	@Bean
//	SecurityFilterChain securityFilterChain(HttpSecurity http)throws Exception {
//	
//		return http.addFilterAt(usernamePasswordAuthenticationFilter, BasicAuthenticationFilter.class).build();
//	}
//	
//	  @Bean
//	    AuthenticationManager authenticationManager(AuthenticationManagerBuilder auth) throws Exception {
//	        return auth
//	        		.authenticationProvider(usernamePasswordAuthProvider)
//	        		.authenticationProvider(otpAuthenticationProvider)
//	        		.build();
//	    }

}
