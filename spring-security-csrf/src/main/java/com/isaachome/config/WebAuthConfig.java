package com.isaachome.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.csrf.CsrfFilter;

import com.isaachome.filters.CsrfTokenLogger;

@Configuration
public class WebAuthConfig extends WebSecurityConfigurerAdapter {


	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.addFilterAfter(
				new CsrfTokenLogger(), CsrfFilter.class);
		
		http
		.authorizeRequests()
		.anyRequest().authenticated();
		
		http.formLogin()
		.defaultSuccessUrl("/main",true);
	}
	
	
}
