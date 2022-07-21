package com.isaachome.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.isaachome.entity.User;

public interface UserRepo extends JpaRepository<User, Long>{
	
	Optional<User> findUserByUsername(String username) throws UsernameNotFoundException;

}
