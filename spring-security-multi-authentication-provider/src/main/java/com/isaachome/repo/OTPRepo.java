package com.isaachome.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.isaachome.entity.Otp;

public interface OTPRepo extends JpaRepository<Otp, Long > {

	Optional<Otp> findOTPByUsername(String username);
}
