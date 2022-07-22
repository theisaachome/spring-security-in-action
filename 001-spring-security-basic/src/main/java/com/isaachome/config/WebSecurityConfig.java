package com.isaachome.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class WebSecurityConfig {
	
	@Autowired
	private PasswordEncoder passwordEncoder;
    @Bean
    UserDetailsService userDetailsService() {
    	// override auto generate  user and password from console.
    	var uds = new InMemoryUserDetailsManager();
    	var billUser = User.withUsername("bill")
    			.password(passwordEncoder.encode("12345"))
    			.authorities("read")
    			.build();
    	uds.createUser(billUser);
    	
        return uds;
    }
    

}
