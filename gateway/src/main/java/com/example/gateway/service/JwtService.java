package com.example.gateway.service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Base64;

@Service
public class JwtService {
    public boolean validateToken(String token) {
        byte[] decodedKey = Base64.getDecoder().decode("ccz2iYjTyJGLfkcFY6F4fzCpjzaVpAzodlrswuplsmU=");
        Key key = Keys.hmacShaKeyFor(decodedKey);
        try {
            Jwts.parserBuilder()
                    .setSigningKey(key)
                    .build()
                    .parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
