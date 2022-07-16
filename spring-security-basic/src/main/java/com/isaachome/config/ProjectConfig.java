package com.isaachome.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class ProjectConfig {

	@Autowired
	private PasswordEncoder passwordEncoder;
    @Bean
    UserDetailsService userDetailsService() {
    	var u1 = User.withUsername("bill")
    			.password(passwordEncoder.encode("12345"))
    			.authorities("read")
    			.build();
    	
        return new InMemoryUserDetailsManager(u1);
    }
    
   
}
