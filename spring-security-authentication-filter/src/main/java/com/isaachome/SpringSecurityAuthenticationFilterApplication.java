package com.isaachome;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.config.authentication.AuthenticationManagerFactoryBean;

@SpringBootApplication
public class SpringSecurityAuthenticationFilterApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityAuthenticationFilterApplication.class, args);
	}

	
}
