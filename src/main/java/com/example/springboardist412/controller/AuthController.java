package com.example.springboardist412.controller;

import com.example.springboardist412.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@RestController
public class AuthController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public Map<String, String> register(@RequestBody Map<String, String> body) {
        String username = body.get("username");
        String password = body.get("password");
        String result = userService.registerUser(username, password);
        return Collections.singletonMap("message", result);
    }

    @PostMapping("/login")
    public Map<String, String> login(@RequestBody Map<String, String> body) {
        String username = body.get("username");
        String password = body.get("password");
        String result = userService.loginUser(username, password);
        return Collections.singletonMap("message", result);
    }
}