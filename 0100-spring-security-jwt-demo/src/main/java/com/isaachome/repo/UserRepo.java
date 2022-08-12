package com.isaachome.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.isaachome.domain.User;

public interface UserRepo extends JpaRepository<User, Long>{

	User findByUsername(String username);
}
