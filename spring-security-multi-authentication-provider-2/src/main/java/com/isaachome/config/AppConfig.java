package com.isaachome.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import com.isaachome.security.authentication.TokenAuthentication;
import com.isaachome.security.filters.TokenAuthFilter;
import com.isaachome.security.filters.UsernamePasswordAuthFilter;
import com.isaachome.security.providers.OtpAuthenticationProvider;
import com.isaachome.security.providers.TokenAuthProvider;
import com.isaachome.security.providers.UsernamePasswordAuthProvider;

@Configuration
public class AppConfig  extends WebSecurityConfigurerAdapter{

	

	@Autowired
	private UsernamePasswordAuthProvider usernamePasswordAuthProvider;
	
	@Autowired
	private OtpAuthenticationProvider otpAuthenticationProvider;

	
	@Autowired
	private TokenAuthProvider tokenAuthProvider;
	
	@Autowired
	private  UsernamePasswordAuthFilter usernamePasswordAuthFilter;
	
	@Autowired
	private TokenAuthFilter tokenAuthFilter;
	
	@Bean
	PasswordEncoder passwordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}

	@Override
	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception {
		
		return super.authenticationManagerBean();
	}
	
	public UsernamePasswordAuthFilter usernamePasswordAuthFilter() {
		return new UsernamePasswordAuthFilter();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	
		auth
		.authenticationProvider(usernamePasswordAuthProvider)
		.authenticationProvider(otpAuthenticationProvider)
		.authenticationProvider(tokenAuthProvider);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.addFilterAt(usernamePasswordAuthFilter,BasicAuthenticationFilter.class)
		.addFilterAfter(tokenAuthFilter, BasicAuthenticationFilter.class);
	}

	
	
	
}
