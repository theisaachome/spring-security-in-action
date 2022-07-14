package com.isaachome.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.provisioning.JdbcUserDetailsManager;

@Configuration
public class ProjectConfig extends WebSecurityConfigurerAdapter  {

	@Bean
	protected
	JdbcUserDetailsManager userDetailsService() {
		return new JdbcUserDetailsManager(dataSource());
	}

	
	@Bean
	DataSource dataSource() {
		var dataSource = new DriverManagerDataSource();
		dataSource.setUrl("jdbc:mysql://localhost:3306/springsecuritydb");
		dataSource.setUsername("root");
		dataSource.setPassword("root");
		
		return dataSource;
	}


	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.httpBasic();
		
		http.csrf().disable();
		
		http.authorizeRequests()
		.mvcMatchers("/user").permitAll()
		.anyRequest().authenticated();
		
	}
	
}
