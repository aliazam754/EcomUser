package com.ecommerce.userservice.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.ecommerce.userservice.dto.LoginRequestDTO;
import com.ecommerce.userservice.dto.UserRequestDTO;
import com.ecommerce.userservice.model.User;
import com.ecommerce.userservice.repository.UserRepository;
import com.ecommerce.userservice.util.JwtUtil;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private JwtUtil jwtUtil;

	
	private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	
	public String registerUser(UserRequestDTO userRequest) {
		User user = new User ();
		user.setUsername(userRequest.getUsername());
		user.setEmail(userRequest.getEmail());
		user.setPassword(passwordEncoder.encode(userRequest.getPassword()));
		user.setRole("ROLE_USER");
		userRepository.save(user);
		return "User Registration Successfully";
		
	}
	
	 public String loginUser(LoginRequestDTO loginRequest) {
	        Optional<User> optionalUser = userRepository.findByUsername(loginRequest.getUsername());

	        if (!optionalUser.isPresent()) {
	            return "User not found!";
	        }

	        User user = optionalUser.get();

	        boolean passwordMatch = passwordEncoder.matches(loginRequest.getPassword(), user.getPassword());

	        if (!passwordMatch) {
	            return "Invalid password!";
	        }

	        // Generate and return JWT token
	        return jwtUtil.generateToken(user.getUsername());
	}

}
