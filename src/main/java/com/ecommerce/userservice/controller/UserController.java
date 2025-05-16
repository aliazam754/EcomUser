package com.ecommerce.userservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @GetMapping("/api/user/profile")
    public String getUserProfile() {
        return "This is a protected user profile info.";
    }
}
