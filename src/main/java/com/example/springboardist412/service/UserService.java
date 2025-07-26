package com.example.springboardist412.service;

import com.example.springboardist412.model.User;
import com.example.springboardist412.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public String registerUser(String username, String password) {
        if (userRepository.findByUsername(username) != null) {
            return "Username already exists";
        }
        String hashedPassword = passwordEncoder.encode(password);
        userRepository.save(new User(username, hashedPassword));
        return "User registered successfully";
    }

    public String loginUser(String username, String password) {
        User user = userRepository.findByUsername(username);
        if (user != null && passwordEncoder.matches(password, user.getPassword())) {
            return "Login successful";
        }
        return "Invalid username or password";
    }
}
