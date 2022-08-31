package com.isaachome.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    UserDetailsService userDetailsService() {
        var uds = new InMemoryUserDetailsManager();
        var john = User.withUsername("john")
                .password(passwordEncoder().encode("12345"))
                .authorities("read")// --> GrantedAuthority interface
                .build();
        var bill = User.withUsername("bill")
        		.password(passwordEncoder().encode("12345"))
        		.authorities("write","delete")
        		.build();
        uds.createUser(john);
        uds.createUser(bill);
        return uds;
    }
	
	@Bean
	 PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	 SecurityFilterChain securityFilterChain(HttpSecurity http)throws Exception {
		return http
				.httpBasic()
				.and()
				.authorizeRequests()
//				.mvcMatchers("/api/students").hasAuthority("read")
//				.anyRequest().authenticated()
				.mvcMatchers("api/courses").hasAuthority("write")
				.anyRequest().authenticated()
				.and().build();
	}
}
