package com.isaachome.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import com.isaachome.security.filter.CustomAuthenticationFilter;
import com.isaachome.security.provider.CustomAuthenticationProvider;

@Configuration
public class ProjectConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private CustomAuthenticationFilter filter;
	@Autowired
	private CustomAuthenticationProvider provider;
	
	@Override
	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(provider);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.addFilterAt(filter,BasicAuthenticationFilter.class);
		http.authorizeHttpRequests().anyRequest().permitAll();
	}

	
	
	
}
