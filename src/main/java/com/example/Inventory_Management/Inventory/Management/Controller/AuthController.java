package com.example.Inventory_Management.Inventory.Management.Controller;

import com.example.Inventory_Management.Inventory.Management.Repository.UserRepository;
import com.example.Inventory_Management.Inventory.Management.entity.User;
import com.example.Inventory_Management.Inventory.Management.security.JwtService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private final AuthenticationManager authManager;
    private final JwtService jwtService;
    private final UserRepository repo;
    private final BCryptPasswordEncoder encoder;
    public AuthController(AuthenticationManager authManager, JwtService jwtService, UserRepository repo, BCryptPasswordEncoder encoder) {
        this.authManager = authManager;
        this.jwtService = jwtService;
        this.repo = repo;
        this.encoder = encoder;
    }
    @PostMapping("/signup")
    public void signup(@RequestBody User user) {
        user.setPassword(encoder.encode(user.getPassword()));
        repo.save(user);
    }

    @PostMapping("/login")
    public String login(@RequestBody User user) {
        authManager.authenticate(
                new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
        return jwtService.generateToken(user.getUsername());
    }
}
