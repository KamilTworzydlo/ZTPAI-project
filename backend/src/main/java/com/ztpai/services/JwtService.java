package com.ztpai.services;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class JwtService {

    // MINIMUM 32 znaki (256 bitów) dla HS256
    private final String SECRET = "ztpai-secret-key-123456-very-long-key-32";

    public String generateToken(String username) {
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(
                        new Date(System.currentTimeMillis() + 1000 * 60 * 60)
                )
                .signWith(Keys.hmacShaKeyFor(SECRET.getBytes()))
                .compact();
    }

    // <<< TA METODA MUSI BYĆ W ŚRODKU KLASY >>>
    public String extractUsername(String token) {
        return Jwts.parserBuilder()
            .setSigningKey(Keys.hmacShaKeyFor(SECRET.getBytes()))
            .build()
            .parseClaimsJws(token)
            .getBody()
            .getSubject();
    }
}
