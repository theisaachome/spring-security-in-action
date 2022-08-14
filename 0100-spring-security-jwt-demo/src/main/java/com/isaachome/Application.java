package com.isaachome;

import java.util.ArrayList;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.isaachome.domain.Role;
import com.isaachome.domain.User;
import com.isaachome.service.UserService;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	PasswordEncoder passwordEncoder() {
		return new  BCryptPasswordEncoder();
	}
	@Bean
	CommandLineRunner commandLineRunner(UserService userService) {
		return arg->{
			userService.saveRole(new Role(null,"ROLE_USER"));
			userService.saveRole(new Role(null,"ROLE_ADMIN"));
			userService.saveRole(new Role(null,"ROLE_MANAGER"));
			userService.saveRole(new Role(null,"ROLE_SUPER_ADMIN"));
			
			
			userService.saveUser(new User(null,"John Petrucci","john","12345",new ArrayList<>()));
			userService.saveUser(new User(null,"Paul Giblert","paul","12345",new ArrayList<>()));
			userService.saveUser(new User(null,"Andy James","james","12345",new ArrayList<>()));
			userService.saveUser(new User(null,"Lari Basilio","lari","12345",new ArrayList<>()));
			
			userService.addRoleToUser("john", "ROLE_USER");
			userService.addRoleToUser("paul", "ROLE_ADMIN");
			userService.addRoleToUser("james", "ROLE_MANAGER");
			userService.addRoleToUser("lari", "ROLE_SUPER_ADMIN");
			
		};
	}
}
