package com.fundoo.gateway.security;

import java.nio.charset.StandardCharsets;
import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;


@Service
public class JwtService {

    @Value("${jwt.secret}")
    private String secret;


    private SecretKey getSigningKey() {

        return Keys.hmacShaKeyFor(
                secret.getBytes(StandardCharsets.UTF_8)
        );
    }


    private Claims extractAllClaims(String token) {

        return Jwts.parser()
                .verifyWith(getSigningKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }


    public String extractEmail(String token) {

        return extractAllClaims(token)
                .getSubject();
    }


    public Long extractUserId(String token) {

        return extractAllClaims(token)
                .get("userId", Long.class);
    }


    public Integer extractTokenVersion(String token) {

        return extractAllClaims(token)
                .get("tokenVersion", Integer.class);
    }


    public boolean isTokenExpired(String token) {

        try {

            Date expiration = extractAllClaims(token)
                    .getExpiration();

            return expiration.before(new Date());

        } catch (Exception e) {

            return true;
        }
    }


    public boolean isTokenValid(String token) {

        try {

            return !isTokenExpired(token);

        } catch (Exception e) {

            return false;
        }
    }
}