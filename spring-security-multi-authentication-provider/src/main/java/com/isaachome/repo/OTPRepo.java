package com.isaachome.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.isaachome.entity.OTP;

public interface OTPRepo extends JpaRepository<OTP, Long > {

}
