package com.isaachome.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.csrf.CsrfFilter;
import org.springframework.security.web.csrf.CsrfTokenRepository;

import com.isaachome.csrf.CustomCsrfTokenRepository;
import com.isaachome.filters.CustomCsrfTokenFilter;

@Configuration
public class ProjectConfig  extends WebSecurityConfigurerAdapter{

	@Bean
	CsrfTokenRepository csrfTokenRepository() {
		return new CustomCsrfTokenRepository();
	}
	@Override
	protected void configure(HttpSecurity http) throws Exception {

		 http.addFilterAfter(new CustomCsrfTokenFilter(), CsrfFilter.class);
		 
		 http.csrf((c)->{
			 c.csrfTokenRepository(csrfTokenRepository());
			 c.ignoringAntMatchers("/api/v1/ciao");
		 });
		 
		 http.authorizeRequests().anyRequest().permitAll();
	}

	
}
