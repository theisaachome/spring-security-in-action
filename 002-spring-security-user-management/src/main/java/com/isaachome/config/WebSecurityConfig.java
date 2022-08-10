package com.isaachome.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class WebSecurityConfig {

	 @Bean
	   PasswordEncoder passwordEncoder() {
	    return NoOpPasswordEncoder.getInstance(); // should not use this in a prod app => BCryptPasswordEncoder
	  }

}
