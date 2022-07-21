package com.isaachome.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.isaachome.entity.Token;

public interface JpaTokenRepo extends JpaRepository<Token, Integer> {

	Optional<Token> findTokenByIdentifier(String identifier);
}
