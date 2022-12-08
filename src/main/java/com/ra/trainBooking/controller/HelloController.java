package com.ra.trainBooking.controller;

import com.ra.trainBooking.DTO.UserRegisteredDTO;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hello")
public class HelloController {
    @GetMapping("/showUserInfo")
    public String showUserInfo() {
        return "Hello";
    }
}

