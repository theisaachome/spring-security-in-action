package com.isaachome.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.isaachome.entity.User;

public interface UserRepo extends JpaRepository<User, Long> {

    Optional<User> findUserByUsername(String username);
}
