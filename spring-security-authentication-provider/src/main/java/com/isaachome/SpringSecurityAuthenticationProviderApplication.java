package com.isaachome;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@SpringBootApplication
public class SpringSecurityAuthenticationProviderApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityAuthenticationProviderApplication.class, args);
	}
	
	@Bean
	PasswordEncoder passwordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}

	@Bean
	protected UserDetailsService userDetailsService() {
		var uds = new InMemoryUserDetailsManager();
		var u = User.withUsername("john")
				.password("12345")
				.authorities("read")
				.build();
		
		uds.createUser(u);
		return uds;
	}
	
	
}
