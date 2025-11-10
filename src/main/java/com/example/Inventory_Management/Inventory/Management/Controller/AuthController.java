package com.example.Inventory_Management.Inventory.Management.Controller;

import com.example.Inventory_Management.Inventory.Management.DTO.ApiResponse;
import com.example.Inventory_Management.Inventory.Management.Repository.UserRepository;
import com.example.Inventory_Management.Inventory.Management.entity.User;
import com.example.Inventory_Management.Inventory.Management.security.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    private final AuthenticationManager authManager;
    @Autowired
    private final JwtService jwtService;
    @Autowired
    private final UserRepository repo;
    @Autowired
    private final BCryptPasswordEncoder encoder;
    public AuthController(AuthenticationManager authManager, JwtService jwtService, UserRepository repo, BCryptPasswordEncoder encoder) {
        this.authManager = authManager;
        this.jwtService = jwtService;
        this.repo = repo;
        this.encoder = encoder;
    }
    @PostMapping("/signup")
    public ResponseEntity<?> signup(@RequestBody User user) {
        user.setPassword(encoder.encode(user.getPassword()));
        repo.save(user);
        return new ResponseEntity<>( new ApiResponse("200","User Added Sucessfully"), HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User request) {

        Authentication auth = authManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(),
                        request.getPassword()
                )
        );

        var userDetails = (org.springframework.security.core.userdetails.User) auth.getPrincipal();
        String token = jwtService.generateToken(userDetails);

        return ResponseEntity.ok(token);
    }

}
