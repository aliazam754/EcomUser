package com.ecommerce.userservice.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.userservice.model.User;

public interface UserRepository extends JpaRepository< User, Long> {
	
 Optional<User> findByUsername(String username);
}