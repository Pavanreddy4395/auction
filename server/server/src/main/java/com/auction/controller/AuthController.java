package com.auction.controller;

import com.auction.dto.AuthRequest;
import com.auction.dto.AuthResponse;
import com.auction.dto.RegisterRequest;
import com.auction.model.User;
import com.auction.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
public class AuthController {

    private final UserRepository userRepo;

    @PostMapping("/register")
    public String register(@RequestBody RegisterRequest request) {
        if (userRepo.findByEmail(request.getEmail()).isPresent()) {
            return "Email already exists.";
        }
        User user = new User();
        user.setUsername(request.getUsername());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword()); // Plain text password
        userRepo.save(user);
        return "Registered successfully.";
    }

    @PostMapping("/login")
    public AuthResponse login(@RequestBody AuthRequest request) {
        Optional<User> user = userRepo.findByEmail(request.getEmail());
        if (user.isPresent() && request.getPassword().equals(user.get().getPassword())) {
            return new AuthResponse("success");
        }
        return new AuthResponse("failure");
    }
}
