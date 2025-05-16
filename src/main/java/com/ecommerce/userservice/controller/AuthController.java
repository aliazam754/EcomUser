package com.ecommerce.userservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ecommerce.userservice.dto.LoginRequestDTO;
import com.ecommerce.userservice.dto.UserRequestDTO;
import com.ecommerce.userservice.service.UserService;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/register")
	public ResponseEntity<String> registerUser(
			@RequestBody UserRequestDTO userRequest
			){
		
		  String result = userService.registerUser(userRequest);
	      return ResponseEntity.ok(result);
		
	}
	@PostMapping("/login")
	public ResponseEntity<String> loginUser(
			@RequestBody LoginRequestDTO loginRequest
			) {
		
	    String result = userService.loginUser(loginRequest);
	    return ResponseEntity.ok(result);
	}


}
