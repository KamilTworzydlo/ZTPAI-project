package com.ztpai.controller;

import com.ztpai.services.JwtService;
import com.ztpai.model.AuthRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.*;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    public AuthController(AuthenticationManager authenticationManager,
                          JwtService jwtService) {
        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthRequest request) {
        try {
            authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                    request.getUsername(),
                    request.getPassword()
                )
            );

            String token = jwtService.generateToken(request.getUsername());

            // Zwracamy JSON zamiast gołego stringa
            return ResponseEntity.ok(
                Map.of(
                    "token", token,
                    "username", request.getUsername()
                )
            );

        } catch (BadCredentialsException e) {
            return ResponseEntity.status(401).body(
                Map.of("error", "Nieprawidłowy login lub hasło")
            );
        }
    }
}
